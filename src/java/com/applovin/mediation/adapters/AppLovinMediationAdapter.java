package com.applovin.mediation.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.ad.i;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

public class AppLovinMediationAdapter extends MediationAdapterBase implements MaxAdViewAdapter, MaxInterstitialAdapter, MaxRewardedAdapter, MaxSignalProvider {
   private AppLovinAdView mLoadedAdView;
   private AppLovinAd mLoadedInterstitialAd;
   private AppLovinAd mLoadedRewardedAd;
   private MaxReward mPendingReward;

   public AppLovinMediationAdapter(AppLovinSdk var1) {
      super(var1);
   }

   // $FF: synthetic method
   static AppLovinAdView access$000(AppLovinMediationAdapter var0) {
      return var0.mLoadedAdView;
   }

   // $FF: synthetic method
   static AppLovinAdView access$002(AppLovinMediationAdapter var0, AppLovinAdView var1) {
      var0.mLoadedAdView = var1;
      return var1;
   }

   // $FF: synthetic method
   static MaxAdapterError access$100(AppLovinAdViewDisplayErrorCode var0) {
      return toMaxError(var0);
   }

   private static MaxAdapterError toMaxError(int var0) {
      short var1 = 204;
      if (var0 == -103) {
         var1 = -5207;
      } else if (var0 != var1) {
         if (var0 == -1) {
            var1 = -5209;
         } else if (var0 >= 500) {
            var1 = -5208;
         } else {
            var1 = -5200;
         }
      }

      return new MaxAdapterError(var1, var0);
   }

   private static MaxAdapterError toMaxError(AppLovinAdViewDisplayErrorCode var0) {
      return MaxAdapterError.UNSPECIFIED;
   }

   public void collectSignal(MaxAdapterSignalCollectionParameters var1, Activity var2, MaxSignalCollectionListener var3) {
      this.log("Collecting signal...");
      var3.onSignalCollected(this.getWrappingSdk().getAdService().getBidToken());
   }

   public String getAdapterVersion() {
      return this.getSdkVersion();
   }

   public String getSdkVersion() {
      return AppLovinSdk.VERSION;
   }

   public void initialize(MaxAdapterInitializationParameters var1, Activity var2, MaxAdapter.OnCompletionListener var3) {
      if (AppLovinSdk.VERSION_CODE >= 90800) {
         var3.onCompletion(MaxAdapter.InitializationStatus.DOES_NOT_APPLY, (String)null);
      } else {
         var3.onCompletion();
      }
   }

   public void loadAdViewAd(MaxAdapterResponseParameters var1, MaxAdFormat var2, final Activity var3, final MaxAdViewAdapterListener var4) {
      AppLovinAdLoadListener var5 = new AppLovinAdLoadListener() {
         public void adReceived(AppLovinAd var1) {
            AppLovinMediationAdapter.this.log("Banner ad loaded");
            AppLovinSdkUtils.runOnUiThread(new AppLovinMediationAdapter$1$1(this, var1));
         }

         public void failedToReceiveAd(int var1) {
            MaxAdapterError var2 = AppLovinMediationAdapter.toMaxError(var1);
            AppLovinMediationAdapter var3x = AppLovinMediationAdapter.this;
            StringBuilder var4x = new StringBuilder();
            var4x.append("Banner ad failed to load with error: ");
            var4x.append(var2);
            var3x.log(var4x.toString());
            var4.onAdViewAdLoadFailed(var2);
         }
      };
      if (!TextUtils.isEmpty(var1.getBidResponse())) {
         this.log("Loading bidding banner ad...");
         this.getWrappingSdk().getAdService().loadNextAdForAdToken(var1.getBidResponse(), var5);
      } else if (!TextUtils.isEmpty(var1.getThirdPartyAdPlacementId())) {
         String var11 = var1.getThirdPartyAdPlacementId();
         StringBuilder var12 = new StringBuilder();
         var12.append("Loading mediated banner ad: ");
         var12.append(var11);
         var12.append("...");
         this.log(var12.toString());
         this.getWrappingSdk().getAdService().loadNextAdForZoneId(var11, var5);
      } else {
         AppLovinAdSize var7;
         if (var2 == MaxAdFormat.BANNER) {
            var7 = AppLovinAdSize.BANNER;
         } else if (var2 == MaxAdFormat.MREC) {
            var7 = AppLovinAdSize.MREC;
         } else {
            MaxAdFormat var6 = MaxAdFormat.LEADER;
            var7 = null;
            if (var2 == var6) {
               var7 = AppLovinAdSize.LEADER;
            }
         }

         if (var7 != null) {
            this.log("Loading mediated banner ad...");
            this.getWrappingSdk().getAdService().loadNextAd(var7, var5);
         } else {
            StringBuilder var8 = new StringBuilder();
            var8.append("Failed to load ad for format: ");
            var8.append(var2);
            this.log(var8.toString());
         }
      }
   }

