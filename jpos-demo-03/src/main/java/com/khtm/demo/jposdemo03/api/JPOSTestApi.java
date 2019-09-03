package com.khtm.demo.jposdemo03.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public interface JPOSTestApi {

    @RequestMapping(value = "/test/send-isomsg", method = RequestMethod.POST)
    Map<String, Object> sendISOMsg();

}
