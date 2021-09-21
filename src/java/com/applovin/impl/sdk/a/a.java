package com.applovin.impl.sdk.a;

import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.ad.f;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.ad.i;
import com.applovin.impl.sdk.d.ad;
import com.applovin.impl.sdk.d.r;
import com.applovin.impl.sdk.d.y;
import com.applovin.impl.sdk.utils.n;
import com.applovin.impl.sdk.utils.q;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.SoftReference;
import java.util.Map;

public class a {
   protected final j a;
   protected final AppLovinAdServiceImpl b;
   private AppLovinAd c;
   private String d;
   private SoftReference e;
   private final Object f = new Object();
   private volatile String g;
   private volatile boolean h = false;

   public a(String var1, AppLovinSdk var2) {
      this.a = q.a(var2);
      this.b = (AppLovinAdServiceImpl)var2.getAdService();
      this.d = var1;
   }

   private void a(AppLovinAdBase var1, Context var2, AppLovinAdRewardListener var3, AppLovinAdVideoPlaybackListener var4, AppLovinAdDisplayListener var5, AppLovinAdClickListener var6) {
      if (!var1.getType().equals(AppLovinAdType.INCENTIVIZED)) {
         p var10 = this.a.v();
         StringBuilder var11 = new StringBuilder();
         var11.append("Failed to render an ad of type ");
         var11.append(var1.getType());
         var11.append(" in an Incentivized Ad interstitial.");
         var10.e("IncentivizedAdController", var11.toString());
         this.a(var1, var4, var5);
      } else {
         AppLovinAd var7 = q.a((AppLovinAd)var1, (j)this.a);
         if (var7 != null) {
            AppLovinInterstitialAdDialog var8 = AppLovinInterstitialAd.create(this.a.S(), var2);
            i var9 = new i(var3, var4, var5, var6, (a$1)null) {
               private final AppLovinAdDisplayListener b;
               private final AppLovinAdClickListener c;
               private final AppLovinAdVideoPlaybackListener d;
               private final AppLovinAdRewardListener e;

               private {
                  this.b = var4;
                  this.c = var5;
                  this.d = var3;
                  this.e = var2;
               }

               private void a(f var1) {
                  if (!n.b(a.this.e()) || !a.this.h) {
                     var1.aI();
                     String var3;
                     short var2;
                     if (a.this.h) {
                        var2 = -500;
                        var3 = "network_timeout";
                     } else {
                        var2 = -600;
                        var3 = "user_closed_video";
                     }

                     var1.a(com.applovin.impl.sdk.a.c.a(var3));
                     com.applovin.impl.sdk.utils.j.a((AppLovinAdRewardListener)this.e, (AppLovinAd)var1, var2);
                  }

                  a.this.a((AppLovinAd)var1);
                  com.applovin.impl.sdk.utils.j.b((AppLovinAdDisplayListener)this.b, (AppLovinAd)var1);
                  if (!var1.ak().getAndSet(true)) {
                     y var4 = new y(var1, a.this.a);
                     a.this.a.K().a((com.applovin.impl.sdk.d.a)var4, r.a.i);
                  }

               }

               public void adClicked(AppLovinAd var1) {
                  com.applovin.impl.sdk.utils.j.a(this.c, var1);
               }

               public void adDisplayed(AppLovinAd var1) {
                  com.applovin.impl.sdk.utils.j.a(this.b, var1);
               }

               public void adHidden(AppLovinAd var1) {
                  if (var1 instanceof g) {
                     var1 = ((g)var1).a();
                  }

                  if (var1 instanceof f) {
                     this.a((f)var1);
                  } else {
                     p var2 = a.this.a.v();
                     StringBuilder var3 = new StringBuilder();
                     var3.append("Something is terribly wrong. Received `adHidden` callback for invalid ad of type: ");
                     var3.append(var1);
                     var2.e("IncentivizedAdController", var3.toString());
                  }
               }

               public void onAdDisplayFailed(String var1) {
                  com.applovin.impl.sdk.utils.j.a(this.b, var1);
               }

               public void userDeclinedToViewAd(AppLovinAd var1) {
               }

               public void userOverQuota(AppLovinAd var1, Map var2) {
                  a.this.a("quota_exceeded");
                  com.applovin.impl.sdk.utils.j.b(this.e, var1, var2);
               }

               public void userRewardRejected(AppLovinAd var1, Map var2) {
                  a.this.a("rejected");
                  com.applovin.impl.sdk.utils.j.c(this.e, var1, var2);
               }

               public void userRewardVerified(AppLovinAd var1, Map var2) {
                  a.this.a("accepted");
                  com.applovin.impl.sdk.utils.j.a(this.e, var1, var2);
               }

               public void validationRequestFailed(AppLovinAd var1, int var2) {
                  a.this.a("network_timeout");
                  com.applovin.impl.sdk.utils.j.a(this.e, var1, var2);
               }

               public void videoPlaybackBegan(AppLovinAd var1) {
                  com.applovin.impl.sdk.utils.j.a(this.d, var1);
               }

               public void videoPlaybackEnded(AppLovinAd var1, double var2, boolean var4) {
                  com.applovin.impl.sdk.utils.j.a(this.d, var1, var2, var4);
                  a.this.h = var4;
               }
            };
            var8.setAdDisplayListener(var9);
            var8.setAdVideoPlaybackListener(var9);
            var8.setAdClickListener(var9);
            var8.showAndRender(var7);
            if (var7 instanceof f) {
               this.a((f)((f)var7), (AppLovinAdRewardListener)var9);
               return;
            }
         } else {
            this.a(var1, var4, var5);
         }

      }
   }

