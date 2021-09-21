package com.applovin.impl.adview;

import android.os.SystemClock;
import android.view.animation.AlphaAnimation;

class m$9 implements Runnable {
   // $FF: synthetic field
   final m a;

   m$9(m var1) {
      this.a = var1;
   }

   public void run() {
      try {
         if (!m.v(this.a) && m.r(this.a) != null) {
            m.b(this.a, -1L);
            m.c(this.a, SystemClock.elapsedRealtime());
            m.b(this.a, true);
            m.r(this.a).setVisibility(0);
            AlphaAnimation var11 = new AlphaAnimation(0.0F, 1.0F);
            var11.setDuration((long)(Integer)this.a.sdk.a(com.applovin.impl.sdk.b.d.cF));
            var11.setRepeatCount(0);
            m.r(this.a).startAnimation(var11);
            if (m.t(this.a) && m.w(this.a) != null) {
               m.w(this.a).setVisibility(0);
               m.w(this.a).bringToFront();
               return;
            }
         }
      } catch (Throwable var13) {
         com.applovin.impl.sdk.p var2 = this.a.logger;
         StringBuilder var3 = new StringBuilder();
         var3.append("Unable to show skip button: ");
         var3.append(var13);
         var2.d("InterActivity", var3.toString());
         return;
      }

   }
}
