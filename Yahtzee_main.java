import java.util.ArrayList;
import java.util.Scanner;

public class Yahtzee_main {
    private static ArrayList<String> playerNames = new ArrayList<>(); 
    public static void Yahtzee_setup() { 

        Scanner playerNumbScanner = new Scanner(System.in);
        System.out.println("Enter number of players: ");
        int playerNum = playerNumbScanner.nextInt();
        playerNumbScanner.close();

        for(int i = 0; i < playerNum; i ++){
            Scanner playerScanner = new Scanner(System.in);
            System.out.print("Enter player name: ");
            String name = playerScanner.nextLine();
            System.out.println("");
            playerNames.add(name);
            playerScanner.close();
        }
    System.out.println(playerNames);
    }
    public static void main(){


    }
    public static void main(String args[]) {
        Yahtzee_setup();
}

}
