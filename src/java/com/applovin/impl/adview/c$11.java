package com.applovin.impl.adview;

import android.webkit.WebSettings;

class c$11 implements Runnable {
   // $FF: synthetic field
   final WebSettings a;
   // $FF: synthetic field
   final Boolean b;
   // $FF: synthetic field
   final c c;

   c$11(c var1, WebSettings var2, Boolean var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void run() {
      this.a.setOffscreenPreRaster(this.b);
   }
}
