package ticket;

import java.util.Arrays;
public class ManagerTickets extends MinimumTravelTime {
    private RepositoryTickets repository;

    public ManagerTickets(RepositoryTickets repository) {
        this.repository = repository;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] newTickets = new Ticket[0];
        RepositoryTickets repo = new RepositoryTickets();
        for (Ticket ticket : repository.findAll()) {
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {
                repo.addTicket(ticket);
            }
            newTickets = repo.findAll();

        }
        Arrays.sort(newTickets);
        return newTickets;
    }

    public Ticket[] findAllTicketsMinimalTimeTravel(String from, String to, MinimumTravelTime travelTime) {
        Ticket[] newTickets = findAll(from, to);
        Arrays.sort(newTickets, travelTime);
        return newTickets;
    }
}
