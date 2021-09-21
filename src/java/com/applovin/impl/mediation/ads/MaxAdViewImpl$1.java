package com.applovin.impl.mediation.ads;

import com.applovin.impl.sdk.p;
import com.applovin.mediation.MaxAdListener;

class MaxAdViewImpl$1 implements Runnable {
   // $FF: synthetic field
   final MaxAdListener a;
   // $FF: synthetic field
   final MaxAdViewImpl b;

   MaxAdViewImpl$1(MaxAdViewImpl var1, MaxAdListener var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      if (MaxAdViewImpl.a(this.b) != null) {
         long var10 = MaxAdViewImpl.b(this.b).a(MaxAdViewImpl.a(this.b));
         this.b.loadRequestBuilder.a("visible_ad_ad_unit_id", MaxAdViewImpl.a(this.b).getAdUnitId()).a("viewability_flags", String.valueOf(var10));
      } else {
         this.b.loadRequestBuilder.a("visible_ad_ad_unit_id").a("viewability_flags");
      }

      p var2 = this.b.logger;
      String var3 = this.b.tag;
      StringBuilder var4 = new StringBuilder();
      var4.append("Loading banner ad for '");
      var4.append(this.b.adUnitId);
      var4.append("' and notifying ");
      var4.append(this.a);
      var4.append("...");
      var2.b(var3, var4.toString());
      this.b.sdk.y().loadAd(this.b.adUnitId, this.b.adFormat, this.b.loadRequestBuilder.a(), false, MaxAdViewImpl.c(this.b), this.a);
   }
}
