import java.util.regex.Pattern;

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
            String definePattern = "(//)(\\[)(.*)(\\])(\\n)(.*)";
            if (input.matches(definePattern)) {
                regex = getDefinePattern(input);
                String[] temp1 = input.split("\\n");
                input = temp1[1];

            }
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
                    //System.out.println(negativeNumbers);
                    throw new IllegalArgumentException("Negative is not allowed. " + negativeNumbers);
                }
                else if (!ni.isEmpty()) {
                    int number = Integer.parseInt(ni);
                    if (number <= 1000) {
                        result += number;
                    }

                }
            }
        }
        return result;
    }

    public String getDefinePattern(String input) {
        String[] temp1 = input.split("\\n");
        String[] temp2 = temp1[0].split("//");
        String getRegex = temp2[1];
        String defineRegex = "[";
        getRegex = getRegex.replaceAll("\\[", " ");
        getRegex = getRegex.replaceAll("\\]", " ");
        String[] spilitRegex = getRegex.split(" ");
        for (String si: spilitRegex) {
            if (!si.isEmpty()) {
                defineRegex += "(" + si + ")";
            }
        }
        defineRegex += "]";
        return defineRegex;
    }
}
