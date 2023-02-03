package stepDef;

import api.BookingAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

public class D06_DeleteClass {

    BookingAPI api = new BookingAPI();
    Response response;
    String ID = "";

    @Given("I create  booking with first name {string}, last name {string}, total price {string}, deposit paid {string}, check-in {string}, check-out {string}, {string} successfully")
    public void createBooking
            (String firstname, String lastname, String totalprice, String deposit, String checkin, String checkout, String needs) {
        ID = api.createBooking(firstname,lastname,totalprice,deposit,checkin,checkout,needs).jsonPath().get("bookingid").toString();

    }
    @And("user enters auth token and sends a delete request to created id")
    public void deletBookingByID() {
        String token = api.getAuthTokenString("admin", "password123");
        response = api.deleteRequest(ID,token);
        Assert.assertEquals(response.statusCode(), 201);
    }
    @Then("response to id inquiry should show not found")
    public void responseShouldShow() {
        Assert.assertEquals(api.get_Booking_by_Id(ID).asString().toLowerCase().trim(), "not found");
    }


}
