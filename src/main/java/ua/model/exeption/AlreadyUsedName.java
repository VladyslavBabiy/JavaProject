package ua.model.exeption;

public class AlreadyUsedName extends RuntimeException{
    AlreadyUsedName(){
        super();
    }
    public AlreadyUsedName(String message)
    {
        super(message);
    }
    AlreadyUsedName(String message, Throwable cause)
    {
        super(message,cause);
    }
}
