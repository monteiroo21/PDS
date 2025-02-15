// Student authors:
// NMec:  Name:
// 113278 Jorge Domingues
// 114547 João Monteiro

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WSResolution {
    public static char[][] solve(List<String> targetStrings, char[][] puzzle) {

        char[][] solvedPuzzle = createSolvedPuzzle(puzzle); // create a puzzle with the same size as the original puzzle
                                                            // with points

        Map<String, ArrayList<Vetor>> wordsMap = getWordsMap(targetStrings); // create a map with the target words

        int size = puzzle.length;

        for (String key : wordsMap.keySet()) { // for each word in the map
            wordsMap = foundTheWord(wordsMap, key, puzzle); // create a map with the target words
        }

        for (String key : wordsMap.keySet()) {
            ArrayList<Vetor> vectorsOfTheWord = wordsMap.get(key);
            if (wordsMap.get(key).size() == 0) { // if a word is not found
                System.err.println("ERROR! " + key + " was not found! Program not finished successfully!");
                System.exit(1);
            } else {
                String word = key.toUpperCase();
                int iterator[] = new int[wordsMap.get(key).size()];
                int count = 0;

                for (Vetor v : vectorsOfTheWord) { // for each vector of the word
                    for (String keyCompare : wordsMap.keySet()) { // for each word in the map, to compare with the word
                        String wordCompare = keyCompare.toUpperCase();

                        if (!wordCompare.equals(word)) { // if the word isn't the same as the word to compare
                            if (wordCompare.contains(word)) { // if the word to compare contains the word
                                for (Vetor vCompare : wordsMap.get(keyCompare)) {
                                    int index[][] = new int[size][size];
                                    int wordIndex[][] = new int[size][size];

                                    calculateIndex(v, index); // calculate the index of the word
                                    calculateIndex(vCompare, wordIndex); // calculate the index of the word to compare

                                    for (int i = 0; i < size; i++) {
                                        for (int j = 0; j < size; j++) {
                                            if (index[i][j] == 1 && wordIndex[i][j] == 1) {
                                                // if the word and the word to compare are in the same place
                                                iterator[count] = 1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    count++;
                }
                for (int i = iterator.length - 1; i >= 0; i--) {
                    if (iterator[i] == 1) {
                        vectorsOfTheWord.remove(i);
                    }
                }
            }
        }

        for (String key : wordsMap.keySet()) {
            if (wordsMap.get(key).size() == 0) { // if a word is not found
                System.err.println("ERROR! " + key + " was not found! Program not finished successfully!");
                System.exit(1);
            } else if (wordsMap.get(key).size() == 1) {
                Vetor v = wordsMap.get(key).get(0);
                Point firstChar = v.getPoint();
                int wordLength = v.getLength();
                System.out.printf("%-15s %d\t%d,%d\t%s\n", key, wordLength, firstChar.getX() + 1, firstChar.getY() + 1,
                        v.getOrientation());
                orientationsCases(v, puzzle, solvedPuzzle);
            } else {
                String word = key.toUpperCase();
                if (wordIsPalindrome(word)) {
                    if (wordsMap.get(key).size() > 2) {
                        System.err.println("ERROR! " + key + " was found more than once!");
                        System.exit(1);
                    }
                    Vetor v = wordsMap.get(key).get(0);
                    Point firstChar = v.getPoint();
                    int wordLength = v.getLength();
                    System.out.printf("%-15s %d\t%d,%d\t%s\n", key, wordLength, firstChar.getX() + 1,
                            firstChar.getY() + 1, v.getOrientation());
                    orientationsCases(v, puzzle, solvedPuzzle);
                } else {
                    System.err.println("ERROR! " + key + " was found more than once!");
                    System.exit(1);
                }
            }
        }

        return solvedPuzzle;

    }

    public static Map<String, ArrayList<Vetor>> getWordsMap(List<String> targetStrings) {
        Map<String, ArrayList<Vetor>> wordsMap = new LinkedHashMap<>();

        for (String word : targetStrings) {
            wordsMap.put(word, new ArrayList<Vetor>());
        }

        return wordsMap;
    }

    public static boolean wordIsPalindrome(String word) { // check if a word is a palindrome
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static Map<String, ArrayList<Vetor>> foundTheWord(Map<String, ArrayList<Vetor>> wordsMap, String key,
            char[][] puzzle) {
        int size = puzzle.length;
        String word = key.toUpperCase();
        int wordLength = word.length();

        // Important: our axes are x vertically and y horizontally

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (puzzle[x][y] == word.charAt(0)) { // if the first letter of the word is found
                    if (Validation.isInside(x + 1, y, size - 1)) {
                        for (int i = 1; i < wordLength; i++) {
                            if (!Validation.isInside(x + i, y, size - 1) || puzzle[x + i][y] != word.charAt(i)) {
                                // if the next letter is not the same as the next letter of the word
                                break;
                            }
                            if (i == wordLength - 1) { // if the last letter of the word is found
                                wordsMap.get(key).add(new Vetor(Orientations.DOWN, new Point(x, y), wordLength));
                                // add the word to the map with the orientation DOWN
                            }
                        }
                    }
                    if (Validation.isInside(x, y + 1, size - 1)) {
                        for (int i = 1; i < wordLength; i++) {
                            if (!Validation.isInside(x, y + i, size - 1) || puzzle[x][y + i] != word.charAt(i)) {
                                break;
                            }
                            if (i == wordLength - 1) {
                                wordsMap.get(key).add(new Vetor(Orientations.RIGHT, new Point(x, y), wordLength));
                            }
                        }
                    }
                    if (Validation.isInside(x + 1, y + 1, size - 1)) {
                        for (int i = 1; i < wordLength; i++) {
                            if (!Validation.isInside(x + i, y + i, size - 1)
                                    || puzzle[x + i][y + i] != word.charAt(i)) {
                                break;
                            }
                            if (i == wordLength - 1) {
                                wordsMap.get(key)
                                        .add(new Vetor(Orientations.DOWNRIGHT, new Point(x, y), wordLength));
                            }
                        }
                    }
                    if (Validation.isInside(x - 1, y + 1, size - 1)) {
                        for (int i = 1; i < wordLength; i++) {
                            if (!Validation.isInside(x - i, y + i, size - 1)
                                    || puzzle[x - i][y + i] != word.charAt(i)) {
                                break;
                            }
                            if (i == wordLength - 1) {
                                wordsMap.get(key)
                                        .add(new Vetor(Orientations.UPRIGHT, new Point(x, y), wordLength));
                            }
                        }

                    }
                    if (Validation.isInside(x - 1, y, size - 1)) {
                        for (int i = 1; i < wordLength; i++) {
                            if (!Validation.isInside(x - i, y, size - 1) || puzzle[x - i][y] != word.charAt(i)) {
                                break;
                            }
                            if (i == wordLength - 1) {
                                wordsMap.get(key).add(new Vetor(Orientations.UP, new Point(x, y), wordLength));
                            }
                        }
                    }
                    if (Validation.isInside(x, y - 1, size - 1)) {
                        for (int i = 1; i < wordLength; i++) {
                            if (!Validation.isInside(x, y - i, size - 1) || puzzle[x][y - i] != word.charAt(i)) {
                                break;
                            }
                            if (i == wordLength - 1) {
                                wordsMap.get(key).add(new Vetor(Orientations.LEFT, new Point(x, y), wordLength));
                            }
                        }
                    }
                    if (Validation.isInside(x + 1, y - 1, size - 1)) {
                        for (int i = 1; i < wordLength; i++) {
                            if (!Validation.isInside(x + i, y - i, size - 1)
                                    || puzzle[x + i][y - i] != word.charAt(i)) {
                                break;
                            }
                            if (i == wordLength - 1) {
                                wordsMap.get(key)
                                        .add(new Vetor(Orientations.DOWNLEFT, new Point(x, y), wordLength));
                            }
                        }
                    }
                    if (Validation.isInside(x - 1, y - 1, size - 1)) {
                        for (int i = 1; i < wordLength; i++) {
                            if (!Validation.isInside(x - i, y - i, size - 1)
                                    || puzzle[x - i][y - i] != word.charAt(i)) {
                                break;
                            }
                            if (i == wordLength - 1) {
                                wordsMap.get(key).add(new Vetor(Orientations.UPLEFT, new Point(x, y), wordLength));
                            }
                        }
                    }
                }
            }
        }

        return wordsMap;
    }

    public static void orientationsCases(Vetor v,
            char[][] puzzle, char[][] solvedPuzzle) {
        int wordLength = v.getLength();
        Point firstChar = v.getPoint();
        int x = firstChar.getX();
        int y = firstChar.getY();
        switch (v.getOrientation()) { // for each orientation, add the word to the solved puzzle
            case DOWN:
                for (int i = 0; i < wordLength; i++) {
                    solvedPuzzle[x + i][y] = puzzle[x + i][y];
                }
                break;
            case RIGHT:
                for (int i = 0; i < wordLength; i++) {
                    solvedPuzzle[x][y + i] = puzzle[x][y + i];
                }
                break;
            case DOWNRIGHT:
                for (int i = 0; i < wordLength; i++) {
                    solvedPuzzle[x + i][y + i] = puzzle[x + i][y + i];
                }
                break;
            case UPRIGHT:
                for (int i = 0; i < wordLength; i++) {
                    solvedPuzzle[x - i][y + i] = puzzle[x - i][y + i];
                }
                break;
            case UP:
                for (int i = 0; i < wordLength; i++) {
                    solvedPuzzle[x - i][y] = puzzle[x - i][y];
                }
                break;
            case LEFT:
                for (int i = 0; i < wordLength; i++) {
                    solvedPuzzle[x][y - i] = puzzle[x][y - i];
                }
                break;
            case DOWNLEFT:
                for (int i = 0; i < wordLength; i++) {
                    solvedPuzzle[x + i][y - i] = puzzle[x + i][y - i];
                }
                break;
            case UPLEFT:
                for (int i = 0; i < wordLength; i++) {
                    solvedPuzzle[x - i][y - i] = puzzle[x - i][y - i];
                }
                break;
        }
    }

    public static void calculateIndex(Vetor v, int index[][]) {
        int wordLength = v.getLength();
        Orientations orientation = v.getOrientation();
        Point firstChar = v.getPoint();
        int x = firstChar.getX();
        int y = firstChar.getY();

        switch (orientation) { // for each orientation, calculate the index of the word
            case DOWN:
                for (int i = 0; i < wordLength; i++) {
                    index[x + i][y] = 1;
                }
                break;
            case RIGHT:
                for (int i = 0; i < wordLength; i++) {
                    index[x][y + i] = 1;
                }
                break;
            case DOWNRIGHT:
                for (int i = 0; i < wordLength; i++) {
                    index[x + i][y + i] = 1;
                }
                break;
            case UPRIGHT:
                for (int i = 0; i < wordLength; i++) {
                    index[x - i][y + i] = 1;
                }
                break;
            case UP:
                for (int i = 0; i < wordLength; i++) {
                    index[x - i][y] = 1;
                }
                break;
            case LEFT:
                for (int i = 0; i < wordLength; i++) {
                    index[x][y - i] = 1;
                }
                break;
            case DOWNLEFT:
                for (int i = 0; i < wordLength; i++) {
                    index[x + i][y - i] = 1;
                }
                break;
            case UPLEFT:
                for (int i = 0; i < wordLength; i++) {
                    index[x - i][y - i] = 1;
                }
                break;
        }
    }

    public static char[][] createSolvedPuzzle(char[][] puzzle) {
        char[][] solvedPuzzle = new char[puzzle.length][puzzle.length];

        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                solvedPuzzle[i][j] = '.'; // create a puzzle with the same size as the original puzzle with points
            }
        }

        return solvedPuzzle;
    }

}