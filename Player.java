import java.util.ArrayList;
import java.util.Scanner;

public class Player{
        private ArrayList<Integer> TEST = new ArrayList<>();
        private String name;
        private ArrayList<Integer> heldDice = new ArrayList<>();
        private ArrayList<Die> rollingDice;
        private ArrayList<String> ScoreSheet = new ArrayList<String>();
        private Run blah = new Run();


        public Player() {

                TEST = null;
                name = blah.getPlayerNames().get(0);
                heldDice = null;
                this.rollingDice = new ArrayList<>();
                ScoreSheet = null;

        }

        public void playerTurn() {
                getNewDice();
                Scanner rollScanner = new Scanner(System.in);
                System.out.println("Would you like to reroll Y/N " + name);
                String reroll = rollScanner.nextLine();

                if(reroll == "y" || reroll == "Y" || reroll == "yes" || reroll == "Yes") {
                        System.out.println("How many dice would you like to reroll " + name +"?");
                        int diceAmount = rollScanner.nextInt();
                        for(int i = 0; i < diceAmount; i++) {
                                System.out.println("What Dice would you like to reroll " + name +"?");
                                int rerolled = rollScanner.nextInt();
                                //
                        }
                        rollScanner.close();
                }
                else if(reroll == "n" || reroll == "N" || reroll == "n" || reroll == "") {
                        
                }

                System.out.println(rollingDice);
        }
        public void getNewDice() {
                Die die = new Die();
                DiePrinter diePrint = new DiePrinter();
                for(int i = 0; i < 5; i++) 
                {
                        die.roll();
                        rollingDice.add(die);
                        diePrint.printDie(die.getValue());
                }
                
        }
        public void keepDice() {
        }
        public static void updateScoreSheet() {
                
        }                  
}      