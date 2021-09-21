package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.RelativeLayout.LayoutParams;
import com.applovin.adview.AdViewController;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicReference;

public class AdViewControllerImpl implements AdViewController {
   private volatile AppLovinAdClickListener A;
   private Context a;
   private ViewGroup b;
   private com.applovin.impl.sdk.j c;
   private AppLovinAdServiceImpl d;
   private com.applovin.impl.sdk.p e;
   private AppLovinAdSize f;
   private String g;
   private com.applovin.impl.sdk.c.d h;
   private com.applovin.impl.adview.d i;
   private AdViewControllerImpl.d j;
   private c k;
   private AppLovinAd l;
   private Runnable m;
   private Runnable n;
   private volatile AppLovinAd o = null;
   private volatile AppLovinAd p = null;
   private k q = null;
   private k r = null;
   private final AtomicReference s = new AtomicReference();
   private volatile boolean t = false;
   private volatile boolean u = true;
   private volatile boolean v = false;
   private volatile boolean w = false;
   private volatile AppLovinAdLoadListener x;
   private volatile AppLovinAdDisplayListener y;
   private volatile AppLovinAdViewEventListener z;

   // $FF: synthetic method
   static k a(AdViewControllerImpl var0) {
      return var0.q;
   }

   // $FF: synthetic method
   static k a(AdViewControllerImpl var0, k var1) {
      var0.r = var1;
      return var1;
   }

   private void a(AppLovinAdView var1, com.applovin.impl.sdk.j var2, AppLovinAdSize var3, String var4, Context var5) {
      if (var1 != null) {
         if (var2 != null) {
            if (var3 != null) {
               this.c = var2;
               this.d = var2.o();
               this.e = var2.v();
               this.f = var3;
               this.g = var4;
               this.a = var5;
               this.b = var1;
               this.l = new com.applovin.impl.sdk.ad.h();
               this.i = new com.applovin.impl.adview.d(this, var2);
               this.n = new Runnable((AdViewControllerImpl$1)null) {
                  public void run() {
                     if (AdViewControllerImpl.this.k != null) {
                        AdViewControllerImpl.this.k.setVisibility(8);
                     }

                  }
               };
               this.m = new Runnable((AdViewControllerImpl$1)null) {
                  public void run() {
                     if (AdViewControllerImpl.this.o != null) {
                        if (AdViewControllerImpl.this.k != null) {
                           com.applovin.impl.sdk.p var5 = AdViewControllerImpl.this.e;
                           StringBuilder var6 = new StringBuilder();
                           var6.append("Rendering advertisement ad for #");
                           var6.append(AdViewControllerImpl.this.o.getAdIdNumber());
                           var6.append("...");
                           var5.b("AppLovinAdView", var6.toString());
                           AdViewControllerImpl.b((View)AdViewControllerImpl.this.k, (AppLovinAdSize)AdViewControllerImpl.this.o.getSize());
                           AdViewControllerImpl.this.k.a(AdViewControllerImpl.this.o);
                           if (AdViewControllerImpl.this.o.getSize() != AppLovinAdSize.INTERSTITIAL && !AdViewControllerImpl.this.v && AdViewControllerImpl.this.o instanceof com.applovin.impl.sdk.ad.f) {
                              com.applovin.impl.sdk.ad.f var12 = (com.applovin.impl.sdk.ad.f)AdViewControllerImpl.this.o;
                              AdViewControllerImpl var13 = AdViewControllerImpl.this;
                              var13.h = new com.applovin.impl.sdk.c.d(var12, var13.c);
                              AdViewControllerImpl.this.h.a();
                              AdViewControllerImpl.this.k.a(AdViewControllerImpl.this.h);
                              var12.setHasShown(true);
                           }

                           if (AdViewControllerImpl.this.k.c() != null && AdViewControllerImpl.this.o instanceof com.applovin.impl.sdk.ad.f) {
                              long var10;
                              if (((com.applovin.impl.sdk.ad.f)AdViewControllerImpl.this.o).r()) {
                                 var10 = 0L;
                              } else {
                                 var10 = 1L;
                              }

                              AdViewControllerImpl.this.k.c().a(var10);
                              return;
                           }
                        } else {
                           StringBuilder var1 = new StringBuilder();
                           var1.append("Unable to render advertisement for ad #");
                           var1.append(AdViewControllerImpl.this.o.getAdIdNumber());
                           var1.append(". Please make sure you are not calling AppLovinAdView.destroy() prematurely.");
                           com.applovin.impl.sdk.p.j("AppLovinAdView", var1.toString());
                        }
                     }

                  }
               };
               this.j = new AdViewControllerImpl.d(this, var2);
               this.a(var3);
            } else {
               throw new IllegalArgumentException("No ad size specified");
            }
         } else {
            throw new IllegalArgumentException("No sdk specified");
         }
      } else {
         throw new IllegalArgumentException("No parent view specified");
      }
   }

