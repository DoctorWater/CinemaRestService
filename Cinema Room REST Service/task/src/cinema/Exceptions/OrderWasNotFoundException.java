package cinema.Exceptions;

import java.util.UUID;

public class OrderWasNotFoundException extends ProvidedException{
    public OrderWasNotFoundException() {
        super("Wrong token!");
    }
}
