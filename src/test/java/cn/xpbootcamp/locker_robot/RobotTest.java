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
}
