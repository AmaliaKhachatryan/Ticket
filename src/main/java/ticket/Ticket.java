package ticket;

public class Ticket implements Comparable<Ticket> {
    private int Id;
    private int price;
    private String from;
    private String to;
    private int minutes;

    public Ticket(int id, int price, String from, String to, int minutes) {
        Id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.minutes = minutes;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }


    @Override
    public int compareTo(Ticket o) {
        if (this.getPrice() < o.getPrice()) {
            return -1;
        } else if (this.getPrice() > o.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "Id=" + Id +
                ", price=" + price +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", minutes=" + minutes +
                '}';
    }
}