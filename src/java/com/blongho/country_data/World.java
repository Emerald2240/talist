package com.blongho.country_data;

import android.content.Context;
import com.blongho.country_data.exception.CountryDataException;
import java.util.List;

public final class World {
    private static WorldBuilder instance;

    public static void init(Context context) {
        instance = WorldBuilder.getInstance(context);
    }

    public static int getFlagOf(int i) {
        if (instance != null) {
            return getFlagOf(String.valueOf(i));
        }
        throw new CountryDataException("You have to call World.init(getApplicationContext()) before this method.");
    }

    public static int getFlagOf(String str) {
        if (instance == null) {
            throw new CountryDataException("You have to call World.init(getApplicationContext()) before this method.");
        } else if (str.isEmpty()) {
            return getWorldFlag();
        } else {
            return WorldBuilder.flagFromCountry(str);
        }
    }

    public static int getWorldFlag() {
        if (instance != null) {
            return WorldBuilder.globe();
        }
        throw new CountryDataException("You have to call World.init(getApplicationContext()) before this method.");
    }

    public static Country getCountryFrom(int i) {
        if (instance != null) {
            return getCountryFrom(String.valueOf(i));
        }
        throw new CountryDataException("You have to call World.init(getApplicationContext()) before this method.");
    }

    public static Country getCountryFrom(String str) {
        if (instance != null) {
            return WorldBuilder.countryFrom(str);
        }
        throw new CountryDataException("You have to call World.init(getApplicationContext()) before this method.");
    }

    public static List<Country> getAllCountries() {
        if (instance != null) {
            return WorldBuilder.countries();
        }
        throw new CountryDataException("You have to call World.init(getApplicationContext()) before this method.");
    }

    public static List<Currency> getAllCurrencies() {
        if (instance != null) {
            return WorldBuilder.currencies();
        }
        throw new CountryDataException("You have to call World.init(getApplicationContext()) before this method.");
    }
}
