package cinema;

import cinema.DTO.ExceptionResponseDTO;
import cinema.Exceptions.OrderWasNotFoundException;
import cinema.Exceptions.ProvidedException;
import cinema.Exceptions.TicketBuyingException;
import cinema.Exceptions.WrongPasswordException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class ExceptionHandlerClass {
    @ExceptionHandler(value = TicketBuyingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionResponseDTO handleException(TicketBuyingException e) {
        return new ExceptionResponseDTO(e.getMessage());
    }

    @ExceptionHandler(value = OrderWasNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionResponseDTO handleException(OrderWasNotFoundException e) {
        return new ExceptionResponseDTO(e.getMessage());
    }

    @ExceptionHandler(value = WrongPasswordException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public @ResponseBody ExceptionResponseDTO handleException(WrongPasswordException e){
        return new ExceptionResponseDTO(e.getMessage());
    }
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public @ResponseBody ExceptionResponseDTO handleException(MissingServletRequestParameterException e) throws WrongPasswordException {
        throw new WrongPasswordException(e);
    }
}
