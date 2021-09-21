package com.applovin.impl.sdk;

import android.text.TextUtils;
import com.applovin.impl.sdk.ad.NativeAdImpl;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.nativeAds.AppLovinNativeAdService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NativeAdServiceImpl implements AppLovinNativeAdService {
   private final j a;
   private final p b;

   NativeAdServiceImpl(j var1) {
      this.a = var1;
      this.b = var1.v();
   }

   private void a(AppLovinNativeAd var1, final AppLovinNativeAdPrecacheListener var2) {
      if (var1.isVideoPrecached()) {
         var2.onNativeAdVideoPreceached(var1);
      } else {
         NativeAdImpl[] var3 = new NativeAdImpl[]{(NativeAdImpl)var1};
         com.applovin.impl.sdk.d.g var4 = new com.applovin.impl.sdk.d.g(Arrays.asList(var3), this.a, new AppLovinNativeAdPrecacheListener() {
            public void onNativeAdImagePrecachingFailed(AppLovinNativeAd var1, int var2x) {
            }

            public void onNativeAdImagesPrecached(AppLovinNativeAd var1) {
            }

            public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd var1, int var2x) {
               NativeAdServiceImpl.this.a(var2, var1, var2x, true);
            }

            public void onNativeAdVideoPreceached(AppLovinNativeAd var1) {
               NativeAdServiceImpl.this.a(var2, var1, true);
            }
         });
         this.a.K().a((com.applovin.impl.sdk.d.a)var4, com.applovin.impl.sdk.d.r.a.h);
      }
   }

   private void a(AppLovinNativeAdLoadListener var1, int var2) {
      if (var1 != null) {
         try {
            var1.onNativeAdsFailedToLoad(var2);
            return;
         } catch (Exception var4) {
            p.c("NativeAdService", "Encountered exception whilst notifying user callback", var4);
         }
      }

   }

   private void a(AppLovinNativeAdLoadListener var1, List var2) {
      if (var1 != null) {
         try {
            var1.onNativeAdsLoaded(var2);
            return;
         } catch (Exception var4) {
            p.c("NativeAdService", "Encountered exception whilst notifying user callback", var4);
         }
      }

   }

   private void a(AppLovinNativeAdPrecacheListener var1, AppLovinNativeAd var2, int var3, boolean var4) {
      if (var1 != null) {
         boolean var10001;
         Exception var10000;
         if (var4) {
            try {
               var1.onNativeAdVideoPrecachingFailed(var2, var3);
               return;
            } catch (Exception var6) {
               var10000 = var6;
               var10001 = false;
            }
         } else {
            try {
               var1.onNativeAdImagePrecachingFailed(var2, var3);
               return;
            } catch (Exception var7) {
               var10000 = var7;
               var10001 = false;
            }
         }

         Exception var5 = var10000;
         p.c("NativeAdService", "Encountered exception whilst notifying user callback", var5);
      }

   }

   private void a(AppLovinNativeAdPrecacheListener var1, AppLovinNativeAd var2, boolean var3) {
      if (var1 != null) {
         boolean var10001;
         Exception var10000;
         if (var3) {
            try {
               var1.onNativeAdVideoPreceached(var2);
               return;
            } catch (Exception var5) {
               var10000 = var5;
               var10001 = false;
            }
         } else {
            try {
               var1.onNativeAdImagesPrecached(var2);
               return;
            } catch (Exception var6) {
               var10000 = var6;
               var10001 = false;
            }
         }

         Exception var4 = var10000;
         p.c("NativeAdService", "Encountered exception whilst notifying user callback", var4);
      }

   }

   private void a(String var1, int var2, final AppLovinNativeAdLoadListener var3) {
      com.applovin.impl.sdk.d.n var4 = new com.applovin.impl.sdk.d.n(var1, var2, this.a, new AppLovinNativeAdLoadListener() {
         public void onNativeAdsFailedToLoad(int var1) {
            NativeAdServiceImpl.this.a(var3, var1);
         }

         public void onNativeAdsLoaded(List var1) {
            NativeAdServiceImpl.this.a(var1, var3);
         }
      });
      this.a.K().a((com.applovin.impl.sdk.d.a)var4, com.applovin.impl.sdk.d.r.a.a);
   }

   private void a(List var1, final AppLovinNativeAdLoadListener var2) {
      int var3 = (Integer)this.a.a(com.applovin.impl.sdk.b.d.dr);
      if (var3 <= 0) {
         if (var2 != null) {
            var2.onNativeAdsLoaded(var1);
            return;
         }
      } else {
         List var4 = (List)var1;
         int var5 = var4.size();
         if (var5 == 0) {
            if (var2 != null) {
               var2.onNativeAdsFailedToLoad(-700);
            }

            return;
         }

         int var6 = Math.min(var3, var5);
         final List var7 = var4.subList(0, var6);
         this.b(var7, new AppLovinNativeAdLoadListener(var4.subList(var6, var5)) {
            // $FF: synthetic field
            final List c;

            {
               this.c = var4;
            }

            public void onNativeAdsFailedToLoad(int var1) {
               AppLovinNativeAdLoadListener var2x = var2;
               if (var2x != null) {
                  var2x.onNativeAdsFailedToLoad(var1);
               }

            }

            public void onNativeAdsLoaded(List var1) {
               NativeAdServiceImpl.this.c(var7, new AppLovinNativeAdLoadListener() {
                  public void onNativeAdsFailedToLoad(int var1) {
                     if (var2 != null) {
                        var2.onNativeAdsFailedToLoad(var1);
                     }

                  }

                  public void onNativeAdsLoaded(List var1) {
                     if (var2 != null) {
                        ArrayList var2x = new ArrayList();
                        var2x.addAll(var7);
                        var2x.addAll(c);
                        var2.onNativeAdsLoaded(var2x);
                     }

                  }
               });
            }
         });
      }

   }

   private void b(List var1, final AppLovinNativeAdLoadListener var2) {
      com.applovin.impl.sdk.d.e var3 = new com.applovin.impl.sdk.d.e(var1, this.a, new AppLovinNativeAdLoadListener() {
         public void onNativeAdsFailedToLoad(int var1) {
            AppLovinNativeAdLoadListener var2x = var2;
            if (var2x != null) {
               var2x.onNativeAdsFailedToLoad(var1);
            }

         }

         public void onNativeAdsLoaded(List var1) {
            AppLovinNativeAdLoadListener var2x = var2;
            if (var2x != null) {
               var2x.onNativeAdsLoaded(var1);
            }

         }
      });
      this.a.K().a((com.applovin.impl.sdk.d.a)var3, com.applovin.impl.sdk.d.r.a.h);
   }

   private void c(List var1, final AppLovinNativeAdLoadListener var2) {
      com.applovin.impl.sdk.d.g var3 = new com.applovin.impl.sdk.d.g(var1, this.a, new AppLovinNativeAdLoadListener() {
         public void onNativeAdsFailedToLoad(int var1) {
            NativeAdServiceImpl.this.a(var2, var1);
         }

         public void onNativeAdsLoaded(List var1) {
            NativeAdServiceImpl.this.a(var2, var1);
         }
      });
      this.a.K().a((com.applovin.impl.sdk.d.a)var3, com.applovin.impl.sdk.d.r.a.h);
   }

   public boolean hasPreloadedAdForZoneId(String var1) {
      if (TextUtils.isEmpty(var1)) {
         p.j("NativeAdService", "Unable to check if ad is preloaded - invalid zone id.");
         return false;
      } else {
         com.applovin.impl.sdk.ad.d var2 = com.applovin.impl.sdk.ad.d.a(var1, this.a);
         return this.a.U().g(var2);
      }
   }

   public void loadNativeAds(int var1, AppLovinNativeAdLoadListener var2) {
      this.loadNativeAds(var1, (String)null, var2);
   }

   public void loadNativeAds(int var1, String var2, AppLovinNativeAdLoadListener var3) {
      if (var1 > 0) {
         this.a.a();
         if (var1 != 1) {
            this.a(var2, var1, var3);
            return;
         }

         com.applovin.impl.sdk.ad.d var7 = com.applovin.impl.sdk.ad.d.b(var2, this.a);
         AppLovinNativeAd var8 = (AppLovinNativeAd)this.a.U().e(var7);
         if (var8 != null) {
            this.a(var3, Arrays.asList(new AppLovinNativeAd[]{var8}));
         } else {
            this.a(var2, 1, var3);
         }

         if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.bg)) {
            this.a.U().i(var7);
            return;
         }
      } else {
         StringBuilder var4 = new StringBuilder();
         var4.append("Requested invalid number of native ads: ");
         var4.append(var1);
         p.j("NativeAdService", var4.toString());
      }

   }

   public void loadNextAd(AppLovinNativeAdLoadListener var1) {
      this.loadNativeAds(1, var1);
   }

   public void precacheResources(AppLovinNativeAd var1, final AppLovinNativeAdPrecacheListener var2) {
      this.a.a();
      if (var1.isImagePrecached()) {
         var2.onNativeAdImagesPrecached(var1);
         this.a(var1, var2);
      } else {
         NativeAdImpl[] var3 = new NativeAdImpl[]{(NativeAdImpl)var1};
         com.applovin.impl.sdk.d.e var4 = new com.applovin.impl.sdk.d.e(Arrays.asList(var3), this.a, new AppLovinNativeAdPrecacheListener() {
            public void onNativeAdImagePrecachingFailed(AppLovinNativeAd var1, int var2x) {
               NativeAdServiceImpl.this.a(var2, var1, var2x, false);
            }

            public void onNativeAdImagesPrecached(AppLovinNativeAd var1) {
               NativeAdServiceImpl.this.a(var2, var1, false);
               NativeAdServiceImpl.this.a(var1, var2);
            }

            public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd var1, int var2x) {
            }

            public void onNativeAdVideoPreceached(AppLovinNativeAd var1) {
            }
         });
         this.a.K().a((com.applovin.impl.sdk.d.a)var4, com.applovin.impl.sdk.d.r.a.h);
      }
   }

   public void preloadAdForZoneId(String var1) {
      if (TextUtils.isEmpty(var1)) {
         p.j("NativeAdService", "Unable to preload zone for invalid zone id.");
      } else {
         this.a.a();
         com.applovin.impl.sdk.ad.d var2 = com.applovin.impl.sdk.ad.d.a(var1, this.a);
         this.a.T().h(var2);
         this.a.T().i(var2);
      }
   }

   public void preloadAds(com.applovin.impl.sdk.ad.d var1) {
      this.a.T().h(var1);
      int var2 = var1.g();
      if (var2 == 0 && this.a.T().b(var1)) {
         var2 = 1;
      }

      this.a.T().b(var1, var2);
   }

   public String toString() {
      return "NativeAdServiceImpl{}";
   }
}
