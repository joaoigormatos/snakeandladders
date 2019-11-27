package util;

import java.util.Random;

public class Dice {
    private int diceNumber;
    private Random randomNumberGenerator;
    public Dice(){
        diceNumber = 6;
        randomNumberGenerator = new Random();
    }
    public int getDiceNumber(){
        return this.diceNumber;
    }
    public void setDiceNumber(int diceNumber){
        this.diceNumber = diceNumber;
    }
    public int getRandomNumber(){
        return randomNumberGenerator.nextInt(6)+1;
    }
}
