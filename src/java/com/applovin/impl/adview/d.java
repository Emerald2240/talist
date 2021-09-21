package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.net.http.SslError;
import android.view.ViewParent;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.sdk.AppLovinAd;
import java.util.List;

class d extends WebViewClient {
   private final com.applovin.impl.sdk.j a;
   private final com.applovin.impl.sdk.p b;
   private final AdViewControllerImpl c;

   public d(AdViewControllerImpl var1, com.applovin.impl.sdk.j var2) {
      this.a = var2;
      this.b = var2.v();
      this.c = var1;
   }

   private void a() {
      this.c.a();
   }

   private void a(PointF var1) {
      this.c.expandAd(var1);
   }

   private void a(Uri param1, c param2) {
      // $FF: Couldn't be decompiled
   }

   private void a(com.applovin.impl.a.a var1, c var2) {
      com.applovin.impl.a.b var3 = var1.j();
      if (var3 != null) {
         com.applovin.impl.a.i.a(var3.c(), this.c.getSdk());
         this.a(var2, var3.a());
      }

   }

   private void a(c var1) {
      ViewParent var2 = var1.getParent();
      if (var2 instanceof AppLovinAdView) {
         ((AppLovinAdView)var2).loadNextAd();
      }

   }

   private void a(c var1, Uri var2) {
      AppLovinAd var3 = var1.b();
      AppLovinAdView var4 = this.c.getParentView();
      if (var4 != null && var3 != null) {
         com.applovin.impl.sdk.c.d var9 = var1.c();
         if (var9 != null) {
            var9.b();
         }

         this.c.a(var3, var4, var2, var1.getAndClearLastClickLocation());
      } else {
         com.applovin.impl.sdk.p var5 = this.b;
         StringBuilder var6 = new StringBuilder();
         var6.append("Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = ");
         var6.append(var2);
         var5.e("AdWebView", var6.toString());
      }
   }

   private boolean a(WebView var1, String var2, boolean var3) {
      com.applovin.impl.sdk.p var15;
      String var16;
      label233: {
         Uri var9;
         c var10;
         label226: {
            com.applovin.impl.sdk.p var4 = this.b;
            StringBuilder var5 = new StringBuilder();
            var5.append("Processing click on ad URL \"");
            var5.append(var2);
            var5.append("\"");
            var4.c("AdWebView", var5.toString());
            if (var2 != null && var1 instanceof c) {
               var9 = Uri.parse(var2);
               var10 = (c)var1;
               String var11 = var9.getScheme();
               String var12 = var9.getHost();
               String var13 = var9.getPath();
               AppLovinAd var14 = this.c.getCurrentAd();
               com.applovin.impl.a.a var20;
               if ("applovin".equals(var11) && "com.applovin.sdk".equals(var12)) {
                  if ("/adservice/next_ad".equals(var13)) {
                     this.a(var10);
                     return true;
                  }

                  if ("/adservice/close_ad".equals(var13)) {
                     this.a();
                     return true;
                  }

                  if ("/adservice/expand_ad".equals(var13)) {
                     this.a(var10.getAndClearLastClickLocation());
                     return true;
                  }

                  if ("/adservice/contract_ad".equals(var13)) {
                     this.b();
                     return true;
                  }

                  if (AppLovinAdServiceImpl.URI_NO_OP.equals(var13)) {
                     return true;
                  }

                  if (AppLovinAdServiceImpl.URI_LOAD_URL.equals(var13)) {
                     this.a(var9, var10);
                     return true;
                  }

                  if (!AppLovinAdServiceImpl.URI_TRACK_CLICK_IMMEDIATELY.equals(var13)) {
                     if (var13 == null || !var13.startsWith("/launch/")) {
                        com.applovin.impl.sdk.p var21 = this.b;
                        StringBuilder var22 = new StringBuilder();
                        var22.append("Unknown URL: ");
                        var22.append(var2);
                        var21.d("AdWebView", var22.toString());
                        com.applovin.impl.sdk.p var25 = this.b;
                        StringBuilder var26 = new StringBuilder();
                        var26.append("Path: ");
                        var26.append(var13);
                        var25.d("AdWebView", var26.toString());
                        return true;
                     }

                     List var29 = var9.getPathSegments();
                     if (var29 != null && var29.size() > 1) {
                        String var30 = (String)var29.get(var29.size() - 1);

                        try {
                           Context var36 = var1.getContext();
                           var36.startActivity(var36.getPackageManager().getLaunchIntentForPackage(var30));
                           this.a((c)var10, (Uri)null);
                           return true;
                        } catch (Throwable var38) {
                           com.applovin.impl.sdk.p var32 = this.b;
                           StringBuilder var33 = new StringBuilder();
                           var33.append("Threw Exception Trying to Launch App for Package: ");
                           var33.append(var30);
                           var32.b("AdWebView", var33.toString(), var38);
                           return true;
                        }
                     }

                     return true;
                  }

                  if (!(var14 instanceof com.applovin.impl.a.a)) {
                     this.a(var10, Uri.parse(AppLovinAdServiceImpl.URI_TRACK_CLICK_IMMEDIATELY));
                     return true;
                  }

                  var20 = (com.applovin.impl.a.a)var14;
               } else {
                  if (!var3) {
                     return false;
                  }

                  if (!(var14 instanceof com.applovin.impl.sdk.ad.f)) {
                     var15 = this.b;
                     var16 = "Bypassing click for ad of invalid type";
                     break label233;
                  }

                  com.applovin.impl.sdk.ad.f var17 = (com.applovin.impl.sdk.ad.f)var14;
                  List var18 = var17.aA();
                  List var19 = var17.aB();
                  if (!var18.isEmpty() && !var18.contains(var11) || !var19.isEmpty() && !var19.contains(var12)) {
                     var15 = this.b;
                     var16 = "URL is not whitelisted - bypassing click";
                     break label233;
                  }

                  if (!(var14 instanceof com.applovin.impl.a.a)) {
                     break label226;
                  }

                  var20 = (com.applovin.impl.a.a)var14;
                  if (!var20.k()) {
                     break label226;
                  }
               }

               this.a(var20, var10);
               return true;
            }

            return true;
         }

         this.a(var10, var9);
         return true;
      }

      var15.e("AdWebView", var16);
      return true;
   }

