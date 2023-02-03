package stepDef;

import api.BookingAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

public class D01_createBookingAndVerify {
    BookingAPI api = new BookingAPI();
    String ID = "";
    Response response;
    JsonPath jsonPathEvaluator;
    Response BookId;

    @Given("I create a booking with first name {string}, last name {string}, total price {string}, deposit paid {string}, check-in {string}, check-out {string}, {string} successfully")
    public void CreateBookingInfo(String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout,String needs) {

        response = api.createBooking(firstname, lastname, totalprice, depositpaid, checkin, checkout,needs);
        Assert.assertEquals(response.getStatusCode(), 200);
        jsonPathEvaluator = response.jsonPath();
        ID = jsonPathEvaluator.get("bookingid").toString();

    }


    @Then("I should be able to retrieve the booking by ID")
    public void retrieveBookingID() {
    BookId = api.get_Booking_by_Id(ID);
        Assert.assertEquals(BookId.statusCode(),200);
    }

    @Then("the retrieved booking should have first name {string}, last name {string}, total price {string}, deposit paid {string}, check-in {string}, check-out {string},{string}")
    public void infoMatches(String firstName, String lastName, String totalprice, String deposit, String checkin, String checkout,String additionalNeeds) {
        jsonPathEvaluator = BookId.jsonPath();
        Assert.assertEquals(jsonPathEvaluator.get("firstname").toString(),firstName);
        Assert.assertEquals(jsonPathEvaluator.get("lastname").toString(),lastName);
        Assert.assertEquals(jsonPathEvaluator.get("totalprice").toString(),totalprice);
        Assert.assertEquals(jsonPathEvaluator.get("depositpaid").toString().toLowerCase(),"true");
        Assert.assertEquals(jsonPathEvaluator.get("bookingdates.checkin").toString(),checkin);
        Assert.assertEquals(jsonPathEvaluator.get("bookingdates.checkout").toString(),checkout);
        Assert.assertEquals(jsonPathEvaluator.get("additionalneeds").toString(),additionalNeeds);
    }

}
