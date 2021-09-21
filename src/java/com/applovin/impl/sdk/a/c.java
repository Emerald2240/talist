package com.applovin.impl.sdk.a;

import java.util.Map;

public class c {
   private final String a;
   private Map b;

   private c(String var1, Map var2) {
      this.a = var1;
      this.b = var2;
   }

   public static c a(String var0) {
      return a(var0, (Map)null);
   }

   public static c a(String var0, Map var1) {
      return new c(var0, var1);
   }

   public Map a() {
      return this.b;
   }

   public String b() {
      return this.a;
   }
}
