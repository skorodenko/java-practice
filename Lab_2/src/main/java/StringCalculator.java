import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    static private int countAdd = 0;

    public int Add(String numbers) throws Exception {
        countAdd += 1;
        String delimiter = ",";

        Pattern pattern = Pattern.compile("//(.)\n");
        Matcher matcher = pattern.matcher(numbers);

        if(matcher.find()) {
            delimiter = matcher.group(1);
        }

        String[] str_arr = numbers.split(String.format("[%s\n]", delimiter));

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
