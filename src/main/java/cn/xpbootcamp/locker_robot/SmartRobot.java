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

    public Ticket store(Bag bag) throws NoAvailableLockerBoxException, NoAvailableLockerException {
        int maxCapacity = 0;
        Locker storedLocker = lockers.get(0);
        for (Locker locker : lockers) {
            int capacity = locker.boxes.size() - locker.keyStore.size();
            if (capacity > maxCapacity) {
                maxCapacity = capacity;
                storedLocker = locker;
            }
        }
        if(storedLocker.isAvailable()){
            Ticket ticket = storedLocker.store(bag);
            ticketLockerMap.put(ticket, storedLocker);
            return ticket;
        }
        throw new NoAvailableLockerException("No locker available");
    }
}
