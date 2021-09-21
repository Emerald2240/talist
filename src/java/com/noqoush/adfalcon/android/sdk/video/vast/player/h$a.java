package com.noqoush.adfalcon.android.sdk.video.vast.player;

import java.util.TimerTask;

class h$a extends TimerTask {
   int a;
   // $FF: synthetic field
   final h b;

   h$a(h var1) {
      this.b = var1;
      this.a = -1;
   }

   public void run() {
      try {
         this.b.post(new h$a$a(this));
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }
}
