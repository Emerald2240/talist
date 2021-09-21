package com.applovin.impl.adview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.text.TextUtils;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class n implements AppLovinInterstitialAdDialog {
   public static volatile boolean b = false;
   public static volatile boolean c = false;
   private static final Map d = Collections.synchronizedMap(new HashMap());
   private static volatile boolean n;
   protected final com.applovin.impl.sdk.j a;
   private final String e;
   private final WeakReference f;
   private volatile AppLovinAdLoadListener g;
   private volatile AppLovinAdDisplayListener h;
   private volatile AppLovinAdVideoPlaybackListener i;
   private volatile AppLovinAdClickListener j;
   private volatile com.applovin.impl.sdk.ad.f k;
   private volatile com.applovin.impl.sdk.ad.f.b l;
   private volatile j m;

   n(AppLovinSdk var1, Context var2) {
      if (var1 != null) {
         if (var2 != null) {
            this.a = com.applovin.impl.sdk.utils.q.a(var1);
            this.e = UUID.randomUUID().toString();
            this.f = new WeakReference(var2);
            b = true;
            c = false;
         } else {
            throw new IllegalArgumentException("No context specified");
         }
      } else {
         throw new IllegalArgumentException("No sdk specified");
      }
   }

   public static n a(String var0) {
      return (n)d.get(var0);
   }

   // $FF: synthetic method
   static AppLovinAdLoadListener a(n var0) {
      return var0.g;
   }

   private void a(int var1) {
      AppLovinSdkUtils.runOnUiThread(new n$5(this, var1));
   }

   private void a(Context var1) {
      Intent var2 = new Intent(var1, AppLovinInterstitialActivity.class);
      var2.putExtra("com.applovin.interstitial.wrapper_id", this.e);
      com.applovin.impl.adview.m.lastKnownWrapper = this;
      ThreadPolicy var4 = StrictMode.allowThreadDiskReads();
      if (var1 instanceof Activity) {
         label25:
         try {
            var1.startActivity(var2);
            ((Activity)var1).overridePendingTransition(0, 0);
         } catch (Throwable var8) {
            this.a.v().b("InterstitialAdDialogWrapper", "Unable to remove pending transition animations", var8);
            break label25;
         }
      } else {
         var2.setFlags(268435456);
         var1.startActivity(var2);
      }

      StrictMode.setThreadPolicy(var4);
      this.a(true);
   }

   // $FF: synthetic method
   static void a(n var0, Context var1) {
      var0.a(var1);
   }

   private void a(com.applovin.impl.sdk.ad.f var1, Context var2) {
      d.put(this.e, this);
      this.k = var1;
      this.l = this.k.l();
      long var4 = Math.max(0L, (Long)this.a.a(com.applovin.impl.sdk.b.d.cS));
      com.applovin.impl.sdk.p var6 = this.a.v();
      StringBuilder var7 = new StringBuilder();
      var7.append("Presenting ad with delay of ");
      var7.append(var4);
      var6.b("InterstitialAdDialogWrapper", var7.toString());
      this.a(var1, var2, new n$2(this, var2, var4));
   }

   private void a(com.applovin.impl.sdk.ad.f var1, Context var2, Runnable var3) {
      if (TextUtils.isEmpty(var1.K()) && var1.am() && !com.applovin.impl.sdk.utils.h.a(var2) && var2 instanceof Activity) {
         AlertDialog var4 = (new Builder(var2)).setTitle(var1.an()).setMessage(var1.ao()).setPositiveButton(var1.ap(), (OnClickListener)null).create();
         var4.setOnDismissListener(new n$3(this, var3));
         var4.show();
      } else {
         var3.run();
      }
   }

   private void a(AppLovinAd var1) {
      if (this.h != null) {
         this.h.adHidden(var1);
      }

      n = false;
   }

   // $FF: synthetic method
   static j b(n var0) {
      return var0.m;
   }

   private void b(AppLovinAd var1) {
      AppLovinSdkUtils.runOnUiThread(new n$4(this, var1));
   }

   private Context h() {
      WeakReference var1 = this.f;
      return var1 != null ? (Context)var1.get() : null;
   }

   public com.applovin.impl.sdk.j a() {
      return this.a;
   }

   public void a(j var1) {
      this.m = var1;
   }

   protected void a(AppLovinAdLoadListener var1) {
      this.a.o().loadNextAd(AppLovinAdSize.INTERSTITIAL, var1);
   }

   public void a(boolean var1) {
      n = var1;
   }

   public AppLovinAd b() {
      return this.k;
   }

   public AppLovinAdVideoPlaybackListener c() {
      return this.i;
   }

   public AppLovinAdDisplayListener d() {
      return this.h;
   }

   public void dismiss() {
      AppLovinSdkUtils.runOnUiThread(new n$6(this));
   }

   public AppLovinAdClickListener e() {
      return this.j;
   }

   public com.applovin.impl.sdk.ad.f.b f() {
      return this.l;
   }

   public void g() {
      b = false;
      c = true;
      d.remove(this.e);
      if (this.k != null && this.k.S()) {
         this.m = null;
      }

   }

   public boolean isAdReadyToDisplay() {
      return this.a.o().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
   }

   public boolean isShowing() {
      return n;
   }

   public void setAdClickListener(AppLovinAdClickListener var1) {
      this.j = var1;
   }

   public void setAdDisplayListener(AppLovinAdDisplayListener var1) {
      this.h = var1;
   }

   public void setAdLoadListener(AppLovinAdLoadListener var1) {
      this.g = var1;
   }

   public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener var1) {
      this.i = var1;
   }

   public void show() {
      this.show((String)null);
   }

   public void show(final String var1) {
      this.a(new AppLovinAdLoadListener() {
         public void adReceived(AppLovinAd var1x) {
            n.this.b(var1x);
            n.this.showAndRender(var1x, var1);
         }

         public void failedToReceiveAd(int var1x) {
            n.this.a(var1x);
         }
      });
   }

   public void showAndRender(AppLovinAd var1) {
      this.showAndRender(var1, (String)null);
   }

   public void showAndRender(AppLovinAd var1, String var2) {
      if (this.isShowing() && !(Boolean)this.a.a(com.applovin.impl.sdk.b.d.eZ)) {
         com.applovin.impl.sdk.p.j("AppLovinInterstitialAdDialog", "Attempted to show an interstitial while one is already displayed; ignoring.");
         if (this.h instanceof com.applovin.impl.sdk.ad.i) {
            ((com.applovin.impl.sdk.ad.i)this.h).onAdDisplayFailed("Attempted to show an interstitial while one is already displayed; ignoring.");
         }

      } else {
         Context var3 = this.h();
         String var5;
         com.applovin.impl.sdk.p var4;
         if (var3 != null) {
            AppLovinAd var6 = com.applovin.impl.sdk.utils.q.a(var1, this.a);
            if (var6 != null) {
               if (var6 instanceof com.applovin.impl.sdk.ad.f) {
                  this.a((com.applovin.impl.sdk.ad.f)var6, var3);
                  return;
               }

               com.applovin.impl.sdk.p var10 = this.a.v();
               StringBuilder var11 = new StringBuilder();
               var11.append("Failed to show interstitial: unknown ad type provided: '");
               var11.append(var6);
               var11.append("'");
               var10.e("InterstitialAdDialogWrapper", var11.toString());
               this.a(var6);
               return;
            }

            var4 = this.a.v();
            StringBuilder var7 = new StringBuilder();
            var7.append("Failed to show ad: ");
            var7.append(var1);
            var5 = var7.toString();
         } else {
            var4 = this.a.v();
            var5 = "Failed to show interstitial: stale activity reference provided";
         }

         var4.e("InterstitialAdDialogWrapper", var5);
         this.a(var1);
      }
   }

   public String toString() {
      return "AppLovinInterstitialAdDialog{}";
   }
}
