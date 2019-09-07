package com.khtm.demo.jposdemo04.jpos.service;

import com.khtm.demo.jposdemo04.jpos.dto.Cart;
import org.jpos.iso.ISOException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public interface JPOSControllerApi {

    @RequestMapping(value = "/test/send-isomsg", method = RequestMethod.POST)
    Map<String, Object> sendISOMsgTest(@RequestBody(required = true)Cart cart) throws ISOException, IOException;

}
