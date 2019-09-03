package com.khtm.demo.jposdemo03.dto;

import org.jpos.iso.ISOMsg;

public class ISOMsgResponse {

    private ISOMsg isoMsg;
    private boolean rsp;

    public ISOMsg getIsoMsg() {
        return isoMsg;
    }

    public void setIsoMsg(ISOMsg isoMsg) {
        this.isoMsg = isoMsg;
    }

    public boolean isRsp() {
        return rsp;
    }

    public void setRsp(boolean rsp) {
        this.rsp = rsp;
    }
}
