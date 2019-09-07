package com.khtm.demo.jposdemo04.jpos.transaction;

import com.khtm.demo.jposdemo04.jpos.dto.ContextConstant;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class JPOSTransaction implements TransactionParticipant {

    private static final String TAG = "JPOSTransaction";
    private Logger logger = LoggerFactory.getLogger(TAG);

    @Override
    public int prepare(long l, Serializable serializable) {
        logger.info("============= Transaction Participant =============");
        Context context = (Context) serializable;
        ISOMsg isoMsg = (ISOMsg) context.get(ContextConstant.REQUEST_KEY);
        try{
            byte[] message = isoMsg.pack();
            logger.info(new String(message));
            logger.info("============================================");
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return PREPARED | NO_JOIN;
    }
}
