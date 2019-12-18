package page;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

public class LoginPage {
    private SelenideElement loginField = $("[name='login']");
    private SelenideElement passField = $("[name='password']");
    private SelenideElement confirmBtn = $("[data-test-id='action-login']");

    public VerifyPage validLogin() {
        loginField.setValue(DataHelper.getValidLoginInfo().getLogin());
        passField.setValue(DataHelper.getValidLoginInfo().getPassword());
        confirmBtn.click();
        return new VerifyPage();
    }

    public VerifyPage invalidLogin() {
        loginField.setValue(DataHelper.getinValidLoginInfo().getLogin());
        passField.setValue(DataHelper.getinValidLoginInfo().getPassword());
        confirmBtn.click();
        $("[data-test-id='error-notification']").waitUntil(Condition.visible,5000);
        return new VerifyPage();
    }

    public VerifyPage invalidLoginNullInfo() {
        loginField.setValue(DataHelper.getEmptyLoginInfo().getLogin());
        passField.setValue(DataHelper.getEmptyLoginInfo().getPassword());
        confirmBtn.click();
        $$(".input__inner").get(0).shouldHave(Condition.text("Поле обязательно для заполнения"));
        $$(".input__inner").get(1).shouldHave(Condition.text("Поле обязательно для заполнения"));
        return new VerifyPage();
    }
}
