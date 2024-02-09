import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class FingerPrint {
    // Fields
    private String name;
    private int year;
    private int rows;
    private int cols;
    private String[][] data;

    // 1st Constructor
    public FingerPrint(String fileName) throws IOException {
        // Declare file handler.
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return;
        }

        Scanner input = new Scanner(file);

        //Read the file
        while (input.hasNext()) {
            //Initialize the fields.
            this.name = input.nextLine();
            this.year = input.nextInt();
            this.rows = input.nextInt();
            this.cols = input.nextInt();

            //Initialize the 2D array with the rows and cols fields
            this.data = new String[rows][cols];

            //Read the file line by line and convert each line into an array using the split() method.
            //Populate each row in the 2D array with the array just created
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (input.hasNext()) {
                        this.data[row][col] = input.next();
                    }
                }
            }
        }
    }

    //2nd Constructor
    //take the needed parameters to initialize the fields
    public FingerPrint(String name, int year, int rows, int cols, String[][] data) {
        //initialize all the fields
        this.name = name;
        this.year = year;
        this.rows = rows;
        this.cols = cols;
        this.data = data;
    }

    //equals() method
    public boolean equals(FingerPrint other) {
        if (other == null || this.rows != other.rows || this.cols != other.cols) {
            return false;
        }

        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                if (!this.data[row][col].equals(other.data[row][col])) {
                    return false;
                }
            }
        }

        return true;
    }

    //take as a parameter another FingerPrint object. Compare the data from both FingerPrint objects.
    //Remember to compare each value of both 2D arrays

    //getNumberOfPixels()
    public int getNumberOfPixels() {
        return rows * cols;
    }

    //toString() method
    //Provide the String representation of this FingerPrint.
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                result.append(data[row][col]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    //getImage() method
    //print the 2D array.
    public void getImage() {
        System.out.println(this);
    }

    //getters
    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

}