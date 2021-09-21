package com.applovin.impl.sdk;

import android.app.Activity;

class u$1 extends com.applovin.impl.sdk.utils.a {
   // $FF: synthetic field
   final u a;

   u$1(u var1) {
      this.a = var1;
   }

   public void onActivityResumed(Activity var1) {
      super.onActivityResumed(var1);
      u.a(this.a);
   }
}
