package com.applovin.impl.mediation.ads;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.applovin.impl.mediation.b.b;
import com.applovin.impl.sdk.d;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.v;
import com.applovin.impl.sdk.w;
import com.applovin.impl.sdk.b.c;
import com.applovin.impl.sdk.d.ac;
import com.applovin.impl.sdk.utils.q;
import com.applovin.impl.sdk.utils.r;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.TimeUnit;

public class MaxAdViewImpl extends a implements d.a, w.a {
   private static final int[] q = new int[]{10, 14};
   private final Activity a;
   private final MaxAdView b;
   private final View c;
   private long d = Long.MAX_VALUE;
   private b e;
   private String f;
   private final <undefinedtype> g;
   private final <undefinedtype> h;
   private final d i;
   private final v j;
   private final w k;
   private final Object l = new Object();
   private b m = null;
   private boolean n;
   private boolean o;
   private boolean p = false;

   public MaxAdViewImpl(String var1, MaxAdView var2, View var3, j var4, Activity var5) {
      super(var1, MaxAdFormat.BANNER, "MaxAdView", var4);
      if (var5 != null) {
         this.a = var5;
         this.b = var2;
         this.c = var3;
         this.g = new <undefinedtype>((MaxAdViewImpl$1)null) {
            public void onAdLoadFailed(String var1, int var2) {
               com.applovin.impl.sdk.utils.j.a(MaxAdViewImpl.this.adListener, var1, var2);
               MaxAdViewImpl.this.a(var2);
            }

            public void onAdLoaded(MaxAd var1) {
               if (var1 instanceof b) {
                  b var7 = (b)var1;
                  var7.d(MaxAdViewImpl.this.f);
                  MaxAdViewImpl.this.a(var7);
                  if (var7.I()) {
                     long var8 = var7.J();
                     p var10 = MaxAdViewImpl.this.sdk.v();
                     String var11 = MaxAdViewImpl.this.tag;
                     StringBuilder var12 = new StringBuilder();
                     var12.append("Scheduling banner ad refresh ");
                     var12.append(var8);
                     var12.append(" milliseconds from now for '");
                     var12.append(MaxAdViewImpl.this.adUnitId);
                     var12.append("'...");
                     var10.b(var11, var12.toString());
                     MaxAdViewImpl.this.i.a(var8);
                  }

                  com.applovin.impl.sdk.utils.j.a(MaxAdViewImpl.this.adListener, var1);
               } else {
                  p var2 = MaxAdViewImpl.this.logger;
                  String var3 = MaxAdViewImpl.this.tag;
                  StringBuilder var4 = new StringBuilder();
                  var4.append("Not a MediatedAdViewAd received: ");
                  var4.append(var1);
                  var2.e(var3, var4.toString());
                  this.onAdLoadFailed(MaxAdViewImpl.this.adUnitId, -5201);
               }
            }
         };
         this.h = new <undefinedtype>((MaxAdViewImpl$1)null) {
            public void onAdLoadFailed(String var1, int var2) {
               p var3 = MaxAdViewImpl.this.logger;
               String var4 = MaxAdViewImpl.this.tag;
               StringBuilder var5 = new StringBuilder();
               var5.append("Failed to pre-cache ad for refresh with error code ");
               var5.append(var2);
               var3.b(var4, var5.toString());
               MaxAdViewImpl.this.a(var2);
            }

            public void onAdLoaded(MaxAd var1) {
               MaxAdViewImpl.this.logger.b(MaxAdViewImpl.this.tag, "Successfully pre-cached ad for refresh");
               MaxAdViewImpl.this.a(var1);
            }
         };
         this.i = new d(var4, this);
         this.j = new v(var2, var4);
         this.k = new w(var2, var4, this);
         p var6 = this.logger;
         String var7 = this.tag;
         StringBuilder var8 = new StringBuilder();
         var8.append("Created new MaxAdView (");
         var8.append(this);
         var8.append(")");
         var6.b(var7, var8.toString());
      } else {
         throw new IllegalArgumentException("No activity specified");
      }
   }

   // $FF: synthetic method
   static b a(MaxAdViewImpl var0) {
      return var0.m;
   }

   // $FF: synthetic method
   static b a(MaxAdViewImpl var0, b var1) {
      var0.m = var1;
      return var1;
   }

