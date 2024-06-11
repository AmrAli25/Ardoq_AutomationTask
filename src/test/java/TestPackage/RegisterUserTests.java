package TestPackage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisterPage;


@Epic("Test cases for Ardoq Case interview")
@Feature("User Management")
@Story("Register New User")

public class RegisterUserTests {

    // Variables
    private final String timeStamp = String.valueOf(System.currentTimeMillis());
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON registrationTestData;
    private SHAFT.TestData.JSON validationTestData;

    @BeforeClass(description = "Setup Test Data.")
    public void beforeClass() {
        registrationTestData = new SHAFT.TestData.JSON("RegisterUserData.json");
        validationTestData = new SHAFT.TestData.JSON("ValidationData.json");
    }

    @BeforeClass(description = "Setup Browser instance.")
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        new HomePage(driver).navigate();
    }

    @Description("Given I am navigating to Register page,\nThen user starts to create account and add his required data," +
            "\nThen submit it successfully")
    @Test(description = "Register New User Test - GUI")
    public void successfullyRegisterNewAccount() {
        new HomePage(driver).verifyNavigationToHomePage()
                .verifyVisibilityOfLoginOrRegisterButton()
                .clickLoginOrRegisterBtn();
        new LoginPage(driver)
                .verifyCorrectNavigationToLoginPage(validationTestData.getTestData("login"))
                .verifyContinueBtn()
                .clickOnContinueButton();
        new RegisterPage(driver)
                .verifyCreateAccountTextVisibility(validationTestData.getTestData("createAccount"))
                .enterUserPersonalInfo(registrationTestData.getTestData("personalData.firstName"),
                        registrationTestData.getTestData("personalData.lastName"),
                        registrationTestData.getTestData("personalData.email") + timeStamp + "@test.com",
                        registrationTestData.getTestData("personalData.phone"))
                .enterUserAddress(registrationTestData.getTestData("address.company"),
                        registrationTestData.getTestData("address.address1"),
                        registrationTestData.getTestData("address.city"),
                        registrationTestData.getTestData("address.zip"),
                        registrationTestData.getTestData("address.region"),
                        registrationTestData.getTestData("address.country"))
                .enterUserLoginDetails(registrationTestData.getTestData("loginDetails.username") + timeStamp,
                        registrationTestData.getTestData("loginDetails.password"))
                .clickContinueBtn()
                .verifyAccountCreatedSuccessfully(validationTestData.getTestData("accountCreated"))
                .clickcontinueToAccountPageBtn();
    }

    @Description("Verify that the account was created successfully by ensuring that the 'My Account'\n" +
            "page is displayed after registration.")
    @Test(description = "Verify successful redirect to my account page after registration",
            dependsOnMethods = {"successfullyRegisterNewAccount"})
    public void verifySuccessfulUserRegistration() {
        new MyAccountPage(driver)
                .verifyCorrectNavigationToUserAccountPage(validationTestData.getTestData("myAccount"))
                .verifyUserFirstName(registrationTestData.getTestData("personalData.firstName"));
    }


    @AfterClass(description = "TearDown Browser instance.")
    public void afterMethod() {
        driver.quit();
    }
}
