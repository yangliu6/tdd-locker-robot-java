package cn.xpbootcamp.locker_robot;

public class Ticket {
    private String password;

    public Ticket(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
