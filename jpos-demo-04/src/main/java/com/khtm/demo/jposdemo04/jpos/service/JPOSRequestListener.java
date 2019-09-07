package com.khtm.demo.jposdemo04.jpos.service;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JPOSRequestListener implements ISORequestListener {

    private static final String TAG = "JPOSRequestListener";
    private Logger logger = LoggerFactory.getLogger(TAG);

    @Override
    public boolean process(ISOSource isoSource, ISOMsg isoMsg) {
        try {
            logger.info(String.format("MTI of ISOMsg Received is: %s", isoMsg.getMTI()));
        } catch (ISOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
