//Activity:2
//In this activity, you will create a test class that contains three test cases:
//
//One test case for sending a POST request on https://petstore.swagger.io/v2/user
//One test case for sending a GET request on https://petstore.swagger.io/v2/user/{username}
//One test case for sending a DELETE request on https://petstore.swagger.io/v2/user/{username}
//The test cases must execute in the order:
//POST request -> GET request -> DELETE request.

package Activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity2 {
    // Set base URL
    final static String ROOT_URI = "https://petstore.swagger.io/v2/user";

    @Test(priority=1)
    public void addNewUserFromFile() throws IOException {
        // Import JSON file
        FileInputStream inputJSON = new FileInputStream("src/Activities/Activity2_input.json");
        // Read JSON file as String
        String reqBody = new String(inputJSON.readAllBytes());

        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .body(reqBody) // Pass request body from file
            .when().post(ROOT_URI); // Send POST request

        inputJSON.close();

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("1177"));
    }
    
    @Test(priority=2)
    public void getUserInfo() {
        // Import JSON file to write to
        File outputJSON = new File("src/Activities/Activity2_output.json");

        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .pathParam("username", "nsinghai") // Pass request body from file
            .when().get(ROOT_URI + "/{username}"); // Send POST request
        
        // Get response body
        String resBody = response.getBody().asPrettyString();

        try {
            // Create JSON file
            outputJSON.createNewFile();
            // Write response body to external file
            FileWriter writer = new FileWriter(outputJSON.getPath());
            writer.write(resBody);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
        
        // Assertion
        response.then().body("id", equalTo(1177));
        response.then().body("username", equalTo("nsinghai"));
        response.then().body("firstName", equalTo("Nimesh"));
        response.then().body("lastName", equalTo("Singhai"));
        response.then().body("email", equalTo("nimesh@gmail.com"));
        response.then().body("password", equalTo("password"));
        response.then().body("phone", equalTo("07448152955"));
    }
    
    @Test(priority=3)
    public void deleteUser() throws IOException {
        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .pathParam("username", "nsinghai") // Add path parameter
            .when().delete(ROOT_URI + "/{username}"); // Send POST request

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("nsinghai"));
    }
}
