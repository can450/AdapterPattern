package freebirdAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdapterPatternDemo {
    public static void main(String[] args){

        //This pattern is also known as Wrapper
        //The adapter converts the interface of a class into another interface desired by a client
        //It allows two or more previously incompatible objects to interact
        //It allows re-usability of existing functionality in the existing class

        //This is useful when we have a re-usable class that doesn't have proper interface

        Logger logger = LoggerFactory.getLogger(AdapterPatternDemo.class);
        logger.info("Test logger");

    }
}
