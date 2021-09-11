import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int Add(String numbers) {
        String delimiter = ",";

        Pattern pattern = Pattern.compile("//(.)\n");
        Matcher matcher = pattern.matcher(numbers);

        if(matcher.find()) {
            delimiter = matcher.group(1);
        }

        String[] str_arr = numbers.split(String.format("[%s\n]", delimiter));

        int sum = 0;
        for(String number: str_arr) {
            try {
                sum += Integer.parseInt(number);
            }
            catch(NumberFormatException e) {
                continue;
            }
        }

        return sum;
    }
}
