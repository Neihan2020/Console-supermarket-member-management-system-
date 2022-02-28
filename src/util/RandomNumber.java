package util;

import data.MomberParm;

import java.util.Random;

/**
 * @auther LiuWeirui
 * @date 2022/2/28 20:35
 */
public class RandomNumber {
    public static int returnNum(){
        return determineNum();
    }

    public static int determineNum(){
        w1:while (true){
            Random ran = new Random();
            int re = ran.nextInt(99999999);
            if(re!=0){
                for (int i1 = 0; i1 < MomberParm.momberArrayList.size(); i1++) {
                    if(MomberParm.momberArrayList.get(i1).getCardId()==re){
                        continue w1;
                    }
                }
                return re;
            }
        }
    }
}