   private void a(f var1, AppLovinAdRewardListener var2) {
      ad var3 = new ad(var1, var2, this.a);
      this.a.K().a((com.applovin.impl.sdk.d.a)var3, r.a.i);
   }

   private void a(AppLovinAd var1) {
      AppLovinAd var2 = this.c;
      if (var2 != null) {
         if (var2 instanceof g) {
            if (var1 != ((g)var2).a()) {
               return;
            }
         } else if (var1 != var2) {
            return;
         }

         this.c = null;
      }

   }

   private void a(AppLovinAd var1, Context var2, AppLovinAdRewardListener var3, AppLovinAdVideoPlaybackListener var4, AppLovinAdDisplayListener var5, AppLovinAdClickListener var6) {
      if (var1 == null) {
         var1 = this.c;
      }

      AppLovinAdBase var7 = (AppLovinAdBase)var1;
      if (var7 != null) {
         this.a(var7, var2, var3, var4, var5, var6);
      } else {
         p.j("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
         this.d();
      }
   }

   private void a(AppLovinAd var1, AppLovinAdVideoPlaybackListener var2, AppLovinAdDisplayListener var3) {
      this.a.L().a(com.applovin.impl.sdk.c.g.j);
      com.applovin.impl.sdk.utils.j.a(var2, var1, 0.0D, false);
      com.applovin.impl.sdk.utils.j.b(var3, var1);
   }

   private void a(String param1) {
      // $FF: Couldn't be decompiled
   }

   private void b(AppLovinAdLoadListener var1) {
      this.b.loadNextIncentivizedAd(this.d, var1);
   }

   private void d() {
      SoftReference var1 = this.e;
      if (var1 != null) {
         AppLovinAdLoadListener var2 = (AppLovinAdLoadListener)var1.get();
         if (var2 != null) {
            var2.failedToReceiveAd(-300);
         }
      }

   }

   private String e() {
      // $FF: Couldn't be decompiled
   }

   private AppLovinAdRewardListener f() {
      return new a$1(this);
   }

   public void a(AppLovinAd var1, Context var2, String var3, AppLovinAdRewardListener var4, AppLovinAdVideoPlaybackListener var5, AppLovinAdDisplayListener var6, AppLovinAdClickListener var7) {
      if (var4 == null) {
         var4 = this.f();
      }

      this.a(var1, var2, var4, var5, var6, var7);
   }

   public void a(AppLovinAdLoadListener var1) {
      this.a.v().b("IncentivizedAdController", "User requested preload of incentivized ad...");
      this.e = new SoftReference(var1);
      if (this.a()) {
         p.j("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
         if (var1 != null) {
            var1.adReceived(this.c);
         }

      } else {
         this.b(new AppLovinAdLoadListener(var1) {
            private final AppLovinAdLoadListener b;

            {
               this.b = var2;
            }

            // $FF: synthetic method
            static AppLovinAdLoadListener a(Object var0) {
               return var0.b;
            }

            public void adReceived(AppLovinAd var1) {
               a.this.c = var1;
               if (this.b != null) {
                  AppLovinSdkUtils.runOnUiThread(new Runnable(var1) {
                     // $FF: synthetic field
                     final AppLovinAd a;
                     // $FF: synthetic field
                     final <undefinedtype> b;

                     {
                        this.b = var1;
                        this.a = var2;
                     }

                     public void run() {
                        try {
                           null.a(this.b).adReceived(this.a);
                        } catch (Throwable var3) {
                           p.c("AppLovinIncentivizedInterstitial", "Unable to notify ad listener about a newly loaded ad", var3);
                           return;
                        }
                     }
                  });
               }

            }

            public void failedToReceiveAd(int var1) {
               if (this.b != null) {
                  AppLovinSdkUtils.runOnUiThread(new Runnable(var1) {
                     // $FF: synthetic field
                     final int a;
                     // $FF: synthetic field
                     final <undefinedtype> b;

                     {
                        this.b = var1;
                        this.a = var2;
                     }

                     public void run() {
                        try {
                           null.a(this.b).failedToReceiveAd(this.a);
                        } catch (Throwable var3) {
                           p.c("AppLovinIncentivizedInterstitial", "Unable to notify listener about ad load failure", var3);
                           return;
                        }
                     }
                  });
               }

            }
         });
      }
   }

   public boolean a() {
      return this.c != null;
   }

   public String b() {
      return this.d;
   }

   public void c() {
   }
}
