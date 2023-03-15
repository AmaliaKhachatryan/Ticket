package ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTicketsTest {
    Ticket ticket1 = new Ticket(1, 7000, "MOW", "LED", 90);
    Ticket ticket2 = new Ticket(2, 9000, "MOW", "ERV", 90);
    Ticket ticket3 = new Ticket(3, 6000, "MOW", "LED", 100);
    Ticket ticket4 = new Ticket(4, 10000, "MOW", "OVB", 240);
    Ticket ticket5 = new Ticket(5, 6000, "MOW", "LED", 100);
    Ticket ticket6 = new Ticket(6, 50000, "DEM", "LON", 400);
    Ticket ticket7 = new Ticket(7, 5000, "MOW", "LED", 120);
    RepositoryTickets repository = new RepositoryTickets();

    @Test
    public void addTicketTest() {
        repository.addTicket(ticket1);
        repository.addTicket(ticket2);
        repository.addTicket(ticket3);
        repository.addTicket(ticket4);
        repository.addTicket(ticket5);
        repository.addTicket(ticket6);
        repository.addTicket(ticket7);
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};
        Assertions.assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void remoteByIdTicketTest() {
        repository.addTicket(ticket1);
        repository.addTicket(ticket2);
        repository.addTicket(ticket3);
        repository.addTicket(ticket4);
        repository.addTicket(ticket5);
        repository.remoteByIdTicket(ticket5.getId());
        repository.remoteByIdTicket(ticket4.getId());
        Ticket[] expected = {ticket1, ticket2, ticket3};
        Assertions.assertArrayEquals(expected, repository.findAll());
    }

     @Test
    public void remoteByMinusIdTicketTest() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            repository.remoteByIdTicket(-5);
        });
        Assertions.assertNotNull(exception.getMessage());
    }
    @Test
    public void remoteByNegativeIdTicketTest() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            repository.remoteByIdTicket(111);
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void remoteNotValidMinusTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            repository.remoteByIdTicket(-1);
        });
    }

    @Test
    public void findAllTest() {
       Ticket[] expected = {};
       Assertions.assertArrayEquals(expected, repository.findAll());
    }
    @Test
    public void remoteByAnyIdTicketTest() {
        repository.addTicket(ticket1);
        repository.addTicket(ticket2);
        repository.addTicket(ticket3);
        Ticket[] expected = {ticket1, ticket2, ticket3};
        Assertions.assertArrayEquals(expected, repository.findAll());
    }
    @Test
    public void remoteAllTicketTest() {
        repository.addTicket(ticket1);
        repository.remoteByIdTicket(ticket1.getId());
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, repository.findAll());
    }

}