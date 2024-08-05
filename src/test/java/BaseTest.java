import Utils.WebApp;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.time.LocalTime;


@ExtendWith(MyParameterResolver.class)
class BaseTest {
    protected WebApp webApp;
    @BeforeAll
    public void beforeEach(){
        webApp = new WebApp();
        webApp.openBrowser();
        webApp.loginPage().loginLuckyBandit();
    }


    @AfterEach
    public void tearDown(ExtensionContext extensionContext) {
        if (System.getProperty("take.screenshots.enabled").equalsIgnoreCase("true")) {
            Method testMethod = extensionContext.getRequiredTestMethod();
            boolean testFailed = extensionContext.getExecutionException().isPresent();
            if (testFailed) {
                webApp.takeScreenshot(testMethod.getDeclaringClass().getSimpleName(), testMethod.getName(), LocalTime.now());
            }
        }
    }
    @AfterAll
    public void afterAll(){
        webApp.quit();
    }

}

