package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.q;
import java.util.HashMap;
import java.util.Map;

public class AppLovinSdkSettings {
   private boolean a;
   private long b;
   private String c;
   private String d;
   private boolean e;
   private final Map localSettings;

   public AppLovinSdkSettings() {
      this((Context)null);
   }

   public AppLovinSdkSettings(Context var1) {
      this.localSettings = new HashMap();
      this.a = q.a(var1);
      this.b = -1L;
      StringBuilder var2 = new StringBuilder();
      var2.append(AppLovinAdSize.INTERSTITIAL.getLabel());
      var2.append(",");
      var2.append(AppLovinAdSize.BANNER.getLabel());
      var2.append(",");
      var2.append(AppLovinAdSize.MREC.getLabel());
      this.c = var2.toString();
      StringBuilder var8 = new StringBuilder();
      var8.append(AppLovinAdType.INCENTIVIZED.getLabel());
      var8.append(",");
      var8.append(AppLovinAdType.REGULAR.getLabel());
      var8.append(",");
      var8.append(AppLovinAdType.NATIVE.getLabel());
      this.d = var8.toString();
   }

   @Deprecated
   public String getAutoPreloadSizes() {
      return this.c;
   }

   @Deprecated
   public String getAutoPreloadTypes() {
      return this.d;
   }

   @Deprecated
   public long getBannerAdRefreshSeconds() {
      return this.b;
   }

   public boolean isMuted() {
      return this.e;
   }

   public boolean isVerboseLoggingEnabled() {
      return this.a;
   }

   @Deprecated
   public void setAutoPreloadSizes(String var1) {
      this.c = var1;
   }

   @Deprecated
   public void setAutoPreloadTypes(String var1) {
      this.d = var1;
   }

   @Deprecated
   public void setBannerAdRefreshSeconds(long var1) {
      this.b = var1;
   }

   public void setMuted(boolean var1) {
      this.e = var1;
   }

   public void setVerboseLogging(boolean var1) {
      if (q.a()) {
         p.j("AppLovinSdkSettings", "Ignoring setting of verbose logging - it is configured from Android manifest already or AppLovinSdkSettings was initialized without a context.");
      } else {
         this.a = var1;
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("AppLovinSdkSettings{isVerboseLoggingEnabled=");
      var1.append(this.a);
      var1.append(", muted=");
      var1.append(this.e);
      var1.append('}');
      return var1.toString();
   }
}
