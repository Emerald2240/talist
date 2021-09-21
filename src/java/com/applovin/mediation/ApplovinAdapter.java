package com.applovin.mediation;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import java.util.HashMap;
import java.util.Queue;

public class ApplovinAdapter extends AppLovinMediationAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, OnContextChangedListener, MediationRewardedAd {
   private static final HashMap INTERSTITIAL_AD_QUEUES = new HashMap();
   private static final Object INTERSTITIAL_AD_QUEUES_LOCK = new Object();
   private static final boolean LOGGING_ENABLED = true;
   private AppLovinAdView mAdView;
   private Context mContext;
   private MediationInterstitialListener mMediationInterstitialListener;
   private Bundle mNetworkExtras;
   private AppLovinSdk mSdk;
   private String mZoneId;

   // $FF: synthetic method
   static String access$000(ApplovinAdapter var0) {
      return var0.mZoneId;
   }

   // $FF: synthetic method
   static Object access$100() {
      return INTERSTITIAL_AD_QUEUES_LOCK;
   }

   // $FF: synthetic method
   static HashMap access$200() {
      return INTERSTITIAL_AD_QUEUES;
   }

   // $FF: synthetic method
   static MediationInterstitialListener access$300(ApplovinAdapter var0) {
      return var0.mMediationInterstitialListener;
   }

   public static void log(int var0, String var1) {
      Log.println(var0, "AppLovinAdapter", var1);
   }

   public View getBannerView() {
      return this.mAdView;
   }

