package com.applovin.impl.mediation.c;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.d.x;
import com.applovin.impl.sdk.utils.i;
import org.json.JSONObject;

class c$1 extends x {
   // $FF: synthetic field
   final c a;

   c$1(c var1, com.applovin.impl.sdk.network.b var2, j var3) {
      super(var2, var3);
      this.a = var1;
   }

   public void a(int var1) {
      com.applovin.impl.mediation.c.c.a(this.a, var1);
   }

   public void a(JSONObject var1, int var2) {
      if (var2 == 200) {
         i.b(var1, "ad_fetch_latency_millis", this.d.a(), this.b);
         i.b(var1, "ad_fetch_response_size", this.d.b(), this.b);
         com.applovin.impl.mediation.c.c.a(this.a, var1);
      } else {
         com.applovin.impl.mediation.c.c.a(this.a, var2);
      }
   }
}
