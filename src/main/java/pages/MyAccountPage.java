package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MyAccountPage {

    // Variables
    private final SHAFT.GUI.WebDriver driver;

    // Locators
    private final By myAccountText = By.cssSelector("span[class=\"maintext\"]");
    private final By UserFirstName = By.cssSelector("span[class=\"subtext\"]");

    // Constructor
    public MyAccountPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Validations
    @Step("Verify that User is redirected to his Account page")
    public MyAccountPage verifyCorrectNavigationToUserAccountPage(String message){
        driver.verifyThat()
                .element(myAccountText).text().isEqualTo(message).perform();
        return this;
    }

    @Step("Verify the User first name is displayed correctly")
    public MyAccountPage verifyUserFirstName(String text){
        driver.verifyThat()
                .element(UserFirstName).text().isEqualTo(text).perform();
        return this;
    }




}
