package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.d.r;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import java.util.concurrent.atomic.AtomicBoolean;

public class i {
   private final Handler a = new Handler(Looper.getMainLooper());
   private final com.applovin.impl.sdk.j b;
   private final p c;
   private final String d;
   private final com.applovin.impl.mediation.b.e e;
   private final String f;
   private MaxAdapter g;
   private String h;
   private com.applovin.impl.mediation.b.a i;
   private View j;
   private final <undefinedtype> k = new MaxAdViewAdapterListener(null) {
      private d b;

      // $FF: synthetic method
      static d a(Object var0) {
         return var0.b;
      }

      private void a(d var1) {
         if (var1 != null) {
            this.b = var1;
         } else {
            throw new IllegalArgumentException("No listener specified");
         }
      }

      private void a(String var1) {
         i.this.o.set(true);
         this.a(var1, this.b, new Runnable() {
            // $FF: synthetic field
            final <undefinedtype> a;

            {
               this.a = var1;
            }

            public void run() {
               if (com.applovin.impl.mediation.i.f(this.a.a).compareAndSet(false, true)) {
                  null.a(this.a).onAdLoaded(com.applovin.impl.mediation.i.j(this.a.a));
               }

            }
         });
      }

      private void a(String var1, int var2) {
         this.a(var1, new MaxAdapterError(var2));
      }

      private void a(String var1, MaxAdListener var2, Runnable var3) {
         i.this.a.post(new Runnable(var3, var2, var1) {
            // $FF: synthetic field
            final Runnable a;
            // $FF: synthetic field
            final MaxAdListener b;
            // $FF: synthetic field
            final String c;
            // $FF: synthetic field
            final <undefinedtype> d;

            {
               this.d = var1;
               this.a = var2;
               this.b = var3;
               this.c = var4;
            }

            public void run() {
               try {
                  this.a.run();
               } catch (Exception var6) {
                  MaxAdListener var2 = this.b;
                  String var3;
                  if (var2 != null) {
                     var3 = var2.getClass().getName();
                  } else {
                     var3 = null;
                  }

                  p var4 = com.applovin.impl.mediation.i.e(this.d.a);
                  StringBuilder var5 = new StringBuilder();
                  var5.append("Failed to forward call (");
                  var5.append(this.c);
                  var5.append(") to ");
                  var5.append(var3);
                  var4.b("MediationAdapterWrapper", var5.toString(), var6);
               }
            }
         });
      }

      private void a(String var1, MaxAdapterError var2) {
         this.a(var1, this.b, new Runnable(var2) {
            // $FF: synthetic field
            final MaxAdapterError a;
            // $FF: synthetic field
            final <undefinedtype> b;

            {
               this.b = var1;
               this.a = var2;
            }

            public void run() {
               if (com.applovin.impl.mediation.i.f(this.b.a).compareAndSet(false, true)) {
                  null.a(this.b).a((String)com.applovin.impl.mediation.i.k(this.b.a), this.a);
               }

            }
         });
      }

      private void b(String var1) {
         if (i.this.i.h().compareAndSet(false, true)) {
            this.a(var1, this.b, new Runnable() {
               // $FF: synthetic field
               final <undefinedtype> a;

               {
                  this.a = var1;
               }

               public void run() {
                  null.a(this.a).onAdDisplayed(com.applovin.impl.mediation.i.j(this.a.a));
               }
            });
         }

      }

      private void b(String var1, int var2) {
         this.b(var1, new MaxAdapterError(var2));
      }

      private void b(String var1, MaxAdapterError var2) {
         this.a(var1, this.b, new Runnable(var2) {
            // $FF: synthetic field
            final MaxAdapterError a;
            // $FF: synthetic field
            final <undefinedtype> b;

            {
               this.b = var1;
               this.a = var2;
            }

            public void run() {
               null.a(this.b).a((MaxAd)com.applovin.impl.mediation.i.j(this.b.a), this.a);
            }
         });
      }

      public void onAdViewAdClicked() {
         p var1 = i.this.c;
         StringBuilder var2 = new StringBuilder();
         var2.append(i.this.f);
         var2.append(": adview ad clicked");
         var1.c("MediationAdapterWrapper", var2.toString());
         this.a("onAdViewAdClicked", this.b, new Runnable() {
            // $FF: synthetic field
            final <undefinedtype> a;

            {
               this.a = var1;
            }

            public void run() {
               null.a(this.a).onAdClicked(com.applovin.impl.mediation.i.j(this.a.a));
            }
         });
      }

      public void onAdViewAdCollapsed() {
         p var1 = i.this.c;
         StringBuilder var2 = new StringBuilder();
         var2.append(i.this.f);
         var2.append(": adview ad collapsed");
         var1.c("MediationAdapterWrapper", var2.toString());
         this.a("onAdViewAdCollapsed", this.b, new Runnable() {
            // $FF: synthetic field
            final <undefinedtype> a;

            {
               this.a = var1;
            }

            public void run() {
               if (null.a(this.a) instanceof MaxAdViewAdListener) {
                  ((MaxAdViewAdListener)null.a(this.a)).onAdCollapsed(com.applovin.impl.mediation.i.j(this.a.a));
               }

            }
         });
      }

      public void onAdViewAdDisplayFailed(MaxAdapterError var1) {
         p var2 = i.this.c;
         StringBuilder var3 = new StringBuilder();
         var3.append(i.this.f);
         var3.append(": adview ad failed to display with code: ");
         var3.append(var1);
         var2.d("MediationAdapterWrapper", var3.toString());
         this.b("onAdViewAdDisplayFailed", var1);
      }

      public void onAdViewAdDisplayed() {
         p var1 = i.this.c;
         StringBuilder var2 = new StringBuilder();
         var2.append(i.this.f);
         var2.append(": adview ad displayed");
         var1.c("MediationAdapterWrapper", var2.toString());
         this.b("onAdViewAdDisplayed");
      }

      public void onAdViewAdExpanded() {
         p var1 = i.this.c;
         StringBuilder var2 = new StringBuilder();
         var2.append(i.this.f);
         var2.append(": adview ad expanded");
         var1.c("MediationAdapterWrapper", var2.toString());
         this.a("onAdViewAdExpanded", this.b, new Runnable() {
            // $FF: synthetic field
            final <undefinedtype> a;

            {
               this.a = var1;
            }

            public void run() {
               if (null.a(this.a) instanceof MaxAdViewAdListener) {
                  ((MaxAdViewAdListener)null.a(this.a)).onAdExpanded(com.applovin.impl.mediation.i.j(this.a.a));
               }

            }
         });
      }

      public void onAdViewAdHidden() {
         p var1 = i.this.c;
         StringBuilder var2 = new StringBuilder();
         var2.append(i.this.f);
         var2.append(": adview ad hidden");
         var1.c("MediationAdapterWrapper", var2.toString());
         this.a("onAdViewAdHidden", this.b, new Runnable() {
            // $FF: synthetic field
            final <undefinedtype> a;

            {
               this.a = var1;
            }

            public void run() {
               null.a(this.a).onAdHidden(com.applovin.impl.mediation.i.j(this.a.a));
            }
         });
      }

      public void onAdViewAdLoadFailed(MaxAdapterError var1) {
         p var2 = i.this.c;
         StringBuilder var3 = new StringBuilder();
         var3.append(i.this.f);
         var3.append(": adview ad ad failed to load with code: ");
         var3.append(var1);
         var2.d("MediationAdapterWrapper", var3.toString());
         this.a("onAdViewAdLoadFailed", var1);
      }

      public void onAdViewAdLoaded(View var1) {
         p var2 = i.this.c;
         StringBuilder var3 = new StringBuilder();
         var3.append(i.this.f);
         var3.append(": adview ad loaded");
         var2.c("MediationAdapterWrapper", var3.toString());
         i.this.j = var1;
         this.a("onAdViewAdLoaded");
      }

      public void onInterstitialAdClicked() {
         p var1 = i.this.c;
         StringBuilder var2 = new StringBuilder();
         var2.append(i.this.f);
         var2.append(": interstitial ad clicked");
         var1.c("MediationAdapterWrapper", var2.toString());
         this.a("onInterstitialAdClicked", this.b, new Runnable() {
            // $FF: synthetic field
            final <undefinedtype> a;

            {
               this.a = var1;
            }

            public void run() {
               null.a(this.a).onAdClicked(com.applovin.impl.mediation.i.j(this.a.a));
            }
         });
      }

      public void onInterstitialAdDisplayFailed(MaxAdapterError var1) {
         p var2 = i.this.c;
         StringBuilder var3 = new StringBuilder();
         var3.append(i.this.f);
         var3.append(": interstitial ad failed to display with code ");
         var3.append(var1);
         var2.d("MediationAdapterWrapper", var3.toString());
         this.b("onInterstitialAdDisplayFailed", var1);
      }

      public void onInterstitialAdDisplayed() {
         p var1 = i.this.c;
         StringBuilder var2 = new StringBuilder();
         var2.append(i.this.f);
         var2.append(": interstitial ad displayed");
         var1.c("MediationAdapterWrapper", var2.toString());
         this.b("onInterstitialAdDisplayed");
      }

      public void onInterstitialAdHidden() {
         p var1 = i.this.c;
         StringBuilder var2 = new StringBuilder();
         var2.append(i.this.f);
         var2.append(": interstitial ad hidden");
         var1.c("MediationAdapterWrapper", var2.toString());
         this.a("onInterstitialAdHidden", this.b, new Runnable() {
            // $FF: synthetic field
            final <undefinedtype> a;

            {
               this.a = var1;
            }

            public void run() {
               null.a(this.a).onAdHidden(com.applovin.impl.mediation.i.j(this.a.a));
            }
         });
      }

      public void onInterstitialAdLoadFailed(MaxAdapterError var1) {
         p var2 = i.this.c;
         StringBuilder var3 = new StringBuilder();
         var3.append(i.this.f);
         var3.append(": interstitial ad failed to load with error ");
         var3.append(var1);
         var2.d("MediationAdapterWrapper", var3.toString());
         this.a("onInterstitialAdLoadFailed", var1);
      }

      public void onInterstitialAdLoaded() {
         p var1 = i.this.c;
         StringBuilder var2 = new StringBuilder();
         var2.append(i.this.f);
         var2.append(": interstitial ad loaded");
         var1.c("MediationAdapterWrapper", var2.toString());
         this.a("onInterstitialAdLoaded");
      }

      public void onRewardedAdClicked() {
         p var1 = i.this.c;
         StringBuilder var2 = new StringBuilder();
         var2.append(i.this.f);
         var2.append(": rewarded ad clicked");
         var1.c("MediationAdapterWrapper", var2.toString());
         this.a("onRewardedAdClicked", this.b, new Runnable() {
            // $FF: synthetic field
            final <undefinedtype> a;

            {
               this.a = var1;
            }

            public void run() {
               null.a(this.a).onAdClicked(com.applovin.impl.mediation.i.j(this.a.a));
            }
         });
      }

      public void onRewardedAdDisplayFailed(MaxAdapterError var1) {
         p var2 = i.this.c;
         StringBuilder var3 = new StringBuilder();
         var3.append(i.this.f);
         var3.append(": rewarded ad display failed with error: ");
         var3.append(var1);
         var2.d("MediationAdapterWrapper", var3.toString());
         this.b("onRewardedAdDisplayFailed", var1);
      }

      public void onRewardedAdDisplayed() {
         p var1 = i.this.c;
         StringBuilder var2 = new StringBuilder();
         var2.append(i.this.f);
         var2.append(": rewarded ad displayed");
         var1.c("MediationAdapterWrapper", var2.toString());
         this.b("onRewardedAdDisplayed");
      }

      public void onRewardedAdHidden() {
         p var1 = i.this.c;
         StringBuilder var2 = new StringBuilder();
         var2.append(i.this.f);
         var2.append(": rewarded ad hidden");
         var1.c("MediationAdapterWrapper", var2.toString());
         this.a("onRewardedAdHidden", this.b, new Runnable() {
            // $FF: synthetic field
            final <undefinedtype> a;

            {
               this.a = var1;
            }

            public void run() {
               null.a(this.a).onAdHidden(com.applovin.impl.mediation.i.j(this.a.a));
            }
         });
      }

      public void onRewardedAdLoadFailed(MaxAdapterError var1) {
         p var2 = i.this.c;
         StringBuilder var3 = new StringBuilder();
         var3.append(i.this.f);
         var3.append(": rewarded ad failed to load with code: ");
         var3.append(var1);
         var2.d("MediationAdapterWrapper", var3.toString());
         this.a("onRewardedAdLoadFailed", var1);
      }

      public void onRewardedAdLoaded() {
         p var1 = i.this.c;
         StringBuilder var2 = new StringBuilder();
         var2.append(i.this.f);
         var2.append(": rewarded ad loaded");
         var1.c("MediationAdapterWrapper", var2.toString());
         this.a("onRewardedAdLoaded");
      }

      public void onRewardedAdVideoCompleted() {
         p var1 = i.this.c;
         StringBuilder var2 = new StringBuilder();
         var2.append(i.this.f);
         var2.append(": rewarded video completed");
         var1.c("MediationAdapterWrapper", var2.toString());
         this.a("onRewardedAdVideoCompleted", this.b, new Runnable() {
            // $FF: synthetic field
            final <undefinedtype> a;

            {
               this.a = var1;
            }

            public void run() {
               if (null.a(this.a) instanceof MaxRewardedAdListener) {
                  ((MaxRewardedAdListener)null.a(this.a)).onRewardedVideoCompleted(com.applovin.impl.mediation.i.j(this.a.a));
               }

            }
         });
      }

      public void onRewardedAdVideoStarted() {
         p var1 = i.this.c;
         StringBuilder var2 = new StringBuilder();
         var2.append(i.this.f);
         var2.append(": rewarded video started");
         var1.c("MediationAdapterWrapper", var2.toString());
         this.a("onRewardedAdVideoStarted", this.b, new Runnable() {
            // $FF: synthetic field
            final <undefinedtype> a;

            {
               this.a = var1;
            }

            public void run() {
               if (null.a(this.a) instanceof MaxRewardedAdListener) {
                  ((MaxRewardedAdListener)null.a(this.a)).onRewardedVideoStarted(com.applovin.impl.mediation.i.j(this.a.a));
               }

            }
         });
      }

      public void onUserRewarded(MaxReward var1) {
         p var2 = i.this.c;
         StringBuilder var3 = new StringBuilder();
         var3.append(i.this.f);
         var3.append(": user was rewarded: ");
         var3.append(var1);
         var2.c("MediationAdapterWrapper", var3.toString());
         this.a("onUserRewarded", this.b, new Runnable(var1) {
            // $FF: synthetic field
            final MaxReward a;
            // $FF: synthetic field
            final <undefinedtype> b;

            {
               this.b = var1;
               this.a = var2;
            }

            public void run() {
               if (null.a(this.b) instanceof MaxRewardedAdListener) {
                  ((MaxRewardedAdListener)null.a(this.b)).onUserRewarded(com.applovin.impl.mediation.i.j(this.b.a), this.a);
               }

            }
         });
      }
   };
   private MaxAdapterResponseParameters l;
   private final AtomicBoolean m = new AtomicBoolean(true);
   private final AtomicBoolean n = new AtomicBoolean(false);
   private final AtomicBoolean o = new AtomicBoolean(false);

