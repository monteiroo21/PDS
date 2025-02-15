import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordSearchGenerator {
    private static final Random random = new Random();

    public static void main(String[] args) {
        List<String> wordsKey = new ArrayList<>();
        int size = 0;
        String iFile = "", oFile = "";

        // validaçao dos argumentos
        if (args.length < 4) {
            System.err.println("Usage: java WordSearchGenerator -i <input file> -s <size> [-o <output file>]");
            System.exit(1);
        }

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-i":
                    iFile = args[i + 1];
                    break;
                case "-s":
                    size = Integer.parseInt(args[i + 1]);
                    break;
                case "-o":
                    oFile = args[i + 1];
                    break;
                default:
                    System.err.println("Unknown argument: " + args[i]);
                    System.exit(1);
            }
        }

        if (oFile.isEmpty()) {
            oFile = iFile.replace(".txt", "") + "_result.txt";
        }

        // ler aspalavras do ifile
        try (Scanner sc = new Scanner(new File(iFile))) {
            while (sc.hasNextLine()) {
                String[] words = sc.nextLine().split("[, ;]+");
                for (String word : words) {
                    if (word.length() >= 3) {
                        wordsKey.add(word.toUpperCase());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + iFile);
            System.exit(1);
        }

        // Sort words by length in descending order for better placement
        wordsKey.sort(Comparator.comparingInt(String::length).reversed());

        // Generate puzzle
        char[][] puzzle = new char[size][size];
        initializePuzzle(puzzle);
        placeWordsInPuzzle(puzzle, wordsKey);
        fillEmptySpaces(puzzle);

        // Output puzzle
        try (PrintWriter out = new PrintWriter(oFile)) {
            outputPuzzle(puzzle, out);
            outputWordList(wordsKey, out);
        } catch (FileNotFoundException e) {
            System.err.println("Could not write to output file: " + oFile);
            System.exit(1);
        }
    }

    private static void initializePuzzle(char[][] puzzle) {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                puzzle[i][j] = '.';
            }
        }
    }

    private static void placeWordsInPuzzle(char[][] puzzle, List<String> words) {
        for (String word : words) {
            boolean placed = false;
            int attempts = 0;

            while (!placed && attempts < 1000) {
                int direction = random.nextInt(8);
                int x = random.nextInt(puzzle.length);
                int y = random.nextInt(puzzle.length);

                placed = tryPlaceWord(puzzle, word, x, y, direction);
                attempts++;
            }

            if (!placed) {
                System.err.println("Failed to place word: " + word);
            }
        }
    }

    private static boolean tryPlaceWord(char[][] puzzle, String word, int x, int y, int direction) {
        int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };
        int[] dy = { 0, 0, -1, 1, -1, -1, 1, 1 };

        int len = word.length();
        int newX = x + dx[direction] * (len - 1);
        int newY = y + dy[direction] * (len - 1);

        if (newX < 0 || newY < 0 || newX >= puzzle.length || newY >= puzzle.length) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            char c = puzzle[x + dx[direction] * i][y + dy[direction] * i];
            if (c != '.' && c != word.charAt(i)) {
                return false;
            }
        }

        for (int i = 0; i < len; i++) {
            puzzle[x + dx[direction] * i][y + dy[direction] * i] = word.charAt(i);
        }

        return true;
    }

    private static void fillEmptySpaces(char[][] puzzle) {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if (puzzle[i][j] == '.') {
                    puzzle[i][j] = (char) ('A' + random.nextInt(26));
                }
            }
        }
    }

    private static void outputPuzzle(char[][] puzzle, PrintWriter out) {
        for (char[] row : puzzle) {
            for (char c : row) {
                out.print(c + " ");
                System.out.print(c + " ");
            }
            out.println();
            System.out.println();
        }
    }

    private static void outputWordList(List<String> words, PrintWriter out) {
        out.println("\nWord List:");
        System.out.println("\nWord List:");
        for (String word : words) {
            out.println(word);
            System.out.println(word);
        }
    }
}
