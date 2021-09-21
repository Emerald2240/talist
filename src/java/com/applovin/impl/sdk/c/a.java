package com.applovin.impl.sdk.c;

public class a {
   private final String a;
   private final String b;

   public a(String var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   public String a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("AdEventPostback{url='");
      var1.append(this.a);
      var1.append('\'');
      var1.append(", backupUrl='");
      var1.append(this.b);
      var1.append('\'');
      var1.append('}');
      return var1.toString();
   }
}
