package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class WeatherPage {
    SelenideElement searchPanel = $x("//div[@class = 'search-block']");
    SelenideElement searchField = searchPanel.$x(".//input");
    SelenideElement searchButton = searchPanel.$x(".//button");

    SelenideElement temperature = $x("//span[contains(@class,'heading')]");
    SelenideElement buttonMetric= $x("//label[@for = 'metric']");
    SelenideElement buttonImperial = $x("//label[@for = 'imperial']");
    SelenideElement cityTitle = $x("//div[@class='section-content']//h2");

    public void searchCity(String city) {
        searchField.clear();
        searchField.sendKeys(city);
        searchButton.click();
        searchPanel.$x(String.format(".//li[contains(.,'%s')][1]", city)).click();
    }

    public void clickOnC() {
        buttonMetric.click();
    }

    public int getCTemperature() {
        temperature.shouldHave(Condition.text("°C"));
        int temperatureC = Integer.parseInt(temperature.getText().replace("°C", ""));
        return temperatureC;
    }

    public void clickOnF() {
        buttonImperial.click();
    }

    public int getFTemperature() {
        temperature.shouldHave(Condition.text("°F"));
        int temperatureF = Integer.parseInt(temperature.getText().replace("°F", ""));
        return temperatureF;
    }

    public SelenideElement getCityTitle() {
        return cityTitle;
    }
}
