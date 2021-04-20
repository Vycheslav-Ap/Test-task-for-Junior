package UIAutotests;

import Pages.LoginPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {
    @Test
    public void Login() {
        Selenide.open("https://openweathermap.org/");
        SelenideElement button = $x("//*[@id='sign_in']/a");
        button.click();

        LoginPage loginPage = new LoginPage();
        loginPage.signIn("goker97@bk.ru", "6451899S");
        assertThat(WebDriverRunner.url()).isEqualTo("https://home.openweathermap.org/");
        SelenideElement userName = $x("//li[@class='user-sign-in']");
        userName.shouldHave(Condition.text("Taurchi"));
    }
}
