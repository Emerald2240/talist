package com.applovin.mediation.rtb;

import android.content.Context;
import android.util.Log;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;

public final class AppLovinRtbInterstitialRenderer implements MediationInterstitialAd, AppLovinAdLoadListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
   private static final String TAG = AppLovinRtbInterstitialRenderer.class.getSimpleName();
   private AppLovinAd ad;
   private final MediationInterstitialAdConfiguration adConfiguration;
   private final MediationAdLoadCallback callback;
   private AppLovinInterstitialAdDialog interstitialAd;
   private MediationInterstitialAdCallback mInterstitalAdCallback;
   private final AppLovinSdk sdk;

   public AppLovinRtbInterstitialRenderer(MediationInterstitialAdConfiguration var1, MediationAdLoadCallback var2) {
      this.adConfiguration = var1;
      this.callback = var2;
      this.sdk = AppLovinUtils.retrieveSdk(var1.getServerParameters(), var1.getContext());
   }

   public void adClicked(AppLovinAd var1) {
      Log.d(TAG, "Interstitial clicked");
      this.mInterstitalAdCallback.reportAdClicked();
      this.mInterstitalAdCallback.onAdLeftApplication();
   }

   public void adDisplayed(AppLovinAd var1) {
      Log.d(TAG, "Interstitial displayed");
      this.mInterstitalAdCallback.reportAdImpression();
      this.mInterstitalAdCallback.onAdOpened();
   }

   public void adHidden(AppLovinAd var1) {
      Log.d(TAG, "Interstitial hidden");
      this.mInterstitalAdCallback.onAdClosed();
   }

   public void adReceived(AppLovinAd var1) {
      String var2 = TAG;
      StringBuilder var3 = new StringBuilder();
      var3.append("Interstitial did load ad: ");
      var3.append(var1.getAdIdNumber());
      Log.d(var2, var3.toString());
      this.ad = var1;
      this.mInterstitalAdCallback = (MediationInterstitialAdCallback)this.callback.onSuccess(this);
   }

   public void failedToReceiveAd(int var1) {
      String var2 = TAG;
      StringBuilder var3 = new StringBuilder();
      var3.append("Failed to load interstitial ad with error: ");
      var3.append(var1);
      Log.e(var2, var3.toString());
      int var7 = AppLovinUtils.toAdMobErrorCode(var1);
      this.callback.onFailure(Integer.toString(var7));
   }

   public void loadAd() {
      this.interstitialAd = AppLovinInterstitialAd.create(this.sdk, this.adConfiguration.getContext());
      this.interstitialAd.setAdDisplayListener(this);
      this.interstitialAd.setAdClickListener(this);
      this.interstitialAd.setAdVideoPlaybackListener(this);
      this.sdk.getAdService().loadNextAdForAdToken(this.adConfiguration.getBidResponse(), this);
   }

   public void showAd(Context var1) {
      boolean var2 = AppLovinUtils.shouldMuteAudio(this.adConfiguration.getMediationExtras());
      this.sdk.getSettings().setMuted(var2);
      this.interstitialAd.showAndRender(this.ad);
   }

   public void videoPlaybackBegan(AppLovinAd var1) {
      Log.d(TAG, "Interstitial video playback began");
   }

   public void videoPlaybackEnded(AppLovinAd var1, double var2, boolean var4) {
      String var5 = TAG;
      StringBuilder var6 = new StringBuilder();
      var6.append("Interstitial video playback ended at playback percent: ");
      var6.append(var2);
      var6.append("%");
      Log.d(var5, var6.toString());
   }
}
