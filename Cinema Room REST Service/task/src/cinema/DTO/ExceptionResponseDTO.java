package cinema.DTO;

public class ExceptionResponseDTO {
    private final String error;

    public ExceptionResponseDTO(String message)
    {
        error = message;
    }

    public ExceptionResponseDTO(Exception e){
        error = e.getMessage();
    }
}
