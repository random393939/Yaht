import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Graphics; 
public class Player{
        public final String RESET = "\u001B[0m";
        public final String BLACK = "\u001B[30m";
        public final String RED = "\u001B[31m";
        public final String GREEN = "\u001B[32m";
        public final String YELLOW = "\u001B[33m";
        public final String BLUE = "\u001B[34m";
        public final String PURPLE = "\u001B[35m";
        public final String CYAN = "\u001B[36m";
        public final String WHITE = "\u001B[37m";
        public String[] colors = {BLACK,RED,GREEN,YELLOW,BLUE,PURPLE,CYAN};
        private String name;
        private ArrayList<Integer> heldDice = new ArrayList<>();
        private ArrayList<Die> rollingDice;
        private ArrayList<String> ScoreSheet = new ArrayList<String>();
        private Run blah = new Run();
        private DicePrinter diePrint = new DicePrinter();
        private int diceAmount;


        public Player() {

                name = blah.getPlayerNames().get(0);
                heldDice = null;
                this.rollingDice = new ArrayList<>();
                ScoreSheet = null;
                diceAmount = 5;

        }

        public void playerTurn() {
                getNewDice();
                setRollingDice();
        }
        public ArrayList<Die> setRollingDice(){
                for(int r = 0; r < 1; r++){
                        //reroll
                        diePrint.print(rollingDice);
                        Scanner rollScanner = new Scanner(System.in);
                        System.out.print(BLACK+"\033[3mWould you like to reroll Y/N \033[0m"+RED+name+"? "+RESET);
                        String reroll = rollScanner.nextLine();
                        if(reroll.equalsIgnoreCase("y") ||reroll.equalsIgnoreCase("Y") || reroll.equalsIgnoreCase("yes") || reroll.equalsIgnoreCase("Yes")) {
                                //dice reroll amount
                                System.out.println("How many dice would you like to reroll " + name +"?");
                                int diceAmount = rollScanner.nextInt();
                                for(int i = 0; i < diceAmount; i++) {
                                        //dice to reroll
                                        System.out.println("What dice would you like to reroll " + name +"?");
                                        int rerolled = rollScanner.nextInt();
                                        for(int k = 0; k < diceAmount; k++) 
                                        {
                                                //reroll
                                                Die die = new Die();
                                                die.roll();
                                                rollingDice.set(rerolled-1,die);

                                        }

                                }

                        }
                        else {
                                System.out.println("keeping dice");
                        }
                }
                return rollingDice;
        }
        public void getNewDice() {
                for(int i = 0; i < diceAmount; i++) 
                {
                        Die die = new Die();
                        die.roll();
                        rollingDice.add(die);
                }
        }
        public void keepDice() {

        }
        public void updateScoreSheet() {
                
        }                  
}      