   i(com.applovin.impl.mediation.b.e var1, MaxAdapter var2, com.applovin.impl.sdk.j var3) {
      if (var1 != null) {
         if (var2 != null) {
            if (var3 != null) {
               this.d = var1.D();
               this.g = var2;
               this.b = var3;
               this.c = var3.v();
               this.e = var1;
               this.f = var2.getClass().getSimpleName();
            } else {
               throw new IllegalArgumentException("No sdk specified");
            }
         } else {
            throw new IllegalArgumentException("No adapter specified");
         }
      } else {
         throw new IllegalArgumentException("No adapter name specified");
      }
   }

   // $FF: synthetic method
   static void a(i var0, String var1, i.b var2) {
      var0.a(var1, var2);
   }

   private void a(String var1) {
      p var2 = this.c;
      StringBuilder var3 = new StringBuilder();
      var3.append("Marking ");
      var3.append(this.f);
      var3.append(" as disabled due to: ");
      var3.append(var1);
      var2.c("MediationAdapterWrapper", var3.toString());
      this.m.set(false);
   }

   private void a(String var1, i.b var2) {
      if (var2.c.compareAndSet(false, true) && var2.b != null) {
         var2.b.onSignalCollected(var1);
      }

   }

   private void a(final String var1, final Runnable var2) {
      Runnable var3 = new Runnable() {
         public void run() {
            try {
               p var13 = i.this.c;
               StringBuilder var14 = new StringBuilder();
               var14.append(i.this.f);
               var14.append(": running ");
               var14.append(var1);
               var14.append("...");
               var13.b("MediationAdapterWrapper", var14.toString());
               var2.run();
               p var19 = i.this.c;
               StringBuilder var20 = new StringBuilder();
               var20.append(i.this.f);
               var20.append(": finished ");
               var20.append(var1);
               var20.append("");
               var19.b("MediationAdapterWrapper", var20.toString());
            } catch (Throwable var22) {
               p var2x = i.this.c;
               StringBuilder var3 = new StringBuilder();
               var3.append("Unable to run adapter operation ");
               var3.append(var1);
               var3.append(", marking ");
               var3.append(i.this.f);
               var3.append(" as disabled");
               var2x.b("MediationAdapterWrapper", var3.toString(), var22);
               i var9 = i.this;
               StringBuilder var10 = new StringBuilder();
               var10.append("fail_");
               var10.append(var1);
               var9.a(var10.toString());
               return;
            }
         }
      };
      if (this.e.F()) {
         this.a.post(var3);
      } else {
         var3.run();
      }
   }

