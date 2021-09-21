package com.noqoush.adfalcon.android.sdk.nativead;

import android.view.View;
import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;
import java.util.Hashtable;

public interface ADFNativeAdListener {
   boolean handleCustomAction(String var1);

   void onDismissAdScreen(ADFNativeAd var1);

   void onFail(ADFNativeAd var1, ADFErrorCode var2, String var3);

   void onLeaveApplication();

   void onLoadAd(ADFNativeAd var1);

   void onPresentAdScreen(ADFNativeAd var1);

   void renderExtraData(View var1, Hashtable var2);
}
