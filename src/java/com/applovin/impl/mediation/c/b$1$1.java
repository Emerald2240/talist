package com.applovin.impl.mediation.c;

class b$1$1 implements com.applovin.impl.mediation.b.f.a {
   // $FF: synthetic field
   final b$1 a;

   b$1$1(b$1 var1) {
      this.a = var1;
   }

   public void a(com.applovin.impl.mediation.b.f var1) {
      if (this.a.b.get() && var1 != null) {
         this.a.c.add(var1);
      }

      this.a.d.countDown();
   }
}
