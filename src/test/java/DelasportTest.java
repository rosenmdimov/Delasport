import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Cookie;

import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MyParameterResolver.class)

class DelasportTest extends BaseTest {
    @Test
    @DisplayName("Can verify the balance")
    public void LoginWithCredentials(){
        Set<Cookie> sessionCookies = webApp.loginPage().getCookies();
        String getMemberBalance = webApp.restQueries().makePostRequest(sessionCookies);
        webApp.mainPage().closeModalsIfAny();
        webApp.mainPage().verifyBalance(getMemberBalance);
    }
}
