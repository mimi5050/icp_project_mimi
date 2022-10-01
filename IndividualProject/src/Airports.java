import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Individual project
 * Author: Miriam Uwingabiye
 */

public class Airports extends Management {

    private final String path = "src/datasets/airports.csv";
    private final HashMap<String, Airports> airportGraph = new HashMap<>();

    private int airportID;
    private  String name;
    private String city;
    private  String country;
    private String IATA;

    public String getPath() {
        return path;
    }

    private  String ICAO;
    private  String latitude;
    private String longitude;
    private String altitude;
    private String timezone;
    private String DST;
    private  String tzDatabaseTimeZone;
    private String type;
    private  String source;

    public Airports(){}
    public Airports(int airportID, String name, String city, String country, String IATA,
                    String ICAO, String latitude, String longitude, String altitude,
                    String timezone, String DST, String tzDatabaseTimeZone,
                    String type, String source) {
        this.airportID = airportID;
        this.name = name;
        this.city = city;
        this.country = country;
        this.IATA = IATA;
        this.ICAO = ICAO;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timezone = timezone;
        this.DST = DST;
        this.tzDatabaseTimeZone = tzDatabaseTimeZone;
        this.type = type;
        this.source = source;
    }

    public int getAirportID() {
        return airportID;
    }

    public void setAirportID(int airportID) {
        this.airportID = airportID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getDST() {
        return DST;
    }

    public void setDST(String DST) {
        this.DST = DST;
    }

    public String getTzDatabaseTimeZone() {
        return tzDatabaseTimeZone;
    }

    public void setTzDatabaseTimeZone(String tzDatabaseTimeZone) {
        this.tzDatabaseTimeZone = tzDatabaseTimeZone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    @Override
    public String toString() {
        return "Airports{" +
                "airportID=" + airportID +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", IATA='" + IATA + '\'' +
                ", ICAO='" + ICAO + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", altitude='" + altitude + '\'' +
                ", timezone='" + timezone + '\'' +
                ", DST='" + DST + '\'' +
                ", tzDatabaseTimeZone='" + tzDatabaseTimeZone + '\'' +
                ", type='" + type + '\'' +
                ", source='" + source + '\'' +
                '}';
    }

    public Airports generateAirlineIDFromRoutes(String s, String d) throws IOException {
        Airports travelling = new Airports();
        this.readDataset(path);
        for (Airports a : airportGraph.values()) {
            //this code fetches the id of the airport that has the source and destination
            if (a.getCity().contains(s) || a.getCountry().contains(d)){
                travelling = a;
            }
        }
        return travelling;
    }

    public void readDataset(String path) throws IOException {
        String line = "";
        BufferedReader br = new BufferedReader(new FileReader(path));
        while ((line = br.readLine()) != null)
        {
            String[] airport = line.split(",");    // use comma as separator

            //the source 2 destination 4
            // Storing the id as key

            if (!airportGraph.containsKey(airport[0])){
                airportGraph.put(airport[0], new Airports());
            }
            //transferring Airport details as a value in a hashmap
            airportGraph.get(airport[0]).setAirportID(Integer.parseInt(airport[0]));
            airportGraph.get(airport[0]).setName(airport[1]);
            airportGraph.get(airport[0]).setCity(airport[2]);
            airportGraph.get(airport[0]).setCountry(airport[3]);
            airportGraph.get(airport[0]).setIATA(airport[4]);
            airportGraph.get(airport[0]).setICAO(airport[5]);
            airportGraph.get(airport[0]).setLatitude(airport[6]);
            airportGraph.get(airport[0]).setLongitude(airport[7]);
            airportGraph.get(airport[0]).setAltitude(airport[8]);
            airportGraph.get(airport[0]).setTimezone(airport[9]);
            airportGraph.get(airport[0]).setDST(airport[10]);
            airportGraph.get(airport[0]).setTzDatabaseTimeZone(airport[11]);
            airportGraph.get(airport[0]).setType( airport[12]);
        }
    }
}
