package com.applovin.impl.mediation.c;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.utils.n;
import com.applovin.mediation.MaxAdFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends com.applovin.impl.sdk.d.a {
   private static String a = null;
   private final MaxAdFormat c;
   private final boolean d;
   private final Activity e;
   private final <undefinedtype> f;

   static {
      try {
         JSONArray var0 = new JSONArray();
         var0.put(a("APPLOVIN_NETWORK", "com.applovin.mediation.adapters.AppLovinMediationAdapter"));
         a("FACEBOOK_NETWORK", "com.applovin.mediation.adapters.FacebookMediationAdapter").put("run_on_ui_thread", false);
         JSONObject var4 = new JSONObject();
         var4.put("signal_providers", var0);
         a = var4.toString();
      } catch (JSONException var5) {
      }
   }

   public b(MaxAdFormat var1, boolean var2, Activity var3, j var4, Object var5) {
      super("TaskCollectSignals", var4);
      this.c = var1;
      this.d = var2;
      this.e = var3;
      this.f = var5;
   }

   // $FF: synthetic method
   static MaxAdFormat a(b var0) {
      return var0.c;
   }

   private String a(String var1, com.applovin.impl.sdk.b.d var2) {
      if (TextUtils.isEmpty(var1)) {
         return "";
      } else {
         int var3 = (Integer)this.b.a(var2);
         return var3 > 0 ? var1.substring(0, Math.min(var1.length(), var3)) : "";
      }
   }

   private static JSONObject a(String var0, String var1) throws JSONException {
      JSONObject var2 = new JSONObject();
      var2.put("name", var0);
      var2.put("class", var1);
      var2.put("adapter_timeout_ms", 30000);
      var2.put("max_signal_length", 32768);
      var2.put("scode", "");
      return var2;
   }

   private void a(com.applovin.impl.mediation.b.g var1, com.applovin.impl.mediation.b.f.a var2) {
      b$2 var3 = new b$2(this, var1, var2);
      if (var1.F()) {
         StringBuilder var4 = new StringBuilder();
         var4.append("Running signal collection for ");
         var4.append(var1);
         var4.append(" on the main thread");
         this.a((String)var4.toString());
         this.e.runOnUiThread(var3);
      } else {
         StringBuilder var8 = new StringBuilder();
         var8.append("Running signal collection for ");
         var8.append(var1);
         var8.append(" on the background thread");
         this.a((String)var8.toString());
         var3.run();
      }
   }

   // $FF: synthetic method
   static void a(b var0, com.applovin.impl.mediation.b.g var1, com.applovin.impl.mediation.b.f.a var2) {
      var0.a(var1, var2);
   }

   private void a(Collection var1) {
      JSONArray var2 = new JSONArray();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         com.applovin.impl.mediation.b.f var4 = (com.applovin.impl.mediation.b.f)var3.next();

         JSONException var10000;
         label60: {
            String var13;
            JSONObject var5;
            boolean var10001;
            JSONObject var12;
            String var14;
            com.applovin.impl.mediation.b.g var7;
            label61: {
               label62: {
                  try {
                     var5 = new JSONObject();
                     var7 = var4.a();
                     var5.put("name", var7.D());
                     var5.put("class", var7.C());
                     var5.put("adapter_version", this.a(var4.c(), com.applovin.impl.sdk.b.c.l));
                     var5.put("sdk_version", this.a(var4.b(), com.applovin.impl.sdk.b.c.m));
                     var12 = new JSONObject();
                     if (n.b(var4.e())) {
                        break label62;
                     }
                  } catch (JSONException var23) {
                     var10000 = var23;
                     var10001 = false;
                     break label60;
                  }

                  var13 = "signal";

                  try {
                     var14 = this.a(var4.d(), com.applovin.impl.sdk.b.c.n);
                     break label61;
                  } catch (JSONException var21) {
                     var10000 = var21;
                     var10001 = false;
                     break label60;
                  }
               }

               var13 = "error_message";

               try {
                  var14 = var4.e();
               } catch (JSONException var22) {
                  var10000 = var22;
                  var10001 = false;
                  break label60;
               }
            }

            try {
               var12.put(var13, var14);
            } catch (JSONException var20) {
               var10000 = var20;
               var10001 = false;
               break label60;
            }

            try {
               var5.put("data", var12);
               var2.put(var5);
               StringBuilder var18 = new StringBuilder();
               var18.append("Collected signal from ");
               var18.append(var7);
               this.a((String)var18.toString());
               continue;
            } catch (JSONException var19) {
               var10000 = var19;
               var10001 = false;
            }
         }

         JSONException var6 = var10000;
         this.a((String)"Failed to create signal data", (Throwable)var6);
      }

      this.a(var2);
   }

   private void a(JSONArray var1) {
      <undefinedtype> var2 = this.f;
      if (var2 != null) {
         var2.a(var1);
      }

   }

   private void a(JSONArray var1, JSONObject var2) throws JSONException, InterruptedException {
      StringBuilder var3 = new StringBuilder();
      var3.append("Collecting signals from ");
      var3.append(var1.length());
      var3.append(" signal providers(s)...");
      this.a((String)var3.toString());
      List var7 = com.applovin.impl.sdk.utils.e.a(var1.length());
      AtomicBoolean var8 = new AtomicBoolean(true);
      CountDownLatch var9 = new CountDownLatch(var1.length());
      ScheduledExecutorService var10 = this.b.K().b();

      for(int var11 = 0; var11 < var1.length(); ++var11) {
         com.applovin.impl.mediation.b.g var12 = new com.applovin.impl.mediation.b.g(var1.getJSONObject(var11), var2, this.b);
         b$1 var13 = new b$1(this, var12, var8, var7, var9);
         var10.execute(var13);
      }

      var9.await((Long)this.b.a(com.applovin.impl.sdk.b.c.k), TimeUnit.MILLISECONDS);
      var8.set(false);
      this.a((Collection)var7);
   }

   // $FF: synthetic method
   static Activity b(b var0) {
      return var0.e;
   }

   private void b(String var1, Throwable var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("No signals collected: ");
      var3.append(var1);
      this.a((String)var3.toString(), (Throwable)var2);
      this.a(new JSONArray());
   }

   // $FF: synthetic method
   static j c(b var0) {
      return var0.b;
   }

   public i a() {
      return i.B;
   }

   public void run() {
      // $FF: Couldn't be decompiled
   }
}
