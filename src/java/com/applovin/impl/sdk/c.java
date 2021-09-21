package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Iterator;
import java.util.List;

public class c extends r {
   c(j var1) {
      super(var1);
   }

   com.applovin.impl.sdk.ad.d a(com.applovin.impl.sdk.ad.j var1) {
      return ((AppLovinAdBase)var1).getAdZone();
   }

   com.applovin.impl.sdk.d.a a(com.applovin.impl.sdk.ad.d var1) {
      com.applovin.impl.sdk.d.m var2 = new com.applovin.impl.sdk.d.m(var1, this, this.a);
      var2.a(true);
      return var2;
   }

   public void a() {
      Iterator var1 = com.applovin.impl.sdk.ad.d.b(this.a).iterator();

      while(var1.hasNext()) {
         com.applovin.impl.sdk.ad.d var2 = (com.applovin.impl.sdk.ad.d)var1.next();
         if (!var2.d()) {
            this.h(var2);
         }
      }

   }

   public void a(com.applovin.impl.sdk.ad.d var1, int var2) {
      this.c(var1, var2);
   }

   void a(Object var1, com.applovin.impl.sdk.ad.d var2, int var3) {
      if (var1 instanceof m) {
         ((m)var1).a(var2, var3);
      }

      if (var1 instanceof AppLovinAdLoadListener) {
         ((AppLovinAdLoadListener)var1).failedToReceiveAd(var3);
      }

   }

   void a(Object var1, com.applovin.impl.sdk.ad.j var2) {
      ((AppLovinAdLoadListener)var1).adReceived((AppLovinAd)var2);
   }

   public void adReceived(AppLovinAd var1) {
      this.b((com.applovin.impl.sdk.ad.j)var1);
   }

   public void failedToReceiveAd(int var1) {
   }

   public void onNativeAdsFailedToLoad(int var1) {
   }

   public void onNativeAdsLoaded(List var1) {
   }
}
