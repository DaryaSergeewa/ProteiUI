package at;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import elements.CustomSelenideElements;
import elements.methods.AutorizationWindow;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddUser {
    public AddUser(String login, String passwd) {
        new AutorizationWindow().autorization(login, passwd);
        Assertions.assertEquals("Добро пожаловать!", $("h3.uk-card-title")
                        .shouldBe(Condition.visible).getText(),
                "Неуспешная авторизация");
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
    }

    public void addUser() {

        Selenide.$$(By.tagName("a")).find(Condition.text("Варианты"))
                .shouldBe(Condition.visible,Condition.enabled).click();
        Assertions.assertTrue(Selenide.$$(By.tagName("a")).find(Condition.text("Пользователи")).isDisplayed(),
                "Поле 'Пользователь' отсутствует на странице");
        Selenide.$$(By.tagName("a")).find(Condition.text("Пользователи"))
                .shouldBe(Condition.visible,Condition.enabled).doubleClick();
        Assertions.assertTrue(CustomSelenideElements.$buttonByText("Добавить пользователя").isDisplayed(),
                "Кнопка 'Добавить пользователя' отсутствует на странице");
        CustomSelenideElements.$buttonByText("Добавить пользователя")
                .shouldBe(Condition.visible,Condition.enabled).click();
        Assertions.assertAll(
                ()-> Assertions.assertTrue( $(".uk-legend")
                        .shouldHave(Condition.text("Добавление пользователя")).isDisplayed(),
                        "Страница добавления пользователя не открыта"),
                ()-> Assertions.assertTrue(CustomSelenideElements.$textField("Email").isDisplayed()),
                ()-> Assertions.assertTrue(CustomSelenideElements.$textField("Пароль").isDisplayed()),
                ()-> Assertions.assertTrue(CustomSelenideElements.$textField("Имя").isDisplayed())

//                Selenide.$(By.xpath("//*[contains(text(), 'Вариант 1.2')]")).click();
//        CustomSelenideElements.$buttonByText("Добавить")
//                .shouldBe(Condition.visible,Condition.enabled).click();
//
//        Selenide.$(By.xpath(".//label[@class='uk-form-label' and text()='Пол']//following-sibling::select")).click();

        );


    }
}
