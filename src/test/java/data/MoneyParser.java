package data;

public class MoneyParser {

    public static String parse(String string) {
        return string.substring(string.indexOf(":") + 1, string.indexOf("р")).trim();
    }

}
