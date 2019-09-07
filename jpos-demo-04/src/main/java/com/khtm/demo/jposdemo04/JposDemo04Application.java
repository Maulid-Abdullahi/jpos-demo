package com.khtm.demo.jposdemo04;

import org.jpos.q2.Q2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JposDemo04Application {

    public static void main(String[] args) {
        Q2 server = new Q2("jpos-demo-04/deploy");
        server.start();
        SpringApplication.run(JposDemo04Application.class, args);
    }

}
