package com.applovin.impl.sdk.d;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Map;
import org.json.JSONObject;

public class n extends m {
   private final int a;
   private final AppLovinNativeAdLoadListener c;

   public n(String var1, int var2, com.applovin.impl.sdk.j var3, AppLovinNativeAdLoadListener var4) {
      super(com.applovin.impl.sdk.ad.d.b(var1, var3), (AppLovinAdLoadListener)null, "TaskFetchNextNativeAd", var3);
      this.a = var2;
      this.c = var4;
   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.o;
   }

   protected a a(JSONObject var1) {
      return new v(var1, this.b, this.c);
   }

   protected void a(int var1) {
      AppLovinNativeAdLoadListener var2 = this.c;
      if (var2 != null) {
         var2.onNativeAdsFailedToLoad(var1);
      }

   }

   Map b() {
      Map var1 = super.b();
      var1.put("slot_count", Integer.toString(this.a));
      return var1;
   }

   protected String d() {
      StringBuilder var1 = new StringBuilder();
      var1.append((String)this.b.a(com.applovin.impl.sdk.b.d.aL));
      var1.append("4.0/nad");
      return var1.toString();
   }

   protected String i() {
      StringBuilder var1 = new StringBuilder();
      var1.append((String)this.b.a(com.applovin.impl.sdk.b.d.aM));
      var1.append("4.0/nad");
      return var1.toString();
   }
}
