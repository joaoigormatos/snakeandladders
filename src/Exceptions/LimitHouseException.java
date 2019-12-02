package Exceptions;

public class LimitHouseException extends Exception {
    @Override
    public String getMessage() {
        return "Can't advance any futher into the houses";
    }
}
