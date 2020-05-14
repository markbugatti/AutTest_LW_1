import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.Ignore;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestCalculator {
    Calculator calculator;
    public double result;

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Rule
    public Timeout globalTimeout = Timeout.millis(60);

    @Before
    public void initialize() {
        calculator = new Calculator();
    }

    @Test
    public void plus() {
        result = calculator.plus(4,4);
        Assert.assertEquals(8., result, 0.0001);
    }

    @Test
    public void minus() {
        result = calculator.minus(4,4);
        Assert.assertEquals(0., result, 0.0001);
    }

    @Test
    public void multiply() {
        result = calculator.multiply(4,4);
        Assert.assertEquals(16., result, 0.0001);
    }

    @Test
    public void divideNegative() {
        thrown.expect(IllegalArgumentException.class);
        calculator.divide(4,0);

    }

//  Принудительный провал теста через fail
    @Test
    public void divideForceFail() {
        //thrown.expect(IllegalArgumentException.class);
        try {
            calculator.divide_WithoutExcetion(4,0);
            fail("No exception is thrown");
        } catch (IllegalArgumentException e)
        {

        }
    }

    @Test
    public void dividePositive() {
        result = calculator.divide(4, 2);
        Assert.assertEquals(2., result, 0.0001);
    }

    // Проигнорировать тест
    @Ignore
    @Test
    public void sqRootPositive() {
        result = calculator.sqRoot(16);
        Assert.assertEquals(4, result, 0.0001);
    }

    @Test
    public void sqRootNegative() {
        thrown.expect(IllegalArgumentException.class);
        result = calculator.sqRoot(-16.);
    }

    // Пренудительный провал теста для проверки TimeOut
    @Test
    public void square() throws InterruptedException {
        result = calculator.square(3);
        Assert.assertEquals(9., result, 0.0001);
        TimeUnit.MILLISECONDS.sleep(100);
    }

    @After
    public void dispose() {
        calculator = null;
        result = 0.;
    }
}
