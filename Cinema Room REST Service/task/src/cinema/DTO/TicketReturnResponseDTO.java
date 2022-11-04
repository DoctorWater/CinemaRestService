package cinema.DTO;

import cinema.Enities.Ticket;

public class TicketReturnResponseDTO {
    private Ticket returned_ticket; //this notation is required by the task

    public TicketReturnResponseDTO(Ticket returned_ticket) {
        this.returned_ticket = returned_ticket;
    }

    public Ticket getReturned_ticket() {
        return returned_ticket;
    }

    public void setReturned_ticket(Ticket returned_ticket) {
        this.returned_ticket = returned_ticket;
    }
}
