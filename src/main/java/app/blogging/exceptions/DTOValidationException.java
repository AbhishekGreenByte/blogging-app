package app.blogging.exceptions;

public class DTOValidationException extends RuntimeException{
    String message;

    public DTOValidationException(String field,String message) {
        super("Error in field: "+field+"-->Reason: "+message);
        this.message = message;
    }
}
