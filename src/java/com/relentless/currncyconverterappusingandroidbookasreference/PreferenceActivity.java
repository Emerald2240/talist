package com.relentless.currncyconverterappusingandroidbookasreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

public class PreferenceActivity extends AppCompatActivity {
    public static final String AUTO_UPDATE = "AUTO_UPDATE";
    public static final String AUTO_UPDATE_FREQ = "AUTO_UPDATE_FREQ";
    public static final String BASE_CURRENCY = "BASE_CURRENCY";
    public static final String FILTER = "FILTER";
    public static final String MAX_FILTER = "MAX_FILTER";
    public static final String MIN_FILTER = "MIN_FILTER";
    public static final String THEME = "THEME";
    public static final String THEMES_ON = "THEMES_ON";
    String Dataholdertemp = "";
    boolean autoupdate = false;
    String basecountry = "NG";
    int check = 1;
    boolean filter = false;
    int maxfilterfrequency = 0;
    int minfilterfrequency = 0;
    boolean theme = false;
    int themeval = 0;
    int updatefrequency = 0;

    public static class SettingsFragment extends PreferenceFragmentCompat {
        public void onCreatePreferences(Bundle bundle, String str) {
            setPreferencesFromResource(R.xml.root_preferences, str);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        updateFromPreferences();
        boolean z = this.theme;
        if (!z) {
            setTheme(R.style.AppTheme);
        } else if (z) {
            if (this.themeval == 0) {
                setTheme(R.style.AppTheme);
            }
            if (this.themeval == 1) {
                setTheme(R.style.DarkAppTheme);
            }
            if (this.themeval == 2) {
                setTheme(R.style.Grad1theme);
            }
            if (this.themeval == 3) {
                setTheme(R.style.Grad2theme);
            }
            if (this.themeval == 4) {
                setTheme(R.style.Grad3theme);
            }
            if (this.themeval == 5) {
                setTheme(R.style.Grad4theme);
            }
        }
        setContentView(R.layout.settings_activity);
        getSupportFragmentManager().beginTransaction().replace(R.id.settings, new SettingsFragment()).commit();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        enabledFullScreenMode();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.check != 1) {
            return super.onKeyDown(i, keyEvent);
        }
        setResult(-1, new Intent());
        finish();
        return true;
    }

    private void enabledFullScreenMode() {
        getWindow().setFlags(1024, 1024);
        getWindow().getDecorView().setSystemUiVisibility(4);
    }

    private void updateFromPreferences() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        this.autoupdate = defaultSharedPreferences.getBoolean("AUTO_UPDATE", false);
        this.filter = defaultSharedPreferences.getBoolean("FILTER", false);
        this.theme = defaultSharedPreferences.getBoolean("THEMES_ON", false);
        String str = "0";
        int parseInt = Integer.parseInt(defaultSharedPreferences.getString("AUTO_UPDATE_FREQ", str));
        if (parseInt < 0) {
            this.updatefrequency = 0;
        } else {
            this.updatefrequency = parseInt;
        }
        String string = defaultSharedPreferences.getString("BASE_CURRENCY", "US");
        if (string == "") {
            this.basecountry = "NG";
        } else {
            this.basecountry = string;
        }
        parseInt = Integer.parseInt(defaultSharedPreferences.getString("MAX_FILTER", "10000"));
        if (parseInt < 0) {
            this.maxfilterfrequency = 1000;
        } else {
            this.maxfilterfrequency = parseInt;
        }
        parseInt = Integer.parseInt(defaultSharedPreferences.getString("MIN_FILTER", "1"));
        if (parseInt < 0) {
            this.minfilterfrequency = 0;
        } else {
            this.minfilterfrequency = parseInt;
        }
        int parseInt2 = Integer.parseInt(defaultSharedPreferences.getString("THEME", str));
        if (parseInt2 < 0) {
            this.themeval = 0;
        } else {
            this.themeval = parseInt2;
        }
    }
}
