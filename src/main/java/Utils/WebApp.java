package Utils;

import org.apache.commons.io.FileUtils;
import pages.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.LocalTime;

public class WebApp {
    WebDriver driver;
    LoginPage loginPage;
    MainPage myBotsPage;
    RestQueries restQueries;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebApp.class);

    public void openBrowser() {
            this.driver = webdrivermanager.LocalWebDriver.getLocalBrowserDriver();
            this.driver.manage().window().maximize();
    }

    public void quit() {
        this.driver.quit();
    }

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
    public MainPage myBotsPage() {
        if (myBotsPage == null) {
            myBotsPage = new MainPage(driver);
        }
        return myBotsPage;
    }

    public RestQueries restQueries() {
        if (restQueries == null) {
            restQueries = new RestQueries();
        }
        return restQueries;
    }
    public void takeScreenshot(String className, String method, LocalTime timestamp) {
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotTakingDriver = (TakesScreenshot) driver;
            try {
                File localScreenshots = new File(new File("target"), "screenshots");
                if (!localScreenshots.exists() || !localScreenshots.isDirectory()) {
                    localScreenshots.mkdirs();
                }
                File screenshot = new File(localScreenshots, className + "_" + method + "_" + timestamp.getHour() + "." + timestamp.getMinute() + "." + timestamp.getSecond() + ".png");
                FileUtils.copyFile(screenshotTakingDriver.getScreenshotAs(OutputType.FILE), screenshot);
                FileHandler.copy(screenshotTakingDriver.getScreenshotAs(OutputType.FILE), screenshot);
                LOGGER.info("Screenshot for class={} method={} saved in: {}", className, method, screenshot.getAbsolutePath());
            } catch (Exception e1) {
                LOGGER.error("Unable to take screenshot", e1);
            }
        } else {
            LOGGER.info("Driver '{}' can't take screenshots so skipping it.", driver.getClass());
        }
    }
}
