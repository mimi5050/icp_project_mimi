import java.io.BufferedReader;
import java.io.FileReader;// import file reader
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Individual project
 * Author: Miriam Uwingabiye
 */
public class Airlines extends Management {

    private final String path = "src/datasets/airlines.csv";

    private final HashMap<String, Airlines> graphAirlines = new HashMap<>();;
    // instantiation of class instances
    private String airlineID;
    private String name;

    public String getPath() {
        return path;
    }

    private String alias;
    private String IATA;
    private String ICAO;
    private String callSign;
    private String country;
    private char active;
    // airline constructor method

    public Airlines(){}
    public Airlines(String airlineID, String name, String alias, String IATA,
                    String ICAO, String callSign, String country, char active) {
        this.airlineID = airlineID;
        this.name = name;
        this.alias = alias;
        this.IATA = IATA;
        this.ICAO = ICAO;
        this.callSign = callSign;
        this.country = country;
        this.active = active;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getIATA() {
        return IATA;
    }

    public void setIATA(String IATA) {
        this.IATA = IATA;
    }

    public String getICAO() {
        return ICAO;
    }

    public void setICAO(String ICAO) {
        this.ICAO = ICAO;
    }

    public String getCallsign() {
        return callSign;
    }

    public void setCallsign(String callsign) {
        this.callSign = callsign;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public char getActive() {
        return active;
    }

    public void setActive(char active) {
        this.active = active;
    }

    /**
     * a method that uses the airline ID from routes to track the name of the
     * airline the user travelled with
     * @return
     * @throws IOException
     */
    public String getTravellingAirline(String s, String d) throws IOException {
        this.readDataset(path);
        Routes r = new Routes();
        r.readDataset(r.getPath());
        Routes ar = r.generateAirlineIDFromRoutes(s, d);
        if (ar == null){
            return graphAirlines.get("1").getName();
        }
        return "BA";
        //return graphAirlines.get(ar.getAirlineID()).getName();
    }

    @Override
    public void readDataset(String path) throws IOException {
        String line = "";
        BufferedReader br = new BufferedReader(new FileReader(path));
        while ((line = br.readLine()) != null)
        {
            String[] airline = line.split(",");    // use comma as separator
            //the source airline 0
            // Storing the id as key
            if (!graphAirlines.containsKey(airline[0])){
                graphAirlines.put(airline[0], new Airlines());
            }
            //transferring Airlines details as a value in a hashmap
            graphAirlines.get(airline[0]).setAirlineID(airline[0]);
            graphAirlines.get(airline[0]).setName(airline[1]);
            graphAirlines.get(airline[0]).setAlias(airline[2]);
            graphAirlines.get(airline[0]).setIATA(airline[3]);
            graphAirlines.get(airline[0]).setICAO(airline[4]);
            graphAirlines.get(airline[0]).setCallsign(airline[5]);
            graphAirlines.get(airline[0]).setCountry(airline[6]);
            graphAirlines.get(airline[0]).setActive(airline[7].charAt(0));

        }
    }
}
