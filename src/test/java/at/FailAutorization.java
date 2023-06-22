package at;

import com.codeborne.selenide.Condition;
import elements.methods.AutorizationWindow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;

public class FailAutorization {

    public void failAutorization(String login, String passwd) {

        new AutorizationWindow().autorization(login, passwd);
        Assertions.assertEquals("Неверный E-Mail или пароль", $(".uk-legend").sibling(0)
                        .shouldBe(Condition.visible).getText(),
                "Успешная авторизация");
    }
    public static Stream<Arguments> parameters(){
        return Stream.of(
                Arguments.arguments("12345@protei.ru","12345"),
                Arguments.arguments("12345@protei.ru","student"),
                Arguments.arguments("student@protei.ru","12345")
        );
    }
}
