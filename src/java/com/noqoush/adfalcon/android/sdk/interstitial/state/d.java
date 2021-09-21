package com.noqoush.adfalcon.android.sdk.interstitial.state;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.noqoush.adfalcon.android.sdk.ADFAd;
import com.noqoush.adfalcon.android.sdk.ADFInterstitial;
import com.noqoush.adfalcon.android.sdk.m;
import com.noqoush.adfalcon.android.sdk.n;
import com.noqoush.adfalcon.android.sdk.p;
import com.noqoush.adfalcon.android.sdk.w;
import com.noqoush.adfalcon.android.sdk.x;
import com.noqoush.adfalcon.android.sdk.y;
import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;
import com.noqoush.adfalcon.android.sdk.response.k;

public class d implements com.noqoush.adfalcon.android.sdk.interstitial.c {
   private ADFInterstitial a;
   private com.noqoush.adfalcon.android.sdk.interstitial.a b;

   private void a(WebView var1, k var2) throws Exception {
      try {
         String var4 = var2.p();
         if (var4.equalsIgnoreCase("content")) {
            if (var2.f() != null) {
               String var5 = var2.f();
               String var6 = com.noqoush.adfalcon.android.sdk.util.e.a(var1.getContext(), var2);
               var1.loadDataWithBaseURL(var5, var6, "text/html", "UTF-8", var2.n());
            } else {
               var1.loadDataWithBaseURL("", com.noqoush.adfalcon.android.sdk.util.e.a(var1.getContext(), var2), "text/html", "utf-8", (String)null);
            }
         } else if (var4.equalsIgnoreCase("url")) {
            var1.loadUrl(var2.s());
         } else {
            this.b();
         }
      } catch (Exception var7) {
         this.d().c().a((m)null);
         this.b();
      }
   }

   private void a(com.noqoush.adfalcon.android.sdk.interstitial.a var1, k var2) throws Exception {
      RelativeLayout var3 = new RelativeLayout(var1.a());
      var3.setId(555555);
      y var4 = new y(var1.a(), var3, (ProgressBar)null);
      d.a var5 = new d.a(var1.a(), var1.f());
      if (var2.q().a() == 2) {
         x var6 = var1.c();
         m var7 = new m(new MutableContextWrapper(var1.a()), var3, var4, false, var1.f(), var5, var2);
         var6.a(var7);
      }

      this.a((WebView)var1.c().j(), (k)var2);
   }

   public void a() throws Exception {
      if (this.d().e() == this) {
         if (this.d().c().j() != null) {
            this.d().c().j().destroy();
            this.d().c().a((m)null);
         }

         this.d().a((com.noqoush.adfalcon.android.sdk.interstitial.c)(new b()));
         this.d().e().a(this.d(), this.c(), ADFErrorCode.COMMUNICATION_ERROR, "Connection Timeout");
      }

   }

   public void a(ADFInterstitial var1) {
      this.a = var1;
   }

   public void a(com.noqoush.adfalcon.android.sdk.interstitial.a var1) {
      this.b = var1;
   }

   public void a(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2) throws Exception {
      if (var1.a() != null) {
         this.a(var1);
         this.a(var2);
         k var3 = var1.f().g().l();
         if (var3.q().a() == -1) {
            var3.q().a(2);
         }

         if (var3.q().a() != 0 && var3.q().a() != -1) {
            if (var3.q().a() == 2) {
               this.a(var1, var3);
            } else if (var3.q().a() == 1) {
               this.a(var1, var3);
            } else {
               this.b();
            }
         } else {
            this.b();
         }
      }
   }

   public void a(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2, ADFErrorCode var3, String var4) throws Exception {
      throw new Exception("Ad can't fail while being prepared");
   }

   public void b() throws Exception {
      if (this.d().e() == this) {
         this.d().a((com.noqoush.adfalcon.android.sdk.interstitial.c)(new e()));
         this.d().b().a((ADFAd)this.c());
      }

   }

   public void b(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2) throws Exception {
      throw new Exception("Loading ad has been finished, wait while preparing it to be shown");
   }

   public ADFInterstitial c() {
      return this.a;
   }

   public void c(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2) throws Exception {
      throw new Exception("Can't dismiss ad while preparing it");
   }

   public com.noqoush.adfalcon.android.sdk.interstitial.a d() {
      return this.b;
   }

   public void d(com.noqoush.adfalcon.android.sdk.interstitial.a var1, ADFInterstitial var2) throws Exception {
      throw new Exception("Ad hasn't been shown yet, it's being prepared");
   }

   private class a extends p {
      public a(Context var2, w var3) {
         super(var2, var3, (n)null, 5000, false);
         if (var3 != null && var3.g() != null && var3.g().l() != null) {
            this.a(var3.g().l().q().c());
         }

      }

      public void a(WebView var1) {
         com.noqoush.adfalcon.android.sdk.util.a.a("PRELOADING: onTimeout");
         super.a(var1);

         try {
            d.this.b();
         } catch (Exception var4) {
            StringBuilder var3 = new StringBuilder();
            var3.append("ADFInterstitialWebViewClient->onTimeout->");
            var3.append(var4.toString());
            com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
         }
      }

      public void onPageFinished(WebView var1, String var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a("PRELOADING: onPageFinished");
         super.onPageFinished(var1, var2);

         try {
            com.noqoush.adfalcon.android.sdk.util.a.a("preload data of interstitial is finished successfully");
            d.this.b();
         } catch (Exception var5) {
            StringBuilder var4 = new StringBuilder();
            var4.append("ADFInterstitialWebViewClient->onPageFinished->");
            var4.append(var5.toString());
            com.noqoush.adfalcon.android.sdk.k.b(var4.toString());
         }
      }

      public void onReceivedError(WebView var1, int var2, String var3, String var4) {
         StringBuilder var5 = new StringBuilder();
         var5.append("PRELOADING: onReceivedError: ");
         var5.append(var3);
         com.noqoush.adfalcon.android.sdk.util.a.a(var5.toString());
         super.onReceivedError(var1, var2, var3, var4);

         try {
            com.noqoush.adfalcon.android.sdk.util.a.a("preload data of interstitial has not been cached due to receiving an error");
            d.this.a();
         } catch (Exception var10) {
            StringBuilder var9 = new StringBuilder();
            var9.append("ADFInterstitialWebViewClient->onReceivedError->");
            var9.append(var10.toString());
            com.noqoush.adfalcon.android.sdk.k.b(var9.toString());
         }
      }
   }
}
