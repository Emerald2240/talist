package com.noqoush.adfalcon.android.sdk.interstitial.state;

import com.noqoush.adfalcon.android.sdk.ADFAd;
import com.noqoush.adfalcon.android.sdk.ADFInterstitial;
import com.noqoush.adfalcon.android.sdk.ADFView;
import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;

public class e implements com.noqoush.adfalcon.android.sdk.interstitial.c {
   public void a(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2) throws Exception {
      throw new Exception("Ad has finished pre-loading data and is ready to show");
   }

   public void a(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2, ADFErrorCode var3, String var4) throws Exception {
      throw new Exception("Ad finished loading and is in show phase");
   }

   public void b(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2) throws Exception {
      var1.b().a((ADFAd)var2);
      throw new Exception("Ad has finished loading and is ready to show");
   }

   public void c(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2) throws Exception {
      throw new Exception("Dismiss ad can't be called while its in show phase");
   }

   public void d(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2) throws Exception {
      if (var1.a() != null) {
         com.noqoush.adfalcon.android.sdk.util.a.c("will show Interstitial Ad");
         var1.f().a(var1, (ADFView)null, var2);
         com.noqoush.adfalcon.android.sdk.util.a.c("did show Interstitial Ad");
      }
   }
}
