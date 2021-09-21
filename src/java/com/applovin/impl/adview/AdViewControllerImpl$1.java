package com.applovin.impl.adview;

class AdViewControllerImpl$1 implements Runnable {
   // $FF: synthetic field
   final AdViewControllerImpl a;

   AdViewControllerImpl$1(AdViewControllerImpl var1) {
      this.a = var1;
   }

   public void run() {
      if (AdViewControllerImpl.a(this.a) != null) {
         com.applovin.impl.sdk.p var1 = AdViewControllerImpl.b(this.a);
         StringBuilder var2 = new StringBuilder();
         var2.append("Detaching expanded ad: ");
         var2.append(AdViewControllerImpl.a(this.a).a());
         var1.b("AppLovinAdView", var2.toString());
         AdViewControllerImpl var5 = this.a;
         AdViewControllerImpl.a(var5, AdViewControllerImpl.a(var5));
         AdViewControllerImpl.b((AdViewControllerImpl)this.a, (k)null);
         AdViewControllerImpl var8 = this.a;
         AdViewControllerImpl.a(var8, AdViewControllerImpl.c(var8));
      }

   }
}
