import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;;

public class WSolver {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            // Get the last argument
            System.out.println("The program should be executed with one argument, which is a file name!");
            System.exit(1);
        }
        Scanner reader = null;
        try {
            reader = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            System.err.printf("Error opening file.\n", args[0]);
            System.exit(1);
        }
        ArrayList<String> charlist = new ArrayList<>();
        ArrayList<String> wordsList = new ArrayList<>();

        String lineFirst = reader.next();
        int puzzleSize = lineFirst.length();
        int loop = 0;
        int newSize = puzzleSize - 1;
        int numRows = 0;

        if (!lineFirst.isEmpty() && lineFirst.matches("[A-Z]+")) { // empty line check not working idk why
            charlist.add(lineFirst);
        } else {
            System.out.println("Something wrong with the puzzle first line");
            reader.close();
            System.exit(1);
        }

        if (newSize > 40) {
            System.out.println("Something wrong with the puzzle");
            reader.close();
            System.exit(1);
        }

        while (loop < newSize) {
            loop++;
            if (reader.hasNext()) {
                String line = reader.next();
                if ((line.matches("[A-Z]+")) && (line.length() == puzzleSize) && (!line.trim().isEmpty())) { // empty
                                                                                                             // line
                                                                                                             // checker
                                                                                                             // not
                                                                                                             // working
                    charlist.add(line);
                    numRows++;
                } else {
                    System.out.println("Something wrong with the puzzle");

                    reader.close();
                    System.exit(1);
                }
            }
        }

        if (numRows != newSize) {
            System.out.println("Invalid puzzle format: Puzzle is not square.");
            reader.close();
            System.exit(1);
        }

        while (reader.hasNext()) {
            if (reader.hasNext("[a-zA-Z,;\\s]+")) {
                String palavras = reader.nextLine();
                String[] words = palavras.split("[;,\\s]+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordsList.add(word.toUpperCase());
                    }
                }
            } else {
                System.out.println("Something wrong with the words");
                reader.close();
                System.exit(1);
            }
        }

        reader.close();

        char[][] PuzzleChars = new char[puzzleSize][puzzleSize];
        int j = 0;
        for (String word : charlist) {
            PuzzleChars[j] = word.toCharArray();
            j++;
        }

        ArrayList<WordData> WordDataList = new ArrayList<>();
        for (String word : wordsList) {
            WordData WordData = new WordData(word);
            WordDataList.add(WordData);
        }

        Collections.sort(wordsList, (s1, s2) -> Integer.compare(s2.length(), s1.length())); // descending order
        // solving the puzzle
        for (String word : wordsList) {
            for (int a = 0; a < puzzleSize; a++) {
                for (int b = 0; b < puzzleSize; b++) {

                    if (PuzzleChars[a][b] == word.charAt(0)) {
                        // right- down- downright, left, leftdown, up. up right . upleft
                        boolean RightWord = false;
                        String direction = "NotFound";

                        // Right
                        if (b + word.length() <= puzzleSize) {
                            String TempWord = new String();

                            for (int i = 0; i < word.length(); i++) {
                                TempWord += PuzzleChars[a][b + i];
                            }
                            if (TempWord.equals(word)) {
                                RightWord = true;
                                direction = "Right";
                                for (int i = 0; i < word.length(); i++) {
                                    PuzzleChars[a][b + i] = Character.toLowerCase(PuzzleChars[a][b + i]);
                                }
                            }
                        }

                        // Down
                        if (!RightWord && a + word.length() <= puzzleSize) {
                            String TempWord = new String();
                            for (int i = 0; i < word.length(); i++) {
                                TempWord += PuzzleChars[a + i][b];
                            }
                            if (TempWord.equals(word)) {
                                RightWord = true;
                                direction = "Down";
                                for (int i = 0; i < word.length(); i++) {
                                    PuzzleChars[a + i][b] = Character.toLowerCase(PuzzleChars[a + i][b]);
                                }
                            }
                        }

                        // DownRight
                        if (!RightWord && a + word.length() <= puzzleSize && b + word.length() <= puzzleSize) {
                            String TempWord = new String();
                            for (int i = 0; i < word.length(); i++) {
                                TempWord += PuzzleChars[a + i][b + i];
                            }
                            if (TempWord.toString().equals(word)) {
                                RightWord = true;
                                direction = "DownRight";

                                for (int i = 0; i < word.length(); i++) {
                                    PuzzleChars[a + i][b + i] = Character.toLowerCase(PuzzleChars[a + i][b + i]);
                                }
                            }
                        }

                        // Left
                        if (!RightWord && b - word.length() >= -1) {
                            String TempWord = new String();
                            for (int i = 0; i < word.length(); i++) {
                                TempWord += (PuzzleChars[a][b - i]);
                            }
                            if (TempWord.equals(word)) {
                                RightWord = true;
                                direction = "Left";
                                for (int i = 0; i < word.length(); i++) {
                                    PuzzleChars[a][b - i] = Character.toLowerCase(PuzzleChars[a][b - i]);
                                }
                            }
                        }

                        // LeftDown
                        if (!RightWord && a + word.length() <= puzzleSize && b - word.length() >= -1) {
                            String TempWord = new String();
                            for (int i = 0; i < word.length(); i++) {
                                TempWord += (PuzzleChars[a + i][b - i]);
                            }
                            if (TempWord.equals(word)) {
                                RightWord = true;
                                direction = "LeftDown";
                                for (int i = 0; i < word.length(); i++) {
                                    PuzzleChars[a + i][b - i] = Character.toLowerCase(PuzzleChars[a + i][b - i]);

                                }
                            }
                        }

                        // Up
                        if (!RightWord && a - word.length() >= -1) {
                            String TempWord = new String();
                            for (int i = 0; i < word.length(); i++) {
                                TempWord += (PuzzleChars[a - i][b]);
                            }
                            if (TempWord.equals(word)) {
                                RightWord = true;
                                direction = "Up";
                                for (int i = 0; i < word.length(); i++) {
                                    PuzzleChars[a - i][b] = Character.toLowerCase(PuzzleChars[a - i][b]);
                                }
                            }
                        }

                        // UpRight
                        if (!RightWord && a - word.length() >= -1 && b + word.length() <= puzzleSize) {
                            String TempWord = new String();
                            for (int i = 0; i < word.length(); i++) {
                                TempWord += (PuzzleChars[a - i][b + i]);
                            }
                            if (TempWord.equals(word)) {
                                RightWord = true;
                                direction = "UpRight";
                                for (int i = 0; i < word.length(); i++) {
                                    PuzzleChars[a - i][b + i] = Character.toLowerCase(PuzzleChars[a - i][b + i]);
                                }
                            }
                        }
                        // UpLeft
                        if (!RightWord && a - word.length() >= -1 && b - word.length() >= -1) {
                            String TempWord = new String();
                            for (int i = 0; i < word.length(); i++) {
                                TempWord += (PuzzleChars[a - i][b - i]);
                            }
                            if (TempWord.equals(word)) {
                                RightWord = true;
                                direction = "UpLeft";
                                for (int i = 0; i < word.length(); i++) {
                                    PuzzleChars[a - i][b - i] = Character.toLowerCase(PuzzleChars[a - i][b - i]);
                                }
                            }
                        }

                        if (RightWord) {
                            // Word found do something
                            int x = a + 1;
                            int y = b + 1;
                            for (WordData WordData : WordDataList) {
                                if (WordData.getWord().equals(word)) {
                                    WordData.setDirection(direction);
                                    WordData.setX(x);
                                    WordData.setY(y);
                                }

                            }

                        }
                    }
                }
            }
        }

        for (WordData wordData : WordDataList) {
            wordData.printData();

        }
        System.err.println("");
        for (int a = 0; a < puzzleSize; a++) {
            for (int b = 0; b < puzzleSize; b++) {
                char currentChar = PuzzleChars[a][b];
                if (Character.isUpperCase(currentChar)) {
                    System.out.print(". ");
                } else {
                    System.out.print(Character.toUpperCase(currentChar) + " ");
                }
            }
            System.out.println();
        }

    }
}
