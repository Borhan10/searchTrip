package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.homeScreenPage;
import pageObjects.signUpPage;

public class searchRoundTripTestCase extends baseTest {
	String tripType, origin, destination, fromDate, toDate, adultsNumber, childsNumber, infantNumber, seatType;
	homeScreenPage home;
	signUpPage signUp;

	@BeforeTest
	public void init() {
		tripType = jsonTestData.getData("searchTrip").get("tripType");
		origin = jsonTestData.getData("searchTrip").get("origin");
		destination = jsonTestData.getData("searchTrip").get("destination");
		fromDate = jsonTestData.getData("searchTrip").get("fromDate");
		toDate = jsonTestData.getData("searchTrip").get("toDate");
		childsNumber = jsonTestData.getData("searchTrip").get("childsNumber");
		adultsNumber = jsonTestData.getData("searchTrip").get("adultsNumber");
		infantNumber = jsonTestData.getData("searchTrip").get("infantNumber");
		seatType = jsonTestData.getData("searchTrip").get("seatType");
		home = new homeScreenPage(driver);

	}

	@Test(priority = '1')
	public void searchForRoundTrip() {
		home.selectOrigin(origin);
		home.selectDestination(destination);
		home.selectFromDate(fromDate);
		home.selectToDate(toDate);
		home.selectTripType(adultsNumber, childsNumber, infantNumber, seatType);
		home.prssSearch();
		Assert.assertTrue(home.searchResults()); // Assert that search results has appear
	}
}
