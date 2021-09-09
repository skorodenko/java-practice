import java.util.ArrayList;

public class Lab1 {
    
    /**
     * Main task for Lab #1, Parse CSV file.
     * Conducted using sophisticated regex.
     * @param ArrayList<String> 
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> task(ArrayList<String> arr, String delimiter) {

        ArrayList<Integer> res = new ArrayList<Integer>(); 

        for(String str: arr) {
            String[] tmp = str.split(String.format("%s(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", delimiter));
            for(String tstr: tmp) {
                System.out.println(tstr);
            }
            for(String s: tmp) {
                int counter = 0;
                s = s.replaceAll("\"\"", "\"");
                counter += s.length();
                if(s.startsWith("\"") && s.endsWith("\"")) {
                    counter -= 2;
                }
                res.add(counter);
            }
            res.add(-1);
            System.out.println("\n");
        }

        return res;
    }

    public static ArrayList<String> Unite(ArrayList<Integer> arr, String delimiter) {
        
        ArrayList<String> res = new ArrayList<String>();

        ArrayList<String> tres = new ArrayList<String>(); 
        for(int num: arr) {
            if(num == -1) {
                res.add(String.join(delimiter, tres));
                tres = new ArrayList<String>();
                continue;
            }
            if(num != 0) {
                tres.add(String.valueOf(num));
            }
        }
        
        return res;
    }
}
