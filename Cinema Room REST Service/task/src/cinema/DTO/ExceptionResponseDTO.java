package cinema.DTO;

public class ExceptionResponseDTO {
    private String error;

    public ExceptionResponseDTO(String message)
    {
        super();
        error = message;
    }
}
