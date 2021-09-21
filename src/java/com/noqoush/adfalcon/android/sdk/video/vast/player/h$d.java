package com.noqoush.adfalcon.android.sdk.video.vast.player;

import java.util.TimerTask;

class h$d extends TimerTask {
   // $FF: synthetic field
   final h a;

   h$d(h var1) {
      this.a = var1;
   }

   public void run() {
      try {
         this.a.post(new h$d$a(this));
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }
}
