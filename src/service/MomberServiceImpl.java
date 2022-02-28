package service;

import data.MomberParm;
import entity.Momber;
import util.DateFormat;
import util.RandomNumber;

import java.util.Date;

/**
 * @auther LiuWeirui
 * @date 2022/2/28 19:59
 */
public class MomberServiceImpl implements MomberService {
    @Override
    public int addMomber(Momber m) {
        int id = RandomNumber.returnNum();
        if (MomberParm.momberArrayList.add(new Momber(m.getName(), id, m.getPassword(), 100, DateFormat.FormatDate(new Date())))) {
            return selectMomber(id);
        } else {
            return -1;
        }
    }

    @Override
    public int selectMomber(int id) {
        for (int i = 0; i < MomberParm.momberArrayList.size(); i++) {
            if (MomberParm.momberArrayList.get(i).getCardId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean update(String pwd, int id) {
        int index = selectMomber(id);
        MomberParm.momberArrayList.get(index).setPassword(pwd);
        if (MomberParm.momberArrayList.get(index).getPassword().equals(pwd)) {
            return true;
        } else {
            return false;
        }
/*        if (index != -1) {

        } else {
            return false;
        }*/
    }

    @Override
    public boolean selectMomberByPwd(String pwd, int id) {
        for (int i = 0; i < MomberParm.momberArrayList.size(); i++) {
            if (MomberParm.momberArrayList.get(i).getCardId() == id && MomberParm.momberArrayList.get(i).getPassword().equals(pwd)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String selectMomberData(String pwd, int id) {
        Momber m1 = MomberParm.momberArrayList.get(selectMomber(id));
        return "姓名\t\t会员卡号\t\t剩余积分\t\t开卡日期\n"+m1.toString();
    }

    @Override
    public boolean scoreChange(int id, int score) {
        try {
            MomberParm.momberArrayList.get(selectMomber(id)).setScore(MomberParm.momberArrayList.get(selectMomber(id)).getScore()-score);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean selectScore(int id, int score) {
        if(MomberParm.momberArrayList.get(selectMomber(id)).getScore()>=score){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean addScore(int id, int score) {
        try {
            MomberParm.momberArrayList.get(selectMomber(id)).setScore(MomberParm.momberArrayList.get(selectMomber(id)).getScore()+score);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
