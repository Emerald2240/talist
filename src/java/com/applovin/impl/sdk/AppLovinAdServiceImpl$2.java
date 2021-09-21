package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAdLoadListener;

class AppLovinAdServiceImpl$2 implements Runnable {
   // $FF: synthetic field
   final AppLovinAdLoadListener a;
   // $FF: synthetic field
   final int b;
   // $FF: synthetic field
   final AppLovinAdServiceImpl c;

   AppLovinAdServiceImpl$2(AppLovinAdServiceImpl var1, AppLovinAdLoadListener var2, int var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void run() {
      try {
         this.a.failedToReceiveAd(this.b);
      } catch (Throwable var3) {
         p.c("AppLovinAdService", "Unable to notify listener about ad load failure", var3);
         return;
      }
   }
}
