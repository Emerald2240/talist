package com.noqoush.adfalcon.android.sdk.viewability;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class d$a extends WebViewClient {
   // $FF: synthetic field
   final d a;

   d$a(d var1) {
      this.a = var1;
   }

   public void onPageFinished(WebView var1, String var2) {
      super.onPageFinished(var1, var2);
      this.a.a(var2);
   }
}