   // $FF: synthetic method
   static void b(i var0, String var1, i.b var2) {
      var0.b(var1, var2);
   }

   private void b(String var1, i.b var2) {
      if (var2.c.compareAndSet(false, true) && var2.b != null) {
         var2.b.onSignalCollectionFailed(var1);
      }

   }

   // $FF: synthetic method
   static String k(i var0) {
      return var0.h;
   }

   public View a() {
      return this.j;
   }

   void a(final com.applovin.impl.mediation.b.a var1, final Activity var2) {
      if (var1 != null) {
         if (var1.c() == null) {
            this.k.b("ad_show", -5201);
         } else if (var1.c() == this) {
            if (var2 != null) {
               if (!this.m.get()) {
                  StringBuilder var3 = new StringBuilder();
                  var3.append("Mediation adapter '");
                  var3.append(this.f);
                  var3.append("' is disabled. Showing ads with this adapter is disabled.");
                  p.j("MediationAdapterWrapper", var3.toString());
                  this.k.b("ad_show", -5103);
               } else if (!this.d()) {
                  StringBuilder var7 = new StringBuilder();
                  var7.append("Mediation adapter '");
                  var7.append(this.f);
                  var7.append("' does not have an ad loaded. Please load an ad first");
                  p.j("MediationAdapterWrapper", var7.toString());
                  this.k.b("ad_show", -5002);
               } else {
                  final Runnable var17;
                  if (var1.getFormat() == MaxAdFormat.INTERSTITIAL) {
                     if (!(this.g instanceof MaxInterstitialAdapter)) {
                        StringBuilder var22 = new StringBuilder();
                        var22.append("Mediation adapter '");
                        var22.append(this.f);
                        var22.append("' is not an interstitial adapter.");
                        p.j("MediationAdapterWrapper", var22.toString());
                        this.k.b("showFullscreenAd", -5104);
                        return;
                     }

                     var17 = new Runnable() {
                        public void run() {
                           ((MaxInterstitialAdapter)i.this.g).showInterstitialAd(i.this.l, var2, i.this.k);
                        }
                     };
                  } else {
                     if (var1.getFormat() != MaxAdFormat.REWARDED) {
                        StringBuilder var11 = new StringBuilder();
                        var11.append("Failed to show ");
                        var11.append(var1);
                        var11.append(": ");
                        var11.append(var1.getFormat());
                        var11.append(" is not a supported ad format");
                        p.j("MediationAdapterWrapper", var11.toString());
                        this.k.b("showFullscreenAd", -5104);
                        return;
                     }

                     if (!(this.g instanceof MaxRewardedAdapter)) {
                        StringBuilder var18 = new StringBuilder();
                        var18.append("Mediation adapter '");
                        var18.append(this.f);
                        var18.append("' is not an incentivized adapter.");
                        p.j("MediationAdapterWrapper", var18.toString());
                        this.k.b("showFullscreenAd", -5104);
                        return;
                     }

                     var17 = new Runnable() {
                        public void run() {
                           ((MaxRewardedAdapter)i.this.g).showRewardedAd(i.this.l, var2, i.this.k);
                        }
                     };
                  }

                  this.a("ad_render", new Runnable() {
                     public void run() {
                        try {
                           var17.run();
                        } catch (Throwable var5) {
                           p var2 = i.this.c;
                           StringBuilder var3 = new StringBuilder();
                           var3.append("Failed to start displaying ad");
                           var3.append(var1);
                           var2.b("MediationAdapterWrapper", var3.toString(), var5);
                           i.this.k.b("ad_render", -5200);
                           return;
                        }
                     }
                  });
               }
            } else {
               throw new IllegalArgumentException("No activity specified");
            }
         } else {
            throw new IllegalArgumentException("Mediated ad belongs to a different adapter");
         }
      } else {
         throw new IllegalArgumentException("No mediated ad specified");
      }
   }

