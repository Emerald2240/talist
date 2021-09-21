package com.noqoush.adfalcon.android.sdk.interstitial.state;

import com.noqoush.adfalcon.android.sdk.ADFInterstitial;
import com.noqoush.adfalcon.android.sdk.ADFListener;
import com.noqoush.adfalcon.android.sdk.g;
import com.noqoush.adfalcon.android.sdk.w;
import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;

public class c implements com.noqoush.adfalcon.android.sdk.interstitial.c {
   public void a(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2) throws Exception {
      throw new Exception("Ad should be loaded first to be prepared");
   }

   public void a(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2, ADFErrorCode var3, String var4) throws Exception {
      throw new Exception("Ad should be loaded instead of failure");
   }

   public void b(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2) throws Exception {
      com.noqoush.adfalcon.android.sdk.util.a.c("will load Interstitial Ad");
      g var3 = g.c(var1.a());
      var1.f().g().a(var3);
      var1.f().g().a(w.e.b);
      var1.f().g().a(var1.d());
      var1.f().g().g(var1.g());
      var1.f().g().a((ADFListener)var2);
      var1.f().g().a(com.noqoush.adfalcon.android.sdk.constant.a.a);
      var1.a(var1.f().g());
      (new Thread(new c$a(this, var1))).start();
      var1.a((com.noqoush.adfalcon.android.sdk.interstitial.c)(new d()));
   }

   public void c(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2) throws Exception {
      throw new Exception("Ad should be loaded first to be dismissed");
   }

   public void d(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2) throws Exception {
      throw new Exception("Ad should be loaded first to be shown");
   }
}
