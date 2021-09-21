package com.applovin.impl.mediation.c;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.d.z;
import com.applovin.impl.sdk.utils.n;
import org.json.JSONObject;

public class g extends z {
   private final com.applovin.impl.mediation.b.c a;

   public g(com.applovin.impl.mediation.b.c var1, j var2) {
      super("TaskReportMaxReward", var2);
      this.a = var1;
   }

   public i a() {
      return i.L;
   }

   protected void a(int var1) {
      super.a(var1);
      StringBuilder var2 = new StringBuilder();
      var2.append("Failed to report reward for mediated ad: ");
      var2.append(this.a);
      var2.append(" - error code: ");
      var2.append(var1);
      this.a(var2.toString());
   }

   protected void a(JSONObject var1) {
      com.applovin.impl.sdk.utils.i.a(var1, "ad_unit_id", this.a.getAdUnitId(), this.b);
      com.applovin.impl.sdk.utils.i.a(var1, "placement", this.a.N(), this.b);
      String var2 = this.a.s();
      if (!n.b(var2)) {
         var2 = "NO_MCODE";
      }

      com.applovin.impl.sdk.utils.i.a(var1, "mcode", var2, this.b);
      String var3 = this.a.r();
      if (!n.b(var3)) {
         var3 = "NO_BCODE";
      }

      com.applovin.impl.sdk.utils.i.a(var1, "bcode", var3, this.b);
   }

   protected String b() {
      return "2.0/mcr";
   }

   protected void b(JSONObject var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Reported reward successfully for mediated ad: ");
      var2.append(this.a);
      this.a(var2.toString());
   }

   protected com.applovin.impl.sdk.a.c c() {
      return this.a.v();
   }

   protected void d() {
      StringBuilder var1 = new StringBuilder();
      var1.append("No reward result was found for mediated ad: ");
      var1.append(this.a);
      this.d(var1.toString());
   }
}
