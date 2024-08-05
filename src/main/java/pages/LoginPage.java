package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

/**
 * Project's Login page where the user can log in to the project
 */
public class LoginPage extends BasePage{

    private final String USER_NAME = String.valueOf(properties.ConfigurationManager.getProperties("userName"));
    private final String PASSWORD = String.valueOf(properties.ConfigurationManager.getProperties("password"));
    private final  String URL = BASE_URL;
    private Set<Cookie> cookies;


    public LoginPage(WebDriver driver) {super(driver);}

    private WebElement userName(){
        return driver.findElement(By.cssSelector("input[id=\"login_form[username]\"]"));
    }
    private WebElement loginModal(){
        return driver.findElement(By.id("login-guest-modal"));
    }

    private WebElement password(){
        return driver.findElement(By.cssSelector("input[id=\"login-modal-password-input\"]"));
    }

    private WebElement loginModalButton(){
        return driver.findElement(By.cssSelector("#header button.cl-login-button"));
    }
    private WebElement loginButton(){
        return driver.findElement(By.cssSelector(".modal-action-bar button"));
    }

    public void loginLuckyBandit(){
        driver.navigate().to(URL);
        loginModalButton().click();
        typeText(userName(), USER_NAME);
        typeText(password(), PASSWORD);
        loginButton().click();
        wait_10_sec_StalenessOfElement(loginModal());
        cookies = this.driver.manage().getCookies();
    }
}
