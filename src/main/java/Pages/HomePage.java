package Pages;

import Utils.ElementActions;
import Utils.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void HomePage_Naviagation() {
        driver.get("homeUrl");

    }

    private final By AddtoCart = By.id("add-to-cart-sauce-labs-backpack");
    private final By CartBtn = By.className("shopping_cart_badge");

    @Step( "Click on the Add to Cart button")
    public HomePage AddToCart() {
        ElementActions.clickElement(driver, AddtoCart);
        LogsUtils.Info("Add to cart button clicked");
        return this;

    }
    @Step("Click on the Cart button")
    public CartPage ClickCart() {
        ElementActions.clickElement(driver, CartBtn);
        LogsUtils.Info("Cart button clicked");
        return new CartPage(driver);
    }
}