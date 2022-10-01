import java.io.*;

/**
 * Individual project
 * Author: Miriam Uwingabiye
 */
public class Main{

    public static void main(String[] args) {
        Input solve = new Input();
        try {
            String filepath = "src/accra-winnipeg";
            //String filepath = "src/datasets/airlines.csv";
            solve.readDataset(filepath);
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}