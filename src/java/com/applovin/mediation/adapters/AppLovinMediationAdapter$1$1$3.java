package com.applovin.mediation.adapters;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinAd;

class AppLovinMediationAdapter$1$1$3 implements AppLovinAdViewEventListener {
   // $FF: synthetic field
   final AppLovinMediationAdapter$1$1 this$2;

   AppLovinMediationAdapter$1$1$3(AppLovinMediationAdapter$1$1 var1) {
      this.this$2 = var1;
   }

   public void adClosedFullscreen(AppLovinAd var1, AppLovinAdView var2) {
      this.this$2.this$1.this$0.log("Banner collapsed");
      this.this$2.this$1.val$listener.onAdViewAdCollapsed();
   }

   public void adFailedToDisplay(AppLovinAd var1, AppLovinAdView var2, AppLovinAdViewDisplayErrorCode var3) {
      MaxAdapterError var4 = AppLovinMediationAdapter.access$100(var3);
      AppLovinMediationAdapter var5 = this.this$2.this$1.this$0;
      StringBuilder var6 = new StringBuilder();
      var6.append("Banner failed to display with error: ");
      var6.append(var4);
      var5.log(var6.toString());
      this.this$2.this$1.val$listener.onAdViewAdDisplayFailed(var4);
   }

   public void adLeftApplication(AppLovinAd var1, AppLovinAdView var2) {
   }

   public void adOpenedFullscreen(AppLovinAd var1, AppLovinAdView var2) {
      this.this$2.this$1.this$0.log("Banner expanded");
      this.this$2.this$1.val$listener.onAdViewAdExpanded();
   }
}
