
package screens;

import core.Game;
import util.Constants;

import java.sql.SQLOutput;
import java.util.Scanner;
// TODO: Finish these class's methods
public class InitialScreen extends BaseScreen {
    public InitialScreen(Game game){
        super(game);

    }
    @Override
    public void showMenu() {
        System.out.println("========== Welcome to Snake and Ladders Game================");
        System.out.println("type 1 to play");
        System.out.println("Type 2 to leave");

    }

    @Override
    public int input() {
        String optionGameText = getInput.nextLine();
        int optionGame=-1;
        try{
            optionGame = Integer.parseInt(optionGameText);
        }catch (NumberFormatException e){
            System.out.println("Sorry your's input isn't valid");
            System.out.println("Please try again");
            return -1;
        }

        return optionGame;
    }

}
