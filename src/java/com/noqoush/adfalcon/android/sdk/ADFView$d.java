package com.noqoush.adfalcon.android.sdk;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ADFView$d implements AnimationListener {
   // $FF: synthetic field
   final ADFView a;

   ADFView$d(ADFView var1) {
      this.a = var1;
   }

   public void onAnimationEnd(Animation var1) {
      this.a.postDelayed(new ADFView$d$a(this), 10L);
   }

   public void onAnimationRepeat(Animation var1) {
   }

   public void onAnimationStart(Animation var1) {
   }
}
