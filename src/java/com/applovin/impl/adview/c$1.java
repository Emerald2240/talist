package com.applovin.impl.adview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class c$1 implements OnTouchListener {
   // $FF: synthetic field
   final c a;

   c$1(c var1) {
      this.a = var1;
   }

   public boolean onTouch(View var1, MotionEvent var2) {
      if (!var1.hasFocus()) {
         var1.requestFocus();
      }

      return false;
   }
}
