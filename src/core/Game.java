package core;

import Exceptions.NotFoundHouse;
import Exceptions.PlayerLimitExeception;
import base.IHouseIterator;
import base.Iterator;
import house.House;
import house.HouseCollections;
import house.HouseFactory;
import house.Houses;
import player.Player;
import player.PlayerCollection;
import player.Players;
import screens.*;
import util.Constants;
import util.Dice;

import java.util.ArrayList;

public class Game {
    private HouseCollections houseCollections;
    private Dice dice;
    private PlayerCollection playerCollection;
    private BaseScreen currentScreen;
    private boolean gameOn;
    private boolean nextScreen;
    private int playerQuantity;
    //Config Variables
    public  static  final int DEFAULT_NUMBER_PLAYERS =2;
    public static final int MAXIMUM_NUMBER_PLAYERS =4;
    public Game(){
        playerCollection = new Players();

        dice = new Dice();
        houseCollections = new Houses();
    }
    public void initGame(){
        //Todo: Give the greedins to player
        //Todo: How many Users going to use

        initialGameScreen();
        if(nextScreen){
            playersSetUpScreen();
        }
        if(nextScreen){
        //TODO: ADD THE METHOD THAT CALL THE SECOND SCREEN.
            addPlayerScreen();
        }
        if(nextScreen){
            mainScreen();
        }

    }



    private boolean  isQuantityValid(int quantity){
        return quantity >=  DEFAULT_NUMBER_PLAYERS && quantity <= MAXIMUM_NUMBER_PLAYERS;
    }
    public void setCurrentScreen(BaseScreen currentScreen) {
        this.currentScreen = currentScreen;
    }
     private void initialGameScreen(){
         currentScreen = new InitialScreen(this);
         currentScreen.showMenu();
         boolean initialScreen = true;
         while(initialScreen){
             int resultInitialScreen= currentScreen.input();
             if(resultInitialScreen== -1){
                  initialScreen = true;
             }
             else{
                 initialScreen = false;
                 //2 means that the player want to leave from the game
                 nextScreen = resultInitialScreen==2?false:true;
             }
         }
     }
     //TODO: add the showMessage notification
    private void playersSetUpScreen() {
        currentScreen = new PlayerSetUpScreen(this);
        currentScreen.showMenu();
        nextScreen = false;
        boolean playerSetupScreen = true;
        boolean resultValitationQuantity;
        int resultPlayerSetUpScreen;
        while(playerSetupScreen){
            resultPlayerSetUpScreen = currentScreen.input();
            if(resultPlayerSetUpScreen==-1){
                playerSetupScreen = true;
            }
            else{
                resultValitationQuantity = isQuantityValid(resultPlayerSetUpScreen);
                if(!resultValitationQuantity){
                    currentScreen.showMessage("This quantity is not allowed!!!\n Please type down again the quantity of players");
                }
                else{
                    nextScreen = true;
                    playerSetupScreen = false;
                    playerQuantity = resultPlayerSetUpScreen;
                }
            }
        }
    }
    //Remember to add a command to leave the game
    private void addPlayerScreen(){
        currentScreen = new AddPlayerScreen(this);
        currentScreen.showMenu();
        boolean addPlayerScreenLoop = true;
        int resultPlayerSetUpScreen;
        while(addPlayerScreenLoop){
            resultPlayerSetUpScreen= currentScreen.input();
            if(resultPlayerSetUpScreen==-1){
                addPlayerScreenLoop = true;
            }
            else{
                addPlayerScreenLoop = playerQuantity > playerCollection.size();
            }
        }
        if(!addPlayerScreenLoop){
            nextScreen = true;
            gameOn = true;
        }
    }

    private void mainScreen(){
        currentScreen = new MainScreen(this);
        Iterator iteratorPlayer = playerCollection.createIterator();
        IHouseIterator iHouseIterator = houseCollections.createIterator();
        setUpGame();
        setUpPlayers();

        currentScreen.showMenu();
        int playerInput;
        // Show the current player;
        // Ask him to roll the dice
        // Validated if input is correct
        //  If it's not we should stay ask him to give a right input
        // Show him the result of the dice
        // Move the player
        // Update his position
        int steps;
        String result;
        while(gameOn){
            showPlayersPosition();
            Player currentPlayer =(Player) iteratorPlayer.next();
            showPlayerPosition(currentPlayer);
            inputValidation();
            steps = dice.getRandomNumber();
            currentScreen.showMessage("the result of the dice is: "+steps);
            if(iHouseIterator.canWalk(currentPlayer.getPosition(),steps)){
                House house = iHouseIterator.walk(steps,currentPlayer.getPosition());

                if(house!=null){

                    if(house.hasEffect()){
                      result = house.doEffect(currentPlayer);
                    }
                    else{
                        currentPlayer.setPosition(currentPlayer.getPosition() + steps);
                        result = "Your new position is: "+currentPlayer.getPosition();
                    }
                    currentScreen.showMessage(result);
                }
            }
            else{
                gameOn = false;
                currentScreen.showMessage("=========================== Congratulation you win the Game ===========================");
            }
       }
    }
    private void showPlayerPosition(Player player){
        currentScreen.showMessage("The current player is: "+player.getName());
    }

    private void inputValidation(){
        int input;
        boolean inputValidationLoop = true;
        while(inputValidationLoop){
            input =  currentScreen.input();
            if(input!=-1){
                inputValidationLoop = false;
            }
        }
    }
    public void addPlay(String playerName) {
        try{
            playerCollection.addPlayer(playerName);
            currentScreen.showMessage("Player added with success");
        }catch (PlayerLimitExeception e){
            currentScreen.showMessage(e.getMessage());
        }
    }

    private void setUpGame(){
        for(int position = 1;position<=Constants.MAX_HOUSES;position++){
           try{
               House house = HouseFactory.createHouse(position);
              houseCollections.addHouse(house);
           }catch (NotFoundHouse notFoundHouse){
               currentScreen.showMessage(notFoundHouse.getMessage());
           }
        }
    }
    private void setUpPlayers(){
        Iterator iteratorPlayer = playerCollection.createIterator();
        while(iteratorPlayer.hasNext()){
            Player player =(Player) iteratorPlayer.next();
            player.setPosition(1);
        }
    }
    private void showPlayersPosition(){
        Iterator iteratorPlayer = playerCollection.createIterator();
        while(iteratorPlayer.hasNext()){
            Player player =(Player) iteratorPlayer.next();
            currentScreen.showMessage(
                    player.getName() + "\n" +
                    "  " + "Position: "+player.getPosition()
            );
        }
    }
}
