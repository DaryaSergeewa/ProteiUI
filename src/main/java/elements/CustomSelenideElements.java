package elements;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.ElementFinder;
import com.codeborne.selenide.impl.WebElementSource;
import elements.interfaces.Button;
import elements.interfaces.Table;
import elements.interfaces.TextField;
import org.openqa.selenium.By;

public abstract class CustomSelenideElements {

    public static TextField $textField(String name) {
        return $textField(null, name, 0);
    }

    public static TextField $textField(SelenideElement parent, String name) {
        return $textField(parent, name, 0);
    }

    public static TextField $textField(SelenideElement parent, String name, int index) {
        return ElementFinder.wrap(WebDriverRunner.driver(),
                TextField.class,
                (WebElementSource) parent,
                By.xpath(".//label[@class='uk-form-label' and text()='" + name + "']/following-sibling::input"),
                index);
    }

    public static Button $buttonByText(String name) {
        return $buttonByText(null, name, 0);
    }

    public static Button $buttonByText(SelenideElement parent, String name) {
        return $buttonByText(parent, name, 0);
    }

    public static Button $buttonByText(SelenideElement parent, String name, int index) {
        return ElementFinder.wrap(WebDriverRunner.driver(),
                Button.class,
                (WebElementSource) parent,
                By.xpath(".//*[contains(@class,'uk-button uk-button-primary') and text()='" + name + "']"),
                index);
    }

    public static Table $table() {
        return $table(null, 0);
    }

    public static Table $table(SelenideElement parent, int index) {
        return ElementFinder.wrap(WebDriverRunner.driver(),
                Table.class,
                (WebElementSource) parent,
                By.xpath(".//table[@class='uk-table uk-table-striped']"),
                index);
    }
}
