package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementActions {

    private ElementActions(){}

    public static void clickElement(WebDriver driver, By Locator) {
        Waits.WaitElementtobeClickable( driver, Locator);
        Scrolling.scrollDown( driver, Locator);
        driver.findElement( Locator).click();
        LogsUtils.Info( "Clicked on element: ", Locator.toString());
    }
    public static void enterText(WebDriver driver, By Locator , String Data) {
        Waits.WaitElementtobeVisible( driver, Locator);
        Scrolling.scrollDown( driver, Locator);
        driver.findElement( Locator).sendKeys( Data);
        LogsUtils.Info( "Data Entered: ", Data + " in element: ", Locator.toString());
    }

}
