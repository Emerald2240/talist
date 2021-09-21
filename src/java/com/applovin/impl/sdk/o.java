package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class o {
   private final j a;
   private final AtomicBoolean b = new AtomicBoolean();
   private final List c = Collections.synchronizedList(new ArrayList());
   private long d;
   private final Object e = new Object();
   private final AtomicBoolean f = new AtomicBoolean();
   private long g;

   o(j var1) {
      this.a = var1;
   }

   public void a(o.a var1) {
      this.c.add(var1);
   }

   public void a(boolean var1) {
      Object var2 = this.e;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label323: {
         try {
            this.f.set(var1);
         } catch (Throwable var56) {
            var10000 = var56;
            var10001 = false;
            break label323;
         }

         if (var1) {
            final long var8;
            try {
               this.g = System.currentTimeMillis();
               p var4 = this.a.v();
               StringBuilder var5 = new StringBuilder();
               var5.append("Setting fullscreen ad pending display: ");
               var5.append(this.g);
               var4.b("FullScreenAdTracker", var5.toString());
               var8 = (Long)this.a.a(com.applovin.impl.sdk.b.d.cz);
            } catch (Throwable var55) {
               var10000 = var55;
               var10001 = false;
               break label323;
            }

            if (var8 >= 0L) {
               try {
                  AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                     public void run() {
                        if (o.this.a()) {
                           if (System.currentTimeMillis() - o.this.g >= var8) {
                              o.this.a.v().b("FullScreenAdTracker", "Resetting \"pending display\" state...");
                              o.this.f.set(false);
                           }

                        }
                     }
                  }, var8);
               } catch (Throwable var54) {
                  var10000 = var54;
                  var10001 = false;
                  break label323;
               }
            }
         } else {
            try {
               this.g = 0L;
               p var10 = this.a.v();
               StringBuilder var11 = new StringBuilder();
               var11.append("Setting fullscreen ad not pending display: ");
               var11.append(System.currentTimeMillis());
               var10.b("FullScreenAdTracker", var11.toString());
            } catch (Throwable var53) {
               var10000 = var53;
               var10001 = false;
               break label323;
            }
         }

         label307:
         try {
            return;
         } catch (Throwable var52) {
            var10000 = var52;
            var10001 = false;
            break label307;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var51) {
            var10000 = var51;
            var10001 = false;
            continue;
         }
      }
   }

   public boolean a() {
      return this.f.get();
   }

   public void b(o.a var1) {
      this.c.remove(var1);
   }

   public boolean b() {
      return this.b.get();
   }

   public void c() {
      if (this.b.compareAndSet(false, true)) {
         this.d = System.currentTimeMillis();
         p var1 = this.a.v();
         StringBuilder var2 = new StringBuilder();
         var2.append("Setting fullscreen ad displayed: ");
         var2.append(this.d);
         var1.b("FullScreenAdTracker", var2.toString());
         Iterator var5 = (new ArrayList(this.c)).iterator();

         while(var5.hasNext()) {
            ((o.a)var5.next()).h();
         }

         final long var6 = (Long)this.a.a(com.applovin.impl.sdk.b.d.cA);
         if (var6 >= 0L) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
               public void run() {
                  if (o.this.b.get()) {
                     if (System.currentTimeMillis() - o.this.d >= var6) {
                        o.this.a.v().b("FullScreenAdTracker", "Resetting \"display\" state...");
                        o.this.d();
                     }

                  }
               }
            }, var6);
         }
      }

   }

   public void d() {
      if (this.b.compareAndSet(true, false)) {
         p var1 = this.a.v();
         StringBuilder var2 = new StringBuilder();
         var2.append("Setting fullscreen ad hidden: ");
         var2.append(System.currentTimeMillis());
         var1.b("FullScreenAdTracker", var2.toString());
         Iterator var5 = (new ArrayList(this.c)).iterator();

         while(var5.hasNext()) {
            ((o.a)var5.next()).i();
         }
      }

   }

   interface a {
      void h();

      void i();
   }
}
