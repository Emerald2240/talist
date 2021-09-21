package com.noqoush.adfalcon.android.sdk;

import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;

public interface ADFListener {
   void onDismissAdScreen(ADFAd var1);

   void onError(ADFAd var1, ADFErrorCode var2, String var3);

   void onLeaveApplication();

   void onLoadAd(ADFAd var1);

   void onPresentAdScreen(ADFAd var1);
}
