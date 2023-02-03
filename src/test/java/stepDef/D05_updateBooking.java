package stepDef;

import api.BookingAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

public class D05_updateBooking {

    BookingAPI api = new BookingAPI();
    Response response;
    JsonPath jsonPathEvaluator;
    String ID;

    @Given("user sends a put request to id : {string} with firstname: {string}, last name {string}, total price {string}, deposit paid {string}, check-in {string}, check-out {string}, additional needs {string}")
    public void putRequestToUpdateBooking(String id, String firstname, String lastname, String totalprice, String deposit, String checkin, String checkout, String needs) {
        String token = api.getAuthTokenString("admin", "password123");
        response = api.updateBooking(id,firstname, lastname, totalprice,deposit,checkin,checkout,needs,token);
        ID = id;

    }
    @Then("Booking with the given id is updated to match fn {string} ln {string} {string} {string} {string} {string} {string}")
    public void infoShouldMatch(String firstname, String lastname, String totalprice, String deposit, String checkin, String checkout, String needs) {
        Response BookId = api.get_Booking_by_Id(ID);
        Assert.assertEquals(BookId.statusCode(),200);
        jsonPathEvaluator = BookId.jsonPath();
        Assert.assertEquals(jsonPathEvaluator.get("firstname").toString(),firstname);
        Assert.assertEquals(jsonPathEvaluator.get("lastname").toString(),lastname);
        Assert.assertEquals(jsonPathEvaluator.get("totalprice").toString(),totalprice);
        Assert.assertEquals(jsonPathEvaluator.get("depositpaid").toString().toLowerCase(),"true");
        Assert.assertEquals(jsonPathEvaluator.get("bookingdates.checkin").toString(),checkin);
        Assert.assertEquals(jsonPathEvaluator.get("bookingdates.checkout").toString(),checkout);
        Assert.assertEquals(jsonPathEvaluator.get("additionalneeds").toString(),needs);
    }
}
