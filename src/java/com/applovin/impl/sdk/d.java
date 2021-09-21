package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.lang.ref.WeakReference;

public class d extends BroadcastReceiver implements o.a {
   private com.applovin.impl.sdk.utils.o a;
   private final Object b = new Object();
   private final j c;
   private final WeakReference d;
   private long e;

   public d(j var1, d.a var2) {
      this.d = new WeakReference(var2);
      this.c = var1;
   }

   // $FF: synthetic method
   static void a(d var0) {
      var0.j();
   }

   // $FF: synthetic method
   static WeakReference b(d var0) {
      return var0.d;
   }

   private void j() {
      Object var1 = this.b;
      synchronized(var1){}

      Throwable var10000;
      boolean var10001;
      label122: {
         try {
            this.a = null;
            if (!(Boolean)this.c.a(com.applovin.impl.sdk.b.c.x)) {
               this.c.af().unregisterReceiver(this);
               this.c.Z().b((o.a)this);
            }
         } catch (Throwable var15) {
            var10000 = var15;
            var10001 = false;
            break label122;
         }

         label119:
         try {
            return;
         } catch (Throwable var14) {
            var10000 = var14;
            var10001 = false;
            break label119;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var13) {
            var10000 = var13;
            var10001 = false;
            continue;
         }
      }
   }

   public void a(long var1) {
      Object var3 = this.b;
      synchronized(var3){}

      boolean var10001;
      Throwable var10000;
      label294: {
         try {
            this.c();
            this.e = var1;
            this.a = com.applovin.impl.sdk.utils.o.a(var1, this.c, new d$1(this));
            if (!(Boolean)this.c.a(com.applovin.impl.sdk.b.c.x)) {
               this.c.af().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
               this.c.af().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
               this.c.Z().a((o.a)this);
            }
         } catch (Throwable var35) {
            var10000 = var35;
            var10001 = false;
            break label294;
         }

         label286: {
            try {
               if (!(Boolean)this.c.a(com.applovin.impl.sdk.b.c.w) || !this.c.Z().b() && !this.c.Y().a()) {
                  break label286;
               }
            } catch (Throwable var34) {
               var10000 = var34;
               var10001 = false;
               break label294;
            }

            try {
               this.a.b();
            } catch (Throwable var33) {
               var10000 = var33;
               var10001 = false;
               break label294;
            }
         }

         label275:
         try {
            return;
         } catch (Throwable var32) {
            var10000 = var32;
            var10001 = false;
            break label275;
         }
      }

      while(true) {
         Throwable var4 = var10000;

         try {
            throw var4;
         } catch (Throwable var31) {
            var10000 = var31;
            var10001 = false;
            continue;
         }
      }
   }

   public boolean a() {
      Object var1 = this.b;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label134: {
         boolean var3;
         label133: {
            label132: {
               try {
                  if (this.a == null) {
                     break label132;
                  }
               } catch (Throwable var16) {
                  var10000 = var16;
                  var10001 = false;
                  break label134;
               }

               var3 = true;
               break label133;
            }

            var3 = false;
         }

         label126:
         try {
            return var3;
         } catch (Throwable var15) {
            var10000 = var15;
            var10001 = false;
            break label126;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var14) {
            var10000 = var14;
            var10001 = false;
            continue;
         }
      }
   }

