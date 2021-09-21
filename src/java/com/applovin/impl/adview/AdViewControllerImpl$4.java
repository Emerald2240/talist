package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;

class AdViewControllerImpl$4 implements Runnable {
   // $FF: synthetic field
   final AppLovinAd a;
   // $FF: synthetic field
   final AdViewControllerImpl b;

   AdViewControllerImpl$4(AdViewControllerImpl var1, AppLovinAd var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      try {
         if (AdViewControllerImpl.m(this.b) != null) {
            AdViewControllerImpl.m(this.b).adReceived(this.a);
            return;
         }
      } catch (Throwable var4) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Exception while running ad load callback: ");
         var2.append(var4.getMessage());
         com.applovin.impl.sdk.p.j("AppLovinAdView", var2.toString());
         return;
      }

   }
}
