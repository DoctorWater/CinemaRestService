package cinema.DTO;

import cinema.Enities.Ticket;
import cinema.Exceptions.MethodArgumentNullException;

import java.util.UUID;

public class ResponseDTO {
    private final String token;
    private final Ticket ticket;



    public ResponseDTO(Integer row, Integer column, String id) throws MethodArgumentNullException {
        if(row == null || column == null){
            throw new MethodArgumentNullException("ResponseDTO was created has null fields.");
        }
        this.ticket = new Ticket(row, column);
        this.token = id;
    }

    public Integer getRow() {
        return ticket.getRow();
    }

    public void setRow(Integer row) {
        this.ticket.setRow(row);
    }

    public Integer getColumn() {
        return ticket.getColumn();
    }

    public void setColumn(Integer column) {
        this.ticket.setColumn(column);
    }

    public Integer getPrice() {
        return ticket.getPrice();
    }

    public String getId() {
        return token;
    }
}
