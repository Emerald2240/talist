package com.applovin.impl.sdk.d;

import com.applovin.sdk.AppLovinPostbackListener;

public class j extends a {
   private final com.applovin.impl.sdk.network.g a;
   private final AppLovinPostbackListener c;
   private final r.a d;

   public j(com.applovin.impl.sdk.network.g var1, r.a var2, com.applovin.impl.sdk.j var3, AppLovinPostbackListener var4) {
      super("TaskDispatchPostback", var3);
      if (var1 != null) {
         this.a = var1;
         this.c = var4;
         this.d = var2;
      } else {
         throw new IllegalArgumentException("No request specified");
      }
   }

   // $FF: synthetic method
   static com.applovin.impl.sdk.network.g a(j var0) {
      return var0.a;
   }

   // $FF: synthetic method
   static AppLovinPostbackListener b(j var0) {
      return var0.c;
   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.c;
   }

   public void run() {
      String var1 = this.a.a();
      if (!com.applovin.impl.sdk.utils.n.b(var1)) {
         this.b("Requested URL is not valid; nothing to do...");
         AppLovinPostbackListener var3 = this.c;
         if (var3 != null) {
            var3.onPostbackFailure(var1, -900);
         }

      } else {
         j$1 var2 = new j$1(this, this.a, this.e(), var1);
         var2.a(this.d);
         this.e().K().a((a)var2);
      }
   }
}
