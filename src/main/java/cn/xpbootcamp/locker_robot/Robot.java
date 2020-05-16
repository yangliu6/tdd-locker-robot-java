package cn.xpbootcamp.locker_robot;

import cn.xpbootcamp.locker_robot.exception.InvalidTicketException;
import cn.xpbootcamp.locker_robot.exception.NoAvailableLockerBoxException;
import cn.xpbootcamp.locker_robot.exception.NoAvailableLockerException;
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

    public Ticket store(Bag bag) throws NoAvailableLockerException, NoAvailableLockerBoxException {
        for (Locker locker : lockers) {
            if (locker.isAvailable()) {
                Ticket ticket = locker.store(bag);
                ticketLockerMap.put(ticket, locker);
                return ticket;
            }
        }
        throw new NoAvailableLockerException("No locker available");
    }

    public Locker getLockerWithTicket(Ticket ticket) {
        return ticketLockerMap.get(ticket);
    }

    public Bag getBagWithTicket(Ticket ticket) throws InvalidTicketException {
        Locker locker = ticketLockerMap.get(ticket);
        if (locker == null) {
            throw new InvalidTicketException("Invalid Ticket");
        } else {
            return locker.takeOut(ticket);
        }
    }
}
