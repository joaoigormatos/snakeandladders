package screens;

import core.Game;

import java.util.Scanner;

public abstract class BaseScreen implements IScreen{
    protected Game game;
    protected Scanner getInput;
    public BaseScreen(Game game){
        this.game = game;
        getInput = new Scanner(System.in);
    }


    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
