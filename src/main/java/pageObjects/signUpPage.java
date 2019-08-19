package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class signUpPage extends basePage {
	public signUpPage(WebDriver driver) {
		super(driver);
	}

	String oldCount, newCount, currentWindow;

	@FindBy(xpath = "//*[@class='F cf zt']")
	public WebElement allResult;

	@FindBy(css = "h2[class='hP']")
	public WebElement headerEmail;

	@FindBy(css = "tbody tr td div  table tbody tr td table a")
	public WebElement validate;

	@FindBy(id = "identifierId")
	public WebElement email;
	@FindBy(css = ".RveJvd.snByac")
	public WebElement next;

	@FindBy(css = "[type='password']")
	public WebElement pass;

	@FindBy(css = "a[href='/en/register']")
	public WebElement signUpLink;

	@FindBy(css = "[placeholder='First Name']")
	public WebElement firstNameInput;

	@FindBy(css = "[placeholder='Family Name']")
	public WebElement familyNameInput;

	@FindBy(css = "[type='email']")
	public WebElement emailInput;

	@FindBy(css = "[type='password']")
	public WebElement passwordInput;

	@FindBy(xpath = "//*[contains(text(),'CREATE ACCOUNT')]")
	public WebElement createAccountButton;

	public void openGmail() {
		openLink("https://www.gmail.com");

	}

	public void pressSignUp() {
		click(signUpLink);
	}

	public void signInGmail(String userName, String password) {
		setText(email, userName);
		click(next);
		waitForVisibilityOf(pass);
		setText(pass, password);
		click(next);
	}

	public void acceptAlerts() {

		acceptAlertsView();
	}

	public void closeTab() {
		closeOthertTab();
	}

	public void waitforGmailToLoad() throws InterruptedException {
		waitForVisibilityOf(allResult);
	}

	public void refreshPage() {
		refresh();
	}

	public boolean validateEmail(String valdiation) throws InterruptedException {
		boolean validation = false;
			List<WebElement> results = allResult.findElements(By.tagName("tr"));
			for (int computerIndex = 0; computerIndex < results.size(); computerIndex++) {
				WebElement single = results.get(computerIndex);
				Thread.sleep(3000);
				click(single);
				if (headerEmail.getText().toLowerCase().contains(valdiation.toLowerCase())) {
					waitForVisibilityOf(headerEmail);
					if (valdiation.toLowerCase().contains("verify your email"))
						click(validate);
					validation = true;
					break;
				} else {
					goBackToPreviousPage();
				}

			}
		return validation;
	}

	public void enterFirstName(String firstName) {
		setText(firstNameInput, firstName);
	}

	public void enterFamilyName(String familyName) {
		setText(familyNameInput, familyName);
	}

	public void enterEmail(String email) {
		setText(emailInput, email);
	}

	public void enterPassword(String password) {
		setText(passwordInput, password);
	}

	public void pressSubmit() {
		click(createAccountButton);
	}

}
