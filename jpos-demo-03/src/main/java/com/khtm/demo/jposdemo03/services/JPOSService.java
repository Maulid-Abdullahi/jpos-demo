package com.khtm.demo.jposdemo03.services;

import com.khtm.demo.jposdemo03.dto.ISOMsgResponse;
import org.jpos.iso.ISOChannel;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.channel.XMLChannel;
import org.jpos.iso.packager.XMLPackager;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JPOSService {

    public ISOMsgResponse sendISOMsgOnXmlChannel(String bit2, String bit3, String bit4, String bit7, String bit11) throws ISOException, IOException {

        ISOMsgResponse isoMsgResponse = new ISOMsgResponse();

        ISOPackager packager = new XMLPackager();
        ISOChannel channel = new XMLChannel("127.0.0.1", 9000, packager);
        channel.connect();
        ISOMsg request = new ISOMsg();
        request.setMTI("0200");
        request.set(2, bit2);
        request.set(3, bit3);
        request.set(4, bit4);
        request.set(7, bit7);
        request.set(11, bit11);
        channel.send(request);
        ISOMsg response = channel.receive();
        isoMsgResponse.setIsoMsg(request);
        isoMsgResponse.setRsp(true);
        if(response == null){
            isoMsgResponse.setIsoMsg(new ISOMsg());
            isoMsgResponse.setRsp(false);
        }
        return isoMsgResponse;
    }

}
