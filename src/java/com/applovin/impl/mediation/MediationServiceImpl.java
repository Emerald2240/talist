package com.applovin.impl.mediation;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.d.r;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MediationServiceImpl {
   private final com.applovin.impl.sdk.j a;
   private final p b;

   public MediationServiceImpl(com.applovin.impl.sdk.j var1) {
      this.a = var1;
      this.b = var1.v();
   }

   // $FF: synthetic method
   static void a(MediationServiceImpl var0, String var1, com.applovin.impl.mediation.b.g var2) {
      var0.a(var1, var2);
   }

   private void a(com.applovin.impl.mediation.b.a var1) {
      p var2 = this.b;
      StringBuilder var3 = new StringBuilder();
      var3.append("Firing ad preload postback for ");
      var3.append(var1.D());
      var2.b("MediationService", var3.toString());
      this.a((String)"mpreload", (com.applovin.impl.mediation.b.e)var1);
   }

   private void a(com.applovin.impl.mediation.b.a var1, e var2, MaxAdListener var3) {
      this.a(var2, var1);
      this.destroyAd(var1);
      com.applovin.impl.sdk.utils.j.a(var3, var1.getAdUnitId(), var2.getErrorCode());
   }

   private void a(e var1, com.applovin.impl.mediation.b.a var2) {
      long var3 = var2.f();
      p var5 = this.b;
      StringBuilder var6 = new StringBuilder();
      var6.append("Firing ad load failure postback with load time: ");
      var6.append(var3);
      var5.b("MediationService", var6.toString());
      HashMap var9 = new HashMap(1);
      var9.put("{LOAD_TIME_MS}", String.valueOf(var3));
      this.a((String)"mlerr", (Map)var9, var1, (com.applovin.impl.mediation.b.e)var2);
   }

   private void a(String var1, com.applovin.impl.mediation.b.e var2) {
      this.a((String)var1, (Map)Collections.EMPTY_MAP, (e)null, (com.applovin.impl.mediation.b.e)var2);
   }

   private void a(String var1, com.applovin.impl.mediation.b.g var2) {
      this.a((String)"serr", (Map)Collections.EMPTY_MAP, new e(var1), (com.applovin.impl.mediation.b.e)var2);
   }

   private void a(String var1, Map var2, com.applovin.impl.mediation.b.e var3) {
      this.a((String)var1, (Map)var2, (e)null, (com.applovin.impl.mediation.b.e)var3);
   }

   private void a(String var1, Map var2, e var3, com.applovin.impl.mediation.b.e var4) {
      HashMap var5 = new HashMap(var2);
      String var6 = var4.N();
      String var7 = "";
      String var8;
      if (var6 != null) {
         var8 = var4.N();
      } else {
         var8 = var7;
      }

      var5.put("{PLACEMENT}", var8);
      if (var4 instanceof com.applovin.impl.mediation.b.c) {
         com.applovin.impl.mediation.b.c var11 = (com.applovin.impl.mediation.b.c)var4;
         if (var11.m() != null) {
            var7 = var11.m();
         }

         var5.put("{PUBLISHER_AD_UNIT_ID}", var7);
      }

      com.applovin.impl.mediation.c.d var10 = new com.applovin.impl.mediation.c.d(var1, var5, var3, var4, this.a);
      this.a.K().a((com.applovin.impl.sdk.d.a)var10, r.a.m);
   }

   private void b(com.applovin.impl.mediation.b.a var1) {
      long var2 = var1.f();
      p var4 = this.b;
      StringBuilder var5 = new StringBuilder();
      var5.append("Firing ad load success postback with load time: ");
      var5.append(var2);
      var4.b("MediationService", var5.toString());
      HashMap var8 = new HashMap(1);
      var8.put("{LOAD_TIME_MS}", String.valueOf(var2));
      this.a((String)"load", (Map)var8, (com.applovin.impl.mediation.b.e)var1);
   }

   private void b(com.applovin.impl.mediation.b.a var1, e var2, MaxAdListener var3) {
      this.a.ac().a(var1, "DID_FAIL_DISPLAY");
      this.maybeScheduleAdDisplayErrorPostback(var2, var1);
      if (var1.h().compareAndSet(false, true)) {
         com.applovin.impl.sdk.utils.j.a((MaxAdListener)var3, (MaxAd)var1, var2.getErrorCode());
      }

   }

   private void c(com.applovin.impl.mediation.b.a var1) {
      this.a((String)"mclick", (com.applovin.impl.mediation.b.e)var1);
   }

   public void collectSignal(MaxAdFormat var1, com.applovin.impl.mediation.b.g var2, Activity var3, com.applovin.impl.mediation.b.f.a var4) {
      if (var2 == null) {
         throw new IllegalArgumentException("No spec specified");
      } else if (var3 != null) {
         if (var4 == null) {
            throw new IllegalArgumentException("No callback specified");
         } else {
            i var5 = this.a.w().a((com.applovin.impl.mediation.b.e)var2);
            String var6;
            if (var5 != null) {
               label26: {
                  MaxAdapterParametersImpl var7 = MaxAdapterParametersImpl.a(var2, var1, var3.getApplicationContext());
                  var5.a((MaxAdapterInitializationParameters)var7, (Activity)var3);
                  MediationServiceImpl$4 var8 = new MediationServiceImpl$4(this, var4, var2, var5);
                  String var11;
                  p var9;
                  StringBuilder var10;
                  if (var2.b()) {
                     if (!this.a.x().a((com.applovin.impl.mediation.b.e)var2)) {
                        p var14 = this.b;
                        StringBuilder var15 = new StringBuilder();
                        var15.append("Skip collecting signal for not-initialized adapter: ");
                        var15.append(var5.b());
                        var14.e("MediationService", var15.toString());
                        var6 = "Adapter not initialized yet";
                        break label26;
                     }

                     var9 = this.b;
                     var10 = new StringBuilder();
                     var11 = "Collecting signal for now-initialized adapter: ";
                  } else {
                     var9 = this.b;
                     var10 = new StringBuilder();
                     var11 = "Collecting signal for adapter: ";
                  }

                  var10.append(var11);
                  var10.append(var5.b());
                  var9.b("MediationService", var10.toString());
                  var5.a(var7, var2, var3, var8);
                  return;
               }
            } else {
               var6 = "Could not load adapter";
            }

            var4.a(com.applovin.impl.mediation.b.f.a(var2, var6));
         }
      } else {
         throw new IllegalArgumentException("No activity specified");
      }
   }

   public void destroyAd(MaxAd var1) {
      if (var1 instanceof com.applovin.impl.mediation.b.a) {
         p var2 = this.b;
         StringBuilder var3 = new StringBuilder();
         var3.append("Destroying ");
         var3.append(var1);
         var2.c("MediationService", var3.toString());
         com.applovin.impl.mediation.b.a var6 = (com.applovin.impl.mediation.b.a)var1;
         i var7 = var6.c();
         if (var7 != null) {
            var7.g();
            var6.i();
         }

      }
   }

   public void loadAd(String var1, MaxAdFormat var2, f var3, boolean var4, Activity var5, final MaxAdListener var6) {
      if (!TextUtils.isEmpty(var1)) {
         if (var5 != null) {
            if (var6 != null) {
               if (!this.a.d()) {
                  p.i("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
               }

               this.a.a();
               final com.applovin.impl.mediation.b.c var7 = this.a.B().a(var2);
               if (var7 != null) {
                  AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                     public void run() {
                        var6.onAdLoaded(var7);
                     }
                  }, var7.k());
               }

               com.applovin.impl.sdk.j var8 = this.a;
               MediationServiceImpl$2 var9 = new MediationServiceImpl$2(this, var3, var1, var2, var5, var6);
               com.applovin.impl.mediation.c.b var10 = new com.applovin.impl.mediation.c.b(var2, var4, var5, var8, var9);
               r.a var11 = com.applovin.impl.mediation.d.c.a(var2);
               this.a.K().a((com.applovin.impl.sdk.d.a)var10, var11);
            } else {
               throw new IllegalArgumentException("No listener specified");
            }
         } else {
            throw new IllegalArgumentException("No activity specified");
         }
      } else {
         throw new IllegalArgumentException("No ad unit ID specified");
      }
   }

   public void loadThirdPartyMediatedAd(String var1, com.applovin.impl.mediation.b.a var2, Activity var3, MaxAdListener var4) {
      if (var2 != null) {
         if (var3 != null) {
            p var5 = this.b;
            StringBuilder var6 = new StringBuilder();
            var6.append("Loading ");
            var6.append(var2);
            var6.append("...");
            var5.b("MediationService", var6.toString());
            this.a.ac().a(var2, "WILL_LOAD");
            this.a(var2);
            i var10 = this.a.w().a((com.applovin.impl.mediation.b.e)var2);
            if (var10 != null) {
               MaxAdapterParametersImpl var16 = MaxAdapterParametersImpl.a(var2, var3.getApplicationContext());
               var10.a((MaxAdapterInitializationParameters)var16, (Activity)var3);
               com.applovin.impl.mediation.b.a var17 = var2.a(var10);
               var10.a(var1, var17);
               var17.g();
               var10.a(var1, var16, var17, var3, new MediationServiceImpl.a(var17, var4));
            } else {
               p var11 = this.b;
               StringBuilder var12 = new StringBuilder();
               var12.append("Failed to load ");
               var12.append(var2);
               var12.append(": adapter not loaded");
               var11.d("MediationService", var12.toString());
               this.a(var2, new e(-5001), var4);
            }
         } else {
            throw new IllegalArgumentException("A valid Activity is required");
         }
      } else {
         throw new IllegalArgumentException("No mediated ad specified");
      }
   }

   public void maybeScheduleAdDisplayErrorPostback(e var1, com.applovin.impl.mediation.b.a var2) {
      this.a((String)"mierr", (Map)Collections.EMPTY_MAP, var1, (com.applovin.impl.mediation.b.e)var2);
   }

   public void maybeScheduleAdapterInitializationPostback(com.applovin.impl.mediation.b.e var1, long var2, MaxAdapter.InitializationStatus var4, String var5) {
      HashMap var6 = new HashMap(3);
      var6.put("{INIT_STATUS}", String.valueOf(var4.getCode()));
      var6.put("{INIT_TIME_MS}", String.valueOf(var2));
      this.a((String)"minit", (Map)var6, new e(var5), (com.applovin.impl.mediation.b.e)var1);
   }

   public void maybeScheduleCallbackAdImpressionPostback(com.applovin.impl.mediation.b.a var1) {
      this.a((String)"mcimp", (com.applovin.impl.mediation.b.e)var1);
   }

   public void maybeScheduleRawAdImpressionPostback(com.applovin.impl.mediation.b.a var1) {
      this.a.ac().a(var1, "WILL_DISPLAY");
      this.a((String)"mimp", (com.applovin.impl.mediation.b.e)var1);
   }

   public void maybeScheduleViewabilityAdImpressionPostback(com.applovin.impl.mediation.b.b var1, long var2) {
      HashMap var4 = new HashMap(1);
      var4.put("{VIEWABILITY_FLAGS}", String.valueOf(var2));
      var4.put("{USED_VIEWABILITY_TIMER}", String.valueOf(var1.r()));
      this.a((String)"mvimp", (Map)var4, (com.applovin.impl.mediation.b.e)var1);
   }

   public void showFullscreenAd(MaxAd var1, String var2, final Activity var3) {
      if (var1 != null) {
         if (var3 != null) {
            if (var1 instanceof com.applovin.impl.mediation.b.c) {
               this.a.Z().a(true);
               final com.applovin.impl.mediation.b.c var10 = (com.applovin.impl.mediation.b.c)var1;
               final i var11 = var10.c();
               if (var11 != null) {
                  var10.d(var2);
                  long var21 = var10.K();
                  p var23 = this.b;
                  StringBuilder var24 = new StringBuilder();
                  var24.append("Showing ad ");
                  var24.append(var1.getAdUnitId());
                  var24.append(" with delay of ");
                  var24.append(var21);
                  var24.append("ms...");
                  var23.c("MediationService", var24.toString());
                  AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                     public void run() {
                        if (var10.getFormat() == MaxAdFormat.REWARDED) {
                           com.applovin.impl.mediation.c.h var1 = new com.applovin.impl.mediation.c.h(var10, MediationServiceImpl.this.a);
                           MediationServiceImpl.this.a.K().a((com.applovin.impl.sdk.d.a)var1, r.a.q);
                        }

                        var11.a((com.applovin.impl.mediation.b.a)var10, (Activity)var3);
                        MediationServiceImpl.this.a.Z().a(false);
                        MediationServiceImpl.this.b.b("MediationService", "Scheduling impression for ad manually...");
                        MediationServiceImpl.this.maybeScheduleRawAdImpressionPostback(var10);
                     }
                  }, var21);
               } else {
                  this.a.Z().a(false);
                  p var12 = this.b;
                  StringBuilder var13 = new StringBuilder();
                  var13.append("Failed to show ");
                  var13.append(var1);
                  var13.append(": adapter not found");
                  var12.d("MediationService", var13.toString());
                  StringBuilder var17 = new StringBuilder();
                  var17.append("There may be an integration problem with the adapter for ad unit id '");
                  var17.append(var10.getAdUnitId());
                  var17.append("'. Please check if you have a supported version of that SDK integrated into your project.");
                  p.j("MediationService", var17.toString());
                  throw new IllegalStateException("Could not find adapter for provided ad");
               }
            } else {
               StringBuilder var4 = new StringBuilder();
               var4.append("Unable to show ad for '");
               var4.append(var1.getAdUnitId());
               var4.append("': only REWARDED or INTERSTITIAL ads are eligible for showFullscreenAd(). ");
               var4.append(var1.getFormat());
               var4.append(" ad was provided.");
               p.j("MediationService", var4.toString());
               throw new IllegalArgumentException("Provided ad is not a MediatedFullscreenAd");
            }
         } else {
            throw new IllegalArgumentException("No activity specified");
         }
      } else {
         throw new IllegalArgumentException("No ad specified");
      }
   }

   private class a implements d, MaxAdViewAdListener, MaxRewardedAdListener {
      private final com.applovin.impl.mediation.b.a b;
      private final MaxAdListener c;

      private a(com.applovin.impl.mediation.b.a var2, MaxAdListener var3) {
         this.b = var2;
         this.c = var3;
      }

      // $FF: synthetic method
      a(com.applovin.impl.mediation.b.a var2, MaxAdListener var3, Object var4) {
         this(var2, var3);
      }

      // $FF: synthetic method
      static MaxAdListener a(MediationServiceImpl.a var0) {
         return var0.c;
      }

      public void a(MaxAd var1, e var2) {
         MediationServiceImpl.this.b(this.b, var2, this.c);
         if (var1.getFormat() == MaxAdFormat.REWARDED && var1 instanceof com.applovin.impl.mediation.b.c) {
            ((com.applovin.impl.mediation.b.c)var1).u();
         }

      }

      public void a(String var1, e var2) {
         MediationServiceImpl.this.a(this.b, var2, this.c);
      }

      public void onAdClicked(MaxAd var1) {
         MediationServiceImpl.this.a.ac().a((com.applovin.impl.mediation.b.a)var1, "DID_CLICKED");
         MediationServiceImpl.this.c(this.b);
         com.applovin.impl.sdk.utils.j.d(this.c, var1);
      }

      public void onAdCollapsed(MaxAd var1) {
         com.applovin.impl.sdk.utils.j.h(this.c, var1);
      }

      public void onAdDisplayFailed(MaxAd var1, int var2) {
         MediationServiceImpl.this.b(this.b, new e(var2), this.c);
      }

      public void onAdDisplayed(MaxAd var1) {
         MediationServiceImpl.this.b.b("MediationService", "Scheduling impression for ad via callback...");
         MediationServiceImpl.this.maybeScheduleCallbackAdImpressionPostback(this.b);
         if (var1.getFormat() == MaxAdFormat.INTERSTITIAL || var1.getFormat() == MaxAdFormat.REWARDED) {
            MediationServiceImpl.this.a.Z().c();
         }

         com.applovin.impl.sdk.utils.j.b(this.c, var1);
      }

      public void onAdExpanded(MaxAd var1) {
         com.applovin.impl.sdk.utils.j.g(this.c, var1);
      }

      public void onAdHidden(MaxAd var1) {
         MediationServiceImpl.this.a.ac().a((com.applovin.impl.mediation.b.a)var1, "DID_HIDE");
         long var2;
         if (var1 instanceof com.applovin.impl.mediation.b.e) {
            var2 = ((com.applovin.impl.mediation.b.e)var1).M();
         } else {
            var2 = 0L;
         }

         AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable(var1) {
            // $FF: synthetic field
            final MaxAd a;
            // $FF: synthetic field
            final MediationServiceImpl.a b;

            {
               this.b = var1;
               this.a = var2;
            }

            public void run() {
               if (this.a.getFormat() == MaxAdFormat.INTERSTITIAL || this.a.getFormat() == MaxAdFormat.REWARDED) {
                  MediationServiceImpl.a(this.b.a).Z().d();
               }

               com.applovin.impl.sdk.utils.j.c(MediationServiceImpl.a.a(this.b), this.a);
            }
         }, var2);
      }

      public void onAdLoadFailed(String var1, int var2) {
         MediationServiceImpl.this.a(this.b, new e(var2), this.c);
      }

      public void onAdLoaded(MaxAd var1) {
         MediationServiceImpl.this.b(this.b);
         com.applovin.impl.sdk.utils.j.a(this.c, var1);
      }

      public void onRewardedVideoCompleted(MaxAd var1) {
         com.applovin.impl.sdk.utils.j.f(this.c, var1);
      }

      public void onRewardedVideoStarted(MaxAd var1) {
         com.applovin.impl.sdk.utils.j.e(this.c, var1);
      }

      public void onUserRewarded(MaxAd var1, MaxReward var2) {
         com.applovin.impl.sdk.utils.j.a(this.c, var1, var2);
         com.applovin.impl.mediation.c.g var3 = new com.applovin.impl.mediation.c.g((com.applovin.impl.mediation.b.c)var1, MediationServiceImpl.this.a);
         MediationServiceImpl.this.a.K().a((com.applovin.impl.sdk.d.a)var3, r.a.q);
      }
   }
}
