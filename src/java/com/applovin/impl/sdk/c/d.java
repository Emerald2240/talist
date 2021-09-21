package com.applovin.impl.sdk.c;

import android.app.Activity;
import com.applovin.impl.sdk.AppLovinAdBase;

public class d {
   private final com.applovin.impl.sdk.j a;
   private final h b;
   private final c.b c;
   private final Object d = new Object();
   private final long e;
   private long f;
   private long g;
   private long h;
   private long i;
   private boolean j;

   public d(AppLovinAdBase var1, com.applovin.impl.sdk.j var2) {
      if (var1 != null) {
         if (var2 != null) {
            this.a = var2;
            this.b = var2.L();
            this.c = var2.X().a(var1);
            this.c.a(com.applovin.impl.sdk.c.b.a, (long)var1.getSource().ordinal()).a();
            this.e = var1.getCreatedAtMillis();
         } else {
            throw new IllegalArgumentException("No sdk specified");
         }
      } else {
         throw new IllegalArgumentException("No ad specified");
      }
   }

   public static void a(long var0, AppLovinAdBase var2, com.applovin.impl.sdk.j var3) {
      if (var2 != null && var3 != null) {
         var3.X().a(var2).a(com.applovin.impl.sdk.c.b.b, var0).a();
      }

   }

   public static void a(AppLovinAdBase var0, com.applovin.impl.sdk.j var1) {
      if (var0 != null && var1 != null) {
         var1.X().a(var0).a(com.applovin.impl.sdk.c.b.c, var0.getFetchLatencyMillis()).a(com.applovin.impl.sdk.c.b.d, var0.getFetchResponseSize()).a();
      }

   }

   private void a(b var1) {
      Object var2 = this.d;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label122: {
         try {
            if (this.f > 0L) {
               long var4 = System.currentTimeMillis() - this.f;
               this.c.a(var1, var4).a();
            }
         } catch (Throwable var18) {
            var10000 = var18;
            var10001 = false;
            break label122;
         }

         label119:
         try {
            return;
         } catch (Throwable var17) {
            var10000 = var17;
            var10001 = false;
            break label119;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var16) {
            var10000 = var16;
            var10001 = false;
            continue;
         }
      }
   }

   public static void a(e var0, AppLovinAdBase var1, com.applovin.impl.sdk.j var2) {
      if (var1 != null && var2 != null && var0 != null) {
         c.b var3 = var2.X().a(var1).a(com.applovin.impl.sdk.c.b.e, var0.c()).a(com.applovin.impl.sdk.c.b.f, var0.d()).a(com.applovin.impl.sdk.c.b.v, var0.g()).a(com.applovin.impl.sdk.c.b.w, var0.h());
         b var4 = com.applovin.impl.sdk.c.b.z;
         long var5;
         if (var0.b()) {
            var5 = 1L;
         } else {
            var5 = 0L;
         }

         var3.a(var4, var5).a();
      }

   }

   public void a() {
      long var1 = this.b.a(com.applovin.impl.sdk.c.g.b);
      long var3 = this.b.a(com.applovin.impl.sdk.c.g.d);
      this.c.a(com.applovin.impl.sdk.c.b.j, var1).a(com.applovin.impl.sdk.c.b.i, var3);
      Object var6 = this.d;
      synchronized(var6){}

      label533: {
         boolean var10001;
         Throwable var10000;
         label534: {
            long var8;
            try {
               var8 = this.e;
            } catch (Throwable var76) {
               var10000 = var76;
               var10001 = false;
               break label534;
            }

            long var10 = 0L;
            if (var8 > var10) {
               long var12;
               long var14;
               long var16;
               label522: {
                  label521: {
                     try {
                        this.f = System.currentTimeMillis();
                        var12 = this.f - this.a.G();
                        var14 = this.f - this.e;
                        if (!com.applovin.impl.sdk.utils.h.a(this.a.D())) {
                           break label521;
                        }
                     } catch (Throwable var75) {
                        var10000 = var75;
                        var10001 = false;
                        break label534;
                     }

                     var16 = 1L;
                     break label522;
                  }

                  var16 = var10;
               }

               label536: {
                  Activity var18;
                  try {
                     var18 = this.a.aa().a();
                     if (!com.applovin.impl.sdk.utils.g.f()) {
                        break label536;
                     }
                  } catch (Throwable var74) {
                     var10000 = var74;
                     var10001 = false;
                     break label534;
                  }

                  if (var18 != null) {
                     label537: {
                        try {
                           if (!var18.isInMultiWindowMode()) {
                              break label537;
                           }
                        } catch (Throwable var73) {
                           var10000 = var73;
                           var10001 = false;
                           break label534;
                        }

                        var10 = 1L;
                     }
                  }
               }

               try {
                  this.c.a(com.applovin.impl.sdk.c.b.h, var12).a(com.applovin.impl.sdk.c.b.g, var14).a(com.applovin.impl.sdk.c.b.p, var16).a(com.applovin.impl.sdk.c.b.A, var10);
               } catch (Throwable var72) {
                  var10000 = var72;
                  var10001 = false;
                  break label534;
               }
            }

            label504:
            try {
               break label533;
            } catch (Throwable var71) {
               var10000 = var71;
               var10001 = false;
               break label504;
            }
         }

         while(true) {
            Throwable var7 = var10000;

            try {
               throw var7;
            } catch (Throwable var70) {
               var10000 = var70;
               var10001 = false;
               continue;
            }
         }
      }

      this.c.a();
   }

