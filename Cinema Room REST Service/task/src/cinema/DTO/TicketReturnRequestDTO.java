package cinema.DTO;

import java.util.UUID;

public class TicketReturnRequestDTO {
    private String token;

    public TicketReturnRequestDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    TicketReturnRequestDTO() {}
}
