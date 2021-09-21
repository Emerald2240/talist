package com.noqoush.adfalcon.android.sdk;

class ADFBrowser$a implements Runnable {
   // $FF: synthetic field
   final z a;
   // $FF: synthetic field
   final ADFBrowser b;

   ADFBrowser$a(ADFBrowser var1, z var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      try {
         this.a.destroy();
      } catch (Exception var2) {
      }
   }
}
