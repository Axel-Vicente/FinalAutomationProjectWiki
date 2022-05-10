package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Utils {

    public static String generateFileName() {
        return generateFileName("");
    }

    public static String generateFileName(String prefixFileName) {

        prefixFileName = prefixFileName.trim();
        if (!prefixFileName.equals("")) {
            prefixFileName = prefixFileName + "_";
        }
        return prefixFileName + getStringCurrentTimeStamp() + ".jpg";
    }

    public static String getStringCurrentTimeStamp() {
        LocalDateTime now = LocalDateTime.now();
        String date = now.format(DateTimeFormatter.ofPattern("yyyyMMdd", new Locale("es", "ES")));
        String time = now.format(DateTimeFormatter.ofPattern("HHmmss", new Locale("es", "ES")));
        return date + "_" + time;
    }
}
