package com.noqoush.adfalcon.android.sdk.nativead;

import android.view.View;
import com.noqoush.adfalcon.android.sdk.k;
import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;
import java.util.Hashtable;

public class a {
   private ADFNativeAd a;
   private ADFNativeAdListener b;
   private boolean c = false;

   public a(ADFNativeAd var1, ADFNativeAdListener var2) {
      this.a(var1);
      this.a(var2);
   }

   public void a() {
      if (this.f() == null) {
         k.c("Native Ad Listener is null");
      }

      if (this.e() == null) {
         k.c("Native Ad is null");
      }

      if (this.f() != null && this.e() != null) {
         this.f().onDismissAdScreen(this.e());
      }

   }

   public void a(View var1, Hashtable var2) {
      if (this.f() != null && var1 != null && var2 != null) {
         this.f().renderExtraData(var1, var2);
      }

   }

   public void a(ADFNativeAd var1) {
      this.a = var1;
   }

   public void a(ADFNativeAdListener var1) {
      this.b = var1;
   }

   public void a(String var1, ADFErrorCode var2) {
      if (this.f() == null) {
         k.c("Native Ad Listener is null");
      }

      if (this.e() == null) {
         k.c("Native Ad is null");
      }

      if (this.f() != null && this.e() != null && var1 != null && var2 != null) {
         this.f().onFail(this.e(), var2, var1);
      }

   }

   public void a(boolean var1) {
      this.c = var1;
   }

   public boolean a(String var1) {
      return this.f() != null && var1 != null ? this.f().handleCustomAction(var1) : false;
   }

   public void b() {
      if (this.f() == null) {
         k.c("Native Ad Listener is null");
      }

      if (this.e() == null) {
         k.c("Native Ad is null");
      }

      if (this.f() != null && this.e() != null) {
         this.f().onLoadAd(this.e());
      }

   }

   public void c() {
      if (this.f() == null) {
         k.c("Native Ad Listener is null");
      }

      if (this.e() == null) {
         k.c("Native Ad is null");
      }

      if (this.f() != null && this.e() != null) {
         this.a(true);
         this.f().onPresentAdScreen(this.e());
      }

   }

   public void d() {
      if (this.f() == null) {
         k.c("Native Ad Listener is null");
      }

      if (this.e() == null) {
         k.c("Native Ad is null");
      }

      if (this.f() != null) {
         this.f().onLeaveApplication();
      }

   }

   public ADFNativeAd e() {
      return this.a;
   }

   public ADFNativeAdListener f() {
      return this.b;
   }

   public boolean g() {
      return this.c;
   }
}
