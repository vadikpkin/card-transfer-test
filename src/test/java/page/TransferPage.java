package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.*;

public class TransferPage {
    private SelenideElement amount = $(".input__control");
    private SelenideElement cardFromWhereTransfer = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement transferConfirmBtn = $("[data-test-id='action-transfer']");
    private SelenideElement cancelBtn = $("[data-test-id='action-cancel']");
    private String firstCardNumber = "5559 0000 0000 0001";
    private String secondCardNumber = "5559 0000 0000 0002";

    public DashboardPage transferMoneyToFirstCard(Number amountOfMoney) {
        amount.setValue(String.valueOf(amountOfMoney));
        cardFromWhereTransfer.setValue(secondCardNumber);
        transferConfirmBtn.click();
        return new DashboardPage();
    }

    public DashboardPage transferMoneyToSecondCard(Number amountOfMoney) {
        amount.setValue(String.valueOf(amountOfMoney));
        cardFromWhereTransfer.setValue(firstCardNumber);
        transferConfirmBtn.click();
        return new DashboardPage();
    }

    public DashboardPage transferRndMoney(int amountOfMoney) {
        amount.setValue(String.valueOf(DataHelper.getRandomMoneyInt()));
        cardFromWhereTransfer.setValue(secondCardNumber);
        transferConfirmBtn.click();
        return new DashboardPage();
    }
}
