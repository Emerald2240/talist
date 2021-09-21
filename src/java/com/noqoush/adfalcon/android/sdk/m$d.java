package com.noqoush.adfalcon.android.sdk;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

class m$d implements Runnable {
   // $FF: synthetic field
   final m a;

   m$d(m var1) {
      this.a = var1;
   }

   public void run() {
      try {
         Class var2 = Class.forName("android.webkit.WebView");
         var2.getMethod("onPause", (Class[])null).invoke(this, (Object[])null);
         if (this.a.q != null) {
            ((y)this.a.q.get()).b();
         }

         this.a.setWebChromeClient((WebChromeClient)null);
         this.a.setWebViewClient((WebViewClient)null);
         ((y)this.a.q.get()).a((Context)null);
         ((p)m.c(this.a).get()).a((Context)null);
         m.d(this.a).b();
         this.a.stopLoading();
         this.a.destroy();
      } catch (Exception var3) {
         k.b(var3.getMessage());
      }
   }
}
