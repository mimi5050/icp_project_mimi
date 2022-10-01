import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Input {
    private final HashMap<String, Airlines> graphAirlines = new HashMap<>();;
    private Routes r = new Routes();
    private Airlines a = new Airlines();
    private Airports ap = new Airports();

    public void readDataset(String path) throws IOException {

        try {
            a.readDataset(a.getPath());
            //System.out.println(a);
            r.readDataset(r.getPath());
            ap.readDataset(ap.getPath());

            String line = "";
            BufferedReader br = new BufferedReader(new FileReader(path));
            BufferedWriter bw = new BufferedWriter(new FileWriter(path + "_output.txt"));
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
