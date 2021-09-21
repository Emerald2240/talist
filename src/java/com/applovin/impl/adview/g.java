package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.webkit.WebView;

public class g extends WebView {
   private PointF a = new PointF();

   public g(Context var1) {
      super(var1);
   }

   public PointF getAndClearLastClickLocation() {
      PointF var1 = this.a;
      this.a = new PointF();
      return var1;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      this.a = new PointF(var1.getRawX(), var1.getRawY());
      return super.onTouchEvent(var1);
   }
}
