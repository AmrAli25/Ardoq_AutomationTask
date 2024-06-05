package TestPackage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;


@Epic("Test case 1 for Ardoq Case interview")
@Feature("User Management")
@Story("Register New User")

public class RegisterUserTests {

    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    @BeforeClass(description = "Setup Test Data.")
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("RegisterUserData.json");
    }

    @BeforeMethod(description = "Setup Browser instance.")
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        new HomePage(driver).navigate();
    }

    @Description("Given I am navigating to Register page,\nThen the browser title should be 'Create Account'.")
    @Test(description = "Check that Register Page Title is correct.")
    public void checkCorrectNavigationToRegisterPage() {
        new HomePage(driver).verifyNavigationToHomePage()
                .verifyVisibilityOfLoginOrRegisterButton()
                .clickLoginOrRegisterBtn();
        new LoginPage(driver)
                .verifyCorrectNavigationToLoginPage()
                .verifyContinueBtn()
                .clickOnContinueButton();
        new RegisterPage(driver)
                .verifyCreateAccountTextVisibility();

    }


    @AfterMethod(description = "TearDown Browser instance.")
    public void afterMethod() {
        driver.quit();
    }
}
