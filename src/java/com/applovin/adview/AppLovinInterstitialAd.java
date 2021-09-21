package com.applovin.adview;

import android.content.Context;
import com.applovin.impl.adview.InterstitialAdDialogCreatorImpl;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;

public class AppLovinInterstitialAd {
   private AppLovinInterstitialAdDialog a = null;

   public static AppLovinInterstitialAdDialog create(AppLovinSdk var0, Context var1) {
      if (var0 != null) {
         if (var1 != null) {
            return (new InterstitialAdDialogCreatorImpl()).createInterstitialAdDialog(var0, var1);
         } else {
            throw new IllegalArgumentException("No context specified");
         }
      } else {
         throw new IllegalArgumentException("No sdk specified");
      }
   }

   @Deprecated
   public static boolean isAdReadyToDisplay(Context var0) {
      return AppLovinSdk.getInstance(var0).getAdService().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
   }

   public static void show(Context var0) {
      show(var0, (String)null);
   }

   @Deprecated
   public static void show(Context var0, String var1) {
      if (var0 != null) {
         AppLovinSdk var2 = AppLovinSdk.getInstance(var0);
         if (var2 != null && !var2.hasCriticalErrors()) {
            show(var2, var0, var1);
         }

      } else {
         throw new IllegalArgumentException("No context specified");
      }
   }

   @Deprecated
   public static void show(final AppLovinSdk var0, final Context var1, final String var2) {
      if (var0 != null) {
         if (var1 != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
               public void run() {
                  (new InterstitialAdDialogCreatorImpl()).createInterstitialAdDialog(var0, var1).show(var2);
               }
            });
         } else {
            throw new IllegalArgumentException("No context specified");
         }
      } else {
         throw new IllegalArgumentException("No sdk specified");
      }
   }

   public String toString() {
      return "AppLovinInterstitialAd{}";
   }
}
