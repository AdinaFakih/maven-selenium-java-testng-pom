package twelvePage; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import twelveBase.TestBase;

public class SignInPage extends TestBase {
	
	//Page Factory - Object Repository
	@FindBy(xpath = "//input[@type='email']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtn;
	
	@FindBy(xpath ="//*[@id=\"main\"]/div/div/div/div/div/ul")
	//@FindBy(className ="error-messages")
	WebElement error_msg;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div[1]/div[1]/ul/li[1]/a]")
	WebElement your_feed;
	
	//Constructor
	public SignInPage() {
		//initialize current class elements/objects(this)
		PageFactory.initElements(driver, this);
	}

	public boolean userSignIn(String in_email, String in_pwd) {	
		email.sendKeys(in_email);
		password.sendKeys(in_pwd);
		signInBtn.click();
		
		if(error_msg.isDisplayed()) {
			System.out.println("Sign In was not successful");
			return false; //fail
		}else {
			System.out.println("Sign In was Successful");
			return true; //pas
		}
}
}