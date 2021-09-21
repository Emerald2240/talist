package com.relentless.currncyconverterappusingandroidbookasreference;

public class adderClass {
    private String countryCode;
    private String countryName;
    private int countryflag;
    private String currencyCode;
    private String currencyName;
    private Double difference;
    private Double originalrate;
    private int progress;
    private Double rate;

    /* Access modifiers changed, original: 0000 */
    public String getCountryName() {
        return this.countryName;
    }

    /* Access modifiers changed, original: 0000 */
    public String getCountryCode() {
        return this.countryCode;
    }

    /* Access modifiers changed, original: 0000 */
    public String getCurrencyName() {
        return this.currencyName;
    }

    /* Access modifiers changed, original: 0000 */
    public String getCurrencyCode() {
        return this.currencyCode;
    }

    /* Access modifiers changed, original: 0000 */
    public Double getRate() {
        return this.rate;
    }

    /* Access modifiers changed, original: 0000 */
    public int getCountryflag() {
        return this.countryflag;
    }

    /* Access modifiers changed, original: 0000 */
    public Double getOriginalrate() {
        return this.originalrate;
    }

    /* Access modifiers changed, original: 0000 */
    public int getProgress() {
        return this.progress;
    }

    /* Access modifiers changed, original: 0000 */
    public Double getDifference() {
        return this.difference;
    }

    adderClass(String str, String str2, String str3, String str4, Double d, int i, Double d2, int i2, Double d3) {
        this.countryName = str;
        this.countryCode = str2;
        this.currencyName = str3;
        this.currencyCode = str4;
        this.rate = d;
        this.countryflag = i;
        this.originalrate = d2;
        this.progress = i2;
        this.difference = d3;
    }

    public void setCountryName(String str) {
        this.countryName = str;
    }

    public void setRate(Double d) {
        this.rate = d;
    }

    public void setCurrencyName(String str) {
        this.currencyName = str;
    }

    public void setCurrencyCode(String str) {
        this.currencyCode = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setCountryflag(int i) {
        this.countryflag = i;
    }

    public void setOriginalrate(Double d) {
        this.originalrate = d;
    }

    public void setProgress(int i) {
        this.progress = i;
    }

    public void setDifference(Double d) {
        this.difference = d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.countryName);
        String str = " ";
        stringBuilder.append(str);
        stringBuilder.append(this.currencyName);
        stringBuilder.append(str);
        stringBuilder.append(this.countryCode);
        return stringBuilder.toString();
    }
}
