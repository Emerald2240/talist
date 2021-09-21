package com.applovin.impl.adview;

import android.view.animation.AlphaAnimation;

class k$6 implements Runnable {
   // $FF: synthetic field
   final k a;

   k$6(k var1) {
      this.a = var1;
   }

   public void run() {
      try {
         if (k.e(this.a) == null) {
            k.d(this.a);
         }

         k.e(this.a).setVisibility(0);
         k.e(this.a).bringToFront();
         AlphaAnimation var2 = new AlphaAnimation(0.0F, 1.0F);
         var2.setDuration((Long)k.f(this.a).a(com.applovin.impl.sdk.b.d.cq));
         var2.setAnimationListener(new k$6$1(this));
         k.e(this.a).startAnimation(var2);
      } catch (Throwable var4) {
         k.g(this.a).b("ExpandedAdDialog", "Unable to fade in close button", var4);
         k.d(this.a);
         return;
      }
   }
}
