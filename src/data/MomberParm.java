package data;

import entity.Momber;
import util.DateFormat;

import java.util.ArrayList;
import java.util.Date;

/**
 * @auther LiuWeirui
 * @date 2022/2/28 20:10
 */
public class MomberParm {
    public static ArrayList<Momber> momberArrayList = new ArrayList<Momber>();

    static {
        momberArrayList.add(new Momber("张三",8888,"123456",8888, DateFormat.FormatDate(new Date())));
    }
}
