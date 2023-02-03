package stepDef;

import api.BookingAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

public class D04_userCanCreateAuthToken {
    BookingAPI api = new BookingAPI();
    Response response;

    @Given("user sends a post request to get auth with username : {string} and password: {string} token")
    public void authTokenRetrieval(String username, String pw) {
    response = api.getAuthToken(username,pw);
    }
    @Then("auth token should be returned")
    public void authTokenResponse() {
        Assert.assertNotNull(response.getBody().jsonPath().getString("token"));

    }
}
