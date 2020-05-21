package cn.xpbootcamp.locker_robot;

import cn.xpbootcamp.locker_robot.exception.NoAvailableLockerBoxException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SmartRobotTest {

    @Test
    void should_store_in_first_locker_and_return_ticket_when_store_bag_given_locker_capacity_are_5_and_4_respectively() throws NoAvailableLockerBoxException {
        ArrayList<Locker> lockers = new ArrayList<>();
        Locker locker1 = new Locker(5);
        Locker locker2 = new Locker(4);
        lockers.add(locker1);
        lockers.add(locker2);
        SmartRobot smartRobot = new SmartRobot(lockers);

        Bag bag = new Bag();
        Ticket ticket = smartRobot.store(bag);

        Assertions.assertNotNull(ticket);
        Assertions.assertEquals(locker1,smartRobot.ticketLockerMap.get(ticket));
    }
}
