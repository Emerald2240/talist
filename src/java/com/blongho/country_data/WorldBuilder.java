package com.blongho.country_data;

import android.content.Context;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class WorldBuilder {
    private static Map<Country, Integer> countryFlagMap = new HashMap();
    private static Map<String, Currency> currencyMap = new HashMap();
    private static WorldBuilder instance;
    private static Country universe;

    private WorldBuilder(Context context) {
        loadAllData(context);
    }

    static WorldBuilder getInstance(Context context) {
        WorldBuilder worldBuilder = instance;
        if (worldBuilder != null) {
            return worldBuilder;
        }
        synchronized (WorldBuilder.class) {
            if (instance == null) {
                instance = new WorldBuilder(context);
            }
        }
        return instance;
    }

    static List<Currency> currencies() {
        return Collections.unmodifiableList(new ArrayList(currencyMap.values()));
    }

    static List<Country> countries() {
        return Collections.unmodifiableList(new ArrayList(countryFlagMap.keySet()));
    }

    static int globe() {
        return R.drawable.globe;
    }

    static int flagFromCountry(String str) {
        for (Country country : countryFlagMap.keySet()) {
            if (country.hasProperty(str)) {
                return country.getFlagResource();
            }
        }
        return globe();
    }

    static Country countryFrom(String str) {
        for (Country country : countryFlagMap.keySet()) {
            if (country.hasProperty(str)) {
                return country;
            }
        }
        return universe;
    }

    private void loadAllData(Context context) {
        Country[] countries = getCountries(context);
        getCurrencies(context);
        for (Country country : countries) {
            int i;
            if (country.getAlpha2().equalsIgnoreCase("do")) {
                i = R.drawable.dominican;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("drawable/");
                stringBuilder.append(country.getAlpha2().toLowerCase());
                i = context.getResources().getIdentifier(stringBuilder.toString(), null, context.getPackageName());
            }
            country.setFlagResource(i);
            country.setCurrency((Currency) currencyMap.get(country.getAlpha2().toLowerCase()));
            countryFlagMap.put(country, Integer.valueOf(i));
            if (country.getAlpha2().equalsIgnoreCase("xx")) {
                universe = country;
            }
        }
    }

    private Country[] getCountries(Context context) {
        return (Country[]) new Gson().fromJson(AssetsReader.readFromAssets(context, R.raw.com_blongho_country_data_countries), Country[].class);
    }

    private void getCurrencies(Context context) {
        for (Currency currency : (Currency[]) new Gson().fromJson(AssetsReader.readFromAssets(context, R.raw.com_blongho_country_data_currencies), Currency[].class)) {
            currencyMap.put(currency.getCountry().toLowerCase(), currency);
        }
    }
}
