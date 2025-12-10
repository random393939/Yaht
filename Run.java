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
    private static String[] colors = {BLACK,RED,GREEN,YELLOW,BLUE,PURPLE,CYAN};


    public static void playerNames() {
        Scanner playerScanner = new Scanner(System.in);
        System.out.print("Enter number of players (max = 4 so far): ");
        int playerNum = playerScanner.nextInt();
        playerScanner.nextLine();

        //generate random colors 
        for(int i = 0; i < playerNum; i ++){
            String randColor = colors[(int) (Math.random() * 7) + 0];
            System.out.print(randColor + "Enter player #" + (i+1) + " name: "+RESET);
            String name = playerScanner.nextLine();
            playerNames.add(name);

        }
        for(int j = 0; j < playerNum; j++){
            Player p =  new Player();
            players.add(p);
        }
        Collections.shuffle(playerNames);
        System.out.println("Players: " + playerNames);
    }

    public ArrayList<String> getPlayerNames(){
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
            players.get(p).playerTurn();
        }
    }
    
    
    
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        yahtzeeLogo();
        playerNames();  
        playerCycle();
    }

}