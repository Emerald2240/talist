package com.iab.omid.library.adfalcon.publisher;

import android.webkit.WebView;

public class a extends AdSessionStatePublisher {
   public a(WebView var1) {
      if (var1 != null && !var1.getSettings().getJavaScriptEnabled()) {
         var1.getSettings().setJavaScriptEnabled(true);
      }

      this.a(var1);
   }
}