   // $FF: synthetic method
   static void a(AdViewControllerImpl var0, AppLovinAdSize var1) {
      var0.a(var1);
   }

   private void a(AppLovinAdSize var1) {
      try {
         this.k = com.applovin.impl.adview.c.a(var1, this.i, this.c, this.a);
         this.k.setBackgroundColor(0);
         this.k.setWillNotCacheDrawing(false);
         this.b.setBackgroundColor(0);
         this.b.addView(this.k);
         b((View)this.k, (AppLovinAdSize)var1);
         if (!this.t) {
            this.a(this.n);
         }

         if ((Boolean)this.c.a(com.applovin.impl.sdk.b.d.fa)) {
            this.a(new Runnable((AdViewControllerImpl$1)null) {
               public void run() {
                  if (AdViewControllerImpl.this.k != null) {
                     try {
                        AdViewControllerImpl.this.k.loadDataWithBaseURL("/", "<html></html>", "text/html", (String)null, "");
                        return;
                     } catch (Exception var2) {
                     }
                  }

               }
            });
         }

         this.t = true;
      } catch (Throwable var5) {
         StringBuilder var3 = new StringBuilder();
         var3.append("Failed to create AdView: ");
         var3.append(var5.getMessage());
         com.applovin.impl.sdk.p.j("AppLovinAdView", var3.toString());
         return;
      }
   }

   private void a(Runnable var1) {
      AppLovinSdkUtils.runOnUiThread(var1);
   }

   // $FF: synthetic method
   static k b(AdViewControllerImpl var0, k var1) {
      var0.q = var1;
      return var1;
   }

   private void b() {
      com.applovin.impl.sdk.p var1 = this.e;
      if (var1 != null) {
         var1.b("AppLovinAdView", "Destroying...");
      }

      c var2 = this.k;
      if (var2 != null) {
         label572: {
            Throwable var10000;
            label577: {
               boolean var10001;
               try {
                  ViewParent var4 = var2.getParent();
                  if (var4 instanceof ViewGroup) {
                     ((ViewGroup)var4).removeView(this.k);
                  }
               } catch (Throwable var79) {
                  var10000 = var79;
                  var10001 = false;
                  break label577;
               }

               boolean var5;
               try {
                  this.k.removeAllViews();
                  var5 = this.k.a();
               } catch (Throwable var78) {
                  var10000 = var78;
                  var10001 = false;
                  break label577;
               }

               if (var5) {
                  try {
                     this.k.loadUrl("about:blank");
                     this.k.clearHistory();
                  } catch (Throwable var76) {
                     var10000 = var76;
                     var10001 = false;
                     break label577;
                  }
               } else {
                  boolean var6;
                  try {
                     var6 = (Boolean)this.c.a(com.applovin.impl.sdk.b.d.eW);
                  } catch (Throwable var75) {
                     var10000 = var75;
                     var10001 = false;
                     break label577;
                  }

                  if (var6) {
                     try {
                        this.k.loadUrl("about:blank");
                        this.k.onPause();
                        this.k.destroyDrawingCache();
                     } catch (Throwable var77) {
                        Throwable var7 = var77;

                        label553:
                        try {
                           this.e.b("AppLovinAdView", "Encountered error while cleaning up WebView", var7);
                           break label553;
                        } catch (Throwable var74) {
                           var10000 = var74;
                           var10001 = false;
                           break label577;
                        }
                     }
                  }

                  try {
                     this.k.destroy();
                  } catch (Throwable var73) {
                     var10000 = var73;
                     var10001 = false;
                     break label577;
                  }
               }

               label550:
               try {
                  this.k = null;
                  break label572;
               } catch (Throwable var72) {
                  var10000 = var72;
                  var10001 = false;
                  break label550;
               }
            }

            Throwable var3 = var10000;
            this.e.a("AppLovinAdView", "Unable to destroy ad view", var3);
         }
      }

      this.v = true;
   }

