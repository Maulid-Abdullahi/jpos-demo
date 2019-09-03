package com.khtm.demo.jposdemoembed;

import org.jpos.iso.*;
import org.jpos.iso.channel.XMLChannel;
import org.jpos.iso.packager.XMLPackager;
import org.jpos.q2.iso.QMUX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class JPOSController {

    @Autowired
    private QMUX qmux;

    @Qualifier("getShaparakPackager")
    @Autowired
    private ShaparakPackager packager;

    private SimpleDateFormat formatterBit7 = new SimpleDateFormat("MMddHHmmss");

    @RequestMapping(value = "/test/send-isomsg", method = RequestMethod.POST)
    public Map<String, Object> sendISOMessage() throws ISOException, IOException {
        Map<String, Object> map = new HashMap<>();

        /*ISOMsg isoMsg = new ISOMsg();
        isoMsg.setMTI("0800");
        isoMsg.set(4, "989194018087");
        isoMsg.set(7, formatterBit7.format(new Date()));
        isoMsg.set(11, "000123");
        isoMsg.set(63, "131001");
        String bit48 = String.format("%1$" + 13 + "s", "98401");
        isoMsg.set(48, bit48);

        ISOMsg isoResponse = qmux.request(isoMsg, 20 * 10);
        if(isoResponse == null){
            map.put("success", false);
            map.put("error", "timeout");
            return map;
        }

        String response = new String(isoResponse.pack());

        map.put("success", true);
        map.put("response_code", isoResponse.getString(39));
        map.put("row_message", response);*/


        ISOPackager packager = new XMLPackager();
        ISOChannel channel = new XMLChannel("127.0.0.1", 9000, packager);
        channel.connect();
        ISOMsg request = new ISOMsg();
        request.setMTI("0200");
        request.set(2, "16");
        request.set(2, "5421287475388412");
        request.set(3, "000000");
        request.set(4, "400.0");
        request.set(7, "0716070815");
        request.set(11, "844515");
        channel.send(request);
        ISOMsg response = channel.receive();
        response.dump(System.out, "response:");

        return map;
    }

}
