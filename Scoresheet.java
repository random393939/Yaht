import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public class Scoresheet {

    private int threeOfAKind = -1;
    private int fourOfAKind = -1;
    private int fullHouse = -1;
    private int smallStraight = -1;
    private int largeStraight = -1;
    private int yahtzee = -1;
    private int chance = -1;
    private int bonus = -1;
    private boolean threeBoolean;
    private boolean fourBoolean;
    private boolean houseBoolean;
    private boolean smallBoolean;
    private boolean largeBoolean;
    private boolean yahtzeeBoolean;
    private boolean chanceBoolean;

    //vars for ai format 
    private static final int CARD_WIDTH = 32;
    final int TOTAL_LINES = 5;
    final String SEPARATOR = "  ";

    public boolean isComplete() {
        return threeBoolean && fourBoolean&& houseBoolean&& smallBoolean&& largeBoolean&& yahtzeeBoolean&& chanceBoolean;
    }

    //logic stuff
    //I searched up hashmap counting online to help with this part
    private int sumDice(ArrayList<Die> dice){
        int tempCountDice = 0;

        for (Die die: dice){
            tempCountDice = tempCountDice + die.getValue();
        }
        return tempCountDice;
    }

    public void setThreeOfAKind(ArrayList<Die> dice){
        if (threeBoolean) {
            return;
        }
        HashMap<Integer, Integer> counts = countDice(dice);
        for (int count : counts.values()) {
            if (count >=3) {
                threeOfAKind = sumDice(dice);
                threeBoolean = true;
                return;
            }
        }
        threeOfAKind = 0;
        threeBoolean = true;
    }
    public void setFourOfAKind(ArrayList<Die> dice){
        if (fourBoolean) {
            return;
        }
        HashMap<Integer, Integer> counts = countDice(dice);
        for (int count : counts.values()) {
            if (count >=4) {
                fourOfAKind = sumDice(dice);
                fourBoolean = true;
                return;
            }
        }
        fourOfAKind = 0;
        fourBoolean = true;
    }

    public void setFullHouse(ArrayList<Die> dice){
        if (houseBoolean == true) {
            return;
        }
        boolean hasTwo = false;
        boolean hasThree = false;
        HashMap<Integer, Integer> counts = countDice(dice);
        for (int counter_3 : counts.values()) {
            if (counter_3 == 2) hasTwo = true;
            if (counter_3 == 3) hasThree = true;
        }
        if (hasTwo && hasThree){
            fullHouse = 25;
        }
        else{
            fullHouse =  0;
        }
        houseBoolean = true;
    }
    public void setSmallStraight(ArrayList<Die> dice) {
        if (smallBoolean){
            return;
        } 
        smallStraight = 30;
        smallBoolean =true;
    }

    public void setLargeStraight(ArrayList<Die> dice) {
        if (largeBoolean == true) return;
        largeStraight = 40;
        largeBoolean = true;
    }

    public void setYahtzee(ArrayList<Die> dice){
        if (yahtzeeBoolean) {
            return;
        }
        HashMap<Integer, Integer> counts = countDice(dice);
        for (int counter4 : counts.values()) {
            if (counter4 == 5) {
                yahtzee = 50;
                yahtzeeBoolean = true;
                return;
            }
        }
        yahtzee = 0;
        yahtzeeBoolean = true;
    }
    private HashMap<Integer, Integer> countDice(ArrayList<Die> dice){
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (Die die :dice){
            int value = die.getValue();

            if (counts.containsKey(value)){
                counts.put(value, counts.get(value) + 1);
            }
            else{
                counts.put(value, 1);
            }

        }
        return counts;
    }
    public void setChance(ArrayList<Die> dice) {
        if (chanceBoolean == true){
            return;
        }
        chance = sumDice(dice);
        chanceBoolean = true;
    }


    //AI formatting
    private String pad(String s) {
        return String.format("%-" + CARD_WIDTH + "s", s);
    }
    public String getScoreSheetLine(int line, String playerName) {
        String name = playerName.length() > 10
                ? playerName.substring(0, 10)
                : String.format("%-10s", playerName);

        switch (line) {
            case 0:
                return pad("╔════════ " + name + " ════════╗");
            case 1:
                return pad(String.format(
                    "│ 3K:%3s 4K:%3s FH:%3s │",
                    threeOfAKind == -1 ? "-" : threeOfAKind,
                    fourOfAKind == -1 ? "-" : fourOfAKind,
                    fullHouse == -1 ? "-" : fullHouse
                ));
            case 2:
                return pad(String.format(
                    "│ SS:%3s LS:%3s Y:%3s │",
                    smallStraight == -1 ? "-" : smallStraight,
                    largeStraight == -1 ? "-" : largeStraight,
                    yahtzee == -1 ? "-" : yahtzee
                ));
            case 3:
                return pad(String.format(
                    "│ CH:%3s  TOT:%3d │",
                    chance == -1 ? "-" : chance,
                    getTotalScore()
                ));
            case 4:
                return pad("╚════════════════════════════╝");
            default:
                return pad("");
        }
    }
    //AI formatting
    public static void printScoreCard(
        String playerName,
        int ones, int twos, int threes, int fours, int fives, int sixes,
        int upperTotal, int bonus,
        int threeKind, int fourKind, int fullHouse,
        int smallStraight, int largeStraight,
        int yahtzee, int chance,
        int lowerTotal, int grandTotal
        ) {
            System.out.println("╔══════════════════════════════════╗");
            System.out.printf ("║         SCORE CARD (%-10s) ║%n", playerName);
            System.out.println("╠══════════════ Upper ═════════════╣");
            System.out.printf ("║ Ones          : %3s              ║%n", ones == -1 ? "-" : ones);
            System.out.printf ("║ Twos          : %3s              ║%n", twos == -1 ? "-" : twos);
            System.out.printf ("║ Threes        : %3s              ║%n", threes == -1 ? "-" : threes);
            System.out.printf ("║ Fours         : %3s              ║%n", fours == -1 ? "-" : fours);
            System.out.printf ("║ Fives         : %3s              ║%n", fives == -1 ? "-" : fives);
            System.out.printf ("║ Sixes         : %3s              ║%n", sixes == -1 ? "-" : sixes);
            System.out.println("╠══════════════════════════════════╣");
            System.out.printf ("║ Upper Total   : %3d              ║%n", upperTotal);
            System.out.printf ("║ Bonus         : %3s              ║%n", bonus == -1 ? "-" : bonus);

            System.out.println("╠══════════════ Lower ═════════════╣");
            System.out.printf ("║ 3 of a Kind   : %3s              ║%n", threeKind == -1 ? "-" : threeKind);
            System.out.printf ("║ 4 of a Kind   : %3s              ║%n", fourKind == -1 ? "-" : fourKind);
            System.out.printf ("║ Full House    : %3s              ║%n", fullHouse == -1 ? "-" : fullHouse);
            System.out.printf ("║ Small Straight: %3s              ║%n", smallStraight == -1 ? "-" : smallStraight);
            System.out.printf ("║ Large Straight: %3s              ║%n", largeStraight == -1 ? "-" : largeStraight);
            System.out.printf ("║ Yahtzee       : %3s              ║%n", yahtzee == -1 ? "-" : yahtzee);
            System.out.printf ("║ Chance        : %3s              ║%n", chance == -1 ? "-" : chance);

            System.out.println("╠══════════════════════════════════╣");
            System.out.printf ("║ Lower Total   : %3d              ║%n", lowerTotal);
            System.out.println("╠══════════════════════════════════╣");
            System.out.printf ("║ GRAND TOTAL   : %3d              ║%n", grandTotal);
            System.out.println("╚══════════════════════════════════╝");
        }

    public int getTotalScore() {
    int tempCount = 0;
        if (threeOfAKind!= -1){
            tempCount += threeOfAKind;
        } 
        if (fourOfAKind!= -1) {
             tempCount += fourOfAKind;
        }
        if (fullHouse!= -1) {
            tempCount += fullHouse;
        }
        if (smallStraight!= -1) {
            tempCount += smallStraight;
        }
        if (largeStraight!= -1) {
            tempCount += largeStraight;
        }
        if (yahtzee!= -1) {
            tempCount += yahtzee;
        }
        if (chance!= -1) {
            tempCount += chance;
        }
        if (bonus!= -1) {
            tempCount += bonus;
        }
        return tempCount;
    }
}


