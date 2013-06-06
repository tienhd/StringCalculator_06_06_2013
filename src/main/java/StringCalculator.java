/**
 * Created with IntelliJ IDEA.
 * User: sqv-nbt
 * Date: 6/6/13
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculator {
    int result = 0;
    public int Add(String input) {
        if (input.isEmpty()) {
            return result;
        }
        else {
            String regex = "[,\n//;]";
            String negative = "-([\\d])(.*)";
            boolean ok = false;
            String[] numberString = input.split(regex);
            String negativeNumbers = "";
            for (String ni: numberString) {
                if (ni.matches(negative)) {
                    negativeNumbers += ni + " ";
                    ok = true;
                    continue;
                }
            }
            for (String ni: numberString) {
                if (ok) {
                    System.out.println(negativeNumbers);
                    throw new IllegalArgumentException("Negative is not allowed. " + negativeNumbers);
                }
                else if (!ni.isEmpty()) {
                    int number = Integer.parseInt(ni);
                    result += number;
                }
            }
        }
        return result;
    }
}
