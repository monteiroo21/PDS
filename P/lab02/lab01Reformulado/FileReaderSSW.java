// Student authors:
// NMec:  Name:
// 113278 Jorge Domingues
// 114547 João Monteiro

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReaderSSW {
    public static List<String> readFileForWSSolver(String fileName) {
        List<String> lines = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) {
            System.err.println("File not found: " + fileName);
        }

        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }

        return lines;
    }
}
