This is a task for Ardoq to automate two test cases about :
* TC1: Successfully register a new account at Account Creation Link. This test should
simulate a user filling out the registration form and submitting it.
* TC2: Verify that the account was created successfully by ensuring that the 'My Account'
page is displayed after registration. This involves checking for specific elements or
messages that confirm the user is logged in. See image below for example of which
elements to verify that they are visible.

# Project Details:
## Main Framework used:
* [SHAFT_Engine](https://github.com/ShaftHQ/SHAFT_ENGINE) <br><img height="100" title="SHAFT_Engine" src="https://github.com/ShaftHQ/SHAFT_ENGINE/blob/main/src/main/resources/images/shaft.png">
## Demo Website used:
* [Automation Test Store](https://automationteststore.com/) <br><img title="AutomationTestStore" src="https://automationteststore.com/resources/image/18/7a/8.png">
## Project Design:
* Page Object Model (POM) design pattern.
* Fluent design approach (method chaining) for better test cases readability.
* Data Driven framework (store data on JSON files).
* Used TestNG framework through the project with it's great annotations
* Used Allure reports to provide a comprehensive report about the test cases and it's status
