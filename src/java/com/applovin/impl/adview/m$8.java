package com.applovin.impl.adview;

import android.os.SystemClock;
import android.view.animation.AlphaAnimation;

class m$8 implements Runnable {
   // $FF: synthetic field
   final m a;

   m$8(m var1) {
      this.a = var1;
   }

   public void run() {
      try {
         if (m.s(this.a)) {
            m.q(this.a).setVisibility(0);
         } else {
            m.a(this.a, SystemClock.elapsedRealtime());
            m.a(this.a, true);
            if (m.t(this.a) && m.u(this.a) != null) {
               m.u(this.a).setVisibility(0);
               m.u(this.a).bringToFront();
            }

            m.q(this.a).setVisibility(0);
            m.q(this.a).bringToFront();
            AlphaAnimation var5 = new AlphaAnimation(0.0F, 1.0F);
            var5.setDuration((long)(Integer)this.a.sdk.a(com.applovin.impl.sdk.b.d.cF));
            var5.setRepeatCount(0);
            m.q(this.a).startAnimation(var5);
         }
      } finally {
         this.a.dismiss();
         return;
      }
   }
}
