package com.iab.omid.library.adfalcon.publisher;

import android.webkit.WebView;

class b$1 implements Runnable {
   // $FF: synthetic field
   final b a;
   private WebView b;

   b$1(b var1) {
      this.a = var1;
      this.b = com.iab.omid.library.adfalcon.publisher.b.a(this.a);
   }

   public void run() {
      this.b.destroy();
   }
}
