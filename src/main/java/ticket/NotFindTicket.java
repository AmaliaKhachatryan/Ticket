package ticket;

public class NotFindTicket extends RuntimeException{
    public NotFindTicket(int id){
        super("there is no ticket with this id:" +id);
    }
}
