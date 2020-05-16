package cn.xpbootcamp.locker_robot;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    List<Locker> lockers;

    public Robot() {
        lockers = new ArrayList<>();
    }

    public void add(Locker locker) {
        lockers.add(locker);
    }

    public Ticket store(Bag bag) {
        return new Ticket();
    }
}
