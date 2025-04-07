package Driver;

import Utils.PropertiesUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

public class BrowserFactory {
    public static WebDriver getBrowser(String browsername) {
        switch (browsername.toLowerCase()){
            case "chrome":

                ChromeOptions Chomeoptions = new ChromeOptions();
                Chomeoptions.addArguments("--remote-allow-origins=*");
                Chomeoptions.addArguments("start-maximized");
                Chomeoptions.addArguments("disable-infobars");
                Chomeoptions.addArguments("--disable-extensions");
                Chomeoptions.addArguments("--disable-gpu");
                Chomeoptions.addArguments("--no-sandbox");
                Chomeoptions.addArguments("--disable-dev-shm-usage");
                // options.addArguments("--headless");
                Map< String, Object> prefs1 = Map.of(
                        "profile.default_content_setting_values.notifications", false,
                        "Credential_enable_service", false,
                        "profile.password_manager_enabled", false,
                        "autofill.profile_enabled", false);
                Chomeoptions.setExperimentalOption("prefs", prefs1);
                if ( !PropertiesUtils.getProperty("ExecutionType").equalsIgnoreCase("local")) {
                   Chomeoptions.addArguments("--headless");
                }
                Chomeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                return new ChromeDriver(Chomeoptions);

            case "firefox":
                FirefoxOptions Fireoptions = new FirefoxOptions();
                Fireoptions.addArguments("--remote-allow-origins=*");
                Fireoptions.addArguments("start-maximized");
                Fireoptions.addArguments("disable-infobars");
                Fireoptions.addArguments("--disable-extensions");
                Fireoptions.addArguments("--disable-gpu");
                Fireoptions.addArguments("--no-sandbox");
                Fireoptions.addArguments("--disable-dev-shm-usage");
                // options.addArguments("--headless");
                Map< String, Object> prefs2 = Map.of(
                        "profile.default_content_setting_values.notifications", false,
                        "Credential_enable_service", false,
                        "profile.password_manager_enabled", false,
                        "autofill.profile_enabled", false);

                if ( !PropertiesUtils.getProperty("ExecutionType").equalsIgnoreCase("local")) {
                    Fireoptions.addArguments("--headless");
                }
                Fireoptions.setAcceptInsecureCerts(true);
                Fireoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                return new FirefoxDriver(Fireoptions);

            case "edge":
                EdgeOptions edoptions = new EdgeOptions();
                edoptions.addArguments("--remote-allow-origins=*");
                edoptions.addArguments("start-maximized");
                edoptions.addArguments("disable-infobars");
                edoptions.addArguments("--disable-extensions");
                edoptions.addArguments("--disable-gpu");
                edoptions.addArguments("--no-sandbox");
                edoptions.addArguments("--disable-dev-shm-usage");
                // options.addArguments("--headless");
                Map< String, Object> prefs = Map.of(
                        "profile.default_content_setting_values.notifications", false,
                        "Credential_enable_service", false,
                        "profile.password_manager_enabled", false,
                        "autofill.profile_enabled", false);
                edoptions.setExperimentalOption("prefs", prefs);
                edoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                if ( !PropertiesUtils.getProperty("ExecutionType").equalsIgnoreCase("local")) {
                    edoptions.addArguments("--headless");
                }
                return new EdgeDriver(edoptions);

            default  :
                System.out.println("Please enter a valid browser name");
                return null;
        }

    }

}
