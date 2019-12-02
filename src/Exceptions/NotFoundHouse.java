package Exceptions;

public class NotFoundHouse extends Exception {
    @Override
    public String getMessage() {
        return "House name doesn't exists";
    }
}