   private static void b(View var0, AppLovinAdSize var1) {
      if (var0 != null) {
         DisplayMetrics var2 = var0.getResources().getDisplayMetrics();
         boolean var3 = var1.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel());
         int var4 = -1;
         int var5;
         if (var3) {
            var5 = -1;
         } else if (var1.getWidth() == var4) {
            var5 = var2.widthPixels;
         } else {
            var5 = (int)TypedValue.applyDimension(1, (float)var1.getWidth(), var2);
         }

         if (!var1.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel())) {
            if (var1.getHeight() == var4) {
               var4 = var2.heightPixels;
            } else {
               var4 = (int)TypedValue.applyDimension(1, (float)var1.getHeight(), var2);
            }
         }

         Object var6 = var0.getLayoutParams();
         if (var6 == null) {
            var6 = new LayoutParams(-2, -2);
         }

         ((android.view.ViewGroup.LayoutParams)var6).width = var5;
         ((android.view.ViewGroup.LayoutParams)var6).height = var4;
         if (var6 instanceof LayoutParams) {
            LayoutParams var7 = (LayoutParams)var6;
            var7.addRule(10);
            var7.addRule(9);
         }

         var0.setLayoutParams((android.view.ViewGroup.LayoutParams)var6);
      }
   }

   // $FF: synthetic method
   static AppLovinAdSize c(AdViewControllerImpl var0) {
      return var0.f;
   }

   private void c() {
      this.a((Runnable)(new AdViewControllerImpl$1(this)));
   }

   private void d() {
      this.a((Runnable)(new AdViewControllerImpl$6(this)));
   }

   private void e() {
      com.applovin.impl.sdk.c.d var1 = this.h;
      if (var1 != null) {
         var1.c();
         this.h = null;
      }

   }

   // $FF: synthetic method
   static Context f(AdViewControllerImpl var0) {
      return var0.a;
   }

   // $FF: synthetic method
   static ViewGroup h(AdViewControllerImpl var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static AppLovinAdViewEventListener i(AdViewControllerImpl var0) {
      return var0.z;
   }

   // $FF: synthetic method
   static AppLovinAdServiceImpl k(AdViewControllerImpl var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static void l(AdViewControllerImpl var0) {
      var0.d();
   }

   // $FF: synthetic method
   static AppLovinAdLoadListener m(AdViewControllerImpl var0) {
      return var0.x;
   }

   // $FF: synthetic method
   static k n(AdViewControllerImpl var0) {
      return var0.r;
   }

   void a() {
      if (this.q == null && this.r == null) {
         com.applovin.impl.sdk.p var1 = this.e;
         StringBuilder var2 = new StringBuilder();
         var2.append("Ad: ");
         var2.append(this.o);
         var2.append(" closed.");
         var1.b("AppLovinAdView", var2.toString());
         this.a(this.n);
         com.applovin.impl.sdk.utils.j.b(this.y, this.o);
         this.o = null;
      } else {
         if ((Boolean)this.c.a(com.applovin.impl.sdk.b.d.cp)) {
            this.contractAd();
         }

      }
   }

   void a(int var1) {
      if (!this.v) {
         this.a(this.n);
      }

      this.a((Runnable)(new AdViewControllerImpl$5(this, var1)));
   }

   void a(AppLovinAd var1) {
      if (var1 != null) {
         this.w = true;
         if (!this.v) {
            this.renderAd(var1);
         } else {
            this.s.set(var1);
            this.e.b("AppLovinAdView", "Ad view has paused when an ad was received, ad saved for later");
         }

         this.a((Runnable)(new AdViewControllerImpl$4(this, var1)));
      } else {
         this.e.e("AppLovinAdView", "No provided when to the view controller");
         this.a(-1);
      }
   }

   void a(AppLovinAd var1, AppLovinAdView var2, Uri var3, PointF var4) {
      com.applovin.impl.sdk.utils.j.a(this.A, var1);
      com.applovin.impl.sdk.p var5;
      String var6;
      if (var2 != null) {
         if (var1 instanceof com.applovin.impl.sdk.ad.f) {
            this.d.trackAndLaunchClick(var1, var2, this, var3, var4);
            return;
         }

         var5 = this.e;
         var6 = "Unable to process ad click - EmptyAd is not supported.";
      } else {
         var5 = this.e;
         var6 = "Unable to process ad click - AppLovinAdView destroyed prematurely";
      }

      var5.e("AppLovinAdView", var6);
   }

   public void contractAd() {
      this.a((Runnable)(new AdViewControllerImpl$3(this)));
   }

   public void destroy() {
      if (this.k != null && this.q != null) {
         this.contractAd();
      }

      this.b();
   }

   public void dismissInterstitialIfRequired() {
      if (this.a instanceof m && this.o instanceof com.applovin.impl.sdk.ad.f) {
         boolean var1;
         if (((com.applovin.impl.sdk.ad.f)this.o).E() == null.b) {
            var1 = true;
         } else {
            var1 = false;
         }

         m var2 = (m)this.a;
         if (var1 && var2.getPostitialWasDisplayed()) {
            var2.dismiss();
         }
      }

   }

   public void expandAd(PointF var1) {
      this.a((Runnable)(new AdViewControllerImpl$2(this, var1)));
   }

   public AppLovinAdViewEventListener getAdViewEventListener() {
      return this.z;
   }

   public c getAdWebView() {
      return this.k;
   }

   public AppLovinAd getCurrentAd() {
      return this.o;
   }

   public AppLovinAdView getParentView() {
      return (AppLovinAdView)this.b;
   }

   public com.applovin.impl.sdk.j getSdk() {
      return this.c;
   }

   public AppLovinAdSize getSize() {
      return this.f;
   }

   public String getZoneId() {
      return this.g;
   }

   public void initializeAdView(AppLovinAdView var1, Context var2, AppLovinAdSize var3, String var4, AppLovinSdk var5, AttributeSet var6) {
      if (var1 != null) {
         if (var2 == null) {
            com.applovin.impl.sdk.p.j("AppLovinAdView", "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
         } else {
            if (var3 == null) {
               var3 = com.applovin.impl.sdk.utils.b.a(var6);
               if (var3 == null) {
                  var3 = AppLovinAdSize.BANNER;
               }
            }

            if (var5 == null) {
               var5 = AppLovinSdk.getInstance(var2);
            }

            if (var5 != null && !var5.hasCriticalErrors()) {
               this.a(var1, com.applovin.impl.sdk.utils.q.a(var5), var3, var4, var2);
               if (com.applovin.impl.sdk.utils.b.b(var6)) {
                  this.loadNextAd();
               }
            }

         }
      } else {
         throw new IllegalArgumentException("No parent view specified");
      }
   }

   public boolean isAdReadyToDisplay() {
      return !TextUtils.isEmpty(this.g) ? this.d.hasPreloadedAdForZoneId(this.g) : this.d.hasPreloadedAd(this.f);
   }

   public boolean isAutoDestroy() {
      return this.u;
   }

   public void loadNextAd() {
      if (this.c != null && this.j != null && this.a != null && this.t) {
         this.d.loadNextAd(this.g, this.f, this.j);
      } else {
         com.applovin.impl.sdk.p.h("AppLovinAdView", "Unable to load next ad: AppLovinAdView is not initialized.");
      }
   }

   public void onAdHtmlLoaded(WebView var1) {
      if (this.o instanceof com.applovin.impl.sdk.ad.f) {
         var1.setVisibility(0);

         try {
            if (this.o != this.p && this.y != null) {
               this.p = this.o;
               com.applovin.impl.sdk.utils.j.a(this.y, this.o);
               return;
            }
         } catch (Throwable var4) {
            com.applovin.impl.sdk.p.c("AppLovinAdView", "Exception while notifying ad display listener", var4);
            return;
         }
      }

   }

   public void onDetachedFromWindow() {
      if (this.t) {
         if (this.o != this.l) {
            com.applovin.impl.sdk.utils.j.b(this.y, this.o);
         }

         if (this.k != null && this.q != null) {
            this.e.b("AppLovinAdView", "onDetachedFromWindowCalled with expanded ad present");
            if ((Boolean)this.c.a(com.applovin.impl.sdk.b.d.co)) {
               this.contractAd();
            } else {
               this.c();
            }
         } else {
            this.e.b("AppLovinAdView", "onDetachedFromWindowCalled without an expanded ad present");
         }

         if (this.u) {
            this.b();
         }

      }
   }

   public void onVisibilityChanged(int var1) {
      if (this.t) {
         if (this.u) {
            if (var1 != 8 && var1 != 4) {
               if (var1 == 0) {
                  this.resume();
                  return;
               }
            } else {
               this.pause();
            }
         }

      }
   }

   public void pause() {
      if (this.t) {
         if (this.v) {
            return;
         }

         AppLovinAd var1 = this.o;
         this.renderAd(this.l);
         if (var1 != null) {
            this.s.set(var1);
         }

         this.v = true;
      }

   }

   public void renderAd(AppLovinAd var1) {
      this.renderAd(var1, (String)null);
   }

   public void renderAd(AppLovinAd var1, String var2) {
      if (var1 != null) {
         com.applovin.impl.sdk.utils.q.b(var1, this.c);
         if (!this.t) {
            com.applovin.impl.sdk.p.h("AppLovinAdView", "Unable to render ad: AppLovinAdView is not initialized.");
         } else {
            AppLovinAd var3 = com.applovin.impl.sdk.utils.q.a(var1, this.c);
            if (var3 != null && var3 != this.o) {
               com.applovin.impl.sdk.p var10 = this.e;
               StringBuilder var11 = new StringBuilder();
               var11.append("Rendering ad #");
               var11.append(var3.getAdIdNumber());
               var11.append(" (");
               var11.append(var3.getSize());
               var11.append(")");
               var10.b("AppLovinAdView", var11.toString());
               if (!(this.o instanceof com.applovin.impl.sdk.ad.h)) {
                  com.applovin.impl.sdk.utils.j.b(this.y, this.o);
                  if (!(var3 instanceof com.applovin.impl.sdk.ad.h) && var3.getSize() != AppLovinAdSize.INTERSTITIAL) {
                     this.e();
                  }
               }

               this.s.set((Object)null);
               this.p = null;
               this.o = var3;
               if (var1 instanceof com.applovin.impl.sdk.ad.f && !this.v && (this.f == AppLovinAdSize.BANNER || this.f == AppLovinAdSize.MREC || this.f == AppLovinAdSize.LEADER)) {
                  this.c.o().trackImpression((com.applovin.impl.sdk.ad.f)var1);
               }

               boolean var17 = var3 instanceof com.applovin.impl.sdk.ad.h;
               if (!var17 && this.q != null) {
                  if ((Boolean)this.c.a(com.applovin.impl.sdk.b.d.cn)) {
                     this.d();
                     this.e.b("AppLovinAdView", "Fade out the old ad scheduled");
                  } else {
                     this.c();
                  }
               }

               if (var17 && (this.q != null || this.r != null)) {
                  this.e.b("AppLovinAdView", "Ignoring empty ad render with expanded ad");
               } else {
                  this.a(this.m);
               }
            } else {
               com.applovin.impl.sdk.p var4 = this.e;
               String var9;
               if (var3 == null) {
                  var9 = "Unable to render ad. Ad is null. Internal inconsistency error.";
               } else {
                  StringBuilder var5 = new StringBuilder();
                  var5.append("Ad #");
                  var5.append(var3.getAdIdNumber());
                  var5.append(" is already showing, ignoring");
                  var9 = var5.toString();
               }

               var4.d("AppLovinAdView", var9);
            }
         }
      } else {
         throw new IllegalArgumentException("No ad specified");
      }
   }

   public void resume() {
      if (this.t) {
         AppLovinAd var1 = (AppLovinAd)this.s.getAndSet((Object)null);
         if (var1 != null) {
            this.renderAd(var1);
         }

         this.v = false;
      }
   }

   public void setAdClickListener(AppLovinAdClickListener var1) {
      this.A = var1;
   }

   public void setAdDisplayListener(AppLovinAdDisplayListener var1) {
      this.y = var1;
   }

   public void setAdLoadListener(AppLovinAdLoadListener var1) {
      this.x = var1;
   }

   public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener var1) {
   }

   public void setAdViewEventListener(AppLovinAdViewEventListener var1) {
      this.z = var1;
   }

   public void setAutoDestroy(boolean var1) {
      this.u = var1;
   }

   public void setStatsManagerHelper(com.applovin.impl.sdk.c.d var1) {
      c var2 = this.k;
      if (var2 != null) {
         var2.a(var1);
      }

   }

   static class d implements AppLovinAdLoadListener {
      private final AppLovinAdService a;
      private final com.applovin.impl.sdk.p b;
      private final AdViewControllerImpl c;

      d(AdViewControllerImpl var1, com.applovin.impl.sdk.j var2) {
         if (var1 != null) {
            if (var2 != null) {
               this.b = var2.v();
               this.a = var2.o();
               this.c = var1;
            } else {
               throw new IllegalArgumentException("No sdk specified");
            }
         } else {
            throw new IllegalArgumentException("No view specified");
         }
      }

      private AdViewControllerImpl a() {
         return this.c;
      }

      public void adReceived(AppLovinAd var1) {
         AdViewControllerImpl var2 = this.a();
         if (var2 != null) {
            var2.a(var1);
         } else {
            com.applovin.impl.sdk.p.j("AppLovinAdView", "Ad view has been garbage collected by the time an ad was received");
         }
      }

      public void failedToReceiveAd(int var1) {
         AdViewControllerImpl var2 = this.a();
         if (var2 != null) {
            var2.a(var1);
         }

      }
   }
}
