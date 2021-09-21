package com.noqoush.adfalcon.android.sdk;

class ADFView$c$a implements Runnable {
   // $FF: synthetic field
   final ADFView$c a;

   ADFView$c$a(ADFView$c var1) {
      this.a = var1;
   }

   public void run() {
      try {
         ADFView.b(this.a.a);
      } catch (Exception var2) {
         k.b(var2.getMessage());
      }
   }
}
