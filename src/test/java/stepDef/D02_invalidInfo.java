package stepDef;

import api.BookingAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

public class D02_invalidInfo {
    BookingAPI api = new BookingAPI();
    Response response;

    @Given("I create a booking with invalid info of {string}, last name {string}, total price {string}, deposit paid {string}, check-in {string}, check-out {string}, {string} successfully")
    public void createBookingWithInvalidInfo(String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String needs) {
        response = api.createBooking(firstname, lastname, totalprice, depositpaid, checkin, checkout,needs);
        System.out.println(response.asString());

    }
    @Then("status code should be {int} for all invalid entries")
    public void statusCodeShouldBeError(Integer errorCode) {
        Assert.assertEquals(response.getStatusCode(), errorCode);
    }
}
