package com.applovin.impl.a;

import android.net.Uri;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.n;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class a extends com.applovin.impl.sdk.ad.f {
   private final String a;
   private final String b;
   private final f c;
   private final long d;
   private final j e;
   private final b f;
   private final Set g;
   private final Set h;

   private a(a.a var1) {
      super(var1.a, var1.b, var1.c, var1.d);
      this.a = var1.f;
      this.c = var1.h;
      this.b = var1.g;
      this.e = var1.i;
      this.f = var1.j;
      this.g = var1.k;
      this.h = var1.l;
      this.d = var1.e;
   }

   // $FF: synthetic method
   a(a.a var1, a$1 var2) {
      this(var1);
   }

   private Set a(Object var1, String[] var2) {
      if (var2 != null && var2.length > 0) {
         Map var4;
         label36: {
            if (var1 == null.b) {
               j var11 = this.e;
               if (var11 != null) {
                  var4 = var11.e();
                  break label36;
               }
            }

            <undefinedtype> var3 = null.a;
            var4 = null;
            if (var1 == var3) {
               b var10 = this.f;
               var4 = null;
               if (var10 != null) {
                  var4 = var10.d();
               }
            }
         }

         HashSet var5 = new HashSet();
         if (var4 != null && !var4.isEmpty()) {
            int var6 = var2.length;

            for(int var7 = 0; var7 < var6; ++var7) {
               String var8 = var2[var7];
               if (var4.containsKey(var8)) {
                  var5.addAll((Collection)var4.get(var8));
               }
            }
         }

         return Collections.unmodifiableSet(var5);
      } else {
         return Collections.emptySet();
      }
   }

   public static a.a aO() {
      return new a.a((a$1)null);
   }

   private String aP() {
      String var1 = this.getStringFromAdObject("vimp_url", (String)null);
      String var2 = null;
      if (var1 != null) {
         var2 = var1.replace("{CLCODE}", this.getClCode());
      }

      return var2;
   }

   private j.a aQ() {
      j.a[] var1 = j.a.values();
      int var2 = (Integer)this.sdk.a(com.applovin.impl.sdk.b.d.eO);
      return var2 >= 0 && var2 < var1.length ? var1[var2] : j.a.a;
   }

   private Set aR() {
      j var1 = this.e;
      return var1 != null ? var1.d() : Collections.emptySet();
   }

   private Set aS() {
      b var1 = this.f;
      return var1 != null ? var1.c() : Collections.emptySet();
   }

   public Set a(a.c var1, String var2) {
      return this.a(var1, new String[]{var2});
   }

   public Set a(a.c var1, String[] var2) {
      p var3 = this.sdk.v();
      StringBuilder var4 = new StringBuilder();
      var4.append("Retrieving trackers of type '");
      var4.append(var1);
      var4.append("' and events '");
      var4.append(var2);
      var4.append("'...");
      var3.b("VastAd", var4.toString());
      if (var1 == a.c.a) {
         return this.g;
      } else if (var1 == a.c.b) {
         return this.aR();
      } else if (var1 == a.c.c) {
         return this.aS();
      } else if (var1 == a.c.d) {
         return this.a(null.b, var2);
      } else if (var1 == a.c.e) {
         return this.a(null.a, var2);
      } else if (var1 == a.c.f) {
         return this.h;
      } else {
         p var10 = this.sdk.v();
         StringBuilder var11 = new StringBuilder();
         var11.append("Failed to retrieve trackers of invalid type '");
         var11.append(var1);
         var11.append("' and events '");
         var11.append(var2);
         var11.append("'");
         var10.e("VastAd", var11.toString());
         return Collections.emptySet();
      }
   }

   public void a(String param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean a() {
      return this.b();
   }

   public String aK() {
      return this.getStringFromAdObject("html_template", "");
   }

   public Uri aL() {
      String var1 = this.getStringFromAdObject("html_template_url", (String)null);
      boolean var2 = n.b(var1);
      Uri var3 = null;
      if (var2) {
         var3 = Uri.parse(var1);
      }

      return var3;
   }

   public boolean aM() {
      return this.getBooleanFromAdObject("cache_companion_ad", true);
   }

   public boolean aN() {
      return this.getBooleanFromAdObject("cache_video", true);
   }

   public List au() {
      // $FF: Couldn't be decompiled
   }

   public boolean b() {
      if (this.containsKeyForAdObject("vast_is_streaming")) {
         return this.getBooleanFromAdObject("vast_is_streaming", false);
      } else {
         k var1 = this.i();
         boolean var2 = false;
         if (var1 != null) {
            boolean var3 = var1.c();
            var2 = false;
            if (var3) {
               var2 = true;
            }
         }

         return var2;
      }
   }

   public <undefinedtype> c() {
      return "companion_ad".equalsIgnoreCase(this.getStringFromAdObject("vast_first_caching_operation", "companion_ad")) ? null.a : null.b;
   }

   public Uri d() {
      k var1 = this.i();
      return var1 != null ? var1.b() : null;
   }

   public boolean e() {
      return this.getBooleanFromAdObject("vast_immediate_ad_load", true);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof a)) {
         return false;
      } else if (!super.equals(var1)) {
         return false;
      } else {
         a var2 = (a)var1;
         String var3 = this.a;
         if (var3 != null) {
            if (!var3.equals(var2.a)) {
               return false;
            }
         } else if (var2.a != null) {
            return false;
         }

         String var4 = this.b;
         if (var4 != null) {
            if (!var4.equals(var2.b)) {
               return false;
            }
         } else if (var2.b != null) {
            return false;
         }

         f var5 = this.c;
         if (var5 != null) {
            if (!var5.equals(var2.c)) {
               return false;
            }
         } else if (var2.c != null) {
            return false;
         }

         j var6 = this.e;
         if (var6 != null) {
            if (!var6.equals(var2.e)) {
               return false;
            }
         } else if (var2.e != null) {
            return false;
         }

         b var7 = this.f;
         if (var7 != null) {
            if (!var7.equals(var2.f)) {
               return false;
            }
         } else if (var2.f != null) {
            return false;
         }

         Set var8 = this.g;
         if (var8 != null) {
            if (!var8.equals(var2.g)) {
               return false;
            }
         } else if (var2.g != null) {
            return false;
         }

         Set var9 = this.h;
         Set var10 = var2.h;
         if (var9 != null) {
            return var9.equals(var10);
         } else {
            return var10 == null;
         }
      }
   }

   public Uri f() {
      j var1 = this.e;
      return var1 != null ? var1.c() : null;
   }

   public Uri g() {
      return this.f();
   }

   public long getCreatedAtMillis() {
      return this.d;
   }

   public j h() {
      return this.e;
   }

   public boolean hasVideoUrl() {
      j var1 = this.e;
      boolean var2 = false;
      if (var1 != null) {
         List var3 = var1.a();
         var2 = false;
         if (var3 != null) {
            int var4 = var3.size();
            var2 = false;
            if (var4 > 0) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   public int hashCode() {
      int var1 = 31 * super.hashCode();
      String var2 = this.a;
      int var3;
      if (var2 != null) {
         var3 = var2.hashCode();
      } else {
         var3 = 0;
      }

      int var4 = 31 * (var1 + var3);
      String var5 = this.b;
      int var6;
      if (var5 != null) {
         var6 = var5.hashCode();
      } else {
         var6 = 0;
      }

      int var7 = 31 * (var4 + var6);
      f var8 = this.c;
      int var9;
      if (var8 != null) {
         var9 = var8.hashCode();
      } else {
         var9 = 0;
      }

      int var10 = 31 * (var7 + var9);
      j var11 = this.e;
      int var12;
      if (var11 != null) {
         var12 = var11.hashCode();
      } else {
         var12 = 0;
      }

      int var13 = 31 * (var10 + var12);
      b var14 = this.f;
      int var15;
      if (var14 != null) {
         var15 = var14.hashCode();
      } else {
         var15 = 0;
      }

      int var16 = 31 * (var13 + var15);
      Set var17 = this.g;
      int var18;
      if (var17 != null) {
         var18 = var17.hashCode();
      } else {
         var18 = 0;
      }

      int var19 = 31 * (var16 + var18);
      Set var20 = this.h;
      int var21 = 0;
      if (var20 != null) {
         var21 = var20.hashCode();
      }

      return var19 + var21;
   }

   public k i() {
      j var1 = this.e;
      return var1 != null ? var1.a(this.aQ()) : null;
   }

   public b j() {
      return this.f;
   }

   public boolean k() {
      return this.getBooleanFromAdObject("vast_fire_click_trackers_on_html_clicks", false);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("VastAd{title='");
      var1.append(this.a);
      var1.append('\'');
      var1.append(", adDescription='");
      var1.append(this.b);
      var1.append('\'');
      var1.append(", systemInfo=");
      var1.append(this.c);
      var1.append(", videoCreative=");
      var1.append(this.e);
      var1.append(", companionAd=");
      var1.append(this.f);
      var1.append(", impressionTrackers=");
      var1.append(this.g);
      var1.append(", errorTrackers=");
      var1.append(this.h);
      var1.append('}');
      return var1.toString();
   }

   public boolean u() {
      return this.f() != null;
   }

   public static class a {
      private JSONObject a;
      private JSONObject b;
      private com.applovin.impl.sdk.ad.b c;
      private com.applovin.impl.sdk.j d;
      private long e;
      private String f;
      private String g;
      private f h;
      private j i;
      private b j;
      private Set k;
      private Set l;

      private a() {
      }

      // $FF: synthetic method
      a(a$1 var1) {
         this();
      }

      public a.a a(long var1) {
         this.e = var1;
         return this;
      }

      public a.a a(b var1) {
         this.j = var1;
         return this;
      }

      public a.a a(f var1) {
         this.h = var1;
         return this;
      }

      public a.a a(j var1) {
         this.i = var1;
         return this;
      }

      public a.a a(com.applovin.impl.sdk.ad.b var1) {
         this.c = var1;
         return this;
      }

      public a.a a(com.applovin.impl.sdk.j var1) {
         if (var1 != null) {
            this.d = var1;
            return this;
         } else {
            throw new IllegalArgumentException("No sdk specified.");
         }
      }

      public a.a a(String var1) {
         this.f = var1;
         return this;
      }

      public a.a a(Set var1) {
         this.k = var1;
         return this;
      }

      public a.a a(JSONObject var1) {
         if (var1 != null) {
            this.a = var1;
            return this;
         } else {
            throw new IllegalArgumentException("No ad object specified.");
         }
      }

      public a a() {
         return new a(this, (a$1)null);
      }

      public a.a b(String var1) {
         this.g = var1;
         return this;
      }

      public a.a b(Set var1) {
         this.l = var1;
         return this;
      }

      public a.a b(JSONObject var1) {
         if (var1 != null) {
            this.b = var1;
            return this;
         } else {
            throw new IllegalArgumentException("No full ad response specified.");
         }
      }
   }

   public static enum c {
      a,
      b,
      c,
      d,
      e,
      f;

      static {
         a.c[] var0 = new a.c[]{a, b, c, d, e, f};
      }
   }
}
