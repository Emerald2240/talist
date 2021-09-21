package com.applovin.impl.a;

import android.net.Uri;
import com.applovin.impl.sdk.utils.n;
import com.applovin.impl.sdk.utils.s;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class b {
   private int a;
   private int b;
   private Uri c;
   private e d;
   private Set e = new HashSet();
   private Map f = new HashMap();

   private b() {
   }

   public static b a(s var0, b var1, c var2, com.applovin.impl.sdk.j var3) {
      if (var0 != null) {
         if (var3 == null) {
            throw new IllegalArgumentException("No sdk specified.");
         } else {
            Throwable var10000;
            label463: {
               boolean var10001;
               if (var1 == null) {
                  try {
                     var1 = new b();
                  } catch (Throwable var50) {
                     var10000 = var50;
                     var10001 = false;
                     break label463;
                  }
               }

               label452: {
                  int var8;
                  int var7;
                  try {
                     if (var1.a != 0 || var1.b != 0) {
                        break label452;
                     }

                     var7 = n.a((String)var0.b().get("width"));
                     var8 = n.a((String)var0.b().get("height"));
                  } catch (Throwable var49) {
                     var10000 = var49;
                     var10001 = false;
                     break label463;
                  }

                  if (var7 > 0 && var8 > 0) {
                     try {
                        var1.a = var7;
                        var1.b = var8;
                     } catch (Throwable var48) {
                        var10000 = var48;
                        var10001 = false;
                        break label463;
                     }
                  }
               }

               label440: {
                  s var5;
                  try {
                     var1.d = com.applovin.impl.a.e.a(var0, var1.d, var3);
                     if (var1.c != null) {
                        break label440;
                     }

                     var5 = var0.b("CompanionClickThrough");
                  } catch (Throwable var47) {
                     var10000 = var47;
                     var10001 = false;
                     break label463;
                  }

                  if (var5 != null) {
                     try {
                        String var6 = var5.c();
                        if (n.b(var6)) {
                           var1.c = Uri.parse(var6);
                        }
                     } catch (Throwable var46) {
                        var10000 = var46;
                        var10001 = false;
                        break label463;
                     }
                  }
               }

               label432:
               try {
                  i.a(var0.a("CompanionClickTracking"), var1.e, var2, var3);
                  i.a(var0, var1.f, var2, var3);
                  return var1;
               } catch (Throwable var45) {
                  var10000 = var45;
                  var10001 = false;
                  break label432;
               }
            }

            Throwable var4 = var10000;
            var3.v().b("VastCompanionAd", "Error occurred while initializing", var4);
            return null;
         }
      } else {
         throw new IllegalArgumentException("No node specified.");
      }
   }

   public Uri a() {
      return this.c;
   }

   public e b() {
      return this.d;
   }

   public Set c() {
      return this.e;
   }

   public Map d() {
      return this.f;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof b)) {
         return false;
      } else {
         b var2 = (b)var1;
         if (this.a != var2.a) {
            return false;
         } else if (this.b != var2.b) {
            return false;
         } else {
            Uri var3 = this.c;
            if (var3 != null) {
               if (!var3.equals(var2.c)) {
                  return false;
               }
            } else if (var2.c != null) {
               return false;
            }

            e var4 = this.d;
            if (var4 != null) {
               if (!var4.equals(var2.d)) {
                  return false;
               }
            } else if (var2.d != null) {
               return false;
            }

            Set var5 = this.e;
            if (var5 != null) {
               if (!var5.equals(var2.e)) {
                  return false;
               }
            } else if (var2.e != null) {
               return false;
            }

            Map var6 = this.f;
            Map var7 = var2.f;
            if (var6 != null) {
               return var6.equals(var7);
            } else {
               return var7 == null;
            }
         }
      }
   }

   public int hashCode() {
      int var1 = 31 * (31 * this.a + this.b);
      Uri var2 = this.c;
      int var3;
      if (var2 != null) {
         var3 = var2.hashCode();
      } else {
         var3 = 0;
      }

      int var4 = 31 * (var1 + var3);
      e var5 = this.d;
      int var6;
      if (var5 != null) {
         var6 = var5.hashCode();
      } else {
         var6 = 0;
      }

      int var7 = 31 * (var4 + var6);
      Set var8 = this.e;
      int var9;
      if (var8 != null) {
         var9 = var8.hashCode();
      } else {
         var9 = 0;
      }

      int var10 = 31 * (var7 + var9);
      Map var11 = this.f;
      int var12 = 0;
      if (var11 != null) {
         var12 = var11.hashCode();
      }

      return var10 + var12;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("VastCompanionAd{width=");
      var1.append(this.a);
      var1.append(", height=");
      var1.append(this.b);
      var1.append(", destinationUri=");
      var1.append(this.c);
      var1.append(", nonVideoResource=");
      var1.append(this.d);
      var1.append(", clickTrackers=");
      var1.append(this.e);
      var1.append(", eventTrackers=");
      var1.append(this.f);
      var1.append('}');
      return var1.toString();
   }
}
