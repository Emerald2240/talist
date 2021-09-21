package com.applovin.impl.adview;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.sdk.AppLovinAd;

class e {
   private final com.applovin.impl.sdk.j a;
   private final WebViewRenderProcessClient b = new WebViewRenderProcessClient() {
      public void onRenderProcessResponsive(WebView var1, WebViewRenderProcess var2) {
      }

      public void onRenderProcessUnresponsive(WebView var1, WebViewRenderProcess var2) {
         if (var1 instanceof c) {
            AppLovinAd var3 = ((c)var1).b();
            if (var3 instanceof AppLovinAdBase) {
               e.this.a.X().a((AppLovinAdBase)var3).a(com.applovin.impl.sdk.c.b.F).a();
            }

            com.applovin.impl.sdk.p var4 = e.this.a.v();
            StringBuilder var5 = new StringBuilder();
            var5.append("WebView render process unresponsive for ad: ");
            var5.append(var3);
            var4.e("AdWebViewRenderProcessClient", var5.toString());
         }

      }
   };

   e(com.applovin.impl.sdk.j var1) {
      this.a = var1;
   }

   WebViewRenderProcessClient a() {
      return this.b;
   }
}
