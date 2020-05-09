package cn.xpbootcamp.locker_robot;

import java.util.*;

public class LockerRobot {

    List<Box> boxes;
    Map<String, Integer> keyStore;

    public LockerRobot(int size) {
        boxes = new ArrayList<>(Collections.nCopies(size, new Box()));
        keyStore = new HashMap<>();
    }

    public Ticket store(Bag bag) {
        int index = -1;
        for (int i = 0; i < boxes.size(); i++) {
            if (boxes.get(i).storeBag(bag)) {
                index = i;
                break;
            }
        }
        return index != -1 ? generateTicket(index) : null;
    }

    private Ticket generateTicket(int index) {
        String key = UUID.randomUUID().toString();

        keyStore.put(key, index);
        return new Ticket(key);
    }

    public Bag takeOut(Ticket ticket) {
        if (ticket == null || ticket.getPassword() == null)
            return null;

        String key = ticket.getPassword();
        Integer index = keyStore.get(key);
        if (index != null) {
            keyStore.remove(key);
            return boxes.get(index).takeOut();
        }
        return null;
    }
}
