package ticket;

public class RepositoryTickets {
    private Ticket[] tickets = new Ticket[0];

    public Ticket[] findAll() {
        return tickets;
    }

    public void remoteByIdTicket(int id) {
        if (id < 0) {
            throw new NegativeException(id);
        }
        try {
            Ticket[] result = new Ticket[tickets.length - 1];
            int number = 0;
            for (Ticket tic : tickets) {
                if (tic.getId() != id) {
                    result[number] = tic;
                    number++;
                }
            }
            tickets = result;
        } catch (Exception e) {
            throw new NotFindTicket(id);
        }
    }

    public void addTicket(Ticket ticket) {
        Ticket[] result = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            result[i] = tickets[i];
        }
        result[result.length - 1] = ticket;
        tickets = result;
    }
}
