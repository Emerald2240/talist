package com.applovin.impl.sdk.d;

import com.applovin.impl.sdk.ad.NativeAdImpl;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import java.util.List;

public class g extends f {
   public g(List var1, com.applovin.impl.sdk.j var2, AppLovinNativeAdLoadListener var3) {
      super("TaskCacheNativeAdVideos", var1, var2, var3);
   }

   public g(List var1, com.applovin.impl.sdk.j var2, AppLovinNativeAdPrecacheListener var3) {
      super("TaskCacheNativeAdVideos", var1, var2, var3);
   }

   private boolean b(NativeAdImpl var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Unable to cache video resource ");
      var2.append(var1.getSourceVideoUrl());
      this.c(var2.toString());
      short var5;
      if (!com.applovin.impl.sdk.utils.h.a(this.g())) {
         var5 = -103;
      } else {
         var5 = -202;
      }

      this.a(var1, var5);
      return false;
   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.k;
   }

   protected void a(NativeAdImpl var1) {
      if (this.a != null) {
         this.a.onNativeAdVideoPreceached(var1);
      }

   }

   protected void a(NativeAdImpl var1, int var2) {
      if (this.a != null) {
         this.a.onNativeAdVideoPrecachingFailed(var1, var2);
      }

   }

   protected boolean a(NativeAdImpl var1, com.applovin.impl.sdk.n var2) {
      if (!com.applovin.impl.sdk.utils.n.b(var1.getSourceVideoUrl())) {
         return true;
      } else {
         StringBuilder var3 = new StringBuilder();
         var3.append("Beginning native ad video caching");
         var3.append(var1.getAdId());
         this.a(var3.toString());
         if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.bK)) {
            String var6 = this.a(var1.getSourceVideoUrl(), var2, var1.getResourcePrefixes());
            if (var6 != null) {
               var1.setVideoUrl(var6);
               return true;
            } else {
               return this.b(var1);
            }
         } else {
            this.a("Resource caching is disabled, skipping...");
            return true;
         }
      }
   }
}