   private void a() {
      // $FF: Couldn't be decompiled
   }

   private void a(int var1) {
      if (this.sdk.b(com.applovin.impl.sdk.b.c.t).contains(String.valueOf(var1))) {
         p var12 = this.sdk.v();
         String var13 = this.tag;
         StringBuilder var14 = new StringBuilder();
         var14.append("Ignoring banner ad refresh for error code '");
         var14.append(var1);
         var14.append("'...");
         var12.b(var13, var14.toString());
      } else {
         this.n = true;
         long var2 = (Long)this.sdk.a(com.applovin.impl.sdk.b.c.s);
         if (var2 >= 0L) {
            p var4 = this.sdk.v();
            String var5 = this.tag;
            StringBuilder var6 = new StringBuilder();
            var6.append("Scheduling failed banner ad refresh ");
            var6.append(var2);
            var6.append(" milliseconds from now for '");
            var6.append(this.adUnitId);
            var6.append("'...");
            var4.b(var5, var6.toString());
            this.i.a(var2);
         }

      }
   }

   private void a(long var1) {
      if (com.applovin.impl.sdk.utils.q.a(var1, (Long)this.sdk.a(com.applovin.impl.sdk.b.c.C))) {
         p var3 = this.logger;
         String var4 = this.tag;
         StringBuilder var5 = new StringBuilder();
         var5.append("Undesired flags matched - current: ");
         var5.append(Long.toBinaryString(var1));
         var5.append(", undesired: ");
         var5.append(Long.toBinaryString(var1));
         var3.b(var4, var5.toString());
         this.logger.b(this.tag, "Waiting for refresh timer to manually fire request");
         this.n = true;
      } else {
         this.logger.b(this.tag, "No undesired viewability flags matched - scheduling viewability");
         this.n = false;
         this.b();
      }
   }

   private void a(AnimatorListenerAdapter var1) {
      b var2 = this.m;
      if (var2 != null && var2.l() != null) {
         View var3 = this.m.l();
         long var4 = (Long)this.sdk.a(com.applovin.impl.sdk.b.c.z);
         var3.animate().alpha(0.0F).setDuration(var4).setListener(var1).start();
      } else {
         var1.onAnimationEnd((Animator)null);
      }
   }

   private void a(View var1, b var2) {
      int var3 = var2.j();
      int var4 = var2.k();
      int var5 = -1;
      int var6;
      if (var3 == var5) {
         var6 = -1;
      } else {
         var6 = AppLovinSdkUtils.dpToPx(var1.getContext(), var3);
      }

      if (var4 != var5) {
         var5 = AppLovinSdkUtils.dpToPx(var1.getContext(), var4);
      }

      int var7 = this.b.getHeight();
      int var8 = this.b.getWidth();
      if (var7 > 0 && var7 < var5 || var8 > 0 && var8 < var6) {
         int var22 = AppLovinSdkUtils.pxToDp(var1.getContext(), var7);
         int var23 = AppLovinSdkUtils.pxToDp(var1.getContext(), var8);
         StringBuilder var24 = new StringBuilder();
         var24.append("\n**************************************************\n`MaxAdView` size ");
         var24.append(var23);
         var24.append("x");
         var24.append(var22);
         var24.append(" dp smaller than required size: ");
         var24.append(var3);
         var24.append("x");
         var24.append(var4);
         var24.append(" dp\n**************************************************\n");
         com.applovin.impl.sdk.p.i("AppLovinSdk", var24.toString());
      }

      Object var9 = var1.getLayoutParams();
      if (var9 == null) {
         var9 = new LayoutParams(var6, var5);
      } else {
         ((android.view.ViewGroup.LayoutParams)var9).width = var6;
         ((android.view.ViewGroup.LayoutParams)var9).height = var5;
      }

      if (var9 instanceof LayoutParams) {
         p var10 = this.logger;
         String var11 = this.tag;
         StringBuilder var12 = new StringBuilder();
         var12.append("Pinning ad view to MAX ad view with width: ");
         var12.append(var6);
         var12.append(" and height: ");
         var12.append(var5);
         var12.append(".");
         var10.b(var11, var12.toString());
         int[] var18 = r.a(this.b.getGravity(), 10, 14);
         LayoutParams var19 = (LayoutParams)var9;
         int var20 = var18.length;

         for(int var21 = 0; var21 < var20; ++var21) {
            var19.addRule(var18[var21]);
         }
      }

      var1.setLayoutParams((android.view.ViewGroup.LayoutParams)var9);
   }

