package stepDef;

import api.BookingAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

public class D03_userRetrieveAllBookings {
    BookingAPI api = new BookingAPI();
    Response response;
    @Given("user sends a get request to get all id of booking")
    public void userGetsAllIDs() {
        response = api.get_all_bookings();
    }
    @Then("status code should be {int} success")
    public void statusCodeSuccess(Integer success) {
        Assert.assertEquals(response.getStatusCode(), success);
    }
}
