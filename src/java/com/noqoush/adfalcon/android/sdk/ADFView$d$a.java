package com.noqoush.adfalcon.android.sdk;

class ADFView$d$a implements Runnable {
   // $FF: synthetic field
   final ADFView$d a;

   ADFView$d$a(ADFView$d var1) {
      this.a = var1;
   }

   public void run() {
      try {
         this.a.a.removeView(this.a.a.findViewById(101));
         this.a.a.removeView(this.a.a.findViewById(102));
      } catch (Exception var2) {
      }
   }
}
