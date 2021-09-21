package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinSdkConfiguration;

public class SdkConfigurationImpl implements AppLovinSdkConfiguration {
   private final j a;

   public SdkConfigurationImpl(j var1) {
      this.a = var1;
   }

   public AppLovinSdkConfiguration.ConsentDialogState getConsentDialogState() {
      String var1 = (String)this.a.a(com.applovin.impl.sdk.b.d.fi);
      if ("applies".equalsIgnoreCase(var1)) {
         return AppLovinSdkConfiguration.ConsentDialogState.APPLIES;
      } else {
         return "does_not_apply".equalsIgnoreCase(var1) ? AppLovinSdkConfiguration.ConsentDialogState.DOES_NOT_APPLY : AppLovinSdkConfiguration.ConsentDialogState.UNKNOWN;
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("AppLovinSdkConfiguration{consentDialogState=");
      var1.append(this.getConsentDialogState());
      var1.append('}');
      return var1.toString();
   }
}
