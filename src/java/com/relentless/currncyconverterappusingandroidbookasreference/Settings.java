package com.relentless.currncyconverterappusingandroidbookasreference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class Settings extends AppCompatActivity {
    public static final String PREF_AUTO_UPDATE = "PREF_AUTO_UPDATE";
    public static final String PREF_UPDATE_FREQ = "PREF_UPDATE_FREQ";
    CheckBox AutoUpdate;
    Button cancelbutton;
    Button okbutton;
    SharedPreferences preferences;
    Spinner updateFrequencySpinner;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        this.AutoUpdate = (CheckBox) findViewById(R.id.checkBox);
        this.updateFrequencySpinner = (Spinner) findViewById(R.id.spinner);
        this.okbutton = (Button) findViewById(R.id.okButton);
        this.cancelbutton = (Button) findViewById(R.id.cancelButton);
        populateSpinners();
        getApplicationContext();
        this.preferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.okbutton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Settings.this.savePreferences();
                Settings.this.setResult(-1);
                Settings.this.finish();
            }
        });
        this.cancelbutton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Settings.this.savePreferences();
                Settings.this.setResult(0);
                Settings.this.finish();
            }
        });
    }

    private void populateSpinners() {
        ArrayAdapter createFromResource = ArrayAdapter.createFromResource(this, R.array.update_frequency_entries, 17367048);
        createFromResource.setDropDownViewResource(17367049);
        this.updateFrequencySpinner.setAdapter(createFromResource);
    }

    private void savePreferences() {
        int selectedItemPosition = this.updateFrequencySpinner.getSelectedItemPosition();
        boolean isChecked = this.AutoUpdate.isChecked();
        Editor edit = this.preferences.edit();
        edit.putBoolean(PREF_AUTO_UPDATE, isChecked);
        edit.putInt(PREF_UPDATE_FREQ, selectedItemPosition);
        edit.commit();
    }
}
