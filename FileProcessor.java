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

        FingerPrint user = new FingerPrint("User1.txt");
        System.out.println("User1 Fingerprint:");
        System.out.println("Name: " + user.getName());
        System.out.println("Year: " + user.getYear());
        System.out.println("Rows: " + user.getRows());
        System.out.println("Cols: " + user.getCols());
        System.out.println("Number of Pixels: " + user.getNumberOfPixels());

        // Compare fingerprints
        System.out.println("\nComparison Result:");
        System.out.println("Original and User fingerprints are equal: " + original.equals(user));
    }
}
