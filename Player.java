import java.util.ArrayList;
import java.util.Scanner;

public class Player{
        private String name;
        private ArrayList<Integer> heldDice = new ArrayList<>();
        private ArrayList<Die> rollingDice;
        private ArrayList<String> ScoreSheet = new ArrayList<String>();
        private int diceAmount;
        private Run blah = new Run();
        private DicePrinter diePrint = new DicePrinter();


        public Player() {

                name = blah.getPlayerNames().get(0);
                heldDice = null;
                this.rollingDice = new ArrayList<>();
                ScoreSheet = null;
                diceAmount = 5;

        }

        public void playerTurn() {
                getNewDice();
                Scanner rollScanner = new Scanner(System.in);
                for(int r = 0; r < 3; r++){
                        System.out.print("Would you like to reroll Y/N " + name +"? ");
                        String reroll = rollScanner.nextLine();
                        if(reroll.equalsIgnoreCase("y") ||reroll.equalsIgnoreCase("Y") || reroll.equalsIgnoreCase("yes") || reroll.equalsIgnoreCase("Yes")) {
                                System.out.println("How many dice would you like to reroll " + name +"?");
                                diceAmount = rollScanner.nextInt();
                                for(int i = 0; i < diceAmount; i++) {
                                        System.out.println("What Dice would you like to reroll " + name +"?");
                                        int rerolled = rollScanner.nextInt();
                                        rollingDice.remove((rerolled-1));
                                        getNewDice();
                                }

                        }
                        else if(reroll.equalsIgnoreCase("n") || reroll.equalsIgnoreCase("N") || reroll.equalsIgnoreCase("no") || reroll.equalsIgnoreCase("No")) {
                                System.out.print("TEST_F");
                        }
                }
        }
        public void getNewDice() {
                for(int i = 0; i < diceAmount; i++) 
                {
                        Die die = new Die();
                        die.roll();
                        rollingDice.add(die);
                }
                diePrint.print(rollingDice);
        }
        public void keepDice() {

        }
        public static void updateScoreSheet() {
                
        }                  
}      