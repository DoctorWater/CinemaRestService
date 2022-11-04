package cinema.Enities;

public class Ticket {
    private transient final int HIGH_PRICE = 10;
    private transient final int LOW_PRICE = 8;
    private Integer row;
    private Integer column;
    private Integer price;

    public Ticket(Integer row, Integer column) {
        this.row = row;
        this.column = column;
        if (row <= 4) {
            price = HIGH_PRICE;
        } else {
            price = LOW_PRICE;
        }
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;

        Ticket ticket = (Ticket) o;

        if (!getRow().equals(ticket.getRow())) return false;
        if (!getColumn().equals(ticket.getColumn())) return false;
        return getPrice().equals(ticket.getPrice());
    }

    @Override
    public int hashCode() {
        int result = HIGH_PRICE;
        result = 31 * result + LOW_PRICE;
        result = 31 * result + getRow().hashCode();
        result = 31 * result + getColumn().hashCode();
        result = 31 * result + getPrice().hashCode();
        return result;
    }
}
