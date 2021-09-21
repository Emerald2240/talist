package com.applovin.impl.mediation.c;

class b$2 implements Runnable {
   // $FF: synthetic field
   final com.applovin.impl.mediation.b.g a;
   // $FF: synthetic field
   final com.applovin.impl.mediation.b.f.a b;
   // $FF: synthetic field
   final b c;

   b$2(b var1, com.applovin.impl.mediation.b.g var2, com.applovin.impl.mediation.b.f.a var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void run() {
      com.applovin.impl.mediation.c.b.c(this.c).y().collectSignal(com.applovin.impl.mediation.c.b.a(this.c), this.a, com.applovin.impl.mediation.c.b.b(this.c), this.b);
   }
}
