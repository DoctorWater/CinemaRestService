package cinema;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
public class RESTController {
    @GetMapping("/seats")
    public String getSeats() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(Main.getResponseObject());
    }

    @PostMapping("/purchase")
    public String sellSeats(@RequestBody UserInfo request) throws TicketBuyingException {
        int row = request.getRow();
        int column = request.getColumn();
        Seat bookingSeat = new Seat(row, column);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (Main.getRoom().getAvailableSeats().contains(bookingSeat)) {
            Main.getRoom().removeSeat(bookingSeat);
            return gson.toJson(new RequestDTO(row, column));
        }
        if(row>9 | column>9 | row<1 | column<1){
            throw new TicketBuyingException("The number of a row or a column is out of bounds!");
        }

        throw new TicketBuyingException("The ticket has been already purchased!");
    }
}
