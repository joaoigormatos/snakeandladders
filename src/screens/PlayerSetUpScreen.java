package screens;

import core.Game;

public class PlayerSetUpScreen extends BaseScreen {
    public PlayerSetUpScreen(Game game) {
        super(game);
    }

    @Override
    public void showMenu() {
        System.out.println("Please Type down the quantity of players that will play this game");
        System.out.println("Remembe the minimum player quantity is 2 and the maximum is 4");
    }

    @Override
    public int input() {
        String optionGameText = getInput.nextLine();
        int optionGame=-1;
        try{
            optionGame = Integer.parseInt(optionGameText);
        }catch (NumberFormatException e){
            System.out.println("Sorry your's input isn't valid");
            System.out.println("Please type down again the quantity of players");
            return optionGame;
        }
        return optionGame;
    }

}
