package com.applovin.impl.mediation.c;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.c.i;
import com.applovin.impl.sdk.d.r;
import com.applovin.impl.sdk.utils.n;
import com.applovin.impl.sdk.utils.q;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class d extends com.applovin.impl.sdk.d.a {
   private final String a;
   private final String c;
   private final com.applovin.impl.mediation.b.e d;
   private final Map e;
   private final Map f;
   private final com.applovin.impl.mediation.e g;

   public d(String var1, Map var2, com.applovin.impl.mediation.e var3, com.applovin.impl.mediation.b.e var4, j var5) {
      super("TaskFireMediationPostbacks", var5);
      this.a = var1;
      StringBuilder var6 = new StringBuilder();
      var6.append(var1);
      var6.append("_urls");
      this.c = var6.toString();
      this.e = q.b(var2);
      if (var3 == null) {
         var3 = com.applovin.impl.mediation.e.EMPTY;
      }

      this.g = var3;
      this.d = var4;
      HashMap var9 = new HashMap(4);
      var9.put("Ad-Network-Name", var4.D());
      if (var4 instanceof com.applovin.impl.mediation.b.a) {
         com.applovin.impl.mediation.b.a var11 = (com.applovin.impl.mediation.b.a)var4;
         var9.put("Ad-Unit-Id", var11.getAdUnitId());
         var9.put("Ad-Format", var11.getFormat().getLabel());
         if (var11 instanceof com.applovin.impl.mediation.b.c) {
            var9.put("Ad-Is-Fallback", String.valueOf(((com.applovin.impl.mediation.b.c)var11).j()));
         }
      }

      this.f = var9;
   }

   private com.applovin.impl.sdk.network.g a(String var1, com.applovin.impl.mediation.e var2, Map var3) {
      String var4 = this.a(var1, var2);
      return com.applovin.impl.sdk.network.g.b(this.e()).d(var4).c(false).c(var3).b();
   }

   private String a(String var1, com.applovin.impl.mediation.e var2) {
      String var4;
      int var3;
      if (var2 instanceof MaxAdapterError) {
         MaxAdapterError var5 = (MaxAdapterError)var2;
         var3 = var5.getThirdPartySdkErrorCode();
         var4 = var5.getThirdPartySdkErrorMessage();
      } else {
         var3 = 0;
         var4 = "";
      }

      return var1.replace("{ERROR_CODE}", String.valueOf(var2.getErrorCode())).replace("{ERROR_MESSAGE}", n.e(var2.getErrorMessage())).replace("{THIRD_PARTY_SDK_ERROR_CODE}", String.valueOf(var3)).replace("{THIRD_PARTY_SDK_ERROR_MESSAGE}", n.e(var4));
   }

   private com.applovin.impl.sdk.network.f b(String var1, com.applovin.impl.mediation.e var2, Map var3) {
      String var4 = this.a(var1, var2);
      return com.applovin.impl.sdk.network.f.l().a(var4).a(false).b(var3).a();
   }

   private void b() {
      List var1 = this.d.a(this.c, this.e);
      if (!var1.isEmpty()) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Firing ");
         var2.append(var1.size());
         var2.append(" '");
         var2.append(this.a);
         var2.append("' postback(s)");
         this.a(var2.toString());
         Iterator var8 = var1.iterator();

         while(var8.hasNext()) {
            com.applovin.impl.sdk.network.g var9 = this.a((String)var8.next(), this.g, this.f);
            this.e().R().dispatchPostbackRequest(var9, r.a.m, new AppLovinPostbackListener() {
               public void onPostbackFailure(String var1, int var2) {
                  d var3 = d.this;
                  StringBuilder var4 = new StringBuilder();
                  var4.append("Failed to fire postback with code: ");
                  var4.append(var2);
                  var4.append(" and url: ");
                  var4.append(var1);
                  var3.d(var4.toString());
               }

               public void onPostbackSuccess(String var1) {
                  d var2 = d.this;
                  StringBuilder var3 = new StringBuilder();
                  var3.append("Successfully fired postback: ");
                  var3.append(var1);
                  var2.a(var3.toString());
               }
            });
         }
      } else {
         StringBuilder var10 = new StringBuilder();
         var10.append("No postbacks to fire for event: ");
         var10.append(this.a);
         this.a(var10.toString());
      }

   }

   private void c() {
      List var1 = this.d.a(this.c, this.e);
      if (!var1.isEmpty()) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Firing ");
         var2.append(var1.size());
         var2.append(" '");
         var2.append(this.a);
         var2.append("' persistent postback(s)");
         this.a(var2.toString());
         Iterator var8 = var1.iterator();

         while(var8.hasNext()) {
            com.applovin.impl.sdk.network.f var9 = this.b((String)var8.next(), this.g, this.f);
            this.e().N().a(var9);
         }
      } else {
         StringBuilder var10 = new StringBuilder();
         var10.append("No persistent postbacks to fire for event: ");
         var10.append(this.a);
         this.a(var10.toString());
      }

   }

   public i a() {
      return i.I;
   }

   public void run() {
      if ((Boolean)this.e().a(com.applovin.impl.sdk.b.c.j)) {
         this.c();
      } else {
         this.b();
      }
   }
}
