import junit.framework.Assert;
import org.junit.Test;

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
}
