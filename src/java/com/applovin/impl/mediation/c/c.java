package com.applovin.impl.mediation.c;

import android.app.Activity;
import android.graphics.Point;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.n;
import com.applovin.impl.sdk.utils.q;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends com.applovin.impl.sdk.d.a {
   private final String a;
   private final MaxAdFormat c;
   private final com.applovin.impl.mediation.f d;
   private final JSONArray e;
   private final Activity f;
   private final MaxAdListener g;

   public c(String var1, MaxAdFormat var2, com.applovin.impl.mediation.f var3, JSONArray var4, Activity var5, j var6, MaxAdListener var7) {
      StringBuilder var8 = new StringBuilder();
      var8.append("TaskFetchMediatedAd ");
      var8.append(var1);
      super(var8.toString(), var6);
      this.a = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
      this.g = var7;
   }

   private void a(int var1) {
      boolean var2;
      if (var1 != 204) {
         var2 = true;
      } else {
         var2 = false;
      }

      p var3 = this.b.v();
      String var4 = this.f();
      Boolean var5 = var2;
      StringBuilder var6 = new StringBuilder();
      var6.append("Unable to fetch ");
      var6.append(this.a);
      var6.append(" ad: server returned ");
      var6.append(var1);
      var3.a(var4, var5, var6.toString());
      if (var1 == -800) {
         this.b.L().a(com.applovin.impl.sdk.c.g.n);
      }

      this.b(var1);
   }

   // $FF: synthetic method
   static void a(c var0, int var1) {
      var0.a(var1);
   }

   // $FF: synthetic method
   static void a(c var0, JSONObject var1) {
      var0.a(var1);
   }

   private void a(com.applovin.impl.sdk.c.h var1) {
      long var2 = var1.b(com.applovin.impl.sdk.c.g.c);
      long var4 = System.currentTimeMillis();
      if (var4 - var2 > TimeUnit.MINUTES.toMillis((long)(Integer)this.b.a(com.applovin.impl.sdk.b.d.dM))) {
         var1.b(com.applovin.impl.sdk.c.g.c, var4);
         var1.c(com.applovin.impl.sdk.c.g.d);
      }

   }

   private void a(JSONObject var1) {
      try {
         com.applovin.impl.sdk.utils.h.d(var1, this.b);
         com.applovin.impl.sdk.utils.h.c(var1, this.b);
         com.applovin.impl.sdk.utils.h.f(var1, this.b);
         com.applovin.impl.mediation.d.b.a(var1, this.b);
         com.applovin.impl.mediation.d.b.b(var1, this.b);
         f var3 = this.b(var1);
         this.b.K().a((com.applovin.impl.sdk.d.a)var3);
      } catch (Throwable var5) {
         this.a("Unable to process mediated ad response", var5);
         this.b(-800);
         return;
      }
   }

   private f b(JSONObject var1) {
      f var2 = new f(this.a, this.c, var1, this.f, this.b, this.g);
      return var2;
   }

   private String b() {
      return com.applovin.impl.mediation.d.b.a(this.b);
   }

   private void b(int var1) {
      com.applovin.impl.sdk.utils.j.a(this.g, this.a, var1);
   }

   private String c() {
      return com.applovin.impl.mediation.d.b.b(this.b);
   }

   private void c(JSONObject var1) {
      try {
         JSONObject var2 = new JSONObject();
         var2.put("loaded", new JSONArray(this.b.w().a()));
         var2.put("failed", new JSONArray(this.b.w().b()));
         var1.put("classname_info", var2);
         var1.put("initialized_adapters", this.b.x().c());
         var1.put("initialized_adapter_classnames", new JSONArray(this.b.x().b()));
         var1.put("installed_mediation_adapters", com.applovin.impl.mediation.d.c.a(this.b).a());
      } catch (Exception var4) {
         this.a("Failed to populate adapter classnames", var4);
      }
   }

   private JSONObject d() throws JSONException {
      JSONObject var1 = new JSONObject();
      this.e(var1);
      this.f(var1);
      this.d(var1);
      this.c(var1);
      var1.put("sc", n.e((String)this.b.a(com.applovin.impl.sdk.b.d.aa)));
      var1.put("sc2", n.e((String)this.b.a(com.applovin.impl.sdk.b.d.ab)));
      var1.put("server_installed_at", n.e((String)this.b.a(com.applovin.impl.sdk.b.d.ac)));
      String var5 = (String)this.b.a(com.applovin.impl.sdk.b.f.z);
      if (n.b(var5)) {
         var1.put("persisted_data", n.e(var5));
      }

      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.ex)) {
         this.h(var1);
      }

      var1.put("mediation_provider", this.b.n());
      return var1;
   }

   private void d(JSONObject var1) throws JSONException {
      JSONArray var2 = this.e;
      if (var2 != null) {
         var1.put("signal_data", var2);
      }

   }

   private void e(JSONObject var1) throws JSONException {
      JSONObject var2 = new JSONObject();
      var2.put("ad_unit_id", this.a);
      var2.put("ad_format", com.applovin.impl.mediation.d.c.b(this.c));
      if (this.d != null && (Boolean)this.b.a(com.applovin.impl.sdk.b.c.h)) {
         var2.put("extra_parameters", i.a(i.a(this.d.a())));
      }

      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.ad)) {
         var2.put("n", String.valueOf(this.b.ab().a(this.a)));
      }

      var1.put("ad_info", var2);
   }

   private void f(JSONObject var1) throws JSONException {
      k var2 = this.b.O();
      k.d var3 = var2.b();
      JSONObject var4 = new JSONObject();
      var4.put("brand", var3.d);
      var4.put("brand_name", var3.e);
      var4.put("hardware", var3.f);
      var4.put("api_level", var3.h);
      var4.put("carrier", var3.j);
      var4.put("country_code", var3.i);
      var4.put("locale", var3.k);
      var4.put("model", var3.a);
      var4.put("os", var3.b);
      var4.put("platform", var3.c);
      var4.put("revision", var3.g);
      var4.put("orientation_lock", var3.l);
      var4.put("tz_offset", var3.r);
      var4.put("aida", n.a(var3.N));
      var4.put("wvvc", var3.s);
      var4.put("adns", (double)var3.m);
      var4.put("adnsd", var3.n);
      var4.put("xdpi", (double)var3.o);
      var4.put("ydpi", (double)var3.p);
      var4.put("screen_size_in", var3.q);
      var4.put("sim", n.a(var3.A));
      var4.put("gy", n.a(var3.B));
      var4.put("is_tablet", n.a(var3.C));
      var4.put("tv", n.a(var3.D));
      var4.put("vs", n.a(var3.E));
      var4.put("lpm", var3.F);
      var4.put("fs", var3.H);
      var4.put("tds", var3.I);
      var4.put("fm", var3.J.b);
      var4.put("tm", var3.J.a);
      var4.put("lmt", var3.J.c);
      var4.put("lm", var3.J.d);
      var4.put("adr", n.a(var3.t));
      var4.put("volume", var3.x);
      var4.put("sb", var3.y);
      var4.put("network", com.applovin.impl.sdk.utils.h.f(this.b));
      var4.put("af", var3.v);
      var4.put("font", (double)var3.w);
      if (n.b(var3.z)) {
         var4.put("ua", var3.z);
      }

      if (n.b(var3.G)) {
         var4.put("so", var3.G);
      }

      var4.put("bt_ms", String.valueOf(var3.Q));
      k.c var44 = var3.u;
      if (var44 != null) {
         var4.put("act", var44.a);
         var4.put("acm", var44.b);
      }

      Boolean var45 = var3.K;
      if (var45 != null) {
         var4.put("huc", var45.toString());
      }

      Boolean var46 = var3.L;
      if (var46 != null) {
         var4.put("aru", var46.toString());
      }

      Boolean var47 = var3.M;
      if (var47 != null) {
         var4.put("dns", var47.toString());
      }

      Point var48 = com.applovin.impl.sdk.utils.g.a(this.g());
      var4.put("dx", Integer.toString(var48.x));
      var4.put("dy", Integer.toString(var48.y));
      if (var3.O > 0.0F) {
         var4.put("da", (double)var3.O);
      }

      if (var3.P > 0.0F) {
         var4.put("dm", (double)var3.P);
      }

      this.g(var4);
      var1.put("device_info", var4);
      k.b var52 = var2.c();
      JSONObject var53 = new JSONObject();
      var53.put("package_name", var52.c);
      var53.put("installer_name", var52.d);
      var53.put("app_name", var52.a);
      var53.put("app_version", var52.b);
      var53.put("installed_at", var52.h);
      var53.put("tg", var52.e);
      var53.put("ltg", var52.f);
      var53.put("api_did", this.b.a(com.applovin.impl.sdk.b.d.X));
      var53.put("sdk_version", AppLovinSdk.VERSION);
      var53.put("build", 131);
      var53.put("first_install", String.valueOf(this.b.H()));
      var53.put("first_install_v2", String.valueOf(true ^ this.b.I()));
      var53.put("debug", Boolean.toString(q.b(this.b)));
      String var67 = this.b.i();
      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.dT) && n.b(var67)) {
         var53.put("cuid", var67);
      }

      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.dW)) {
         var53.put("compass_random_token", this.b.j());
      }

      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.dY)) {
         var53.put("applovin_random_token", this.b.k());
      }

      String var68 = (String)this.b.a(com.applovin.impl.sdk.b.d.ea);
      if (n.b(var68)) {
         var53.put("plugin_version", var68);
      }

      var1.put("app_info", var53);
      com.applovin.impl.sdk.network.a.b var70 = this.b.J().a();
      if (var70 != null) {
         JSONObject var71 = new JSONObject();
         var71.put("lrm_ts_ms", String.valueOf(var70.a()));
         var71.put("lrm_url", var70.b());
         var71.put("lrm_ct_ms", String.valueOf(var70.d()));
         var71.put("lrm_rs", String.valueOf(var70.c()));
         var1.put("connection_info", var71);
      }

   }

   private void g(JSONObject var1) {
      try {
         k.a var3 = this.b.O().d();
         String var4 = var3.b;
         if (n.b(var4)) {
            var1.put("idfa", var4);
         }

         var1.put("dnt", var3.a);
      } catch (Throwable var6) {
         this.a("Failed to populate advertising info", var6);
         return;
      }
   }

   private void h(JSONObject var1) {
      try {
         com.applovin.impl.sdk.c.h var3 = this.b.L();
         var1.put("li", String.valueOf(var3.b(com.applovin.impl.sdk.c.g.b)));
         var1.put("si", String.valueOf(var3.b(com.applovin.impl.sdk.c.g.d)));
         var1.put("pf", String.valueOf(var3.b(com.applovin.impl.sdk.c.g.h)));
         var1.put("mpf", String.valueOf(var3.b(com.applovin.impl.sdk.c.g.n)));
         var1.put("gpf", String.valueOf(var3.b(com.applovin.impl.sdk.c.g.i)));
      } catch (Throwable var5) {
         this.a("Failed to populate ad serving info", var5);
         return;
      }
   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.C;
   }

   public void run() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Fetching next ad for ad unit id: ");
      var1.append(this.a);
      var1.append(" and format: ");
      var1.append(this.c);
      this.a((String)var1.toString());
      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.eh) && q.d()) {
         this.a((String)"User is connected to a VPN");
      }

      com.applovin.impl.sdk.c.h var6 = this.b.L();
      var6.a(com.applovin.impl.sdk.c.g.m);
      if (var6.b(com.applovin.impl.sdk.c.g.c) == 0L) {
         var6.b(com.applovin.impl.sdk.c.g.c, System.currentTimeMillis());
      }

      try {
         JSONObject var13 = this.d();
         HashMap var14 = new HashMap();
         var14.put("rid", UUID.randomUUID().toString());
         if (var13.has("huc")) {
            var14.put("huc", String.valueOf(i.a(var13, "huc", false, this.b)));
         }

         if (var13.has("aru")) {
            var14.put("aru", String.valueOf(i.a(var13, "aru", false, this.b)));
         }

         if (var13.has("dns")) {
            var14.put("dns", String.valueOf(i.a(var13, "dns", false, this.b)));
         }

         if (!(Boolean)this.b.a(com.applovin.impl.sdk.b.d.eR)) {
            var14.put("sdk_key", this.b.t());
         }

         this.a(var6);
         c$1 var16 = new c$1(this, com.applovin.impl.sdk.network.b.a(this.b).b("POST").a(this.b()).c(this.c()).a((Map)var14).a(var13).a((Object)(new JSONObject())).b(((Long)this.b.a(com.applovin.impl.sdk.b.c.f)).intValue()).a((Integer)this.b.a(com.applovin.impl.sdk.b.d.dB)).c(((Long)this.b.a(com.applovin.impl.sdk.b.c.e)).intValue()).b(true).a(), this.b);
         var16.a(com.applovin.impl.sdk.b.c.c);
         var16.b(com.applovin.impl.sdk.b.c.d);
         this.b.K().a((com.applovin.impl.sdk.d.a)var16);
      } catch (Throwable var18) {
         StringBuilder var10 = new StringBuilder();
         var10.append("Unable to fetch ad ");
         var10.append(this.a);
         this.a(var10.toString(), var18);
         this.a(0);
         this.b.M().a(this.a());
         return;
      }
   }
}
