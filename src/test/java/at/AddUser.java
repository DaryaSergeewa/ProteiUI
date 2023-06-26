package at;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import elements.CustomSelenideElements;
import elements.methods.Autorization;
import elements.methods.MainMenu;
import elements.window.Information;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;

public class AddUser {
    public AddUser(String login, String passwd) {
        new Autorization().autorization(login, passwd);
        Assertions.assertEquals("Добро пожаловать!", $("h3.uk-card-title")
                        .shouldBe(Condition.visible).getText(),
                "Неуспешная авторизация");
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
    }

    public void addUser(String login, String passwd, String name) {

        MainMenu button = new MainMenu();
        elements.methods.AddUser pole = new elements.methods.AddUser();
        Information window = new Information();

        button.searchButton("Варианты").shouldBe(Condition.visible, Condition.enabled).click();
        Assertions.assertTrue(button.searchButton("Пользователи").isDisplayed(),
                "Поле 'Пользователь' отсутствует на странице");

        button.searchButton("Пользователи").shouldBe(Condition.visible, Condition.enabled).doubleClick();
        Assertions.assertTrue(CustomSelenideElements.$buttonByText("Добавить пользователя").isDisplayed(),
                "Кнопка 'Добавить пользователя' отсутствует на странице");

        CustomSelenideElements.$buttonByText("Добавить пользователя")
                .shouldBe(Condition.visible, Condition.enabled).click();
        Assertions.assertAll(
                () -> Assertions.assertTrue(pole.checking_open(),
                        "Страница добавления пользователя не открыта"),
                () -> Assertions.assertTrue(pole.inputText("Email").isDisplayed(),
                        "Проверка поля 'Email'"),
                () -> Assertions.assertTrue(pole.inputText("Пароль").isDisplayed(),
                        "Проверка поля 'Пароль'"),
                () -> Assertions.assertTrue(pole.inputText("Имя").isDisplayed(),
                        "Проверка поля 'Имя'"),
                () -> Assertions.assertTrue(pole.drop_downList("Пол").isDisplayed(),
                        "Проверка выпадающего списка 'Пол'"),
                () -> Assertions.assertTrue(pole.checkBox(" Вариант 1.1").isDisplayed(),
                        "Проверка чекбокса 'Вариант 1.1'"),
                () -> Assertions.assertTrue(pole.checkBox(" Вариант 1.2").isDisplayed(),
                        "Проверка чекбокса 'Вариант 1.2'"),
                () -> Assertions.assertTrue(pole.checkBox(" Вариант 2.1").isDisplayed(),
                        "Проверка чекбокса 'Вариант 2.1'"),
                () -> Assertions.assertTrue(pole.checkBox(" Вариант 2.2").isDisplayed(),
                        "Проверка чекбокса 'Вариант 2.2'"),
                () -> Assertions.assertTrue(pole.checkBox(" Вариант 2.3").isDisplayed(),
                        "Проверка чекбокса 'Вариант 2.3'")
        );

        pole.inputText("Email").setValue(login);
        Assertions.assertEquals(login, pole.inputText("Email").getValue(),
                "Проверка значения поля 'Email'");

        pole.inputText("Пароль").setValue(passwd);
        Assertions.assertEquals(passwd, pole.inputText("Пароль").getValue(),
                "Проверка значения поля 'Пароль'");

        pole.inputText("Имя").setValue(name);
        Assertions.assertEquals(name, pole.inputText("Имя").getValue(),
                "Проверка значения поля 'Имя'");

        pole.checkBox(" Вариант 1.2").click();
        Assertions.assertTrue(pole.checkBox(" Вариант 1.2").shouldHave(Condition.attribute("checked")).isDisplayed(),
                "Проверка установки чекбокса ' Вариант 1.2'");

        CustomSelenideElements.$buttonByText("Добавить")
                .shouldBe(Condition.visible, Condition.enabled).click();

        Assertions.assertTrue(window.informationAddUser(), "Проверка сообщения о добавлении пользователя");
        window.$button("Ok").shouldBe(Condition.visible, Condition.enabled).click();

        button.searchButton("Пользователи").shouldBe(Condition.visible, Condition.enabled).doubleClick();
        Assertions.assertTrue(CustomSelenideElements.$buttonByText("Добавить пользователя").isDisplayed(),
                "Кнопка 'Добавить пользователя' отсутствует на странице");

        Assertions.assertTrue(CustomSelenideElements.$table()
                        .shouldHave(Condition.text("newstudent@.protei.ru newstudent Мужской 1.2 2.1")).isDisplayed(),
                "Проверка нового пользователя в таблице");

        //todo: Неплохо бы сделать проверку с поиском нового добавленного пользователя в БД или в отображении страницы,
        // но сделать метод поиска строки в таблице по значениям столбцов
    }
}
