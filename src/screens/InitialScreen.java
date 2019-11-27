package screens;

import util.Constants;

import java.util.Scanner;
// TODO: Finish these class's methods
public class InitialScreen implements IScreen{
    private Scanner getInput;
    public InitialScreen(){
        getInput = new Scanner(System.in);
    }
    @Override
    public void showMenu() {
        String gameName = Constants.gameName;
        String initialScreen = gameName+"\n";
        //System.out.print();
    }

    @Override
    public void input() {

    }
}
