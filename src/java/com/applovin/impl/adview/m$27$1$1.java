package com.applovin.impl.adview;

class m$27$1$1 implements Runnable {
   // $FF: synthetic field
   final int a;
   // $FF: synthetic field
   final int b;
   // $FF: synthetic field
   final m$27$1 c;

   m$27$1$1(m$27$1 var1, int var2, int var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void run() {
      m var1 = this.c.a.a;
      StringBuilder var2 = new StringBuilder();
      var2.append("Media player error (");
      var2.append(this.a);
      var2.append(",");
      var2.append(this.b);
      var2.append(")");
      var1.handleMediaError(var2.toString());
   }
}
