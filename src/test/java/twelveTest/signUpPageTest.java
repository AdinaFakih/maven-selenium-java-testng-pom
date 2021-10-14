package twelveTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import twelveBase.TestBase;
import twelvePage.homePage;
import twelvePage.signUpPage;

public class signUpPageTest extends TestBase{
	signUpPage signUpPage;
	homePage homePage;
	
	//constructor
	public signUpPageTest() {
		super(); //call parent class constructor
	}
	
	@BeforeMethod
	public void setUp() {
		run();
		signUpPage = new signUpPage();
	}
	
	@Test
	public void signUpPageTitleTest() {
		String title = signUpPage.validPageTitle();
		Assert.assertEquals(title, "Conduit");
	}
	
	@Test
	public void LogoTest(){
		boolean flag = signUpPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void signUpTest_Valid(){
		// valid username, valid email
		Assert.assertEquals(0, signUpPage.userSignUp(rb.getString("username"), rb.getString("email"), rb.getString("password")));
	}
	
	@Test
	public void signUpTest_Invalid_1(){
		// invalid user name, invalid email
		Assert.assertEquals(1, signUpPage.userSignUp("ad1230", "ad1230@xox.com", rb.getString("password")));
	}
	
	@Test
	public void signUpTest_Invalid_2(){
		// invalid user name, valid email
		Assert.assertEquals(1, signUpPage.userSignUp("ad1230", "xord123@app.io", rb.getString("password")));
	}
	@Test
	public void signUpTest_Invalid_3(){
		// valid user name, invalid email
		Assert.assertEquals(1, signUpPage.userSignUp("xorr420", "xord123@app.io", rb.getString("password")));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}