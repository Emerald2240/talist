package com.noqoush.adfalcon.android.sdk.nativead.data;

import android.app.Activity;
import com.noqoush.adfalcon.android.sdk.ADFTargetingParams;
import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;
import com.noqoush.adfalcon.android.sdk.handler.d;
import com.noqoush.adfalcon.android.sdk.nativead.ADFNativeAd;
import com.noqoush.adfalcon.android.sdk.nativead.ADFNativeAdStatus;
import com.noqoush.adfalcon.android.sdk.nativead.assets.ADFAssetsBinder;
import com.noqoush.adfalcon.android.sdk.nativead.mngr.b;
import com.noqoush.adfalcon.android.sdk.response.k;
import java.lang.ref.WeakReference;

public class a {
   private String a;
   private boolean b;
   private ADFTargetingParams c;
   private ADFAssetsBinder d;
   private k e;
   private WeakReference f;
   private WeakReference g;
   private b h = new b(this);
   private com.noqoush.adfalcon.android.sdk.nativead.a i;
   private boolean j;
   private d k;

   public void a() {
      this.c = null;
      this.d = null;
      this.e = null;
      this.f = null;
      this.h = null;
      this.i = null;
      this.g = null;
      this.o();
   }

   public void a(Activity var1) {
      this.g = new WeakReference(var1);
   }

   public void a(ADFTargetingParams var1) {
      this.c = var1;
   }

   public void a(d var1) {
      this.k = var1;
   }

   public void a(ADFNativeAd var1) {
      this.f = new WeakReference(var1);
   }

   public void a(ADFNativeAdStatus var1, String var2, ADFErrorCode var3) throws Exception {
      if (var1 == ADFNativeAdStatus.clicked) {
         this.h().onViewabilityClick();
      }

      this.h.a(var1, var2, var3);
   }

   public void a(com.noqoush.adfalcon.android.sdk.nativead.a var1) {
      this.i = var1;
   }

   public void a(ADFAssetsBinder var1) {
      this.d = var1;
   }

   public void a(k var1) {
      this.e = var1;
      this.h().setViewabilityResponse(var1);
   }

   public void a(String var1) {
      this.a = var1;
   }

   public void a(boolean var1) {
      this.j = var1;
   }

   public Activity b() {
      WeakReference var1 = this.g;
      return var1 == null ? null : (Activity)var1.get();
   }

   public void b(boolean var1) {
      this.b = var1;
   }

   public com.noqoush.adfalcon.android.sdk.nativead.a c() {
      com.noqoush.adfalcon.android.sdk.nativead.a var1 = this.i;
      if (var1 == null) {
         var1 = null;
      }

      return var1;
   }

   public ADFNativeAdStatus d() {
      b var1 = this.h;
      return var1 == null ? ADFNativeAdStatus.none : var1.b();
   }

   public ADFAssetsBinder e() {
      return this.d;
   }

   public ADFErrorCode f() {
      return this.h.c();
   }

   public String g() {
      return this.h.d();
   }

   public ADFNativeAd h() {
      WeakReference var1 = this.f;
      return var1 == null ? null : (ADFNativeAd)var1.get();
   }

   public k i() {
      return this.e;
   }

   public String j() {
      return this.a;
   }

   public ADFTargetingParams k() {
      return this.c;
   }

   public d l() {
      return this.k;
   }

   public boolean m() {
      return this.j;
   }

   public boolean n() {
      return this.b;
   }

   public void o() {
      try {
         if (this.l() != null && this.l().c()) {
            this.l().interrupt();
            this.k = null;
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }
}
