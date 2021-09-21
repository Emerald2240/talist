package com.applovin.impl.sdk.c;

import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.d.x;

class c$1 extends x {
   // $FF: synthetic field
   final c a;

   c$1(c var1, com.applovin.impl.sdk.network.b var2, com.applovin.impl.sdk.j var3) {
      super(var2, var3);
      this.a = var1;
   }

   public void a(int var1) {
      p var2 = com.applovin.impl.sdk.c.c.a(this.a);
      StringBuilder var3 = new StringBuilder();
      var3.append("Failed to submitted ad stats: ");
      var3.append(var1);
      var2.e("AdEventStatsManager", var3.toString());
   }

   public void a(Object var1, int var2) {
      p var3 = com.applovin.impl.sdk.c.c.a(this.a);
      StringBuilder var4 = new StringBuilder();
      var4.append("Ad stats submitted: ");
      var4.append(var2);
      var3.b("AdEventStatsManager", var4.toString());
   }
}