   // $FF: synthetic method
   static void a(MaxAdViewImpl var0, long var1) {
      var0.a(var1);
   }

   // $FF: synthetic method
   static void a(MaxAdViewImpl var0, AnimatorListenerAdapter var1) {
      var0.a(var1);
   }

   // $FF: synthetic method
   static void a(MaxAdViewImpl var0, b var1, long var2) {
      var0.a(var1, var2);
   }

   // $FF: synthetic method
   static void a(MaxAdViewImpl var0, b var1, MaxAdView var2) {
      var0.a(var1, var2);
   }

   // $FF: synthetic method
   static void a(MaxAdViewImpl var0, MaxAdListener var1) {
      var0.a(var1);
   }

   private void a(b var1) {
      AppLovinSdkUtils.runOnUiThread(new MaxAdViewImpl$2(this, var1));
   }

   private void a(b var1, long var2) {
      this.logger.b(this.tag, "Scheduling viewability impression for ad...");
      this.sdk.y().maybeScheduleViewabilityAdImpressionPostback(var1, var2);
   }

   private void a(b var1, MaxAdView var2) {
      View var3 = var1.l();
      var3.setAlpha(0.0F);
      if (var1.u() != Long.MAX_VALUE) {
         this.c.setBackgroundColor((int)var1.u());
      } else {
         long var4 = this.d;
         if (var4 != Long.MAX_VALUE) {
            this.c.setBackgroundColor((int)var4);
         } else {
            this.c.setBackgroundColor(0);
         }
      }

      var2.addView(var3);
      this.a(var3, var1);
      long var6 = (Long)this.sdk.a(com.applovin.impl.sdk.b.c.y);
      var3.animate().alpha(1.0F).setDuration(var6).start();
   }

   private void a(MaxAd var1) {
      if (this.o) {
         this.o = false;
         p var2 = this.logger;
         String var3 = this.tag;
         StringBuilder var4 = new StringBuilder();
         var4.append("Rendering precache request ad: ");
         var4.append(var1.getAdUnitId());
         var4.append("...");
         var2.b(var3, var4.toString());
         this.g.onAdLoaded(var1);
      } else {
         this.e = (b)var1;
      }
   }

   private void a(MaxAdListener var1) {
      if (this.d()) {
         com.applovin.impl.sdk.p.j(this.tag, "Unable to load new ad; ad is already destroyed");
         com.applovin.impl.sdk.utils.j.a((MaxAdListener)this.adListener, (String)this.adUnitId, -1);
      } else {
         AppLovinSdkUtils.runOnUiThread(new MaxAdViewImpl$1(this, var1));
      }
   }

   // $FF: synthetic method
   static v b(MaxAdViewImpl var0) {
      return var0.j;
   }

   private void b() {
      if (this.c()) {
         long var1 = (Long)this.sdk.a(com.applovin.impl.sdk.b.c.D);
         p var3 = this.logger;
         String var4 = this.tag;
         StringBuilder var5 = new StringBuilder();
         var5.append("Scheduling refresh precache request in ");
         var5.append(TimeUnit.MICROSECONDS.toSeconds(var1));
         var5.append(" seconds...");
         var3.b(var4, var5.toString());
         ac var9 = new ac(this.sdk, new MaxAdViewImpl$3(this));
         com.applovin.impl.sdk.d.r.a var10 = com.applovin.impl.mediation.d.c.a(this.adFormat);
         this.sdk.K().a(var9, var10, var1);
      }
   }

   // $FF: synthetic method
   static Activity c(MaxAdViewImpl var0) {
      return var0.a;
   }

   private boolean c() {
      return (Long)this.sdk.a(com.applovin.impl.sdk.b.c.D) > 0L;
   }

   // $FF: synthetic method
   static MaxAdView d(MaxAdViewImpl var0) {
      return var0.b;
   }

