package com.khtm.demo.jposdemoembed;

import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomizeRequestListener implements ISORequestListener {

    private static final String TAG = "CustomizeRequestListene";
    private Logger logger = LoggerFactory.getLogger(TAG);

    @Override
    public boolean process(ISOSource isoSource, ISOMsg isoMsg) {
        logger.info("ISO message was received.");
        return false;
    }
}
