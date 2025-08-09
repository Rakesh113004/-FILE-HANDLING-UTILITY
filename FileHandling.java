import java.io.*;
import java.util.*;

public class FileHandling {

    // Method to write to a file
    public static void writeFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println(" Step 1: File written successfully.");
            System.out.println("Written Content:\n" + content);
        } catch (IOException e) {
            System.out.println(" Error writing file: " + e.getMessage());
        }
    }

    // Method to read from a file
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\nStep 2: Reading file...");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
        }
    }

    // Method to modify file content
    public static void modifyFile(String fileName, String oldText, String newText) {
        try {
            List<String> lines = new ArrayList<>();

            // Read lines and replace text
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line.replace(oldText, newText));
                }
            }

            // Write updated lines back
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (String l : lines) {
                    writer.write(l);
                    writer.newLine();
                }
            }

            System.out.println("\n Step 3: File modified successfully.");
            System.out.println("Replaced \"" + oldText + "\" with \"" + newText + "\"");

        } catch (IOException e) {
            System.out.println(" Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fileName = "example.txt";

        // Step 1: Write to file
        writeFile(fileName, "Hello World!\nThis is a Java file handling example.");

        // Step 2: Read the file
        readFile(fileName);

        // Step 3: Modify the file
        modifyFile(fileName, "Hello", "Hi");

        // Step 4: Read again after modification
        readFile(fileName);
    }
}
