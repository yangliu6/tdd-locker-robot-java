package cn.xpbootcamp.locker_robot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RobotTest {

    @Test
    void should_return_ticket_when_store_package_given_robot_have_available_locker() {
        Robot robot = new Robot();
        Locker locker = new Locker(5);
        robot.add(locker);

        Bag bag = new Bag();
        Ticket ticket = robot.store(bag);

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_store_into_the_first_available_locker_and_return_ticket_when_store_package_given_robot_have_many_available_lockers() {
        Robot robot = new Robot();
        Locker theFirstLocker = new Locker(0);
        Locker theSecondLocker = new Locker(1);
        Locker theThirdLocker = new Locker(1);
        robot.add(theFirstLocker);
        robot.add(theSecondLocker);
        robot.add(theThirdLocker);

        Bag bag = new Bag();
        Ticket ticket = robot.store(bag);

        Assertions.assertEquals(theSecondLocker, robot.getLockerWithTicket(ticket));
        Assertions.assertNotNull(ticket);
    }
}
