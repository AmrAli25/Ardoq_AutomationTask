This is a task for Ardoq to automate two test cases:
* TC1: Successfully register a new account at the Account Creation Link. This test should
simulate a user filling out the registration form and submitting it.
* TC2: Verify that the account was created successfully by ensuring that the 'My Account'
page is displayed after registration. This involves checking for specific elements or
messages that confirm the user is logged in.

# Project Details:
## Main Framework used:
* [SHAFT_Engine](https://github.com/ShaftHQ/SHAFT_ENGINE) <br><img height="100" title="SHAFT_Engine" src="https://github.com/ShaftHQ/SHAFT_ENGINE/blob/main/src/main/resources/images/shaft.png">
## Demo Website used:
* [Automation Test Store](https://automationteststore.com/) <br><img title="AutomationTestStore" src="https://automationteststore.com/resources/image/18/7a/8.png">
## Project Design:
* Page Object Model (POM) design pattern.
* Fluent design approach (method chaining) for better test case readability.
* Data Driven Testing (store data as JSON files).
* Used TestNG framework throughout the project with its great annotations
* Used Allure reports to provide a comprehensive report about the test cases and their status

## How to run the project 
* Using Maven installed on your machine you just need to clone the repo on your machine and run the command on an opend terminal in the project directory "mvn test"
* Using InteliJ IDE to run it through the Code Editor 
