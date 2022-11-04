package cinema;

import cinema.DTO.*;
import cinema.Enities.Seat;
import cinema.Enities.Ticket;
import cinema.Exceptions.MethodArgumentNullException;
import cinema.Exceptions.OrderWasNotFoundException;
import cinema.Exceptions.TicketBuyingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class RESTController {
    private final CinemaService cinemaService;

    public RESTController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    public String getSeats() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(cinemaService.getRoomDTO());
    }

    @PostMapping("/purchase")
    public String sellSeats(@RequestBody UserInfo request) throws TicketBuyingException, MethodArgumentNullException {
        int row = request.getRow();
        int column = request.getColumn();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(cinemaService.bookSeat(row, column));
    }

    @PostMapping("/return")
    public String returnTicket(@RequestBody TicketReturnRequestDTO requestDTO) throws OrderWasNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        TicketReturnResponseDTO response = cinemaService.unbookSeat(requestDTO.getToken());
        return gson.toJson(response);
    }

    @ExceptionHandler(value = TicketBuyingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody String handleException(TicketBuyingException e) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(new ExceptionResponseDTO(e.getMessage()));
    }

    @ExceptionHandler(value = OrderWasNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody String handleException(OrderWasNotFoundException e) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(new ExceptionResponseDTO(e.getMessage()));
    }
}
