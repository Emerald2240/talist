package com.applovin.impl.mediation.c;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.d.ae;
import com.applovin.impl.sdk.utils.n;
import org.json.JSONObject;

public class h extends ae {
   private final com.applovin.impl.mediation.b.c a;

   public h(com.applovin.impl.mediation.b.c var1, j var2) {
      super("TaskValidateMaxReward", var2);
      this.a = var1;
   }

   public i a() {
      return i.K;
   }

   protected void a(int var1) {
      super.a(var1);
      String var2;
      if (var1 >= 400 && var1 < 500) {
         var2 = "rejected";
      } else {
         var2 = "network_timeout";
      }

      this.a.a(com.applovin.impl.sdk.a.c.a(var2));
   }

   protected void a(com.applovin.impl.sdk.a.c var1) {
      this.a.a(var1);
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
      return "2.0/mvr";
   }

   protected boolean c() {
      return this.a.t();
   }
}
