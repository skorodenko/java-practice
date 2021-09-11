public class StringCalculator {
    public int Add(String numbers) {
        String[] str_arr = numbers.split(",");

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
