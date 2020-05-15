package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockerRobotTest {

    @Test
    public void should_store_in_order_and_return_ticket_when_store_given_locker_is_available(){
        LockerRobot lockerRobot = new LockerRobot(3);
        Bag bag1 = new Bag();
        Bag bag2 = new Bag();

        lockerRobot.store(bag1);
        lockerRobot.store(bag2);

        Assertions.assertEquals(0,bag1);
        Assertions.assertEquals(1,bag2);
    }
}
