package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class TicketBuyingException extends RuntimeException{
    public TicketBuyingException (String error){
        super(error);
    }
}
