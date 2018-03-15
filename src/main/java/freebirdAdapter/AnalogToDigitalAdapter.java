package freebirdAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 *<p>
 *Adapter - converting float analog signals to binary digital data.
 * This is taken from mkobit's Stackoverflow entry and modified.
 *</p>
 *
 * @author mkobit, can4500
 * date Mar 13, 2018 4:00:00 PM
 */
public class AnalogToDigitalAdapter implements DigitalSignal {

    private static final float DEFAULT_THRESHOLD_FLOAT_TO_BIN=1.0f;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private AnalogSignal analogSignal;
    private byte[] digitalData;
    private float threshold;
    private boolean cached;

    public AnalogToDigitalAdapter(AnalogSignal analogSignal){
        this(analogSignal, DEFAULT_THRESHOLD_FLOAT_TO_BIN);
    }

    public AnalogToDigitalAdapter(AnalogSignal analogSignal, float threshold){
        this.analogSignal=analogSignal;
        this.threshold=threshold;
    }


    @Override
    public byte[] getDigital() {
        float [] analogData = analogSignal.getAnalog();
        int len = analogData.length;
        digitalData= new byte[len];
        for(int i=0; i<len;i++){
            digitalData[i]=filterAnalogData(analogData[i]);
        }
        return digitalData;
    }
    //we should have a convert method instead
    @Override
    public void setDigital(byte[] digitalData) {
        throw new UnsupportedOperationException("This is an adapter. Only the analog signal can set the digital value");

    }

    @Override
    public void printDigital() {
        logger.info("{}", getDigital());
    }

    public void feedAnalogSignal(float[] analogData){
        this.analogSignal.setAnalog(analogData);
    }

    private byte filterAnalogData(float signal){
        return (byte) (signal>=threshold?1:0);
    }
}
