package com.blongho.country_data.exception;

public class CountryDataException extends UnsupportedOperationException {
    public CountryDataException(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.blongho.worldCountryData -> ");
        stringBuilder.append(str);
        super(stringBuilder.toString());
    }
}
