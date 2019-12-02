package screens;

import core.Game;

public class MainScreen extends BaseScreen implements IScreen {
    public MainScreen(Game game) {
        super(game);
    }

    @Override
    public void showMenu() {
        System.out.println("==== Game ====");
    }

    @Override
    public int input() {
        System.out.println("Type down 1 to roll the dice:");
        String optionDice = getInput.nextLine();
        int optionGame=-1;
        try{
            optionGame = Integer.parseInt(optionDice);
        }catch (NumberFormatException e){
            System.out.println("Sorry your's input isn't valid");
            System.out.println("Please try again");
            return -1;
        }
        return optionGame;
    }
}
