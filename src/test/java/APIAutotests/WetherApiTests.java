package APIAutotests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WetherApiTests {
    String appKey = "856004bd440505acad9bc9e77c710960";
    String city = "Yoshkar-Ola";

    @Test
    public void testWhether() {
        String temperature = when().
                get("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + appKey + "&units=metric").
                then().
                assertThat().
                statusCode(200).
                and().
                body("name", equalTo("Yoshkar-Ola"))
                .extract().response().jsonPath().get("main.temp").toString();
        assertThat(Integer.parseInt(temperature)).isBetween(-40, 40);
    }
}
