package com.applovin.impl.sdk;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;

public class v {
   private final j a;
   private final p b;
   private final MaxAdView c;

   public v(MaxAdView var1, j var2) {
      this.a = var2;
      this.b = var2.v();
      this.c = var1;
   }

   public long a(com.applovin.impl.mediation.b.b var1) {
      this.b.b("ViewabilityTracker", "Checking visibility...");
      long var2;
      if (!this.c.isShown()) {
         this.b.e("ViewabilityTracker", "View is hidden");
         var2 = 2L;
      } else {
         var2 = 0L;
      }

      if (this.c.getAlpha() < var1.p()) {
         this.b.e("ViewabilityTracker", "View is transparent");
         var2 |= 4L;
      }

      Animation var4 = this.c.getAnimation();
      if (var4 != null && var4.hasStarted() && !var4.hasEnded()) {
         this.b.e("ViewabilityTracker", "View is animating");
         var2 |= 8L;
      }

      if (this.c.getParent() == null) {
         this.b.e("ViewabilityTracker", "No parent view found");
         var2 |= 16L;
      }

      int var5 = AppLovinSdkUtils.pxToDp(this.c.getContext(), this.c.getWidth());
      if (var5 < var1.n()) {
         p var28 = this.b;
         StringBuilder var29 = new StringBuilder();
         var29.append("View has width (");
         var29.append(var5);
         var29.append(") below threshold");
         var28.e("ViewabilityTracker", var29.toString());
         var2 |= 32L;
      }

      int var6 = AppLovinSdkUtils.pxToDp(this.c.getContext(), this.c.getHeight());
      if (var6 < var1.o()) {
         p var23 = this.b;
         StringBuilder var24 = new StringBuilder();
         var24.append("View has height (");
         var24.append(var6);
         var24.append(") below threshold");
         var23.e("ViewabilityTracker", var24.toString());
         var2 |= 64L;
      }

      Point var7 = com.applovin.impl.sdk.utils.g.a(this.c.getContext());
      Rect var8 = new Rect(0, 0, var7.x, var7.y);
      int[] var9 = new int[]{-1, -1};
      this.c.getLocationOnScreen(var9);
      Rect var10 = new Rect(var9[0], var9[1], var9[0] + this.c.getWidth(), var9[1] + this.c.getHeight());
      if (!Rect.intersects(var8, var10)) {
         p var16 = this.b;
         StringBuilder var17 = new StringBuilder();
         var17.append("Rect (");
         var17.append(var10);
         var17.append(") outside of screen's bounds (");
         var17.append(var8);
         var17.append(")");
         var16.e("ViewabilityTracker", var17.toString());
         var2 |= 128L;
      }

      Activity var11 = this.a.aa().a();
      if (var11 != null && !com.applovin.impl.sdk.utils.q.a((View)this.c, (Activity)var11)) {
         this.b.e("ViewabilityTracker", "View is not in top activity's view hierarchy");
         var2 |= 256L;
      }

      p var12 = this.b;
      StringBuilder var13 = new StringBuilder();
      var13.append("Returning flags: ");
      var13.append(Long.toBinaryString(var2));
      var12.b("ViewabilityTracker", var13.toString());
      return var2;
   }
}
