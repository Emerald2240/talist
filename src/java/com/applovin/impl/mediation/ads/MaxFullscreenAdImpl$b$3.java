package com.applovin.impl.mediation.ads;

import com.applovin.impl.sdk.utils.j;

class MaxFullscreenAdImpl$b$3 implements Runnable {
   // $FF: synthetic field
   final <undefinedtype> a;

   MaxFullscreenAdImpl$b$3(Object var1) {
      this.a = var1;
   }

   public void run() {
      MaxFullscreenAdImpl.j(this.a.a);
      j.c(this.a.a.adListener, MaxFullscreenAdImpl.e(this.a.a));
   }
}
