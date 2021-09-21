package com.relentless.currncyconverterappusingandroidbookasreference;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Welcome2Activity extends AppCompatActivity {
    ImageView imgTA;
    Animation tanim10;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_welcome2);
        this.imgTA = (ImageView) findViewById(R.id.imageView2);
        this.tanim10 = AnimationUtils.loadAnimation(this, R.anim.textanim10);
        this.imgTA = (ImageView) findViewById(R.id.imageView2);
        this.imgTA.startAnimation(this.tanim10);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Welcome2Activity.this.startActivityForResult(new Intent(Welcome2Activity.this, WelcomeActivity.class), 1);
                Welcome2Activity.this.overridePendingTransition(R.anim.anim, R.anim.exitanim);
                Welcome2Activity.this.kill();
            }
        }, 5000);
        overridePendingTransition(R.anim.anim, R.anim.exitanim);
    }

    public void kill() {
        finish();
    }
}
