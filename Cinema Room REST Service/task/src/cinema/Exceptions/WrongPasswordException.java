package cinema.Exceptions;

public class WrongPasswordException extends ProvidedException {
    public WrongPasswordException() {
        super("The password is wrong!");
    }

    public WrongPasswordException(Throwable cause) {
        super("The password is wrong!", cause);
    }
}
