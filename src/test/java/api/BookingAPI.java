package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class BookingAPI {
    private final String baseURI = "http://restful-booker.herokuapp.com";
    private final String auth = "/auth";

    private final String bookingEndPoint = "/booking";


    public Response createBooking(String firstName, String lastName, String totalprice, String depositpaid, String checkin, String checkout,String needs) {
        RequestSpecification request = RestAssured.given().baseUri(baseURI).header("Content-Type", "application/json");
        HashMap<String, Object> body = new HashMap<>();
        body.put("firstname", firstName);
        body.put("lastname", lastName);
        body.put("totalprice", totalprice);
        body.put("depositpaid", Boolean.parseBoolean(depositpaid));
        HashMap<String, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", checkin);
        bookingdates.put("checkout", checkout);
        body.put("bookingdates", bookingdates);
        body.put("additionalneeds", needs);
        request.body(body);
        return request.post(bookingEndPoint);
    }
    public  Response get_Booking_by_Id(String ID){
        RequestSpecification request = RestAssured.given().baseUri(baseURI);
        return request.get(bookingEndPoint+"/"+ID);

    }
    public Response get_all_bookings(){
        RequestSpecification request = RestAssured.given().baseUri(baseURI);
        return request.get(bookingEndPoint);
    }

    public Response getAuthToken(String username, String password) {
        RequestSpecification request = RestAssured.given().baseUri(baseURI).header("Content-Type", "application/json");
        Map<String, String> body = new HashMap<>();
        body.put("username", username);
        body.put("password", password);
        request.body(body);
        return request.post(auth);
    }

    public String getAuthTokenString(String username ,String password){
        RequestSpecification request = RestAssured.given().baseUri(baseURI).header("Content-Type", "application/json");
        Map<String, String> body = new HashMap<>();
        body.put("username", username);
        body.put("password", password);
        request.body(body);
        Response response =  request.post(auth);
        return response.jsonPath().getString("token");

    }

    public Response updateBooking(String id, String firstname, String lastname, String totalprice, String deposit, String checkin, String checkout, String needs,String token){
        Map<String, Object> body = new HashMap<>();
        body.put("firstname", firstname);
        body.put("lastname", lastname);
        body.put("totalprice", totalprice);
        body.put("depositpaid", true);

        Map<String, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", checkin);
        bookingdates.put("checkout", checkout);

        body.put("bookingdates", bookingdates);
        body.put("additionalneeds", needs);
        RequestSpecification request = RestAssured.given().baseUri(baseURI).header("Content-Type", "application/json")
                .header("Accept", "application/json").header("Cookie", "token=" + token).body(body);
        Response response = request.put(bookingEndPoint +"/"+ id);
        return response;
    }

    public  Response deleteRequest(String id, String token) {
        RequestSpecification request = RestAssured.given().header("Cookie", "token=" + token);
        return request.delete(baseURI + bookingEndPoint + "/"+id);
    }
}
