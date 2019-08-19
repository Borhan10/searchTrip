package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.contactUsPage;
import pageObjects.homeScreenPage;
import pageObjects.signUpPage;

public class sendTicketContactUsTestCase extends baseTest{
	String fullName, message, email, category;
	homeScreenPage home;
	signUpPage signUp;
	contactUsPage contactUs;
	@BeforeTest
	public void init() {
		fullName = jsonTestData.getData("sendTicket").get("fullName");
		message = jsonTestData.getData("sendTicket").get("message");
		email = jsonTestData.getData("sendTicket").get("email");
		category = jsonTestData.getData("sendTicket").get("category");
		home = new homeScreenPage(driver);
		contactUs=new contactUsPage(driver);
		
	}
	
	@Test(priority=1)
	public void sendTicketContactUs() throws InterruptedException {
		home.waitForHomePagetoload();
		home.openContactUs();
		contactUs.waitForContactUsToLoad();
		contactUs.enterFullName(fullName);
		contactUs.enterEmail(email);
		contactUs.enterMessage(message);
		contactUs.selectCategory(category);
		contactUs.pressSend();
		contactUs.waitForContactUsToLoad();
		Assert.assertTrue(contactUs.sendTicketSuccessfullySent());    // Assert that ticket has been sent 
	}

}
