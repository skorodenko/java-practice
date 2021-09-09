import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {

        //final String infile = args[0];
        //final String outfile = args[1];
        //final String delimiter = args[2];
        //final String ndelimiter = args[3];

        final String infile = "./Lab_1/in.csv";
        final String outfile = "./Lab_1/out.csv";
        final String delimiter = ",";
        final String ndelimiter = "+";

        IO_csv_handle handle = new IO_csv_handle(infile, outfile, delimiter);

        //System.out.println("\n"+handle);

        ArrayList<String> input = handle.readCSV();

        ArrayList<Integer> wlens = Lab1.task(input, delimiter);

        ArrayList<String> res = Lab1.Unite(wlens, ndelimiter);
        
        handle.writeCSV(res);
    }
}
