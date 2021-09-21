package com.applovin.mediation.rtb;

import android.util.Log;
import android.view.View;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;

public final class AppLovinRtbBannerRenderer implements MediationBannerAd, AppLovinAdLoadListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdViewEventListener {
   private static final String TAG = AppLovinRtbBannerRenderer.class.getSimpleName();
   private final MediationBannerAdConfiguration adConfiguration;
   private final AppLovinAdSize adSize;
   private AppLovinAdView adView;
   private final MediationAdLoadCallback callback;
   private MediationBannerAdCallback mBannerAdCallback;
   private final AppLovinSdk sdk;

   public AppLovinRtbBannerRenderer(MediationBannerAdConfiguration var1, MediationAdLoadCallback var2) {
      this.adConfiguration = var1;
      this.callback = var2;
      this.adSize = AppLovinUtils.appLovinAdSizeFromAdMobAdSize(var1.getContext(), var1.getAdSize());
      this.sdk = AppLovinUtils.retrieveSdk(var1.getServerParameters(), var1.getContext());
   }

   public void adClicked(AppLovinAd var1) {
      Log.d(TAG, "Banner clicked");
      this.mBannerAdCallback.reportAdClicked();
   }

   public void adClosedFullscreen(AppLovinAd var1, AppLovinAdView var2) {
      Log.d(TAG, "Banner closed fullscreen");
      this.mBannerAdCallback.onAdClosed();
   }

   public void adDisplayed(AppLovinAd var1) {
      Log.d(TAG, "Banner displayed");
      this.mBannerAdCallback.reportAdImpression();
      this.mBannerAdCallback.onAdOpened();
   }

   public void adFailedToDisplay(AppLovinAd var1, AppLovinAdView var2, AppLovinAdViewDisplayErrorCode var3) {
      String var4 = TAG;
      StringBuilder var5 = new StringBuilder();
      var5.append("Banner failed to display: ");
      var5.append(var3);
      Log.e(var4, var5.toString());
   }

   public void adHidden(AppLovinAd var1) {
      Log.d(TAG, "Banner hidden");
   }

   public void adLeftApplication(AppLovinAd var1, AppLovinAdView var2) {
      Log.d(TAG, "Banner left application");
      this.mBannerAdCallback.onAdLeftApplication();
   }

   public void adOpenedFullscreen(AppLovinAd var1, AppLovinAdView var2) {
      Log.d(TAG, "Banner opened fullscreen");
      this.mBannerAdCallback.onAdOpened();
   }

   public void adReceived(AppLovinAd var1) {
      String var2 = TAG;
      StringBuilder var3 = new StringBuilder();
      var3.append("Banner did load ad: ");
      var3.append(var1.getAdIdNumber());
      Log.d(var2, var3.toString());
      this.mBannerAdCallback = (MediationBannerAdCallback)this.callback.onSuccess(this);
      this.adView.renderAd(var1);
   }

   public void failedToReceiveAd(int var1) {
      String var2 = TAG;
      StringBuilder var3 = new StringBuilder();
      var3.append("Failed to load banner ad with error: ");
      var3.append(var1);
      Log.e(var2, var3.toString());
      int var7 = AppLovinUtils.toAdMobErrorCode(var1);
      this.callback.onFailure(Integer.toString(var7));
   }

   public View getView() {
      return this.adView;
   }

   public void loadAd() {
      AppLovinAdSize var1 = this.adSize;
      if (var1 != null) {
         this.adView = new AppLovinAdView(this.sdk, var1, this.adConfiguration.getContext());
         this.adView.setAdDisplayListener(this);
         this.adView.setAdClickListener(this);
         this.adView.setAdViewEventListener(this);
         this.sdk.getAdService().loadNextAdForAdToken(this.adConfiguration.getBidResponse(), this);
      } else {
         this.callback.onFailure("Failed to request banner with unsupported size");
      }
   }
}
