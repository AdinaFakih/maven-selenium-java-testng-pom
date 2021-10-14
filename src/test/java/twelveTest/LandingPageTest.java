package twelveTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import twelveBase.TestBase;
import twelvePage.LandingPage;
import twelvePage.signUpPage;

public class LandingPageTest extends TestBase{
	LandingPage landingPage;
	signUpPage signUpPage;
	
	//constructor
	public LandingPageTest() {
		super(); //call parent class constructor
	}
	
	@BeforeTest
	public void setUp() {
		run();
		landingPage = new LandingPage();
	}
	
	@Test
	public void landingPageTitleTest() {
		String title = landingPage.validPageTitle();
		Assert.assertEquals(title, "Conduit");
	}
	
	@Test
	public void logoTest(){
		boolean flag = landingPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void goToSignUpTest(){
		Assert.assertEquals(1, landingPage.goToSignUp());
	}
	
	@Test
	public void goToSignInTest(){
		Assert.assertEquals(1, landingPage.goToSignIn());
	}
	
    @AfterTest
    public void afterMethod() {
        // close and quit the browser
     driver.quit();
    }
}