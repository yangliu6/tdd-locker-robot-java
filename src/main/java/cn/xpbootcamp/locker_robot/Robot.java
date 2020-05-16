package cn.xpbootcamp.locker_robot;

import cn.xpbootcamp.locker_robot.exception.NoAvailableLockerBoxException;
import java.util.*;

public class Robot {
    List<Locker> lockers;

    Map<Ticket, Locker> ticketLockerMap;

    public Robot() {
        lockers = new ArrayList<>();
        ticketLockerMap = new HashMap<>();
    }

    public void add(Locker locker) {
        lockers.add(locker);
    }

    public Ticket store(Bag bag) throws NoAvailableLockerBoxException {
        for (Locker locker : lockers) {
            if (locker.isAvailable()) {
                Ticket ticket = locker.store(bag);
                ticketLockerMap.put(ticket, locker);
                return ticket;
            }
        }
        return new Ticket();
    }

    public Locker getLockerWithTicket(Ticket ticket) {
        return ticketLockerMap.get(ticket);
    }
}