   public void onContextChanged(Context var1) {
      if (var1 != null) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Context changed: ");
         var2.append(var1);
         log(3, var2.toString());
         this.mContext = var1;
      }

   }

   public void onDestroy() {
   }

   public void onPause() {
   }

   public void onResume() {
   }

   public void requestBannerAd(Context var1, MediationBannerListener var2, Bundle var3, AdSize var4, MediationAdRequest var5, Bundle var6) {
      this.mSdk = AppLovinUtils.retrieveSdk(var3, var1);
      this.mZoneId = AppLovinUtils.retrieveZoneId(var3);
      StringBuilder var7 = new StringBuilder();
      var7.append("Requesting banner of size ");
      var7.append(var4);
      var7.append(" for zone: ");
      var7.append(this.mZoneId);
      log(3, var7.toString());
      AppLovinAdSize var12 = AppLovinUtils.appLovinAdSizeFromAdMobAdSize(var1, var4);
      if (var12 != null) {
         this.mAdView = new AppLovinAdView(this.mSdk, var12, var1);
         AppLovinBannerAdListener var13 = new AppLovinBannerAdListener(this.mZoneId, this.mAdView, this, var2);
         this.mAdView.setAdDisplayListener(var13);
         this.mAdView.setAdClickListener(var13);
         this.mAdView.setAdViewEventListener(var13);
         if (!TextUtils.isEmpty(this.mZoneId)) {
            this.mSdk.getAdService().loadNextAdForZoneId(this.mZoneId, var13);
         } else {
            this.mSdk.getAdService().loadNextAd(var12, var13);
         }

      } else {
         log(6, "Failed to request banner with unsupported size");
         if (var2 != null) {
            AppLovinSdkUtils.runOnUiThread(new ApplovinAdapter$3(this, var2));
         }

      }
   }

   public void requestInterstitialAd(Context var1, MediationInterstitialListener var2, Bundle var3, MediationAdRequest var4, Bundle var5) {
      this.mSdk = AppLovinUtils.retrieveSdk(var3, var1);
      this.mContext = var1;
      this.mNetworkExtras = var5;
      this.mMediationInterstitialListener = var2;
      this.mZoneId = AppLovinUtils.retrieveZoneId(var3);
      StringBuilder var6 = new StringBuilder();
      var6.append("Requesting interstitial for zone: ");
      var6.append(this.mZoneId);
      log(3, var6.toString());
      ApplovinAdapter$1 var9 = new ApplovinAdapter$1(this);
      Object var10 = INTERSTITIAL_AD_QUEUES_LOCK;
      synchronized(var10){}

      boolean var10001;
      Throwable var10000;
      label548: {
         Queue var12;
         try {
            var12 = (Queue)INTERSTITIAL_AD_QUEUES.get(this.mZoneId);
         } catch (Throwable var69) {
            var10000 = var69;
            var10001 = false;
            break label548;
         }

         label554: {
            if (var12 != null) {
               label555: {
                  if (var12 != null) {
                     label534:
                     try {
                        if (!var12.isEmpty()) {
                           break label534;
                        }
                        break label555;
                     } catch (Throwable var68) {
                        var10000 = var68;
                        var10001 = false;
                        break label548;
                     }
                  }

                  try {
                     log(3, "Enqueued interstitial found. Finishing load...");
                     AppLovinSdkUtils.runOnUiThread(new ApplovinAdapter$2(this));
                     break label554;
                  } catch (Throwable var66) {
                     var10000 = var66;
                     var10001 = false;
                     break label548;
                  }
               }
            }

            try {
               if (!TextUtils.isEmpty(this.mZoneId)) {
                  this.mSdk.getAdService().loadNextAdForZoneId(this.mZoneId, var9);
                  break label554;
               }
            } catch (Throwable var67) {
               var10000 = var67;
               var10001 = false;
               break label548;
            }

            try {
               this.mSdk.getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, var9);
            } catch (Throwable var65) {
               var10000 = var65;
               var10001 = false;
               break label548;
            }
         }

         label515:
         try {
            return;
         } catch (Throwable var64) {
            var10000 = var64;
            var10001 = false;
            break label515;
         }
      }

      while(true) {
         Throwable var11 = var10000;

         try {
            throw var11;
         } catch (Throwable var63) {
            var10000 = var63;
            var10001 = false;
            continue;
         }
      }
   }

   public void showInterstitial() {
      Object var1 = INTERSTITIAL_AD_QUEUES_LOCK;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label630: {
         Queue var3;
         try {
            this.mSdk.getSettings().setMuted(AppLovinUtils.shouldMuteAudio(this.mNetworkExtras));
            var3 = (Queue)INTERSTITIAL_AD_QUEUES.get(this.mZoneId);
         } catch (Throwable var82) {
            var10000 = var82;
            var10001 = false;
            break label630;
         }

         AppLovinAd var4;
         if (var3 != null) {
            try {
               var4 = (AppLovinAd)var3.poll();
            } catch (Throwable var81) {
               var10000 = var81;
               var10001 = false;
               break label630;
            }
         } else {
            var4 = null;
         }

         AppLovinInterstitialAdDialog var5;
         try {
            var5 = AppLovinInterstitialAd.create(this.mSdk, this.mContext);
            AppLovinInterstitialAdListener var6 = new AppLovinInterstitialAdListener(this, this.mMediationInterstitialListener);
            var5.setAdDisplayListener(var6);
            var5.setAdClickListener(var6);
            var5.setAdVideoPlaybackListener(var6);
         } catch (Throwable var80) {
            var10000 = var80;
            var10001 = false;
            break label630;
         }

         if (var4 != null) {
            try {
               StringBuilder var7 = new StringBuilder();
               var7.append("Showing interstitial for zone: ");
               var7.append(this.mZoneId);
               log(3, var7.toString());
               var5.showAndRender(var4);
            } catch (Throwable var78) {
               var10000 = var78;
               var10001 = false;
               break label630;
            }
         } else {
            label632: {
               try {
                  log(3, "Attempting to show interstitial before one was loaded");
                  if (TextUtils.isEmpty(this.mZoneId) && var5.isAdReadyToDisplay()) {
                     log(3, "Showing interstitial preloaded by SDK");
                     var5.show();
                     break label632;
                  }
               } catch (Throwable var79) {
                  var10000 = var79;
                  var10001 = false;
                  break label630;
               }

               try {
                  this.mMediationInterstitialListener.onAdOpened(this);
                  this.mMediationInterstitialListener.onAdClosed(this);
               } catch (Throwable var77) {
                  var10000 = var77;
                  var10001 = false;
                  break label630;
               }
            }
         }

         label600:
         try {
            return;
         } catch (Throwable var76) {
            var10000 = var76;
            var10001 = false;
            break label600;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var75) {
            var10000 = var75;
            var10001 = false;
            continue;
         }
      }
   }
}
