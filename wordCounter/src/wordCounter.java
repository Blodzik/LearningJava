import java.util.Scanner;

public class wordCounter {
    public static int countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] words = input.trim().split("\\s+");

        return words.length;
    }

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence or paragraph: ");
        String input = scanner.nextLine();

        int wordCount = countWords(input);
        System.out.println("Word count: " + wordCount);

        scanner.close();
    }
}
