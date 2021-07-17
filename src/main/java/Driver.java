import java.util.Scanner;

public class Driver {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Necessary letter: ");
        char necessaryChar = scanner.next().toCharArray()[0];

        System.out.print("Other letters: ");
        char[] allChars = (scanner.next() + necessaryChar).toCharArray();

        PuzzleSolver puzzleSolver = new PuzzleSolver(necessaryChar, allChars);

        int wordListNumber;
        while (true) {
            System.out.print("Which word list to used (1. Full Dictionary | 2. Most Frequent 10,000 Used Words): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input, please enter 1 or 2");
                scanner.next();
            }
            else {
                wordListNumber = scanner.nextInt();
                if (wordListNumber != 1 && wordListNumber != 2) {
                    System.out.println("Invalid input, please enter 1 or 2");
                }
                else {
                    break;
                }
            }
        }

        puzzleSolver.solve(wordListNumber);




    }
}
