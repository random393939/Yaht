import java.util.ArrayList;
import java.util.Scanner;

public class Player{
        private ArrayList<Integer> TEST = new ArrayList<>();
        private String name;
        private ArrayList<Integer> heldDice = new ArrayList<>();
        private ArrayList<Integer> rollingDice = new ArrayList<>();
        private ArrayList<String> ScoreSheet = new ArrayList<String>();


        public Player() {

                TEST = null;
                name = null;
                heldDice = null;
                rollingDice = null;
                ScoreSheet = null;

        }

        public void playerTurn() {

                Scanner rollScanner = new Scanner(System.in);
                System.out.println("Would you like to reroll Y/N" + name);
                String reroll = rollScanner.next();

                if(reroll == "y" || reroll == "Y" || reroll == "yes" || reroll == "Yes") {
                        System.out.println("How many dice would you like to reroll " + name +"?");
                        int diceAmount = rollScanner.nextInt();
                        for(int i = 0; i < diceAmount; i++) {
                                System.out.println("What Dice would you like to reroll " + name +"?");
                                int rerolled = rollScanner.nextInt();
                                rollingDice.add(rerolled);
                        }
                        rollScanner.close();
                }
                else if(reroll == "n" || reroll == "N" || reroll == "n" || reroll == "") {
                        
                }

                System.out.println(rollingDice);
        }
        public void getNewDice() {
                Die die = new Die();
                for(int i = 0; i < 5; i++) 
                {
                        die.roll();
                        rollingDice.add(die.getValue());
                        System.out.println(rollingDice);
                }
        }
        public void keepDice() {
        }
        public static void updateScoreSheet() {
                
        }                  
}      