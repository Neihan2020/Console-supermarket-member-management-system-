package util;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @auther LiuWeirui
 * @date 2022/2/28 21:32
 */
public class PasswordFormat {
    static Scanner scanner = new Scanner(System.in);

    public static String pwdFm(String pwd){
        while (!Pattern.matches("^\\w{6,18}$",pwd)){
            System.out.print("会员密码不能小于6位大于18位，请重新输入注册密码:");
            pwd = scanner.next();
        }
        return pwd;
    }
}
