package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage {
    // Variables
    private final SHAFT.GUI.WebDriver driver;

    // Locators
    private final By continueToRegisterBtn = By.cssSelector("button[title=\"Continue\"]");
    private final By accountLoginText = By.cssSelector("span[class=\"maintext\"]");

    // Constructor
    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    @Step("Click on continue button to navigate to Registration page")
    public LoginPage clickOnContinueButton() {
        driver.element().click(continueToRegisterBtn);
        return this;
    }

    // Validations
    @Step("Verify correct navigation to LoginPage")
    public LoginPage verifyCorrectNavigationToLoginPage(String message) {
        driver.verifyThat().element(accountLoginText).text()
                .isEqualTo(message).perform();
        return this;
    }

    @Step("Verify continue button is Visible on LoginPage")
    public LoginPage verifyContinueBtn() {
        driver.verifyThat().element(continueToRegisterBtn).exists().perform();
        return this;
    }
}
