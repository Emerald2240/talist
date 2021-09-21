package com.heetch.countrypicker;

public class Country {
    private String dialingCode;
    private String isoCode;

    public Country(String str, String str2) {
        this.isoCode = str;
        this.dialingCode = str2;
    }

    public String getIsoCode() {
        return this.isoCode;
    }

    public void setIsoCode(String str) {
        this.isoCode = str;
    }

    public String getDialingCode() {
        return this.dialingCode;
    }

    public void setDialingCode(String str) {
        this.dialingCode = str;
    }
}
