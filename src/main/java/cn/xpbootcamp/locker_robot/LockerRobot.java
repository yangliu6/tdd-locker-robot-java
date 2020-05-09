package cn.xpbootcamp.locker_robot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LockerRobot {

    List<Box> boxes;
    public LockerRobot(int size) {
        boxes = new ArrayList<>(Collections.nCopies(size, new Box()));
    }

    public Ticket store(Bag bag) {
        boolean succeed = boxes.stream().anyMatch(box -> box.storeBag(bag));
        return succeed ? new Ticket("password") : null;
    }
}
