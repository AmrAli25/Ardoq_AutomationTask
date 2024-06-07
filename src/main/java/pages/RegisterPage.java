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
    private By emailAddress = By.id("AccountFrm_email");
    private By phoneNum = By.id("AccountFrm_telephone");
    private By faxNum = By.id("AccountFrm_fax");
    private By company = By.id("AccountFrm_company");
    private By address = By.id("AccountFrm_address_1");
    private By city = By.id("AccountFrm_city");
    private By stateDropDown = By.id("AccountFrm_zone_id");
    private By zipCode = By.id("AccountFrm_postcode");
    private By countryDropDown = By.cssSelector("select[name=\"country_id\"]");
    private By username = By.id("AccountFrm_loginname");
    private By password = By.id("AccountFrm_password");
    private By confirmPassword = By.id("AccountFrm_confirm");
    private By subscribeYesRadioBtn = By.id("AccountFrm_newsletter1");
    private By privacyPolicyCheck = By.id("AccountFrm_agree");
    private By continueBtn = By.cssSelector("button[title=\"Continue\"]");
    private By accountCreatedText = By.cssSelector("span[class=\"maintext\"]");
    private By continueToAccountPageBtn = By.cssSelector("a[title=\"Continue\"]");


    // Constructor
    public RegisterPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    @Step("Enter User required personal information")
    public RegisterPage enterUserPersonalInfo(String fName, String lName, String email, String phone) {
        driver.element()
                .type(firstName, fName)
                .type(lastName, lName)
                .type(emailAddress, email)
                .type(phoneNum, phone);
        return this;
    }

    @Step("Enter User Address")
    public RegisterPage enterUserAddress(String company, String address1, String city, String zipCode,
                                         String region, String country) {
        driver.element()
                .type(this.company, company)
                .type(address, address1)
                .type(this.city, city)
                .type(this.zipCode, zipCode)
                .select(countryDropDown, country)
                .select(stateDropDown, region);
        return this;
    }

    @Step("Enter User Login details")
    public RegisterPage enterUserLoginDetails(String loginName, String password) {
        driver.element()
                .type(username, loginName)
                .type(this.password, password)
                .type(confirmPassword, password)
                .click(subscribeYesRadioBtn)
                .click(privacyPolicyCheck);
        return this;
    }

    @Step("Click on continue button to register new account")
    public RegisterPage clickContinueBtn() {
        driver.element()
                .click(continueBtn);
        return this;
    }

    @Step("Click on continue button to go to user account page")
    public RegisterPage clickcontinueToAccountPageBtn() {
        driver.element()
                .click(continueToAccountPageBtn);
        return this;
    }


    // Validations
    @Step("Verify correct navgation to RegisterPage")
    public RegisterPage verifyCreateAccountTextVisibility(String message) {
        driver.verifyThat().element(createAccountText).text()
                .isEqualTo(message);
        return this;
    }

    @Step("Verify That account is created successfuly")
    public RegisterPage verifyAccountCreatedSuccessfully(String message) {
        driver.verifyThat().element(accountCreatedText).text()
                .isEqualTo(message);
        return this;
    }


}
