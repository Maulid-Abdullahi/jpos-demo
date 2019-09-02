package com.khtm.demo.jposdemoembed;

import org.jpos.q2.QBean;

public interface QTestMBean extends QBean {
    void setTickInterval(long tickInterval) ;
    long getTickInterval() ;
}
