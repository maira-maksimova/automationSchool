
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import my.reqres.UserReponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class APITests {
    private static RequestSpecification spec;
    private static RequestSpecification spec2;
    @BeforeAll
    public static void init() {
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setProxy("gate.swissre.com", 9443)
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();

        spec2 = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setProxy("gate.swissre.com", 9443)
                .setBaseUri("https://reqres.in/api")
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    @Test
    public void someTest() {
        User[] users = given()
                .spec(spec)
                .when()
                .get("users")
                .then()
                .statusCode(200)
                .extract().as(User[].class);
        assertEquals(users[0].getId(), 1);
        assertEquals(users[1].getUsername(), "Bret");
    }

    @Test
    public void getPostTest() {
        Post[] users = given()
                .spec(spec)
                .when()
                .get("posts")
                .then()
                .statusCode(200)
                .extract().as(Post[].class);
        assertEquals(users[0].getId(), 1);
        assertEquals(users[1].getTitle(), "qui est esse");
    }

    @Test
    public void getToDosTest() {
        ToDo[] users = given()
                .spec(spec)
                .when()
                .get("todos")
                .then()
                .statusCode(200)
                .extract().as(ToDo[].class);
        assertEquals(users[0].getId(), 1);
        assertEquals(users[0].getTitle(), "delectus aut autem");
        assertEquals(users[0].isCompleted(), false);
    }

    @Test
    public void getToDos1Test() {
        ToDo toDo = given()
                .spec(spec)
                .when()
                .get("todos/1")
                .then()
                .statusCode(200)
                .extract().as(ToDo.class);
        assertEquals(toDo.getId(), 1);
        assertEquals(toDo.getTitle(), "delectus aut autem");
        assertEquals(toDo.isCompleted(), false);
        assertEquals(toDo.getUserId(), 1);
    }

    @Test
    public void getPost1Test() {
        Post post = given()
                .spec(spec)
                .when()
                .get("posts/1")
                .then()
                .statusCode(200)
                .extract().as(Post.class);
        assertEquals(1, post.getId());
        System.out.println(post.getMyString());
        assertEquals( "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", post.getTitle());
    }

    @Test
    public void postPostTest() {

        String payload = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        UserReponse response = given()
                .spec(spec2)
                .urlEncodingEnabled(true)
                .body(payload)
                .when()
                .post("users")
                .then().statusCode(201)
                .and()
                .extract().as(UserReponse.class);

        System.out.println(response.getCreatedAt());

    }

    @Test
    public void postLoginTest() {

        String payload = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";
        LoginResponse response = given()
                .spec(spec2)
                .urlEncodingEnabled(true)
                .body(payload)
                .when()
                .post("login")
                .then().statusCode(200)
                .and()
                .extract().as(LoginResponse.class);

        assertFalse(response.token.isEmpty(), "Expected token to be provided");

    }

    @Test
    public void getUserPage2Test() {


        UserPage userPage = given()
                .spec(spec2)
                .urlEncodingEnabled(true)
                .when()
                .get("users?page=2")
                .then().statusCode(200)
                .and()
                .extract().as(UserPage.class);

        assertEquals(userPage.data[0].getId(), 7);
        assertEquals(userPage.data[0].getEmail(), "michael.lawson@reqres.in");
        assertEquals(userPage.data[0].getFirst_name(), "Michael");

    }




}


