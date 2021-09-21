package com.applovin.impl.sdk.d;

class aa$1 extends x {
   // $FF: synthetic field
   final aa a;

   aa$1(aa var1, com.applovin.impl.sdk.network.b var2, com.applovin.impl.sdk.j var3) {
      super(var2, var3);
      this.a = var1;
   }

   public void a(int var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Unable to resolve VAST wrapper. Server returned ");
      var2.append(var1);
      this.d(var2.toString());
      aa.a(this.a, var1);
   }

   public void a(com.applovin.impl.sdk.utils.s var1, int var2) {
      t var3 = t.a(var1, aa.a(this.a), aa.b(this.a), this.a.b);
      this.b.K().a((a)var3);
   }
}
