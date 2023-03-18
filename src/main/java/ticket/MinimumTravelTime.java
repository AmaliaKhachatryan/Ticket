package ticket;

import java.util.Comparator;

public class MinimumTravelTime implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        if (o1.getMinutes() < o2.getMinutes()) {
            return -1;
        }
        if (o1.getMinutes() > o2.getMinutes()) {
            return 1;
        } else {
            return 0;
        }
    }
}