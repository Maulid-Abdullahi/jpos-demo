package com.khtm.demo.jposdemo04.jpos.service;

import com.khtm.demo.jposdemo04.jpos.dto.ContextConstant;
import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;
import org.jpos.space.Space;
import org.jpos.space.SpaceFactory;
import org.jpos.transaction.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JPOSRequestListener implements ISORequestListener, Configurable {

    private static final String TAG = "JPOSRequestListener";
    private Logger logger = LoggerFactory.getLogger(TAG);

    private Configuration configuration;

    @Override
    public boolean process(ISOSource isoSource, ISOMsg isoMsg) {
        try {
            logger.info(String.format("MTI of ISOMsg Received is: %s", isoMsg.getMTI()));
            // put request into the space by using of context object

            // get some parameters from configuration
            String spaceName = configuration.get("space");
            long timeout = configuration.getLong("sapceTimeout");
            String queueName = configuration.get("queue");

            // create context
            Context context = new Context();
            Space<String, Context> space = SpaceFactory.getSpace(spaceName);

            context.put(ContextConstant.REQUEST_KEY, isoMsg);
            context.put(ContextConstant.SOURCE_KEY, isoSource);

            space.out(queueName, context, timeout);

        } catch (ISOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void setConfiguration(Configuration configuration) throws ConfigurationException {
        this.configuration = configuration;
    }
}
