package com.applovin.impl.adview;

class m$12$1 implements Runnable {
   // $FF: synthetic field
   final <undefinedtype> a;

   m$12$1(Object var1) {
      this.a = var1;
   }

   public void run() {
      com.applovin.impl.sdk.p.j("AppLovinInterstitialActivity", "Dismissing on-screen ad due to app relaunched via launcher.");
      this.a.a.dismiss();
   }
}
