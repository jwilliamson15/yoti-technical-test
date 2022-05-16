package org.yoti.yotitechnicaltest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.yoti.yotitechnicaltest.models.Coordinate;
import org.yoti.yotitechnicaltest.models.HooverRequest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class YotiTechnicalTestApplicationTests {

    @LocalServerPort
    private int port;
    private static final String API_ROOT = "http://localhost:8080/hoover";

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void hoover() {
        List<Coordinate> patches = new ArrayList<>();
        patches.add(new Coordinate(0,1));
        HooverRequest request = new HooverRequest(
            new Coordinate(3,3),
            new Coordinate(0,0),
            patches,
            "NE"
        );

        Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .post(API_ROOT);

        JsonPath jsonPathEvaluator = response.jsonPath();
        ArrayList responsePosition = jsonPathEvaluator.get("coords");
        int responsePatches = jsonPathEvaluator.getInt("patches");

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(1, responsePosition.get(0));
        assertEquals(1, responsePosition.get(1));
        assertEquals(1, responsePatches);
    }

}
