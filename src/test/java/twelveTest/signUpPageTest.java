package twelveTest;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import reportListeners.testAllureListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import twelveBase.TestBase;
import twelvePage.LandingPage;
import twelvePage.homePage;
import twelvePage.signUpPage;

@Listeners({testAllureListener.class})
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
		log.info("************Title of the page is --> " + title );
		//msg shows if fail
		Assert.assertEquals(title, "Condut", "SignUp page title did not match");
	}
	
	@Test(enabled=false)
	//to skip this test case (enabled=false) 
	public void LogoTest(){
		boolean flag = signUpPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
//	@Test(priority=1)
//	public void signUpTest_Valid(){
//		// valid username, valid email
//		Assert.assertEquals(0, signUpPage.userSignUp(rb.getString("username"), rb.getString("email"), rb.getString("password")));
//	}
	
	@Test(priority=1, description = "invalid user name, invalid email test case")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: invalid user name, invalid email test case")
	@Story("Story Name: checking signUp")
	public void signUpTest_Invalid_1(){
		// invalid user name, invalid email
		Assert.assertEquals(1, signUpPage.userSignUp("ad1230", "ad1230@xoxcom", rb.getString("password")));
	}
	
	@Test(priority=2)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: invalid user name, valid email test case")
	@Story("Story Name: checking signUp")
	public void signUpTest_Invalid_2(){
		// invalid user name, valid email
		Assert.assertEquals(1, signUpPage.userSignUp("ad1230", "xoxo456@api.io", rb.getString("password")));
	}
	
	@Test(priority=3)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: valid user name, invalid email test case")
	@Story("Story Name: checking signUp")
	public void signUpTest_Invalid_3(){
		// valid user name, invalid email
		Assert.assertEquals(1, signUpPage.userSignUp("rr123", "xord123@app.io", rb.getString("password")));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	//Allure supported annotations 
	//@Description("")
	//@Epic("EP001") //like id 
	//@Feature("Feature1: Logo")
	//@Story("Story: blah blah")
	//@Step("Verify blah blah")
	//@Severity(SeverityLevel.MINOR)
}