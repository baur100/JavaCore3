package ApiPetStore_1;

import io.restassured.response.Response;
import models_1.Category_1;
import models_1.GetPetResponse_1;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiMyDoggie {
    @Test
    public void getPet(){
      Response response = given()
              .baseUri("https://petstore.swagger.io/v2")
              .basePath("/pet/200")
              .when()
              .get()
              .then()
              .statusCode(200)
              .extract()
              .response();
      var jsonPath = response.jsonPath();
      System.out.println(jsonPath.prettify());

      var status = jsonPath.getString("status");
      System.out.println(status);

        Category_1 category_1 = jsonPath.getObject("category_1", Category_1.class);
        Assert.assertEquals(category_1.getId(),1);
        Assert.assertEquals(category_1.getName(),"category_1");

        GetPetResponse_1 pet = jsonPath.getObject("$", GetPetResponse_1.class);

        Assert.assertEquals(pet.getStatus(),"pending");
        Assert.assertEquals(pet.getName(),"Sherlok");

    }
    @Test
    public void getByStatus() {
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/findByStatus")
                .queryParam("status", "pending")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();
        var jsonPath = response.jsonPath();
        GetPetResponse_1[] arr = jsonPath.getObject("$", GetPetResponse_1[].class);
        List<GetPetResponse_1> list = Arrays.asList(jsonPath.getObject("$", GetPetResponse_1[].class));
//        System.out.println(list.size());
        System.out.println(list.get(0).getName());
    }
}
