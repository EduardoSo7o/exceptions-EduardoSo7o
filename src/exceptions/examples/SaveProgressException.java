package exceptions.examples;

public class SaveProgressException extends Exception {

    public SaveProgressException (String message, Throwable cause){
        super(message, cause);
    }
}
