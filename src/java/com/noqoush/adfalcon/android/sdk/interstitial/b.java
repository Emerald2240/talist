package com.noqoush.adfalcon.android.sdk.interstitial;

import com.noqoush.adfalcon.android.sdk.ADFAd;
import com.noqoush.adfalcon.android.sdk.ADFInterstitial;
import com.noqoush.adfalcon.android.sdk.ADFListener;
import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;

public class b {
   private ADFListener a;
   private ADFAd b;

   public b(ADFListener var1, ADFAd var2) {
      try {
         this.a(var1);
         this.b(var2);
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }
   }

   public void a() {
      try {
         if (this.d() != null) {
            this.d().onDismissAdScreen(this.c());
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public void a(ADFAd var1) {
      try {
         if (var1 instanceof ADFInterstitial && this.d() != null) {
            this.d().onLoadAd(this.c());
            return;
         }
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }

   }

   public void a(ADFAd var1, ADFErrorCode var2, String var3) {
      try {
         if (var1 instanceof ADFInterstitial && this.d() != null) {
            this.d().onError(this.c(), var2, var3);
            return;
         }
      } catch (Exception var5) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var5);
      }

   }

   public void a(ADFListener var1) {
      this.a = var1;
   }

   public void b() {
      try {
         if (this.d() != null) {
            this.d().onPresentAdScreen(this.c());
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   protected void b(ADFAd var1) {
      this.b = var1;
   }

   protected ADFAd c() {
      return this.b;
   }

   protected ADFListener d() {
      return this.a;
   }

   public void e() {
      try {
         if (this.d() != null) {
            this.d().onLeaveApplication();
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }
}
