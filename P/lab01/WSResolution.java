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
        }

        for (String key : wordsMap.keySet()) {
            if (wordsMap.get(key).size() == 0) { // if a word is not found
                System.err.println("ERROR! " + key + " was not found! Program not finished successfully!");
                System.exit(1);
            }
            if (wordsMap.get(key).size() == 1) { // if a word is found only once
                Vetor v = wordsMap.get(key).get(0);
                Point firstChar = v.getPoint();
                int x = firstChar.getX();
                int y = firstChar.getY();
                int wordLength = v.getLength();
                System.out.printf("%-15s %d\t%d,%d\t%s\n", key, wordLength, x + 1, y + 1, v.getOrientation());
                orientatiosCases(v, x, y, wordLength, puzzle, solvedPuzzle);
            } else { // if a word is found more than once
                int count = 0;
                String word = key.toUpperCase();
                for (Vetor v : wordsMap.get(key)) { // for each vector of the word
                    Point firstChar = v.getPoint();
                    int x = firstChar.getX();
                    int y = firstChar.getY();
                    int wordLength = v.getLength();
                    Orientations orientation = v.getOrientation();

                    for (String keyCompare : wordsMap.keySet()) { // for each word in the map, to compare with the word
                        String wordCompare = keyCompare.toUpperCase();
                        int keyCompareLength = keyCompare.length();
                        if (wordCompare.equals(word)) { // if the word is the same as the word to compare
                            continue;
                        }
                        if (wordCompare.contains(word)) { // if the word to compare contains the word
                            Vetor vKeyCompare = wordsMap.get(keyCompare).get(0);
                            if (!vKeyCompare.getOrientation().equals(orientation)) { // if the orientation is different
                                count++;
                            } else { // if the orientation is the same
                                int index[][] = new int[size][size];
                                int wordIndex[][] = new int[size][size];
                                Point pointCompare = vKeyCompare.getPoint();
                                int xCompare = pointCompare.getX();
                                int yCompare = pointCompare.getY();

                                boolean isPossible = true;

                                calculateIndex(wordLength, keyCompareLength, orientation, x, y, xCompare,
                                        yCompare,
                                        index, wordIndex); // calculate the index of the word and the word to compare

                                for (int i = 0; i < size; i++) {
                                    for (int j = 0; j < size; j++) {
                                        if (index[i][j] == 1 && wordIndex[i][j] == 1) {
                                            // if the word and the word to compare are in the same place
                                            isPossible = false;
                                            break;
                                        }
                                    }
                                    if (!isPossible) {
                                        break;
                                    }
                                }

                                if (isPossible) {
                                    count++;
                                }
                            }
                        }
                    }
                    if (count == 1) { // if the word is found correctly
                        System.out.printf("%-15s %d\t%d,%d\t%s\n", key, wordLength, x + 1, y + 1, v.getOrientation());
                        orientatiosCases(v, x, y, wordLength, puzzle, solvedPuzzle);
                        break; // to ignore the other vectors of the word
                    }
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

    public static void orientatiosCases(Vetor v, int x, int y, int wordLength,
            char[][] puzzle, char[][] solvedPuzzle) {
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

    public static void calculateIndex(int wordLength, int keyCompareLength, Orientations orientation, int x, int y,
            int xCompare, int yCompare, int index[][], int wordIndex[][]) {
        switch (orientation) { // for each orientation, calculate the index of the word and the word to compare
            case DOWN:
                for (int i = 0; i < keyCompareLength; i++) {
                    index[xCompare + i][yCompare] = 1;
                }

                for (int i = 0; i < wordLength; i++) {
                    wordIndex[x + i][y] = 1;
                }
                break;
            case RIGHT:
                for (int i = 0; i < keyCompareLength; i++) {
                    index[xCompare][yCompare + i] = 1;
                }

                for (int i = 0; i < wordLength; i++) {
                    wordIndex[x][y + i] = 1;
                }
                break;
            case DOWNRIGHT:
                for (int i = 0; i < keyCompareLength; i++) {
                    index[xCompare + i][yCompare + i] = 1;
                }

                for (int i = 0; i < wordLength; i++) {
                    wordIndex[x + i][y + i] = 1;
                }
                break;

            case UPRIGHT:
                for (int i = 0; i < keyCompareLength; i++) {
                    index[xCompare - i][yCompare + i] = 1;
                }

                for (int i = 0; i < wordLength; i++) {
                    wordIndex[x - i][y + i] = 1;
                }
                break;

            case UP:
                for (int i = 0; i < keyCompareLength; i++) {
                    index[xCompare - i][yCompare] = 1;
                }

                for (int i = 0; i < wordLength; i++) {
                    wordIndex[x - i][y] = 1;
                }
                break;

            case LEFT:
                for (int i = 0; i < keyCompareLength; i++) {
                    index[xCompare][yCompare - i] = 1;
                }

                for (int i = 0; i < wordLength; i++) {
                    wordIndex[x][y - i] = 1;
                }
                break;

            case DOWNLEFT:
                for (int i = 0; i < keyCompareLength; i++) {
                    index[xCompare + i][yCompare - i] = 1;
                }

                for (int i = 0; i < wordLength; i++) {
                    wordIndex[x + i][y - i] = 1;
                }
                break;

            case UPLEFT:
                for (int i = 0; i < keyCompareLength; i++) {
                    index[xCompare - i][yCompare - i] = 1;
                }

                for (int i = 0; i < wordLength; i++) {
                    wordIndex[x - i][y - i] = 1;
                }
                break;
            default:
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
