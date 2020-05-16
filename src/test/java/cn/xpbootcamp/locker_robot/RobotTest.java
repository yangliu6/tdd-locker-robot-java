package cn.xpbootcamp.locker_robot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cn.xpbootcamp.locker_robot.exception.InvalidTicketException;
import cn.xpbootcamp.locker_robot.exception.NoAvailableLockerBoxException;
import cn.xpbootcamp.locker_robot.exception.NoAvailableLockerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RobotTest {

    @Test
    void should_return_ticket_when_store_package_given_robot_have_available_locker()
            throws NoAvailableLockerBoxException, NoAvailableLockerException {
        Robot robot = new Robot();
        Locker locker = new Locker(5);
        robot.add(locker);

        Bag bag = new Bag();
        Ticket ticket = robot.store(bag);

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_store_into_the_first_available_locker_and_return_ticket_when_store_package_given_robot_have_many_available_lockers()
            throws NoAvailableLockerBoxException, NoAvailableLockerException {
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

    @Test
    void should_warning_no_locker_available_when_store_package_given_no_available_lockers() {
        Robot robot = new Robot();
        Locker locker = new Locker(0);
        robot.add(locker);

        Bag bag = new Bag();

        NoAvailableLockerException exception = Assertions.assertThrows(NoAvailableLockerException.class, () -> robot.store(bag));
        assertEquals("No locker available", exception.getMessage());
    }

    @Test
    void should_return_package_when_get_package_given_right_ticket()
            throws NoAvailableLockerBoxException, NoAvailableLockerException, InvalidTicketException {
        Robot robot = new Robot();
        Locker locker1 = new Locker(0);
        Locker locker2 = new Locker(1);
        robot.add(locker1);
        robot.add(locker2);
        Bag storedBag = new Bag();
        Ticket ticket = robot.store(storedBag);

        Bag bag = robot.getBagWithTicket(ticket);

        Assertions.assertEquals(storedBag, bag);
    }

    @Test
    void should_not_get_package_when_get_package_given_wrong_ticket()
            throws NoAvailableLockerBoxException, NoAvailableLockerException {
        Robot robot = new Robot();
        Locker locker = new Locker(1);
        robot.add(locker);
        Bag storedBag = new Bag();
        Ticket theRightTicket = robot.store(storedBag);
        Ticket theWrongTicket = new Ticket();
        Assertions.assertNotEquals(theRightTicket, theWrongTicket);

        InvalidTicketException exception = Assertions.assertThrows(InvalidTicketException.class, () -> robot.getBagWithTicket(theWrongTicket));

        assertEquals("Invalid Ticket", exception.getMessage());
    }

    @Test
    void should_not_get_package_when_get_package_given_expired_ticket()
            throws NoAvailableLockerBoxException, NoAvailableLockerException, InvalidTicketException {
        Robot robot = new Robot();
        Locker locker = new Locker(1);
        robot.add(locker);
        Bag storedBag = new Bag();
        Ticket theRightTicket = robot.store(storedBag);
        Bag bag = robot.getBagWithTicket(theRightTicket);
        assertEquals(storedBag, bag);

        InvalidTicketException exception = Assertions.assertThrows(InvalidTicketException.class, () -> robot.getBagWithTicket(theRightTicket));

        assertEquals("Invalid Ticket", exception.getMessage());
    }
}
