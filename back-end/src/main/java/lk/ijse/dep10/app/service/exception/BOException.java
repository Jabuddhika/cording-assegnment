package lk.ijse.dep10.app.service.exception;

public class BOException extends RuntimeException{

    public BOException() {
    }

    public BOException(String message) {
        super(message);
    }

    public BOException(String message, Throwable cause) {
        super(message, cause);
    }

    public BOException(Throwable cause) {

        super(cause);
    }


}
