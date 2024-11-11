import java.io.File;
import java.util.Scanner;

public class read {
    public static void load(String fileName) {
        String line = null;
        
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);

            // Skip the first row (header)
            if (s.hasNextLine()) {
                s.nextLine();
            }

            // Read and process each line
            while (s.hasNextLine()) {
                line = s.nextLine().trim();

                // Skip lines that are too short
                if (line.length() < 3) {
                    System.out.println("Skipped this line: " + line);
                    continue; // Use continue to skip this iteration
                }

                // Print the line
                System.out.println(line);

                // Split the line by comma and process
                String[] parts = line.split(",", 2); // Only split into 2 parts
                if (parts.length < 2) {
                    System.out.println("Invalid line format: " + line);
                    continue; // Skip if the line doesn't have the expected format
                }
                
                try {
                    int id = Integer.parseInt(parts[0].trim());
                    String content = parts[1].trim();
                    // Process id and content as needed
                } catch (NumberFormatException e) {
                    // System.out.println("Invalid ID format: " + parts[0].trim());
                }
            }
            s.close(); // Close the scanner
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        load("dataset.csv");
    }
}