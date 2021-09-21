package com.applovin.impl.mediation.c;

import android.app.Activity;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.d.r;
import com.applovin.impl.sdk.utils.q;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class f extends com.applovin.impl.sdk.d.a {
   private final String a;
   private final MaxAdFormat c;
   private final JSONObject d;
   private final MaxAdListener e;
   private final WeakReference f;

   f(String var1, MaxAdFormat var2, JSONObject var3, Activity var4, j var5, MaxAdListener var6) {
      StringBuilder var7 = new StringBuilder();
      var7.append("TaskProcessMediationWaterfall ");
      var7.append(var1);
      super(var7.toString(), var5);
      this.a = var1;
      this.c = var2;
      this.d = var3;
      this.e = var6;
      this.f = new WeakReference(var4);
   }

   private void a(int var1) {
      com.applovin.impl.sdk.c.g var3;
      com.applovin.impl.sdk.c.h var2;
      if (var1 == 204) {
         var2 = this.b.L();
         var3 = com.applovin.impl.sdk.c.g.p;
      } else if (var1 == -5001) {
         var2 = this.b.L();
         var3 = com.applovin.impl.sdk.c.g.q;
      } else {
         var2 = this.b.L();
         var3 = com.applovin.impl.sdk.c.g.r;
      }

      var2.a(var3);
      StringBuilder var6 = new StringBuilder();
      var6.append("Notifying parent of ad load failure for ad unit ");
      var6.append(this.a);
      var6.append(": ");
      var6.append(var1);
      this.b(var6.toString());
      com.applovin.impl.sdk.utils.j.a(this.e, this.a, var1);
   }

   // $FF: synthetic method
   static void a(f var0, MaxAd var1) {
      var0.a(var1);
   }

   private void a(MaxAd var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Notifying parent of ad load success for ad unit ");
      var2.append(this.a);
      this.b(var2.toString());
      com.applovin.impl.sdk.utils.j.a(this.e, var1);
   }

   private void b() {
      this.a(-5001);
   }

   public i a() {
      return i.E;
   }

   public void run() {
      JSONArray var1 = this.d.optJSONArray("ads");
      int var2;
      if (var1 != null) {
         var2 = var1.length();
      } else {
         var2 = 0;
      }

      if (var2 > 0) {
         StringBuilder var3 = new StringBuilder();
         var3.append("Loading the first out of ");
         var3.append(var2);
         var3.append(" ads...");
         this.a((String)var3.toString());
         f.a var7 = new f.a(0, var1);
         this.b.K().a((com.applovin.impl.sdk.d.a)var7);
      } else {
         this.c("No ads were returned from the server");
         q.a(this.a, this.d, this.b);
         JSONObject var8 = com.applovin.impl.sdk.utils.i.b(this.d, "settings", new JSONObject(), this.b);
         long var9 = com.applovin.impl.sdk.utils.i.a(var8, "alfdcs", 0L, this.b);
         if (var9 > 0L) {
            long var11 = TimeUnit.SECONDS.toMillis(var9);
            f$1 var13 = new f$1(this);
            if (com.applovin.impl.sdk.utils.i.a(var8, "alfdcs_iba", false, this.b)) {
               com.applovin.impl.sdk.utils.d.a(var11, this.b, var13);
            } else {
               AppLovinSdkUtils.runOnUiThreadDelayed(var13, var11);
            }
         } else {
            this.a(204);
         }
      }
   }

   private class a extends com.applovin.impl.sdk.d.a {
      private final JSONArray c;
      private final int d;

      a(int var2, JSONArray var3) {
         super("TaskProcessNextWaterfallAd", f.this.b);
         if (var2 >= 0 && var2 < var3.length()) {
            this.c = var3;
            this.d = var2;
         } else {
            StringBuilder var4 = new StringBuilder();
            var4.append("Invalid ad index specified: ");
            var4.append(var2);
            throw new IllegalArgumentException(var4.toString());
         }
      }

      private String a(int var1) {
         if (var1 >= 0) {
            return var1 >= this.c.length() ? "undefined" : com.applovin.impl.sdk.utils.i.b(com.applovin.impl.sdk.utils.i.a(this.c, var1, new JSONObject(), this.b), "type", "undefined", this.b);
         } else {
            return "undefined";
         }
      }

      // $FF: synthetic method
      static void a(f.a var0) {
         var0.c();
      }

      // $FF: synthetic method
      static void a(f.a var0, String var1) {
         var0.e(var1);
      }

      private void b() {
         JSONObject var1 = com.applovin.impl.sdk.utils.i.a(this.c, this.d, (JSONObject)null, this.b);
         String var2 = this.a(this.d);
         if ("adapter".equalsIgnoreCase(var2)) {
            this.a("Starting task for adapter ad...");
            this.e("started to load ad");
            r var6 = this.b.K();
            e var7 = new e(f.this.a, var1, f.this.d, this.b, (Activity)f.this.f.get(), new f$a$1(this, f.this.e, this.b));
            var6.a((com.applovin.impl.sdk.d.a)var7);
         } else {
            StringBuilder var3 = new StringBuilder();
            var3.append("Unable to process ad of unknown type: ");
            var3.append(var2);
            this.d(var3.toString());
            f.this.a(-800);
         }
      }

      private void c() {
         if (this.d < -1 + this.c.length()) {
            StringBuilder var1 = new StringBuilder();
            var1.append("Attempting to load next ad (");
            var1.append(this.d);
            var1.append(") after failure...");
            this.b(var1.toString());
            f.a var5 = f.this.new a(1 + this.d, this.c);
            r.a var6 = com.applovin.impl.mediation.d.c.a(f.this.c);
            this.b.K().a((com.applovin.impl.sdk.d.a)var5, var6);
         } else {
            f.this.b();
         }
      }

      private void e(String var1) {
      }

      public i a() {
         return i.F;
      }

      public void run() {
         if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.fd)) {
            try {
               this.b();
            } catch (Throwable var4) {
               StringBuilder var2 = new StringBuilder();
               var2.append("Encountered error while processing ad number ");
               var2.append(this.d);
               this.a(var2.toString(), var4);
               this.b.M().a(this.a());
               f.this.b();
               return;
            }
         } else {
            this.b();
         }
      }
   }
}
