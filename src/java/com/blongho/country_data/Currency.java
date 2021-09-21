package com.blongho.country_data;

public final class Currency {
    private final String code;
    private final String country;
    private final String name;
    private final String symbol;

    Currency(String str, String str2, String str3, String str4) {
        this.country = str;
        this.name = str2;
        this.code = str3;
        this.symbol = str4;
    }

    public String getCountry() {
        return this.country;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String str = this.country;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.code;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.symbol;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Currency)) {
            return false;
        }
        Currency currency = (Currency) obj;
        String str = this.country;
        if (!str == null ? str.equals(currency.country) : currency.country == null) {
            return false;
        }
        str = this.name;
        if (!str == null ? str.equals(currency.name) : currency.name == null) {
            return false;
        }
        str = this.code;
        if (!str == null ? str.equals(currency.code) : currency.code == null) {
            return false;
        }
        str = this.symbol;
        String str2 = currency.symbol;
        if (str != null) {
            z = str.equals(str2);
        } else if (str2 != null) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Currency [country=");
        stringBuilder.append(this.country);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", code=");
        stringBuilder.append(this.code);
        stringBuilder.append(", symbol=");
        stringBuilder.append(this.symbol);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
