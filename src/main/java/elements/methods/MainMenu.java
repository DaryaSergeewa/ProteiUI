package elements.methods;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class MainMenu {

    public SelenideElement searchButton(String name) {
        return Selenide.$$(By.tagName("a")).find(Condition.text(name));
    }
}
