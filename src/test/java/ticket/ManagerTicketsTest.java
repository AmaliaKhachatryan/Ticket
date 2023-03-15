package ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ManagerTicketsTest {
    Ticket ticket1 = new Ticket(1, 4500, "MOW", "LED", 90);
    Ticket ticket2 = new Ticket(2, 9000, "MOW", "ERV", 90);
    Ticket ticket3 = new Ticket(3, 6000, "MOW", "LED", 100);
    Ticket ticket4 = new Ticket(4, 10000, "MOW", "OVB", 240);
    Ticket ticket5 = new Ticket(5, 6000, "MOW", "LED", 100);
    Ticket ticket6 = new Ticket(6, 50000, "DEM", "LON", 400);
    Ticket ticket7 = new Ticket(7, 5000, "MOW", "LED", 120);
    RepositoryTickets repository = new RepositoryTickets();
    ManagerTickets manager = new ManagerTickets(repository);

    @BeforeEach
    public void globalSetUp() {
        repository.addTicket(ticket1);
        repository.addTicket(ticket2);
        repository.addTicket(ticket3);
        repository.addTicket(ticket4);
        repository.addTicket(ticket5);
        repository.addTicket(ticket6);
        repository.addTicket(ticket7);
    }

    @Test
    public void findAllByFromAndToTest() {
        Ticket[] expected = {ticket1, ticket7, ticket3, ticket5};
        Assertions.assertArrayEquals(expected, manager.findAll("MOW", "LED"));
    }

    @Test
    public void findAllByNotValidTicketTest()  {
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, manager.findAll("OOO", "WWW"));
    }
    @Test
    public void findTicketByNotValidTo ()  {
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, manager.findAll("MOW", "WWW"));
    }
    @Test
    public void findTicketByNotValidFrom ()  {
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, manager.findAll("XXX", "LED"));
    }
    @Test
    public void findTicketByValidFrom ()  {
        Ticket[] expected = {ticket6};
        Assertions.assertArrayEquals(expected, manager.findAll("DEM", "LON"));
    }
 }