package com.noqoush.adfalcon.android.sdk.video.vast.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.noqoush.adfalcon.android.sdk.ADFTargetingParams;
import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;
import com.noqoush.adfalcon.android.sdk.video.vast.model.p;
import com.noqoush.adfalcon.android.sdk.video.vast.model.y;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.ArrayList;

public class d implements com.noqoush.adfalcon.android.sdk.conn.b {
   private com.noqoush.adfalcon.android.sdk.conn.a a;
   private p b;
   private p c;
   private f d;
   private y e;
   private y f;
   private boolean g;
   private int h = 0;
   private boolean i;
   private com.noqoush.adfalcon.android.sdk.g j;
   private String k;
   private ADFTargetingParams l;
   private WeakReference m;

   d(Context var1, f var2) {
      this.a(var1);
      this.a(var2);
   }

   // $FF: synthetic method
   static HttpURLConnection a(d var0) throws Exception {
      return var0.i();
   }

   private void a(ADFTargetingParams var1) {
      this.l = var1;
   }

   private void a(com.noqoush.adfalcon.android.sdk.conn.a var1) {
      this.a = var1;
   }

   private void a(ADFErrorCode var1, String var2) {
      this.a((ADFErrorCode)var1, (String)var2, (ArrayList)null);
   }

   private void a(ADFErrorCode var1, String var2, ArrayList var3) {
      if (this.o() != null) {
         this.o().failedToLoadAd(this, var1, var2, var3);
      }
   }

   private void a(com.noqoush.adfalcon.android.sdk.g var1) {
      this.j = var1;
   }

   // $FF: synthetic method
   static void a(d var0, com.noqoush.adfalcon.android.sdk.conn.a var1) {
      var0.a(var1);
   }

   private void a(f var1) {
      this.d = var1;
   }

   private void a(p var1) {
      this.b = var1;
   }

   private void a(y var1) {
      this.f = var1;
   }

   private void a(boolean var1) {
      this.g = var1;
   }

   // $FF: synthetic method
   static com.noqoush.adfalcon.android.sdk.conn.a b(d var0) {
      return var0.h();
   }

   private HttpURLConnection b(String var1) throws Exception {
      return (new com.noqoush.adfalcon.android.sdk.conn.c()).e(var1).a();
   }

   private void b(p var1) {
      this.c = var1;
   }

   private void b(y var1) {
      this.e = var1;
   }

   private void b(boolean var1) {
      this.i = var1;
   }

   private void c(String param1) {
      // $FF: Couldn't be decompiled
   }

   private void d(String var1) {
      this.k = var1;
   }

   private com.noqoush.adfalcon.android.sdk.conn.a h() {
      return this.a;
   }

   private HttpURLConnection i() throws Exception {
      return (new com.noqoush.adfalcon.android.sdk.conn.c()).d(this.m()).a("v").b("vast").c("1,2,4,5,3,6,7,8,9,10").a(this.n()).b().d().e().a(this.d(), this.k()).a(this.d()).b(this.d()).a();
   }

   private p j() {
      return this.b;
   }

   private com.noqoush.adfalcon.android.sdk.g k() {
      return this.j;
   }

   private y l() {
      return this.f;
   }

   private String m() {
      return this.k;
   }

   private ADFTargetingParams n() {
      return this.l;
   }

   private f o() {
      f var1 = this.d;
      if (var1 == null) {
         var1 = null;
      }

      return var1;
   }

   private p p() {
      return this.c;
   }

   private y q() {
      return this.e;
   }

   private int r() {
      return this.h;
   }

   private boolean s() throws Exception {
      return this.r() > 0;
   }

   private void t() {
      ++this.h;
   }

   private void u() throws Exception {
      if (this.r() < 5) {
         if (this.l() != null && !this.l().t()) {
            if (this.o() != null) {
               this.a(ADFErrorCode.NO_AVAILABLE_AD, "No available ad");
            }

         } else if (!this.f()) {
            this.a(new com.noqoush.adfalcon.android.sdk.conn.a());
            HttpURLConnection var1 = this.b(this.q().q());
            this.h().a((HttpURLConnection)var1, (com.noqoush.adfalcon.android.sdk.conn.b)this);
            this.t();
         } else {
            throw new Exception("Request already sent");
         }
      } else {
         throw new Exception("More than 5 vast redirects");
      }
   }

   private void v() throws Exception {
      this.b(true);
      if (this.o() != null) {
         if (this.s()) {
            this.o().didWrapAd(this);
         }

         this.o().didLoadAd(this, this.p());
      }

   }

   public void a() {
      this.a(true);
   }

   public void a(int var1, String var2, ADFErrorCode var3) {
      this.a(false);
      this.a(var3, var2);
   }

   public void a(Context var1) {
      this.m = new WeakReference(var1);
   }

   public void a(String var1) {
      try {
         this.a(false);
         this.c(var1);
      } catch (Exception var3) {
         this.a(ADFErrorCode.GENERIC_SDK_ERROR, "Error while loading ad");
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }

   void a(String var1, ADFTargetingParams var2, com.noqoush.adfalcon.android.sdk.g var3) throws Exception {
      this.d(var1);
      this.a(var2);
      this.a(var3);
      if (!this.f()) {
         if (this.o() != null) {
            this.o().willLoadAd(this);
         }

         (new Thread(new d$a(this, new Handler(Looper.getMainLooper())))).start();
      }
   }

   public void b() {
      this.a(false);
      this.a(ADFErrorCode.COMMUNICATION_ERROR, "Ad loading has been cancelled");
   }

   public void c() {
      try {
         if (this.h() != null && this.f()) {
            this.h().a();
         }

         this.d((String)null);
         this.a((ADFTargetingParams)null);
         this.a((com.noqoush.adfalcon.android.sdk.g)null);
         this.a((f)null);
         this.b((p)null);
         this.a((com.noqoush.adfalcon.android.sdk.conn.a)null);
         this.a((p)null);
         this.b((y)null);
         this.b(false);
         this.a(false);
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public Context d() {
      WeakReference var1 = this.m;
      return var1 == null ? null : (Context)var1.get();
   }

   public boolean e() {
      return this.g();
   }

   public boolean f() {
      return this.g;
   }

   public boolean g() {
      return this.i;
   }
}
