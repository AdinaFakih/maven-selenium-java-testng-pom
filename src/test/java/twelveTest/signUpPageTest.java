package twelveTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import twelveBase.TestBase;
import twelvePage.LandingPage;
import twelvePage.homePage;
import twelvePage.signUpPage;

public class signUpPageTest extends TestBase{
	LandingPage landingPage;
	signUpPage signUpPage;
	
	
	//constructor
	public signUpPageTest() {
		super(); //call parent class constructor
	}
	
	@BeforeMethod
	public void setUp() {
		run();
		landingPage = new LandingPage();
		landingPage.goToSignUp();
		signUpPage = new signUpPage();
	}
	
	@Test
	public void signUpPageTitleTest() {
		String title = signUpPage.validPageTitle();
		//msg shows if fail
		Assert.assertEquals(title, "Conduit", "SignUp page title did not match");
	}
	
	@Test
	public void LogoTest(){
		boolean flag = signUpPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
//	@Test(priority=1)
//	public void signUpTest_Valid(){
//		// valid username, valid email
//		Assert.assertEquals(0, signUpPage.userSignUp(rb.getString("username"), rb.getString("email"), rb.getString("password")));
//	}
	
	@Test
	public void signUpTest_Invalid_1(){
		// invalid user name, invalid email
		Assert.assertEquals(1, signUpPage.userSignUp("ad1230", "ad1230@xox.com", rb.getString("password")));
	}
	
	@Test
	public void signUpTest_Invalid_2(){
		// invalid user name, valid email
		Assert.assertEquals(1, signUpPage.userSignUp("ad1230", "xoxo456@api.io", rb.getString("password")));
	}
	
	@Test
	public void signUpTest_Invalid_3(){
		// valid user name, invalid email
		Assert.assertEquals(1, signUpPage.userSignUp("rr123", "xord123@app.io", rb.getString("password")));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}