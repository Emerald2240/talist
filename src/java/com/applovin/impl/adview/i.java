package com.applovin.impl.adview;

import android.os.Handler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class i {
   private final com.applovin.impl.sdk.p a;
   private final Handler b;
   private final Set c = new HashSet();
   private final AtomicInteger d = new AtomicInteger();

   public i(Handler var1, com.applovin.impl.sdk.j var2) {
      if (var1 != null) {
         if (var2 != null) {
            this.b = var1;
            this.a = var2.v();
         } else {
            throw new IllegalArgumentException("No sdk specified.");
         }
      } else {
         throw new IllegalArgumentException("No handler specified.");
      }
   }

   private void a(final i.b var1, final int var2) {
      this.b.postDelayed(new Runnable() {
         public void run() {
            i.a var1x = var1.c();
            if (!var1x.b()) {
               com.applovin.impl.sdk.p var2x = i.this.a;
               StringBuilder var3 = new StringBuilder();
               var3.append("Ending countdown for ");
               var3.append(var1.a());
               var2x.b("CountdownManager", var3.toString());
            } else if (i.this.d.get() == var2) {
               label34:
               try {
                  var1x.a();
               } catch (Throwable var14) {
                  com.applovin.impl.sdk.p var11 = i.this.a;
                  StringBuilder var12 = new StringBuilder();
                  var12.append("Encountered error on countdown step for: ");
                  var12.append(var1.a());
                  var11.b("CountdownManager", var12.toString(), var14);
                  break label34;
               }

               i.this.a(var1, var2);
            } else {
               com.applovin.impl.sdk.p var6 = i.this.a;
               StringBuilder var7 = new StringBuilder();
               var7.append("Killing duplicate countdown from previous generation: ");
               var7.append(var1.a());
               var6.d("CountdownManager", var7.toString());
            }
         }
      }, var1.b());
   }

   public void a() {
      HashSet var1 = new HashSet(this.c);
      com.applovin.impl.sdk.p var2 = this.a;
      StringBuilder var3 = new StringBuilder();
      var3.append("Starting ");
      var3.append(var1.size());
      var3.append(" countdowns...");
      var2.b("CountdownManager", var3.toString());
      int var7 = this.d.incrementAndGet();
      Iterator var8 = var1.iterator();

      while(var8.hasNext()) {
         i.b var9 = (i.b)var8.next();
         com.applovin.impl.sdk.p var10 = this.a;
         StringBuilder var11 = new StringBuilder();
         var11.append("Starting countdown: ");
         var11.append(var9.a());
         var11.append(" for generation ");
         var11.append(var7);
         var11.append("...");
         var10.b("CountdownManager", var11.toString());
         this.a(var9, var7);
      }

   }

   public void a(String var1, long var2, i.a var4) {
      if (var2 > 0L) {
         if (this.b != null) {
            com.applovin.impl.sdk.p var5 = this.a;
            StringBuilder var6 = new StringBuilder();
            var6.append("Adding countdown: ");
            var6.append(var1);
            var5.b("CountdownManager", var6.toString());
            i.b var9 = new i.b(var1, var2, var4);
            this.c.add(var9);
         } else {
            throw new IllegalArgumentException("No handler specified.");
         }
      } else {
         throw new IllegalArgumentException("Invalid step specified.");
      }
   }

   public void b() {
      this.a.b("CountdownManager", "Removing all countdowns...");
      this.c();
      this.c.clear();
   }

   public void c() {
      this.a.b("CountdownManager", "Stopping countdowns...");
      this.d.incrementAndGet();
      this.b.removeCallbacksAndMessages((Object)null);
   }

   interface a {
      void a();

      boolean b();
   }

   private static class b {
      private final String a;
      private final i.a b;
      private final long c;

      private b(String var1, long var2, i.a var4) {
         this.a = var1;
         this.c = var2;
         this.b = var4;
      }

      // $FF: synthetic method
      b(String var1, long var2, i.a var4, Object var5) {
         this(var1, var2, var4);
      }

      private String a() {
         return this.a;
      }

      private long b() {
         return this.c;
      }

      private i.a c() {
         return this.b;
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof i.b)) {
            return false;
         } else {
            i.b var2 = (i.b)var1;
            String var3 = this.a;
            String var4 = var2.a;
            if (var3 != null) {
               return var3.equalsIgnoreCase(var4);
            } else {
               return var4 == null;
            }
         }
      }

      public int hashCode() {
         String var1 = this.a;
         return var1 != null ? var1.hashCode() : 0;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("CountdownProxy{identifier='");
         var1.append(this.a);
         var1.append('\'');
         var1.append(", countdownStepMillis=");
         var1.append(this.c);
         var1.append('}');
         return var1.toString();
      }
   }
}
