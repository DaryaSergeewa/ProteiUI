package elements.methods;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.CustomSelenideElements;

public class AutorizationWindow {
    public void autorization(String login_name, String passwd_name) {

        SelenideElement login = CustomSelenideElements.$textField("E-Mail:");
        SelenideElement passwd = CustomSelenideElements.$textField("Пароль:");

        login.setValue(login_name);
        passwd.setValue(passwd_name);

        SelenideElement enter = CustomSelenideElements.$buttonByText("Вход");
        enter.shouldBe(Condition.visible, Condition.enabled).click();
    }
}
