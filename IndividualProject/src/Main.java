import java.io.*;

/**
 * Individual project
 * Author: Miriam Uwingabiye
 */
public class Main{
    private static String filepath = "src/accra-winnipeg.txt";

    static Routes r = new Routes();
    static Airlines a = new Airlines();
    static Airports ap = new Airports();

    public static void main(String[] args) {

        try {
            readDataset(filepath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static void readDataset(String path) throws IOException {

        try {
            a.readDataset(a.getPath());
            r.readDataset(r.getPath());
            ap.readDataset(ap.getPath());

            String line = "";
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath + "_output.txt"));
            while ((line = br.readLine()) != null) {
                String[] route = line.split(",");    // use comma as separator
                String l = a.getTravellingAirline(route[0], route[1]);
                bw.write(l + " from " + route[0] + " " + route[1] + " 0 " + "stops\n");
            }
            br.close();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}