package cinema.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class TicketBuyingException extends ProvidedException{
    public TicketBuyingException (String error){
        super(error);
    }
}
