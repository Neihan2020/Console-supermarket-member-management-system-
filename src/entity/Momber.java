package entity;

/**
 * @auther LiuWeirui
 * @date 2022/2/28 19:53
 */
public class Momber {
    private String name;
    private int cardId;
    private String password;
    private int score;
    private String regisDate;

    public Momber() {
    }

    public Momber(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Momber(String name, int cardId, String password, int score) {
        this.name = name;
        this.cardId = cardId;
        this.password = password;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getRegisDate() {
        return regisDate;
    }

    public void setRegisDate(String regisDate) {
        this.regisDate = regisDate;
    }

    public Momber(String name, int cardId, String password, int score, String regisDate) {
        this.name = name;
        this.cardId = cardId;
        this.password = password;
        this.score = score;
        this.regisDate = regisDate;
    }

    @Override
    public String toString() {
        return name+"\t\t"+cardId+"\t\t"+score+"\t\t"+regisDate;
    }
}
