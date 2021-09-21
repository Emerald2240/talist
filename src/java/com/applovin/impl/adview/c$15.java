package com.applovin.impl.adview;

import android.webkit.WebView;

class c$15 implements Runnable {
   // $FF: synthetic field
   final c a;

   c$15(c var1) {
      this.a = var1;
   }

   public void run() {
      WebView.setWebContentsDebuggingEnabled(true);
   }
}
