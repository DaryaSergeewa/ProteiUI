package at;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import elements.methods.AutorizationWindow;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
public class AddUser {
    public AddUser(String login, String passwd){
        new AutorizationWindow().autorization(login, passwd);
        Assertions.assertEquals("Добро пожаловать!", $("h3.uk-card-title")
                        .shouldBe(Condition.visible).getText(),
                "Неуспешная авторизация");
    }
    public void addUser(){

        Selenide.$$(By.tagName("a")).find(Condition.text("Варианты")).click();

    }
}
