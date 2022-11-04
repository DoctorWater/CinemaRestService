package cinema.Exceptions;

import java.util.UUID;

public class OrderWasNotFoundException extends Exception{
    public OrderWasNotFoundException() {
        super("Wrong token!");
    }
}
