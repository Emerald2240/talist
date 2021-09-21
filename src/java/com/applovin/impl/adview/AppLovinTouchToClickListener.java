package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class AppLovinTouchToClickListener implements OnTouchListener {
   private final long a;
   private final int b;
   private final AppLovinTouchToClickListener.ClickRecognitionState c;
   private long d;
   private PointF e;
   private boolean f;
   private final Context g;
   private final AppLovinTouchToClickListener.OnClickListener h;

   public AppLovinTouchToClickListener(com.applovin.impl.sdk.j var1, Context var2, AppLovinTouchToClickListener.OnClickListener var3) {
      this.a = (Long)var1.a(com.applovin.impl.sdk.b.d.aF);
      this.b = (Integer)var1.a(com.applovin.impl.sdk.b.d.aG);
      int var4 = (Integer)var1.a(com.applovin.impl.sdk.b.d.aH);
      this.c = AppLovinTouchToClickListener.ClickRecognitionState.values()[var4];
      this.g = var2;
      this.h = var3;
   }

   private float a(float var1) {
      return var1 / this.g.getResources().getDisplayMetrics().density;
   }

   private float a(PointF var1, PointF var2) {
      float var3 = var1.x - var2.x;
      float var4 = var1.y - var2.y;
      return this.a((float)Math.sqrt((double)(var3 * var3 + var4 * var4)));
   }

   private void a(View var1, MotionEvent var2) {
      PointF var3 = new PointF(var2.getRawX(), var2.getRawY());
      this.h.onClick(var1, var3);
      this.f = true;
   }

   public boolean onTouch(View var1, MotionEvent var2) {
      label46: {
         int var3 = var2.getActionMasked();
         if (var3 != 0) {
            if (var3 != 1) {
               if (var3 != 6) {
                  return true;
               }

               if (!this.f && this.c == AppLovinTouchToClickListener.ClickRecognitionState.ACTION_POINTER_UP) {
                  break label46;
               }
            } else {
               if (!this.f && this.c == AppLovinTouchToClickListener.ClickRecognitionState.ACTION_UP) {
                  break label46;
               }

               if (this.c == AppLovinTouchToClickListener.ClickRecognitionState.DISABLED) {
                  long var4 = SystemClock.elapsedRealtime() - this.d;
                  float var6 = this.a(this.e, new PointF(var2.getX(), var2.getY()));
                  if (!this.f) {
                     long var7 = this.a;
                     if (var7 < 0L || var4 < var7) {
                        int var9 = this.b;
                        if (var9 < 0 || var6 < (float)var9) {
                           break label46;
                        }
                     }
                  }
               }
            }
         } else {
            if (this.c == AppLovinTouchToClickListener.ClickRecognitionState.ACTION_DOWN) {
               break label46;
            }

            this.d = SystemClock.elapsedRealtime();
            this.e = new PointF(var2.getX(), var2.getY());
            this.f = false;
         }

         return true;
      }

      this.a(var1, var2);
      return true;
   }

   public static enum ClickRecognitionState {
      ACTION_DOWN,
      ACTION_POINTER_UP,
      ACTION_UP,
      DISABLED;

      static {
         AppLovinTouchToClickListener.ClickRecognitionState[] var0 = new AppLovinTouchToClickListener.ClickRecognitionState[]{DISABLED, ACTION_DOWN, ACTION_POINTER_UP, ACTION_UP};
      }
   }

   public interface OnClickListener {
      void onClick(View var1, PointF var2);
   }
}
