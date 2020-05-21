package cn.xpbootcamp.locker_robot;

import cn.xpbootcamp.locker_robot.exception.NoAvailableLockerBoxException;
import cn.xpbootcamp.locker_robot.exception.NoAvailableLockerException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartRobot {
    List<Locker> lockers;
    Map<Ticket, Locker> ticketLockerMap = new HashMap<>();

    public SmartRobot(ArrayList lockers) {
        this.lockers = lockers;
    }

    public Ticket store(Bag bag) throws NoAvailableLockerBoxException {
        for (Locker locker : lockers) {
            if (locker.isAvailable()) {
                Ticket ticket = locker.store(bag);
                ticketLockerMap.put(ticket, locker);
                return ticket;
            }
        }
        return null;
    }
}
