package com.applovin.impl.mediation.a.a;

import android.text.TextUtils;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.q;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d implements Comparable {
   private final d.a a;
   private final boolean b;
   private final boolean c;
   private final boolean d;
   private final String e;
   private final String f;
   private final String g;
   private final String h;
   private final String i;
   private final List j;
   private final List k;
   private final List l;
   private final e m;

   public d(JSONObject var1, j var2) {
      String var3 = "";
      this.e = com.applovin.impl.sdk.utils.i.b(var1, "display_name", var3, var2);
      this.h = com.applovin.impl.sdk.utils.i.b(var1, "name", var3, var2);
      this.i = com.applovin.impl.sdk.utils.i.b(var1, "latest_adapter_version", var3, var2);
      JSONObject var4 = com.applovin.impl.sdk.utils.i.b(var1, "configuration", new JSONObject(), var2);
      this.k = this.a(var4, var2);
      this.l = this.b(var4, var2);
      this.m = new e(var4, var2);
      this.b = q.e(com.applovin.impl.sdk.utils.i.b(var1, "existence_class", var3, var2));
      List var5 = Collections.emptyList();
      MaxAdapter var6 = com.applovin.impl.mediation.d.c.a(com.applovin.impl.sdk.utils.i.b(var1, "adapter_class", var3, var2), var2);
      String var7;
      if (var6 != null) {
         label75: {
            this.c = true;

            label70: {
               String var14;
               try {
                  var14 = var6.getAdapterVersion();
               } catch (Throwable var20) {
                  var7 = var3;
                  break label70;
               }

               label67:
               try {
                  var3 = var6.getSdkVersion();
                  var5 = this.a(var6);
                  break label75;
               } finally {
                  var7 = var3;
                  var3 = var14;
                  break label67;
               }
            }

            StringBuilder var9 = new StringBuilder();
            var9.append("Failed to load adapter for network ");
            var9.append(this.e);
            var9.append(". Please check that you have a compatible network SDK integrated. Error: ");
            var9.append(var20);
            p.j("MediatedNetwork", var9.toString());
         }
      } else {
         this.c = false;
         var7 = var3;
      }

      this.g = var3;
      this.f = var7;
      this.j = var5;
      this.a = this.m();
      this.d = true ^ var3.equals(this.i);
   }

   private List a(MaxAdapter var1) {
      ArrayList var2 = new ArrayList(5);
      if (var1 instanceof MaxInterstitialAdapter) {
         var2.add(MaxAdFormat.INTERSTITIAL);
      }

      if (var1 instanceof MaxRewardedAdapter) {
         var2.add(MaxAdFormat.REWARDED);
      }

      if (var1 instanceof MaxAdViewAdapter) {
         var2.add(MaxAdFormat.BANNER);
         var2.add(MaxAdFormat.LEADER);
         var2.add(MaxAdFormat.MREC);
      }

      return var2;
   }

   private List a(JSONObject var1, j var2) {
      ArrayList var3 = new ArrayList();
      JSONObject var4 = com.applovin.impl.sdk.utils.i.b(var1, "permissions", new JSONObject(), var2);
      Iterator var5 = var4.keys();

      while(var5.hasNext()) {
         try {
            String var7 = (String)var5.next();
            var3.add(new f(var7, var4.getString(var7), var2.D()));
         } catch (JSONException var8) {
         }
      }

      return var3;
   }

   private List b(JSONObject var1, j var2) {
      ArrayList var3 = new ArrayList();
      JSONArray var4 = com.applovin.impl.sdk.utils.i.b(var1, "dependencies", new JSONArray(), var2);

      for(int var5 = 0; var5 < var4.length(); ++var5) {
         JSONObject var6 = com.applovin.impl.sdk.utils.i.a(var4, var5, (JSONObject)null, var2);
         if (var6 != null) {
            var3.add(new com.applovin.impl.mediation.a.a.a(var6, var2));
         }
      }

      return var3;
   }

   private d.a m() {
      if (!this.b && !this.c) {
         return d.a.a;
      } else {
         Iterator var1 = this.k.iterator();

         do {
            if (!var1.hasNext()) {
               Iterator var2 = this.l.iterator();

               do {
                  if (!var2.hasNext()) {
                     if (this.m.a() && !this.m.b()) {
                        return d.a.c;
                     }

                     if (this.b && this.c) {
                        return d.a.d;
                     }

                     return d.a.b;
                  }
               } while(((com.applovin.impl.mediation.a.a.a)var2.next()).c());

               return d.a.c;
            }
         } while(((f)var1.next()).c());

         return d.a.c;
      }
   }

   public int a(d var1) {
      return this.e.compareToIgnoreCase(var1.e);
   }

   public d.a a() {
      return this.a;
   }

   public boolean b() {
      return this.b;
   }

   public boolean c() {
      return this.c;
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.a((d)var1);
   }

   public boolean d() {
      return this.d;
   }

   public String e() {
      return this.e;
   }

   public String f() {
      return this.f;
   }

   public String g() {
      return this.g;
   }

   public String h() {
      return this.i;
   }

   public List i() {
      return this.k;
   }

   public List j() {
      return this.l;
   }

   public final e k() {
      return this.m;
   }

   public final String l() {
      StringBuilder var1 = new StringBuilder();
      var1.append("\n------------------ ");
      var1.append(this.e);
      var1.append(" ------------------");
      var1.append("\nStatus  - ");
      var1.append(this.a.a());
      var1.append("\nAdapter - ");
      boolean var8 = this.c;
      String var9 = "UNAVAILABLE";
      String var10;
      if (var8 && !TextUtils.isEmpty(this.g)) {
         var10 = this.g;
      } else {
         var10 = var9;
      }

      var1.append(var10);
      var1.append("\nSDK     - ");
      if (this.b && !TextUtils.isEmpty(this.f)) {
         var9 = this.f;
      }

      var1.append(var9);
      if (this.m.a() && !this.m.b()) {
         var1.append("\n* ");
         var1.append(this.m.c());
      }

      Iterator var14 = this.i().iterator();

      while(var14.hasNext()) {
         f var21 = (f)var14.next();
         if (!var21.c()) {
            var1.append("\n* MISSING ");
            var1.append(var21.a());
            var1.append(": ");
            var1.append(var21.b());
         }
      }

      Iterator var15 = this.j().iterator();

      while(var15.hasNext()) {
         com.applovin.impl.mediation.a.a.a var16 = (com.applovin.impl.mediation.a.a.a)var15.next();
         if (!var16.c()) {
            var1.append("\n* MISSING ");
            var1.append(var16.a());
            var1.append(": ");
            var1.append(var16.b());
         }
      }

      return var1.toString();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MediatedNetwork{name=");
      var1.append(this.e);
      var1.append(", sdkAvailable=");
      var1.append(this.b);
      var1.append(", sdkVersion=");
      var1.append(this.f);
      var1.append(", adapterAvailable=");
      var1.append(this.c);
      var1.append(", adapterVersion=");
      var1.append(this.g);
      var1.append("}");
      return var1.toString();
   }

   public static enum a {
      a("MISSING"),
      b("INCOMPLETE INTEGRATION"),
      c("INVALID INTEGRATION"),
      d("COMPLETE");

      private final String e;

      static {
         d.a[] var0 = new d.a[]{a, b, c, d};
      }

      private a(String var3) {
         this.e = var3;
      }

      private String a() {
         return this.e;
      }
   }
}
