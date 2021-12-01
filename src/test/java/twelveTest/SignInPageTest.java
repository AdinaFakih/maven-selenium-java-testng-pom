package twelveTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import twelveBase.TestBase;
import twelvePage.LandingPage;
import twelvePage.SignInPage;
import twelveUtil.TestUtil;


public class SignInPageTest extends TestBase{
	LandingPage landingPage;
	SignInPage signInPage;
	
	//String sheetName = "testData";
	
	
	//Constructor
	public SignInPageTest() {
		super(); //call parent class constructor
	}
	
	@BeforeMethod
	public void setUp() {
		run();
		landingPage = new LandingPage();
		landingPage.goToSignIn();
		signInPage = new SignInPage();
	}
	
	@DataProvider
	public Object[][] getSheetTestData() {
		Object data[][] = TestUtil.getTestData("ad");
		return data;
	}
	
	@Test(dataProvider = "getSheetTestData")
	public void signInTest(String email, String password){
		//Assert.assertEquals(false, signInPage.userSignIn(rb.getString("email"), rb.getString("password")));
		Assert.assertEquals(false, signInPage.userSignIn("email","password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}