   void a(final MaxAdapterInitializationParameters var1, final Activity var2) {
      this.a("initialize", new Runnable() {
         public void run() {
            long var1x = SystemClock.elapsedRealtime();
            i.this.g.initialize(var1, var2, new i$1$1(this, var1x));
         }
      });
   }

   void a(final MaxAdapterSignalCollectionParameters var1, final com.applovin.impl.mediation.b.g var2, final Activity var3, MaxSignalCollectionListener var4) {
      if (var4 != null) {
         if (!this.m.get()) {
            StringBuilder var5 = new StringBuilder();
            var5.append("Mediation adapter '");
            var5.append(this.f);
            var5.append("' is disabled. Signal collection ads with this adapter is disabled.");
            p.j("MediationAdapterWrapper", var5.toString());
            StringBuilder var9 = new StringBuilder();
            var9.append("The adapter (");
            var9.append(this.f);
            var9.append(") is disabled");
            var4.onSignalCollectionFailed(var9.toString());
         } else {
            final i.b var13 = new i.b(var2, var4);
            MaxAdapter var14 = this.g;
            if (var14 instanceof MaxSignalProvider) {
               final MaxSignalProvider var19 = (MaxSignalProvider)var14;
               Runnable var20 = new Runnable() {
                  public void run() {
                     // $FF: Couldn't be decompiled
                  }
               };
               this.a("collect_signal", var20);
            } else {
               StringBuilder var15 = new StringBuilder();
               var15.append("The adapter (");
               var15.append(this.f);
               var15.append(") does not support signal collection");
               this.b(var15.toString(), var13);
            }
         }
      } else {
         throw new IllegalArgumentException("No callback specified");
      }
   }

