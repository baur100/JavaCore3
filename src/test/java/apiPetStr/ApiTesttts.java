package apiPetStr;

import com.google.gson.Gson;
import helpers.TestDataApi;
import helpers.TestObjectCreattor;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import modelsz.DeleteResponse;
import modelsz.GetPetsResponse;
import modelsz.PostPetRequests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class ApiTesttts {
    private long petId;
    private PostPetRequests petRequests;

    @Test(enabled = false)
    public void getPet() {
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/987987987987")
        .when()
               .get()
        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        var jsonPath = response.jsonPath();
        System.out.println(jsonPath);
        GetPetsResponse pet = jsonPath.getObject("$", GetPetsResponse.class);
        Assert.assertEquals(pet.getStatus(), "available");
    }

    @Test (enabled = false)
    public void getByStatus() {
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/findByStatus")
                .queryParam("status", "available")
            .when()
                .get()
            .then()
                .statusCode(200)
                .extract()
                .response();
        var jsonPath = response.jsonPath();
        System.out.println(jsonPath);

        List<GetPetsResponse> list = Arrays.asList(jsonPath.getObject("$", GetPetsResponse[].class));
        System.out.println(list.get(0).getName());
    }

    @Test (priority = 1)
    public void createPet() {
        petRequests = TestObjectCreattor.createPostPetzsRequest();
        Gson gson = new Gson();
        String body = gson.toJson(petRequests);
        //System.out.println(body);

        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(petRequests)
            .when()
                .post()
            .then()
                .statusCode(200)
                .extract()
                .response();

        var jsonPath = response.jsonPath();

        GetPetsResponse pet = jsonPath.getObject("$", GetPetsResponse.class);

        petId = pet.getId();

        jsonPath.prettyPrint();

        Assert.assertEquals(pet.getStatus(), petRequests.getStatus());
        Assert.assertEquals(pet.getName(), petRequests.getName());
        Assert.assertEquals(pet.getCategory().getName(), petRequests.getCategory().getName());
        Assert.assertEquals(pet.getCategory().getId(), petRequests.getCategory().getId());
        System.out.println(petId);
        System.out.println(petRequests.getId());
        System.out.println(petRequests.getName());

    }

    @Test (priority = 2)
    public void udatePetzNama() {
        System.out.println(petRequests.getName());
        System.out.println(petRequests.getId());
        System.out.println(petId);

        String newName = TestDataApi.rendomPetz(12);
        petRequests.setName(newName);

        System.out.println(petRequests.getName());
        System.out.println(petId);


        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(petRequests)
                .when()
                .put()
                .then()
                .statusCode(200)
                .extract()
                .response();

        var jsonPath = response.jsonPath();

        GetPetsResponse pet = jsonPath.getObject("$", GetPetsResponse.class);

        petId = pet.getId();

        jsonPath.prettyPrint();

        Assert.assertEquals(pet.getStatus(), petRequests.getStatus());
        Assert.assertEquals(pet.getName(), petRequests.getName());
        Assert.assertEquals(pet.getCategory().getName(), petRequests.getCategory().getName());
        Assert.assertEquals(pet.getCategory().getId(), petRequests.getCategory().getId());
        System.out.println(petId);
    }

    @Test (priority = 3)
    public void deletePets() {
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/" +petId)
            .when()
                .delete()
            .then()
                .statusCode(200)
                .extract()
                .response();

        var jsonPath = response.jsonPath();

        DeleteResponse pet = jsonPath.getObject("$", DeleteResponse.class);
        Long deletedId = pet.getMessage();
        Long toDeleteId = petId;
        Assert.assertEquals(toDeleteId, deletedId);
        System.out.println(pet.getMessage());

        var headers = response.getHeaders();

        System.out.println(headers.toString());

        var header = response.header("Connection");
        System.out.println("This is one of the headers " + header);

        jsonPath.prettyPrint();

        var status = response.getStatusCode();
        var time = response.getTimeIn(TimeUnit.MILLISECONDS);
        var statusLine = response.getStatusLine();
        System.out.println(status);
        System.out.println(time);
        System.out.println(statusLine);
        ResponseBody body = response.getBody();
        body.prettyPrint();
    }
}
