package com.khtm.demo.jposdemo04.jpos.service;

import com.khtm.demo.jposdemo04.jpos.dto.Cart;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JPOSControllerImpl implements JPOSControllerApi{
    @Override
    public Map<String, Object> sendISOMsgTest(Cart cart) {
        return null;
    }
}
