import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    static private int countAdd = 0;

    public int Add(String numbers) throws Exception {
        countAdd += 1;
        String delimiter = ",";

        Pattern pattern1 = Pattern.compile("//(.)\n");
        Pattern pattern2_1 = Pattern.compile("//([^\n]+)\n");
        Pattern pattern2_2 = Pattern.compile("(?:\\[(.+?)\\])");
        Matcher matcher1 = pattern1.matcher(numbers);
        Matcher matcher2_1 = pattern2_1.matcher(numbers);

        if(matcher1.find()) {
            delimiter = Pattern.quote(matcher1.group(1));
        } else if(matcher2_1.find()) {
            String unparsed_delimiters = matcher2_1.group(1);
            Matcher matcher2_2 = pattern2_2.matcher(unparsed_delimiters);
            ArrayList<String> tstr = new ArrayList<String>();
            while(matcher2_2.find()) {
                tstr.add(Pattern.quote(matcher2_2.group(1)));
            }
            delimiter = String.join("|", tstr);
        }

        String[] str_arr = numbers.split(String.format("%s|[\n]", delimiter));

        int sum = 0;
        ArrayList<Integer> negativeError = new ArrayList<Integer>();
        for(String number: str_arr) {
            try {
                int num = Integer.parseInt(number);

                if(num < 0) {
                    negativeError.add(num);
                }

                if(num > 1000) {
                    num = 0;
                }

                sum += num;
            }
            catch(NumberFormatException e) {
                continue;
            }
        }

        if(!negativeError.isEmpty()) {
            throw new Exception("Negatives are not allowed: " + negativeError);
        }

        return sum;
    }

    public int GetCalledCount() {
        return countAdd;
    }
}
