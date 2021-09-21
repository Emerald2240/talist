package com.applovin.impl.sdk.d;

import org.json.JSONObject;

class k$1 extends x {
   // $FF: synthetic field
   final k a;

   k$1(k var1, com.applovin.impl.sdk.network.b var2, com.applovin.impl.sdk.j var3, boolean var4) {
      super(var2, var3, var4);
      this.a = var1;
   }

   public void a(int var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Unable to fetch basic SDK settings: server returned ");
      var2.append(var1);
      this.d(var2.toString());
      k.a(this.a, new JSONObject());
   }

   public void a(JSONObject var1, int var2) {
      k.a(this.a, var1);
   }
}
