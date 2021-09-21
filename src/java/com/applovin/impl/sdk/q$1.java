package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;

class q$1 implements AppLovinNativeAdPrecacheListener {
   // $FF: synthetic field
   final q a;

   q$1(q var1) {
      this.a = var1;
   }

   public void onNativeAdImagePrecachingFailed(AppLovinNativeAd var1, int var2) {
      q var3 = this.a;
      var3.c(com.applovin.impl.sdk.ad.d.h(var3.a), var2);
   }

   public void onNativeAdImagesPrecached(AppLovinNativeAd var1) {
      if (!com.applovin.impl.sdk.utils.n.b(var1.getVideoUrl())) {
         this.a.b((com.applovin.impl.sdk.ad.j)var1);
      }

   }

   public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd var1, int var2) {
      p var3 = this.a.b;
      StringBuilder var4 = new StringBuilder();
      var4.append("Video failed to cache during native ad preload. ");
      var4.append(var2);
      var3.d("NativeAdPreloadManager", var4.toString());
      this.a.b((com.applovin.impl.sdk.ad.j)var1);
   }

   public void onNativeAdVideoPreceached(AppLovinNativeAd var1) {
      this.a.b((com.applovin.impl.sdk.ad.j)var1);
   }
}
