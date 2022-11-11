package cinema;

import cinema.DTO.*;
import cinema.Exceptions.MethodArgumentNullException;
import cinema.Exceptions.OrderWasNotFoundException;
import cinema.Exceptions.TicketBuyingException;
import cinema.Exceptions.WrongPasswordException;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTController {
    private final CinemaService cinemaService;
    public RESTController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    public RoomDTO getSeats() {
        return cinemaService.getRoomDTO();
    }

    @PostMapping("/purchase")
    public ResponseDTO sellSeats(@RequestBody UserInfoDTO request) throws TicketBuyingException, MethodArgumentNullException {
        int row = request.getRow();
        int column = request.getColumn();
        return cinemaService.bookSeat(row, column);
    }

    @PostMapping("/return")
    public TicketReturnResponseDTO returnTicket(@RequestBody TicketReturnRequestDTO requestDTO) throws OrderWasNotFoundException {
        TicketReturnResponseDTO response = cinemaService.unbookSeat(requestDTO.getToken());
        return response;
    }

    @PostMapping("/stats")
    public StatisticsDTO returnStatistics(@RequestParam String password) throws WrongPasswordException {
        String realPassword = "super_secret";
        try {
            if (password.equals(realPassword)) {
                return cinemaService.getStatisticsDTO();
            }
            throw new WrongPasswordException();
        }
        catch (Exception e){
            throw new WrongPasswordException();
        }
    }
}
