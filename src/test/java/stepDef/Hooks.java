package stepDef;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import java.io.IOException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;



public class Hooks {


    @Before
    public void setUp() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

    }
    @After
    public void cleanup(){
        RestAssured.reset();
    }
}
