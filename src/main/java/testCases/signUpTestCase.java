package testCases;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.homeScreenPage;
import pageObjects.signUpPage;

public class signUpTestCase extends baseTest {
	String firstName, familyName, email, password, emailPassword, validateEmail, validationSuccessfully;
	homeScreenPage home;
	signUpPage signUp;

	@BeforeTest
	public void init() {
		firstName = jsonTestData.getData("signUp").get("firstName");
		familyName = jsonTestData.getData("signUp").get("familyName");
		email = jsonTestData.getData("signUp").get("email");
		emailPassword = jsonTestData.getData("signUp").get("emailPassword");
		password = jsonTestData.getData("signUp").get("password");
		validateEmail = jsonTestData.getData("signUp").get("validateEmail");
		validationSuccessfully = jsonTestData.getData("signUp").get("validationSuccessfully");
		home = new homeScreenPage(driver);
		signUp = new signUpPage(driver);
	}

	@Test(priority = 1)
	public void signUp() {
		home.pressSignIn();
		signUp.pressSignUp();
		signUp.enterFirstName(firstName);
		signUp.enterFamilyName(familyName);
		signUp.enterEmail(email);
		signUp.enterPassword(password);
		signUp.pressSubmit();
		home.waitForMyaccountToload();
		Assert.assertTrue(home.signUpSuccessfully()); // Assert that user signUp successfully
	}

	@Test(priority = 2 )
	public void validateEmail() throws InterruptedException {
		signUp.openGmail();
		signUp.signInGmail(email, emailPassword);
		signUp.waitforGmailToLoad();
		Assert.assertTrue(signUp.validateEmail(validateEmail)); // Assert that verification email received
	}

	@Test(priority = 3, enabled=false)
	public void validateEmailByGmail() throws InterruptedException {
		signUp.closeTab();
		signUp.openGmail();
		signUp.refresh();
		signUp.waitforGmailToLoad();
		signUp.acceptAlerts();
		Assert.assertTrue(signUp.validateEmail(validationSuccessfully)); // Assert that email received of verification
																			// successfully

	}

	@Test(priority = 3)
	public void validateAccountVerfied() {
		signUp.closeTab();
		home.openHome();
		home.refresh();
		home.waitForHomePagetoload();
		if(home.signInSuccessfully())
		assertEquals(home.accountVerified(), false); // Assert that message of verification disappear
	}

}
