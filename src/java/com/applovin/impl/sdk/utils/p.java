package com.applovin.impl.sdk.utils;

import android.content.Context;
import java.util.Locale;
import java.util.UUID;

public final class p {
   private final com.applovin.impl.sdk.j a;
   private String b;
   private final String c;
   private final String d;

   public p(com.applovin.impl.sdk.j var1) {
      this.a = var1;
      this.b = this.d();
      String var2 = (String)com.applovin.impl.sdk.b.g.b(com.applovin.impl.sdk.b.f.d, (Object)null, (Context)var1.D());
      this.c = this.a(com.applovin.impl.sdk.b.f.e, var2);
      String var3 = (String)var1.a(com.applovin.impl.sdk.b.d.X);
      this.d = this.a(com.applovin.impl.sdk.b.f.f, var3);
   }

   private String a(com.applovin.impl.sdk.b.f var1, String var2) {
      String var3 = (String)com.applovin.impl.sdk.b.g.b(var1, (Object)null, (Context)this.a.D());
      if (n.b(var3)) {
         return var3;
      } else {
         if (!n.b(var2)) {
            var2 = UUID.randomUUID().toString().toLowerCase(Locale.US);
         }

         com.applovin.impl.sdk.b.g.a((com.applovin.impl.sdk.b.f)var1, var2, (Context)this.a.D());
         return var2;
      }
   }

   private String d() {
      if (!(Boolean)this.a.a(com.applovin.impl.sdk.b.d.dZ)) {
         this.a.b(com.applovin.impl.sdk.b.f.c);
      }

      String var1 = (String)this.a.a(com.applovin.impl.sdk.b.f.c);
      if (n.b(var1)) {
         com.applovin.impl.sdk.p var2 = this.a.v();
         StringBuilder var3 = new StringBuilder();
         var3.append("Using identifier (");
         var3.append(var1);
         var3.append(") from previous session");
         var2.b("AppLovinSdk", var3.toString());
         this.b = var1;
      }

      return null;
   }

   public String a() {
      return this.b;
   }

   public void a(String var1) {
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.dZ)) {
         this.a.a((com.applovin.impl.sdk.b.f)com.applovin.impl.sdk.b.f.c, (Object)var1);
      }

      this.b = var1;
   }

   public String b() {
      return this.c;
   }

   public String c() {
      return this.d;
   }
}