   void a(String var1, com.applovin.impl.mediation.b.a var2) {
      this.h = var1;
      this.i = var2;
   }

   void a(String var1, final MaxAdapterResponseParameters var2, final com.applovin.impl.mediation.b.a var3, final Activity var4, d var5) {
      if (var3 != null) {
         if (!this.m.get()) {
            StringBuilder var6 = new StringBuilder();
            var6.append("Mediation adapter '");
            var6.append(this.f);
            var6.append("' was disabled due to earlier failures. Loading ads with this adapter is disabled.");
            p.j("MediationAdapterWrapper", var6.toString());
            var5.onAdLoadFailed(var1, -5103);
         } else {
            this.l = var2;
            this.k.a(var5);
            final Runnable var10;
            if (var3.getFormat() == MaxAdFormat.INTERSTITIAL) {
               if (!(this.g instanceof MaxInterstitialAdapter)) {
                  StringBuilder var25 = new StringBuilder();
                  var25.append("Mediation adapter '");
                  var25.append(this.f);
                  var25.append("' is not an interstitial adapter.");
                  p.j("MediationAdapterWrapper", var25.toString());
                  this.k.a("loadAd", -5104);
                  return;
               }

               var10 = new Runnable() {
                  public void run() {
                     ((MaxInterstitialAdapter)i.this.g).loadInterstitialAd(var2, var4, i.this.k);
                  }
               };
            } else if (var3.getFormat() == MaxAdFormat.REWARDED) {
               if (!(this.g instanceof MaxRewardedAdapter)) {
                  StringBuilder var21 = new StringBuilder();
                  var21.append("Mediation adapter '");
                  var21.append(this.f);
                  var21.append("' is not an incentivized adapter.");
                  p.j("MediationAdapterWrapper", var21.toString());
                  this.k.a("loadAd", -5104);
                  return;
               }

               var10 = new Runnable() {
                  public void run() {
                     ((MaxRewardedAdapter)i.this.g).loadRewardedAd(var2, var4, i.this.k);
                  }
               };
            } else {
               if (var3.getFormat() != MaxAdFormat.BANNER && var3.getFormat() != MaxAdFormat.LEADER && var3.getFormat() != MaxAdFormat.MREC) {
                  StringBuilder var15 = new StringBuilder();
                  var15.append("Failed to load ");
                  var15.append(var3);
                  var15.append(": ");
                  var15.append(var3.getFormat());
                  var15.append(" is not a supported ad format");
                  p.j("MediationAdapterWrapper", var15.toString());
                  this.k.a("loadAd", -5501);
                  return;
               }

               if (!(this.g instanceof MaxAdViewAdapter)) {
                  StringBuilder var11 = new StringBuilder();
                  var11.append("Mediation adapter '");
                  var11.append(this.f);
                  var11.append("' is not an adview-based adapter.");
                  p.j("MediationAdapterWrapper", var11.toString());
                  this.k.a("loadAd", -5104);
                  return;
               }

               var10 = new Runnable() {
                  public void run() {
                     ((MaxAdViewAdapter)i.this.g).loadAdViewAd(var2, var3.getFormat(), var4, i.this.k);
                  }
               };
            }

            this.a("ad_load", new Runnable() {
               public void run() {
                  label46:
                  try {
                     var10.run();
                  } catch (Throwable var22) {
                     p var2 = i.this.c;
                     StringBuilder var3x = new StringBuilder();
                     var3x.append("Failed start loading ");
                     var3x.append(var3);
                     var2.b("MediationAdapterWrapper", var3x.toString(), var22);
                     i.this.k.a("loadAd", -1);
                     break label46;
                  }

                  if (!i.this.n.get()) {
                     long var6 = i.this.e.H();
                     if (var6 == 0L) {
                        p var19 = i.this.c;
                        StringBuilder var20 = new StringBuilder();
                        var20.append("Failing ad ");
                        var20.append(var3);
                        var20.append(" since it has 0 timeout");
                        var19.b("MediationAdapterWrapper", var20.toString());
                        i.this.k.a("loadAd", -5102);
                        return;
                     }

                     if (var6 > 0L) {
                        p var13 = i.this.c;
                        StringBuilder var14 = new StringBuilder();
                        var14.append("Setting timeout ");
                        var14.append(var6);
                        var14.append("ms. for ");
                        var14.append(var3);
                        var13.b("MediationAdapterWrapper", var14.toString());
                        i.this.b.K().a(new com.applovin.impl.sdk.d.a(null) {
                           // $FF: synthetic field
                           final i a;

                           private {
                              super("TaskTimeoutMediatedAd", com.applovin.impl.mediation.i.b(var1));
                              this.a = var1;
                           }

                           // $FF: synthetic method
                           {
                              this();
                           }

                           public com.applovin.impl.sdk.c.i a() {
                              return com.applovin.impl.sdk.c.i.G;
                           }

                           public void run() {
                              if (!com.applovin.impl.mediation.i.i(this.a).get()) {
                                 StringBuilder var1 = new StringBuilder();
                                 var1.append(com.applovin.impl.mediation.i.h(this.a));
                                 var1.append(" is timing out ");
                                 var1.append(com.applovin.impl.mediation.i.j(this.a));
                                 var1.append("...");
                                 this.d(var1.toString());
                                 this.b.A().a(com.applovin.impl.mediation.i.j(this.a));
                                 null.a(com.applovin.impl.mediation.i.d(this.a), this.f(), -5101);
                              }

                           }
                        }, r.a.k, var6);
                        return;
                     }

                     p var8 = i.this.c;
                     StringBuilder var9 = new StringBuilder();
                     var9.append("Negative timeout set for ");
                     var9.append(var3);
                     var9.append(", not scheduling a timeout");
                     var8.b("MediationAdapterWrapper", var9.toString());
                  }

               }
            });
         }
      } else {
         throw new IllegalArgumentException("No mediated ad specified");
      }
   }

