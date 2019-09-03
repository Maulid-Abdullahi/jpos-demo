package com.khtm.demo.jposdemoembed;

import org.jpos.q2.Q2;
import org.jpos.q2.iso.QMUX;
import org.jpos.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JPOSConfiguration {

    @Bean
    public QMUX getMUXChannel() throws NameRegistrar.NotFoundException {
        return (QMUX) NameRegistrar.get("mux.mymux");
    }

    @Bean
    public ShaparakPackager getShaparakPackager(){
        return new ShaparakPackager();
    }

}
