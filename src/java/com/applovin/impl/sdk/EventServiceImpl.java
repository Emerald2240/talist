package com.applovin.impl.sdk;

import android.content.Intent;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class EventServiceImpl implements AppLovinEventService {
   private final j a;
   private final Map b;
   private final AtomicBoolean c = new AtomicBoolean();

   public EventServiceImpl(j var1) {
      this.a = var1;
      if ((Boolean)var1.a(com.applovin.impl.sdk.b.d.aY)) {
         this.b = com.applovin.impl.sdk.utils.i.a((String)((String)this.a.b(com.applovin.impl.sdk.b.f.r, "{}")), (Map)(new HashMap()), this.a);
      } else {
         this.b = new HashMap();
         var1.a((com.applovin.impl.sdk.b.f)com.applovin.impl.sdk.b.f.r, (Object)"{}");
      }
   }

   private String a() {
      StringBuilder var1 = new StringBuilder();
      var1.append((String)this.a.a(com.applovin.impl.sdk.b.d.aP));
      var1.append("4.0/pix");
      return var1.toString();
   }

   private HashMap a(l var1, k.a var2) {
      k var3 = this.a.O();
      k.d var4 = var3.b();
      k.b var5 = var3.c();
      boolean var6 = this.a.b(com.applovin.impl.sdk.b.d.aV).contains(var1.a());
      HashMap var7 = new HashMap();
      String var8;
      if (var6) {
         var8 = com.applovin.impl.sdk.utils.n.e(var1.a());
      } else {
         var8 = "postinstall";
      }

      var7.put("event", var8);
      var7.put("ts", Long.toString(var1.c()));
      var7.put("platform", com.applovin.impl.sdk.utils.n.e(var4.c));
      var7.put("model", com.applovin.impl.sdk.utils.n.e(var4.a));
      var7.put("package_name", com.applovin.impl.sdk.utils.n.e(var5.c));
      var7.put("installer_name", com.applovin.impl.sdk.utils.n.e(var5.d));
      var7.put("ia", Long.toString(var5.h));
      var7.put("api_did", this.a.a(com.applovin.impl.sdk.b.d.X));
      var7.put("brand", com.applovin.impl.sdk.utils.n.e(var4.d));
      var7.put("brand_name", com.applovin.impl.sdk.utils.n.e(var4.e));
      var7.put("hardware", com.applovin.impl.sdk.utils.n.e(var4.f));
      var7.put("revision", com.applovin.impl.sdk.utils.n.e(var4.g));
      var7.put("sdk_version", AppLovinSdk.VERSION);
      var7.put("os", com.applovin.impl.sdk.utils.n.e(var4.b));
      var7.put("orientation_lock", var4.l);
      var7.put("app_version", com.applovin.impl.sdk.utils.n.e(var5.b));
      var7.put("country_code", com.applovin.impl.sdk.utils.n.e(var4.i));
      var7.put("carrier", com.applovin.impl.sdk.utils.n.e(var4.j));
      var7.put("tz_offset", String.valueOf(var4.r));
      var7.put("aida", String.valueOf(var4.N));
      boolean var29 = var4.t;
      String var30 = "1";
      String var31;
      if (var29) {
         var31 = var30;
      } else {
         var31 = "0";
      }

      var7.put("adr", var31);
      var7.put("volume", String.valueOf(var4.x));
      var7.put("sb", String.valueOf(var4.y));
      if (!var4.A) {
         var30 = "0";
      }

      var7.put("sim", var30);
      var7.put("gy", String.valueOf(var4.B));
      var7.put("is_tablet", String.valueOf(var4.C));
      var7.put("tv", String.valueOf(var4.D));
      var7.put("vs", String.valueOf(var4.E));
      var7.put("lpm", String.valueOf(var4.F));
      var7.put("tg", var5.e);
      var7.put("ltg", var5.f);
      var7.put("fs", String.valueOf(var4.H));
      var7.put("tds", String.valueOf(var4.I));
      var7.put("fm", String.valueOf(var4.J.b));
      var7.put("tm", String.valueOf(var4.J.a));
      var7.put("lmt", String.valueOf(var4.J.c));
      var7.put("lm", String.valueOf(var4.J.d));
      var7.put("adns", String.valueOf(var4.m));
      var7.put("adnsd", String.valueOf(var4.n));
      var7.put("xdpi", String.valueOf(var4.o));
      var7.put("ydpi", String.valueOf(var4.p));
      var7.put("screen_size_in", String.valueOf(var4.q));
      var7.put("debug", Boolean.toString(com.applovin.impl.sdk.utils.q.b(this.a)));
      var7.put("af", String.valueOf(var4.v));
      var7.put("font", String.valueOf(var4.w));
      var7.put("bt_ms", String.valueOf(var4.Q));
      if (!(Boolean)this.a.a(com.applovin.impl.sdk.b.d.eR)) {
         var7.put("sdk_key", this.a.t());
      }

      this.a((k.a)var2, (Map)var7);
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.dT)) {
         com.applovin.impl.sdk.utils.q.a((String)"cuid", (String)this.a.i(), (Map)var7);
      }

      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.dW)) {
         var7.put("compass_random_token", this.a.j());
      }

      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.dY)) {
         var7.put("applovin_random_token", this.a.k());
      }

      Boolean var58 = var4.K;
      if (var58 != null) {
         var7.put("huc", var58.toString());
      }

      Boolean var59 = var4.L;
      if (var59 != null) {
         var7.put("aru", var59.toString());
      }

      Boolean var60 = var4.M;
      if (var60 != null) {
         var7.put("dns", var60.toString());
      }

      k.c var61 = var4.u;
      if (var61 != null) {
         var7.put("act", String.valueOf(var61.a));
         var7.put("acm", String.valueOf(var61.b));
      }

      String var62 = var4.z;
      if (com.applovin.impl.sdk.utils.n.b(var62)) {
         var7.put("ua", com.applovin.impl.sdk.utils.n.e(var62));
      }

      String var63 = var4.G;
      if (!TextUtils.isEmpty(var63)) {
         var7.put("so", com.applovin.impl.sdk.utils.n.e(var63));
      }

      if (!var6) {
         var7.put("sub_event", com.applovin.impl.sdk.utils.n.e(var1.a()));
      }

      if (var4.O > 0.0F) {
         var7.put("da", String.valueOf(var4.O));
      }

      if (var4.P > 0.0F) {
         var7.put("dm", String.valueOf(var4.P));
      }

      var7.put("sc", com.applovin.impl.sdk.utils.n.e((String)this.a.a(com.applovin.impl.sdk.b.d.aa)));
      var7.put("sc2", com.applovin.impl.sdk.utils.n.e((String)this.a.a(com.applovin.impl.sdk.b.d.ab)));
      var7.put("server_installed_at", com.applovin.impl.sdk.utils.n.e((String)this.a.a(com.applovin.impl.sdk.b.d.ac)));
      com.applovin.impl.sdk.utils.q.a((String)"persisted_data", (String)com.applovin.impl.sdk.utils.n.e((String)this.a.a(com.applovin.impl.sdk.b.f.z)), (Map)var7);
      com.applovin.impl.sdk.utils.q.a((String)"plugin_version", (String)com.applovin.impl.sdk.utils.n.e((String)this.a.a(com.applovin.impl.sdk.b.d.ea)), (Map)var7);
      com.applovin.impl.sdk.utils.q.a((String)"mediation_provider", (String)com.applovin.impl.sdk.utils.n.e(this.a.n()), (Map)var7);
      return var7;
   }

   private void a(Object var1) {
      com.applovin.impl.sdk.d.i var2 = new com.applovin.impl.sdk.d.i(this.a, var1);
      this.a.K().a((com.applovin.impl.sdk.d.a)var2, com.applovin.impl.sdk.d.r.a.d);
   }

   private void a(k.a var1, Map var2) {
      String var3 = var1.b;
      if (com.applovin.impl.sdk.utils.n.b(var3)) {
         var2.put("idfa", var3);
      }

      var2.put("dnt", Boolean.toString(var1.a));
   }

   private String b() {
      StringBuilder var1 = new StringBuilder();
      var1.append((String)this.a.a(com.applovin.impl.sdk.b.d.aQ));
      var1.append("4.0/pix");
      return var1.toString();
   }

   private void c() {
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.aY)) {
         String var1 = com.applovin.impl.sdk.utils.i.a(this.b, "{}", this.a);
         this.a.a((com.applovin.impl.sdk.b.f)com.applovin.impl.sdk.b.f.r, (Object)var1);
      }

   }

   void a(String var1, boolean var2) {
      this.trackEvent(var1, new HashMap(), (Map)null, var2);
   }

   public Map getSuperProperties() {
      return new HashMap(this.b);
   }

   public void maybeTrackAppOpenEvent() {
      if (this.c.compareAndSet(false, true)) {
         this.a.q().trackEvent("landing");
      }

   }

   public void setSuperProperty(Object var1, String var2) {
      if (TextUtils.isEmpty(var2)) {
         p.j("AppLovinEventService", "Super property key cannot be null or empty");
      } else if (var1 == null) {
         this.b.remove(var2);
         this.c();
      } else {
         List var3 = this.a.b(com.applovin.impl.sdk.b.d.aX);
         if (!com.applovin.impl.sdk.utils.q.a(var1, var3, this.a)) {
            StringBuilder var4 = new StringBuilder();
            var4.append("Failed to set super property '");
            var4.append(var1);
            var4.append("' for key '");
            var4.append(var2);
            var4.append("' - valid super property types include: ");
            var4.append(var3);
            p.j("AppLovinEventService", var4.toString());
         } else {
            this.b.put(var2, com.applovin.impl.sdk.utils.q.a(var1, this.a));
            this.c();
         }
      }
   }

   public String toString() {
      return "EventService{}";
   }

   public void trackCheckout(String param1, Map param2) {
      // $FF: Couldn't be decompiled
   }

   public void trackEvent(String var1) {
      this.trackEvent(var1, new HashMap());
   }

   public void trackEvent(String var1, Map var2) {
      this.trackEvent(var1, var2, (Map)null, true);
   }

   public void trackEvent(final String var1, final Map var2, final Map var3, final boolean var4) {
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.aW)) {
         p var5 = this.a.v();
         StringBuilder var6 = new StringBuilder();
         var6.append("Tracking event: \"");
         var6.append(var1);
         var6.append("\" with parameters: ");
         var6.append(var2);
         var5.b("AppLovinEventService", var6.toString());
         <undefinedtype> var11 = new <undefinedtype>() {
            public void a(k.a var1x) {
               l var2x = new l(var1, var2, EventServiceImpl.this.b);

               try {
                  if (var4) {
                     com.applovin.impl.sdk.network.f var9 = com.applovin.impl.sdk.network.f.l().a(EventServiceImpl.this.a()).b(EventServiceImpl.this.b()).a((Map)EventServiceImpl.this.a(var2x, var1x)).b(var3).c(var2x.b()).a((Boolean)EventServiceImpl.this.a.a(com.applovin.impl.sdk.b.d.eR)).a();
                     EventServiceImpl.this.a.N().a(var9);
                  } else {
                     com.applovin.impl.sdk.network.g var8 = com.applovin.impl.sdk.network.g.b(EventServiceImpl.this.a).d(EventServiceImpl.this.a()).e(EventServiceImpl.this.b()).b((Map)EventServiceImpl.this.a(var2x, var1x)).c(var3).b(com.applovin.impl.sdk.utils.i.a(var2x.b())).c((Boolean)EventServiceImpl.this.a.a(com.applovin.impl.sdk.b.d.eR)).b();
                     EventServiceImpl.this.a.R().dispatchPostbackRequest(var8, (AppLovinPostbackListener)null);
                  }
               } catch (Throwable var11) {
                  p var4x = EventServiceImpl.this.a.v();
                  StringBuilder var5 = new StringBuilder();
                  var5.append("Unable to track event: ");
                  var5.append(var2x);
                  var4x.b("AppLovinEventService", var5.toString(), var11);
                  return;
               }
            }
         };
         this.a(var11);
      }
   }

   public void trackInAppPurchase(Intent param1, Map param2) {
      // $FF: Couldn't be decompiled
   }
}
