package com.applovin.impl.sdk.d;

import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class m extends a {
   private final com.applovin.impl.sdk.ad.d a;
   private final AppLovinAdLoadListener c;
   private boolean d;

   public m(com.applovin.impl.sdk.ad.d var1, AppLovinAdLoadListener var2, com.applovin.impl.sdk.j var3) {
      this(var1, var2, "TaskFetchNextAd", var3);
   }

   m(com.applovin.impl.sdk.ad.d var1, AppLovinAdLoadListener var2, String var3, com.applovin.impl.sdk.j var4) {
      super(var3, var4);
      this.d = false;
      this.a = var1;
      this.c = var2;
   }

   private void a(com.applovin.impl.sdk.c.h var1) {
      long var2 = var1.b(com.applovin.impl.sdk.c.g.c);
      long var4 = System.currentTimeMillis();
      if (var4 - var2 > TimeUnit.MINUTES.toMillis((long)(Integer)this.b.a(com.applovin.impl.sdk.b.d.dM))) {
         var1.b(com.applovin.impl.sdk.c.g.c, var4);
         var1.c(com.applovin.impl.sdk.c.g.d);
      }

   }

   // $FF: synthetic method
   static void a(m var0, int var1) {
      var0.b(var1);
   }

   // $FF: synthetic method
   static void a(m var0, JSONObject var1) {
      var0.b(var1);
   }

   private void b(int var1) {
      boolean var2;
      if (var1 != 204) {
         var2 = true;
      } else {
         var2 = false;
      }

      com.applovin.impl.sdk.p var3 = this.e().v();
      String var4 = this.f();
      Boolean var5 = var2;
      StringBuilder var6 = new StringBuilder();
      var6.append("Unable to fetch ");
      var6.append(this.a);
      var6.append(" ad: server returned ");
      var6.append(var1);
      var3.a(var4, var5, var6.toString());
      if (var1 == -800) {
         this.b.L().a(com.applovin.impl.sdk.c.g.h);
      }

      try {
         this.a(var1);
      } catch (Throwable var13) {
         com.applovin.impl.sdk.p.c(this.f(), "Unable process a failure to recieve an ad", var13);
         return;
      }
   }

   private void b(JSONObject var1) {
      com.applovin.impl.sdk.utils.h.d(var1, this.b);
      com.applovin.impl.sdk.utils.h.c(var1, this.b);
      com.applovin.impl.sdk.utils.h.e(var1, this.b);
      a var2 = this.a(var1);
      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.eV)) {
         this.b.K().a(var2);
      } else {
         this.b.K().a(var2, r.a.a);
      }
   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.n;
   }

   protected a a(JSONObject var1) {
      s var2 = new s(var1, this.a, this.c(), this.c, this.b);
      return var2;
   }

   protected void a(int var1) {
      AppLovinAdLoadListener var2 = this.c;
      if (var2 != null) {
         if (var2 instanceof com.applovin.impl.sdk.m) {
            ((com.applovin.impl.sdk.m)var2).a(this.a, var1);
            return;
         }

         var2.failedToReceiveAd(var1);
      }

   }

   public void a(boolean var1) {
      this.d = var1;
   }

   Map b() {
      HashMap var1 = new HashMap(4);
      var1.put("zone_id", com.applovin.impl.sdk.utils.n.e(this.a.a()));
      if (this.a.b() != null) {
         var1.put("size", this.a.b().getLabel());
      }

      if (this.a.c() != null) {
         var1.put("require", this.a.c().getLabel());
      }

      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.ad)) {
         var1.put("n", String.valueOf(this.b.ab().a(this.a.a())));
      }

      return var1;
   }

   protected com.applovin.impl.sdk.ad.b c() {
      return this.a.i() ? com.applovin.impl.sdk.ad.b.b : com.applovin.impl.sdk.ad.b.c;
   }

   protected String d() {
      return com.applovin.impl.sdk.utils.h.g(this.b);
   }

   protected String i() {
      return com.applovin.impl.sdk.utils.h.h(this.b);
   }

   public void run() {
      StringBuilder var1;
      String var2;
      if (this.d) {
         var1 = new StringBuilder();
         var2 = "Preloading next ad of zone: ";
      } else {
         var1 = new StringBuilder();
         var2 = "Fetching next ad of zone: ";
      }

      var1.append(var2);
      var1.append(this.a);
      this.a((String)var1.toString());
      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.eh) && com.applovin.impl.sdk.utils.q.d()) {
         this.a((String)"User is connected to a VPN");
      }

      com.applovin.impl.sdk.c.h var5 = this.b.L();
      var5.a(com.applovin.impl.sdk.c.g.a);
      if (var5.b(com.applovin.impl.sdk.c.g.c) == 0L) {
         var5.b(com.applovin.impl.sdk.c.g.c, System.currentTimeMillis());
      }

      try {
         Map var12 = this.b.O().a(this.b(), this.d, false);
         this.a(var5);
         m$1 var13 = new m$1(this, com.applovin.impl.sdk.network.b.a(this.b).a(this.d()).a(var12).c(this.i()).b("GET").a((Object)(new JSONObject())).a((Integer)this.b.a(com.applovin.impl.sdk.b.d.dB)).b((Integer)this.b.a(com.applovin.impl.sdk.b.d.dA)).b(true).a(), this.b);
         var13.a(com.applovin.impl.sdk.b.d.aL);
         var13.b(com.applovin.impl.sdk.b.d.aM);
         this.b.K().a((a)var13);
      } catch (Throwable var15) {
         StringBuilder var9 = new StringBuilder();
         var9.append("Unable to fetch ad ");
         var9.append(this.a);
         this.a(var9.toString(), var15);
         this.b(0);
         this.b.M().a(this.a());
         return;
      }
   }
}
