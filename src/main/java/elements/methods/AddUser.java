package elements.methods;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.CustomSelenideElements;
import elements.interfaces.TextField;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddUser {
    public Boolean checking_open() {
        return $(".uk-legend").shouldHave(Condition.text("Добавление пользователя")).isDisplayed();
    }

    public TextField inputText(String name) {
        return CustomSelenideElements.$textField(name);
    }

    public SelenideElement checkBox(String name) {
        return Selenide.$(By.xpath("//*[contains(text(), 'Вариант 1.2')]//preceding-sibling::input"));
    }

    public SelenideElement drop_downList(String name) {
        return Selenide.$(By.xpath(".//label[@class='uk-form-label' and text()='" + name + "']//following-sibling::select"));
    }
}
