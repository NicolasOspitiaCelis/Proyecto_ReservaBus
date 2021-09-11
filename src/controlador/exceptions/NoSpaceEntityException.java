package controlador.exceptions;

public class NoSpaceEntityException extends Exception {
    public NoSpaceEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public NoSpaceEntityException(String message) {
        super(message);
    }
}
