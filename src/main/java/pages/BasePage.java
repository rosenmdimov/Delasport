package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Base Page of the project. All pages will inherit this page with all its parameters and methods.
 * All the methods that are common for more than one page should be placed here
 */
public class BasePage {
    protected WebDriver driver;
    protected final String BASE_URL = System.getProperty("baseUrl", "https://luckybandit.club.test-delasport.com/en/sports");



    /**
     * @param driver opens selected browser
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected List<WebElement> pageLoader(){
        return driver.findElements(By.id("page-loader"));
    }
    /**
     * This method types text[textToType] to the given [inputField]
     *
     * @param inputField input field to type a text
     * @param textToType text that should be typed
     */
    public void typeText(WebElement inputField, String textToType) {
        inputField.sendKeys(textToType);
    }

    public void waitPageLoaderStalled(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

       if(!pageLoader().isEmpty()){
           wait.until(ExpectedConditions.stalenessOf(pageLoader().get(0)));
       }
    }
    public void wait_10_sec_StalenessOfElement(WebElement element){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.stalenessOf(element));
    }
    public Set<Cookie> getCookies(){
        return driver.manage().getCookies();
    }
}
