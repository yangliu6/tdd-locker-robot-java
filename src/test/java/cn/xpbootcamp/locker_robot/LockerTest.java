package cn.xpbootcamp.locker_robot;

import cn.xpbootcamp.locker_robot.exception.InvalidTicketException;
import cn.xpbootcamp.locker_robot.exception.NoAvailableLockerBoxException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LockerTest {

    @Test
    void should_return_ticket_when_store_bag_given_locker_robot_is_available() throws NoAvailableLockerBoxException {
        Locker locker = new Locker(10);
        Bag bag = new Bag();

        Ticket ticket = locker.store(bag);

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_null_when_store_bag_given_locker_robot_is_not_available() throws NoAvailableLockerBoxException {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        Ticket ticket = locker.store(bag);

        Bag anotherBag = new Bag();
        NoAvailableLockerBoxException exception = Assertions.assertThrows(NoAvailableLockerBoxException.class, () -> locker.store(anotherBag));

        assertEquals("Locker is full", exception.getMessage());
    }

    @Test
    void should_return_bag_when_get_bag_given_right_ticket() throws NoAvailableLockerBoxException, InvalidTicketException {
        Locker locker = new Locker(10);
        Bag bag1 = new Bag();
        Ticket ticket = locker.store(bag1);

        Bag bag2 = locker.takeOut(ticket);

        Assertions.assertEquals(bag1, bag2);
    }

    @Test
    void should_not_get_bag_when_get_bag_given_wrong_ticket() throws NoAvailableLockerBoxException {
        Locker locker = new Locker(10);
        Bag bag = new Bag();
        Ticket ticket = locker.store(bag);

        Ticket wrongTicket = new Ticket();

        InvalidTicketException exception = Assertions.assertThrows(InvalidTicketException.class,() ->locker.takeOut(wrongTicket));
        assertEquals("Invalid Ticket", exception.getMessage());
    }

    @Test
    void should_not_get_bag_when_get_bag_given_expired_ticket() throws NoAvailableLockerBoxException {
        Locker locker = new Locker(10);
        Bag bag = new Bag();
        Ticket ticket = locker.store(bag);

        Assertions.assertDoesNotThrow(() ->locker.takeOut(ticket));

        InvalidTicketException exception = Assertions.assertThrows(InvalidTicketException.class,() ->locker.takeOut(ticket));
        assertEquals("Invalid Ticket", exception.getMessage());
    }
}
