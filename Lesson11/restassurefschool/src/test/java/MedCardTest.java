import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MedCardTest {

    private static RequestSpecification spec;

    @BeforeAll
    public static void init() {
        try {
            InputStream inputStream = MedCardTest.class.getResourceAsStream("config.properties");
            Properties properties = new Properties();

            if (inputStream == null) {
                System.out.println("Properties file not found");
            }

            properties.load(inputStream);

            String baseUrl = properties.getProperty("baseUrl");;
            String proxy = properties.getProperty("proxy");

            spec = new RequestSpecBuilder()
                    .setContentType(ContentType.JSON)
                    .setProxy(proxy)
                    .setBaseUri(baseUrl)
                    .addFilter(new ResponseLoggingFilter())
                    .addFilter(new RequestLoggingFilter())
                    .build();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @ParameterizedTest
    @ValueSource(ints = {0})
    public void getBracelet(int index) throws IOException {

        int braceletIndex = index;

        String payload = new String(Files.readAllBytes(Paths.get("src/test/resources/JSON/bracelets.json")));

        List<Bracelet> bracelets = given()
                .spec(spec)
                .urlEncodingEnabled(true)
                .header(new Header("Content-type", "application/json"))
                .body(payload)
                .when()
                .post()
                .then().statusCode(200)
                .and()
                .extract()
                .body().jsonPath().getList("data.bracelets", Bracelet.class);


        String braceletGuid = bracelets.get(braceletIndex).getGuid();


        String payload2 = new String(Files.readAllBytes(Paths.get("src/test/resources/JSON/medCardFilteredByGuid.json")));
        MedCard medCard = given()
                .spec(spec)
                .urlEncodingEnabled(true)
                .header(new Header("Content-type", "application/json"))
                .body(payload2.replace("{{guid}}", braceletGuid))
                .when()
                .post()
                .then().statusCode(200)
                .and()
                .extract()
                .body().jsonPath().getObject("data.medicalCard", MedCard.class);


        assertTrue(medCard.isActive(), "Expected MedCard to be active, but was: " + medCard);
    }
}
