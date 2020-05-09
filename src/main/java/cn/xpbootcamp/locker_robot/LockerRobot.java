package cn.xpbootcamp.locker_robot;

import java.util.*;

public class LockerRobot {

    List<Box> boxes;
    Map<Integer, Integer> keyStore;

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
        Random rand = new Random();
        int key = rand.nextInt(1000000);
        keyStore.put(key, index);
        return new Ticket(String.format("%06d", key));
    }

    public Bag takeOut(Ticket ticket) {
        int key = Integer.parseInt(ticket.getPassword());
        Integer index = keyStore.get(key);
        return index != null ? boxes.get(index).takeOut() : null;
    }
}
