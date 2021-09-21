package com.noqoush.adfalcon.android.sdk.video.vast.player;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class c$a implements AnimatorListener {
   // $FF: synthetic field
   final boolean a;
   // $FF: synthetic field
   final c b;

   c$a(c var1, boolean var2) {
      this.b = var1;
      this.a = var2;
   }

   public void onAnimationCancel(Animator var1) {
   }

   public void onAnimationEnd(Animator var1) {
      c var2 = this.b;
      byte var3;
      if (this.a) {
         var3 = 0;
      } else {
         var3 = 4;
      }

      var2.setVisibility(var3);
   }

   public void onAnimationRepeat(Animator var1) {
   }

   public void onAnimationStart(Animator var1) {
      this.b.setVisibility(0);
   }
}
