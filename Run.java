import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.awt.Color;
import java.awt.Graphics; 


public class Run {
    //player stuff
    private static ArrayList<Player> players = new ArrayList<>();
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
        for (int i = 0; i < playerNum; i++) {
            String randColor = colors[(int)(Math.random() * 6)];
            System.out.print(randColor + "enter player #" + (i + 1) + " name: " + RESET);
            String name = playerScanner.nextLine();
            Player player = new Player(name); 
            player.setName(name);
            player.setColor(randColor);
            players.add(player);
        }

        Collections.shuffle(players); 
        terminalReset();
    }


    //text to ASCI font logo
    public static void yahtzeeLogo() {
        terminalReset();
        System.out.println(BLACK +"$$\\     $$\\         $$\\        $$\\                                   \r\n" + //
                        "\\$$\\   $$  |        $$ |       $$ |                                  \r\n" + //
                        " \\$$\\ $$  /$$$$$$\\  $$$$$$$\\ $$$$$$\\   $$$$$$$$\\  $$$$$$\\   $$$$$$\\  \r\n" + //
                        "  \\$$$$  / \\____$$\\ $$  __$$\\\\_$$  _|  \\____$$  |$$  __$$\\ $$  __$$\\ \r\n" + //
                        "   \\$$  /  $$$$$$$ |$$ |  $$ | $$ |      $$$$ _/ $$$$$$$$ |$$$$$$$$ |\r\n" + //
                        "    $$ |  $$  __$$ |$$ |  $$ | $$ |$$\\  $$  _/   $$   ____|$$   ____|\r\n" + //
                        "    $$ |  \\$$$$$$$ |$$ |  $$ | \\$$$$  |$$$$$$$$\\ \\$$$$$$$\\ \\$$$$$$$\\ \r\n" + //
                        "    \\__|   \\_______|\\__|  \\__|  \\____/ \\________| \\_______| \\_______|\r\n" + //
                        "                                                                     \r\n" + //
                        "                                                                     \r\n" + //
                        "                                                                     "+ RESET);
    } 
    public static boolean winnersCheck() {
        for (Player player : players) {
            if (!player.getScoresheet().isComplete()) {
                return false; 
            }
        }
        return true; 
    }
    //AI function to print all players' scoresheets horizontally
    public static void printAllScoreSheetsHorizontal() {
        if (players.isEmpty()) {
            return;
        }

        // Assuming 4 lines per scoresheet (from the new Scoresheet method)
        final int TOTAL_LINES = 4;
        final String SEPARATOR = "    "; // 4 spaces between sheets

        // Iterate through each line number (Line 0 of all players, Line 1 of all players, etc.)
        for (int i = 0; i < TOTAL_LINES; i++) {
            StringBuilder sb = new StringBuilder();
            
            // For each line number, iterate through every player
            for (Player player : players) {
                // Get the specific line for the current player
                sb.append(player.getScoresheet().getScoreSheetLine(i, player.getName()));
                sb.append(SEPARATOR);
            }
            
            // Print the merged line
            System.out.println(sb.toString());
        }
    }
    
    public static void playerCycle() {
        while (true) {
            for (Player player : players) {
                player.playerTurn();
                terminalReset();
                System.out.println(CYAN + "\033[3mnext players turn\033[0m" + RESET);
            }
            if (winnersCheck()) {
                break;
            }
        }
    }
    public static void terminalReset() {
        //resest terminal
        System.out.print("\033[H\033[2J");
    }
    public void terminalResetNonStatic() {
        //resest terminal (non static version)
        System.out.print("\033[H\033[2J");
    }
    
    
    public static void main(String[] args) {
        //game
        yahtzeeLogo();
        playerNames(); 
        playerCycle();

    }

}