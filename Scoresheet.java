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

    private boolean bonusBoolean;
    private boolean threeBoolean;
    private boolean fourBoolean;
    private boolean houseBoolean;
    private boolean smallBoolean;
    private boolean largeBoolean;
    private boolean yahtzeeBoolean;
    private boolean chanceBoolean;
    

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

        this.bonusBoolean = false;
        this.threeBoolean = false;
        this.fourBoolean = false;
        this.houseBoolean = false;
        this.smallBoolean = false;
        this.largeBoolean = false;
        this.yahtzeeBoolean = false;
        this.chanceBoolean = false;


    }
    public void setUpperScore(int value) {
    } 

    public void setThreeOfAKind() {
        threeBoolean = true;
    }   
    public void setFourOfAKind(ArrayList<Die> dice) {
        fourBoolean = true;
    }   
    public void setFullHouse(ArrayList<Die> dice) {
        houseBoolean = true;
    }   
    public void setSmallStraight(ArrayList<Die> dice) {
        largeBoolean = true;
    }   
    public void setLargeStraight(ArrayList<Die> dice) {
        bonusBoolean = true;
    }   
    public void setYahtzee(ArrayList<Die> dice) {
        yahtzeeBoolean = true;
    }   
    public void setChance(ArrayList<Die> dice) {
        chanceBoolean = true;
    }   
    public void setTopTotal() {

    }   
    public void setBottomTotal() {

    }   

    //Ai for set and get for time (same function)
    public boolean isBonus() {
        return bonusBoolean;
    }

    public boolean isThree() {
        return threeBoolean;
    }

    public boolean isFour() {
        return fourBoolean;
    }

    public boolean isHouse() {
        return houseBoolean;
    }

    public boolean isSmall() {
        return smallBoolean;
    }

    public boolean isLarge() {
        return largeBoolean;
    }

    public boolean isYahtzee() {
        return yahtzeeBoolean;
    }

    public boolean isChance() {
        return chanceBoolean;
    }
    
    public void setBonusBol(boolean bonusBoolean) {
        this.bonusBoolean = bonusBoolean;
    }

    public void setThreeBol(boolean threeBoolean) {
        this.threeBoolean = threeBoolean;
    }

    public void setFourBol(boolean fourBoolean) {
        this.fourBoolean = fourBoolean;
    }

    public void setHouseBol(boolean houseBoolean) {
        this.houseBoolean = houseBoolean;
    }

    public void setSmallBol(boolean smallBoolean) {
        this.smallBoolean = smallBoolean;
    }

    public void setLargeBol(boolean largeBoolean) {
        this.largeBoolean = largeBoolean;
    }

    public void setYahtzeeBol(boolean yahtzeeBoolean) {
        this.yahtzeeBoolean = yahtzeeBoolean;
    }

    public void setChanceBol(boolean chanceBoolean) {
        this.chanceBoolean = chanceBoolean;
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

