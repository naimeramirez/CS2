import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Quiz3 {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        try {
            File file = new File("DATA.TXT");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                queue.add(line);
            }

            scanner.close();

            System.out.println("Elements dequeued from the queue:");
            while (!queue.isEmpty()) {
                String element = queue.poll();
                System.out.println(element);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}
