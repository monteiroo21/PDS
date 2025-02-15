import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WSGenerator {
    public static void main(String[] args) {

        if (!validInput(args)) {
            System.exit(1);
        }

        ArrayList<String> all_words = new ArrayList<>();

        try {
            all_words = openFile(args[1]);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
            System.exit(1);
        }

        int max_size = 0;
        for (String word : all_words) {
            if (word.length() > max_size) {
                max_size = word.length();
            }
        }

        if (max_size > Integer.parseInt(args[3])) {
            System.out.println("Invalid size!");
            System.exit(1);
        }

        generatePuzzle(all_words, Integer.parseInt(args[3]), args[5]);

    }

    public static boolean validInput(String[] input) {
        if ((input.length != 6) || !((Integer.parseInt(input[3]) < 40) && (Integer.parseInt(input[3]) > 1)) ||
                (!input[0].equals("-i") || (!input[2].equals("-s")))) {
            System.out.println("Invalid input!");
            return false;
        }
        return true;
    }

    public static ArrayList<String> openFile(String filename) throws FileNotFoundException {

        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        ArrayList<String> all_words = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split("[;,\\s]+");
            for (String word : words) {
                if (!word.matches(".*[a-z].*") || !word.matches("[a-zA-Z]+")) {
                    System.out.println("Invalid word");
                    System.exit(1);
                } else {
                    all_words.add(word);
                }
            }
        }
        scanner.close();
        return all_words;
    }

    public static void generatePuzzle(ArrayList<String> all_words, int size, String outputFile) {

        String[][] puzzle = new String[size][size];

        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (String word : all_words) {
            int word_size = word.length();

            boolean canPlaceWord = false;

            while (!canPlaceWord) {
                int row = (int) (Math.random() * size);
                int col = (int) (Math.random() * size);
                int direction = (int) (Math.random() * 8);

                canPlaceWord = true;

                // Check if the word can be placed in the chosen direction
                for (int i = 0; i < word_size; i++) {
                    int newRow = row + i * dx[direction];
                    int newCol = col + i * dy[direction];

                    if (newRow < 0 || newRow >= size || newCol < 0 || newCol >= size
                            || puzzle[newRow][newCol] != null) {
                        canPlaceWord = false;
                        break;
                    }
                }

                // If the word can be placed, place it
                if (canPlaceWord) {
                    for (int i = 0; i < word_size; i++) {
                        int newRow = row + i * dx[direction];
                        int newCol = col + i * dy[direction];
                        puzzle[newRow][newCol] = word.substring(i, i + 1);
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (puzzle[i][j] == null) {
                    puzzle[i][j] = Character.toString((char) (Math.random() * 26 + 97));
                }
            }
        }

        try {
            File file = new File(outputFile);
            file.createNewFile();
            java.io.PrintWriter output = new java.io.PrintWriter(file);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    output.print(puzzle[i][j].toUpperCase() + "");
                }
                output.println(" ");
            }

            for (String word : all_words) {
                output.println(word);
            }

            output.close();
        } catch (Exception e) {
            System.out.println("Error writing to file");
            e.printStackTrace();
        }
    }
}
