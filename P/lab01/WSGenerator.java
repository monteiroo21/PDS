import java.io.*;
import java.util.*;

public class WSGenerator {
    private static final int MAX_ARGS = 6;
    private static final int MIN_ARGS = 4;

    public static void main(String[] args) {
        if (args.length != MIN_ARGS && args.length != MAX_ARGS) {
            System.err.println("ERROR! Invalid arguments!");
            System.exit(1);
        }

        // Variables definition
        String file = null;
        int size = 0;
        String outputFile = null;
        boolean output = false;

        // Validation of arguments
        for (int i = 0; i < args.length; i += 2) {
            switch (Validation.sizeOrFile(args[i])) {
                case 1:
                    file = args[i + 1];
                    break;
                case 2:
                    try {
                        size = Integer.parseInt(args[i + 1]);
                    } catch (NumberFormatException e) { //NumberFormatException to check if it is possible to transform the argument into an integer
                        System.err.println("Size needs to be an integer!");
                        System.exit(1);
                    }
                    break;
                case 3:
                    outputFile = args[i + 1];
                    output = true;
                    break;
                default:
                    System.err.println("Invalid flag!");
                    System.exit(1);
                    break;
            }
        }

        if (!Validation.validSize(size)) {
            System.err.println("ERROR! The size given is invalid. Needs to be positive and smaller than 40!");
            System.exit(1);
        }

        // Calling implemented functions
        List<String> words;
        words = wordsList(file);

        char[][] puzzle;
        puzzle = puzzle(words, size);

        printAll(puzzle, words, output, outputFile);
    }

    private static List<String> wordsList(String file) {
        // Reading the content of the file
        List<String> words = new ArrayList<String>();
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split("[.,\\s;]+");
                for (int i = 0; i < parts.length; i++) {
                    words.add(parts[i]); // Get all the words into a list, for later use
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("ERROR! File not found!");
            System.exit(1);
        }
        return words;
    }

