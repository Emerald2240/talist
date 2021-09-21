package com.noqoush.adfalcon.android.sdk.video.vast.manager;

import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;
import com.noqoush.adfalcon.android.sdk.video.vast.model.p;
import java.util.ArrayList;

public interface f {
   void didLoadAd(d var1, p var2);

   void didWrapAd(d var1);

   void failedToLoadAd(d var1, ADFErrorCode var2, String var3, ArrayList var4);

   void onApplicationLeft(com.noqoush.adfalcon.android.sdk.video.vast.player.h var1);

   void onCompanionAdClicked(com.noqoush.adfalcon.android.sdk.video.vast.model.b var1, com.noqoush.adfalcon.android.sdk.video.vast.player.h var2);

   void onComplete(com.noqoush.adfalcon.android.sdk.video.vast.player.h var1);

   void onDismissed(com.noqoush.adfalcon.android.sdk.video.vast.player.h var1);

   void onFailedToPlayAd(com.noqoush.adfalcon.android.sdk.video.vast.player.h var1);

   void onFailedToPresent(d var1, ADFErrorCode var2, String var3);

   void onFirstQurtile(com.noqoush.adfalcon.android.sdk.video.vast.player.h var1);

   void onMidpoint(com.noqoush.adfalcon.android.sdk.video.vast.player.h var1);

   void onPresented(com.noqoush.adfalcon.android.sdk.video.vast.player.h var1);

   void onStart(com.noqoush.adfalcon.android.sdk.video.vast.player.h var1);

   void onThirdQurtile(com.noqoush.adfalcon.android.sdk.video.vast.player.h var1);

   void willLoadAd(d var1);

   boolean willWrapAd(d var1);
}