   public long b() {
      Object var1 = this.b;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label150: {
         long var3;
         label144: {
            try {
               if (this.a != null) {
                  var3 = this.a.a();
                  break label144;
               }
            } catch (Throwable var17) {
               var10000 = var17;
               var10001 = false;
               break label150;
            }

            var3 = -1L;
         }

         label136:
         try {
            return var3;
         } catch (Throwable var16) {
            var10000 = var16;
            var10001 = false;
            break label136;
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

   public void c() {
      Object var1 = this.b;
      synchronized(var1){}

      Throwable var10000;
      boolean var10001;
      label122: {
         try {
            if (this.a != null) {
               this.a.d();
               this.j();
            }
         } catch (Throwable var15) {
            var10000 = var15;
            var10001 = false;
            break label122;
         }

         label119:
         try {
            return;
         } catch (Throwable var14) {
            var10000 = var14;
            var10001 = false;
            break label119;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var13) {
            var10000 = var13;
            var10001 = false;
            continue;
         }
      }
   }

   public void d() {
      Object var1 = this.b;
      synchronized(var1){}

      Throwable var10000;
      boolean var10001;
      label122: {
         try {
            if (this.a != null) {
               this.a.b();
            }
         } catch (Throwable var15) {
            var10000 = var15;
            var10001 = false;
            break label122;
         }

         label119:
         try {
            return;
         } catch (Throwable var14) {
            var10000 = var14;
            var10001 = false;
            break label119;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var13) {
            var10000 = var13;
            var10001 = false;
            continue;
         }
      }
   }

   public void e() {
      Object var1 = this.b;
      synchronized(var1){}

      Throwable var10000;
      boolean var10001;
      label122: {
         try {
            if (this.a != null) {
               this.a.c();
            }
         } catch (Throwable var15) {
            var10000 = var15;
            var10001 = false;
            break label122;
         }

         label119:
         try {
            return;
         } catch (Throwable var14) {
            var10000 = var14;
            var10001 = false;
            break label119;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var13) {
            var10000 = var13;
            var10001 = false;
            continue;
         }
      }
   }

   public void f() {
      if ((Boolean)this.c.a(com.applovin.impl.sdk.b.c.v)) {
         this.d();
      }

   }

   public void g() {
      boolean var10001;
      Throwable var10000;
      label561: {
         if ((Boolean)this.c.a(com.applovin.impl.sdk.b.c.v)) {
            Object var1 = this.b;
            synchronized(var1){}

            try {
               if (this.c.Z().b()) {
                  this.c.v().b("AdRefreshManager", "Waiting for the full screen ad to be dismissed to resume the timer.");
                  return;
               }
            } catch (Throwable var66) {
               var10000 = var66;
               var10001 = false;
               break label561;
            }

            com.applovin.impl.sdk.utils.o var3;
            try {
               var3 = this.a;
            } catch (Throwable var65) {
               var10000 = var65;
               var10001 = false;
               break label561;
            }

            boolean var4 = false;
            if (var3 != null) {
               long var5;
               long var7;
               try {
                  var5 = this.e - this.b();
                  var7 = (Long)this.c.a(com.applovin.impl.sdk.b.c.u);
               } catch (Throwable var64) {
                  var10000 = var64;
                  var10001 = false;
                  break label561;
               }

               if (var7 >= 0L && var5 > var7) {
                  try {
                     this.c();
                  } catch (Throwable var63) {
                     var10000 = var63;
                     var10001 = false;
                     break label561;
                  }

                  var4 = true;
               } else {
                  try {
                     this.a.c();
                  } catch (Throwable var62) {
                     var10000 = var62;
                     var10001 = false;
                     break label561;
                  }
               }
            }

            try {
               ;
            } catch (Throwable var61) {
               var10000 = var61;
               var10001 = false;
               break label561;
            }

            if (var4) {
               d.a var9 = (d.a)this.d.get();
               if (var9 != null) {
                  var9.onAdRefresh();
                  return;
               }
            }
         }

         return;
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var60) {
            var10000 = var60;
            var10001 = false;
            continue;
         }
      }
   }

   public void h() {
      if ((Boolean)this.c.a(com.applovin.impl.sdk.b.c.w)) {
         this.d();
      }

   }

   public void i() {
      if ((Boolean)this.c.a(com.applovin.impl.sdk.b.c.w)) {
         Object var1 = this.b;
         synchronized(var1){}

         boolean var10001;
         Throwable var10000;
         label217: {
            try {
               if (this.c.Y().a()) {
                  this.c.v().b("AdRefreshManager", "Waiting for the application to enter foreground to resume the timer.");
                  return;
               }
            } catch (Throwable var23) {
               var10000 = var23;
               var10001 = false;
               break label217;
            }

            try {
               if (this.a != null) {
                  this.a.c();
               }
            } catch (Throwable var22) {
               var10000 = var22;
               var10001 = false;
               break label217;
            }

            label205:
            try {
               return;
            } catch (Throwable var21) {
               var10000 = var21;
               var10001 = false;
               break label205;
            }
         }

         while(true) {
            Throwable var2 = var10000;

            try {
               throw var2;
            } catch (Throwable var20) {
               var10000 = var20;
               var10001 = false;
               continue;
            }
         }
      }
   }

   public void onReceive(Context var1, Intent var2) {
      String var3 = var2.getAction();
      if ("com.applovin.application_paused".equals(var3)) {
         this.f();
      } else {
         if ("com.applovin.application_resumed".equals(var3)) {
            this.g();
         }

      }
   }

   public interface a {
      void onAdRefresh();
   }
}
