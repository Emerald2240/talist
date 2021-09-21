package com.applovin.mediation.adapters;

import com.applovin.adview.AppLovinAdView;
import com.applovin.sdk.AppLovinAd;

class AppLovinMediationAdapter$1$1 implements Runnable {
   // $FF: synthetic field
   final <undefinedtype> this$1;
   // $FF: synthetic field
   final AppLovinAd val$appLovinAd;

   AppLovinMediationAdapter$1$1(Object var1, AppLovinAd var2) {
      this.this$1 = var1;
      this.val$appLovinAd = var2;
   }

   public void run() {
      AppLovinMediationAdapter.access$002(this.this$1.this$0, new AppLovinAdView(this.this$1.this$0.getWrappingSdk(), this.val$appLovinAd.getSize(), this.this$1.val$activity));
      AppLovinMediationAdapter.access$000(this.this$1.this$0).setAdDisplayListener(new AppLovinMediationAdapter$1$1$1(this));
      AppLovinMediationAdapter.access$000(this.this$1.this$0).setAdClickListener(new AppLovinMediationAdapter$1$1$2(this));
      AppLovinMediationAdapter.access$000(this.this$1.this$0).setAdViewEventListener(new AppLovinMediationAdapter$1$1$3(this));
      this.this$1.val$listener.onAdViewAdLoaded(AppLovinMediationAdapter.access$000(this.this$1.this$0));
      AppLovinMediationAdapter.access$000(this.this$1.this$0).renderAd(this.val$appLovinAd);
   }
}
