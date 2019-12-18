package data;

import lombok.Value;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class DataHelper {
    public DataHelper() {
    }

    @Value
    public static class LoginInfo {
        private String login;
        private String password;

    }

    public static LoginInfo getValidLoginInfo() {
        return new LoginInfo("vasya", "qwerty123");
    }

    public static LoginInfo getinValidLoginInfo() {
        return new LoginInfo("kolya", "password");
    }

    public static LoginInfo getEmptyLoginInfo() {
        return new LoginInfo(null, null);
    }

    @Value
    public static class VerificationCode {
        private String verificationCode;

    }

    public static VerificationCode getVerifyCode() {
        return new VerificationCode("12345");
    }

    public static VerificationCode getInvalidVerifyCode() {
        return new VerificationCode("99999");
    }

    public static BigDecimal getRandomMoneyInt() {
        Random rand = new Random();
        return new BigDecimal(1 + rand.nextInt(10000 - 1 + 1));
    }

    public static BigDecimal getRandomMoneyDouble() {
        Random rand = new Random();
        return BigDecimal.valueOf(1 + rand.nextDouble() * (10000 - 1)).setScale(2, RoundingMode.CEILING);
    }

    public static int getCurrentMoney(int amount) {
        return amount;
    }
}
