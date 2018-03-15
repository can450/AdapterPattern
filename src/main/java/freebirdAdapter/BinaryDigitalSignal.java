package freebirdAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class BinaryDigitalSignal implements DigitalSignal{

    private Logger logger=LoggerFactory.getLogger(this.getClass());
    private byte[] data;

    public BinaryDigitalSignal(byte[] signalData){
        this.data=signalData;
    }

    @Override
    public byte[] getDigital() {
        return data;
    }

    @Override
    public void setDigital(byte[] digitalData) {
        this.data=digitalData;
    }

    @Override
    public void printDigital() {
        logger.info("{}", Arrays.toString(this.getDigital()));

    }
}
