package com.applovin.impl.sdk;

import android.graphics.PointF;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.text.TextUtils;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdUpdateListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppLovinAdServiceImpl implements AppLovinAdService {
   public static String URI_LOAD_URL = "/adservice/load_url";
   public static String URI_NO_OP = "/adservice/no_op";
   public static String URI_TRACK_CLICK_IMMEDIATELY = "/adservice/track_click_now";
   private final j a;
   private final p b;
   private final Handler c = new Handler(Looper.getMainLooper());
   private final Map d;
   private final Object e = new Object();

   AppLovinAdServiceImpl(j var1) {
      this.a = var1;
      this.b = var1.v();
      this.d = new HashMap(5);
      this.d.put(com.applovin.impl.sdk.ad.d.c(var1), new AppLovinAdServiceImpl.b((AppLovinAdServiceImpl$1)null));
      this.d.put(com.applovin.impl.sdk.ad.d.d(var1), new AppLovinAdServiceImpl.b((AppLovinAdServiceImpl$1)null));
      this.d.put(com.applovin.impl.sdk.ad.d.e(var1), new AppLovinAdServiceImpl.b((AppLovinAdServiceImpl$1)null));
      this.d.put(com.applovin.impl.sdk.ad.d.f(var1), new AppLovinAdServiceImpl.b((AppLovinAdServiceImpl$1)null));
      this.d.put(com.applovin.impl.sdk.ad.d.g(var1), new AppLovinAdServiceImpl.b((AppLovinAdServiceImpl$1)null));
   }

   private AppLovinAdServiceImpl.b a(com.applovin.impl.sdk.ad.d var1) {
      Object var2 = this.e;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label176: {
         AppLovinAdServiceImpl.b var4;
         try {
            var4 = (AppLovinAdServiceImpl.b)this.d.get(var1);
         } catch (Throwable var26) {
            var10000 = var26;
            var10001 = false;
            break label176;
         }

         if (var4 == null) {
            try {
               var4 = new AppLovinAdServiceImpl.b((AppLovinAdServiceImpl$1)null);
               this.d.put(var1, var4);
            } catch (Throwable var25) {
               var10000 = var25;
               var10001 = false;
               break label176;
            }
         }

         label165:
         try {
            return var4;
         } catch (Throwable var24) {
            var10000 = var24;
            var10001 = false;
            break label165;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var23) {
            var10000 = var23;
            var10001 = false;
            continue;
         }
      }
   }

   // $FF: synthetic method
   static j a(AppLovinAdServiceImpl var0) {
      return var0.a;
   }

   private String a(String param1, long param2, int param4, String param5, boolean param6) {
      // $FF: Couldn't be decompiled
   }

   private String a(String var1, long var2, long var4, boolean var6, int var7) {
      if (com.applovin.impl.sdk.utils.n.b(var1)) {
         Builder var8 = Uri.parse(var1).buildUpon().appendQueryParameter("et_ms", Long.toString(var2)).appendQueryParameter("vs_ms", Long.toString(var4));
         if (var7 != com.applovin.impl.sdk.e.a) {
            var8.appendQueryParameter("musw_ch", Boolean.toString(var6));
            var8.appendQueryParameter("musw_st", Boolean.toString(com.applovin.impl.sdk.e.a(var7)));
         }

         return var8.build().toString();
      } else {
         return null;
      }
   }

   private void a(int var1, AppLovinAdLoadListener var2) {
      this.c.post(new AppLovinAdServiceImpl$2(this, var2, var1));
   }

   private void a(Uri var1, com.applovin.impl.sdk.ad.f var2, AppLovinAdView var3, AdViewControllerImpl var4) {
      if (var3 != null) {
         if (com.applovin.impl.sdk.utils.q.a(var3.getContext(), var1, this.a)) {
            com.applovin.impl.sdk.utils.j.c((AppLovinAdViewEventListener)var4.getAdViewEventListener(), var2, (AppLovinAdView)var3);
         }

         var4.dismissInterstitialIfRequired();
      } else {
         this.b.e("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
      }
   }

   // $FF: synthetic method
   static void a(AppLovinAdServiceImpl var0, int var1, AppLovinAdLoadListener var2) {
      var0.a(var1, var2);
   }

   // $FF: synthetic method
   static void a(AppLovinAdServiceImpl var0, AppLovinAd var1, AppLovinAdLoadListener var2) {
      var0.a(var1, var2);
   }

   private void a(com.applovin.impl.sdk.ad.d var1, AppLovinAdServiceImpl.a var2) {
      AppLovinAd var3 = (AppLovinAd)this.a.T().e(var1);
      if (var3 != null) {
         p var4 = this.b;
         StringBuilder var5 = new StringBuilder();
         var5.append("Using pre-loaded ad: ");
         var5.append(var3);
         var5.append(" for ");
         var5.append(var1);
         var4.b("AppLovinAdService", var5.toString());
         var2.adReceived(var3);
         if (var1.i() || var1.g() > 0) {
            this.a.T().i(var1);
            return;
         }
      } else {
         this.a((com.applovin.impl.sdk.d.a)(new com.applovin.impl.sdk.d.m(var1, var2, this.a)), (AppLovinAdLoadListener)var2);
      }

   }

   private void a(com.applovin.impl.sdk.ad.d var1, AppLovinAdLoadListener var2) {
      if (var1 == null) {
         IllegalArgumentException var3 = new IllegalArgumentException("No zone specified");
         throw var3;
      } else if (var2 != null) {
         p var4 = this.a.v();
         StringBuilder var5 = new StringBuilder();
         var5.append("Loading next ad of zone {");
         var5.append(var1);
         var5.append("}...");
         var4.b("AppLovinAdService", var5.toString());
         AppLovinAdServiceImpl.b var9 = this.a(var1);
         Object var10 = var9.a;
         synchronized(var10){}

         boolean var10001;
         Throwable var10000;
         label781: {
            label789: {
               AppLovinAdServiceImpl.a var16;
               label790: {
                  p var13;
                  String var15;
                  String var14;
                  label778: {
                     label777: {
                        label791: {
                           label792: {
                              try {
                                 var9.c.add(var2);
                                 if (!var9.b) {
                                    this.b.b("AppLovinAdService", "Loading next ad...");
                                    var9.b = true;
                                    var16 = new AppLovinAdServiceImpl.a(var9, (AppLovinAdServiceImpl$1)null);
                                    if (!var1.h()) {
                                       break label792;
                                    }

                                    if (!this.a.T().a((com.applovin.impl.sdk.ad.d)var1, (AppLovinAdLoadListener)var16)) {
                                       break label791;
                                    }

                                    var13 = this.b;
                                    break label777;
                                 }
                              } catch (Throwable var89) {
                                 var10000 = var89;
                                 var10001 = false;
                                 break label781;
                              }

                              try {
                                 var13 = this.b;
                              } catch (Throwable var88) {
                                 var10000 = var88;
                                 var10001 = false;
                                 break label781;
                              }

                              var14 = "AppLovinAdService";
                              var15 = "Already waiting on an ad load...";
                              break label778;
                           }

                           try {
                              this.b.b("AppLovinAdService", "Task merge not necessary.");
                              break label790;
                           } catch (Throwable var85) {
                              var10000 = var85;
                              var10001 = false;
                              break label781;
                           }
                        }

                        try {
                           this.b.b("AppLovinAdService", "Skipped attach of initial preload callback.");
                           break label790;
                        } catch (Throwable var86) {
                           var10000 = var86;
                           var10001 = false;
                           break label781;
                        }
                     }

                     var14 = "AppLovinAdService";
                     var15 = "Attaching load listener to initial preload task...";
                  }

                  try {
                     var13.b(var14, var15);
                     break label789;
                  } catch (Throwable var87) {
                     var10000 = var87;
                     var10001 = false;
                     break label781;
                  }
               }

               try {
                  this.a(var1, var16);
               } catch (Throwable var84) {
                  var10000 = var84;
                  var10001 = false;
                  break label781;
               }
            }

            label749:
            try {
               return;
            } catch (Throwable var83) {
               var10000 = var83;
               var10001 = false;
               break label749;
            }
         }

         while(true) {
            Throwable var11 = var10000;

            try {
               throw var11;
            } catch (Throwable var82) {
               var10000 = var82;
               var10001 = false;
               continue;
            }
         }
      } else {
         throw new IllegalArgumentException("No callback specified");
      }
   }

   private void a(com.applovin.impl.sdk.c.a var1) {
      if (com.applovin.impl.sdk.utils.n.b(var1.a())) {
         String var2 = com.applovin.impl.sdk.utils.q.b(var1.a());
         String var3;
         if (com.applovin.impl.sdk.utils.n.b(var1.b())) {
            var3 = com.applovin.impl.sdk.utils.q.b(var1.b());
         } else {
            var3 = null;
         }

         this.a.N().a(com.applovin.impl.sdk.network.f.l().a(var2).b(var3).a(false).a());
      } else {
         this.b.d("AppLovinAdService", "Requested a postback dispatch for a null URL; nothing to do...");
      }
   }

   private void a(com.applovin.impl.sdk.d.a var1, AppLovinAdLoadListener var2) {
      if (!this.a.d()) {
         p.i("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
      }

      this.a.a();
      this.a.K().a(var1, com.applovin.impl.sdk.d.r.a.a);
   }

   private void a(AppLovinAd var1, AppLovinAdLoadListener var2) {
      this.c.post(new AppLovinAdServiceImpl$1(this, var2, var1));
   }

   private void a(List var1) {
      if (var1 != null && !var1.isEmpty()) {
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            this.a((com.applovin.impl.sdk.c.a)var2.next());
         }
      }

   }

   public void addAdUpdateListener(AppLovinAdUpdateListener var1) {
   }

   public void addAdUpdateListener(AppLovinAdUpdateListener var1, AppLovinAdSize var2) {
   }

   public AppLovinAd dequeueAd(com.applovin.impl.sdk.ad.d var1) {
      AppLovinAd var2 = (AppLovinAd)this.a.T().d(var1);
      p var3 = this.b;
      StringBuilder var4 = new StringBuilder();
      var4.append("Dequeued ad: ");
      var4.append(var2);
      var4.append(" for zone: ");
      var4.append(var1);
      var4.append("...");
      var3.b("AppLovinAdService", var4.toString());
      return var2;
   }

   public String getBidToken() {
      ThreadPolicy var1 = StrictMode.allowThreadDiskReads();
      String var2 = this.a.O().a();
      StrictMode.setThreadPolicy(var1);
      return var2;
   }

   public boolean hasPreloadedAd(AppLovinAdSize var1) {
      com.applovin.impl.sdk.ad.d var2 = com.applovin.impl.sdk.ad.d.a(var1, AppLovinAdType.REGULAR, this.a);
      return this.a.T().g(var2);
   }

   public boolean hasPreloadedAdForZoneId(String var1) {
      if (TextUtils.isEmpty(var1)) {
         p.j("AppLovinAdService", "Unable to check if ad is preloaded - invalid zone id");
         return false;
      } else {
         com.applovin.impl.sdk.ad.d var2 = com.applovin.impl.sdk.ad.d.a(var1, this.a);
         return this.a.T().g(var2);
      }
   }

   public void loadNextAd(AppLovinAdSize var1, AppLovinAdLoadListener var2) {
      this.a(com.applovin.impl.sdk.ad.d.a(var1, AppLovinAdType.REGULAR, this.a), var2);
   }

   public void loadNextAd(String var1, AppLovinAdSize var2, AppLovinAdLoadListener var3) {
      p var4 = this.b;
      StringBuilder var5 = new StringBuilder();
      var5.append("Loading next ad of zone {");
      var5.append(var1);
      var5.append("} with size ");
      var5.append(var2);
      var4.b("AppLovinAdService", var5.toString());
      this.a(com.applovin.impl.sdk.ad.d.a(var2, AppLovinAdType.REGULAR, var1, this.a), var3);
   }

   public void loadNextAdForAdToken(String var1, AppLovinAdLoadListener var2) {
      String var3;
      if (var1 != null) {
         var3 = var1.trim();
      } else {
         var3 = null;
      }

      if (TextUtils.isEmpty(var3)) {
         p.j("AppLovinAdService", "Invalid ad token specified");
         this.a(-8, var2);
      } else {
         label32: {
            com.applovin.impl.sdk.ad.c var4 = new com.applovin.impl.sdk.ad.c(var3, this.a);
            Object var24;
            if (var4.b() == com.applovin.impl.sdk.ad.c.a.b) {
               p var25 = this.b;
               StringBuilder var26 = new StringBuilder();
               var26.append("Loading next ad for token: ");
               var26.append(var4);
               var25.b("AppLovinAdService", var26.toString());
               var24 = new com.applovin.impl.sdk.d.o(var4, var2, this.a);
            } else {
               if (var4.b() != com.applovin.impl.sdk.ad.c.a.c) {
                  StringBuilder var5 = new StringBuilder();
                  var5.append("Invalid ad token specified: ");
                  var5.append(var4);
                  p.j("AppLovinAdService", var5.toString());
                  break label32;
               }

               JSONObject var8 = var4.d();
               if (var8 == null) {
                  p var9 = this.b;
                  StringBuilder var10 = new StringBuilder();
                  var10.append("Unable to retrieve ad response JSON from token: ");
                  var10.append(var4);
                  var9.e("AppLovinAdService", var10.toString());
                  break label32;
               }

               com.applovin.impl.sdk.utils.h.f(var8, this.a);
               com.applovin.impl.sdk.utils.h.d(var8, this.a);
               com.applovin.impl.sdk.utils.h.c(var8, this.a);
               if (com.applovin.impl.sdk.utils.i.b(var8, "ads", new JSONArray(), this.a).length() <= 0) {
                  p var13 = this.b;
                  StringBuilder var14 = new StringBuilder();
                  var14.append("No ad returned from the server for token: ");
                  var14.append(var4);
                  var13.e("AppLovinAdService", var14.toString());
                  var2.failedToReceiveAd(204);
                  return;
               }

               p var17 = this.b;
               StringBuilder var18 = new StringBuilder();
               var18.append("Rendering ad for token: ");
               var18.append(var4);
               var17.b("AppLovinAdService", var18.toString());
               com.applovin.impl.sdk.ad.d var21 = com.applovin.impl.sdk.utils.q.a(var8, this.a);
               com.applovin.impl.sdk.ad.b var22 = com.applovin.impl.sdk.ad.b.f;
               j var23 = this.a;
               var24 = new com.applovin.impl.sdk.d.s(var8, var21, var22, var2, var23);
            }

            this.a((com.applovin.impl.sdk.d.a)var24, (AppLovinAdLoadListener)var2);
            return;
         }

         var2.failedToReceiveAd(-8);
      }
   }

   public void loadNextAdForZoneId(String var1, AppLovinAdLoadListener var2) {
      if (!TextUtils.isEmpty(var1)) {
         p var3 = this.b;
         StringBuilder var4 = new StringBuilder();
         var4.append("Loading next ad of zone {");
         var4.append(var1);
         var4.append("}");
         var3.b("AppLovinAdService", var4.toString());
         this.a(com.applovin.impl.sdk.ad.d.a(var1, this.a), var2);
      } else {
         throw new IllegalArgumentException("No zone id specified");
      }
   }

   public void loadNextAdForZoneIds(List var1, AppLovinAdLoadListener var2) {
      List var3 = com.applovin.impl.sdk.utils.e.a(var1);
      if (var3 != null && !var3.isEmpty()) {
         p var4 = this.b;
         StringBuilder var5 = new StringBuilder();
         var5.append("Loading next ad for zones: ");
         var5.append(var3);
         var4.b("AppLovinAdService", var5.toString());
         this.a((com.applovin.impl.sdk.d.a)(new com.applovin.impl.sdk.d.l(var3, var2, this.a)), (AppLovinAdLoadListener)var2);
      } else {
         p.j("AppLovinAdService", "No zones were provided");
         this.a(-7, var2);
      }
   }

   public void loadNextIncentivizedAd(String var1, AppLovinAdLoadListener var2) {
      p var3 = this.b;
      StringBuilder var4 = new StringBuilder();
      var4.append("Loading next incentivized ad of zone {");
      var4.append(var1);
      var4.append("}");
      var3.b("AppLovinAdService", var4.toString());
      this.a(com.applovin.impl.sdk.ad.d.c(var1, this.a), var2);
   }

   public void preloadAd(AppLovinAdSize var1) {
      this.a.a();
      com.applovin.impl.sdk.ad.d var2 = com.applovin.impl.sdk.ad.d.a(var1, AppLovinAdType.REGULAR, this.a);
      this.a.T().i(var2);
   }

   public void preloadAdForZoneId(String var1) {
      if (TextUtils.isEmpty(var1)) {
         p.j("AppLovinAdService", "Unable to preload ad for invalid zone identifier");
      } else {
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

   public void removeAdUpdateListener(AppLovinAdUpdateListener var1, AppLovinAdSize var2) {
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("AppLovinAdService{adLoadStates=");
      var1.append(this.d);
      var1.append('}');
      return var1.toString();
   }

   public void trackAndLaunchClick(AppLovinAd var1, AppLovinAdView var2, AdViewControllerImpl var3, Uri var4, PointF var5) {
      if (var1 == null) {
         this.b.e("AppLovinAdService", "Unable to track ad view click. No ad specified");
      } else {
         this.b.b("AppLovinAdService", "Tracking click on an ad...");
         com.applovin.impl.sdk.ad.f var6 = (com.applovin.impl.sdk.ad.f)var1;
         this.a(var6.a(var5));
         this.a(var4, var6, var2, var3);
      }
   }

   public void trackAndLaunchVideoClick(AppLovinAd var1, AppLovinAdView var2, Uri var3, PointF var4) {
      if (var1 == null) {
         this.b.e("AppLovinAdService", "Unable to track video click. No ad specified");
      } else {
         this.b.b("AppLovinAdService", "Tracking VIDEO click on an ad...");
         this.a(((com.applovin.impl.sdk.ad.f)var1).b(var4));
         com.applovin.impl.sdk.utils.q.a(var2.getContext(), var3, this.a);
      }
   }

   public void trackAppKilled(com.applovin.impl.sdk.ad.f var1) {
      if (var1 == null) {
         this.b.e("AppLovinAdService", "Unable to track app killed. No ad specified");
      } else {
         this.b.b("AppLovinAdService", "Tracking app killed during ad...");
         List var2 = var1.at();
         if (var2 != null && !var2.isEmpty()) {
            Iterator var8 = var2.iterator();

            while(var8.hasNext()) {
               com.applovin.impl.sdk.c.a var9 = (com.applovin.impl.sdk.c.a)var8.next();
               this.a(new com.applovin.impl.sdk.c.a(var9.a(), var9.b()));
            }
         } else {
            p var3 = this.b;
            StringBuilder var4 = new StringBuilder();
            var4.append("Unable to track app killed during AD #");
            var4.append(var1.getAdIdNumber());
            var4.append(". Missing app killed tracking URL.");
            var3.d("AppLovinAdService", var4.toString());
         }

      }
   }

   public void trackFullScreenAdClosed(com.applovin.impl.sdk.ad.f var1, long var2, long var4, boolean var6, int var7) {
      p var8 = this.b;
      if (var1 == null) {
         var8.e("AppLovinAdService", "Unable to track ad closed. No ad specified.");
      } else {
         var8.b("AppLovinAdService", "Tracking ad closed...");
         List var9 = var1.as();
         if (var9 != null && !var9.isEmpty()) {
            Iterator var16 = var9.iterator();

            while(var16.hasNext()) {
               com.applovin.impl.sdk.c.a var17 = (com.applovin.impl.sdk.c.a)var16.next();
               String var18 = this.a(var17.a(), var2, var4, var6, var7);
               String var19 = this.a(var17.b(), var2, var4, var6, var7);
               if (com.applovin.impl.sdk.utils.n.b(var18)) {
                  this.a(new com.applovin.impl.sdk.c.a(var18, var19));
               } else {
                  p var20 = this.b;
                  StringBuilder var21 = new StringBuilder();
                  var21.append("Failed to parse url: ");
                  var21.append(var17.a());
                  var20.e("AppLovinAdService", var21.toString());
               }
            }
         } else {
            p var10 = this.b;
            StringBuilder var11 = new StringBuilder();
            var11.append("Unable to track ad closed for AD #");
            var11.append(var1.getAdIdNumber());
            var11.append(". Missing ad close tracking URL.");
            var11.append(var1.getAdIdNumber());
            var10.d("AppLovinAdService", var11.toString());
         }

      }
   }

   public void trackImpression(com.applovin.impl.sdk.ad.f var1) {
      if (var1 == null) {
         this.b.e("AppLovinAdService", "Unable to track impression click. No ad specified");
      } else {
         this.b.b("AppLovinAdService", "Tracking impression on ad...");
         this.a(var1.au());
      }
   }

   public void trackVideoEnd(com.applovin.impl.sdk.ad.f var1, long var2, int var4, boolean var5) {
      p var6 = this.b;
      if (var1 == null) {
         var6.e("AppLovinAdService", "Unable to track video end. No ad specified");
      } else {
         var6.b("AppLovinAdService", "Tracking video end on ad...");
         List var7 = var1.ar();
         if (var7 != null && !var7.isEmpty()) {
            String var13 = Long.toString(System.currentTimeMillis());
            Iterator var14 = var7.iterator();

            while(var14.hasNext()) {
               com.applovin.impl.sdk.c.a var15 = (com.applovin.impl.sdk.c.a)var14.next();
               if (com.applovin.impl.sdk.utils.n.b(var15.a())) {
                  String var16 = this.a(var15.a(), var2, var4, var13, var5);
                  String var17 = this.a(var15.b(), var2, var4, var13, var5);
                  if (var16 != null) {
                     this.a(new com.applovin.impl.sdk.c.a(var16, var17));
                  } else {
                     p var18 = this.b;
                     StringBuilder var19 = new StringBuilder();
                     var19.append("Failed to parse url: ");
                     var19.append(var15.a());
                     var18.e("AppLovinAdService", var19.toString());
                  }
               } else {
                  this.b.d("AppLovinAdService", "Requested a postback dispatch for an empty video end URL; nothing to do...");
               }
            }
         } else {
            p var8 = this.b;
            StringBuilder var9 = new StringBuilder();
            var9.append("Unable to submit persistent postback for AD #");
            var9.append(var1.getAdIdNumber());
            var9.append(". Missing video end tracking URL.");
            var8.d("AppLovinAdService", var9.toString());
         }

      }
   }

   private class a implements AppLovinAdLoadListener {
      private final AppLovinAdServiceImpl.b b;

      private a(AppLovinAdServiceImpl.b var2) {
         this.b = var2;
      }

      // $FF: synthetic method
      a(AppLovinAdServiceImpl.b var2, AppLovinAdServiceImpl$1 var3) {
         this(var2);
      }

      public void adReceived(AppLovinAd param1) {
         // $FF: Couldn't be decompiled
      }

      public void failedToReceiveAd(int param1) {
         // $FF: Couldn't be decompiled
      }
   }

   private static class b {
      final Object a;
      boolean b;
      final Collection c;

      private b() {
         this.a = new Object();
         this.c = new HashSet();
      }

      // $FF: synthetic method
      b(AppLovinAdServiceImpl$1 var1) {
         this();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("AdLoadState{, isWaitingForAd=");
         var1.append(this.b);
         var1.append(", pendingAdListeners=");
         var1.append(this.c);
         var1.append('}');
         return var1.toString();
      }
   }
}
