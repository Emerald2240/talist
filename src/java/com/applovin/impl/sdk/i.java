package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinUserService;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class i implements h.a, AppLovinWebViewActivity.EventListener {
   private static final AtomicBoolean a = new AtomicBoolean();
   private static WeakReference b;
   private final j c;
   private final p d;
   private AppLovinUserService.OnConsentDialogDismissListener e;
   private h f;
   private WeakReference g = new WeakReference((Object)null);
   private com.applovin.impl.sdk.utils.a h;

   i(j var1) {
      this.c = var1;
      this.d = var1.v();
      if (var1.F() != null) {
         this.g = new WeakReference(var1.F());
      }

      var1.aa().a(new com.applovin.impl.sdk.utils.a() {
         public void onActivityStarted(Activity var1) {
            i.this.g = new WeakReference(var1);
         }
      });
      this.f = new h(this, var1);
   }

   // $FF: synthetic method
   static j a(i var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static com.applovin.impl.sdk.utils.a a(i var0, com.applovin.impl.sdk.utils.a var1) {
      var0.h = var1;
      return var1;
   }

   // $FF: synthetic method
   static AppLovinUserService.OnConsentDialogDismissListener a(i var0, AppLovinUserService.OnConsentDialogDismissListener var1) {
      var0.e = var1;
      return var1;
   }

   // $FF: synthetic method
   static WeakReference a(WeakReference var0) {
      b = var0;
      return var0;
   }

   private void a(boolean var1, long var2) {
      this.f();
      if (var1) {
         this.a(var2);
      }

   }

   // $FF: synthetic method
   static boolean a(i var0, j var1) {
      return var0.a(var1);
   }

   private boolean a(j var1) {
      if (this.c()) {
         p.j("AppLovinSdk", "Consent dialog already showing");
         return false;
      } else if (!com.applovin.impl.sdk.utils.h.a(var1.D())) {
         p.j("AppLovinSdk", "No internet available, skip showing of consent dialog");
         return false;
      } else if (!(Boolean)var1.a(com.applovin.impl.sdk.b.d.an)) {
         this.d.e("ConsentDialogManager", "Blocked publisher from showing consent dialog");
         return false;
      } else if (!com.applovin.impl.sdk.utils.n.b((String)var1.a(com.applovin.impl.sdk.b.d.ao))) {
         this.d.e("ConsentDialogManager", "AdServer returned empty consent dialog URL");
         return false;
      } else {
         return true;
      }
   }

   // $FF: synthetic method
   static com.applovin.impl.sdk.utils.a b(i var0) {
      return var0.h;
   }

   // $FF: synthetic method
   static p c(i var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static h d(i var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static AtomicBoolean d() {
      return a;
   }

   // $FF: synthetic method
   static WeakReference e() {
      return b;
   }

   private void f() {
      this.c.aa().b(this.h);
      if (this.c()) {
         AppLovinWebViewActivity var1 = (AppLovinWebViewActivity)b.get();
         b = null;
         if (var1 != null) {
            var1.finish();
            AppLovinUserService.OnConsentDialogDismissListener var2 = this.e;
            if (var2 != null) {
               var2.onDismiss();
               this.e = null;
            }
         }
      }

   }

   public void a() {
      if (this.g.get() != null) {
         Activity var1 = (Activity)this.g.get();
         long var2 = (Long)this.c.a(com.applovin.impl.sdk.b.d.aq);
         AppLovinSdkUtils.runOnUiThreadDelayed(new i$4(this, var1), var2);
      }

   }

   public void a(long var1) {
      AppLovinSdkUtils.runOnUiThread(new i$3(this, var1));
   }

   public void a(Activity var1, AppLovinUserService.OnConsentDialogDismissListener var2) {
      var1.runOnUiThread(new i$2(this, var2, var1));
   }

   public void b() {
   }

   boolean c() {
      WeakReference var1 = b;
      return var1 != null && var1.get() != null;
   }

   public void onReceivedEvent(String var1) {
      if ("accepted".equalsIgnoreCase(var1)) {
         AppLovinPrivacySettings.setHasUserConsent(true, this.c.D());
         this.f();
      } else {
         com.applovin.impl.sdk.b.d var4;
         boolean var2;
         j var3;
         if ("rejected".equalsIgnoreCase(var1)) {
            AppLovinPrivacySettings.setHasUserConsent(false, this.c.D());
            var2 = (Boolean)this.c.a(com.applovin.impl.sdk.b.d.ar);
            var3 = this.c;
            var4 = com.applovin.impl.sdk.b.d.aw;
         } else if ("closed".equalsIgnoreCase(var1)) {
            var2 = (Boolean)this.c.a(com.applovin.impl.sdk.b.d.as);
            var3 = this.c;
            var4 = com.applovin.impl.sdk.b.d.ax;
         } else {
            if (!"dismissed_via_back_button".equalsIgnoreCase(var1)) {
               return;
            }

            var2 = (Boolean)this.c.a(com.applovin.impl.sdk.b.d.at);
            var3 = this.c;
            var4 = com.applovin.impl.sdk.b.d.ay;
         }

         this.a(var2, (Long)var3.a(var4));
      }
   }
}
