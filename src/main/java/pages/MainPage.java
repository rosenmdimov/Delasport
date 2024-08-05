package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v124.network.Network;
import org.openqa.selenium.devtools.v124.network.model.Request;
import org.openqa.selenium.devtools.v124.network.model.RequestId;
import org.openqa.selenium.devtools.v124.network.model.Response;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Bots internal page
 */
public class MainPage extends BasePage{
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public MainPage(WebDriver driver) {
        super(driver);
    }
    private WebElement memberBalance(){
        return driver.findElement(By.cssSelector("li.user-balance-item:first-of-type span.user-balance-item-amount"));
    }
    private List<WebElement> getAllModals(){

        return driver.findElements(By.cssSelector("#sportsbookModal .modal-content"));
    }

    private WebElement closeModalButton(){
        return driver.findElement(By.cssSelector(".modal-dialog-scrollable button.close"));
    }

    public void closeModalsIfAny(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"locale-en page-index layout-default asian-layout route-CasinoHome\"], #sportsbookModal .modal-content")));
        if(!getAllModals().isEmpty()){
            closeModalButton().click();
        }
    }
    public void verifyBalance(String memberBalance){
        waitPageLoaderStalled();
        String balance = memberBalance().getText().trim();

        Assertions.assertTrue( balance.contains("0.00"));
    }

}
