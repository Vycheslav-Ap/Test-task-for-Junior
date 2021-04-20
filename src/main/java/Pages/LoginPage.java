package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    SelenideElement loginField = $x("//*[@id=\"user_email\"]");
    SelenideElement passwordField = $x("//*[@id=\"user_password\"]");
    SelenideElement submitButton = $x("//*[@id=\"new_user\"]/input[3]");

    public void signIn(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
    }
}
