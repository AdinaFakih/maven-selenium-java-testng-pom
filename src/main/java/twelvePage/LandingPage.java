package twelvePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import twelveBase.TestBase;

public class LandingPage extends TestBase {
	
	@FindBy(linkText="Home")
	WebElement home;
	
	@FindBy(linkText="Sign in")
	WebElement signInBtn;
	
	@FindBy(linkText="Sign up")
	WebElement signUpBtn;

	@FindBy(className ="navbar-brand")
	WebElement logo;
	
	//Constructor
	public LandingPage() {
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
	
	public int goToSignUp() {
		if(signUpBtn.isEnabled()) {
			signUpBtn.click();
			return 1; //pass
		}else
			return 0; //fail
	}

	public int goToSignIn() {
		if(signInBtn.isEnabled()) {
			signInBtn.click();
			return 1; //pass
		}else
			return 0; //fail
	}
}