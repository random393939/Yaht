import java.util.ArrayList;

public class DiePrinter {

    private static ArrayList<ArrayList<String>> makeDieFaces()
    {
        ArrayList<String> oneDie = new ArrayList<>() 
        {{
            add("┏━━━━━━━┓");
            add("┃       ┃");
            add("┃   ●   ┃");
            add("┃       ┃");
            add("┗━━━━━━━┛");
        }};

        ArrayList<String> twoDie = new ArrayList<>()
        {{
            add("┏━━━━━━━┓");
            add("┃ ●     ┃");
            add("┃       ┃");
            add("┃     ● ┃");
            add("┗━━━━━━━┛");
        }};

        ArrayList<String> threeDie = new ArrayList<>()
        {{
            add("┏━━━━━━━┓");
            add("┃ ●     ┃");
            add("┃   ●   ┃");
            add("┃     ● ┃");
            add("┗━━━━━━━┛");
        }};

        ArrayList<String> fourDie = new ArrayList<>()
        {{
            add("┏━━━━━━━┓");
            add("┃ ●   ● ┃");
            add("┃       ┃");
            add("┃ ●   ● ┃");
            add("┗━━━━━━━┛");
        }};

        ArrayList<String> fiveDie = new ArrayList<>()
        {{
            add("┏━━━━━━━┓");
            add("┃ ●   ● ┃");
            add("┃   ●   ┃");
            add("┃ ●   ● ┃");
            add("┗━━━━━━━┛");
        }};

        ArrayList<String> sixDie = new ArrayList<>()
        {{
            add("┏━━━━━━━┓");
            add("┃ ●   ● ┃");
            add("┃ ●   ● ┃");
            add("┃ ●   ● ┃");
            add("┗━━━━━━━┛");
        }};

        ArrayList<ArrayList<String>> dieFaces = new ArrayList<>()
        {{
            add(oneDie);
            add(twoDie);
            add(threeDie);
            add(fourDie);
            add(fiveDie);
            add(sixDie);
        }};

        return dieFaces;
    }

    public static void print(ArrayList<Die> dice)
    {

        ArrayList<ArrayList<String>> dieFaces = makeDieFaces();
        ArrayList<String> oneDie = dieFaces.get(0);
        int dieHeight = oneDie.size();
        int dieWidth = oneDie.get(0).length();
        String seperator = "  ";
        String posStarter = "";
        for(int i = 0; i < dieWidth/2; i++)
        {
            posStarter += " ";
        }
        String posEnder = "";
        for(int i = 1; i < dieWidth - dieWidth/2; i++)
        {
            posEnder += " ";
        }

        int place = 1;
        for(Die die : dice)
        {
            System.out.print(posStarter + place + posEnder + seperator);
            place += 1;
        }
        System.out.println();

        for(int i = 0; i < dieHeight; i++)
        {
            for(Die die : dice)
            {
                int dieIndex = die.getValue() - 1;
                String diePiece = dieFaces.get(dieIndex).get(i);
                System.out.print(diePiece + seperator);
            }
            System.out.println();
        }
    }

}
