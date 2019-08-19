# searchTrip
by Mohamed Ahmed Borhan, 2019/08/19

This is selenium automation project on Fly365 website 
it make search round trip with dynamic data from the user 
it make validation on signUp done successfully
it make validation on the validation email process is done successfully (has some issues it working normally in debugging mode)
it make validation on account has been verified on the website 
it make validation on account has been verified on the Gmail (has some issues it working normally in debugging mode)
it make validation on sending ticket with dynamic data done successfully 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

1. download project

2. extract project

3. open eclispse or any ID

4. import mavn project

5. convert Java combiler to 1.8

6. Add valid test data from resources/data.json

7. Open TestNG.xml to run all test cases 

8. run as TESTNG

### Prerequisites

1. Eclipse 

2. Make sure to convert the project to TestNG project if its not converted

3. Open properties and make sure that JDK is higher than 1.5 (Open project properties=> Open Java compiler => Uncheck Use compliance 
from execution => Change to 1.8 => Apply and close)


## Running the tests

1.Open testng file and run the project as testng 

2.Add or remove any tests that need to run from the testng.xml file 

3.Make sure that test data are valid to run the tests (fly365=>resources=>data.json)

### Test Cases in the code 

1. Search round triptest cases .

2. Send ticket from contact us page test cases .

2.1 Send ticket with dynamic data from contact us page .

3. Sign up test cases .

3.1 Sign up from the web site with dynamic data .

3.2 Make verify account from gmail and validate it received 

3.3 Make verify that account verified successfully from Gmail

3.4 Make verify that account verified successfully from Website

## Built With

* [Selenium webdriver](https://www.seleniumhq.org/projects/webdriver/) Selenium-WebDriver makes direct calls to the browser using each browser’s native support for automation.

* [Maven](https://maven.apache.org/) - Dependency Management

* [TestNg](testng.org) - Used for Annotations and Run your test




