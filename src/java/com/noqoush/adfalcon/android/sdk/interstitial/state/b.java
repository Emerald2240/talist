package com.noqoush.adfalcon.android.sdk.interstitial.state;

import com.noqoush.adfalcon.android.sdk.ADFInterstitial;
import com.noqoush.adfalcon.android.sdk.m;
import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;

public class b implements com.noqoush.adfalcon.android.sdk.interstitial.c {
   public void a(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2) throws Exception {
      throw new Exception("Can't process failed ad");
   }

   public void a(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2, ADFErrorCode var3, String var4) throws Exception {
      if (var3 == null) {
         var3 = ADFErrorCode.GENERIC_SDK_ERROR;
      }

      if (var4 == null || var4.trim().isEmpty()) {
         var4 = "Error while loading ad";
      }

      if (var1.c().j() != null) {
         var1.c().a((m)null);
      }

      var1.b().a(var2, var3, var4);
      var1.a((com.noqoush.adfalcon.android.sdk.interstitial.c)(new c()));
   }

   public void b(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2) throws Exception {
      throw new Exception("Can't process failed ad");
   }

   public void c(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2) throws Exception {
      throw new Exception("Can't process failed ad");
   }

   public void d(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2) throws Exception {
      throw new Exception("Can't process failed ad");
   }
}
