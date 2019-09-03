package com.khtm.demo.jposdemo03.controller;

import com.khtm.demo.jposdemo03.api.JPOSTestApi;
import com.khtm.demo.jposdemo03.dto.ISOMsgResponse;
import com.khtm.demo.jposdemo03.services.JPOSService;
import org.jpos.iso.ISOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JPOSController implements JPOSTestApi {

    private static final String TAG = "JPOS :: JPOSController";
    private Logger logger = LoggerFactory.getLogger(TAG);

    @Autowired
    private JPOSService jposService;

    @Override
    public Map<String, Object> sendISOMsg() {
        ISOMsgResponse isoMsgResponse = null;
        Map<String, Object> map = new HashMap<>();
        try {
            isoMsgResponse = jposService.sendISOMsgOnXmlChannel("5421287475388412",
                    "000000", "400.0", "0716070815", "844515");
            map.put("transmission_status", true);
        } catch (ISOException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        }
        map.put("server_response", isoMsgResponse.isRsp() ? "YES" : "NO");
        try {
            map.put("response_content", new String(isoMsgResponse.getIsoMsg().pack()));
        } catch (ISOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
