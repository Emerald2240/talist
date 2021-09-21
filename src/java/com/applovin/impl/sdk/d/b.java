package com.applovin.impl.sdk.d;

import android.text.TextUtils;
import com.applovin.sdk.AppLovinSdk;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class b extends a {
   b(com.applovin.impl.sdk.j var1) {
      super("TaskApiSubmitData", var1);
   }

   // $FF: synthetic method
   static void a(b var0, JSONObject var1) {
      var0.a(var1);
   }

   private void a(JSONObject var1) {
      try {
         this.b.P().c();
         JSONObject var3 = com.applovin.impl.sdk.utils.h.a(var1);
         this.b.C().a((com.applovin.impl.sdk.b.d)com.applovin.impl.sdk.b.d.X, (Object)var3.getString("device_id"));
         this.b.C().a((com.applovin.impl.sdk.b.d)com.applovin.impl.sdk.b.d.Y, (Object)var3.getString("device_token"));
         this.b.C().b();
         com.applovin.impl.sdk.utils.h.d(var3, this.b);
         com.applovin.impl.sdk.utils.h.e(var3, this.b);
         String var4 = com.applovin.impl.sdk.utils.i.b(var3, "latest_version", "", this.b);
         if (!TextUtils.isEmpty(var4) && !AppLovinSdk.VERSION.equals(var4)) {
            StringBuilder var5 = new StringBuilder();
            var5.append("Current SDK version (");
            var5.append(AppLovinSdk.VERSION);
            var5.append(") is outdated. Please integrate the latest version of the AppLovin SDK (");
            var5.append(var4);
            var5.append("). Doing so will improve your CPMs and ensure you have access to the latest revenue earning features.");
            String var11 = var5.toString();
            if (com.applovin.impl.sdk.utils.i.a(var3, "sdk_update_message")) {
               var11 = com.applovin.impl.sdk.utils.i.b(var3, "sdk_update_message", var11, this.b);
            }

            com.applovin.impl.sdk.p.i("AppLovinSdk", var11);
         }

         this.b.L().b();
         this.b.M().b();
      } catch (Throwable var13) {
         this.a("Unable to parse API response", var13);
         return;
      }
   }

   private void b(JSONObject var1) throws JSONException {
      com.applovin.impl.sdk.k var2 = this.b.O();
      com.applovin.impl.sdk.k.b var3 = var2.c();
      com.applovin.impl.sdk.k.d var4 = var2.b();
      JSONObject var5 = new JSONObject();
      var5.put("model", var4.a);
      var5.put("os", var4.b);
      var5.put("brand", var4.d);
      var5.put("brand_name", var4.e);
      var5.put("hardware", var4.f);
      var5.put("sdk_version", var4.h);
      var5.put("revision", var4.g);
      var5.put("adns", (double)var4.m);
      var5.put("adnsd", var4.n);
      var5.put("xdpi", String.valueOf(var4.o));
      var5.put("ydpi", String.valueOf(var4.p));
      var5.put("screen_size_in", String.valueOf(var4.q));
      var5.put("gy", com.applovin.impl.sdk.utils.n.a(var4.B));
      var5.put("country_code", var4.i);
      var5.put("carrier", var4.j);
      var5.put("orientation_lock", var4.l);
      var5.put("tz_offset", var4.r);
      var5.put("aida", String.valueOf(var4.N));
      var5.put("adr", com.applovin.impl.sdk.utils.n.a(var4.t));
      var5.put("wvvc", var4.s);
      var5.put("volume", var4.x);
      var5.put("sb", var4.y);
      var5.put("type", "android");
      var5.put("sim", com.applovin.impl.sdk.utils.n.a(var4.A));
      var5.put("is_tablet", com.applovin.impl.sdk.utils.n.a(var4.C));
      var5.put("lpm", var4.F);
      var5.put("tv", com.applovin.impl.sdk.utils.n.a(var4.D));
      var5.put("vs", com.applovin.impl.sdk.utils.n.a(var4.E));
      var5.put("fs", var4.H);
      var5.put("tds", var4.I);
      var5.put("fm", String.valueOf(var4.J.b));
      var5.put("tm", String.valueOf(var4.J.a));
      var5.put("lmt", String.valueOf(var4.J.c));
      var5.put("lm", String.valueOf(var4.J.d));
      var5.put("af", String.valueOf(var4.v));
      var5.put("font", String.valueOf(var4.w));
      var5.put("bt_ms", String.valueOf(var4.Q));
      this.g(var5);
      Boolean var43 = var4.K;
      if (var43 != null) {
         var5.put("huc", var43.toString());
      }

      Boolean var44 = var4.L;
      if (var44 != null) {
         var5.put("aru", var44.toString());
      }

      Boolean var45 = var4.M;
      if (var45 != null) {
         var5.put("dns", var45.toString());
      }

      com.applovin.impl.sdk.k.c var46 = var4.u;
      if (var46 != null) {
         var5.put("act", var46.a);
         var5.put("acm", var46.b);
      }

      String var47 = var4.z;
      if (com.applovin.impl.sdk.utils.n.b(var47)) {
         var5.put("ua", com.applovin.impl.sdk.utils.n.e(var47));
      }

      String var48 = var4.G;
      if (!TextUtils.isEmpty(var48)) {
         var5.put("so", com.applovin.impl.sdk.utils.n.e(var48));
      }

      Locale var49 = var4.k;
      if (var49 != null) {
         var5.put("locale", com.applovin.impl.sdk.utils.n.e(var49.toString()));
      }

      if (var4.O > 0.0F) {
         var5.put("da", (double)var4.O);
      }

      if (var4.P > 0.0F) {
         var5.put("dm", (double)var4.P);
      }

      var1.put("device_info", var5);
      JSONObject var51 = new JSONObject();
      var51.put("package_name", var3.c);
      var51.put("installer_name", var3.d);
      var51.put("app_name", var3.a);
      var51.put("app_version", var3.b);
      var51.put("installed_at", var3.h);
      var51.put("tg", var3.e);
      var51.put("ltg", var3.f);
      var51.put("applovin_sdk_version", AppLovinSdk.VERSION);
      var51.put("first_install", String.valueOf(this.b.H()));
      var51.put("first_install_v2", String.valueOf(true ^ this.b.I()));
      var51.put("debug", Boolean.toString(com.applovin.impl.sdk.utils.q.b(this.b)));
      String var63 = (String)this.b.a(com.applovin.impl.sdk.b.d.ea);
      if (com.applovin.impl.sdk.utils.n.b(var63)) {
         var51.put("plugin_version", var63);
      }

      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.dT) && com.applovin.impl.sdk.utils.n.b(this.b.i())) {
         var51.put("cuid", this.b.i());
      }

      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.dW)) {
         var51.put("compass_random_token", this.b.j());
      }

      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.dY)) {
         var51.put("applovin_random_token", this.b.k());
      }

      var1.put("app_info", var51);
   }

   private void c(JSONObject var1) throws JSONException {
      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.ex)) {
         var1.put("stats", this.b.L().c());
      }

      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.ag)) {
         JSONObject var2 = com.applovin.impl.sdk.network.d.b(this.g());
         if (var2.length() > 0) {
            var1.put("network_response_codes", var2);
         }

         if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.ah)) {
            com.applovin.impl.sdk.network.d.a(this.g());
         }
      }

   }

   private void d(JSONObject var1) throws JSONException {
      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.eE)) {
         JSONArray var2 = this.b.P().a();
         if (var2 != null && var2.length() > 0) {
            var1.put("errors", var2);
         }
      }

   }

   private void e(JSONObject var1) throws JSONException {
      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.eD)) {
         JSONArray var2 = this.b.M().a();
         if (var2 != null && var2.length() > 0) {
            var1.put("tasks", var2);
         }
      }

   }

   private void f(JSONObject var1) {
      b$1 var2 = new b$1(this, com.applovin.impl.sdk.network.b.a(this.b).a(com.applovin.impl.sdk.utils.h.a("2.0/device", this.b)).c(com.applovin.impl.sdk.utils.h.b("2.0/device", this.b)).a(com.applovin.impl.sdk.utils.h.e(this.b)).b("POST").a(var1).a((Object)(new JSONObject())).a((Integer)this.b.a(com.applovin.impl.sdk.b.d.dC)).a(), this.b);
      var2.a(com.applovin.impl.sdk.b.d.aN);
      var2.b(com.applovin.impl.sdk.b.d.aO);
      this.b.K().a((a)var2);
   }

   private void g(JSONObject var1) {
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
      return com.applovin.impl.sdk.c.i.h;
   }

   public void run() {
      try {
         this.b("Submitting user data...");
         JSONObject var2 = new JSONObject();
         this.b(var2);
         this.c(var2);
         this.d(var2);
         this.e(var2);
         this.f(var2);
      } catch (JSONException var3) {
         this.a("Unable to build JSON message with collected data", var3);
         this.b.M().a(this.a());
      }
   }
}
