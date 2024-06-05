package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage {
    // Variables
    private final String url = System.getProperty("baseURL");
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    private final By promoSection = By.cssSelector("section[class=\"row promo_section\"]");
    private final By loginOrRegisterBtn = By.id("customer_menu_top");

    // Constructor
    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    @Step("Navigate to HomePage")
    public HomePage navigate() {
        driver.browser().navigateToURL(url);
        return this;
    }

    @Step("Click on the login or register button from the header")
    public HomePage clickLoginOrRegisterBtn() {
        driver.element().click(loginOrRegisterBtn);
        return this;
    }

    // Validations
    @Step("Verify Correct navigation to HomePage")
    public HomePage verifyNavigationToHomePage() {
        driver.verifyThat().element(promoSection).exists().perform();
        return this;
    }

    @Step("Verify visibility of Login or Register button")
    public HomePage verifyVisibilityOfLoginOrRegisterButton(){
        driver.verifyThat().element(loginOrRegisterBtn).isVisible().perform();
        return this;
    }
}
