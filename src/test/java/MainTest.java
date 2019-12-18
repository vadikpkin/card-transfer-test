
import data.DataHelper;
import data.MoneyParser;
import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.LoginPage;
import page.TransferPage;
import page.VerifyPage;

import java.math.BigDecimal;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;


class MainTest {
    private static String ulr = "http://localhost:9999/";

    @Test
    void shouldTransferMoneyFirstCardForIntMoneyValue() {
        open(ulr);
        LoginPage loginPage = new LoginPage();
        VerifyPage verifyPage = loginPage.validLogin();
        DashboardPage dashboardPage = verifyPage.validVerify();
        BigDecimal payment = DataHelper.getRandomMoneyInt();
        BigDecimal expectedBalanceFirstCard = new BigDecimal(MoneyParser.parse(dashboardPage.getMoneyFirstCard()
                .getText())).add(payment);
        BigDecimal expectedBalanceSecondCard = new BigDecimal(MoneyParser.parse(dashboardPage.getMoneySecondCard()
                .getText())).subtract(payment);
        TransferPage transferPage = dashboardPage.depositMoneyFirstCard();
        dashboardPage = transferPage.transferMoneyToFirstCard(payment);
        BigDecimal actualBalanceFirstCard = new BigDecimal(MoneyParser.parse(dashboardPage.getMoneyFirstCard()
                .getText()));
        BigDecimal actualBalanceSecondCard = new BigDecimal(MoneyParser.parse(dashboardPage.getMoneySecondCard()
                .getText()));
        assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard);
        assertEquals(expectedBalanceSecondCard, actualBalanceSecondCard);
    }

    @Test
    void shouldTransferMoneySecondCardForIntMoneyValue() {
        open(ulr);
        LoginPage loginPage = new LoginPage();
        VerifyPage verifyPage = loginPage.validLogin();
        DashboardPage dashboardPage = verifyPage.validVerify();
        BigDecimal payment = DataHelper.getRandomMoneyInt();
        BigDecimal expectedBalanceFirstCard = new BigDecimal(MoneyParser.parse(dashboardPage.getMoneyFirstCard()
                .getText())).subtract(payment);
        BigDecimal expectedBalanceSecondCard = new BigDecimal(MoneyParser.parse(dashboardPage.getMoneySecondCard()
                .getText())).add(payment);
        TransferPage transferPage = dashboardPage.depositMoneySecondCard();
        dashboardPage = transferPage.transferMoneyToSecondCard(payment);
        BigDecimal actualBalanceFirstCard = new BigDecimal(MoneyParser.parse(dashboardPage.getMoneyFirstCard()
                .getText()));
        BigDecimal actualBalanceSecondCard = new BigDecimal(MoneyParser.parse(dashboardPage.getMoneySecondCard()
                .getText()));
        System.out.println(payment);
        assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard);
        assertEquals(expectedBalanceSecondCard, actualBalanceSecondCard);
    }

    @Test
    void shouldTransferMoneySecondCardForDoubleMoneyValue() {
        open(ulr);
        LoginPage loginPage = new LoginPage();
        VerifyPage verifyPage = loginPage.validLogin();
        DashboardPage dashboardPage = verifyPage.validVerify();
        BigDecimal payment = DataHelper.getRandomMoneyDouble();
        BigDecimal expectedBalanceFirstCard = new BigDecimal(MoneyParser.parse(dashboardPage.getMoneySecondCard()
                .getText())).subtract(payment);
        BigDecimal expectedBalanceSecondCard = new BigDecimal(MoneyParser.parse(dashboardPage.getMoneySecondCard()
                .getText())).add(payment);
        TransferPage transferPage = dashboardPage.depositMoneySecondCard();
        dashboardPage = transferPage.transferMoneyToSecondCard(payment);
        BigDecimal actualBalanceFirstCard = new BigDecimal(MoneyParser.parse(dashboardPage.getMoneyFirstCard()
                .getText()));
        BigDecimal actualBalanceSecondCard = new BigDecimal(MoneyParser.parse(dashboardPage.getMoneySecondCard()
                .getText()));
        assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard);
        assertEquals(expectedBalanceSecondCard, actualBalanceSecondCard);
    }

    @Test
    void shouldTransferMoneyFirstCardForDoubleMoneyValue() {
        open(ulr);
        LoginPage loginPage = new LoginPage();
        VerifyPage verifyPage = loginPage.validLogin();
        DashboardPage dashboardPage = verifyPage.validVerify();
        BigDecimal payment = DataHelper.getRandomMoneyDouble();
        BigDecimal expectedBalanceFirstCard = new BigDecimal(MoneyParser.parse(dashboardPage.getMoneySecondCard()
                .getText())).add(payment);
        BigDecimal expectedBalanceSecondCard = new BigDecimal(MoneyParser.parse(dashboardPage.getMoneySecondCard()
                .getText())).subtract(payment);
        TransferPage transferPage = dashboardPage.depositMoneyFirstCard();
        dashboardPage = transferPage.transferMoneyToFirstCard(payment);
        BigDecimal actualBalanceFirstCard = new BigDecimal(MoneyParser.parse(dashboardPage.getMoneyFirstCard()
                .getText()));
        BigDecimal actualBalanceSecondCard = new BigDecimal(MoneyParser.parse(dashboardPage.getMoneySecondCard()
                .getText()));
        assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard);
        assertEquals(expectedBalanceSecondCard, actualBalanceSecondCard);
    }

    @Test
    void shouldDeclineRequestForInvalidLogin() {
        open(ulr);
        LoginPage loginPage = new LoginPage();
        VerifyPage verifyPage = loginPage.invalidLogin();
    }

    @Test
    void shouldDeclineRequestForNullLogin() {
        open(ulr);
        LoginPage loginPage = new LoginPage();
        VerifyPage verifyPage = loginPage.invalidLoginNullInfo();
    }

    @Test
    void shouldDeclineRequestForInvalidAuthCode() {
        open(ulr);
        LoginPage loginPage = new LoginPage();
        VerifyPage verifyPage = loginPage.validLogin();
        DashboardPage dashboardPage = verifyPage.invalidVerify();
    }

    @Test
    void shouldDeclineRequestForNullAuthCode() {
        open(ulr);
        LoginPage loginPage = new LoginPage();
        VerifyPage verifyPage = loginPage.validLogin();
        DashboardPage dashboardPage = verifyPage.invalidVerifyNullCode();
    }

}
