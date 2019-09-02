package com.khtm.demo.jposdemoembed;

import org.jpos.iso.ISOUtil;
import org.jpos.q2.Q2;
import org.jpos.q2.QBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QTest implements QTestMBean, Runnable {

    private static final String TAG = "QTest";
    private Logger logger = LoggerFactory.getLogger(TAG);

    private long tickInterval = 1000;
    volatile int state;

    public QTest(){
        super();
        state = -1;
        logger.info(Q2.LOGGER_NAME + " ::: qtest");
        logger.info("Constructor");
    }

    @Override
    public void run() {
        for (int tickCount=0; running (); tickCount++) {
            logger.info ("tick " + tickCount);
            ISOUtil.sleep (tickInterval);
        }
    }

    @Override
    public void init() throws Exception {
        logger.info("init");
        state = STARTING;
    }

    @Override
    public void start() throws Exception {
        logger.info("start");
        state = STARTED;
        new Thread(this).start();
    }

    @Override
    public void stop() throws Exception {
        logger.info("stop");
        state = STOPPING;
    }

    @Override
    public void destroy() throws Exception {
        logger.info("destroy");
        state = STOPPED;
    }

    @Override
    public long getTickInterval() {
        return tickInterval;
    }

    @Override
    public void setTickInterval(long tickInterval) {
        this.tickInterval = tickInterval;
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public String getStateAsString() {
        return state >= 0 ? stateString[state] : "Unknown";
    }

    private boolean running() {
        return state == QBean.STARTING || state == QBean.STARTED;
    }
}
