package opt24;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestApi {

    @Test(description = "Проверка, что товар добавляется в избранные")
    @Description("Response status = 200")
    @Story("addToChosen")
    public void addToChosen(){
        baseURI="https://www.opt24.org";
        JSONObject request = new JSONObject();
        request.put("post_id", "808");
        request.put("offer_id", "808");
        request.put("delete", "0");

        JSONObject headers = new JSONObject();
        headers.put("Content-type", "application/json");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Connection", "keep-alive");
        headers.put("authority", "www.opt24.org");
        headers.put("sec-ch-ua", "\"Chromium\";v=\"92\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"92\"");
        headers.put("accept", "application/json, text/javascript, */*; q=0.01");
        headers.put("x-requested-with", "XMLHttpRequest");
        headers.put("referer", "https://www.opt24.org/kleevye-pistolety/808-pistolet-kleevoy-elektricheskiy-8-mm-70-vt.html");

        given().
                body(request.toJSONString()).
                when().
                headers(headers).
                post("/ajax/shop/wishlist.json").
                then().
                statusCode(200).
                log().all();
    }

    @Test(description = "Проверка, что товар добавляется в сравнение")
    @Description("Response status = 200")
    @Story("addToCompare")
    public void addToCompare() {
        JSONObject request = new JSONObject();
        request.put("post_id", "808");
        request.put("offer_id", "808");

        JSONObject headers = new JSONObject();
        headers.put("Content-type", "application/json");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Connection", "keep-alive");
        headers.put("authority", "www.opt24.org");
        headers.put("sec-ch-ua", "\"Chromium\";v=\"92\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"92\"");
        headers.put("accept", "application/json, text/javascript, */*; q=0.01");
        headers.put("x-requested-with", "XMLHttpRequest");
        headers.put("referer", "https://www.opt24.org/kleevye-pistolety/808-pistolet-kleevoy-elektricheskiy-8-mm-70-vt.html");

        given().
                body(request.toJSONString()).
                when().
                headers(headers).
                post("/ajax/shop/cart/add.json").
                then().
                statusCode(200).
                log().all();
    }
}


