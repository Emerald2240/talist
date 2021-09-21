package com.applovin.impl.mediation.b;

import android.view.View;
import com.applovin.impl.mediation.i;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.utils.q;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdkUtils;
import org.json.JSONObject;

public class b extends a {
   private static final int c;
   private static final int d;

   static {
      c = AppLovinAdSize.BANNER.getHeight();
      d = AppLovinAdSize.LEADER.getHeight();
   }

   private b(b var1, i var2) {
      super(var1.B(), var1.A(), var2, var1.b);
   }

   public b(JSONObject var1, JSONObject var2, j var3) {
      super(var1, var2, (i)null, var3);
   }

   public a a(i var1) {
      return new b(this, var1);
   }

   public int j() {
      int var1 = this.b("ad_view_width", (Integer)this.b.a(com.applovin.impl.sdk.b.c.p));
      if (var1 == -2) {
         if (AppLovinSdkUtils.isTablet(this.b.D())) {
            return 728;
         }

         var1 = 320;
      }

      return var1;
   }

   public int k() {
      int var1 = this.b("ad_view_height", (Integer)this.b.a(com.applovin.impl.sdk.b.c.q));
      if (var1 == -2) {
         if (AppLovinSdkUtils.isTablet(this.b.D())) {
            return d;
         }

         var1 = c;
      }

      return var1;
   }

   public View l() {
      if (this.a() && this.a != null) {
         View var1 = this.a.a();
         if (var1 != null) {
            return var1;
         } else {
            throw new IllegalStateException("Ad-view based ad is missing an ad view");
         }
      } else {
         return null;
      }
   }

   public long m() {
      return this.b("viewability_imp_delay_ms", (Long)this.b.a(com.applovin.impl.sdk.b.d.cd));
   }

   public int n() {
      com.applovin.impl.sdk.b.d var1;
      if (this.getFormat() == MaxAdFormat.BANNER) {
         var1 = com.applovin.impl.sdk.b.d.ce;
      } else if (this.getFormat() == MaxAdFormat.MREC) {
         var1 = com.applovin.impl.sdk.b.d.cg;
      } else {
         var1 = com.applovin.impl.sdk.b.d.ci;
      }

      return this.b("viewability_min_width", (Integer)this.b.a(var1));
   }

   public int o() {
      com.applovin.impl.sdk.b.d var1;
      if (this.getFormat() == MaxAdFormat.BANNER) {
         var1 = com.applovin.impl.sdk.b.d.cf;
      } else if (this.getFormat() == MaxAdFormat.MREC) {
         var1 = com.applovin.impl.sdk.b.d.ch;
      } else {
         var1 = com.applovin.impl.sdk.b.d.cj;
      }

      return this.b("viewability_min_height", (Integer)this.b.a(var1));
   }

   public float p() {
      return this.a("viewability_min_alpha", (Float)this.b.a(com.applovin.impl.sdk.b.c.ck) / 100.0F);
   }

   public int q() {
      return this.b("viewability_min_pixels", -1);
   }

   public boolean r() {
      return this.q() >= 0;
   }

   public long s() {
      return this.b("viewability_timer_min_visible_ms", (Long)this.b.a(com.applovin.impl.sdk.b.c.cl));
   }

   public boolean t() {
      return this.b("proe", (Boolean)this.b.a(com.applovin.impl.sdk.b.c.N));
   }

   public long u() {
      return q.f(this.b("bg_color", (String)null));
   }
}
