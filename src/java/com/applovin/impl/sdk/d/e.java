package com.applovin.impl.sdk.d;

import com.applovin.impl.sdk.ad.NativeAdImpl;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import java.util.List;

public class e extends f {
   public e(List var1, com.applovin.impl.sdk.j var2, AppLovinNativeAdLoadListener var3) {
      super("TaskCacheNativeAdImages", var1, var2, var3);
   }

   public e(List var1, com.applovin.impl.sdk.j var2, AppLovinNativeAdPrecacheListener var3) {
      super("TaskCacheNativeAdImages", var1, var2, var3);
   }

   private boolean b(NativeAdImpl var1) {
      this.c("Unable to cache image resource");
      short var2;
      if (!com.applovin.impl.sdk.utils.h.a(this.g())) {
         var2 = -103;
      } else {
         var2 = -201;
      }

      this.a(var1, var2);
      return false;
   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.j;
   }

   protected void a(NativeAdImpl var1) {
      if (this.a != null) {
         this.a.onNativeAdImagesPrecached(var1);
      }

   }

   protected void a(NativeAdImpl var1, int var2) {
      if (this.a != null) {
         this.a.onNativeAdImagePrecachingFailed(var1, var2);
      }

   }

   protected boolean a(NativeAdImpl var1, com.applovin.impl.sdk.n var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("Beginning native ad image caching for #");
      var3.append(var1.getAdId());
      this.a(var3.toString());
      if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.bK)) {
         String var6 = this.a(var1.getSourceIconUrl(), var2, var1.getResourcePrefixes());
         if (var6 == null) {
            return this.b(var1);
         }

         var1.setIconUrl(var6);
         String var7 = this.a(var1.getSourceImageUrl(), var2, var1.getResourcePrefixes());
         if (var7 == null) {
            return this.b(var1);
         }

         var1.setImageUrl(var7);
      } else {
         this.a("Resource caching is disabled, skipping...");
      }

      return true;
   }
}
