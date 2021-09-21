package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class l {
   private final String a = UUID.randomUUID().toString();
   private final String b;
   private final Map c;
   private final long d;

   public l(String var1, Map var2, Map var3) {
      this.b = var1;
      this.c = new HashMap();
      this.c.putAll(var2);
      this.c.put("applovin_sdk_super_properties", var3);
      this.d = System.currentTimeMillis();
   }

   public String a() {
      return this.b;
   }

   public Map b() {
      return this.c;
   }

   public long c() {
      return this.d;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this == var1) {
         return var2;
      } else if (var1 != null) {
         if (this.getClass() != var1.getClass()) {
            return false;
         } else {
            l var3 = (l)var1;
            if (this.d != var3.d) {
               return false;
            } else {
               String var4 = this.b;
               if (var4 != null) {
                  if (!var4.equals(var3.b)) {
                     return false;
                  }
               } else if (var3.b != null) {
                  return false;
               }

               Map var5 = this.c;
               if (var5 != null) {
                  if (!var5.equals(var3.c)) {
                     return false;
                  }
               } else if (var3.c != null) {
                  return false;
               }

               String var6 = this.a;
               String var7 = var3.a;
               if (var6 != null) {
                  if (var6.equals(var7)) {
                     return var2;
                  }
               } else if (var7 == null) {
                  return var2;
               }

               var2 = false;
               return var2;
            }
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      String var1 = this.b;
      int var2;
      if (var1 != null) {
         var2 = var1.hashCode();
      } else {
         var2 = 0;
      }

      int var3 = var2 * 31;
      Map var4 = this.c;
      int var5;
      if (var4 != null) {
         var5 = var4.hashCode();
      } else {
         var5 = 0;
      }

      int var6 = 31 * (var3 + var5);
      long var7 = this.d;
      int var9 = 31 * (var6 + (int)(var7 ^ var7 >>> 32));
      String var10 = this.a;
      int var11 = 0;
      if (var10 != null) {
         var11 = var10.hashCode();
      }

      return var9 + var11;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Event{name='");
      var1.append(this.b);
      var1.append('\'');
      var1.append(", id='");
      var1.append(this.a);
      var1.append('\'');
      var1.append(", creationTimestampMillis=");
      var1.append(this.d);
      var1.append(", parameters=");
      var1.append(this.c);
      var1.append('}');
      return var1.toString();
   }
}
