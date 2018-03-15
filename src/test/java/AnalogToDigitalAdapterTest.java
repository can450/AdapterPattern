import freebirdAdapter.*;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

public class AnalogToDigitalAdapterTest extends TestCase {
    private float[] analogData = { 0.2f, 1.4f, 3.12f, 0.9f };
    private byte[] binData = { 0, 1, 1, 0 };
    private float[] analogData2 = { 1.2f, 1.4f, 0.12f, 0.9f };

    @Test
    public void testAnalogToDigitalAdapter(){
        AnalogSignal analogSignal= new FloatAnalogSignal(analogData);
        analogSignal.printAnalog();

        DigitalSignal digitalSignal = new BinaryDigitalSignal(binData);
        digitalSignal.printDigital();

        AnalogToDigitalAdapter myAdapter = new AnalogToDigitalAdapter(analogSignal);
        myAdapter.printDigital();
        assertTrue(Arrays.equals(digitalSignal.getDigital(), myAdapter.getDigital()));

        myAdapter.feedAnalogSignal(analogData2);
        myAdapter.printDigital();
        assertFalse(Arrays.equals(digitalSignal.getDigital(), myAdapter.getDigital()));


    }

}
