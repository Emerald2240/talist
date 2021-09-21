package com.applovin.impl.sdk;

class d$1 implements Runnable {
   // $FF: synthetic field
   final d a;

   d$1(d var1) {
      this.a = var1;
   }

   public void run() {
      d.a(this.a);
      d.a var1 = (d.a)d.b(this.a).get();
      if (var1 != null) {
         var1.onAdRefresh();
      }

   }
}
