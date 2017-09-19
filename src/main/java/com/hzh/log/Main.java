package com.hzh.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by huangzehai on 2016/9/5.
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.error("Running main method.");
    }

}
