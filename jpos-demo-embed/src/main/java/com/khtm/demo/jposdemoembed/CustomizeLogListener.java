package com.khtm.demo.jposdemoembed;

import com.google.gson.GsonBuilder;
import org.jpos.util.LogEvent;
import org.jpos.util.LogListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CustomizeLogListener implements LogListener {

    private static final String TAG = "CustomizeLogListener";
    private Logger logger = LoggerFactory.getLogger(TAG);

    @Override
    public LogEvent log(LogEvent logEvent) {
        logger.info(logEvent.getTag());
        logger.info(logEvent.getRealm());
        logger.info(new GsonBuilder().create().toJson(logEvent.getPayLoad(), Object.class));
        return null;
    }
}
