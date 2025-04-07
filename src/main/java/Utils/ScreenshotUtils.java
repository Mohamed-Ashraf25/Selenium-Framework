package Utils;

import Driver.DriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenshotUtils {
    private ScreenshotUtils(){super();}

    private static final String SCREENSHOT_PATH = "test-outputs/screenshots/";
    public static void Takescreenshot(String screenshotName) {
        try {
            File screenshot =((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File Screenshotfile= new File(SCREENSHOT_PATH + screenshotName + ".png");
            FileUtils.copyFile( screenshot, Screenshotfile);
            AllureUtils.AttachScreenshotstoAllureReport(screenshotName, Screenshotfile.getPath());
        } catch (Exception e) {

            LogsUtils.Error("Failed to take screenshot: " + e.getMessage());
        }

    }

}
