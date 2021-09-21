package com.applovin.mediation;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.applovin.sdk.AppLovinSdk;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;

public class AppLovinNativeAdapter implements MediationNativeAdapter {
   public static final String KEY_EXTRA_AD_ID = "ad_id";
   public static final String KEY_EXTRA_CAPTION_TEXT = "caption_text";
   static final String TAG = AppLovinNativeAdapter.class.getSimpleName();

   public void onDestroy() {
   }

   public void onPause() {
   }

   public void onResume() {
   }

   public void requestNativeAd(Context var1, MediationNativeListener var2, Bundle var3, NativeMediationAdRequest var4, Bundle var5) {
      if (!var4.isUnifiedNativeAdRequested() && !var4.isAppInstallAdRequested()) {
         Log.e(TAG, "Failed to request native ad. Unified Native Ad or App install Ad should be requested");
         var2.onAdFailedToLoad(this, 1);
      } else {
         AppLovinSdk var6 = AppLovinUtils.retrieveSdk(var3, var1);
         AppLovinNativeAdListener var7 = new AppLovinNativeAdListener(this, var2, var6, var1, var4);
         var6.getNativeAdService().loadNativeAds(1, var7);
      }
   }
}
