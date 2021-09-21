package com.applovin.impl.sdk.d;

import org.json.JSONObject;

public class y extends z {
   private final com.applovin.impl.sdk.ad.f a;

   public y(com.applovin.impl.sdk.ad.f var1, com.applovin.impl.sdk.j var2) {
      super("TaskReportAppLovinReward", var2);
      this.a = var1;
   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.x;
   }

   protected void a(int var1) {
      super.a(var1);
      StringBuilder var2 = new StringBuilder();
      var2.append("Failed to report reward for ad: ");
      var2.append(this.a);
      var2.append(" - error code: ");
      var2.append(var1);
      this.d(var2.toString());
   }

   protected void a(JSONObject var1) {
      com.applovin.impl.sdk.utils.i.a(var1, "zone_id", this.a.getAdZone().a(), this.b);
      com.applovin.impl.sdk.utils.i.a(var1, "fire_percent", this.a.ai(), this.b);
      String var2 = this.a.getClCode();
      if (!com.applovin.impl.sdk.utils.n.b(var2)) {
         var2 = "NO_CLCODE";
      }

      com.applovin.impl.sdk.utils.i.a(var1, "clcode", var2, this.b);
   }

   protected String b() {
      return "2.0/cr";
   }

   protected void b(JSONObject var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Reported reward successfully for ad: ");
      var2.append(this.a);
      this.a(var2.toString());
   }

   protected com.applovin.impl.sdk.a.c c() {
      return this.a.aJ();
   }

   protected void d() {
      StringBuilder var1 = new StringBuilder();
      var1.append("No reward result was found for ad: ");
      var1.append(this.a);
      this.d(var1.toString());
   }
}
