package com.applovin.impl.a;

import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.n;
import com.applovin.impl.sdk.utils.s;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class g {
   private String a;
   private String b;
   private String c;
   private long d = -1L;
   private int e = -1;

   private g() {
   }

   private static int a(String var0, c var1) {
      if ("start".equalsIgnoreCase(var0)) {
         return 0;
      } else if ("firstQuartile".equalsIgnoreCase(var0)) {
         return 25;
      } else if ("midpoint".equalsIgnoreCase(var0)) {
         return 50;
      } else if ("thirdQuartile".equalsIgnoreCase(var0)) {
         return 75;
      } else if ("complete".equalsIgnoreCase(var0)) {
         return var1 != null ? var1.i() : 95;
      } else {
         return -1;
      }
   }

   public static g a(s var0, c var1, com.applovin.impl.sdk.j var2) {
      if (var0 != null) {
         if (var2 == null) {
            throw new IllegalArgumentException("No sdk specified.");
         } else {
            Throwable var10000;
            label1068: {
               boolean var10001;
               label1083: {
                  g var6;
                  String var8;
                  try {
                     String var5 = var0.c();
                     if (!n.b(var5)) {
                        break label1083;
                     }

                     var6 = new g();
                     var6.c = var5;
                     var6.a = (String)var0.b().get("id");
                     var6.b = (String)var0.b().get("event");
                     var6.e = a(var6.a(), var1);
                     String var7 = (String)var0.b().get("offset");
                     if (!n.b(var7)) {
                        return var6;
                     }

                     var8 = var7.trim();
                     if (var8.contains("%")) {
                        var6.e = n.a(var8.substring(0, -1 + var8.length()));
                        return var6;
                     }
                  } catch (Throwable var113) {
                     var10000 = var113;
                     var10001 = false;
                     break label1068;
                  }

                  int var14;
                  List var13;
                  label1058: {
                     try {
                        if (var8.contains(":")) {
                           var13 = com.applovin.impl.sdk.utils.e.a(var8, ":");
                           var14 = var13.size();
                           break label1058;
                        }
                     } catch (Throwable var111) {
                        var10000 = var111;
                        var10001 = false;
                        break label1068;
                     }

                     try {
                        p var9 = var2.v();
                        StringBuilder var10 = new StringBuilder();
                        var10.append("Unable to parse time offset from rawOffsetString = ");
                        var10.append(var8);
                        var9.e("VastTracker", var10.toString());
                        return var6;
                     } catch (Throwable var106) {
                        var10000 = var106;
                        var10001 = false;
                        break label1068;
                     }
                  }

                  if (var14 <= 0) {
                     return var6;
                  }

                  long var15 = 0L;
                  int var17 = var14 - 1;

                  for(int var18 = var17; var18 >= 0; --var18) {
                     int var20;
                     try {
                        String var19 = (String)var13.get(var18);
                        if (!n.d(var19)) {
                           continue;
                        }

                        var20 = Integer.parseInt(var19);
                     } catch (Throwable var110) {
                        var10000 = var110;
                        var10001 = false;
                        break label1068;
                     }

                     long var22;
                     if (var18 == var17) {
                        var22 = (long)var20;
                     } else {
                        TimeUnit var21;
                        if (var18 == var14 - 2) {
                           try {
                              var21 = TimeUnit.MINUTES;
                           } catch (Throwable var109) {
                              var10000 = var109;
                              var10001 = false;
                              break label1068;
                           }
                        } else {
                           if (var18 != var14 - 3) {
                              continue;
                           }

                           try {
                              var21 = TimeUnit.HOURS;
                           } catch (Throwable var108) {
                              var10000 = var108;
                              var10001 = false;
                              break label1068;
                           }
                        }

                        try {
                           var22 = var21.toSeconds((long)var20);
                        } catch (Throwable var107) {
                           var10000 = var107;
                           var10001 = false;
                           break label1068;
                        }
                     }

                     var15 += var22;
                  }

                  try {
                     var6.d = var15;
                     var6.e = -1;
                     return var6;
                  } catch (Throwable var105) {
                     var10000 = var105;
                     var10001 = false;
                     break label1068;
                  }
               }

               label1061:
               try {
                  var2.v().e("VastTracker", "Unable to create tracker. Could not find URL.");
                  return null;
               } catch (Throwable var112) {
                  var10000 = var112;
                  var10001 = false;
                  break label1061;
               }
            }

            Throwable var4 = var10000;
            var2.v().b("VastTracker", "Error occurred while initializing", var4);
            return null;
         }
      } else {
         IllegalArgumentException var3 = new IllegalArgumentException("No node specified.");
         throw var3;
      }
   }

   public String a() {
      return this.b;
   }

   public boolean a(long var1, int var3) {
      long var4 = this.d;
      boolean var6 = true;
      boolean var7;
      if (var4 >= 0L) {
         var7 = true;
      } else {
         var7 = false;
      }

      boolean var8;
      if (var1 >= this.d) {
         var8 = true;
      } else {
         var8 = false;
      }

      boolean var9;
      if (this.e >= 0) {
         var9 = true;
      } else {
         var9 = false;
      }

      boolean var10;
      if (var3 >= this.e) {
         var10 = true;
      } else {
         var10 = false;
      }

      if (!var7 || !var8) {
         if (var9 && var10) {
            return var6;
         }

         var6 = false;
      }

      return var6;
   }

   public String b() {
      return this.c;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof g)) {
         return false;
      } else {
         g var2 = (g)var1;
         if (this.d != var2.d) {
            return false;
         } else if (this.e != var2.e) {
            return false;
         } else {
            String var3 = this.a;
            if (var3 != null) {
               if (!var3.equals(var2.a)) {
                  return false;
               }
            } else if (var2.a != null) {
               return false;
            }

            String var4 = this.b;
            if (var4 != null) {
               if (!var4.equals(var2.b)) {
                  return false;
               }
            } else if (var2.b != null) {
               return false;
            }

            return this.c.equals(var2.c);
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

      int var6 = 31 * (31 * (var3 + var5) + this.c.hashCode());
      long var7 = this.d;
      return 31 * (var6 + (int)(var7 ^ var7 >>> 32)) + this.e;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("VastTracker{identifier='");
      var1.append(this.a);
      var1.append('\'');
      var1.append(", event='");
      var1.append(this.b);
      var1.append('\'');
      var1.append(", uriString='");
      var1.append(this.c);
      var1.append('\'');
      var1.append(", offsetSeconds=");
      var1.append(this.d);
      var1.append(", offsetPercent=");
      var1.append(this.e);
      var1.append('}');
      return var1.toString();
   }
}
