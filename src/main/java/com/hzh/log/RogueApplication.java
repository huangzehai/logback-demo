package com.hzh.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RogueApplication {
    private static final Logger logger = LoggerFactory.getLogger(RogueApplication.class);

    public static void main(String[] args) throws Exception {
        int slowCount = 6;
        int fastCount = 15;
        //Slow state
        for (int i = 0; i < slowCount; i++) {
            logger.info("This is an info (slow state) " + i);
            Thread.sleep(1000);
        }

        //Enter rapid state
        for (int i = 0; i < fastCount; i++) {
            logger.info("This is an info (rapid state) " + i);
            Thread.sleep(500);
        }
    }
}
