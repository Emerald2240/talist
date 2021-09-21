package com.applovin.impl.sdk.d;

import java.util.Map;
import org.json.JSONObject;

public abstract class z extends ab {
   protected z(String var1, com.applovin.impl.sdk.j var2) {
      super(var1, var2);
   }

   private JSONObject a(com.applovin.impl.sdk.a.c var1) {
      JSONObject var2 = this.i();
      com.applovin.impl.sdk.utils.i.a(var2, "result", var1.b(), this.b);
      Map var3 = var1.a();
      if (var3 != null) {
         com.applovin.impl.sdk.utils.i.a(var2, "params", new JSONObject(var3), this.b);
      }

      return var2;
   }

   protected abstract void b(JSONObject var1);

   protected abstract com.applovin.impl.sdk.a.c c();

   protected abstract void d();

   public void run() {
      com.applovin.impl.sdk.a.c var1 = this.c();
      if (var1 != null) {
         this.a(this.a(var1), new z$1(this));
      } else {
         this.d();
      }
   }
}
