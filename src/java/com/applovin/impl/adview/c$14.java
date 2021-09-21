package com.applovin.impl.adview;

class c$14 implements Runnable {
   // $FF: synthetic field
   final com.applovin.impl.sdk.ad.f a;
   // $FF: synthetic field
   final c b;

   c$14(c var1, com.applovin.impl.sdk.ad.f var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      boolean var1 = this.a.av();
      this.b.getSettings().setMediaPlaybackRequiresUserGesture(var1);
   }
}