   public void loadInterstitialAd(MaxAdapterResponseParameters var1, Activity var2, final MaxInterstitialAdapterListener var3) {
      AppLovinAdLoadListener var4 = new AppLovinAdLoadListener() {
         public void adReceived(AppLovinAd var1) {
            AppLovinMediationAdapter.this.log("Interstitial ad loaded");
            AppLovinMediationAdapter.this.mLoadedInterstitialAd = var1;
            var3.onInterstitialAdLoaded();
         }

         public void failedToReceiveAd(int var1) {
            MaxAdapterError var2 = AppLovinMediationAdapter.toMaxError(var1);
            AppLovinMediationAdapter var3x = AppLovinMediationAdapter.this;
            StringBuilder var4 = new StringBuilder();
            var4.append("Banner ad failed to load with error: ");
            var4.append(var2);
            var3x.log(var4.toString());
            var3.onInterstitialAdLoadFailed(var2);
         }
      };
      if (!TextUtils.isEmpty(var1.getBidResponse())) {
         this.log("Loading bidder interstitial ad...");
         this.getWrappingSdk().getAdService().loadNextAdForAdToken(var1.getBidResponse(), var4);
      } else if (!TextUtils.isEmpty(var1.getThirdPartyAdPlacementId())) {
         String var5 = var1.getThirdPartyAdPlacementId();
         StringBuilder var6 = new StringBuilder();
         var6.append("Loading mediated interstitial ad: ");
         var6.append(var5);
         var6.append("...");
         this.log(var6.toString());
         this.getWrappingSdk().getAdService().loadNextAdForZoneId(var5, var4);
      } else {
         this.log("Loading mediated interstitial ad...");
         this.getWrappingSdk().getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, var4);
      }
   }

   public void loadRewardedAd(MaxAdapterResponseParameters var1, Activity var2, final MaxRewardedAdapterListener var3) {
      AppLovinAdLoadListener var4 = new AppLovinAdLoadListener() {
         public void adReceived(AppLovinAd var1) {
            AppLovinMediationAdapter.this.log("Rewarded ad loaded");
            AppLovinMediationAdapter.this.mLoadedRewardedAd = var1;
            var3.onRewardedAdLoaded();
         }

         public void failedToReceiveAd(int var1) {
            MaxAdapterError var2 = AppLovinMediationAdapter.toMaxError(var1);
            AppLovinMediationAdapter var3x = AppLovinMediationAdapter.this;
            StringBuilder var4 = new StringBuilder();
            var4.append("Rewarded ad failed to load with error: ");
            var4.append(var2);
            var3x.log(var4.toString());
            var3.onRewardedAdLoadFailed(var2);
         }
      };
      if (!TextUtils.isEmpty(var1.getBidResponse())) {
         this.log("Loading bidding rewarded ad...");
         this.getWrappingSdk().getAdService().loadNextAdForAdToken(var1.getBidResponse(), var4);
      } else if (!TextUtils.isEmpty(var1.getThirdPartyAdPlacementId())) {
         String var5 = var1.getThirdPartyAdPlacementId();
         StringBuilder var6 = new StringBuilder();
         var6.append("Loading mediated rewarded ad: ");
         var6.append(var5);
         var6.append("...");
         this.log(var6.toString());
         this.getWrappingSdk().getAdService().loadNextAdForZoneId(var1.getThirdPartyAdPlacementId(), var4);
      } else {
         this.log("Loading mediated rewarded ad...");
         this.getWrappingSdk().getAdService().loadNextAdForZoneId("inter_videoa", var4);
      }
   }

   public void onDestroy() {
      this.mLoadedInterstitialAd = null;
      this.mLoadedRewardedAd = null;
      AppLovinAdView var1 = this.mLoadedAdView;
      if (var1 != null) {
         var1.destroy();
         this.mLoadedAdView = null;
      }

   }

   public void showInterstitialAd(MaxAdapterResponseParameters var1, Activity var2, final MaxInterstitialAdapterListener var3) {
      StringBuilder var4 = new StringBuilder();
      var4.append("Showing interstitial: ");
      var4.append(var1.getThirdPartyAdPlacementId());
      var4.append("...");
      this.log(var4.toString());
      AppLovinInterstitialAdDialog var8 = AppLovinInterstitialAd.create(this.getWrappingSdk(), var2);
      var8.setAdDisplayListener(new i() {
         public void adDisplayed(AppLovinAd var1) {
            AppLovinMediationAdapter.this.log("Interstitial ad shown");
            var3.onInterstitialAdDisplayed();
         }

         public void adHidden(AppLovinAd var1) {
            AppLovinMediationAdapter.this.log("Interstitial ad hidden");
            var3.onInterstitialAdHidden();
         }

         public void onAdDisplayFailed(String var1) {
            MaxAdapterError var2 = new MaxAdapterError(-5200, var1);
            AppLovinMediationAdapter var3x = AppLovinMediationAdapter.this;
            StringBuilder var4 = new StringBuilder();
            var4.append("Interstitial ad failed to display with error: ");
            var4.append(var2);
            var3x.log(var4.toString());
            var3.onInterstitialAdDisplayFailed(var2);
         }
      });
      var8.setAdClickListener(new AppLovinAdClickListener() {
         public void adClicked(AppLovinAd var1) {
            AppLovinMediationAdapter.this.log("Interstitial ad clicked");
            var3.onInterstitialAdClicked();
         }
      });
      var8.showAndRender(this.mLoadedInterstitialAd);
   }

   public void showRewardedAd(MaxAdapterResponseParameters var1, Activity var2, MaxRewardedAdapterListener var3) {
      StringBuilder var4 = new StringBuilder();
      var4.append("Showing rewarded ad: ");
      var4.append(var1.getThirdPartyAdPlacementId());
      var4.append("...");
      this.log(var4.toString());
      AppLovinIncentivizedInterstitial var8 = AppLovinIncentivizedInterstitial.create(this.getWrappingSdk());
      AppLovinMediationAdapter.RewardListenerWrapper var9 = new AppLovinMediationAdapter.RewardListenerWrapper(var3);
      var8.show((AppLovinAd)this.mLoadedRewardedAd, (Context)var2, var9, var9, var9, var9);
   }

   private class RewardListenerWrapper implements i, AppLovinAdClickListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener {
      private boolean isFullyWatched;
      private final MaxRewardedAdapterListener listener;

      private RewardListenerWrapper(MaxRewardedAdapterListener var2) {
         this.isFullyWatched = false;
         this.listener = var2;
      }

      // $FF: synthetic method
      RewardListenerWrapper(MaxRewardedAdapterListener var2, Object var3) {
         this(var2);
      }

      public void adClicked(AppLovinAd var1) {
         AppLovinMediationAdapter.this.log("Rewarded ad clicked");
         this.listener.onRewardedAdClicked();
      }

      public void adDisplayed(AppLovinAd var1) {
         AppLovinMediationAdapter.this.log("Rewarded ad shown");
         this.listener.onRewardedAdDisplayed();
      }

      public void adHidden(AppLovinAd var1) {
         if (this.isFullyWatched && AppLovinMediationAdapter.this.mPendingReward != null) {
            AppLovinMediationAdapter var2 = AppLovinMediationAdapter.this;
            StringBuilder var3 = new StringBuilder();
            var3.append("Rewarded user with reward: ");
            var3.append(AppLovinMediationAdapter.this.mPendingReward);
            var2.log(var3.toString());
            this.listener.onUserRewarded(AppLovinMediationAdapter.this.mPendingReward);
            AppLovinMediationAdapter.this.mPendingReward = null;
         }

         AppLovinMediationAdapter.this.log("Rewarded ad hidden");
         this.listener.onRewardedAdHidden();
      }

      public void onAdDisplayFailed(String var1) {
         MaxAdapterError var2 = new MaxAdapterError(-5200, var1);
         AppLovinMediationAdapter var3 = AppLovinMediationAdapter.this;
         StringBuilder var4 = new StringBuilder();
         var4.append("Rewarded ad failed to display with error: ");
         var4.append(var2);
         var3.log(var4.toString());
         this.listener.onRewardedAdDisplayFailed(var2);
      }

      public void userDeclinedToViewAd(AppLovinAd var1) {
         AppLovinMediationAdapter.this.log("User declined to view rewarded ad");
         AppLovinMediationAdapter.this.mPendingReward = null;
         this.listener.onRewardedAdDisplayFailed(MaxAdapterError.REWARD_ERROR);
      }

      public void userOverQuota(AppLovinAd var1, Map var2) {
         AppLovinMediationAdapter var3 = AppLovinMediationAdapter.this;
         StringBuilder var4 = new StringBuilder();
         var4.append("User is over quota: ");
         var4.append(var2);
         var3.log(var4.toString());
         AppLovinMediationAdapter.this.mPendingReward = null;
      }

      public void userRewardRejected(AppLovinAd var1, Map var2) {
         AppLovinMediationAdapter var3 = AppLovinMediationAdapter.this;
         StringBuilder var4 = new StringBuilder();
         var4.append("Reward rejected: ");
         var4.append(var2);
         var3.log(var4.toString());
         AppLovinMediationAdapter.this.mPendingReward = null;
      }

      public void userRewardVerified(AppLovinAd var1, Map var2) {
         String var3 = (String)var2.get("currency");
         String var4 = (String)var2.get("amount");
         if (!TextUtils.isEmpty(var3) && !TextUtils.isEmpty(var4)) {
            int var10 = 0;

            label17: {
               double var17;
               try {
                  var17 = Double.parseDouble(var4);
               } catch (NumberFormatException var19) {
                  AppLovinMediationAdapter var12 = AppLovinMediationAdapter.this;
                  StringBuilder var13 = new StringBuilder();
                  var13.append("Failed to parse AppLovin reward amount: ");
                  var13.append(var4);
                  var12.log(var13.toString(), var19);
                  break label17;
               }

               var10 = (int)var17;
            }

            AppLovinMediationAdapter.this.mPendingReward = MaxReward.create(var10, var3);
         } else {
            AppLovinMediationAdapter.this.mPendingReward = MaxReward.createDefault();
         }

         AppLovinMediationAdapter var6 = AppLovinMediationAdapter.this;
         StringBuilder var7 = new StringBuilder();
         var7.append("Rewarded verified: ");
         var7.append(AppLovinMediationAdapter.this.mPendingReward);
         var6.log(var7.toString());
      }

      public void validationRequestFailed(AppLovinAd var1, int var2) {
         AppLovinMediationAdapter var3 = AppLovinMediationAdapter.this;
         StringBuilder var4 = new StringBuilder();
         var4.append("Reward validation request failed with code: ");
         var4.append(var2);
         var3.log(var4.toString());
         AppLovinMediationAdapter.this.mPendingReward = null;
      }

      public void videoPlaybackBegan(AppLovinAd var1) {
         AppLovinMediationAdapter.this.log("Rewarded ad video started");
         this.listener.onRewardedAdVideoStarted();
      }

      public void videoPlaybackEnded(AppLovinAd var1, double var2, boolean var4) {
         AppLovinMediationAdapter var5 = AppLovinMediationAdapter.this;
         StringBuilder var6 = new StringBuilder();
         var6.append("Rewarded ad video ended at ");
         var6.append(var2);
         var6.append("% and is fully watched: ");
         var6.append(var4);
         var5.log(var6.toString());
         this.isFullyWatched = var4;
         this.listener.onRewardedAdVideoCompleted();
      }
   }
}
