package cinema.Exceptions;

public class ProvidedException extends Exception{
    public ProvidedException(String message) {
        super(message);
    }

    public ProvidedException(String message, Throwable cause) {
        super(message, cause);
    }
}
