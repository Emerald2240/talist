package com.applovin.impl.mediation.c;

import com.applovin.impl.sdk.j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;

class f$a$1 extends com.applovin.impl.mediation.d.a {
   // $FF: synthetic field
   final f.a a;

   f$a$1(f.a var1, MaxAdListener var2, j var3) {
      super(var2, var3);
      this.a = var1;
   }

   public void onAdLoadFailed(String var1, int var2) {
      f.a var3 = this.a;
      StringBuilder var4 = new StringBuilder();
      var4.append("failed to load ad: ");
      var4.append(var2);
      f.a.a(var3, var4.toString());
      f.a.a(this.a);
   }

   public void onAdLoaded(MaxAd var1) {
      f.a.a(this.a, "loaded ad");
      f.a(this.a.a, var1);
   }
}
