import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AsciiArtProcessor {

    private static final int MAX_LINE_LENGTH = 50;
    private static final int EMPTY_SPACES_START = 5;
    private static final int EMPTY_SPACES_END = 5;

    public static String addSpacesAtBeginning(String line) {
        int totalLength = EMPTY_SPACES_START + line.length() + EMPTY_SPACES_END;
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(EMPTY_SPACES_START)).append(line);
        if (totalLength < MAX_LINE_LENGTH) {
            sb.append(" ".repeat(MAX_LINE_LENGTH - totalLength));
        }
        return sb.toString();
    }

    public static void processTextFile(String filePath, String filePath2) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {

            StringBuilder textBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                textBuilder.append(line).append(" "); // Append a space to separate lines
            }
            String text = textBuilder.toString().trim(); // Remove leading/trailing spaces
            
            
            // add frame of dialogue
        	System.out.println(addSpacesAtBeginning("=".repeat(50)));

            // Divide the text into chunks and ensure each line ends with full words
            int startIndex = 0;
            String line2;
            while (startIndex < text.length()) {
                int endIndex = Math.min(startIndex + MAX_LINE_LENGTH, text.length());
                String line1 = text.substring(startIndex, endIndex).trim();
                line1 = addSpacesAtBeginning(line1);
                startIndex = endIndex;

                // Check if there is more text to read from the second file
                if ((line2 = reader2.readLine()) != null) {
                	
                    String combinedLine = line1 + line2;
                    System.out.println(combinedLine);
                } else {
                    System.out.println(line1);
                }
            }

            // Print any remaining lines from the second file, if available
            while ((line2 = reader2.readLine()) != null) {
                System.out.println(" ".repeat(MAX_LINE_LENGTH) + line2);
            }
            // close frame of dialogue
        	System.out.println(addSpacesAtBeginning("=".repeat(50)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "text_1.txt";
        processTextFile(filePath, "cowSay.txt");
    }
}
