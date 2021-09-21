package com.applovin.mediation;

class ApplovinAdapter$1$2 implements Runnable {
   // $FF: synthetic field
   final ApplovinAdapter$1 this$1;
   // $FF: synthetic field
   final int val$code;

   ApplovinAdapter$1$2(ApplovinAdapter$1 var1, int var2) {
      this.this$1 = var1;
      this.val$code = var2;
   }

   public void run() {
      ApplovinAdapter.access$300(this.this$1.this$0).onAdFailedToLoad(this.this$1.this$0, AppLovinUtils.toAdMobErrorCode(this.val$code));
   }
}
