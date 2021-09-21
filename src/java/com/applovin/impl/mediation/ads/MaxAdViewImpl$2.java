package com.applovin.impl.mediation.ads;

import android.animation.AnimatorListenerAdapter;
import com.applovin.impl.mediation.b.b;
import com.applovin.impl.sdk.p;
import com.applovin.mediation.ads.MaxAdView;

class MaxAdViewImpl$2 implements Runnable {
   // $FF: synthetic field
   final b a;
   // $FF: synthetic field
   final MaxAdViewImpl b;

   MaxAdViewImpl$2(MaxAdViewImpl var1, b var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      p var1;
      String var2;
      String var3;
      if (this.a.l() != null) {
         MaxAdView var4 = MaxAdViewImpl.d(this.b);
         if (var4 != null) {
            MaxAdViewImpl.a((MaxAdViewImpl)this.b, (AnimatorListenerAdapter)(new MaxAdViewImpl$2$1(this, var4)));
            return;
         }

         var1 = this.b.logger;
         var2 = this.b.tag;
         var3 = "Max ad view does not have a parent View";
      } else {
         var1 = this.b.logger;
         var2 = this.b.tag;
         var3 = "Max ad does not have a loaded ad view";
      }

      var1.e(var2, var3);
      MaxAdViewImpl.h(this.b).onAdDisplayFailed(this.a, -5201);
   }
}
