package Utils;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.Cookie;

import java.util.Set;


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
