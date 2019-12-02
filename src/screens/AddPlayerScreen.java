package screens;

import core.Game;

public class AddPlayerScreen extends BaseScreen {
    private int playerNumber = 1;

    public AddPlayerScreen(Game game) {
        super(game);
    }

    @Override
    public void showMenu() {
        System.out.println("===== Add Player Screen =====");
    }


    //TODO: This method should valited the input from the user
    @Override
    public int input() {
        System.out.println("Add the name of the player "+playerNumber+": ");
        String playerName = getInput.nextLine();
        playerNumber++;
        game.addPlay(playerName);
        return 0;
    }

}

