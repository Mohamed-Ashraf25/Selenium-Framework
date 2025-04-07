package Pages;

import Utils.ElementActions;
import Utils.LogsUtils;
import Utils.Waits;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutCompletePage {

    private final WebDriver driver;

    public CheckOutCompletePage (WebDriver driver) {
        this.driver = driver;
    }
    @Step ("Navigate to the checkout complete page")
    public void CheckOutComplete_Navigation(){
        driver.get("CheckOutCompleteUrl");
    }

    private static final By ThankYou= By.id("back-to-products");
@Step ("Verify the thank you message")
    public CheckOutCompletePage VerifyThanksMsg(){
    ElementActions.clickElement(driver, ThankYou);
        LogsUtils.Info( "Back to Product : User Journey is Done successully");

        return this;


    }
}
