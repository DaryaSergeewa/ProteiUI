package suite;

import at.AddUser;
import at.FailAutorization;
import at.PassedAutorization;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.codeborne.selenide.Selenide.$;

public class protei {

    @BeforeEach
    public void Setup() {
        WebDriverManager.chromedriver().setup();
        Selenide.open("http://185.67.95.60/");
        Assertions.assertDoesNotThrow(()->$(".uk-legend")
                        .shouldHave(Condition.text("Привет с демо-сайта для автотестов!")).shouldBe(Condition.visible),
                "Страница демо-сайта не открыта");
    }

    @Test
    @Order(1)
    @DisplayName("T1: Успешная авторизация")
    public void Passed_Autorization() {

        String login = "student@protei.ru",
                passwd = "student";

        new PassedAutorization().passedAutorization(login,passwd);
    }

    @Test
    @Order(2)
    @DisplayName("T2: Добавление пользователя")
    public void AddUser() {

        String login = "student@protei.ru",
                passwd = "student";

        new AddUser(login,passwd).addUser();
    }

    @ParameterizedTest(name = "T3.{index}. Неверные данные для авторизации")
    @MethodSource("at.FailAutorization#parameters")
    @Order(3)
    public void Fail_Autorization(String login, String passwd) {

        new FailAutorization().failAutorization(login, passwd);
    }

    @AfterEach
    public void deleteCookies() {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
    }
}