   public String b() {
      return this.d;
   }

   public boolean c() {
      return this.m.get();
   }

   public boolean d() {
      return this.n.get() && this.o.get();
   }

   public String e() {
      MaxAdapter var1 = this.g;
      if (var1 != null) {
         try {
            String var8 = var1.getSdkVersion();
            return var8;
         } catch (Throwable var10) {
            p var3 = this.c;
            StringBuilder var4 = new StringBuilder();
            var4.append("Unable to get adapter's SDK version, marking ");
            var4.append(this);
            var4.append(" as disabled");
            var3.b("MediationAdapterWrapper", var4.toString(), var10);
            this.a("fail_version");
            return null;
         }
      } else {
         return null;
      }
   }

   public String f() {
      MaxAdapter var1 = this.g;
      if (var1 != null) {
         try {
            String var8 = var1.getAdapterVersion();
            return var8;
         } catch (Throwable var10) {
            p var3 = this.c;
            StringBuilder var4 = new StringBuilder();
            var4.append("Unable to get adapter version, marking ");
            var4.append(this);
            var4.append(" as disabled");
            var3.b("MediationAdapterWrapper", var4.toString(), var10);
            this.a("fail_version");
            return null;
         }
      } else {
         return null;
      }
   }

   void g() {
      this.a("destroy", new Runnable() {
         public void run() {
            i.this.a("destroy");
            i.this.g.onDestroy();
            i.this.g = null;
         }
      });
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MediationAdapterWrapper{adapterTag='");
      var1.append(this.f);
      var1.append("'");
      var1.append('}');
      return var1.toString();
   }

   private static class b {
      private final com.applovin.impl.mediation.b.g a;
      private final MaxSignalCollectionListener b;
      private final AtomicBoolean c = new AtomicBoolean();

      b(com.applovin.impl.mediation.b.g var1, MaxSignalCollectionListener var2) {
         this.a = var1;
         this.b = var2;
      }

      // $FF: synthetic method
      static com.applovin.impl.mediation.b.g c(i.b var0) {
         return var0.a;
      }
   }
}
