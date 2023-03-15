package ticket;

import java.util.Arrays;

public class ManagerTickets {
    private RepositoryTickets repository;
    private Ticket[] tickets;

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
            Arrays.sort(newTickets);
        }
        return newTickets;
    }
}