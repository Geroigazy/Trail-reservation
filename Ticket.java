public class Ticket {
    private int ticketId;
    private int price;
    private String depatureDate;
    private String start;
    private String finish;
//getters and setters
    public String getStart() {
        return start;
    }

    public String getFinish() {
        return finish;
    }

    public String getDepatureDate() {
        return depatureDate;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getPrice() {
        return price;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setDepatureDate(String depatureDate) {
        this.depatureDate = depatureDate;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}

