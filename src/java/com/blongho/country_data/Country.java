package com.blongho.country_data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Country {
    private static final Map<String, String> CONTINENTS = Collections.unmodifiableMap(new HashMap<String, String>() {
        {
            put("AF", "Africa");
            put("AS", "Asia");
            put("NA", "North America");
            put("SA", "South America");
            put("OC", "Oceania");
            put("EU", "Europe");
            put("AN", "Antarctica");
            put("UNX", "Universe");
        }
    });
    private final String alpha2;
    private final String alpha3;
    private final String area;
    private final String capital;
    private final String continent;
    private Currency currency;
    private int flagResource;
    private final String id;
    private final String name;
    private final String population;

    Country(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Currency currency) {
        this.id = str;
        this.name = str2;
        this.alpha2 = str3;
        this.alpha3 = str4;
        this.capital = str5;
        this.continent = str6;
        this.area = str7;
        this.population = str8;
        this.flagResource = i;
        this.currency = currency;
    }

    public final int getId() {
        return Integer.valueOf(this.id).intValue();
    }

    public final String getCapital() {
        return this.capital;
    }

    public final String getContinent() {
        return (String) CONTINENTS.get(this.continent);
    }

    public final double getArea() {
        return Double.parseDouble(formatStringToNumber(this.area).replace(".0", ""));
    }

    public final long getPopulation() {
        return Long.parseLong(formatStringToNumber(this.population));
    }

    public final String getName() {
        return this.name;
    }

    public final String getAlpha2() {
        return this.alpha2;
    }

    public final String getAlpha3() {
        return this.alpha3;
    }

    public final int getFlagResource() {
        return this.flagResource;
    }

    /* Access modifiers changed, original: 0000 */
    public void setFlagResource(int i) {
        this.flagResource = i;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Country country = (Country) obj;
        String str = this.id;
        if (!str == null ? str.equals(country.id) : country.id == null) {
            return false;
        }
        str = this.name;
        if (!str == null ? str.equals(country.name) : country.name == null) {
            return false;
        }
        str = this.alpha2;
        if (!str == null ? str.equals(country.alpha2) : country.alpha2 == null) {
            return false;
        }
        str = this.alpha3;
        String str2 = country.alpha3;
        if (str != null) {
            z = str.equals(str2);
        } else if (str2 != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.alpha2;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.alpha3;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final Currency getCurrency() {
        return this.currency;
    }

    /* Access modifiers changed, original: 0000 */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Country{id='");
        stringBuilder.append(this.id);
        stringBuilder.append('\'');
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", alpha2='");
        stringBuilder.append(this.alpha2);
        stringBuilder.append('\'');
        stringBuilder.append(", alpha3='");
        stringBuilder.append(this.alpha3);
        stringBuilder.append('\'');
        stringBuilder.append(", capital='");
        stringBuilder.append(this.capital);
        stringBuilder.append('\'');
        stringBuilder.append(", contitent='");
        stringBuilder.append(getContinent());
        stringBuilder.append('\'');
        stringBuilder.append(", area='");
        stringBuilder.append(getArea());
        stringBuilder.append('\'');
        stringBuilder.append(", population='");
        stringBuilder.append(getPopulation());
        stringBuilder.append('\'');
        stringBuilder.append(", flagResource=");
        stringBuilder.append(this.flagResource);
        stringBuilder.append(", currency=");
        stringBuilder.append(this.currency);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    private String formatStringToNumber(String str) {
        return str.replaceAll(",", "");
    }

    /* Access modifiers changed, original: 0000 */
    public boolean hasProperty(String str) {
        return str.equalsIgnoreCase(this.alpha2) || str.equalsIgnoreCase(this.alpha3) || str.equalsIgnoreCase(this.name) || str.equalsIgnoreCase(String.valueOf(getId()));
    }
}
