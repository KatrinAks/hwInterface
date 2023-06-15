import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void shouldCompareToEquals() {
    Ticket ticket = new Ticket("МСК", "Тюмень", 50, 8, 15);

        int o = 50;

        int expected = 0;
        int actual = ticket.compareTo(ticket);


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToMore() {
        Ticket ticket = new Ticket("МСК", "Тюмень", 50, 8, 15);

        int o = 60;


        int expected = -1;
        int actual = ticket.compareTo(ticket);
    }

    @Test
    public void shouldCompareToLess() {
        Ticket ticket = new Ticket("МСК", "Тюмень", 50, 8, 15);

        int o = 40;


        int expected = 1;
        int actual = ticket.compareTo(ticket);
    }

    @Test
    public void shouldSortTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("МСК", "СПБ", 30, 9, 11);
        Ticket ticket2 = new Ticket("МСК", "СПБ", 20, 12, 15);
        Ticket ticket3 = new Ticket("МСК", "СПБ", 40, 8, 13);
        Ticket ticket4 = new Ticket("Тюмень", "МСК", 50, 14, 18);
        Ticket ticket5 = new Ticket("МСК", "СПБ", 70, 7, 10);
        Ticket ticket6 = new Ticket("МСК", "СПБ", 60, 11, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket2, ticket1, ticket3, ticket6, ticket5};
        Ticket[] actual = manager.search("МСК","СПБ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicket1() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Тюмень", "СПБ", 30, 9, 11);
        Ticket ticket2 = new Ticket("МСК", "СПБ", 20, 12, 15);
        Ticket ticket3 = new Ticket("МСК", "СПБ", 40, 8, 13);
        Ticket ticket4 = new Ticket("Тюмень", "СПБ", 50, 14, 18);
        Ticket ticket5 = new Ticket("МСК", "СПБ", 70, 7, 10);
        Ticket ticket6 = new Ticket("Тюмень", "СПБ", 60, 11, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket1, ticket4, ticket6};
        Ticket[] actual = manager.search("Тюмень","СПБ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketNotFlight() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Тюмень", "СПБ", 30, 9, 11);
        Ticket ticket2 = new Ticket("МСК", "СПБ", 20, 12, 15);
        Ticket ticket3 = new Ticket("МСК", "СПБ", 40, 8, 13);
        Ticket ticket4 = new Ticket("Тюмень", "СПБ", 50, 14, 18);
        Ticket ticket5 = new Ticket("МСК", "СПБ", 70, 7, 10);
        Ticket ticket6 = new Ticket("Тюмень", "СПБ", 60, 11, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Тюмень","Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

   @Test
    public void shouldComparatorToEquals() {
       Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket t1 = new Ticket("МСК", "Тюмень", 50, 8, 15);
        Ticket t2 = new Ticket("МСК", "Тюмень", 60, 8, 15);

        int expected = 0;
        int actual = ticketTimeComporator.compare("МСК", "Тюмень");


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByComparatorTicketM() {
        AviaSouls manager = new AviaSouls();
        Ticket t1 = new Ticket("Тюмень", "СПБ", 30, 9, 11); // 2 время полета
        Ticket t2 = new Ticket("МСК", "СПБ", 20, 12, 15);   // 3
        Ticket t3 = new Ticket("МСК", "СПБ", 40, 8, 13);    // 5
        Ticket t4 = new Ticket("Тюмень", "СПБ", 50, 14, 18);// 4
        Ticket t5 = new Ticket("МСК", "СПБ", 70, 7, 11);    // 4
        Ticket t6 = new Ticket("Тюмень", "СПБ", 60, 11, 15);// 4

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {t2, t5, t3};
        Ticket[] actual = manager.searchAndSortBy("МСК","СПБ", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByComparatorTicketT() {
        AviaSouls manager = new AviaSouls();
        Ticket t1 = new Ticket("Тюмень", "СПБ", 30, 9, 11); // 2 время полета
        Ticket t2 = new Ticket("МСК", "СПБ", 20, 12, 15);   // 3
        Ticket t3 = new Ticket("МСК", "СПБ", 40, 8, 13);    // 5
        Ticket t4 = new Ticket("Тюмень", "СПБ", 50, 14, 18);// 4
        Ticket t5 = new Ticket("МСК", "СПБ", 70, 7, 11);    // 4
        Ticket t6 = new Ticket("Тюмень", "СПБ", 60, 11, 15);// 4

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {t1, t4, t6};
        Ticket[] actual = manager.searchAndSortBy("Тюмень","СПБ", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByComparatorTicketNot() {
        AviaSouls manager = new AviaSouls();
        Ticket t1 = new Ticket("Тюмень", "СПБ", 30, 9, 11); // 2 время полета
        Ticket t2 = new Ticket("МСК", "СПБ", 20, 12, 15);   // 3
        Ticket t3 = new Ticket("МСК", "СПБ", 40, 8, 13);    // 5
        Ticket t4 = new Ticket("Тюмень", "СПБ", 50, 14, 18);// 4
        Ticket t5 = new Ticket("МСК", "СПБ", 70, 7, 11);    // 4
        Ticket t6 = new Ticket("Тюмень", "СПБ", 60, 11, 15);// 4

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Тюмень","Москва", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
