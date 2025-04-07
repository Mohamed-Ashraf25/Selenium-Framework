package Driver;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class DriverManager {
    private DriverManager(){}

    private static final ThreadLocal<WebDriver> ThreadLocaldriver = new ThreadLocal<>();// ThreadLocal is used to create a separate instance of WebDriver for each thread

    public static WebDriver getDriver() {
        if ( ThreadLocaldriver.get() == null) {
            fail("Driver is not initialized");
        }
        return ThreadLocaldriver.get();
    }
    public static void setDriver(WebDriver driver) {
        ThreadLocaldriver.set(driver);
    }
    public static WebDriver Create_Instance( String browser) {
        WebDriver driver=BrowserFactory.getBrowser(browser);
         setDriver( driver);

        return getDriver();

    }}
