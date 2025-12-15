import java.util.ArrayList;

public class Scoresheet {
    private int tops;
    private int threeOfAKind;
    private int fourOfAKind;
    private int fullHouse;
    private int smallStraight;
    private int largeStraight;
    private int yahtzee;
    private int chance;
    private int bonus;
    private int topTotal;
    private int bottomTotal;
    private int totalScore;

    public Scoresheet() {
        this.tops = -1;
        this.threeOfAKind = -1;
        this.fourOfAKind = -1;
        this.fullHouse = -1;
        this.smallStraight = -1;
        this.largeStraight = -1;
        this.yahtzee = -1;
        this.chance = -1;
        this.bonus = -1;
        this.topTotal = 0;
        this.bottomTotal = 0;
        this.totalScore = 0;

    }
    public void setUpperScore(int value) {

    } 
    public void setThreeOfAKind() {

    }   
    public void setFourOfAKind(ArrayList<Die> dice) {

    }   
    public void setFullHouse(ArrayList<Die> dice) {

    }   
    public void setSmallStraight(ArrayList<Die> dice) {

    }   
    public void setLargeStraight(ArrayList<Die> dice) {

    }   
    public void setYahtzee(ArrayList<Die> dice) {

    }   
    public void setChance(ArrayList<Die> dice) {

    }   
    public void setTopTotal() {

    }   
    public void setBottomTotal() {

    }   
    //AI function to print scoresheet
    public void printScoreSheet() {
        System.out.println("╭────────SCORE SHEET─────────╮");
        System.out.println("    Upper Section:");
        System.out.println("    Tops: " + (tops == -1 ? "-" : tops));
        System.out.println("    Bonus: " + (bonus == -1 ? "-" : bonus));
        System.out.println("    Lower Section:");
        System.out.println("    3 of a Kind: " + (threeOfAKind == -1 ? "-" : threeOfAKind));
        System.out.println("    4 of a Kind: " + (fourOfAKind == -1 ? "-" : fourOfAKind));
        System.out.println("    Full House: " + (fullHouse == -1 ? "-" : fullHouse));
        System.out.println("    Small Straight: " + (smallStraight == -1 ? "-" : smallStraight));
        System.out.println("    Large Straight: " + (largeStraight == -1 ? "-" : largeStraight));
        System.out.println("    Yahtzee: " + (yahtzee == -1 ? "-" : yahtzee));
        System.out.println("    Chance: " + (chance == -1 ? "-" : chance));
        System.out.println();

        System.out.println("    TOTAL SCORE: " + getTotalScore());
        System.out.println("╰────────────────────────────╯");
    }
    //AI function to calculate total score
    public int getTotalScore() {
        int total = 0;
        total += (tops == -1 ? 0 : tops);
        total += (threeOfAKind == -1 ? 0 : threeOfAKind);
        total += (fourOfAKind == -1 ? 0 : fourOfAKind);
        total += (fullHouse == -1 ? 0 : fullHouse);
        total += (smallStraight == -1 ? 0 : smallStraight);
        total += (largeStraight == -1 ? 0 : largeStraight);
        total += (yahtzee == -1 ? 0 : yahtzee);
        total += (chance == -1 ? 0 : chance);
        total += (bonus == -1 ? 0 : bonus);
        return total;
    }
}

