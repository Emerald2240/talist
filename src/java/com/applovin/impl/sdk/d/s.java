package com.applovin.impl.sdk.d;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONArray;
import org.json.JSONObject;

public class s extends a implements AppLovinAdLoadListener {
   private final JSONObject a;
   private final com.applovin.impl.sdk.ad.d c;
   private final com.applovin.impl.sdk.ad.b d;
   private final AppLovinAdLoadListener e;

   public s(JSONObject var1, com.applovin.impl.sdk.ad.d var2, com.applovin.impl.sdk.ad.b var3, AppLovinAdLoadListener var4, com.applovin.impl.sdk.j var5) {
      super("TaskProcessAdResponse", var5);
      if (var1 != null) {
         if (var2 != null) {
            this.a = var1;
            this.c = var2;
            this.d = var3;
            this.e = var4;
         } else {
            throw new IllegalArgumentException("No zone specified");
         }
      } else {
         throw new IllegalArgumentException("No response specified");
      }
   }

   private void a(int var1) {
      com.applovin.impl.sdk.utils.q.a(this.e, this.c, var1, this.b);
   }

   private void a(AppLovinAd var1) {
      try {
         if (this.e != null) {
            this.e.adReceived(var1);
            return;
         }
      } catch (Throwable var4) {
         this.a("Unable process a ad received notification", var4);
         return;
      }

   }

   private void a(JSONObject var1) {
      String var2 = com.applovin.impl.sdk.utils.i.b(var1, "type", "undefined", this.b);
      if ("applovin".equalsIgnoreCase(var2)) {
         this.a((String)"Starting task for AppLovin ad...");
         r var6 = this.b.K();
         u var7 = new u(var1, this.a, this.d, this, this.b);
         var6.a((a)var7);
      } else if ("vast".equalsIgnoreCase(var2)) {
         this.a((String)"Starting task for VAST ad...");
         this.b.K().a((a)t.a(var1, this.a, this.d, this, this.b));
      } else {
         StringBuilder var3 = new StringBuilder();
         var3.append("Unable to process ad of unknown type: ");
         var3.append(var2);
         this.c(var3.toString());
         this.failedToReceiveAd(-800);
      }
   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.r;
   }

   public void adReceived(AppLovinAd var1) {
      this.a(var1);
   }

   public void failedToReceiveAd(int var1) {
      this.a(var1);
   }

   public void run() {
      JSONArray var1 = com.applovin.impl.sdk.utils.i.b(this.a, "ads", new JSONArray(), this.b);
      if (var1.length() > 0) {
         this.a((String)"Processing ad...");
         this.a(com.applovin.impl.sdk.utils.i.a(var1, 0, (JSONObject)(new JSONObject()), this.b));
      } else {
         this.c("No ads were returned from the server");
         com.applovin.impl.sdk.utils.q.a(this.c.a(), this.a, this.b);
         this.a(204);
      }
   }
}
