package com.functional;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import static  io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import com.FrameworkHelpers.ListThrusday;


public class restTest {
	
	@Test
	public void mytest() {
		ListThrusday lt = new ListThrusday();
		
	//Passing 5 for thrusday as 1-sun,2-mon,3-tue,4-wed,5-thru,6-fri & 7-sat
	String nextThrusday = lt.nextDayOfWeek(5);
	String day= (String) nextThrusday.subSequence(8,10); 
	Float temp=(float) 10;
	
	RestAssured.baseURI="https://api.openweathermap.org";
	List<Float> resp=given()
	.param("q", "Sydney,au")
	.param("units","metric")
	.param("appid", "9b2e8e2a9ef5103fd3d1e531b65e8092")
	.when()
	.get("/data/2.5/forecast")
	.then().extract().path("list.findAll{it.dt_txt==~/.*"+day+".*/}.main.temp");
	
	//Asserting for temperature > 10 
	assertTrue(resp.get(0)>temp);

	
	}

}
