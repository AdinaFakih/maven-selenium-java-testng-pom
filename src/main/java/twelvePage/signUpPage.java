package twelvePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import twelveBase.TestBase;

public class signUpPage extends TestBase{
	
	//Page Factory - Object Repository
	@FindBy(xpath = "//input[@type='text']")
	WebElement username;
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	//@FindBy(xpath = "//button[contains(text(),'submit')]")
	WebElement signUpBtn;
	
	@FindBy(linkText="Sign in")
	WebElement signInBtn;
	
	@FindBy(linkText="Home")
	WebElement home;
	
	@FindBy(className ="navbar-brand")
	//@FindBy(xpath = "//img[contains(@class, '')]")
	WebElement logo;
	
	@FindBy(className ="error-messages")
	WebElement error;
	
	//Constructor
	public signUpPage() {
		//initialize current class elements/objects(this)
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public String validPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo(){
		return logo.isDisplayed();
	}
	
	public int userSignUp(String in_user, String in_email ,String in_pwd){
		username.sendKeys(in_user);
		email.sendKeys(in_email);
		password.sendKeys(in_pwd);
		signUpBtn.click();
		
		if(error.isDisplayed()) {
			System.out.println("Sign Up was not successful");
			return 1; //fail
		}else {
			return 0; //pass
		}
	}
}