package com.khtm.demo.jposdemo03.jpos;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CustomizeRequestListener implements ISORequestListener {

    private static final String TAG = "JPOS :: CustomizeRequestListene";
    private Logger logger = LoggerFactory.getLogger(TAG);

    @Override
    public boolean process(ISOSource isoSource, ISOMsg isoMsg) {
        logger.info("ISOSource -> Connection Status :: " + isoSource.isConnected());
        for (int i = 0; i < isoMsg.getMaxField(); i++) {
            if(isoMsg.hasField(i)){
                logger.info(String.format("field [%d] content [%s]", i, isoMsg.getString(i)));
            }
        }

        try {
            isoSource.send(isoMsg);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ISOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
