import java.util.ArrayList;

public class DicePrinter {

    // Final fields to store the ASCII art for the six faces using your preferred symbols
    private final ArrayList<String> oneDie = new ArrayList<>();
    private final ArrayList<String> twoDie = new ArrayList<>();
    private final ArrayList<String> threeDie = new ArrayList<>();
    private final ArrayList<String> fourDie = new ArrayList<>();
    private final ArrayList<String> fiveDie = new ArrayList<>();
    private final ArrayList<String> sixDie = new ArrayList<>();
    private final ArrayList<ArrayList<String>> dieFaces = new ArrayList<>();
    
    public DicePrinter()
    {
        // Initialize Die Faces using the requested symbols
        
        this.oneDie.add("╭─────────╮");
        this.oneDie.add("│         │");
        this.oneDie.add("│    ●    │");
        this.oneDie.add("│         │");
        this.oneDie.add("╰─────────╯");

        this.twoDie.add("╭─────────╮");
        this.twoDie.add("│ ●       │");
        this.twoDie.add("│         │");
        this.twoDie.add("│       ● │");
        this.twoDie.add("╰─────────╯");

        this.threeDie.add("╭─────────╮");
        this.threeDie.add("│ ●       │");
        this.threeDie.add("│    ●    │");
        this.threeDie.add("│       ● │");
        this.threeDie.add("╰─────────╯");

        this.fourDie.add("╭─────────╮");
        this.fourDie.add("│ ●     ● │");
        this.fourDie.add("│         │");
        this.fourDie.add("│ ●     ● │");
        this.fourDie.add("╰─────────╯");

        this.fiveDie.add("╭─────────╮");
        this.fiveDie.add("│ ●     ● │");
        this.fiveDie.add("│    ●    │");
        this.fiveDie.add("│ ●     ● │");
        this.fiveDie.add("╰─────────╯");

        this.sixDie.add("╭─────────╮");
        this.sixDie.add("│ ●     ● │");
        this.sixDie.add("│ ●     ● │");
        this.sixDie.add("│ ●     ● │");
        this.sixDie.add("╰─────────╯");

        this.dieFaces.add(oneDie);
        this.dieFaces.add(twoDie);
        this.dieFaces.add(threeDie);
        this.dieFaces.add(fourDie);
        this.dieFaces.add(fiveDie);
        this.dieFaces.add(sixDie);
    }

    public void print(ArrayList<Die> dice)
    {
        if (oneDie.isEmpty() || oneDie.get(0).isEmpty()) return;

        int dieHeight = oneDie.size();
        int dieWidth = oneDie.get(0).length();
        String seperator = "  ";
        
        // --- 1. Print Die Position Numbers (1, 2, 3, ...) Centered ---
        int posStarterLength = dieWidth / 2;
        
        int place = 1;
        for(Die die : dice)
        {
            String placeStr = String.valueOf(place);
            int numLength = placeStr.length();
            
            int adjustedEnderLength = dieWidth - posStarterLength - numLength; 
            
            String posStarter = " ".repeat(posStarterLength);
            String posEnder = " ".repeat(adjustedEnderLength);
            
            System.out.print(posStarter + placeStr + posEnder + seperator);
            place += 1;
        }
        System.out.println(); 

        // --- 2. Print Die Faces Line by Line (Horizontal Print) ---
        for(int i = 0; i < dieHeight; i++)
        {
            for(Die die : dice)
            {
                // **Crucially, this uses the unique, independent value of each Die object**
                int dieIndex = die.getValue() - 1;
                
                String diePiece = (dieFaces.get(dieIndex).get(i));
                
                System.out.print(diePiece + seperator);
            }
            System.out.println();
        }
    }
}