package com.applovin.impl.a;

import com.applovin.impl.sdk.utils.n;
import com.applovin.impl.sdk.utils.s;

public class f {
   private String a;
   private String b;

   private f() {
   }

   public static f a(s var0, f var1, com.applovin.impl.sdk.j var2) {
      if (var0 != null) {
         if (var2 == null) {
            throw new IllegalArgumentException("No sdk specified.");
         } else {
            Throwable var10000;
            label181: {
               boolean var10001;
               if (var1 == null) {
                  try {
                     var1 = new f();
                  } catch (Throwable var17) {
                     var10000 = var17;
                     var10001 = false;
                     break label181;
                  }
               }

               try {
                  if (!n.b(var1.a)) {
                     String var5 = var0.c();
                     if (n.b(var5)) {
                        var1.a = var5;
                     }
                  }
               } catch (Throwable var16) {
                  var10000 = var16;
                  var10001 = false;
                  break label181;
               }

               label168:
               try {
                  if (!n.b(var1.b)) {
                     String var4 = (String)var0.b().get("version");
                     if (n.b(var4)) {
                        var1.b = var4;
                     }
                  }

                  return var1;
               } catch (Throwable var15) {
                  var10000 = var15;
                  var10001 = false;
                  break label168;
               }
            }

            Throwable var3 = var10000;
            var2.v().b("VastSystemInfo", "Error occurred while initializing", var3);
            return null;
         }
      } else {
         throw new IllegalArgumentException("No node specified.");
      }
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof f)) {
         return false;
      } else {
         f var2 = (f)var1;
         String var3 = this.a;
         if (var3 != null) {
            if (!var3.equals(var2.a)) {
               return false;
            }
         } else if (var2.a != null) {
            return false;
         }

         String var4 = this.b;
         String var5 = var2.b;
         if (var4 != null) {
            return var4.equals(var5);
         } else {
            return var5 == null;
         }
      }
   }

   public int hashCode() {
      String var1 = this.a;
      int var2;
      if (var1 != null) {
         var2 = var1.hashCode();
      } else {
         var2 = 0;
      }

      int var3 = var2 * 31;
      String var4 = this.b;
      int var5 = 0;
      if (var4 != null) {
         var5 = var4.hashCode();
      }

      return var3 + var5;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("VastSystemInfo{name='");
      var1.append(this.a);
      var1.append('\'');
      var1.append(", version='");
      var1.append(this.b);
      var1.append('\'');
      var1.append('}');
      return var1.toString();
   }
}
