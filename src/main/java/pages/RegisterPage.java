package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RegisterPage {

    // Variables
    private SHAFT.GUI.WebDriver driver;

    // Locators
    private By createAccountText = By.cssSelector("span[class=\"maintext\"]");
    private By firstName = By.id("AccountFrm_firstname");
    private By lastName = By.id("AccountFrm_lastname");
    private By email = By.id("AccountFrm_email");
    private By phone = By.id("AccountFrm_telephone");
    private By fax = By.id("AccountFrm_fax");
    private By company = By.id("AccountFrm_company");
    private By address = By.id("AccountFrm_address_1");
    private By city = By.id("AccountFrm_city");
    private By stateDropDown = By.id("AccountFrm_zone_id");
    private By zipCode = By.id("AccountFrm_postcode");
    private By countryDropDown = By.cssSelector("select[name=\"country_id\"]");
    private By username = By.id("AccountFrm_loginname");
    private By password = By.id("AccountFrm_password");
    private By confirmPassword = By.id("AccountFrm_confirm");
    private By subscribeYes = By.id("AccountFrm_newsletter1");
    private By privacyPolicy = By.id("AccountFrm_agree");
    private By continueBtn = By.cssSelector("button[title=\"Continue\"]");


    // Constructor
    public RegisterPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Actions

    // Validations
    @Step("Verify correct navgation to RegisterPage")
    public RegisterPage verifyCreateAccountTextVisibility() {
        driver.verifyThat().element(createAccountText).text()
                .isEqualTo("CREATE ACCOUNT");
        return this;
    }


}
