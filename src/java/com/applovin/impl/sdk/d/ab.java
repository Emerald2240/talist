package com.applovin.impl.sdk.d;

import org.json.JSONObject;

public abstract class ab extends a {
   protected ab(String var1, com.applovin.impl.sdk.j var2) {
      super(var1, var2);
   }

   protected void a(int var1) {
      com.applovin.impl.sdk.utils.h.a(var1, this.b);
   }

   protected abstract void a(JSONObject var1);

   void a(JSONObject var1, com.applovin.impl.sdk.network.a.c var2) {
      ab$1 var3 = new ab$1(this, com.applovin.impl.sdk.network.b.a(this.b).a(com.applovin.impl.sdk.utils.h.a(this.b(), this.b)).c(com.applovin.impl.sdk.utils.h.b(this.b(), this.b)).a(com.applovin.impl.sdk.utils.h.e(this.b)).b("POST").a(var1).a((Object)(new JSONObject())).a((Integer)this.b.a(com.applovin.impl.sdk.b.d.bP)).a(), this.b, var2);
      var3.a(com.applovin.impl.sdk.b.d.aN);
      var3.b(com.applovin.impl.sdk.b.d.aO);
      this.b.K().a((a)var3);
   }

   protected abstract String b();

   protected JSONObject i() {
      JSONObject var1 = new JSONObject();
      String var2 = this.b.i();
      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.dU) && com.applovin.impl.sdk.utils.n.b(var2)) {
         com.applovin.impl.sdk.utils.i.a(var1, "cuid", var2, this.b);
      }

      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.dW)) {
         com.applovin.impl.sdk.utils.i.a(var1, "compass_random_token", this.b.j(), this.b);
      }

      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.dY)) {
         com.applovin.impl.sdk.utils.i.a(var1, "applovin_random_token", this.b.k(), this.b);
      }

      this.a(var1);
      return var1;
   }
}
