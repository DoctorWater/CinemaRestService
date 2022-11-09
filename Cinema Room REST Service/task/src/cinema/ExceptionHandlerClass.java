package cinema;

import cinema.DTO.ExceptionResponseDTO;
import cinema.Exceptions.OrderWasNotFoundException;
import cinema.Exceptions.TicketBuyingException;
import cinema.Exceptions.WrongPasswordException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ExceptionHandlerClass {

}
