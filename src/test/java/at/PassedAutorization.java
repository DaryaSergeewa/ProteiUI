package at;

import com.codeborne.selenide.Condition;
import elements.methods.Autorization;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;

public class PassedAutorization {
    public void passedAutorization(String login, String passwd) {

        new Autorization().autorization(login, passwd);
        Assertions.assertEquals("Добро пожаловать!", $("h3.uk-card-title")
                        .shouldBe(Condition.visible).getText(),
                "Неуспешная авторизация");
    }
}
