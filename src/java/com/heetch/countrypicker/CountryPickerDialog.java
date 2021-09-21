package com.heetch.countrypicker;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.view.ViewCompat;
import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class CountryPickerDialog extends AppCompatDialog {
    private CountryPickerCallbacks callbacks;
    private List<Country> countries;
    private String headingCountryCode;
    private ListView listview;
    private boolean showDialingCode;

    public CountryPickerDialog(Context context, CountryPickerCallbacks countryPickerCallbacks) {
        this(context, countryPickerCallbacks, null, true);
    }

    public CountryPickerDialog(Context context, CountryPickerCallbacks countryPickerCallbacks, String str) {
        this(context, countryPickerCallbacks, str, true);
    }

    public CountryPickerDialog(Context context, CountryPickerCallbacks countryPickerCallbacks, String str, boolean z) {
        super(context);
        this.callbacks = countryPickerCallbacks;
        this.headingCountryCode = str;
        this.showDialingCode = z;
        this.countries = Utils.parseCountries(Utils.getCountriesJSON(getContext()));
        Collections.sort(this.countries, new Comparator<Country>() {
            public int compare(Country country, Country country2) {
                Locale locale = CountryPickerDialog.this.getContext().getResources().getConfiguration().locale;
                Collator instance = Collator.getInstance(locale);
                instance.setStrength(0);
                return instance.compare(new Locale(locale.getLanguage(), country.getIsoCode()).getDisplayCountry(), new Locale(locale.getLanguage(), country2.getIsoCode()).getDisplayCountry());
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.country_picker);
        ViewCompat.setElevation(getWindow().getDecorView(), 3.0f);
        this.listview = (ListView) findViewById(R.id.country_picker_listview);
        this.listview.setAdapter(new CountryListAdapter(getContext(), this.countries, this.showDialingCode));
        this.listview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                CountryPickerDialog.this.hide();
                Country country = (Country) CountryPickerDialog.this.countries.get(i);
                CountryPickerCallbacks access$100 = CountryPickerDialog.this.callbacks;
                Context context = CountryPickerDialog.this.getContext();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(country.getIsoCode().toLowerCase(Locale.ENGLISH));
                stringBuilder.append("_flag");
                access$100.onCountrySelected(country, Utils.getMipmapResId(context, stringBuilder.toString()));
            }
        });
        scrollToHeadingCountry();
    }

    private void scrollToHeadingCountry() {
        if (this.headingCountryCode != null) {
            for (int i = 0; i < this.listview.getCount(); i++) {
                if (((Country) this.listview.getItemAtPosition(i)).getIsoCode().toLowerCase().equals(this.headingCountryCode.toLowerCase())) {
                    this.listview.setSelection(i);
                }
            }
        }
    }

    public Country getCountryFromIsoCode(String str) {
        for (int i = 0; i < this.countries.size(); i++) {
            if (((Country) this.countries.get(i)).getIsoCode().equals(str.toUpperCase())) {
                return (Country) this.countries.get(i);
            }
        }
        return null;
    }
}
