package stepDef;

import api.BookingAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

public class D07_userUpdateOrDeleteWithoutToken {

    Response response;
    BookingAPI api = new BookingAPI();

    @Given("user sends a put request with invalid auth to id : {string} with firstname: {string}, last name {string}, total price {string}, deposit paid {string}, check-in {string}, check-out {string}, additional needs {string}")
    public void userUpdatesBookingWithInvalidToken
            (String id, String firstname, String lastname, String totalprice, String deposit, String checkin, String checkout, String needs) {
        response = api.updateBooking(id,firstname, lastname, totalprice,deposit,checkin,checkout,needs,"invalidToken");

    }

    @Then("response should fail")
    public void responseShouldFail() {
        Assert.assertEquals(response.statusCode(), 403);

    }


    @Given("user sends a delete request to id {int}")
    public void userTriesToDeleteWithInvalidAuthToken(Integer id) {
        response = api.deleteRequest(id.toString(),"invalidToken");

    }

}
