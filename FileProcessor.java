import java.io.IOException;

public class FileProcessor {
    public static void main (String [] args) throws IOException {
        FingerPrint original = new FingerPrint("original.txt");
        System.out.println("Original Fingerprint:");
        System.out.println("Name: " + original.getName());
        System.out.println("Year: " + original.getYear());
        System.out.println("Rows: " + original.getRows());
        System.out.println("Cols: " + original.getCols());
        System.out.println("Number of Pixels: " + original.getNumberOfPixels());
        System.out.println();

        FingerPrint user1 = new FingerPrint("User1.txt");
        System.out.println("User1 Fingerprint:");
        System.out.println("Name: " + user1.getName());
        System.out.println("Year: " + user1.getYear());
        System.out.println("Rows: " + user1.getRows());
        System.out.println("Cols: " + user1.getCols());
        System.out.println("Number of Pixels: " + user1.getNumberOfPixels());

        // Compare fingerprints
        System.out.println("\nComparison Result:");
        System.out.println("Original and User1 fingerprints are equal: " + original.equals(user1));
    }
}
