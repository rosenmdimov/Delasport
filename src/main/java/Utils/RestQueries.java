package Utils;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.Cookie;

import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;


public class RestQueries {


    public String makePostRequest(Set<Cookie> sessionCookies){
        RestAssured.baseURI = "https://luckybandit.club.test-delasport.com/en/index/operation/getMemberBalance";


        RequestSpecification requestSpecification = RestAssured.given();
        JSONObject requestParams = new JSONObject();


        requestSpecification.body(requestParams.toJSONString());
        requestSpecification.cookie(addCookiesToRequestParameters(sessionCookies), "already_visit");
        requestSpecification.header("x-requested-with", "XMLHttpRequest");
        requestSpecification.header("Content-Encoding", "br");
        requestSpecification.auth().basic("tu_rossen", "Pass112#");
        Response response = requestSpecification
                .auth().basic("tu_rossen", "Pass112#")
                .post();
        return response.getBody().asString();
    }
    private String addCookiesToRequestParameters( Set<Cookie> cookies){
        String cookieString2 = "glc=en; gfv=already_visit; betobet-_zldp=1jrnmlY467D%2FuZBQb48MjY3r8U9mjEML%2BJLanxlF6EI3Xi9hZw1ON5LPLaQtaoyAFU8bH97eNSo%3D; mfl=1; cd=362d7fe3d8; imd=0; SESS=7hmp261sfmhi2o5ukddbkrp4upannf195vfv1miedd6vgghu6dl276m1cmghna3fvnetia; CSRF=3686c4dc0d81dc1ef498eee94f134af18a6a0a52200d4be3e42f4fc574387a1e; sv=european; betobet-_zldt=0d0bd5b5-ee00-4b97-b58b-4a50b104297b-0; afs";
        String cookiesString="" ;
        for (Cookie cookie : cookies) {
            cookiesString += cookie.getName()
                    + "="
                    + cookie.getValue()
                    + ";gfv";
        }
                return cookiesString;

    }
}
