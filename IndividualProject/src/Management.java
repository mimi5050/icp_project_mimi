import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class Management {
    public abstract void readDataset(String path) throws IOException;
}
