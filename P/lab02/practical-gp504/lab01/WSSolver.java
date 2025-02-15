import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WSSolver {
    private static final int MAX_SIZE = 40;
    private static final String[] DIRECTIONS = { "UpLeft", "Up", "UpRight", "Left", "Right", "DownLeft", "Down",
            "DownRight" };
    private static final int[] DX = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private static final int[] DY = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        Scanner sc = new Scanner(file);

        String[][] puzzle = readPuzzle(sc);
        List<String> all_words = readWords(sc);
        sc.close();

        Map<String, List<Integer[]>> dictionary = findWordsInPuzzle(puzzle, all_words);
        printResult(puzzle, dictionary);
    }

    private static String[][] readPuzzle(Scanner sc) {
        String line = sc.nextLine();
        validateLine(line, "Invalid puzzle");

        int n = line.length() - 1;
        validateSize(n, "Invalid puzzle size");

        String[][] puzzle = new String[n][n];
        for (int i = 0; i < n; i++) {
            puzzle[i] = line.split("");
            validatePuzzle(puzzle[i], i);

            if (i < n - 1 && sc.hasNextLine()) { // Only read the next line if it's part of the puzzle
                line = sc.nextLine();
            }
        }
        return puzzle;
    }

    private static List<String> readWords(Scanner sc) {
        List<String> all_words = new ArrayList<>();
        String line;
        do {
            line = sc.nextLine();
            String[] words = line.split("[;,\\s]+");
            validateWords(words);

            all_words.addAll(Arrays.asList(words));
        } while (sc.hasNextLine());
        return all_words;
    }

    private static Map<String, List<Integer[]>> findWordsInPuzzle(String[][] puzzle, List<String> all_words) {
        Map<String, List<Integer[]>> dictionary = new HashMap<>();
        while (!all_words.isEmpty()) {
            String word = all_words.get(0).toUpperCase();
            int n = puzzle.length;
            int linha = -1;
            int coluna = -1;
            String dir_str = "";

            loop: for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (puzzle[i][j].equals(word.substring(0, 1))) { // If the first letter of the word is found
                        for (int dir = 0; dir < 8; dir++) {
                            List<Integer[]> coords = checkWordInDirection(puzzle, word, i, j, dir);
                            if (coords != null) {
                                if (!intersects(dictionary, coords)) {
                                    linha = i; // Store the row
                                    coluna = j; // Store the column
                                    dir_str = DIRECTIONS[dir]; // Store the direction
                                    dictionary.put(word, coords); // Add the word and its coordinates to the dictionary
                                    break loop;
                                }
                            }
                        }
                    }
                }
            }
            printWordInfo(all_words, word, n, linha, coluna, dir_str);
        }
        return dictionary;
    }

    private static List<Integer[]> checkWordInDirection(String[][] puzzle, String word, int i, int j, int dir) {
        int n = puzzle.length;
        int k;
        int row = i + DX[dir];
        int column = j + DY[dir];

        List<Integer[]> coords = new ArrayList<>(); // List to store all coordinates of the word
        coords.add(new Integer[] { i, j }); // Add the first coordinate

        for (k = 1; k < word.length(); k++) { // Check the word in the direction
            if (row < 0 || row >= n || column < 0 || column >= n
                    || !puzzle[row][column].equals(word.substring(k, k + 1))) {
                break;
            }
            coords.add(new Integer[] { row, column }); // Add the coordinate
            row += DX[dir]; // Move to the next coordinate
            column += DY[dir]; // Move to the next coordinate
        }
        if (k == word.length()) { // If the word is found
            return coords;
        }
        return null;
    }

    private static void printResult(String[][] puzzle, Map<String, List<Integer[]>> dictionary) {
        int n = puzzle.length;
        char[][] result = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = '.';
            }
        }
        for (Map.Entry<String, List<Integer[]>> entry : dictionary.entrySet()) {
            String word = entry.getKey();
            List<Integer[]> coordsList = entry.getValue();
            for (int i = 0; i < word.length(); i++) {
                Integer[] coords = coordsList.get(i);
                result[coords[0]][coords[1]] = word.charAt(i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void validateLine(String line, String errorMessage) {
        if (line.isEmpty()) {
            System.out.println(errorMessage + ": " + line);
            System.exit(1);
        }
    }

    private static void validateSize(int n, String errorMessage) {
        if (n > MAX_SIZE) {
            System.out.println(errorMessage);
            System.exit(1);
        }
    }

    private static void validatePuzzle(String[] puzzleLine, int lineNumber) {
        for (String s : puzzleLine) {
            if (!s.matches("[A-Z ]")) {
                System.out.println("Invalid character '" + s + "' in puzzle line " + (lineNumber + 1) + ": "
                        + Arrays.toString(puzzleLine));
                System.exit(1);
            }
        }
    }

    private static void validateWords(String[] words) {
        for (String word : words) {
            if (!word.matches(".*[a-z].*") || !word.matches("[a-zA-Z]+")) {
                System.out.println("Invalid word");
                System.exit(1);
            }
        }
    }

    private static boolean intersects(Map<String, List<Integer[]>> dictionary, List<Integer[]> coords) {
        for (Map.Entry<String, List<Integer[]>> entry : dictionary.entrySet()) {
            List<Integer[]> largerCoords = entry.getValue();
            for (Integer[] coord : coords) {
                if (containsCoord(largerCoords, coord)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean containsCoord(List<Integer[]> coordsList, Integer[] coord) {
        for (Integer[] c : coordsList) {
            if (Arrays.equals(c, coord)) {
                return true;
            }
        }
        return false;
    }

    private static void printWordInfo(List<String> all_words, String word, int n, int linha, int coluna,
            String dir_str) {
        if (linha == -1 && coluna == -1) {
            System.out.println(word.toLowerCase() + " not found");
            all_words.remove(0);
        } else {
            String coords = (linha + 1) + "," + (coluna + 1);
            System.out.printf("%-" + n + "s %-5s %-9s %-9s %n", word.toLowerCase(), word.length(), coords, dir_str);
            all_words.remove(0);
        }
    }
}