package com.applovin.impl.adview;

class m$29$1 implements Runnable {
   // $FF: synthetic field
   final int a;
   // $FF: synthetic field
   final int b;
   // $FF: synthetic field
   final m$29 c;

   m$29$1(m$29 var1, int var2, int var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void run() {
      m var1 = this.c.a;
      StringBuilder var2 = new StringBuilder();
      var2.append("Video view error (");
      var2.append(this.a);
      var2.append(",");
      var2.append(this.b);
      var1.handleMediaError(var2.toString());
   }
}
