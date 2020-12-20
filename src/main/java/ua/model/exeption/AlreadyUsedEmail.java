package ua.model.exeption;

public class AlreadyUsedEmail extends RuntimeException {
    AlreadyUsedEmail(){
        super();
    }
    public AlreadyUsedEmail(String message)
    {
        super(message);
    }
    AlreadyUsedEmail(String message, Throwable cause)
    {
        super(message,cause);
    }
}
