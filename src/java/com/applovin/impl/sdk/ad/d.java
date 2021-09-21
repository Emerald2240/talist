package com.applovin.impl.sdk.ad;

import android.text.TextUtils;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class d {
   private static final Map a = new HashMap();
   private static final Object b = new Object();
   private com.applovin.impl.sdk.j c;
   private p d;
   private JSONObject e;
   private final String f;
   private String g;
   private AppLovinAdSize h;
   private AppLovinAdType i;

   private d(AppLovinAdSize var1, AppLovinAdType var2, String var3, com.applovin.impl.sdk.j var4) {
      if (!TextUtils.isEmpty(var3) || var2 != null && var1 != null) {
         this.c = var4;
         p var5;
         if (var4 != null) {
            var5 = var4.v();
         } else {
            var5 = null;
         }

         this.d = var5;
         this.h = var1;
         this.i = var2;
         if (!TextUtils.isEmpty(var3)) {
            this.f = var3.toLowerCase(Locale.ENGLISH);
            this.g = var3.toLowerCase(Locale.ENGLISH);
         } else {
            StringBuilder var6 = new StringBuilder();
            var6.append(var1.getLabel());
            var6.append("_");
            var6.append(var2.getLabel());
            this.f = var6.toString().toLowerCase(Locale.ENGLISH);
         }
      } else {
         throw new IllegalArgumentException("No zone identifier or type or size specified");
      }
   }

   public static d a(AppLovinAdSize var0, AppLovinAdType var1, com.applovin.impl.sdk.j var2) {
      return a(var0, var1, (String)null, var2);
   }

   public static d a(AppLovinAdSize var0, AppLovinAdType var1, String var2, com.applovin.impl.sdk.j var3) {
      d var4 = new d(var0, var1, var2, var3);
      Object var5 = b;
      synchronized(var5){}

      boolean var10001;
      Throwable var10000;
      label195: {
         label189: {
            String var7;
            try {
               var7 = var4.f;
               if (a.containsKey(var7)) {
                  var4 = (d)a.get(var7);
                  break label189;
               }
            } catch (Throwable var29) {
               var10000 = var29;
               var10001 = false;
               break label195;
            }

            try {
               a.put(var7, var4);
            } catch (Throwable var28) {
               var10000 = var28;
               var10001 = false;
               break label195;
            }
         }

         label180:
         try {
            return var4;
         } catch (Throwable var27) {
            var10000 = var27;
            var10001 = false;
            break label180;
         }
      }

      while(true) {
         Throwable var6 = var10000;

         try {
            throw var6;
         } catch (Throwable var26) {
            var10000 = var26;
            var10001 = false;
            continue;
         }
      }
   }

   public static d a(String var0, com.applovin.impl.sdk.j var1) {
      return a((AppLovinAdSize)null, (AppLovinAdType)null, var0, var1);
   }

   public static d a(String var0, JSONObject var1, com.applovin.impl.sdk.j var2) {
      d var3 = a(var0, var2);
      var3.e = var1;
      return var3;
   }

   private com.applovin.impl.sdk.b.d a(String var1, com.applovin.impl.sdk.b.d var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append(var1);
      var3.append(this.f);
      String var6 = var3.toString();
      return this.c.a(var6, var2);
   }

   private boolean a(com.applovin.impl.sdk.b.d var1, AppLovinAdSize var2) {
      return ((String)this.c.a(var1)).toUpperCase(Locale.ENGLISH).contains(var2.getLabel());
   }

   public static d b(String var0, com.applovin.impl.sdk.j var1) {
      return a(AppLovinAdSize.NATIVE, AppLovinAdType.NATIVE, var0, var1);
   }

   public static Collection b(com.applovin.impl.sdk.j var0) {
      LinkedHashSet var1 = new LinkedHashSet(8);
      d[] var2 = new d[]{c(var0), d(var0), e(var0), f(var0), g(var0), h(var0)};
      Collections.addAll(var1, var2);
      return Collections.unmodifiableSet(var1);
   }

   public static d c(com.applovin.impl.sdk.j var0) {
      return a(AppLovinAdSize.BANNER, AppLovinAdType.REGULAR, var0);
   }

   public static d c(String var0, com.applovin.impl.sdk.j var1) {
      return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, var0, var1);
   }

   public static d d(com.applovin.impl.sdk.j var0) {
      return a(AppLovinAdSize.MREC, AppLovinAdType.REGULAR, var0);
   }

   public static d e(com.applovin.impl.sdk.j var0) {
      return a(AppLovinAdSize.LEADER, AppLovinAdType.REGULAR, var0);
   }

   public static d f(com.applovin.impl.sdk.j var0) {
      return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR, var0);
   }

   public static d g(com.applovin.impl.sdk.j var0) {
      return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, var0);
   }

   public static d h(com.applovin.impl.sdk.j var0) {
      return a(AppLovinAdSize.NATIVE, AppLovinAdType.NATIVE, var0);
   }

   private boolean j() {
      try {
         if (!TextUtils.isEmpty(this.g)) {
            return true;
         } else if (AppLovinAdType.INCENTIVIZED.equals(this.c())) {
            return (Boolean)this.c.a(com.applovin.impl.sdk.b.d.be);
         } else {
            boolean var2 = this.a(com.applovin.impl.sdk.b.d.bd, this.b());
            return var2;
         }
      } catch (Throwable var4) {
         this.d.b("AdZone", "Unable to safely test preload merge capability", var4);
         return false;
      }
   }

   public String a() {
      return this.f;
   }

   void a(com.applovin.impl.sdk.j var1) {
      this.c = var1;
      this.d = var1.v();
   }

   public AppLovinAdSize b() {
      if (this.h == null && com.applovin.impl.sdk.utils.i.a(this.e, "ad_size")) {
         this.h = AppLovinAdSize.fromString(com.applovin.impl.sdk.utils.i.b(this.e, "ad_size", (String)null, this.c));
      }

      return this.h;
   }

   public AppLovinAdType c() {
      if (this.i == null && com.applovin.impl.sdk.utils.i.a(this.e, "ad_type")) {
         this.i = AppLovinAdType.fromString(com.applovin.impl.sdk.utils.i.b(this.e, "ad_type", (String)null, this.c));
      }

      return this.i;
   }

   public boolean d() {
      return AppLovinAdSize.NATIVE.equals(this.b()) && AppLovinAdType.NATIVE.equals(this.c());
   }

   public int e() {
      if (com.applovin.impl.sdk.utils.i.a(this.e, "capacity")) {
         return com.applovin.impl.sdk.utils.i.b(this.e, "capacity", 0, this.c);
      } else if (!TextUtils.isEmpty(this.g)) {
         return this.d() ? (Integer)this.c.a(com.applovin.impl.sdk.b.d.bt) : (Integer)this.c.a(com.applovin.impl.sdk.b.d.bs);
      } else {
         com.applovin.impl.sdk.b.d var1 = this.a("preload_capacity_", com.applovin.impl.sdk.b.d.bh);
         return (Integer)this.c.a(var1);
      }
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         d var2 = (d)var1;
         return this.f.equalsIgnoreCase(var2.f);
      } else {
         return false;
      }
   }

   public int f() {
      if (com.applovin.impl.sdk.utils.i.a(this.e, "extended_capacity")) {
         return com.applovin.impl.sdk.utils.i.b(this.e, "extended_capacity", 0, this.c);
      } else if (!TextUtils.isEmpty(this.g)) {
         return this.d() ? 0 : (Integer)this.c.a(com.applovin.impl.sdk.b.d.bu);
      } else {
         com.applovin.impl.sdk.b.d var1 = this.a("extended_preload_capacity_", com.applovin.impl.sdk.b.d.bn);
         return (Integer)this.c.a(var1);
      }
   }

   public int g() {
      return com.applovin.impl.sdk.utils.i.b(this.e, "preload_count", 0, this.c);
   }

   public boolean h() {
      if (!(Boolean)this.c.a(com.applovin.impl.sdk.b.d.bc)) {
         return false;
      } else if (!this.j()) {
         return false;
      } else if (!TextUtils.isEmpty(this.g)) {
         if (this.e != null && this.g() == 0) {
            return false;
         } else {
            String var5 = ((String)this.c.a(com.applovin.impl.sdk.b.d.bd)).toUpperCase(Locale.ENGLISH);
            if (!var5.contains(AppLovinAdSize.INTERSTITIAL.getLabel()) && !var5.contains(AppLovinAdSize.BANNER.getLabel()) && !var5.contains(AppLovinAdSize.MREC.getLabel()) && !var5.contains(AppLovinAdSize.LEADER.getLabel())) {
               return this.c.W().a(this) && this.g() > 0 && (Boolean)this.c.a(com.applovin.impl.sdk.b.d.dK);
            } else {
               return (Boolean)this.c.a(com.applovin.impl.sdk.b.d.bB);
            }
         }
      } else {
         com.applovin.impl.sdk.b.d var1 = this.a((String)"preload_merge_init_tasks_", (com.applovin.impl.sdk.b.d)null);
         boolean var2 = false;
         if (var1 != null) {
            boolean var3 = (Boolean)this.c.a(var1);
            var2 = false;
            if (var3) {
               int var4 = this.e();
               var2 = false;
               if (var4 > 0) {
                  var2 = true;
               }
            }
         }

         return var2;
      }
   }

   public int hashCode() {
      return this.f.hashCode();
   }

   public boolean i() {
      return b(this.c).contains(this);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("AdZone{identifier=");
      var1.append(this.f);
      var1.append(", zoneObject=");
      var1.append(this.e);
      var1.append('}');
      return var1.toString();
   }
}
