package Pages;

import Utils.ElementActions;
import Utils.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {

    private final WebDriver driver;

    public  CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
@Step ("Navigate to the checkout page")
    public void CheckOutpage_Navigation()
    {
        driver.get("CheckOutUrl");
    }
    private final By Firstname= By.id("first-name");
    private final By Lastname= By.id("last-name");
    private final By Postalcode= By.id("postal-code");
    private final By Continue= By.id("continue");

@Step ("Enter Firstname: {Firstname1}")
public CheckOutPage  EnterFirstName(String Firstname1){
        ElementActions.enterText(driver, Firstname, Firstname1);
        LogsUtils.Info( "Entering Firstname: " + Firstname1);
    return this;
}
@Step ("Enter Lastname: {Lastname1}")
public CheckOutPage  EnterLastName(String Lastname1){
        ElementActions.enterText(driver, Lastname, Lastname1);
        LogsUtils.Info( "Entering Lastname: " + Lastname1);
    return this;
}

@Step ("Enter Postalcode: {Postalcode1}")
public CheckOutPage  EnterPostalCode(String Postalcode1){
        ElementActions.enterText(driver, Postalcode, Postalcode1);
        LogsUtils.Info( "Entering Postalcode: " + Postalcode1);
    return this;
}
@Step ("Click on the Continue button")
public CheckOut2Page  ClickonContinueBtn(){
        ElementActions.clickElement(driver,Continue);
        LogsUtils.Info( "Continue button clicked");
    return new CheckOut2Page(driver);
}
}
