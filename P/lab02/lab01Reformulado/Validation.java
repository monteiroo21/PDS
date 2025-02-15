// Student authors:
// NMec:  Name:
// 113278 Jorge Domingues
// 114547 João Monteiro

import java.awt.Point;

public class Validation {
    public static int checkLengthLine(String line) {
        int num = 0;
        for (char c : line.toCharArray()) {
            if (c != '\n') { // if it's not a line break
                num++;
            }
        }
        return num;
    }

    public static boolean isUpperCase(String line) {
        for (char c : line.toCharArray()) {
            if (!Character.isUpperCase(c)) { // if it's not an UpperCase letter
                return false;
            }
        }
        return true;
    }

    public static boolean isSquare(int x, int y) {
        return x == y; // if the number of lines is equal to the number of columns
    }

    public static boolean sameSizes(int size1, int size2) {
        return size1 == size2;
    }

    public static boolean validSize(int size) {
        return (size > 0 && size <= 40);
    }

    public static boolean isInside(int x, int y, int size) {
        return (x >= 0 && x <= size && y >= 0 && y <= size);
    }

    public static boolean pointIsValid(Point point, int size) {
        return (point.getX() < size && point.getY() < size) && (point.getX() >= 0 && point.getY() >= 0);
    }

    public static int sizeOrFile(String exp) {
        if ("-i".equals(exp)) {
            return 1;
        }
        if ("-s".equals(exp)) {
            return 2;
        }
        if ("-o".equals(exp)) {
            return 3;
        }
        return 0;
    }

}
