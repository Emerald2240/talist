package com.applovin.impl.sdk.d;

import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

class u extends a {
   private final JSONObject a;
   private final JSONObject c;
   private final AppLovinAdLoadListener d;
   private final com.applovin.impl.sdk.ad.b e;

   u(JSONObject var1, JSONObject var2, com.applovin.impl.sdk.ad.b var3, AppLovinAdLoadListener var4, com.applovin.impl.sdk.j var5) {
      super("TaskRenderAppLovinAd", var5);
      this.a = var1;
      this.c = var2;
      this.e = var3;
      this.d = var4;
   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.u;
   }

   public void run() {
      this.a("Rendering ad...");
      com.applovin.impl.sdk.ad.a var1 = new com.applovin.impl.sdk.ad.a(this.a, this.c, this.e, this.b);
      boolean var2 = com.applovin.impl.sdk.utils.i.a(this.a, "gs_load_immediately", false, this.b);
      boolean var3 = com.applovin.impl.sdk.utils.i.a(this.a, "vs_load_immediately", true, this.b);
      d var4 = new d(var1, this.b, this.d);
      var4.a(var3);
      var4.b(var2);
      r.a var5 = r.a.h;
      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.bm)) {
         if (var1.getSize() == AppLovinAdSize.INTERSTITIAL && var1.getType() == AppLovinAdType.REGULAR) {
            var5 = r.a.f;
         } else if (var1.getSize() == AppLovinAdSize.INTERSTITIAL && var1.getType() == AppLovinAdType.INCENTIVIZED) {
            var5 = r.a.g;
         }
      }

      this.b.K().a((a)var4, var5);
   }
}
