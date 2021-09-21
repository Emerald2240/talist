package com.applovin.mediation;

import android.content.Context;
import android.util.Log;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.lang.ref.WeakReference;
import java.util.List;

class AppLovinNativeAdListener implements AppLovinNativeAdLoadListener, AppLovinNativeAdPrecacheListener {
   private final AppLovinNativeAdapter mAdapter;
   private final WeakReference mContextWeakReference;
   private final NativeMediationAdRequest mMediationAdRequest;
   private final MediationNativeListener mNativeListener;
   private final AppLovinSdk mSdk;

   public AppLovinNativeAdListener(AppLovinNativeAdapter var1, MediationNativeListener var2, AppLovinSdk var3, Context var4, NativeMediationAdRequest var5) {
      this.mAdapter = var1;
      this.mNativeListener = var2;
      this.mSdk = var3;
      this.mContextWeakReference = new WeakReference(var4);
      this.mMediationAdRequest = var5;
   }

   // $FF: synthetic method
   static AppLovinNativeAdapter access$000(AppLovinNativeAdListener var0) {
      return var0.mAdapter;
   }

   // $FF: synthetic method
   static MediationNativeListener access$100(AppLovinNativeAdListener var0) {
      return var0.mNativeListener;
   }

   private static boolean isValidNativeAd(AppLovinNativeAd var0) {
      return var0.getImageUrl() != null && var0.getIconUrl() != null && var0.getTitle() != null && var0.getDescriptionText() != null && var0.getCtaText() != null;
   }

   private void notifyAdFailure(int var1) {
      AppLovinSdkUtils.runOnUiThread(new AppLovinNativeAdListener$3(this, var1));
   }

   public void onNativeAdImagePrecachingFailed(AppLovinNativeAd var1, int var2) {
      String var3 = AppLovinNativeAdapter.TAG;
      StringBuilder var4 = new StringBuilder();
      var4.append("Native ad failed to pre cache images ");
      var4.append(var2);
      Log.e(var3, var4.toString());
      this.notifyAdFailure(AppLovinUtils.toAdMobErrorCode(var2));
   }

   public void onNativeAdImagesPrecached(AppLovinNativeAd var1) {
      Context var2 = (Context)this.mContextWeakReference.get();
      if (var2 == null) {
         Log.e(AppLovinNativeAdapter.TAG, "Failed to create mapper. Context is null.");
         this.notifyAdFailure(0);
      } else {
         if (this.mMediationAdRequest.isUnifiedNativeAdRequested()) {
            AppLovinUnifiedNativeAdMapper var3 = new AppLovinUnifiedNativeAdMapper(var2, var1);
            Log.d(AppLovinNativeAdapter.TAG, "UnifiedNativeAd loaded.");
            AppLovinSdkUtils.runOnUiThread(new AppLovinNativeAdListener$1(this, var3));
         } else if (this.mMediationAdRequest.isAppInstallAdRequested()) {
            AppLovinNativeAdMapper var5 = new AppLovinNativeAdMapper(var1, var2);
            Log.d(AppLovinNativeAdapter.TAG, "AppInstallAd loaded.");
            AppLovinSdkUtils.runOnUiThread(new AppLovinNativeAdListener$2(this, var5));
            return;
         }

      }
   }

   public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd var1, int var2) {
   }

   public void onNativeAdVideoPreceached(AppLovinNativeAd var1) {
   }

   public void onNativeAdsFailedToLoad(int var1) {
      String var2 = AppLovinNativeAdapter.TAG;
      StringBuilder var3 = new StringBuilder();
      var3.append("Native ad failed to load ");
      var3.append(var1);
      Log.e(var2, var3.toString());
      this.notifyAdFailure(AppLovinUtils.toAdMobErrorCode(var1));
   }

   public void onNativeAdsLoaded(List var1) {
      if (var1.size() > 0 && isValidNativeAd((AppLovinNativeAd)var1.get(0))) {
         this.mSdk.getNativeAdService().precacheResources((AppLovinNativeAd)var1.get(0), this);
      } else {
         Log.e(AppLovinNativeAdapter.TAG, "Ad from AppLovin doesn't have all assets required for the app install ad format");
         this.notifyAdFailure(3);
      }
   }
}
