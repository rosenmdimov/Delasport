package webdrivermanager;

import properties.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalWebDriver {

    public static WebDriver getLocalBrowserDriver() {
        String browserName = System.getProperty("browserName", String.valueOf(ConfigurationManager.getProperties("browserName")).toLowerCase());
        return switch (browserName) {
            case "chrome" -> {
                //System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME);
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--remote-allow-origins=*");

                yield new ChromeDriver(option);
            }
            case "firefox" -> {
                //System.setProperty("webdriver.gecko.driver", PATH_TO_FIREFOX);
                yield new FirefoxDriver();
            }
            case "headless" ->{
                //System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new", "--window-size=1920x1080", "--disable-extensions", "--remote-allow-origins=*");
                yield new ChromeDriver(options);
            }
            default -> throw new IllegalArgumentException(
                    String.format("Incorrect browser name was provided: '%s'", browserName));
        };

    }

}

