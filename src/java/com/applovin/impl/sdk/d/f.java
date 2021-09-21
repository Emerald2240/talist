package com.applovin.impl.sdk.d;

import com.applovin.impl.sdk.ad.NativeAdImpl;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import java.util.Iterator;
import java.util.List;

abstract class f extends a {
   protected final AppLovinNativeAdPrecacheListener a;
   private final List c;
   private final AppLovinNativeAdLoadListener d;
   private int e;

   f(String var1, List var2, com.applovin.impl.sdk.j var3, AppLovinNativeAdLoadListener var4) {
      super(var1, var3);
      this.c = var2;
      this.d = var4;
      this.a = null;
   }

   f(String var1, List var2, com.applovin.impl.sdk.j var3, AppLovinNativeAdPrecacheListener var4) {
      super(var1, var3);
      if (var2 != null) {
         this.c = var2;
         this.d = null;
         this.a = var4;
      } else {
         throw new IllegalArgumentException("Native ads cannot be null");
      }
   }

   private void a(int var1) {
      AppLovinNativeAdLoadListener var2 = this.d;
      if (var2 != null) {
         var2.onNativeAdsFailedToLoad(var1);
      }

   }

   private void a(List var1) {
      AppLovinNativeAdLoadListener var2 = this.d;
      if (var2 != null) {
         var2.onNativeAdsLoaded(var1);
      }

   }

   protected String a(String var1, com.applovin.impl.sdk.n var2, List var3) {
      if (!com.applovin.impl.sdk.utils.n.b(var1)) {
         this.a((String)"Asked to cache file with null/empty URL, nothing to do.");
         return null;
      } else if (!com.applovin.impl.sdk.utils.q.a(var1, var3)) {
         StringBuilder var4 = new StringBuilder();
         var4.append("Domain is not whitelisted, skipping precache for URL ");
         var4.append(var1);
         this.a((String)var4.toString());
         return null;
      } else {
         Exception var10000;
         label33: {
            String var11;
            boolean var10001;
            try {
               var11 = var2.a(this.g(), var1, (String)null, var3, true, true, (com.applovin.impl.sdk.c.e)null);
            } catch (Exception var14) {
               var10000 = var14;
               var10001 = false;
               break label33;
            }

            if (var11 != null) {
               return var11;
            }

            try {
               StringBuilder var12 = new StringBuilder();
               var12.append("Unable to cache icon resource ");
               var12.append(var1);
               this.c(var12.toString());
               return null;
            } catch (Exception var13) {
               var10000 = var13;
               var10001 = false;
            }
         }

         Exception var7 = var10000;
         StringBuilder var8 = new StringBuilder();
         var8.append("Unable to cache icon resource ");
         var8.append(var1);
         this.a(var8.toString(), var7);
         return null;
      }
   }

   protected abstract void a(NativeAdImpl var1);

   protected abstract void a(NativeAdImpl var1, int var2);

   protected abstract boolean a(NativeAdImpl var1, com.applovin.impl.sdk.n var2);

   public void run() {
      Iterator var1 = this.c.iterator();

      while(var1.hasNext()) {
         NativeAdImpl var4 = (NativeAdImpl)var1.next();
         this.a((String)"Beginning resource caching phase...");
         if (this.a(var4, this.b.V())) {
            ++this.e;
            this.a(var4);
         } else {
            this.d("Unable to cache resources");
         }
      }

      Throwable var10000;
      label233: {
         boolean var10001;
         List var3;
         label242: {
            try {
               if (this.e == this.c.size()) {
                  var3 = (List)this.c;
                  break label242;
               }
            } catch (Throwable var23) {
               var10000 = var23;
               var10001 = false;
               break label233;
            }

            try {
               if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.dq)) {
                  this.d("Mismatch between successful populations and requested size");
                  this.a(-6);
                  return;
               }
            } catch (Throwable var24) {
               var10000 = var24;
               var10001 = false;
               break label233;
            }

            try {
               var3 = (List)this.c;
            } catch (Throwable var22) {
               var10000 = var22;
               var10001 = false;
               break label233;
            }
         }

         label219:
         try {
            this.a(var3);
            return;
         } catch (Throwable var21) {
            var10000 = var21;
            var10001 = false;
            break label219;
         }
      }

      Throwable var2 = var10000;
      com.applovin.impl.sdk.p.c(this.f(), "Encountered exception while notifying publisher code", var2);
   }
}
