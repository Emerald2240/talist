package com.applovin.impl.sdk.d;

import android.text.TextUtils;
import com.applovin.sdk.AppLovinSdk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class p extends a {
   private final p.a a;

   public p(com.applovin.impl.sdk.j var1, p.a var2) {
      super("TaskFetchVariables", var1);
      this.a = var2;
   }

   // $FF: synthetic method
   static p.a a(p var0) {
      return var0.a;
   }

   private void a(Map var1) {
      try {
         com.applovin.impl.sdk.k.a var3 = this.b.O().d();
         String var4 = var3.b;
         if (com.applovin.impl.sdk.utils.n.b(var4)) {
            var1.put("idfa", var4);
         }

         var1.put("dnt", Boolean.toString(var3.a));
      } catch (Throwable var6) {
         this.a("Failed to populate advertising info", var6);
         return;
      }
   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.q;
   }

   protected Map b() {
      com.applovin.impl.sdk.k var1 = this.b.O();
      com.applovin.impl.sdk.k.d var2 = var1.b();
      com.applovin.impl.sdk.k.b var3 = var1.c();
      HashMap var4 = new HashMap();
      var4.put("platform", com.applovin.impl.sdk.utils.n.e(var2.c));
      var4.put("model", com.applovin.impl.sdk.utils.n.e(var2.a));
      var4.put("package_name", com.applovin.impl.sdk.utils.n.e(var3.c));
      var4.put("installer_name", com.applovin.impl.sdk.utils.n.e(var3.d));
      var4.put("ia", Long.toString(var3.h));
      var4.put("api_did", this.b.a(com.applovin.impl.sdk.b.d.X));
      var4.put("brand", com.applovin.impl.sdk.utils.n.e(var2.d));
      var4.put("brand_name", com.applovin.impl.sdk.utils.n.e(var2.e));
      var4.put("hardware", com.applovin.impl.sdk.utils.n.e(var2.f));
      var4.put("revision", com.applovin.impl.sdk.utils.n.e(var2.g));
      var4.put("sdk_version", AppLovinSdk.VERSION);
      var4.put("os", com.applovin.impl.sdk.utils.n.e(var2.b));
      var4.put("orientation_lock", var2.l);
      var4.put("app_version", com.applovin.impl.sdk.utils.n.e(var3.b));
      var4.put("country_code", com.applovin.impl.sdk.utils.n.e(var2.i));
      var4.put("carrier", com.applovin.impl.sdk.utils.n.e(var2.j));
      var4.put("tz_offset", String.valueOf(var2.r));
      var4.put("aida", String.valueOf(var2.N));
      boolean var23 = var2.t;
      String var24 = "1";
      String var25;
      if (var23) {
         var25 = var24;
      } else {
         var25 = "0";
      }

      var4.put("adr", var25);
      var4.put("volume", String.valueOf(var2.x));
      var4.put("sb", String.valueOf(var2.y));
      if (!var2.A) {
         var24 = "0";
      }

      var4.put("sim", var24);
      var4.put("gy", String.valueOf(var2.B));
      var4.put("is_tablet", String.valueOf(var2.C));
      var4.put("tv", String.valueOf(var2.D));
      var4.put("vs", String.valueOf(var2.E));
      var4.put("lpm", String.valueOf(var2.F));
      var4.put("tg", var3.e);
      var4.put("ltg", var3.f);
      var4.put("fs", String.valueOf(var2.H));
      var4.put("tds", String.valueOf(var2.I));
      var4.put("fm", String.valueOf(var2.J.b));
      var4.put("tm", String.valueOf(var2.J.a));
      var4.put("lmt", String.valueOf(var2.J.c));
      var4.put("lm", String.valueOf(var2.J.d));
      var4.put("adns", String.valueOf(var2.m));
      var4.put("adnsd", String.valueOf(var2.n));
      var4.put("xdpi", String.valueOf(var2.o));
      var4.put("ydpi", String.valueOf(var2.p));
      var4.put("screen_size_in", String.valueOf(var2.q));
      var4.put("debug", Boolean.toString(com.applovin.impl.sdk.utils.q.b(this.b)));
      var4.put("af", String.valueOf(var2.v));
      var4.put("font", String.valueOf(var2.w));
      var4.put("bt_ms", String.valueOf(var2.Q));
      if (!(Boolean)this.b.a(com.applovin.impl.sdk.b.d.eR)) {
         var4.put("sdk_key", this.b.t());
      }

      this.a((Map)var4);
      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.dT)) {
         com.applovin.impl.sdk.utils.q.a((String)"cuid", (String)this.b.i(), (Map)var4);
      }

      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.dW)) {
         var4.put("compass_random_token", this.b.j());
      }

      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.dY)) {
         var4.put("applovin_random_token", this.b.k());
      }

      Boolean var52 = var2.K;
      if (var52 != null) {
         var4.put("huc", var52.toString());
      }

      Boolean var53 = var2.L;
      if (var53 != null) {
         var4.put("aru", var53.toString());
      }

      Boolean var54 = var2.M;
      if (var54 != null) {
         var4.put("dns", var54.toString());
      }

      com.applovin.impl.sdk.k.c var55 = var2.u;
      if (var55 != null) {
         var4.put("act", String.valueOf(var55.a));
         var4.put("acm", String.valueOf(var55.b));
      }

      String var56 = var2.z;
      if (com.applovin.impl.sdk.utils.n.b(var56)) {
         var4.put("ua", com.applovin.impl.sdk.utils.n.e(var56));
      }

      String var57 = var2.G;
      if (!TextUtils.isEmpty(var57)) {
         var4.put("so", com.applovin.impl.sdk.utils.n.e(var57));
      }

      if (var2.O > 0.0F) {
         var4.put("da", String.valueOf(var2.O));
      }

      if (var2.P > 0.0F) {
         var4.put("dm", String.valueOf(var2.P));
      }

      var4.put("sc", com.applovin.impl.sdk.utils.n.e((String)this.b.a(com.applovin.impl.sdk.b.d.aa)));
      var4.put("sc2", com.applovin.impl.sdk.utils.n.e((String)this.b.a(com.applovin.impl.sdk.b.d.ab)));
      var4.put("server_installed_at", com.applovin.impl.sdk.utils.n.e((String)this.b.a(com.applovin.impl.sdk.b.d.ac)));
      com.applovin.impl.sdk.utils.q.a((String)"persisted_data", (String)com.applovin.impl.sdk.utils.n.e((String)this.b.a(com.applovin.impl.sdk.b.f.z)), (Map)var4);
      return var4;
   }

   public void run() {
      Map var1 = this.b();
      p$1 var2 = new p$1(this, com.applovin.impl.sdk.network.b.a(this.b).a(com.applovin.impl.sdk.utils.h.i(this.b)).c(com.applovin.impl.sdk.utils.h.j(this.b)).a(var1).b("GET").a((Object)(new JSONObject())).b((Integer)this.b.a(com.applovin.impl.sdk.b.d.dJ)).a(), this.b);
      var2.a(com.applovin.impl.sdk.b.d.aR);
      var2.b(com.applovin.impl.sdk.b.d.aS);
      this.b.K().a((a)var2);
   }

   public interface a {
      void a();
   }
}
