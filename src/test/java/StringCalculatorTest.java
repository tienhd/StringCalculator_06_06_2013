import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created with IntelliJ IDEA.
 * User: sqv-nbt
 * Date: 6/6/13
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculatorTest {

    @Test
    public void testWithNoNumberInput() {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(0,stringCalculator.Add(""));
    }

    @Test
    public void testWithTwoNumberInput() {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(3,stringCalculator.Add("1,2"));
    }

    @Test
    public void testWithMoreInputNumber () {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(6, stringCalculator.Add("1,3,2"));
    }

    @Test
    public void testEndlineInInputString () {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(6,stringCalculator.Add("1\n2,3"));
    }

    @Test
    public void testWithDifferentDelimiter () {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(6,stringCalculator.Add("//;\n1,2;3"));
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testNegativeExceptionInInputString() {
        StringCalculator stringCalculator = new StringCalculator();
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Negative is not allowed. -1 -3");
        stringCalculator.Add("//;\n,-1,2,-3");
    }

}
