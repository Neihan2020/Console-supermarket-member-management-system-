package service;

import entity.Momber;

/**
 * @auther LiuWeirui
 * @date 2022/2/28 19:59
 */
public interface MomberService {
    //添加会员
    int addMomber(Momber m);

    int selectMomber(int id);

    boolean update(String pwd,int id);

    boolean selectMomberByPwd(String pwd,int id);

    String selectMomberData(String pwd,int id);

    boolean scoreChange(int id,int score);

    boolean selectScore(int id,int score);

    boolean addScore(int id,int score);
}
