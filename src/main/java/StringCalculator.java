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
            return 0;
        }
        else {
            String regex = "[,]";
            String[] numberString = input.split(regex);
            for (String ni: numberString) {
                if (!ni.isEmpty()) {
                    int number = Integer.parseInt(ni);
                    result += number;
                }
            }
        }
        return result;
    }
}
