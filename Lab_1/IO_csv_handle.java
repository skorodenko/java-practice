import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class for reading/writting from/into csv file.
 */
public class IO_csv_handle {

    private String in;
    private String out = "./outfile.csv";
    private String delimiter = ",";
    private java.util.logging.Logger logger =  java.util.logging.Logger.getLogger(this.getClass().getName());

    public IO_csv_handle(String in, String out, String delimiter) {
        this.in = in;
        this.out = out;
        this.delimiter = delimiter;
    }
    public IO_csv_handle(String in, String out) {
        this.in = in;
        this.out = out;
    }
    public IO_csv_handle(String in) {
        this.in = in;
    }

    public String toString() {
        return "CSV File handle:   infile = \"" + this.in + "\"    outfile = \"" + this.out + "\"    delimiter = \"" + this.delimiter + "\""; 
    }

    public ArrayList<String> readCSV() {
        ArrayList<String> res = new ArrayList<String>();
        BufferedReader csvReader = null;
        try {
            FileReader reader = new FileReader(this.in);
            
            csvReader = new BufferedReader(reader);
            String row = "";
            do {
                row = csvReader.readLine();
                if(row != null) {
                    res.add(row);
                }
            } while(row != null);

        } catch(FileNotFoundException e) {
            logger.severe("InFile not found " + this.in);
            System.exit(0);
        } catch(IOException e) {
            logger.severe("Problem in reading a file " + e);
            System.exit(0);
        } finally {
            try {
                csvReader.close();
            } catch(IOException e) {
                logger.severe("Problem file IO " + e);
                System.exit(0);
            }
        }
        return res;
    }

    public void writeCSV(ArrayList<String> arr) {
        try {
            FileWriter csvWriter = new FileWriter(this.out);

            for (String str: arr) {
                csvWriter.append(str);
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            logger.severe("Problem in writting a file " + e);
            System.exit(0);
        }
    }
}
