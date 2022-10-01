import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Individual project
 * Author: Miriam Uwingabiye
 */
public class Routes extends Management {
    private  final String path = "src/datasets/routes.csv";

    private final HashMap<String, Routes> graphRoutes = new HashMap<>();
    private String airline;

    public String getPath() {
        return path;
    }

    private String airlineID;
    private String sourceAirport;
    private String sourceAirportID;
    private  String destinationAirport;
    private  String destinationAirportID;
    private String codeShare;
    private int stops;
    private String equipment;

    public Routes(){}
    public Routes(String airline, String airlineID, String sourceAirport,
                  String sourceAirportID, String destinationAirport,
                  String destinationAirportID, String codeShare,
                  int stops, String equipment) {
        this.airline = airline;
        this.airlineID = airlineID;
        this.sourceAirport = sourceAirport;
        this.sourceAirportID = sourceAirportID;
        this.destinationAirport = destinationAirport;
        this.destinationAirportID = destinationAirportID;
        this.codeShare = codeShare;
        this.stops = stops;
        this.equipment = equipment;
    }

    public void loadDataAsGraph() throws IOException {
        this.readDataset(path);

    }

    public Routes generateAirlineIDFromRoutes(String s, String d) {
        Routes travelling = new Routes();
        for (Routes a : graphRoutes.values()) {
            //this code fetches the id of the airport that has the source and destination
            if (a.getSourceAirport().equals(s) && a.getDestinationAirport().equals(d)){
                travelling = a;
            }
        }
        return travelling;
    }



    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public String getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(String sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public String getSourceAirportID() {
        return sourceAirportID;
    }

    public void setSourceAirportID(String sourceAirportID) {
        this.sourceAirportID = sourceAirportID;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getDestinationAirportID() {
        return destinationAirportID;
    }

    public void setDestinationAirportID(String destinationAirportID) {
        this.destinationAirportID = destinationAirportID;
    }

    public String getCodeshare() {
        return codeShare;
    }

    public void setCodeshare(String codeshare) {
        this.codeShare = codeshare;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    @Override
    public void readDataset(String path) throws IOException {
        String line = "";
        BufferedReader br = new BufferedReader(new FileReader(path));
        while ((line = br.readLine()) != null)
        {
            String[] route = line.split(",");    // use comma as separator

            //source 2 destination 4

            //Storing the id as key
            if (!graphRoutes.containsKey(route[1])){
                graphRoutes.put(route[1], new Routes());
            }
            //transferring routes details as a value in a hashmap
            graphRoutes.get(route[1]).setAirline(route[0]);
            graphRoutes.get(route[1]).setAirlineID(route[1]);
            graphRoutes.get(route[1]).setSourceAirport(route[2]);
            graphRoutes.get(route[1]).setSourceAirportID(route[3]);
            graphRoutes.get(route[1]).setDestinationAirport(route[4]);
            graphRoutes.get(route[1]).setDestinationAirportID(route[5]);
            graphRoutes.get(route[1]).setCodeshare(route[6]);
            graphRoutes.get(route[1]).setStops(Integer.parseInt(route[7]));
            graphRoutes.get(route[1]).setEquipment(route[7]);

        }
    }
}
