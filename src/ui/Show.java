package ui;

import data.MomberParm;
import entity.Momber;
import service.MomberService;
import service.MomberServiceImpl;
import util.PasswordFormat;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @auther LiuWeirui
 * @date 2022/2/28 19:44
 */
public class Show {
    Scanner scanner = new Scanner(System.in);
    MomberService ms = new MomberServiceImpl();

    public void zhuye() {
        while (true) {
            System.out.println("*************************欢迎进入超市会员管理系统************************");
            System.out.println("1.积分累计\t2.积分兑换\t3.查询剩余积分\t4.修改密码\t5.开卡\t6.退出");
            System.out.println("*********************************************************************");
            System.out.print("请选择操作:");
            int xz = scanner.nextInt();
            switch (xz) {
                case 1:
                    scoreAdd();
                    break;
                case 2:
                    scoreChange();
                    break;
                case 3:
                    select();
                    break;
                case 4:
                    updatePwd();
                    break;
                case 5:
                    kaika();
                    break;
                case 6:
                    System.out.println("感谢您的使用,欢迎下次再见!");
                    return;
                default:
                    System.out.println("您的操作有误,请重新输入:");
                    continue;
            }
            System.out.println("");
        }
    }

    public void scoreAdd(){
        Object [] strs =luru(2);
        if (!ms.selectMomberByPwd(strs[1].toString(), (Integer) strs[0])) {
            System.out.println("您输入的会员卡号或密码错误，无法累计积分!");
            return;
        }
        System.out.print("请输入您此次消费金额（消费1元累计1积分):");
        double re = scanner.nextDouble();
        if(ms.addScore((Integer) strs[0],(int)re)){
            System.out.println("积分累计成功!+"+(int)re);
        }
    }

    public void scoreChange(){
        Object [] strs =luru(2);
        if (!ms.selectMomberByPwd(strs[1].toString(), (Integer) strs[0])) {
            System.out.println("您输入的会员卡号或密码错误，无法兑换积分!");
            return;
        }
        System.out.print("请输入您需要兑换使用的积分(100积分抵用0.1元，不足100的积分不做抵用):");
        int score = scanner.nextInt();
        if(!ms.selectScore((Integer) strs[0],score)){
            System.out.println("您的账户上并没有那么多积分!无法兑换积分!");
            return;
        }
        if(score>=100){
            int re = score/100*100;
            if(ms.scoreChange((Integer) strs[0],re)){
            System.out.println("您的消费金额中使用会员积分抵消"+(double)re/1000+"元\n积分兑换成功!");
            }
        }else{
            System.out.println("您输入的积分不足100,无法兑换积分!");
        }
    }

    public void select(){
        Object [] strs =luru(2);
        if (!ms.selectMomberByPwd(strs[1].toString(), (Integer) strs[0])) {
            System.out.println("您输入的会员卡号或密码错误，无法查询积分!");
            return;
        }
        System.out.println(ms.selectMomberData(strs[1].toString(), (Integer) strs[0]));
    }

    public void updatePwd() {
        Object [] strs =luru(2);
        if (!ms.selectMomberByPwd(strs[1].toString(), (Integer) strs[0])) {
            System.out.println("您输入的会员卡号或密码错误，无法修改密码!\n密码修改失败!");
            return;
        }
        System.out.print("请输入新的密码:");
        String newPwd = scanner.next();
        newPwd = PasswordFormat.pwdFm(newPwd);
        if (ms.update(newPwd, (Integer) strs[0])) {
            System.out.println("密码修改成功!");
        } else {
            System.out.println("您输入的会员卡号或密码错误，无法修改密码!\n密码修改失败!");
        }

    }

    public void kaika() {
        Object []  strs= luru(1);
        strs[1] = PasswordFormat.pwdFm(strs[1].toString());
        int re = ms.addMomber(new Momber(strs[0].toString(), strs[1].toString()));
        if (re >= 0) {
            System.out.println("恭喜，开通会员卡成功，系统赠送您" + MomberParm.momberArrayList.get(re).getScore() + "积分!您的会员卡号为:" + MomberParm.momberArrayList.get(re).getCardId());
        } else {
            System.out.println("开通会员卡失败,未知错误!");
        }
    }

    public Object[] luru(int i){
        if(i==1){
            System.out.print("请输入用户名:");
            String name = scanner.next();
            System.out.print("请输入密码:");
            String pwd = scanner.next();
            return new Object[]{name,pwd};
        }else if(i==2){
            System.out.print("请输入您的会员卡号:");
            int id = scanner.nextInt();
            System.out.print("请输入您的密码:");
            String pwd = scanner.next();
            return new Object[]{id,pwd};
        }
        return null;
    }
}
