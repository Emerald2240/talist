package com.applovin.impl.sdk;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

public class w {
   private final j a;
   private final Object b = new Object();
   private final Rect c = new Rect();
   private final Handler d;
   private final Runnable e;
   private final OnPreDrawListener f;
   private WeakReference g = new WeakReference((Object)null);
   private WeakReference h = new WeakReference((Object)null);
   private int i;
   private long j;
   private long k = Long.MIN_VALUE;

   public w(MaxAdView var1, j var2, w.a var3) {
      this.a = var2;
      this.d = new Handler(Looper.getMainLooper());
      this.e = new Runnable(new WeakReference(var1), new WeakReference(var3)) {
         // $FF: synthetic field
         final WeakReference a;
         // $FF: synthetic field
         final WeakReference b;

         {
            this.a = var2;
            this.b = var3;
         }

         public void run() {
            MaxAdView var1 = (MaxAdView)this.a.get();
            View var2 = (View)w.this.h.get();
            if (var1 != null) {
               if (var2 == null) {
                  return;
               }

               if (w.this.b(var1, var2)) {
                  w.this.a();
                  w.a var3 = (w.a)this.b.get();
                  if (var3 != null) {
                     var3.onLogVisibilityImpression();
                     return;
                  }
               } else {
                  w.this.b();
               }
            }

         }
      };
      this.f = new OnPreDrawListener() {
         public boolean onPreDraw() {
            w.this.b();
            w.this.c();
            return true;
         }
      };
   }

   private void a(Context var1, View var2) {
      View var3 = com.applovin.impl.sdk.utils.q.a(var1, var2);
      if (var3 == null) {
         this.a.v().b("VisibilityTracker", "Unable to set view tree observer due to no root view.");
      } else {
         ViewTreeObserver var4 = var3.getViewTreeObserver();
         if (!var4.isAlive()) {
            this.a.v().d("VisibilityTracker", "Unable to set view tree observer since the view tree observer is not alive.");
         } else {
            this.g = new WeakReference(var4);
            var4.addOnPreDrawListener(this.f);
         }
      }
   }

   private boolean a(View var1, View var2) {
      boolean var3 = false;
      if (var2 != null) {
         int var4 = var2.getVisibility();
         var3 = false;
         if (var4 == 0) {
            if (var1.getParent() == null) {
               return false;
            }

            int var5 = var2.getWidth();
            var3 = false;
            if (var5 > 0) {
               if (var2.getHeight() <= 0) {
                  return false;
               }

               if (!var2.getGlobalVisibleRect(this.c)) {
                  return false;
               }

               long var7;
               int var6 = (var7 = (long)(AppLovinSdkUtils.pxToDp(var2.getContext(), this.c.width()) * AppLovinSdkUtils.pxToDp(var2.getContext(), this.c.height())) - (long)this.i) == 0L ? 0 : (var7 < 0L ? -1 : 1);
               var3 = false;
               if (var6 >= 0) {
                  var3 = true;
               }
            }
         }
      }

      return var3;
   }

   private void b() {
      this.d.postDelayed(this.e, (Long)this.a.a(com.applovin.impl.sdk.b.d.cm));
   }

   private boolean b(View var1, View var2) {
      boolean var3 = this.a(var1, var2);
      boolean var4 = false;
      if (var3) {
         if (this.k == Long.MIN_VALUE) {
            this.k = SystemClock.uptimeMillis();
         }

         long var6;
         int var5 = (var6 = SystemClock.uptimeMillis() - this.k - this.j) == 0L ? 0 : (var6 < 0L ? -1 : 1);
         var4 = false;
         if (var5 >= 0) {
            var4 = true;
         }
      }

      return var4;
   }

   private void c() {
      ViewTreeObserver var1 = (ViewTreeObserver)this.g.get();
      if (var1 != null && var1.isAlive()) {
         var1.removeOnPreDrawListener(this.f);
      }

      this.g.clear();
   }

   public void a() {
      // $FF: Couldn't be decompiled
   }

   public void a(Context param1, com.applovin.impl.mediation.b.b param2) {
      // $FF: Couldn't be decompiled
   }

   public interface a {
      void onLogVisibilityImpression();
   }
}