   private void b() {
      this.c.contractAd();
   }

   public void onLoadResource(WebView var1, String var2) {
      super.onLoadResource(var1, var2);
      com.applovin.impl.sdk.p var3 = this.b;
      StringBuilder var4 = new StringBuilder();
      var4.append("Loaded resource: ");
      var4.append(var2);
      var3.c("AdWebView", var4.toString());
   }

   public void onPageFinished(WebView var1, String var2) {
      super.onPageFinished(var1, var2);
      this.c.onAdHtmlLoaded(var1);
   }

   public void onReceivedError(WebView var1, int var2, String var3, String var4) {
      super.onReceivedError(var1, var2, var3, var4);
      AppLovinAd var5 = this.c.getCurrentAd();
      StringBuilder var6 = new StringBuilder();
      var6.append("Received error with error code: ");
      var6.append(var2);
      var6.append(" with description \\'");
      var6.append(var3);
      var6.append("\\' for URL: ");
      var6.append(var4);
      String var13 = var6.toString();
      if (var5 instanceof AppLovinAdBase) {
         this.a.X().a((AppLovinAdBase)var5).a(com.applovin.impl.sdk.c.b.C, var13).a();
      }

      com.applovin.impl.sdk.p var14 = this.b;
      StringBuilder var15 = new StringBuilder();
      var15.append(var13);
      var15.append(" for ad: ");
      var15.append(var5);
      var14.e("AdWebView", var15.toString());
   }

   public void onReceivedError(WebView var1, WebResourceRequest var2, WebResourceError var3) {
      super.onReceivedError(var1, var2, var3);
      this.onReceivedError(var1, var3.getErrorCode(), var3.getDescription().toString(), var2.getUrl().toString());
   }

   public void onReceivedHttpError(WebView var1, WebResourceRequest var2, WebResourceResponse var3) {
      super.onReceivedHttpError(var1, var2, var3);
      AppLovinAd var4 = this.c.getCurrentAd();
      if (var4 instanceof AppLovinAdBase) {
         this.a.X().a((AppLovinAdBase)var4).a(com.applovin.impl.sdk.c.b.D).a();
      }

      com.applovin.impl.sdk.p var5 = this.b;
      StringBuilder var6 = new StringBuilder();
      var6.append("Received HTTP error: ");
      var6.append(var3);
      var6.append("for url: ");
      var6.append(var2.getUrl());
      var6.append(" and ad: ");
      var6.append(var4);
      var5.e("AdWebView", var6.toString());
   }

   public void onReceivedSslError(WebView var1, SslErrorHandler var2, SslError var3) {
      super.onReceivedSslError(var1, var2, var3);
      AppLovinAd var4 = this.c.getCurrentAd();
      StringBuilder var5 = new StringBuilder();
      var5.append("Received SSL error: ");
      var5.append(var3);
      String var8 = var5.toString();
      if (var4 instanceof AppLovinAdBase) {
         this.a.X().a((AppLovinAdBase)var4).a(com.applovin.impl.sdk.c.b.E, var8).a();
      }

      com.applovin.impl.sdk.p var9 = this.b;
      StringBuilder var10 = new StringBuilder();
      var10.append(var8);
      var10.append(" for ad: ");
      var10.append(var4);
      var9.e("AdWebView", var10.toString());
   }

   public boolean shouldOverrideUrlLoading(WebView var1, WebResourceRequest var2) {
      boolean var3;
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.cb)) {
         var3 = var2.hasGesture();
      } else {
         var3 = true;
      }

      Uri var4 = var2.getUrl();
      if (var4 != null) {
         return this.a(var1, var4.toString(), var3);
      } else {
         this.b.e("AdWebView", "No url found for request");
         return false;
      }
   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      return this.a(var1, var2, true);
   }
}
