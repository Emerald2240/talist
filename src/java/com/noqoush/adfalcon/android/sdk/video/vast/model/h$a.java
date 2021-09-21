package com.noqoush.adfalcon.android.sdk.video.vast.model;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class h$a extends WebViewClient {
   // $FF: synthetic field
   final h a;

   h$a(h var1) {
      this.a = var1;
   }

   public void onPageFinished(WebView var1, String var2) {
      super.onPageFinished(var1, var2);
      this.a.o();
      this.a.a(false);
   }

   public void onReceivedError(WebView var1, int var2, String var3, String var4) {
      this.a.n();
   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      if (this.a.m()) {
         return false;
      } else {
         com.noqoush.adfalcon.android.sdk.handler.c var3 = new com.noqoush.adfalcon.android.sdk.handler.c();
         com.noqoush.adfalcon.android.sdk.urlactions.e var4 = new com.noqoush.adfalcon.android.sdk.urlactions.e(var2, this.a.e(), false, true, (com.noqoush.adfalcon.android.sdk.urlactions.g)null, var1);
         var4.a((com.noqoush.adfalcon.android.sdk.urlactions.g)(new h$a$a(this)));
         var3.a(var4);
         return true;
      }
   }
}
