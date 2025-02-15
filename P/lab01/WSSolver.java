import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WSSolver {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if (args.length != 1) {
            System.out.println("Usage: java P1/WSSolver P1/<filename>");
            System.exit(1);
        }

        int size = 0;
        List<String> targetStrings = new ArrayList<>();

        List<String> lines = FileReaderSSW.readFileForWSSolver(args[0]); // read the file

        String fLine = lines.get(0);
        size = Validation.checkLengthLine(fLine);
        int sizeComparation = 0;

        char Puzzle[][] = new char[size][size];
        int countVertical = 0;

        for (String ln : lines) {
            if (Validation.isUpperCase(ln)) { // if it's a line with letters in UpperCase
                sizeComparation = Validation.checkLengthLine(ln); // check if all the lines have the same size
                if (Validation.sameSizes(size, sizeComparation)) {
                    for (int i = 0; i < ln.length(); i++) {
                        Puzzle[countVertical][i] = ln.charAt(i);
                    }
                    countVertical++;
                } else {
                    System.err.println("ERROR! All the lines need to have the same size!");
                    System.exit(1);
                }
            } else {
                String[] words = ln.split("[,;\\s]+"); // split by comma, semicolon or space
                for (String word : words) {
                    targetStrings.add(word);
                }
            }
        }

        if (!Validation.isSquare(sizeComparation, countVertical)) {
            System.err.println("Isn't a SQUARE!");
            System.exit(1);
        }

        Validation.sortWordsByLengthDescending(targetStrings); // so that later it will be easier to make the soup

        char[][] solvedPuzzle = WSResolution.solve(targetStrings, Puzzle);

        // print the solved puzzle
        for (int i = 0; i < solvedPuzzle.length; i++) {
            for (int j = 0; j < solvedPuzzle[i].length; j++) {
                System.out.print(solvedPuzzle[i][j] + " ");
            }
            System.out.println();
        }
    }

}