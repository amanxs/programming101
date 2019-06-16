package programming2018.goldmanSachs.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadder {

    private static final int WIN_SPOT = 100 ;
    static Map<Integer, Integer> ladderPositionMap= new HashMap<>();
    static Map<Integer, Integer> snakePositionMap= new HashMap<>();

    static Map<Integer, Player> playerMap = new HashMap<>();

    private static int numberOfPlayers = 2; // Can get input value from user

    static Scanner scan  = new Scanner(System.in);


    public static void main(String args){
        constructSnakePosition();
        constructLadderPosition();
        setUpPlayers();
        playGame();
    }



    private static void setUpPlayers(){
        for(int i=1; i<= numberOfPlayers; i++){
            Player player = new Player();
            player.playerName = "Player " + i;
            playerMap.put(i, player);

        }
    }

    private static void constructLadderPosition() {
        ladderPositionMap.put(6,25);
        ladderPositionMap.put(11,40);
        ladderPositionMap.put(60,85);
        ladderPositionMap.put(46,90);
        ladderPositionMap.put(17,69);
    }

    private static void constructSnakePosition() {


        snakePositionMap.put(99,54);
        snakePositionMap.put(70,55);
        snakePositionMap.put(52,42);
        snakePositionMap.put(25,2);
        snakePositionMap.put(95,72);
    }

    private static void playGame() {

        int currentPlayer = 1;
        while(true){
            Player player = playerMap.get(currentPlayer);
            int currentPosition = player.getCurrentPosition();

            int newPosition = calculatePlayerPosition(currentPosition, rollDice());

            if(isWin(newPosition)) {
                System.out.println(player.playerName + "Wins the game");
                break;
            }

            currentPlayer = currentPlayer == numberOfPlayers ? 1 : currentPlayer++;
        }
    }

    private static boolean isWin(int newPosition) {
        return newPosition==WIN_SPOT;
    }


    public static int rollDice(){
        int n=0;
        Random r = new Random();
         n = r.nextInt(7);
         return n==0? 1 : n;
    }

    static int calculatePlayerPosition(int currentPosition, int diceValue){

        int newPosition = currentPosition + diceValue;

        if (newPosition>WIN_SPOT){
            return currentPosition;
        }

        newPosition = snakeExist(newPosition);
        newPosition = ladderExist(newPosition);

        return newPosition;

    }

    static int snakeExist(int currentPosition){
        if(null!=snakePositionMap.get(currentPosition))
        {
            System.out.println("swallowed by snake");
            return snakePositionMap.get(currentPosition);
        }

        return currentPosition;
    }

    static int ladderExist(int currentPosition){
        if(null!=ladderPositionMap.get(currentPosition))
        {
            System.out.println("Climbed the ladder");
            return ladderPositionMap.get(currentPosition);
        }

        return currentPosition;
    }
}
