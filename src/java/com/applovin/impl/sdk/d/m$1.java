package com.applovin.impl.sdk.d;

import org.json.JSONObject;

class m$1 extends x {
   // $FF: synthetic field
   final m a;

   m$1(m var1, com.applovin.impl.sdk.network.b var2, com.applovin.impl.sdk.j var3) {
      super(var2, var3);
      this.a = var1;
   }

   public void a(int var1) {
      m.a(this.a, var1);
   }

   public void a(JSONObject var1, int var2) {
      if (var2 == 200) {
         com.applovin.impl.sdk.utils.i.b(var1, "ad_fetch_latency_millis", this.d.a(), this.b);
         com.applovin.impl.sdk.utils.i.b(var1, "ad_fetch_response_size", this.d.b(), this.b);
         m.a(this.a, var1);
      } else {
         m.a(this.a, var2);
      }
   }
}