    private static char[][] puzzle(List<String> words, int size) {
        char[][] puzzle = new char[size][size];

        // Create a random and complete puzzle
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                puzzle[i][j] = randomChar();
            }
        }

        return wordsInPuzzle(puzzle, words);
    }

    private static char randomChar() {
        Random random = new Random();
        return (char) (random.nextInt(26) + 'A');
    }

    private static char[][] wordsInPuzzle(char[][] puzzle, List<String> words) {
        // Function to insert the words (in the List) into the puzzle in random (and valid) positions
        int size = puzzle.length;

        Collections.sort(words, (s1, s2) -> Integer.compare(s2.length(), s1.length()));

        Orientations orientation = null;
        List<Point> occupiedPoints = new ArrayList<Point>();
        int px = 0, py = 0;

        Random random = new Random();
        for (String word : words) {

            boolean fitted = false;

            while (!fitted) {
                // Getting random values for the coordinates and for the direction that should be taken
                px = random.nextInt(size - 1);
                py = random.nextInt(size - 1);
                orientation = Orientations.values()[random.nextInt(8)];
                List<Point> occupiedPoints_temp = new ArrayList<Point>(); // Creation of a temporary array, for an easier implementation

                Point p = new Point(px, py);
                int count;

                if (Validation.pointIsValid(p, size) && !occupiedPoints.contains(p)) {

                    // switch case that addresses all the scenarios, for each word 
                    // It checks if it is possible to insert a word into a given position
                    switch (orientation) {
                        case UP:
                            count = 0;
                            for (int i = 0; i < word.length(); i++) {
                                Point point = new Point(px - i, py);
                                if (Validation.pointIsValid(point, size) && !occupiedPoints.contains(point)) {
                                    occupiedPoints_temp.add(point);
                                    count++;
                                }
                            }
                            if (count == word.length()) {
                                for (int i = 0; i < word.length(); i++) {
                                    puzzle[px - i][py] = Character.toUpperCase(word.charAt(i));
                                }
                                occupiedPoints.addAll(occupiedPoints_temp);
                                fitted = true;
                            }
                            break;
                        case UPRIGHT:
                            count = 0;
                            for (int i = 0; i < word.length(); i++) {
                                Point point = new Point(px - i, py + i);
                                if (Validation.pointIsValid(point, size) && !occupiedPoints.contains(point)) {
                                    occupiedPoints_temp.add(point);
                                    count++;
                                }
                            }
                            if (count == word.length()) {
                                for (int i = 0; i < word.length(); i++) {
                                    puzzle[px - i][py + i] = Character.toUpperCase(word.charAt(i));
                                }
                                occupiedPoints.addAll(occupiedPoints_temp);
                                fitted = true;
                            }
                            break;
                        case RIGHT:
                            count = 0;
                            for (int i = 0; i < word.length(); i++) {
                                Point point = new Point(px, py + i);
                                if (Validation.pointIsValid(point, size) && !occupiedPoints.contains(point)) {
                                    occupiedPoints_temp.add(point);
                                    count++;
                                }
                            }
                            if (count == word.length()) {
                                for (int i = 0; i < word.length(); i++) {
                                    puzzle[px][py + i] = Character.toUpperCase(word.charAt(i));
                                }
                                occupiedPoints.addAll(occupiedPoints_temp);
                                fitted = true;
                            }
                            break;
                        case DOWNRIGHT:
                            count = 0;
                            for (int i = 0; i < word.length(); i++) {
                                Point point = new Point(px + i, py + i);
                                if (Validation.pointIsValid(point, size) && !occupiedPoints.contains(point)) {
                                    occupiedPoints_temp.add(point);
                                    count++;
                                }
                            }
                            if (count == word.length()) {
                                for (int i = 0; i < word.length(); i++) {
                                    puzzle[px + i][py + i] = Character.toUpperCase(word.charAt(i));
                                }
                                occupiedPoints.addAll(occupiedPoints_temp);
                                fitted = true;
                            }
                            break;
                        case DOWN:
                            count = 0;
                            for (int i = 0; i < word.length(); i++) {
                                Point point = new Point(px, py + i);
                                if (Validation.pointIsValid(point, size) && !occupiedPoints.contains(point)) {
                                    occupiedPoints_temp.add(point);
                                    count++;
                                }
                            }
                            if (count == word.length()) {
                                for (int i = 0; i < word.length(); i++) {
                                    puzzle[px][py + i] = Character.toUpperCase(word.charAt(i));
                                }
                                occupiedPoints.addAll(occupiedPoints_temp);
                                fitted = true;
                            }
                            break;
                        case DOWNLEFT:
                            count = 0;
                            for (int i = 0; i < word.length(); i++) {
                                Point point = new Point(px + i, py - i);
                                if (Validation.pointIsValid(point, size) && !occupiedPoints.contains(point)) {
                                    occupiedPoints_temp.add(point);
                                    count++;
                                }
                            }
                            if (count == word.length()) {
                                for (int i = 0; i < word.length(); i++) {
                                    puzzle[px + i][py - i] = Character.toUpperCase(word.charAt(i));
                                }
                                occupiedPoints.addAll(occupiedPoints_temp);
                                fitted = true;
                            }
                            break;
                        case LEFT:
                            count = 0;
                            for (int i = 0; i < word.length(); i++) {
                                Point point = new Point(px, py - i);
                                if (Validation.pointIsValid(point, size) && !occupiedPoints.contains(point)) {
                                    occupiedPoints_temp.add(point);
                                    count++;
                                }
                            }
                            if (count == word.length()) {
                                for (int i = 0; i < word.length(); i++) {
                                    puzzle[px][py - i] = Character.toUpperCase(word.charAt(i));
                                }
                                occupiedPoints.addAll(occupiedPoints_temp);
                                fitted = true;
                            }
                            break;
                        case UPLEFT:
                            count = 0;
                            for (int i = 0; i < word.length(); i++) {
                                Point point = new Point(px - i, py - i);
                                if (Validation.pointIsValid(point, size) && !occupiedPoints.contains(point)) {
                                    occupiedPoints_temp.add(point);
                                    count++;
                                }
                            }
                            if (count == word.length()) {
                                for (int i = 0; i < word.length(); i++) {
                                    puzzle[px - i][py - i] = Character.toUpperCase(word.charAt(i));
                                }
                                occupiedPoints.addAll(occupiedPoints_temp);
                                fitted = true;
                            }
                            break;
                        default:
                            System.err.println("ERROR! Unable to get a direction!");
                            System.exit(1);
                            break;
                    }
                }
            }

        }

        return puzzle;
    }

    private static void printAll(char[][] puzzle, List<String> words, boolean output, String file) {
        // Function to print the information (into the terminal or into a file)
        if (output) {
            try {
                FileWriter fileWriter = new FileWriter(file);

                PrintWriter printWriter = new PrintWriter(fileWriter); // FileWiter and PrintWriter usage, to print into a file (-o option)

                // Printing the random generated puzzle
                for (int i = 0; i < puzzle.length; i++) {
                    for (int j = 0; j < puzzle.length; j++) {
                        printWriter.printf("%s ", puzzle[i][j]);
                    }
                    printWriter.println();
                }

                // Printing the list of words
                for (String word : words) {
                    printWriter.printf("%s, ", word);
                }

                printWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                System.err.println("ERROR! Unable to write into the file!");
                System.exit(1);
            }
        } else {
            for (int i = 0; i < puzzle.length; i++) {
                for (int j = 0; j < puzzle.length; j++) {
                    System.out.printf("%s ", puzzle[i][j]);
                }
                System.out.println();
            }

            for (String word : words) {
                System.out.printf("%s, ", word);
            }
        }
    }
}
