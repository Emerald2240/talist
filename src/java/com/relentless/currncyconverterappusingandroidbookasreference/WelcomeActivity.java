package com.relentless.currncyconverterappusingandroidbookasreference;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class WelcomeActivity extends AppCompatActivity {
    ViewPager viewPager;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_welcome);
        this.viewPager = (ViewPager) findViewById(R.id.welcomeviewpager);
        this.viewPager.setAdapter(new IntroAdapter(getSupportFragmentManager(), 0));
    }
}
