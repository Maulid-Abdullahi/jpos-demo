package com.khtm.demo.jposdemo04.jpos.transaction;

import org.jpos.transaction.TransactionParticipant;

import java.io.Serializable;

public class JPOSTransaction implements TransactionParticipant {
    @Override
    public int prepare(long l, Serializable serializable) {
        return 0;
    }
}
