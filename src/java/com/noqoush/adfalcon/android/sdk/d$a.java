package com.noqoush.adfalcon.android.sdk;

class d$a implements Runnable {
   // $FF: synthetic field
   final d a;

   d$a(d var1) {
      this.a = var1;
   }

   public void run() {
      try {
         d.a(this.a).i().destroy();
      } catch (Exception var2) {
      }
   }
}
