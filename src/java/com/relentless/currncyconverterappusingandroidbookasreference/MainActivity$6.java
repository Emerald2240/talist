package com.relentless.currncyconverterappusingandroidbookasreference;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class MainActivity$6 implements OnClickListener {
   // $FF: synthetic field
   final MainActivity this$0;

   MainActivity$6(MainActivity var1) {
      this.this$0 = var1;
   }

   public void onClick(View var1) {
      Intent var2 = new Intent(this.this$0, PreferenceActivity.class);
      this.this$0.startActivityForResult(var2, 1);
   }
}
