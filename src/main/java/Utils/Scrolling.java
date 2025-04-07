package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scrolling {
    private Scrolling(){}

    public static void scrollDown(WebDriver driver, By Locator) {
        LogsUtils.Info( "Scrolling down to element: ", Locator.toString());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Locator));
    }

}
