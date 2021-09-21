package com.applovin.impl.sdk.d;

import com.applovin.impl.sdk.ad.NativeAdImpl;
import com.applovin.impl.sdk.ad.NativeAdImpl$1;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class v extends a {
   private final AppLovinNativeAdLoadListener a;
   private final JSONObject c;

   v(JSONObject var1, com.applovin.impl.sdk.j var2, AppLovinNativeAdLoadListener var3) {
      super("TaskRenderNativeAd", var2);
      this.a = var3;
      this.c = var1;
   }

   private String a(String var1, JSONObject var2, String var3) {
      String var4 = com.applovin.impl.sdk.utils.i.b(var2, var1, (String)null, this.b);
      String var5 = null;
      if (var4 != null) {
         var5 = var4.replace("{CLCODE}", var3);
      }

      return var5;
   }

   private String a(JSONObject var1, String var2, String var3) {
      String var4 = com.applovin.impl.sdk.utils.i.b(var1, "click_url", (String)null, this.b);
      if (var3 == null) {
         var3 = "";
      }

      return var4.replace("{CLCODE}", var2).replace("{EVENT_ID}", var3);
   }

   private void a(JSONObject var1) {
      JSONObject var2 = var1;
      JSONArray var3 = com.applovin.impl.sdk.utils.i.b(var1, "native_ads", new JSONArray(), this.b);
      JSONObject var4 = com.applovin.impl.sdk.utils.i.b(var1, "native_settings", new JSONObject(), this.b);
      if (var3.length() > 0) {
         ArrayList var5 = new ArrayList(var3.length());

         for(int var6 = 0; var6 < var3.length(); var3 = var3) {
            JSONObject var8 = com.applovin.impl.sdk.utils.i.a(var3, var6, (JSONObject)null, this.b);
            String var9 = com.applovin.impl.sdk.utils.i.b(var8, "clcode", (String)null, this.b);
            String var10 = com.applovin.impl.sdk.utils.i.b(var2, "zone_id", (String)null, this.b);
            com.applovin.impl.sdk.ad.d var11 = com.applovin.impl.sdk.ad.d.b(var10, this.b);
            String var12 = com.applovin.impl.sdk.utils.i.b(var8, "event_id", (String)null, this.b);
            String var13 = this.a("simp_url", var4, var9);
            String var14 = this.a(var4, var9, var12);
            List var15 = com.applovin.impl.sdk.utils.q.a("simp_urls", var4, var9, var13, this.b);
            String var16;
            if (com.applovin.impl.sdk.utils.i.a(var4, "should_post_click_url", true, this.b)) {
               var16 = var14;
            } else {
               var16 = null;
            }

            com.applovin.impl.sdk.j var17 = this.b;
            List var20 = com.applovin.impl.sdk.utils.q.a("click_tracking_urls", var4, var9, var12, var16, var17);
            if (var15.size() == 0) {
               throw new IllegalArgumentException("No impression URL available");
            }

            if (var20.size() == 0) {
               throw new IllegalArgumentException("No click tracking URL available");
            }

            String var21 = com.applovin.impl.sdk.utils.i.b(var8, "resource_cache_prefix", (String)null, this.b);
            List var22;
            if (com.applovin.impl.sdk.utils.n.b(var21)) {
               var22 = com.applovin.impl.sdk.utils.e.a(var21);
            } else {
               var22 = this.b.b(com.applovin.impl.sdk.b.d.bM);
            }

            NativeAdImpl var23 = ((<undefinedtype>)(new Object() {
               private com.applovin.impl.sdk.ad.d a;
               private String b;
               private String c;
               private String d;
               private String e;
               private String f;
               private String g;
               private String h;
               private String i;
               private String j;
               private String k;
               private float l;
               private String m;
               private String n;
               private String o;
               private String p;
               private String q;
               private List r;
               private List s;
               private String t;
               private String u;
               private long v;
               private List w;
               private com.applovin.impl.sdk.j x;

               public <undefinedtype> a(float var1) {
                  this.l = var1;
                  return this;
               }

               public <undefinedtype> a(long var1) {
                  this.v = var1;
                  return this;
               }

               public <undefinedtype> a(com.applovin.impl.sdk.ad.d var1) {
                  this.a = var1;
                  return this;
               }

               public <undefinedtype> a(com.applovin.impl.sdk.j var1) {
                  this.x = var1;
                  return this;
               }

               public <undefinedtype> a(String var1) {
                  this.c = var1;
                  return this;
               }

               public <undefinedtype> a(List var1) {
                  this.r = var1;
                  return this;
               }

               public NativeAdImpl a() {
                  NativeAdImpl var1 = new NativeAdImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, (NativeAdImpl$1)null);
                  return var1;
               }

               public <undefinedtype> b(String var1) {
                  this.d = var1;
                  return this;
               }

               public <undefinedtype> b(List var1) {
                  this.s = var1;
                  return this;
               }

               public <undefinedtype> c(String var1) {
                  this.e = var1;
                  return this;
               }

               public <undefinedtype> c(List var1) {
                  this.w = var1;
                  return this;
               }

               public <undefinedtype> d(String var1) {
                  this.f = var1;
                  return this;
               }

               public <undefinedtype> e(String var1) {
                  this.b = var1;
                  return this;
               }

               public <undefinedtype> f(String var1) {
                  this.g = var1;
                  return this;
               }

               public <undefinedtype> g(String var1) {
                  this.h = var1;
                  return this;
               }

               public <undefinedtype> h(String var1) {
                  this.i = var1;
                  return this;
               }

               public <undefinedtype> i(String var1) {
                  this.j = var1;
                  return this;
               }

               public <undefinedtype> j(String var1) {
                  this.k = var1;
                  return this;
               }

               public <undefinedtype> k(String var1) {
                  this.m = var1;
                  return this;
               }

               public <undefinedtype> l(String var1) {
                  this.n = var1;
                  return this;
               }

               public <undefinedtype> m(String var1) {
                  this.o = var1;
                  return this;
               }

               public <undefinedtype> n(String var1) {
                  this.p = var1;
                  return this;
               }

               public <undefinedtype> o(String var1) {
                  this.q = var1;
                  return this;
               }

               public <undefinedtype> p(String var1) {
                  this.t = var1;
                  return this;
               }

               public <undefinedtype> q(String var1) {
                  this.u = var1;
                  return this;
               }
            })).a(var11).e(var10).f(com.applovin.impl.sdk.utils.i.b(var8, "title", (String)null, this.b)).g(com.applovin.impl.sdk.utils.i.b(var8, "description", (String)null, this.b)).h(com.applovin.impl.sdk.utils.i.b(var8, "caption", (String)null, this.b)).q(com.applovin.impl.sdk.utils.i.b(var8, "cta", (String)null, this.b)).a(com.applovin.impl.sdk.utils.i.b(var8, "icon_url", (String)null, this.b)).b(com.applovin.impl.sdk.utils.i.b(var8, "image_url", (String)null, this.b)).d(com.applovin.impl.sdk.utils.i.b(var8, "video_url", (String)null, this.b)).c(com.applovin.impl.sdk.utils.i.b(var8, "star_rating_url", (String)null, this.b)).i(com.applovin.impl.sdk.utils.i.b(var8, "icon_url", (String)null, this.b)).j(com.applovin.impl.sdk.utils.i.b(var8, "image_url", (String)null, this.b)).k(com.applovin.impl.sdk.utils.i.b(var8, "video_url", (String)null, this.b)).a(com.applovin.impl.sdk.utils.i.a(var8, "star_rating", 5.0F, this.b)).p(var9).l(var14).m(var13).n(this.a("video_start_url", var4, var9)).o(this.a("video_end_url", var4, var9)).a(var15).b(var20).a(com.applovin.impl.sdk.utils.i.a(var8, "ad_id", 0L, this.b)).c(var22).a(this.b).a();
            var5.add(var23);
            StringBuilder var25 = new StringBuilder();
            var25.append("Prepared native ad: ");
            var25.append(var23.getAdId());
            this.a(var25.toString());
            ++var6;
            var2 = var1;
         }

         AppLovinNativeAdLoadListener var7 = this.a;
         if (var7 != null) {
            var7.onNativeAdsLoaded((List)var5);
            return;
         }
      } else {
         this.c("No ads were returned from the server");
         this.a.onNativeAdsFailedToLoad(204);
      }

   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.v;
   }

   void a(int var1) {
      try {
         if (this.a != null) {
            this.a.onNativeAdsFailedToLoad(var1);
            return;
         }
      } catch (Exception var3) {
         this.a("Unable to notify listener about failure.", var3);
      }

   }

   public void run() {
      JSONObject var1 = this.c;
      if (var1 != null && var1.length() > 0) {
         this.a(this.c);
      } else {
         this.d("Attempting to run task with empty or null ad response");
         this.a(204);
      }
   }
}
