package elements.window;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import elements.CustomSelenideElements;
import elements.interfaces.Button;

public class Information {
    public Boolean informationAddUser() {

        return Selenide.$("div.uk-modal-body").shouldHave(Condition.text("Данные добавлены.")).isDisplayed();
    }

    public Button $button(String name) {
        //SelenideElement window = Selenide.$(".uk-modal-dialog").shouldHave(Condition.text("Данные добавлены."));
        return CustomSelenideElements.$buttonByText(name); //todo: Сделать проверку с parent
    }
}
