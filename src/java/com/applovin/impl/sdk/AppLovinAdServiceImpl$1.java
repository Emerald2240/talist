package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;

class AppLovinAdServiceImpl$1 implements Runnable {
   // $FF: synthetic field
   final AppLovinAdLoadListener a;
   // $FF: synthetic field
   final AppLovinAd b;
   // $FF: synthetic field
   final AppLovinAdServiceImpl c;

   AppLovinAdServiceImpl$1(AppLovinAdServiceImpl var1, AppLovinAdLoadListener var2, AppLovinAd var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void run() {
      try {
         this.a.adReceived(this.b);
      } catch (Throwable var3) {
         p.c("AppLovinAdService", "Unable to notify listener about a newly loaded ad", var3);
         return;
      }
   }
}
