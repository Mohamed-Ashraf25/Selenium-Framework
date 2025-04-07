package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    private Waits(){ }

    public static WebElement WaitElementtobePresent(WebDriver driver, By Locator){
        LogsUtils.Info( "Element is present: " + Locator.toString());
        return new WebDriverWait( driver, Duration.ofSeconds(10))
                .until(driver1 -> driver1.findElement(Locator));

    }
    public static WebElement WaitElementtobeVisible(WebDriver driver, By Locator){

        return new WebDriverWait( driver, Duration.ofSeconds(10))
                .until(driver1 ->{ WebElement element =WaitElementtobePresent(driver, Locator) ;
                    LogsUtils.Info( "Element is visible: " + Locator.toString());

                    return element.isDisplayed() ? element : null;});
    }
    public static WebElement WaitElementtobeClickable(WebDriver driver, By Locator){
        return new WebDriverWait( driver, Duration.ofSeconds(10))
                .until(driver1 -> {WebElement element=WaitElementtobeVisible(driver, Locator);
                    LogsUtils.Info( "Element is clickable: " + Locator.toString());

                    return element.isEnabled() ? element : null;});
    }

}
