package utils;

import org.apache.commons.codec.binary.Base64;

public class ExcelUtils {

    public static String encodeTobase64(String text) {
        String encoded = Base64.encodeBase64String(text.getBytes());
        return encoded;
    }

    public static String decodeTobase64(String text) {
        String decoded = new String(Base64.decodeBase64(text));
        return decoded;
    }
}
