package com.applovin.impl.sdk.d;

import org.json.JSONObject;

class p$1 extends x {
   // $FF: synthetic field
   final p a;

   p$1(p var1, com.applovin.impl.sdk.network.b var2, com.applovin.impl.sdk.j var3) {
      super(var2, var3);
      this.a = var1;
   }

   public void a(int var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Unable to fetch variables: server returned ");
      var2.append(var1);
      this.d(var2.toString());
      com.applovin.impl.sdk.p.j("AppLovinVariableService", "Failed to load variables.");
      p.a(this.a).a();
   }

   public void a(JSONObject var1, int var2) {
      com.applovin.impl.sdk.utils.h.d(var1, this.b);
      com.applovin.impl.sdk.utils.h.c(var1, this.b);
      com.applovin.impl.sdk.utils.h.f(var1, this.b);
      p.a(this.a).a();
   }
}
