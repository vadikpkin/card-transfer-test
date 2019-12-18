package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class DashboardPage {
    private SelenideElement refresh = $("[data-test-id='action-reload']");
    private SelenideElement firstCardDepositMoneyBtn = $$("[data-test-id='action-deposit']").get(0);
    private SelenideElement secondCardDepositMoneyBtn = $$("[data-test-id='action-deposit']").get(1);
    private SelenideElement moneyFirstCard = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement moneySecondCard = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    public SelenideElement getMoneyFirstCard() {
        return moneyFirstCard;
    }

    public SelenideElement getMoneySecondCard() {
        return moneySecondCard;
    }

    public TransferPage depositMoneyFirstCard() {
        firstCardDepositMoneyBtn.click();
        return new TransferPage();
    }

    public TransferPage depositMoneySecondCard() {
        secondCardDepositMoneyBtn.click();
        return new TransferPage();
    }

}
