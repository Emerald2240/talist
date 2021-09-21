package com.noqoush.adfalcon.android.sdk.video.vast.player;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.ScaleAnimation;

class f$f implements OnClickListener {
   // $FF: synthetic field
   final f a;

   f$f(f var1) {
      this.a = var1;
   }

   public void onClick(View var1) {
      try {
         if (this.a.getAutoCloseRelativeLayout().getVisibility() != 8) {
            if (this.a.getAutoCloseRelativeLayout().getAnimation() == null || this.a.getAutoCloseRelativeLayout().getAnimation().hasEnded()) {
               this.a.getAutoCloseRelativeLayout().clearAnimation();
               ScaleAnimation var3 = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 1.0F);
               var3.setDuration(250L);
               var3.setFillEnabled(true);
               var3.setFillAfter(true);
               var3.setAnimationListener(new f$f$a(this));
               this.a.getAutoCloseRelativeLayout().startAnimation(var3);
               this.a.getTitleTxtView().setAlpha(1.0F);
               this.a.getTopContainerListener().c();
            }
         }
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }
   }
}
