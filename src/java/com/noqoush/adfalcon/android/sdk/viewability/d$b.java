package com.noqoush.adfalcon.android.sdk.viewability;

class d$b implements Runnable {
   // $FF: synthetic field
   final d a;

   d$b(d var1) {
      this.a = var1;
   }

   public void run() {
      try {
         d.a(this.a);
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }
}
