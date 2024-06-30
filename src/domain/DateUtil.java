package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년MM월dd일");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH시mm분");

    public static String getCurrentDate() {
        return dateFormat.format(new Date());
    }

    public static String getCurrentTime() {
        return timeFormat.format(new Date());
    }
}
