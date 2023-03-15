package ticket;

public class NegativeException extends RuntimeException{
    public NegativeException (int id){
        super("Element can not be with negative id: "+id);
    }
}
