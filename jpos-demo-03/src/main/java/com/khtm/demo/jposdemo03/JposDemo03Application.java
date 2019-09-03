package com.khtm.demo.jposdemo03;

import org.jpos.q2.Q2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JposDemo03Application {

    public static void main(String[] args) {
        Q2 q2 = new Q2("jpos-demo-03/deploy");
        q2.start();

        SpringApplication.run(JposDemo03Application.class, args);
    }

}
