package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class contactUsPage extends basePage {

	public contactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "[placeholder='Full name']")
	public WebElement fullNameInput;

	@FindBy(css = "[placeholder='example@email.com']")
	public WebElement emailInput;

	@FindBy(css = "[placeholder='Write your message here …']")
	public WebElement messageInput;

	@FindBy(css = "[placeholder='Select Category']")
	public WebElement categoryButton;

	@FindBy(css = "[class='el-scrollbar__view el-select-dropdown__list']")
	public WebElement categoryDropDown;

	@FindBy(xpath = "//*[contains(text(),'SEND')]")
	public WebElement submitTicketButton;

	@FindBy(xpath = "(//*[contains(text(),'Contact Us')])")
	public WebElement contactUs;

	@FindBy(xpath = "(//*[contains(text(),'Thank you for contacting us')])")
	public WebElement messageSuccessfully;

	public void enterFullName(String fullName) {
		setText(fullNameInput, fullName);
	}

	public void enterEmail(String email) {
		setText(emailInput, email);
	}

	public void enterMessage(String message) {
		setText(messageInput, message);
	}

	public void selectCategory(String category) {
		clickByAction(categoryButton);
		List<WebElement> categories = categoryDropDown.findElements(By.tagName("li"));
		for (int i = 0; i < categories.size(); i++) {
			if (categories.get(i).getText().toLowerCase().contains(category.toLowerCase())) {
				categories.get(0).click();
				break;
			}
		}
	}

	public void pressSend() {
		clickByAction(submitTicketButton);
	}

	public void waitForContactUsToLoad() throws InterruptedException {
		waitForVisibilityOf(contactUs);
		Thread.sleep(2000);

	}

	public boolean sendTicketSuccessfullySent() {
		if (elementIsVisible(messageSuccessfully))
			return true;
		else
			return false;
	}
}
