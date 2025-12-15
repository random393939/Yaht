import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.awt.Color;
import java.awt.Graphics; 


public class Run {
    private static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<String> playerNames = new ArrayList<String>();
    //imported colors from ANSI
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    private static String[] colors = {RED,GREEN,YELLOW,BLUE,PURPLE,CYAN};


    public static void playerNames() {
        Scanner playerScanner = new Scanner(System.in);
        System.out.print("enter number of players: ");
        int playerNum = playerScanner.nextInt();
        playerScanner.nextLine();
        System.out.println(BLACK + "(players start in random order) " + RESET);
        //generate random colors 
        for(int i = 0; i < playerNum; i ++){

            String randColor = colors[(int) (Math.random() * 6) + 0];
            System.out.print(randColor + "enter player #" + (i+1) + " name: "+RESET);
            String playerName = playerScanner.nextLine();
            playerNames.add(playerName);
            Player newPlayer = new Player();
            newPlayer.setColor(randColor);
            players.add(newPlayer);

        }
        Collections.shuffle(playerNames);
        System.out.println("Players: " + playerNames);
        
    }

    public ArrayList<String> getPlayerNames() { 
        return playerNames;
    }

    public static void yahtzeeLogo() {
        System.out.println(BLACK+"$$\\     $$\\         $$\\        $$\\                                   \r\n" + //
                        "\\$$\\   $$  |        $$ |       $$ |                                  \r\n" + //
                        " \\$$\\ $$  /$$$$$$\\  $$$$$$$\\ $$$$$$\\   $$$$$$$$\\  $$$$$$\\   $$$$$$\\  \r\n" + //
                        "  \\$$$$  / \\____$$\\ $$  __$$\\\\_$$  _|  \\____$$  |$$  __$$\\ $$  __$$\\ \r\n" + //
                        "   \\$$  /  $$$$$$$ |$$ |  $$ | $$ |      $$$$ _/ $$$$$$$$ |$$$$$$$$ |\r\n" + //
                        "    $$ |  $$  __$$ |$$ |  $$ | $$ |$$\\  $$  _/   $$   ____|$$   ____|\r\n" + //
                        "    $$ |  \\$$$$$$$ |$$ |  $$ | \\$$$$  |$$$$$$$$\\ \\$$$$$$$\\ \\$$$$$$$\\ \r\n" + //
                        "    \\__|   \\_______|\\__|  \\__|  \\____/ \\________| \\_______| \\_______|\r\n" + //
                        "                                                                     \r\n" + //
                        "                                                                     \r\n" + //
                        "                                                                     ");
                        System.out.print(RESET);
    } 
    public static void playerCycle() {
        for (int p = 0; p < players.size(); p++) {
            players.get(p).setName(playerNames.get(p));
            (players.get(p)).playerTurn();
            terminalReset();
            System.out.println(CYAN + "\033[3m next players turn \033[0m" + RESET);
        }
    }
    public static void terminalReset() {
        //resest terminal
        System.out.print("\033[H\033[2J");
    }
    public void terminalResetnv() {
        //resest terminal
        System.out.print("\033[H\033[2J");
    }
    
    
    public static void main(String[] args) {
        //game
        terminalReset();
        yahtzeeLogo();
        playerNames(); 
        terminalReset(); 
        playerCycle();
        terminalReset();
    
    }

}