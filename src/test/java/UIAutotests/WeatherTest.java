package UIAutotests;

import Pages.WeatherPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherTest {
    @DataProvider(name = "cities")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"London, GB"}, {"Yoshkar-Ola, RU"}, {"Moscow, RU"}};
    }

    @BeforeTest
    public void openPage() {
        Selenide.open("https://openweathermap.org/");
    }

    @Test(dataProvider = "cities")
    public void temperatureTest(String city) {
        WeatherPage weatherPage = new WeatherPage();
        weatherPage.searchCity(city);
        weatherPage.getCityTitle().shouldHave(Condition.text(city));
        weatherPage.clickOnC();
        int temperatureC = weatherPage.getCTemperature();

        weatherPage.clickOnF();
        int temperatureF = weatherPage.getFTemperature();
        int ctof = (int) Math.round(1.8 * temperatureC + 32);
        assertThat(ctof).isEqualTo(temperatureF);
    }
}
