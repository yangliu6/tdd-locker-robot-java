package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockerRobotTest {

    @Test
    void should_return_ticket_when_store_package_given_locker_robot_is_available() {
        LockerRobot lockerRobot = new LockerRobot(10);
        Bag bag = new Bag("my bag");
        Ticket ticket = lockerRobot.store(bag);
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_null_when_store_package_given_locker_robot_is_not_available() {
        LockerRobot lockerRobot = new LockerRobot(1);
        Bag bag = new Bag("my bag");
        Ticket ticket = lockerRobot.store(bag);
        Assertions.assertNotNull(ticket);

        Bag anotherBag = new Bag("another bag");
        Ticket anotherTicket = lockerRobot.store(anotherBag);
        Assertions.assertNull(anotherTicket);
    }
}
