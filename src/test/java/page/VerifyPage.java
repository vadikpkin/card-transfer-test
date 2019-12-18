package page;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

public class VerifyPage {
    private SelenideElement codeField = $("[name='code']");
    private SelenideElement confirmBtn = $("[data-test-id='action-verify']");

    public DashboardPage validVerify() {
        codeField.setValue(DataHelper.getVerifyCode().getVerificationCode());
        confirmBtn.click();
        return new DashboardPage();
    }

    public DashboardPage invalidVerify() {
        codeField.setValue(DataHelper.getInvalidVerifyCode().getVerificationCode());
        confirmBtn.click();
        $("[data-test-id='error-notification']").waitUntil(Condition.visible,5000);
        return new DashboardPage();
    }

    public DashboardPage invalidVerifyNullCode() {
        codeField.setValue(null);
        confirmBtn.click();
        $(".input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
        return new DashboardPage();
    }
}
