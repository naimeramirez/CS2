import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class CS3Lab4 {
    public static void main(String[] args) {
        CS3Lab4 processor = new CS3Lab4();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("*************************");
            System.out.println("* [l] load file         *");
            System.out.println("* [a] add a word        *");
            System.out.println("* [g] get a word        *");
            System.out.println("* [d] delete a word     *");
            System.out.println("* [p] print table       *");
            System.out.println("* [x] exit and save     *");
            System.out.println("*************************");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "l":
                    System.out.print("Enter file name to load: ");
                    String filename = scanner.nextLine();
                    processor.loadFromFile(filename);
                    break;
                case "a":
                    System.out.print("Enter a word to add: ");
                    String wordToAdd = scanner.nextLine();
                    processor.put(wordToAdd);
                    break;
                case "g":
                    System.out.print("Enter a word to get: ");
                    String wordToGet = scanner.nextLine();
                    if (processor.get(wordToGet)) {
                        System.out.println("Word Found");
                    } else {
                        System.out.println("Word Not Found");
                    }
                    break;
                case "d":
                    System.out.print("Enter a word to delete: ");
                    String wordToDelete = scanner.nextLine();
                    if (processor.delete(wordToDelete)) {
                        System.out.println("Word Deleted");
                    } else {
                        System.out.println("Word Not Found");
                    }
                    break;
                case "p":
                    processor.printTable();
                    break;
                case "x":
                    System.out.print("Enter file name to save: ");
                    String saveFilename = scanner.nextLine();
                    processor.saveToFile(saveFilename);
                    System.out.println("Program exited and table saved.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (!choice.equals("x"));

        scanner.close();
    }

    private static final int TABLE_SIZE = 128;

    private LinkedList<String>[] table;

    public CS3Lab4() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(String key) {
        int hash = 5381;
        for (int i = 0; i < key.length(); i++) {
            hash = ((hash << 5) + hash) + key.charAt(i); // hash * 33 + c
        }
        return Math.abs(hash % TABLE_SIZE);
    }

    public void put(String key) {
        int index = hashFunction(key);
        if (!table[index].contains(key)) {
            table[index].add(key);
        }
    }

    public boolean get(String key) {
        int index = hashFunction(key);
        return table[index].contains(key);
    }

    public boolean delete(String key) {
        int index = hashFunction(key);
        return table[index].remove(key);
    }

    public void printTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (!table[i].isEmpty()) {
                System.out.println("Index " + i + ": " + table[i]);
            }
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                put(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < TABLE_SIZE; i++) {
                if (!table[i].isEmpty()) {
                    writer.println("Index " + i + ": " + table[i]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
