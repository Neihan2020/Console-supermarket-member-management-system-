package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther LiuWeirui
 * @date 2022/2/28 20:16
 */
public class DateFormat {
    public static String FormatDate(Date date){
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss SS").format(new Date()).toString();
    }
}
