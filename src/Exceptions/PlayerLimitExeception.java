package Exceptions;

public class PlayerLimitExeception extends Exception {
    @Override
    public String getMessage() {
        return "PlayerCollection has arrived at his limit of capacity";
    }
}
