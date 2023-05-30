import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {

    @Test
    public void testSortTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("EKB", "MSK", 300, 9, 12);
        Ticket ticket2 = new Ticket("EKB", "SPB", 200, 10, 14);
        Ticket ticket3 = new Ticket("MSK", "BLR", 100, 10, 13);
        Ticket ticket4 = new Ticket("EKB", "MSK", 400, 4, 4);
        Ticket ticket5 = new Ticket("BLR", "SPB", 700, 5, 8);
        Ticket ticket6 = new Ticket("EKB", "MSK", 300, 3, 10);
        Ticket ticket7 = new Ticket("BLR", "MEX", 100, 14, 16);
        Ticket ticket8 = new Ticket("EKB", "MSK", 600, 4, 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket1, ticket4, ticket6, ticket8};
        Ticket[] actual = manager.search("EKB", "MSK");

         Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTickets1() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("EKB", "MSK", 300, 9, 12);
        Ticket ticket2 = new Ticket("EKB", "SPB", 200, 10, 14);
        Ticket ticket3 = new Ticket("MSK", "BLR", 100, 10, 13);
        Ticket ticket4 = new Ticket("EKB", "MSK", 400, 4, 4);
        Ticket ticket5 = new Ticket("BLR", "SPB", 700, 5, 8);
        Ticket ticket6 = new Ticket("EKB", "MSK", 300, 3, 10);
        Ticket ticket7 = new Ticket("BLR", "MEX", 100, 14, 16);
        Ticket ticket8 = new Ticket("EKB", "MSK", 600, 4, 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket7};
        Ticket[] actual = manager.search("BLR", "MEX");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTickets0() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("EKB", "MSK", 300, 9, 12);
        Ticket ticket2 = new Ticket("EKB", "SPB", 200, 10, 14);
        Ticket ticket3 = new Ticket("MSK", "BLR", 100, 10, 13);
        Ticket ticket4 = new Ticket("EKB", "MSK", 400, 4, 4);
        Ticket ticket5 = new Ticket("BLR", "SPB", 700, 5, 8);
        Ticket ticket6 = new Ticket("EKB", "MSK", 300, 3, 10);
        Ticket ticket7 = new Ticket("BLR", "MEX", 100, 14, 16);
        Ticket ticket8 = new Ticket("EKB", "MSK", 600, 4, 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSK", "MEX");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("EKB", "MSK", 300, 9, 12);
        Ticket ticket2 = new Ticket("EKB", "SPB", 200, 10, 14);
        Ticket ticket3 = new Ticket("MSK", "BLR", 100, 10, 13);
        Ticket ticket4 = new Ticket("EKB", "MSK", 400, 4, 4);
        Ticket ticket5 = new Ticket("BLR", "SPB", 700, 5, 8);
        Ticket ticket6 = new Ticket("EKB", "MSK", 300, 3, 10);
        Ticket ticket7 = new Ticket("BLR", "MEX", 100, 14, 16);
        Ticket ticket8 = new Ticket("EKB", "MSK", 600, 4, 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket1, ticket8, ticket6};
        Ticket[] actual = manager.search("EKB", "MSK", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparator1() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("EKB", "MSK", 300, 9, 12);
        Ticket ticket2 = new Ticket("EKB", "SPB", 200, 10, 14);
        Ticket ticket3 = new Ticket("MSK", "BLR", 100, 10, 13);
        Ticket ticket4 = new Ticket("EKB", "MSK", 400, 4, 4);
        Ticket ticket5 = new Ticket("BLR", "SPB", 700, 5, 8);
        Ticket ticket6 = new Ticket("EKB", "MSK", 300, 3, 10);
        Ticket ticket7 = new Ticket("BLR", "MEX", 100, 14, 16);
        Ticket ticket8 = new Ticket("EKB", "MSK", 600, 4, 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket7};
        Ticket[] actual = manager.search("BLR", "MEX", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparator0() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("EKB", "MSK", 300, 9, 12);
        Ticket ticket2 = new Ticket("EKB", "SPB", 200, 10, 14);
        Ticket ticket3 = new Ticket("MSK", "BLR", 100, 10, 13);
        Ticket ticket4 = new Ticket("EKB", "MSK", 400, 4, 4);
        Ticket ticket5 = new Ticket("BLR", "SPB", 700, 5, 8);
        Ticket ticket6 = new Ticket("EKB", "MSK", 300, 3, 10);
        Ticket ticket7 = new Ticket("BLR", "MEX", 100, 14, 16);
        Ticket ticket8 = new Ticket("EKB", "MSK", 600, 4, 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSK", "MEX", comparator);

        assertArrayEquals(expected, actual);
    }
}
