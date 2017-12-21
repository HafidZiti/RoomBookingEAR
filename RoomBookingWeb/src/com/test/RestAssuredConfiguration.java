package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeSuite;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

class RestAssuredConfiguration {

	public RequestSpecification getRequestSpecification() {
		// TODO Auto-generated method stub
		return RestAssured.given().contentType(ContentType.JSON);
	}

}
