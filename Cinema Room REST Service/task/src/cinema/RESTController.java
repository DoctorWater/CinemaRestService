package cinema;

import cinema.DTO.*;
import cinema.Exceptions.MethodArgumentNullException;
import cinema.Exceptions.OrderWasNotFoundException;
import cinema.Exceptions.TicketBuyingException;
import cinema.Exceptions.WrongPasswordException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTController {
    private final CinemaService cinemaService;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public RESTController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    public String getSeats() {
        return gson.toJson(cinemaService.getRoomDTO());
    }

    @PostMapping("/purchase")
    public String sellSeats(@RequestBody UserInfo request) throws TicketBuyingException, MethodArgumentNullException {
        int row = request.getRow();
        int column = request.getColumn();
        return gson.toJson(cinemaService.bookSeat(row, column));
    }

    @PostMapping("/return")
    public String returnTicket(@RequestBody TicketReturnRequestDTO requestDTO) throws OrderWasNotFoundException {
        TicketReturnResponseDTO response = cinemaService.unbookSeat(requestDTO.getToken());
        return gson.toJson(response);
    }

    @PostMapping("/stats")
    public String returnStatistics(@RequestParam String password) throws WrongPasswordException {
        String realPassword = "super_secret";
        try {
            if (password.equals(realPassword)) {
                StatisticsDTO result = cinemaService.getStatisticsDTO();
                return gson.toJson(result);
            }
            throw new WrongPasswordException();
        }
        catch (Exception e){
            throw new WrongPasswordException();
        }
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

    @ExceptionHandler(value = WrongPasswordException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public @ResponseBody String handleException(WrongPasswordException e){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(new ExceptionResponseDTO(e.getMessage()));
    }
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public @ResponseBody String handleException(MissingServletRequestParameterException e){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(new ExceptionResponseDTO("The password is wrong!"));
    }
}
