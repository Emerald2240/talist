package com.applovin.impl.sdk.d;

import android.app.Activity;
import com.applovin.impl.sdk.EventServiceImpl;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdk;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;

public class q extends a {
   private final com.applovin.impl.sdk.j a;

   public q(com.applovin.impl.sdk.j var1) {
      super("TaskInitializeSdk", var1);
      this.a = var1;
   }

   // $FF: synthetic method
   static com.applovin.impl.sdk.j a(q var0) {
      return var0.a;
   }

   private void a(com.applovin.impl.sdk.b.d var1) {
      if ((Boolean)this.a.a(var1)) {
         com.applovin.impl.sdk.ad.d var2 = com.applovin.impl.sdk.ad.d.a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, this.a);
         this.a.T().f(var2);
      }

   }

   private void b() {
      if (!this.a.x().a()) {
         Activity var1 = this.a.ag();
         if (var1 != null) {
            this.a.x().a(var1);
         } else {
            this.a.K().a(new ac(this.a, true, new q$1(this)), r.a.a, TimeUnit.SECONDS.toMillis(1L));
         }
      }
   }

   private void c() {
      this.a.K().a((a)(new b(this.a)), r.a.a);
   }

   private void d() {
      this.a.T().a();
      this.a.U().a();
   }

   private void i() {
      this.j();
      this.k();
      this.l();
   }

   private void j() {
      LinkedHashSet var1 = this.a.W().a();
      if (!var1.isEmpty()) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Scheduling preload(s) for ");
         var2.append(var1.size());
         var2.append(" zone(s)");
         this.a((String)var2.toString());
         Iterator var6 = var1.iterator();

         while(var6.hasNext()) {
            com.applovin.impl.sdk.ad.d var7 = (com.applovin.impl.sdk.ad.d)var6.next();
            if (var7.d()) {
               this.a.p().preloadAds(var7);
            } else {
               this.a.o().preloadAds(var7);
            }
         }
      }

   }

   private void k() {
      com.applovin.impl.sdk.b.d var1 = com.applovin.impl.sdk.b.d.be;
      String var2 = (String)this.a.a(com.applovin.impl.sdk.b.d.bd);
      int var3 = var2.length();
      boolean var4 = false;
      if (var3 > 0) {
         Iterator var5 = com.applovin.impl.sdk.utils.e.a(var2).iterator();

         while(var5.hasNext()) {
            AppLovinAdSize var6 = AppLovinAdSize.fromString((String)var5.next());
            if (var6 != null) {
               com.applovin.impl.sdk.ad.d var7 = com.applovin.impl.sdk.ad.d.a(var6, AppLovinAdType.REGULAR, this.a);
               this.a.T().f(var7);
               if (AppLovinAdSize.INTERSTITIAL.getLabel().equals(var6.getLabel())) {
                  this.a(var1);
                  var4 = true;
               }
            }
         }
      }

      if (!var4) {
         this.a(var1);
      }

   }

   private void l() {
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.bf)) {
         this.a.U().f(com.applovin.impl.sdk.ad.d.h(this.a));
      }

   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.a;
   }

   public void run() {
      String var1 = "succeeded";
      long var2 = System.currentTimeMillis();
      StringBuilder var4 = new StringBuilder();
      var4.append("Initializing AppLovin SDK ");
      var4.append(AppLovinSdk.VERSION);
      var4.append("...");
      this.a((String)var4.toString());

      StringBuilder var20;
      label150: {
         label154: {
            try {
               this.a.L().d();
               this.a.L().c(com.applovin.impl.sdk.c.g.b);
               this.a.V().a(this.g());
               this.a.V().b(this.g());
               this.d();
               this.i();
               this.b();
               this.a.X().a();
               this.c();
               this.a.O().e();
               this.a.ad().a();
               this.a.a(true);
               this.a.N().a();
               ((EventServiceImpl)this.a.q()).maybeTrackAppOpenEvent();
               this.a.B().a();
               if (this.a.z().a()) {
                  this.a.z().b();
               }
            } catch (Throwable var41) {
               Throwable var8 = var41;
               boolean var37 = false;

               try {
                  var37 = true;
                  this.a("Unable to initialize SDK.", var8);
                  this.a.a(false);
                  this.a.M().a(this.a());
                  var37 = false;
               } finally {
                  if (var37) {
                     if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.au)) {
                        long var18 = (Long)this.a.a(com.applovin.impl.sdk.b.d.av);
                        this.a.a(var18);
                     }

                     StringBuilder var10 = new StringBuilder();
                     var10.append("AppLovin SDK ");
                     var10.append(AppLovinSdk.VERSION);
                     var10.append(" initialization ");
                     if (!this.a.d()) {
                        var1 = "failed";
                     }

                     var10.append(var1);
                     var10.append(" in ");
                     var10.append(System.currentTimeMillis() - var2);
                     var10.append("ms");
                     this.a((String)var10.toString());
                  }
               }

               if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.au)) {
                  long var28 = (Long)this.a.a(com.applovin.impl.sdk.b.d.av);
                  this.a.a(var28);
               }

               var20 = new StringBuilder();
               var20.append("AppLovin SDK ");
               var20.append(AppLovinSdk.VERSION);
               var20.append(" initialization ");
               if (this.a.d()) {
                  break label150;
               }
               break label154;
            }

            if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.au)) {
               long var33 = (Long)this.a.a(com.applovin.impl.sdk.b.d.av);
               this.a.a(var33);
            }

            var20 = new StringBuilder();
            var20.append("AppLovin SDK ");
            var20.append(AppLovinSdk.VERSION);
            var20.append(" initialization ");
            if (this.a.d()) {
               break label150;
            }
         }

         var1 = "failed";
      }

      var20.append(var1);
      var20.append(" in ");
      var20.append(System.currentTimeMillis() - var2);
      var20.append("ms");
      this.a((String)var20.toString());
   }
}
