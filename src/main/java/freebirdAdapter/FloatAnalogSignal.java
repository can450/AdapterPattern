package freebirdAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


public class FloatAnalogSignal implements AnalogSignal {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private float[] data;

    public FloatAnalogSignal(float[] data){
        this.data=data;
    }

    @Override
    public float[] getAnalog() {
        return data;
    }

    @Override
    public void setAnalog(float[] analogData) {
        this.data=analogData;
    }

    @Override
    public void printAnalog() {
        logger.info("{}", Arrays.toString(this.getAnalog()));
    }

}
