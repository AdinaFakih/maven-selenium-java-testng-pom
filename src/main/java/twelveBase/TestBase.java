package twelveBase;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import twelveUtil.TestUtil;
import twelveUtil.WebEventListener;


public class TestBase {
	public static WebDriver driver;
	public static ResourceBundle rb;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	public static Logger log = LogManager.getLogger(TestBase.class);
	
	//constructor 
	public TestBase() {
		rb = ResourceBundle.getBundle("config");
	}
	
	//method
	public static void run() {
		String browserName = rb.getString("browser");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    log.info("launching chrome browser");
		    log.warn("logs for warn");
		    log.fatal("logs for fatal");

		}else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		    
		}else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		log.info("Entering application URL");
		driver.get(rb.getString("url_landingPage"));	 
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
}