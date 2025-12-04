public class DiePrinter {

    private static final String[] DICE = {
        """
        ╭─────────╮
        │         │
        │    ●    │
        │         │
        ╰─────────╯
        """,
        """
        ╭─────────╮
        │ ●       │
        │         │
        │       ● │
        ╰─────────╯
        """,
        """
        ╭─────────╮
        │ ●       │
        │    ●    │
        │       ● │
        ╰─────────╯
        """,
        """
        ╭─────────╮
        │ ●     ● │
        │         │
        │ ●     ● │
        ╰─────────╯
        """,
        """
        ╭─────────╮
        │ ●     ● │
        │    ●    │
        │ ●     ● │
        ╰─────────╯
        """,
        """
        ╭─────────╮
        │ ●     ● │
        │ ●     ● │
        │ ●     ● │
        ╰─────────╯
        """
    };

    // Simple function to print a die
    public static void printDie(int number) {
        System.out.println(DICE[number - 1]);
    }

    // Example usage
    public static void main(String[] args) {
        printDie(1); // prints die 1
        printDie(5); // prints die 5
    }
}
