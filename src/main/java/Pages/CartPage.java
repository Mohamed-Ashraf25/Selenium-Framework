package Pages;

import Utils.ElementActions;
import Utils.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void CartPage_Navigation(){

        driver.get("CartUrl");

    }

     private static final By Checkout=By.id("checkout");


     @Step ("Click on the Checkout button")
    public CheckOutPage  ClickonCheckOutBtn(){
        ElementActions.clickElement(driver,Checkout);
        LogsUtils.Info( "Checkout button clicked");
    return  new CheckOutPage(driver);
    }



}
