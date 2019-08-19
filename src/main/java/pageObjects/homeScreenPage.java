package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homeScreenPage extends basePage {

	public homeScreenPage(WebDriver driver) {
		super(driver);
	}

	public By verifyEmailMessage = By.xpath("//*[contains(text(),'Your account is not verified, please')]");

	@FindBy(css = "[href='/en/contact-us']")
	public WebElement contactUs;

	@FindBy(id = "tab-oneWay")
	public WebElement oneWay;

	@FindBy(id = "tab-multiStop")
	public WebElement multiCity;

	@FindBy(id = "tab-roundTrip")
	public WebElement roundTrip;

	@FindBy(css = "[name='origin']")
	public WebElement originInput;

	@FindBy(css = "[name='destination']")
	public WebElement destinationInput;

	@FindBy(xpath = "(//*[@class='el-scrollbar__view el-autocomplete-suggestion__list'])[2]")
	public WebElement airportDropDown;

	@FindBy(css = "[name='d']")
	public WebElement fromDate;

	@FindBy(css = "[name='a']")
	public WebElement toDate;

	@FindBy(css = "[name='adult']")
	public WebElement numberAdult;

	@FindBy(css = "[name='child']")
	public WebElement numberChild;

	@FindBy(css = "[name='infant']")
	public WebElement numberInfant;

	@FindBy(css = ".el-radio-group")
	public WebElement typeTrip;

	@FindBy(css = "[class='btn uppercase btn-search-form font-bold lg:w-full w-2/5 m-auto btn-primary-second h-full']")
	public WebElement searchNow;

	@FindBy(css = "[class='bg-white text-sm h-50 px-3 rounded flex items-center text-primary-third font-medium el-popover__reference']")
	public WebElement tripTypeDetails;

	@FindBy(xpath = "//*[contains(text(),'Search Results')]")
	public WebElement searchResults;

	@FindBy(css = "a[href='/en/login']")
	public WebElement signInButton;

	@FindBy(xpath = "//*[contains(text(),'Hi')]")
	public WebElement signUpSuccessfully;

	@FindBy(xpath = "//*[contains(text(),'SIGN IN')]")
	public WebElement signIn;
	@FindBy(css = "[href='/en/account/bookings']")
	public WebElement myAccount;

	public void seletTripType(String trip) {
		if (trip.toLowerCase().contains("round trip")) {
			click(roundTrip);
		} else if (trip.toLowerCase().contains("multi city")) {
			click(multiCity);
		} else {
			click(oneWay);
		}

	}

	public void selectOrigin(String origin) {
		setText(originInput, origin);
		waitForElementTobeClickable(airportDropDown);
		selectAirPort(airportDropDown);
	}

	public void selectDestination(String destination) {
		setText(destinationInput, destination);
		waitForElementTobeClickable(airportDropDown);
		selectAirPort(airportDropDown);
	}

	public void selectFromDate(String fromDateText) {
		setText(fromDate, fromDateText);

	}

	public void selectToDate(String toDateText) {
		setText(toDate, toDateText);

	}

	public void prssSearch() {
		click(searchNow);
	}

	public void selectTripType(String numberAdults, String numberChilds, String infant, String seatClass) {
		click(roundTrip);
		click(tripTypeDetails);
		setText(numberAdult, numberAdults);
		setText(numberChild, numberChilds);
		setText(numberInfant, infant);
		List<WebElement> radiGroup = typeTrip.findElements(By.tagName("label"));
		for (int i = 0; i < radiGroup.size(); i++) {
			if (radiGroup.get(i).getText().toLowerCase().contains(seatClass.toLowerCase())) {
				radiGroup.get(i).click();
				break;
			}
		}
		click(roundTrip);
	}

	public boolean searchResults() {
		waitForVisibilityOf(searchResults);
		if (elementIsVisible(searchResults))
			return true;
		else
			return false;
	}

	public void selectAirPort(WebElement dropDown) {
		List<WebElement> airports = dropDown.findElements(By.tagName("li"));
		airports.get(0).click();
	}

	public void pressSignIn() {
		click(signInButton);
	}

	public boolean signUpSuccessfully() {

		if (elementIsVisible(signUpSuccessfully))
			return true;
		else
			return false;
	}

	public void waitForHomePagetoload() {
		waitForVisibilityOf(roundTrip);
	}

	public void waitForMyaccountToload() {
		waitForVisibilityOf(myAccount);
	}

	public void openContactUs() {
		click(contactUs);
	}

	public boolean accountVerified() {
		return findElementAppear(verifyEmailMessage);
	}

	public void openHome() {
		openLink("https://www.fly365.com/");
	}

	public boolean signInSuccessfully() {
		if (elementIsVisible(signIn))
			return true;
		else
			return false;
	}
}
