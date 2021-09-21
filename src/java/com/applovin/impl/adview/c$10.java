package com.applovin.impl.adview;

import android.webkit.WebSettings;

class c$10 implements Runnable {
   // $FF: synthetic field
   final WebSettings a;
   // $FF: synthetic field
   final Integer b;
   // $FF: synthetic field
   final c c;

   c$10(c var1, WebSettings var2, Integer var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void run() {
      this.a.setMixedContentMode(this.b);
   }
}
