package cn.xpbootcamp.locker_robot;

import java.util.ArrayList;
import java.util.List;

public class LockerRobot {

    List<Bag> bags;
    public LockerRobot(int size) {
        bags = new ArrayList<>(size);
    }

    public Ticket store(Bag bag) {
        bags.add(bag);
        return new Ticket("password");
    }
}
