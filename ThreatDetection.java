import java.io.IOException;
import java.util.Scanner;

public class ThreatDetection {
    private static final int maxTries = 3;
    private static int tries = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (tries < maxTries) {
            System.out.println("Enter a new Fingerprint: ");
            String filePath = scanner.nextLine();

            try {
                FingerPrint newFingerprint = loadFingerprint(filePath);

                if (validateFingerprint(newFingerprint)) {
                    System.out.println("Fingerprint validated successfully!");
                    break;
                } else {
                    System.out.println("Invalid fingerprint. Please try again.");
                    tries++;
                }
            } catch (IOException e) {
                System.out.println("Error reading the file. Please check the file path and try again.");
                tries++;
            }

        }

        if (tries >= maxTries) {
            System.out.println("Max attempts reached. Threat detected!");
        }

        scanner.close();
    }

    private static FingerPrint loadFingerprint(String filePath) throws IOException {
        return new FingerPrint(filePath);
    }

    private static boolean validateFingerprint(FingerPrint fingerprint) {
        try {
            FingerPrint original = new FingerPrint("Original.txt");

            System.out.println("Original Fingerprint:\n" + original);
            System.out.println("User Fingerprint:\n" + fingerprint);

            return original.equals(fingerprint);
        } catch (IOException e) {
            System.out.println("Error reading the original file. Please check the file path.");
            return false;
        }
    }

}
