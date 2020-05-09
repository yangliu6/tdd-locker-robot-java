package cn.xpbootcamp.locker_robot;

public class Ticket {
    private Integer password;

    public Ticket(Integer password) {
        this.password = password;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
}
