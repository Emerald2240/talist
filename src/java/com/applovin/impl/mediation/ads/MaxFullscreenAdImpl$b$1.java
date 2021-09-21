package com.applovin.impl.mediation.ads;

import com.applovin.impl.sdk.utils.j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;

class MaxFullscreenAdImpl$b$1 implements Runnable {
   // $FF: synthetic field
   final <undefinedtype> a;

   MaxFullscreenAdImpl$b$1(Object var1) {
      this.a = var1;
   }

   public void run() {
      j.a((MaxAdListener)this.a.a.adListener, (MaxAd)MaxFullscreenAdImpl.e(this.a.a));
   }
}
