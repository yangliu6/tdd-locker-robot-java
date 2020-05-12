package cn.xpbootcamp.locker_robot;

import cn.xpbootcamp.locker_robot.exception.InvalidTicketException;
import cn.xpbootcamp.locker_robot.exception.NoAvailableLockerBoxException;

import java.util.*;

public class Locker {

    List<Box> boxes;
    Map<String, Integer> keyStore;

    public Locker(int size) {
        boxes = new ArrayList<>(Collections.nCopies(size, new Box()));
        keyStore = new HashMap<>();
    }

    public Ticket store(Bag bag) throws NoAvailableLockerBoxException {
        int index = -1;
        for (int i = 0; i < boxes.size(); i++) {
            if (boxes.get(i).storeBag(bag)) {
                index = i;
                break;
            }
        }
        if(index != -1){
            return generateTicket(index);
        }
        else {
            throw new NoAvailableLockerBoxException("Locker is full");
        }
    }

    private Ticket generateTicket(int index) {
        String key = UUID.randomUUID().toString();

        keyStore.put(key, index);
        return new Ticket(key);
    }

    public Bag takeOut(Ticket ticket) throws InvalidTicketException {
        if (ticket == null || ticket.getPassword() == null)
            throw new InvalidTicketException("Invalid Ticket");

        String key = ticket.getPassword();
        Integer index = keyStore.get(key);
        if (index != null) {
            keyStore.remove(key);
            return boxes.get(index).takeOut();
        } else {
            throw new InvalidTicketException("Invalid Ticket");
        }
    }
}
