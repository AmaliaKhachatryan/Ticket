package ticket;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        RepositoryTickets repository = new RepositoryTickets();
        MinimumTravelTime travelTime = new MinimumTravelTime();
        ManagerTickets managerTickets = new ManagerTickets(repository);

        Ticket ticket1 = new Ticket(1, 4500, "MOW", "LED", 90);
        Ticket ticket2 = new Ticket(2, 9000, "MOW", "ERV", 90);
        Ticket ticket3 = new Ticket(3, 6000, "MOW", "LED", 100);
        Ticket ticket4 = new Ticket(4, 10000, "MOW", "OVB", 240);
        Ticket ticket5 = new Ticket(5, 6000, "MOW", "LED", 100);
        Ticket ticket6 = new Ticket(6, 50000, "DEM", "LON", 400);
        Ticket ticket7 = new Ticket(7, 5000, "MOW", "LED", 80);

        repository.addTicket(ticket1);
        repository.addTicket(ticket2);
        repository.addTicket(ticket3);
        repository.addTicket(ticket4);
        repository.addTicket(ticket5);
        repository.addTicket(ticket6);
        repository.addTicket(ticket7);

        Ticket[] tickets = managerTickets.findAll("MOW", "LED");
        Arrays.sort(tickets, travelTime);

        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }
}