package com.noqoush.adfalcon.android.sdk;

import android.content.Context;
import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;

public class ADFInterstitial implements ADFAd, ADFListener, q {
   private com.noqoush.adfalcon.android.sdk.interstitial.a a;

   public ADFInterstitial(Context var1, String var2, ADFListener var3) {
      this.a(var1, var2, false, var3, (ADFTargetingParams)null);
   }

   public ADFInterstitial(Context var1, String var2, ADFListener var3, ADFTargetingParams var4) {
      this.a(var1, var2, false, var3, var4);
   }

   public ADFInterstitial(Context var1, String var2, ADFListener var3, ADFTargetingParams var4, boolean var5) {
      this.a(var1, var2, var5, var3, var4);
   }

   public ADFInterstitial(Context var1, String var2, ADFListener var3, boolean var4) {
      this.a(var1, var2, var4, var3, (ADFTargetingParams)null);
   }

   private void a(Context var1, String var2, boolean var3, ADFListener var4, ADFTargetingParams var5) {
      Exception var10000;
      label38: {
         boolean var10001;
         if (var3) {
            try {
               k.c("Setting test mode is deprecated. Please consider using ADFTargetingParams for test ads");
               com.noqoush.adfalcon.android.sdk.util.d.a();
            } catch (Exception var18) {
               var10000 = var18;
               var10001 = false;
               break label38;
            }
         }

         w var6;
         try {
            var6 = new w(var1, this);
            var6.g().a(w.e.a);
            var6.g().f(true);
            var6.g().a(var5);
         } catch (Exception var17) {
            var10000 = var17;
            var10001 = false;
            break label38;
         }

         com.noqoush.adfalcon.android.sdk.interstitial.b var11;
         if (var4 != null) {
            try {
               var11 = new com.noqoush.adfalcon.android.sdk.interstitial.b(var4, this);
            } catch (Exception var16) {
               var10000 = var16;
               var10001 = false;
               break label38;
            }
         } else {
            var11 = null;
         }

         try {
            com.noqoush.adfalcon.android.sdk.interstitial.state.c var12 = new com.noqoush.adfalcon.android.sdk.interstitial.state.c();
            x var13 = var6.g();
            com.noqoush.adfalcon.android.sdk.interstitial.a var14 = new com.noqoush.adfalcon.android.sdk.interstitial.a(var1.getApplicationContext(), var6, var13, var12, var11, var3, var2);
            this.a = var14;
            return;
         } catch (Exception var15) {
            var10000 = var15;
            var10001 = false;
         }
      }

      Exception var7 = var10000;
      StringBuilder var8 = new StringBuilder();
      var8.append("ADFInterstitial->initViewability: ");
      var8.append(var7);
      k.b(var8.toString());
   }

   private com.noqoush.adfalcon.android.sdk.interstitial.a b() {
      return this.a;
   }

   private com.noqoush.adfalcon.android.sdk.interstitial.c c() {
      return this.b().e();
   }

   private com.noqoush.adfalcon.android.sdk.interstitial.b d() {
      return this.b().b();
   }

   protected w a() {
      return this.b().f();
   }

   public void didDismissScreen() {
      try {
         this.c().c(this.b(), this);
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void didPresentScreen() {
      try {
         this.d().b();
         this.b().a((com.noqoush.adfalcon.android.sdk.interstitial.c)(new com.noqoush.adfalcon.android.sdk.interstitial.state.a()));
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public boolean isReady() {
      return this.c() instanceof com.noqoush.adfalcon.android.sdk.interstitial.state.e;
   }

   @Deprecated
   public boolean isTestMode() {
      return this.b().g();
   }

   public void loadInterstitialAd() {
      try {
         this.c().b(this.b(), this);
      } catch (Exception var4) {
         Exception var1 = var4;

         try {
            com.noqoush.adfalcon.android.sdk.util.a.a(var1);
            if (this.c() instanceof com.noqoush.adfalcon.android.sdk.interstitial.state.c) {
               this.b().a((com.noqoush.adfalcon.android.sdk.interstitial.c)(new com.noqoush.adfalcon.android.sdk.interstitial.state.b()));
               this.c().a(this.b(), this, (ADFErrorCode)null, var1.getMessage());
               return;
            }
         } catch (Exception var3) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var3);
         }

      }
   }

   public void onDismissAdScreen(ADFAd var1) {
   }

   public void onError(ADFAd var1, ADFErrorCode var2, String var3) {
      try {
         if (var1 instanceof ADFInterstitial) {
            this.b().a((com.noqoush.adfalcon.android.sdk.interstitial.c)(new com.noqoush.adfalcon.android.sdk.interstitial.state.b()));
         }

         this.b().e().a(this.b(), this, var2, var3);
      } catch (Exception var5) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var5);
      }
   }

   public void onLeaveApplication() {
      try {
         if (this.d() != null) {
            this.d().e();
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public void onLoadAd(ADFAd var1) {
      try {
         if (var1 instanceof ADFInterstitial) {
            com.noqoush.adfalcon.android.sdk.util.a.c("did load Interstitial Ad");
            this.c().a(this.b(), this);
            return;
         }
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
         this.b().a((com.noqoush.adfalcon.android.sdk.interstitial.c)(new com.noqoush.adfalcon.android.sdk.interstitial.state.e()));
         this.d().a(var1);
      }

   }

   public void onPresentAdScreen(ADFAd var1) {
   }

   public void setListener(ADFListener var1) {
      this.d().a(var1);
   }

   @Deprecated
   public void setTestMode(boolean var1) {
      this.b().a(var1);
      com.noqoush.adfalcon.android.sdk.util.d.a();
   }

   public void showInterstitialAd() {
      try {
         this.c().d(this.b(), this);
      } catch (Exception var4) {
         Exception var1 = var4;

         try {
            com.noqoush.adfalcon.android.sdk.util.a.a(var1);
            this.b().a((com.noqoush.adfalcon.android.sdk.interstitial.c)(new com.noqoush.adfalcon.android.sdk.interstitial.state.b()));
            this.c().a(this.b(), this, (ADFErrorCode)null, "Failed to present this interstitial, load new ad");
         } catch (Exception var3) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var3);
         }
      }
   }

   public void willDismissScreen() {
   }

   public void willPresentScreen() {
   }
}
