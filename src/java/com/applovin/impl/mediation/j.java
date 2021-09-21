package com.applovin.impl.mediation;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.utils.n;
import com.applovin.impl.sdk.utils.o;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class j {
   private final List a = Collections.synchronizedList(new ArrayList());
   private final <undefinedtype> b;
   private final <undefinedtype> c;

   public j(com.applovin.impl.sdk.j var1) {
      MaxAdListener var2 = new MaxAdListener(com.applovin.impl.sdk.b.c.O, MaxAdFormat.INTERSTITIAL, this, var1, null) {
         private final com.applovin.impl.sdk.j a;
         private final j b;
         private final MaxAdFormat c;
         private final com.applovin.impl.sdk.b.d d;
         private MaxAdListener e;
         private com.applovin.impl.mediation.b.c f;
         private final Object g;
         private o h;
         private long i;
         private final AtomicBoolean j;
         private volatile boolean k;

         private {
            this.g = new Object();
            this.j = new AtomicBoolean();
            this.b = var3;
            this.a = var4;
            this.d = var1;
            this.c = var2;
            var4.af().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
            var4.af().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
         }

         private void a(long var1) {
            if (var1 > 0L) {
               this.i = var1 + System.currentTimeMillis();
               this.h = o.a(var1, this.a, new Runnable() {
                  // $FF: synthetic field
                  final <undefinedtype> a;

                  {
                     this.a = var1;
                  }

                  public void run() {
                     null.a(this.a, true);
                  }
               });
            }

         }

         // $FF: synthetic method
         static void a(Object var0, boolean var1) {
            var0.b(var1);
         }

         private void a(boolean var1) {
            if (this.a.Y().a()) {
               this.k = var1;
               this.j.set(true);
            } else {
               String var2 = (String)this.a.a(this.d);
               if (n.b(var2)) {
                  f var3 = (new f.a()).a("fa", String.valueOf(true)).a("faie", String.valueOf(var1)).a();
                  this.a.y().loadAd(var2, this.c, var3, true, this.a.ag(), this);
               }

            }
         }

         private void b() {
            this.a(false);
         }

         private void b(boolean param1) {
            // $FF: Couldn't be decompiled
         }

         private void c() {
            Object var1 = this.g;
            synchronized(var1){}

            Throwable var10000;
            boolean var10001;
            label122: {
               try {
                  if (this.h != null) {
                     this.h.d();
                     this.h = null;
                  }
               } catch (Throwable var15) {
                  var10000 = var15;
                  var10001 = false;
                  break label122;
               }

               label119:
               try {
                  return;
               } catch (Throwable var14) {
                  var10000 = var14;
                  var10001 = false;
                  break label119;
               }
            }

            while(true) {
               Throwable var2 = var10000;

               try {
                  throw var2;
               } catch (Throwable var13) {
                  var10000 = var13;
                  var10001 = false;
                  continue;
               }
            }
         }

         public void a() {
            if (this.j.compareAndSet(true, false)) {
               this.a(this.k);
            } else {
               long var1 = this.i;
               if (var1 != 0L) {
                  long var3 = var1 - System.currentTimeMillis();
                  if (var3 <= 0L) {
                     this.b(true);
                  } else {
                     this.a(var3);
                  }
               }
            }
         }

         public void onAdClicked(MaxAd var1) {
            this.e.onAdClicked(var1);
         }

         public void onAdDisplayFailed(MaxAd var1, int var2) {
            this.e.onAdDisplayFailed(var1, var2);
         }

         public void onAdDisplayed(MaxAd var1) {
            this.e.onAdDisplayed(var1);
            this.b(false);
         }

         public void onAdHidden(MaxAd var1) {
            this.e.onAdHidden(var1);
            this.e = null;
         }

         public void onAdLoadFailed(String var1, int var2) {
            long var3 = TimeUnit.SECONDS.toMillis((Long)this.a.a(com.applovin.impl.sdk.b.c.R));
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
               // $FF: synthetic field
               final <undefinedtype> a;

               {
                  this.a = var1;
               }

               public void run() {
                  null.a(this.a);
               }
            }, var3);
         }

         public void onAdLoaded(MaxAd var1) {
            this.f = (com.applovin.impl.mediation.b.c)var1;
            this.a(this.f.l());
            Iterator var2 = (new ArrayList(this.b.a)).iterator();

            while(var2.hasNext()) {
               ((j.b)var2.next()).a(this.f);
            }

         }

         public void onReceive(Context var1, Intent var2) {
            String var3 = var2.getAction();
            if ("com.applovin.application_paused".equals(var3)) {
               this.c();
            } else {
               if ("com.applovin.application_resumed".equals(var3)) {
                  this.a();
               }

            }
         }

         public void onRewardedVideoCompleted(MaxAd var1) {
            MaxAdListener var2 = this.e;
            if (var2 instanceof MaxRewardedAdListener) {
               ((MaxRewardedAdListener)var2).onRewardedVideoCompleted(var1);
            }

         }

         public void onRewardedVideoStarted(MaxAd var1) {
            MaxAdListener var2 = this.e;
            if (var2 instanceof MaxRewardedAdListener) {
               ((MaxRewardedAdListener)var2).onRewardedVideoStarted(var1);
            }

         }

         public void onUserRewarded(MaxAd var1, MaxReward var2) {
            MaxAdListener var3 = this.e;
            if (var3 instanceof MaxRewardedAdListener) {
               ((MaxRewardedAdListener)var3).onUserRewarded(var1, var2);
            }

         }
      };
      this.b = var2;
      MaxAdListener var3 = new MaxAdListener(com.applovin.impl.sdk.b.c.P, MaxAdFormat.REWARDED, this, var1, null) {
         private final com.applovin.impl.sdk.j a;
         private final j b;
         private final MaxAdFormat c;
         private final com.applovin.impl.sdk.b.d d;
         private MaxAdListener e;
         private com.applovin.impl.mediation.b.c f;
         private final Object g;
         private o h;
         private long i;
         private final AtomicBoolean j;
         private volatile boolean k;

         private {
            this.g = new Object();
            this.j = new AtomicBoolean();
            this.b = var3;
            this.a = var4;
            this.d = var1;
            this.c = var2;
            var4.af().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
            var4.af().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
         }

         private void a(long var1) {
            if (var1 > 0L) {
               this.i = var1 + System.currentTimeMillis();
               this.h = o.a(var1, this.a, new Runnable() {
                  // $FF: synthetic field
                  final <undefinedtype> a;

                  {
                     this.a = var1;
                  }

                  public void run() {
                     null.a(this.a, true);
                  }
               });
            }

         }

         // $FF: synthetic method
         static void a(Object var0, boolean var1) {
            var0.b(var1);
         }

         private void a(boolean var1) {
            if (this.a.Y().a()) {
               this.k = var1;
               this.j.set(true);
            } else {
               String var2 = (String)this.a.a(this.d);
               if (n.b(var2)) {
                  f var3 = (new f.a()).a("fa", String.valueOf(true)).a("faie", String.valueOf(var1)).a();
                  this.a.y().loadAd(var2, this.c, var3, true, this.a.ag(), this);
               }

            }
         }

         private void b() {
            this.a(false);
         }

         private void b(boolean param1) {
            // $FF: Couldn't be decompiled
         }

         private void c() {
            Object var1 = this.g;
            synchronized(var1){}

            Throwable var10000;
            boolean var10001;
            label122: {
               try {
                  if (this.h != null) {
                     this.h.d();
                     this.h = null;
                  }
               } catch (Throwable var15) {
                  var10000 = var15;
                  var10001 = false;
                  break label122;
               }

               label119:
               try {
                  return;
               } catch (Throwable var14) {
                  var10000 = var14;
                  var10001 = false;
                  break label119;
               }
            }

            while(true) {
               Throwable var2 = var10000;

               try {
                  throw var2;
               } catch (Throwable var13) {
                  var10000 = var13;
                  var10001 = false;
                  continue;
               }
            }
         }

         public void a() {
            if (this.j.compareAndSet(true, false)) {
               this.a(this.k);
            } else {
               long var1 = this.i;
               if (var1 != 0L) {
                  long var3 = var1 - System.currentTimeMillis();
                  if (var3 <= 0L) {
                     this.b(true);
                  } else {
                     this.a(var3);
                  }
               }
            }
         }

         public void onAdClicked(MaxAd var1) {
            this.e.onAdClicked(var1);
         }

         public void onAdDisplayFailed(MaxAd var1, int var2) {
            this.e.onAdDisplayFailed(var1, var2);
         }

         public void onAdDisplayed(MaxAd var1) {
            this.e.onAdDisplayed(var1);
            this.b(false);
         }

         public void onAdHidden(MaxAd var1) {
            this.e.onAdHidden(var1);
            this.e = null;
         }

         public void onAdLoadFailed(String var1, int var2) {
            long var3 = TimeUnit.SECONDS.toMillis((Long)this.a.a(com.applovin.impl.sdk.b.c.R));
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
               // $FF: synthetic field
               final <undefinedtype> a;

               {
                  this.a = var1;
               }

               public void run() {
                  null.a(this.a);
               }
            }, var3);
         }

         public void onAdLoaded(MaxAd var1) {
            this.f = (com.applovin.impl.mediation.b.c)var1;
            this.a(this.f.l());
            Iterator var2 = (new ArrayList(this.b.a)).iterator();

            while(var2.hasNext()) {
               ((j.b)var2.next()).a(this.f);
            }

         }

         public void onReceive(Context var1, Intent var2) {
            String var3 = var2.getAction();
            if ("com.applovin.application_paused".equals(var3)) {
               this.c();
            } else {
               if ("com.applovin.application_resumed".equals(var3)) {
                  this.a();
               }

            }
         }

         public void onRewardedVideoCompleted(MaxAd var1) {
            MaxAdListener var2 = this.e;
            if (var2 instanceof MaxRewardedAdListener) {
               ((MaxRewardedAdListener)var2).onRewardedVideoCompleted(var1);
            }

         }

         public void onRewardedVideoStarted(MaxAd var1) {
            MaxAdListener var2 = this.e;
            if (var2 instanceof MaxRewardedAdListener) {
               ((MaxRewardedAdListener)var2).onRewardedVideoStarted(var1);
            }

         }

         public void onUserRewarded(MaxAd var1, MaxReward var2) {
            MaxAdListener var3 = this.e;
            if (var3 instanceof MaxRewardedAdListener) {
               ((MaxRewardedAdListener)var3).onUserRewarded(var1, var2);
            }

         }
      };
      this.c = var3;
   }

   private <undefinedtype> b(MaxAdFormat var1) {
      if (MaxAdFormat.INTERSTITIAL == var1) {
         return this.b;
      } else {
         return MaxAdFormat.REWARDED == var1 ? this.c : null;
      }
   }

   public com.applovin.impl.mediation.b.c a(MaxAdFormat var1) {
      <undefinedtype> var2 = this.b(var1);
      return var2 != null ? var2.f : null;
   }

   public void a() {
      this.b.b();
      this.c.b();
   }

   public void a(j.b var1) {
      this.a.add(var1);
   }

   public void a(MaxAdListener var1, MaxAdFormat var2) {
      <undefinedtype> var3 = this.b(var2);
      if (var3 != null) {
         var3.e = var1;
      }

   }

   public void b(j.b var1) {
      this.a.remove(var1);
   }

   public interface b {
      void a(com.applovin.impl.mediation.b.c var1);
   }
}
