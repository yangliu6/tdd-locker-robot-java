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

    @Test
    void should_return_bag_when_get_package_given_right_ticket() {
        LockerRobot lockerRobot = new LockerRobot(10);
        Bag bag1 = new Bag("my bag");
        Ticket ticket = lockerRobot.store(bag1);

        Bag bag2 = lockerRobot.takeOut(ticket);
        Assertions.assertEquals(bag1, bag2);
        Assertions.assertEquals("my bag", bag2.getName());
    }

    @Test
    void should_not_get_bag_when_get_package_given_wrong_ticket() {
        LockerRobot lockerRobot = new LockerRobot(10);
        Bag bag1 = new Bag("my bag");
        Ticket ticket = lockerRobot.store(bag1);

        // ticket == null
        Assertions.assertNull(lockerRobot.takeOut(null));

        // ticket.password == null
        Assertions.assertNull(lockerRobot.takeOut(new Ticket(null)));

        // ticket password is wrong
        Ticket wrongTicket = new Ticket(ticket.getPassword()+ 1231);
        Assertions.assertNull(lockerRobot.takeOut(wrongTicket));

        Bag bag2 = lockerRobot.takeOut(ticket);
        Assertions.assertEquals(bag1, bag2);
        Assertions.assertEquals("my bag", bag2.getName());

        // expired ticket
        Assertions.assertNull(lockerRobot.takeOut(ticket));
    }
}
