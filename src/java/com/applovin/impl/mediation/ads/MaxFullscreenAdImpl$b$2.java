package com.applovin.impl.mediation.ads;

import com.applovin.impl.sdk.utils.j;

class MaxFullscreenAdImpl$b$2 implements Runnable {
   // $FF: synthetic field
   final String a;
   // $FF: synthetic field
   final int b;
   // $FF: synthetic field
   final <undefinedtype> c;

   MaxFullscreenAdImpl$b$2(Object var1, String var2, int var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void run() {
      j.a(this.c.a.adListener, this.a, this.b);
   }
}
