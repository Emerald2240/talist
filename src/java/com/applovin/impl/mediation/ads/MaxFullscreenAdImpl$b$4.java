package com.applovin.impl.mediation.ads;

import com.applovin.impl.sdk.utils.j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;

class MaxFullscreenAdImpl$b$4 implements Runnable {
   // $FF: synthetic field
   final int a;
   // $FF: synthetic field
   final <undefinedtype> b;

   MaxFullscreenAdImpl$b$4(Object var1, int var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      MaxFullscreenAdImpl.h(this.b.a).a();
      MaxFullscreenAdImpl.j(this.b.a);
      j.a((MaxAdListener)this.b.a.adListener, (MaxAd)MaxFullscreenAdImpl.e(this.b.a), this.a);
   }
}
