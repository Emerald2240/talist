package com.applovin.impl.adview;

class AdViewControllerImpl$5 implements Runnable {
   // $FF: synthetic field
   final int a;
   // $FF: synthetic field
   final AdViewControllerImpl b;

   AdViewControllerImpl$5(AdViewControllerImpl var1, int var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      try {
         if (AdViewControllerImpl.m(this.b) != null) {
            AdViewControllerImpl.m(this.b).failedToReceiveAd(this.a);
            return;
         }
      } catch (Throwable var3) {
         com.applovin.impl.sdk.p.c("AppLovinAdView", "Exception while running app load  callback", var3);
         return;
      }

   }
}
