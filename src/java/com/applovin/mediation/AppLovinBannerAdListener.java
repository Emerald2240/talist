package com.applovin.mediation;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.mediation.MediationBannerListener;

class AppLovinBannerAdListener implements AppLovinAdLoadListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdViewEventListener {
   private final AppLovinAdView mAdView;
   private final ApplovinAdapter mAdapter;
   private final MediationBannerListener mMediationBannerListener;
   private final String mZoneId;

   AppLovinBannerAdListener(String var1, AppLovinAdView var2, ApplovinAdapter var3, MediationBannerListener var4) {
      this.mAdapter = var3;
      this.mMediationBannerListener = var4;
      this.mAdView = var2;
      this.mZoneId = var1;
   }

   // $FF: synthetic method
   static ApplovinAdapter access$000(AppLovinBannerAdListener var0) {
      return var0.mAdapter;
   }

   // $FF: synthetic method
   static MediationBannerListener access$100(AppLovinBannerAdListener var0) {
      return var0.mMediationBannerListener;
   }

   public void adClicked(AppLovinAd var1) {
      ApplovinAdapter.log(3, "Banner clicked");
      this.mMediationBannerListener.onAdClicked(this.mAdapter);
   }

   public void adClosedFullscreen(AppLovinAd var1, AppLovinAdView var2) {
      ApplovinAdapter.log(3, "Banner closed fullscreen");
      this.mMediationBannerListener.onAdClosed(this.mAdapter);
   }

   public void adDisplayed(AppLovinAd var1) {
      ApplovinAdapter.log(3, "Banner displayed");
   }

   public void adFailedToDisplay(AppLovinAd var1, AppLovinAdView var2, AppLovinAdViewDisplayErrorCode var3) {
      StringBuilder var4 = new StringBuilder();
      var4.append("Banner failed to display: ");
      var4.append(var3);
      ApplovinAdapter.log(6, var4.toString());
   }

   public void adHidden(AppLovinAd var1) {
      ApplovinAdapter.log(3, "Banner dismissed");
   }

   public void adLeftApplication(AppLovinAd var1, AppLovinAdView var2) {
      ApplovinAdapter.log(3, "Banner left application");
      this.mMediationBannerListener.onAdLeftApplication(this.mAdapter);
   }

   public void adOpenedFullscreen(AppLovinAd var1, AppLovinAdView var2) {
      ApplovinAdapter.log(3, "Banner opened fullscreen");
      this.mMediationBannerListener.onAdOpened(this.mAdapter);
   }

   public void adReceived(AppLovinAd var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Banner did load ad: ");
      var2.append(var1.getAdIdNumber());
      var2.append(" for zone: ");
      var2.append(this.mZoneId);
      ApplovinAdapter.log(3, var2.toString());
      this.mAdView.renderAd(var1);
      AppLovinSdkUtils.runOnUiThread(new AppLovinBannerAdListener$1(this));
   }

   public void failedToReceiveAd(int var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Failed to load banner ad with error: ");
      var2.append(var1);
      ApplovinAdapter.log(6, var2.toString());
      AppLovinSdkUtils.runOnUiThread(new AppLovinBannerAdListener$2(this, var1));
   }
}
