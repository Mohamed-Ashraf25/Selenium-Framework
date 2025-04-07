package Pages;

import Utils.ElementActions;
import Utils.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    private final  WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Navigate to the login page")
    public void PageNavigation() {
        driver.get("https://www.saucedemo.com/");
    }

    private static  final By username = By.id("user-name");
    private static final By password = By.id("password");
    private static final By loginButton = By.id("login-button");

    @Step("Enter username: {user}")
    public loginPage enterUsername(String user) {
        LogsUtils.Info( "Entering username: " + user);
        ElementActions.enterText(driver, username, user);
        return this;
    }
    @Step("Enter password: {pass}")
    public loginPage enterPassword(String pass) {
        LogsUtils.Info( "Entering password: " + pass);
        ElementActions.enterText( driver, password, pass);
        return this;
    }
    @Step("Click on the login button")
    public loginPage clickLoginButton() {
        LogsUtils.Info( "Clicking on the login button");
        ElementActions.clickElement( driver, loginButton);
        return this;
    }


}
