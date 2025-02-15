// Student authors:
// NMec:  Name:
// 113278 Jorge Domingues
// 114547 João Monteiro

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WSSolver {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if (args.length != 1) {
            System.out.println("Usage: java P1/WSSolver P1/<filename>");
            System.exit(1);
        }

        List<String> lines = FileReaderSSW.readFileForWSSolver(args[0]); // read the file

        List<String> targetStrings = new ArrayList<>();

        char[][] Puzzle = readLines(lines, targetStrings); // read the lines and check if it's a square~

        char[][] solvedPuzzle = WSResolution.solve(targetStrings, Puzzle);

        printSolvedPuzzle(solvedPuzzle); // print the solved puzzle
    }

    public static char[][] readLines(List<String> lines, List<String> targetStrings) {
        String fLine = lines.get(0);
        if (!Validation.validSize(fLine.length())) {
            System.err.println("ERROR! The size of the puzzle must be between 1 and 40!");
            System.exit(1);
        }
        Set<String> set = new HashSet<>();

        int size = Validation.checkLengthLine(fLine);
        char[][] Puzzle = new char[size][size];

        int countVertical = 0;
        int sizeComparation = 0;

        for (String ln : lines) {
            if (ln.isEmpty()) {
                System.err.println("ERROR! Empty line!");
                System.exit(1);
            } else {
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
                        String wordUpper = word.toUpperCase();
                        if (!set.add(wordUpper)) {
                            System.err.println("ERROR! The words must be unique!");
                            System.exit(1);
                        }
                    }
                }
            }
        }

        if (!Validation.isSquare(sizeComparation, countVertical)) {
            System.err.println("Isn't a SQUARE!");
            System.exit(1);
        }

        return Puzzle;
    }

    public static void printSolvedPuzzle(char[][] solvedPuzzle) {
        for (int i = 0; i < solvedPuzzle.length; i++) {
            for (int j = 0; j < solvedPuzzle[i].length; j++) {
                System.out.print(solvedPuzzle[i][j] + " ");
            }
            System.out.println();
        }
    }

}