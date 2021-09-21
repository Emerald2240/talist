package com.applovin.impl.mediation.ads;

import android.app.Activity;
import com.applovin.impl.mediation.j;
import com.applovin.impl.mediation.b.c;

class MaxFullscreenAdImpl$2 implements Runnable {
   // $FF: synthetic field
   final Activity a;
   // $FF: synthetic field
   final MaxFullscreenAdImpl b;

   MaxFullscreenAdImpl$2(MaxFullscreenAdImpl var1, Activity var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      c var1 = MaxFullscreenAdImpl.c(this.b);
      if (var1 != null && !var1.j()) {
         MaxFullscreenAdImpl.a((MaxFullscreenAdImpl)this.b, (<undefinedtype>)null.c, (Runnable)(new MaxFullscreenAdImpl$2$1(this, var1)));
      } else {
         this.b.sdk.B().a((j.b)this.b.listenerWrapper);
         Activity var2 = this.a;
         if (var2 == null) {
            var2 = this.b.sdk.ag();
         }

         this.b.sdk.y().loadAd(this.b.adUnitId, this.b.adFormat, this.b.loadRequestBuilder.a(), false, var2, this.b.listenerWrapper);
      }
   }
}
