package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.NativeAdImpl;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinAd;
import java.util.Arrays;
import java.util.List;

public class q extends r {
   q(j var1) {
      super(var1);
   }

   com.applovin.impl.sdk.ad.d a(com.applovin.impl.sdk.ad.j var1) {
      return ((NativeAdImpl)var1).getAdZone();
   }

   com.applovin.impl.sdk.d.a a(com.applovin.impl.sdk.ad.d var1) {
      return new com.applovin.impl.sdk.d.n((String)null, 1, this.a, this);
   }

   public void a() {
      this.h(com.applovin.impl.sdk.ad.d.h(this.a));
   }

   public void a(com.applovin.impl.sdk.ad.d var1, int var2) {
   }

   void a(Object var1, com.applovin.impl.sdk.ad.d var2, int var3) {
      ((AppLovinNativeAdLoadListener)var1).onNativeAdsFailedToLoad(var3);
   }

   void a(Object var1, com.applovin.impl.sdk.ad.j var2) {
      AppLovinNativeAd[] var3 = new AppLovinNativeAd[]{(AppLovinNativeAd)var2};
      List var4 = Arrays.asList(var3);
      ((AppLovinNativeAdLoadListener)var1).onNativeAdsLoaded(var4);
   }

   public void adReceived(AppLovinAd var1) {
   }

   public void failedToReceiveAd(int var1) {
   }

   public void onNativeAdsFailedToLoad(int var1) {
      this.c(com.applovin.impl.sdk.ad.d.h(this.a), var1);
   }

   public void onNativeAdsLoaded(List var1) {
      AppLovinNativeAd var2 = (AppLovinNativeAd)var1.get(0);
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.bJ)) {
         this.a.p().precacheResources(var2, new q$1(this));
      } else {
         this.b((com.applovin.impl.sdk.ad.j)var2);
      }
   }
}
