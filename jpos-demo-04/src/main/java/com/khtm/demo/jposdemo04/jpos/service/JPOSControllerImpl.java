package com.khtm.demo.jposdemo04.jpos.service;

import com.khtm.demo.jposdemo04.jpos.dto.Cart;
import org.jpos.iso.ISOChannel;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.packager.XMLPackager;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class JPOSControllerImpl implements JPOSControllerApi{
    @Override
    public Map<String, Object> sendISOMsgTest(Cart cart) throws ISOException, IOException {

        ISOPackager isoPackager = new XMLPackager();
        ISOChannel isoChannel = new ASCIIChannel("127.0.0.1", 8005, isoPackager);
        isoChannel.connect();
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setMTI("0800");
        isoMsg.set(4, cart.getMsisdn());
        isoMsg.set(7, cart.getValue());
        isoChannel.send(isoMsg);
//        isoChannel.disconnect();
        return null;
    }
}