   public void a(long var1) {
      this.c.a(com.applovin.impl.sdk.c.b.r, var1).a();
   }

   public void b() {
      Object var1 = this.d;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label130: {
         try {
            if (this.g < 1L) {
               this.g = System.currentTimeMillis();
               if (this.f > 0L) {
                  long var3 = this.g - this.f;
                  this.c.a(com.applovin.impl.sdk.c.b.m, var3).a();
               }
            }
         } catch (Throwable var17) {
            var10000 = var17;
            var10001 = false;
            break label130;
         }

         label127:
         try {
            return;
         } catch (Throwable var16) {
            var10000 = var16;
            var10001 = false;
            break label127;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var15) {
            var10000 = var15;
            var10001 = false;
            continue;
         }
      }
   }

   public void b(long var1) {
      this.c.a(com.applovin.impl.sdk.c.b.q, var1).a();
   }

   public void c() {
      this.a(com.applovin.impl.sdk.c.b.k);
   }

   public void c(long var1) {
      this.c.a(com.applovin.impl.sdk.c.b.s, var1).a();
   }

   public void d() {
      this.a(com.applovin.impl.sdk.c.b.n);
   }

   public void d(long var1) {
      Object var3 = this.d;
      synchronized(var3){}

      boolean var10001;
      Throwable var10000;
      label122: {
         try {
            if (this.h < 1L) {
               this.h = var1;
               this.c.a(com.applovin.impl.sdk.c.b.t, var1).a();
            }
         } catch (Throwable var17) {
            var10000 = var17;
            var10001 = false;
            break label122;
         }

         label119:
         try {
            return;
         } catch (Throwable var16) {
            var10000 = var16;
            var10001 = false;
            break label119;
         }
      }

      while(true) {
         Throwable var4 = var10000;

         try {
            throw var4;
         } catch (Throwable var15) {
            var10000 = var15;
            var10001 = false;
            continue;
         }
      }
   }

   public void e() {
      this.a(com.applovin.impl.sdk.c.b.o);
   }

   public void e(long var1) {
      Object var3 = this.d;
      synchronized(var3){}

      boolean var10001;
      Throwable var10000;
      label122: {
         try {
            if (!this.j) {
               this.j = true;
               this.c.a(com.applovin.impl.sdk.c.b.x, var1).a();
            }
         } catch (Throwable var17) {
            var10000 = var17;
            var10001 = false;
            break label122;
         }

         label119:
         try {
            return;
         } catch (Throwable var16) {
            var10000 = var16;
            var10001 = false;
            break label119;
         }
      }

      while(true) {
         Throwable var4 = var10000;

         try {
            throw var4;
         } catch (Throwable var15) {
            var10000 = var15;
            var10001 = false;
            continue;
         }
      }
   }

   public void f() {
      this.a(com.applovin.impl.sdk.c.b.l);
   }

   public void g() {
      this.c.a(com.applovin.impl.sdk.c.b.u, 1L).a();
   }

   public void h() {
      this.c.a(com.applovin.impl.sdk.c.b.B).a();
   }

   public void i() {
      Object var1 = this.d;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label130: {
         try {
            if (this.i < 1L) {
               this.i = System.currentTimeMillis();
               if (this.f > 0L) {
                  long var3 = this.i - this.f;
                  this.c.a(com.applovin.impl.sdk.c.b.y, var3).a();
               }
            }
         } catch (Throwable var17) {
            var10000 = var17;
            var10001 = false;
            break label130;
         }

         label127:
         try {
            return;
         } catch (Throwable var16) {
            var10000 = var16;
            var10001 = false;
            break label127;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var15) {
            var10000 = var15;
            var10001 = false;
            continue;
         }
      }
   }
}
