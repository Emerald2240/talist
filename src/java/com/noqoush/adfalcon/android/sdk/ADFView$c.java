package com.noqoush.adfalcon.android.sdk;

import java.util.TimerTask;

class ADFView$c extends TimerTask {
   // $FF: synthetic field
   final ADFView a;

   ADFView$c(ADFView var1) {
      this.a = var1;
   }

   public void run() {
      this.a.post(new ADFView$c$a(this));
   }
}
