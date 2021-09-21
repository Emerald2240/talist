package com.noqoush.adfalcon.android.sdk.video.reward;

import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;

public interface ADFRewardedVideoAdListener {
   void onRewarded(String var1, int var2);

   void onRewardedVideoAdClosed();

   void onRewardedVideoAdFailedToLoad(ADFErrorCode var1, String var2);

   void onRewardedVideoAdFailedToOpen(ADFErrorCode var1, String var2);

   void onRewardedVideoAdLeftApplication();

   void onRewardedVideoAdLoaded(ADFRewardedVideoAd var1);

   void onRewardedVideoAdOpened();

   void onRewardedVideoEnded();

   void onRewardedVideoStarted();
}
