package com.noqoush.adfalcon.android.sdk.video.vast.player;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class f$f$a implements AnimationListener {
   // $FF: synthetic field
   final f$f a;

   f$f$a(f$f var1) {
      this.a = var1;
   }

   public void onAnimationEnd(Animation var1) {
      this.a.a.getAutoCloseRelativeLayout().setVisibility(8);
   }

   public void onAnimationRepeat(Animation var1) {
   }

   public void onAnimationStart(Animation var1) {
   }
}
