package com.applovin.mediation;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import com.google.ads.mediation.applovin.AppLovinRewardItem;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import java.util.Map;

public class AppLovinIncentivizedAdListener implements AppLovinAdRewardListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
   private boolean mFullyWatched;
   private AppLovinRewardItem mRewardItem;
   private MediationRewardedAdCallback mRewardedAdCallback;
   private String mZoneId;

   public AppLovinIncentivizedAdListener(MediationRewardedAdConfiguration var1, MediationRewardedAdCallback var2) {
      this.mZoneId = AppLovinUtils.retrieveZoneId(var1.getServerParameters());
      this.mRewardedAdCallback = var2;
   }

   public void adClicked(AppLovinAd var1) {
      ApplovinAdapter.log(3, "Rewarded video clicked");
      this.mRewardedAdCallback.reportAdClicked();
   }

   public void adDisplayed(AppLovinAd var1) {
      ApplovinAdapter.log(3, "Rewarded video displayed");
      this.mRewardedAdCallback.onAdOpened();
      this.mRewardedAdCallback.reportAdImpression();
   }

   public void adHidden(AppLovinAd var1) {
      ApplovinAdapter.log(3, "Rewarded video dismissed");
      AppLovinMediationAdapter.INCENTIVIZED_ADS.remove(this.mZoneId);
      if (this.mFullyWatched) {
         this.mRewardedAdCallback.onUserEarnedReward(this.mRewardItem);
      }

      this.mRewardedAdCallback.onAdClosed();
   }

   public void userDeclinedToViewAd(AppLovinAd var1) {
      ApplovinAdapter.log(3, "User declined to view rewarded video");
   }

   public void userOverQuota(AppLovinAd var1, Map var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("Rewarded video validation request for ad did exceed quota with response: ");
      var3.append(var2);
      ApplovinAdapter.log(6, var3.toString());
   }

   public void userRewardRejected(AppLovinAd var1, Map var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("Rewarded video validation request was rejected with response: ");
      var3.append(var2);
      ApplovinAdapter.log(6, var3.toString());
   }

   public void userRewardVerified(AppLovinAd var1, Map var2) {
      String var3 = (String)var2.get("currency");
      int var4 = (int)Double.parseDouble((String)var2.get("amount"));
      StringBuilder var5 = new StringBuilder();
      var5.append("Rewarded ");
      var5.append(var4);
      var5.append(" ");
      var5.append(var3);
      ApplovinAdapter.log(3, var5.toString());
      this.mRewardItem = new AppLovinRewardItem(var4, var3);
   }

   public void validationRequestFailed(AppLovinAd var1, int var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("Rewarded video validation request for ad failed with error code: ");
      var3.append(var2);
      ApplovinAdapter.log(6, var3.toString());
   }

   public void videoPlaybackBegan(AppLovinAd var1) {
      ApplovinAdapter.log(3, "Rewarded video playback began");
      this.mRewardedAdCallback.onVideoStart();
   }

   public void videoPlaybackEnded(AppLovinAd var1, double var2, boolean var4) {
      StringBuilder var5 = new StringBuilder();
      var5.append("Rewarded video playback ended at playback percent: ");
      var5.append(var2);
      var5.append("%");
      ApplovinAdapter.log(3, var5.toString());
      this.mFullyWatched = var4;
      if (var4) {
         this.mRewardedAdCallback.onVideoComplete();
      }

   }
}
