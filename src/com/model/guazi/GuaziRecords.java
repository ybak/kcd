package com.model.guazi;

import java.util.Date;

public class GuaziRecords {
    private Integer gzid;

    private String gzVin;

    private Integer gzApiuserId;

    private String gzMessage;

    private String gzAddtime;

    private String gzUptime;

    private Integer gzStart;

    public Integer getGzid() {
        return gzid;
    }

    public void setGzid(Integer gzid) {
        this.gzid = gzid;
    }

    public String getGzVin() {
        return gzVin;
    }

    public void setGzVin(String gzVin) {
        this.gzVin = gzVin == null ? null : gzVin.trim();
    }

    public Integer getGzApiuserId() {
        return gzApiuserId;
    }

    public void setGzApiuserId(Integer gzApiuserId) {
        this.gzApiuserId = gzApiuserId;
    }

    public String getGzMessage() {
        return gzMessage;
    }

    public void setGzMessage(String gzMessage) {
        this.gzMessage = gzMessage == null ? null : gzMessage.trim();
    }
    public String getGzAddtime() {
		return gzAddtime;
	}

	public void setGzAddtime(String gzAddtime) {
		this.gzAddtime = gzAddtime;
	}

	public String getGzUptime() {
		return gzUptime;
	}

	public void setGzUptime(String gzUptime) {
		this.gzUptime = gzUptime;
	}

	public Integer getGzStart() {
        return gzStart;
    }

    public void setGzStart(Integer gzStart) {
        this.gzStart = gzStart;
    }
}