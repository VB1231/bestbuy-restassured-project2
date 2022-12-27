package com.bestbuy.testsuit;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }
    //Extract the limit
    @Test
    public void test001(){
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }
    //Extract the total
        @Test
    public void test002(){
     int total = response.extract().path("total");
            System.out.println("The value of limit is : " + total);

    }
    //Extract the name of 5th store

    @Test
    public void test003(){
       String name = response.extract().path("data[4].name");
        System.out.println("The value of limit is : " + name);
    }
    //Extract the names of all the store
    @Test
    public void test004(){
        List<String> listName= response.extract().path("data.name");

            System.out.println("List of name"+listName);

    }
    //Extract the storeId of all the store
    @Test
    public void test005(){
        List<?>listOfId = response.extract().path("data.id");
        System.out.println("List of storeId"+listOfId);
    }
    //Print the size of the data list
    @Test
    public void test006(){
        List<?>listData = response.extract().path("data");
        System.out.println("size of data"+listData.size());
    }
    //Get all the value of the store where store name = St Cloud
    @Test
    public void test007(){
        List<String> storeValue = response.extract().path("data.findAll{it.name =='St Cloud'}");
        System.out.println("value of the store :"+ storeValue);
      }
      //Get the address of the store where store name = Rochester
    @Test
    public void test008(){
        List<?>valueOfStore=response.extract().path("data.findAll{it.name=='Rochester'}.address");
        System.out.println("address of data"+valueOfStore);
    }
    //Get all the services of 8th store
    @Test
    public void test009(){
        List<?>listOfServices = response.extract().path("data[7].services");
        System.out.println("List of services of 8th store"+listOfServices);
    }
    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test10(){
        List<HashMap<String,?>> storeServices = response.extract().path("data.findAll{it.services.findAll{it.name == 'Windows Store'}.storeservices}");
        System.out.println("value of store services of name windows store"+storeServices);
    }
  //Get all the storeId of all the store
    @Test
    public void test11(){
        List<?>listStoreId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("List of storeId"+listStoreId);
    }
    //Get id of all the store
    @Test
    public void test12(){
        List<?>listOfId = response.extract().path("data.id");
        System.out.println("List of storeId"+listOfId);
    }
    //Find the store names Where state = ND
    @Test
    public void test13(){
        List<?> storeNames = response.extract().path("data.findAll{it.state == 'MN'}.name");
        System.out.println("value of store services of name windows store"+storeNames);
    }
    //Find the Total number of services for the store where store name = Rochester
    @Test
    public void test14(){
        List<List<String>> services  = response.extract().path("data.findAll{it.name == 'Rochester'}.services");
        System.out.println(" total number of services :" + services.size());
        List<String> services9 = services.get(0);
        System.out.println("total number of services for the store Rochester :" + services9.size());
    }
    //Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test15(){
        List<?> listCreatedAt = response.extract().path("data.findAll{it.services.findAll{it.name == 'Windows Store'}.createdAt}");
        System.out.println("List of createdAt of windows store services"+listCreatedAt);
    }
    //Find the name of all services Where store name = “Fargo”
    @Test
    public void test16(){
        List<?>listAllNameOfFargo = response.extract().path("data.findAll{it.name =='Fargo'}.services.name");
        System.out.println("Enter all services name of fargo"+listAllNameOfFargo);
    }
    //Find the zip of all the store
    @Test
    public void test17(){
        List<?>listZip = response.extract().path("data.zip");
        System.out.println("Enter zip of all store"+listZip);
    }
    //Find the zip of store name = Roseville
    @Test
    public void test18(){
        List<?>listZipOfRoseville = response.extract().path("data.findAll{it.name=='Roseville'}.zip");
        System.out.println("Enter zip of roseville"+listZipOfRoseville);
    }
    //Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test19(){

      List<HashMap<String,?>> storeServices = response.extract().path("data.findAll{it.services.findAll{it.name == 'Magnolia Home Theater'}}.services.storeservices");
        System.out.println(""+storeServices);
    }
    //Find the lat of all the stores
    @Test
    public void test20(){
        List<?> lat =  response.extract().path("data.lat");
        System.out.println("the latitude of all stores : "+ lat);


    }

}
