package com.applovin.impl.mediation.c;

class a$1 implements Runnable {
   // $FF: synthetic field
   final com.applovin.impl.mediation.b.e a;
   // $FF: synthetic field
   final a b;

   a$1(a var1, com.applovin.impl.mediation.b.e var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      a var1 = this.b;
      StringBuilder var2 = new StringBuilder();
      var2.append("Auto-initing adapter: ");
      var2.append(this.a);
      com.applovin.impl.mediation.c.a.a(var1, var2.toString());
      com.applovin.impl.mediation.c.a.b(this.b).x().a(this.a, com.applovin.impl.mediation.c.a.a(this.b));
   }
}
