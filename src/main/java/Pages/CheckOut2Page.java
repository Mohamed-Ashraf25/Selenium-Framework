package Pages;

import Utils.ElementActions;
import Utils.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut2Page {

    private final WebDriver driver;

    public CheckOut2Page (WebDriver driver) {
        this.driver = driver;
    }

    @Step ("Navigate to the checkout page")
    public void CheckOut2_Navigation(){

        driver.get("CheckOut2Url");

    }
    private final static By Finish= By.id("finish");


    @Step ("Click on the Cancel button")
    public CheckOutCompletePage clickFinish() {
        ElementActions.clickElement(driver, Finish);
        LogsUtils.Info( "Finish button clicked");
    return  new CheckOutCompletePage(driver);
    }

}
