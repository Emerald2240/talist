package com.relentless.currncyconverterappusingandroidbookasreference;

import android.util.Log;

class MainActivity$4 implements Runnable {
   // $FF: synthetic field
   final MainActivity this$0;

   MainActivity$4(MainActivity var1) {
      this.this$0 = var1;
   }

   public void run() {
      if (!this.this$0.justopened) {
         if (MainActivity.access$000(this.this$0).isLoaded()) {
            MainActivity.access$000(this.this$0).show();
            return;
         }
      } else {
         Log.d("TAG", "The Interstitial wasn't loaded yet.");
      }

   }
}