   private boolean d() {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static void e(MaxAdViewImpl var0) {
      var0.a();
   }

   // $FF: synthetic method
   static w f(MaxAdViewImpl var0) {
      return var0.k;
   }

   // $FF: synthetic method
   static Object g(MaxAdViewImpl var0) {
      return var0.l;
   }

   // $FF: synthetic method
   static <undefinedtype> h(MaxAdViewImpl var0) {
      return var0.g;
   }

   // $FF: synthetic method
   static <undefinedtype> i(MaxAdViewImpl var0) {
      return var0.h;
   }

   public void destroy() {
      // $FF: Couldn't be decompiled
   }

   public String getPlacement() {
      return this.f;
   }

   public void loadAd() {
      p var1 = this.logger;
      String var2 = this.tag;
      StringBuilder var3 = new StringBuilder();
      var3.append("");
      var3.append(this);
      var3.append(" Loading ad for ");
      var3.append(this.adUnitId);
      var3.append("...");
      var1.b(var2, var3.toString());
      if (this.d()) {
         com.applovin.impl.sdk.p.j(this.tag, "Unable to load new ad; ad is already destroyed");
         com.applovin.impl.sdk.utils.j.a((MaxAdListener)this.adListener, (String)this.adUnitId, -1);
      } else if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.c.E) && this.i.a()) {
         String var9 = this.tag;
         StringBuilder var10 = new StringBuilder();
         var10.append("Unable to load a new ad. An ad refresh has already been scheduled in ");
         var10.append(TimeUnit.MILLISECONDS.toSeconds(this.i.b()));
         var10.append(" seconds.");
         com.applovin.impl.sdk.p.j(var9, var10.toString());
      } else {
         this.a((MaxAdListener)this.g);
      }
   }

   public void onAdRefresh() {
      this.o = false;
      if (this.e != null) {
         p var4 = this.logger;
         String var5 = this.tag;
         StringBuilder var6 = new StringBuilder();
         var6.append("Refreshing for cached ad: ");
         var6.append(this.e.getAdUnitId());
         var6.append("...");
         var4.b(var5, var6.toString());
         this.g.onAdLoaded(this.e);
         this.e = null;
      } else {
         String var3;
         p var1;
         String var2;
         if (this.c()) {
            if (!this.n) {
               this.logger.e(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
               this.o = true;
               return;
            }

            var1 = this.logger;
            var2 = this.tag;
            var3 = "Refreshing ad from network due to viewability requirements not met for refresh request...";
         } else {
            var1 = this.logger;
            var2 = this.tag;
            var3 = "Refreshing ad from network...";
         }

         var1.b(var2, var3);
         this.loadAd();
      }
   }

   public void onLogVisibilityImpression() {
      long var1 = this.j.a(this.m);
      this.a(this.m, var1);
   }

   public void onWindowVisibilityChanged(int var1) {
      if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.c.x)) {
         if (!this.i.a()) {
            return;
         }

         if (r.a(var1)) {
            this.logger.b(this.tag, "Ad view visible");
            this.i.g();
            return;
         }

         this.logger.b(this.tag, "Ad view hidden");
         this.i.f();
      }

   }

   public void setPlacement(String var1) {
      this.f = var1;
   }

   public void setPublisherBackgroundColor(int var1) {
      this.d = (long)var1;
   }

   public void startAutoRefresh() {
      this.i.e();
      p var1 = this.logger;
      String var2 = this.tag;
      StringBuilder var3 = new StringBuilder();
      var3.append("Resumed auto-refresh with remaining time: ");
      var3.append(this.i.b());
      var1.b(var2, var3.toString());
   }

   public void stopAutoRefresh() {
      if (this.m != null) {
         p var1 = this.logger;
         String var2 = this.tag;
         StringBuilder var3 = new StringBuilder();
         var3.append("Pausing auto-refresh with remaining time: ");
         var3.append(this.i.b());
         var1.b(var2, var3.toString());
         this.i.d();
      } else {
         com.applovin.impl.sdk.p.i(this.tag, "Stopping auto-refresh has no effect until after the first ad has been loaded.");
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MaxAdView{adUnitId='");
      var1.append(this.adUnitId);
      var1.append('\'');
      var1.append(", adListener=");
      var1.append(this.adListener);
      var1.append(", isDestroyed=");
      var1.append(this.d());
      var1.append('}');
      return var1.toString();
   }
}
