package com.applovin.impl.mediation.ads;

class MaxAdViewImpl$2$1$1 implements Runnable {
   // $FF: synthetic field
   final MaxAdViewImpl$2$1 a;

   MaxAdViewImpl$2$1$1(MaxAdViewImpl$2$1 var1) {
      this.a = var1;
   }

   public void run() {
      long var1 = MaxAdViewImpl.b(this.a.b.b).a(this.a.b.a);
      if (!this.a.b.a.r()) {
         MaxAdViewImpl.a(this.a.b.b, this.a.b.a, var1);
      }

      MaxAdViewImpl.a(this.a.b.b, var1);
   }
}
