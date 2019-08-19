package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basePage {

	protected WebDriver driver;

	public int time = 150;

	Actions action;

	String currentWindow;
	final WebDriverWait wait;

	basePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		action = new Actions(driver);
		wait = new WebDriverWait(driver, time);
	}

	public void click(WebElement element) { // Click on the web element
		element.click();
	}

	public void setText(WebElement element, String text) { // Set text to the web element
		element.clear();
		element.sendKeys(text);
	}

	public void clear(WebElement element) { // Set text to the web element
		element.clear();
	}

	public void waitForElementTobeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickByAction(WebElement element) {
		action.moveToElement(element).click().perform();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void getcurrentWindow() {
		currentWindow = driver.getWindowHandle();
	}

	public void switchToOriginalWindow() {
		driver.switchTo().window(currentWindow);
	}

	public void closeOthertTab() {
		String originalHandle = driver.getWindowHandle();

		// Do something to open new tabs

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}

		driver.switchTo().window(originalHandle);
	}

	public void acceptAlertsView() {
		if (wait.until(ExpectedConditions.alertIsPresent()) == null)
			System.out.println("alert was not present");
		else
			driver.switchTo().alert().accept();

	}

	public void selectValuefromDropDown(WebElement element, String text) { // Select value from the drop down by the
																			// text
		Select dropDown = new Select(element);
		dropDown.selectByVisibleText(text);
	}

	public boolean elementIsVisible(WebElement element) { // Check if element is visible or not
		try {
			if (element.isDisplayed())
				return true;
			else
				return false;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public String[] split(String value, String splitter) { // Split date into array of string
		String[] newValue;
		newValue = value.split(splitter);
		return newValue;
	}

	public void waitForVisibilityOf(WebElement element) { // Wait for WebElement to be visible
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void goBackToPreviousPage() {
		driver.navigate().back();
	}

	public void switchWindow(String windowName) {
		driver.switchTo().window(windowName);
	}

	public void openLink(String url) {
		driver.get(url);
	}

	public String getWindowName() {
		return driver.getWindowHandle();
	}

	public void selectFromRadioGroup(WebElement radio, String radioText) {
		List<WebElement> radioButton = radio.findElements(By.tagName("span"));
		for (int i = 0; i < radioButton.size(); i++) {
			if (radioButton.get(i).getText().contains(radioText)) {
				radioButton.get(i).click();
			}
		}
	}

	public boolean findElementAppear(By element) {
		if (driver.findElements(element).size() > 0)
			return true;
		else
			return false;
	}
}
