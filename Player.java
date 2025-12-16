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
        private String color;
        private String name;
        private int diceAmount;
        private ArrayList<Die> rollingDice;
        private Run placeholder;
        private Scoresheet scoresheet;
        private DicePrinter diePrint;

        public Player(String name) {

                this.name = null;
                this.diceAmount = 5;
                this.diePrint = new DicePrinter();
                this.rollingDice = new ArrayList<>();
                this.scoresheet = new Scoresheet(); 
                this.placeholder = new Run();

        }
        public Scoresheet getScoresheet() {
                return scoresheet;
        }
        public String getName() {
                return name;
        }
        public void setName(String n){
                this.name = n;
        }
        public void setColor(String c) {
                this.color = c;
        }
        public void playerTurn() {
                rollingDice.clear();
                getNewDice();
                setRollingDice();
        }
        public ArrayList<Die> setRollingDice(){
                System.out.println( color + name + "'s" + " turn" +RESET);
                diePrint.print(rollingDice);
                Run.printAllScoreSheetsHorizontal();

                for(int r = 0; r < 2; r++){
                        //reroll

                        Scanner rollScanner = new Scanner(System.in);
                        System.out.print( "\033[3mWould you like to reroll Y/N \033[0m" + color + name+" " + RESET +"? ");
                        String reroll = rollScanner.nextLine(); 
                        if (reroll.equalsIgnoreCase("y") || reroll.equalsIgnoreCase("yes")) { 
                                placeholder.terminalResetNonStatic();
                                System.out.println(GREEN +"rerolling..."+ RESET);
                                diePrint.print(rollingDice);
                                Run.printAllScoreSheetsHorizontal();
                                System.out.print("how many dice would you like to reroll: "+ color + name + RESET + "? ");
                                int diceAmount = rollScanner.nextInt();
                                rollScanner.nextLine(); 
                                for (int i = 0; i < diceAmount; i++) {
                                        System.out.print("which die would you like to reroll " + name + "? ");
                                        int rerolledIndex = rollScanner.nextInt();
                                        placeholder.terminalResetNonStatic();
                                        rollingDice.get(rerolledIndex-1).roll();
                                        System.out.println(BLACK+"Die #" + rerolledIndex + " has been rerolled - "+ color + name + RESET);
                                        diePrint.print(rollingDice);
                                        Run.printAllScoreSheetsHorizontal();
                                }
                        }
                        else {
                                keepDice();
                                break;
                        }
                        
                }
                updateScoreSheet();
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
                placeholder.terminalResetNonStatic();
                System.out.println(GREEN +"keeping dice"+ RESET);
                diePrint.print(rollingDice);
        }
        public void updateScoreSheet() {
                Run.printAllScoreSheetsHorizontal();
                System.out.println(BLACK + "keywords for placing score (three of a kind, four of a kind, full house, small straight, large straight, yahtzee, chance)" + RESET);
                Scanner scoreScanner = new Scanner(System.in);
                System.out.print("where would you like to place your score " + color + name + RESET + "? ");
                String scoreChoice = scoreScanner.nextLine(); 
                        if (scoreChoice.equalsIgnoreCase("three of a kind")) {
                                scoresheet.setThreeOfAKind(rollingDice);
                        }
                        else if (scoreChoice.equalsIgnoreCase("four of a kind")) {
                                scoresheet.setFourOfAKind(rollingDice);
                        }
                        else if (scoreChoice.equalsIgnoreCase("full house")) {
                                scoresheet.setFullHouse(rollingDice);
                        }
                        else if (scoreChoice.equalsIgnoreCase("small straight")) {
                                scoresheet.setSmallStraight(rollingDice);
                        }
                        else if (scoreChoice.equalsIgnoreCase("large straight")) {
                                scoresheet.setLargeStraight(rollingDice);
                        }
                        else if (scoreChoice.equalsIgnoreCase("yahtzee")) {
                                scoresheet.setYahtzee(rollingDice);
                        }
                        else if (scoreChoice.equalsIgnoreCase("chance")) {
                                scoresheet.setChance(rollingDice);
                        }
        }                  
}      