package com.applovin.impl.sdk.d;

import com.applovin.sdk.AppLovinAdLoadListener;

class aa extends a {
   private com.applovin.impl.a.c a;
   private final AppLovinAdLoadListener c;

   aa(com.applovin.impl.a.c var1, AppLovinAdLoadListener var2, com.applovin.impl.sdk.j var3) {
      super("TaskResolveVastWrapper", var3);
      this.c = var2;
      this.a = var1;
   }

   // $FF: synthetic method
   static com.applovin.impl.a.c a(aa var0) {
      return var0.a;
   }

   private void a(int var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Failed to resolve VAST wrapper due to error code ");
      var2.append(var1);
      this.d(var2.toString());
      if (var1 == -103) {
         com.applovin.impl.sdk.utils.q.a(this.c, this.a.g(), var1, this.b);
      } else {
         com.applovin.impl.a.d var5;
         if (var1 == -102) {
            var5 = com.applovin.impl.a.d.d;
         } else {
            var5 = com.applovin.impl.a.d.c;
         }

         com.applovin.impl.a.i.a(this.a, this.c, var5, var1, this.b);
      }
   }

   // $FF: synthetic method
   static void a(aa var0, int var1) {
      var0.a(var1);
   }

   // $FF: synthetic method
   static AppLovinAdLoadListener b(aa var0) {
      return var0.c;
   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.y;
   }

   public void run() {
      String var1 = com.applovin.impl.a.i.a(this.a);
      if (com.applovin.impl.sdk.utils.n.b(var1)) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Resolving VAST ad with depth ");
         var2.append(this.a.a());
         var2.append(" at ");
         var2.append(var1);
         this.a(var2.toString());

         try {
            aa$1 var7 = new aa$1(this, com.applovin.impl.sdk.network.b.a(this.b).a(var1).b("GET").a((Object)com.applovin.impl.sdk.utils.s.a).a((Integer)this.b.a(com.applovin.impl.sdk.b.d.eP)).b((Integer)this.b.a(com.applovin.impl.sdk.b.d.eQ)).a(false).a(), this.b);
            this.b.K().a((a)var7);
         } catch (Throwable var10) {
            this.a("Unable to resolve VAST wrapper", var10);
            this.a(-1);
            this.b.M().a(this.a());
            return;
         }
      } else {
         this.d("Resolving VAST failed. Could not find resolution URL");
         this.a(-1);
      }
   }
}
