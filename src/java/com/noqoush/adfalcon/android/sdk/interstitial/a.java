package com.noqoush.adfalcon.android.sdk.interstitial;

import android.content.Context;
import com.noqoush.adfalcon.android.sdk.w;
import com.noqoush.adfalcon.android.sdk.x;
import java.lang.ref.SoftReference;

public class a {
   private SoftReference a;
   private w b;
   private x c;
   private c d;
   private b e;
   private boolean f;
   private String g;

   public a(Context var1, w var2, x var3, c var4, b var5, boolean var6, String var7) {
      this.a(var1);
      this.a(var2);
      this.a(var3);
      this.a(var4);
      this.a(var5);
      this.a(var6);
      this.a(var7);
   }

   public Context a() {
      SoftReference var1 = this.a;
      return var1 == null ? null : (Context)var1.get();
   }

   public void a(Context var1) {
      SoftReference var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = new SoftReference(var1);
      }

      this.a = var2;
   }

   public void a(b var1) {
      this.e = var1;
   }

   public void a(c var1) {
      this.d = var1;
   }

   public void a(w var1) {
      this.b = var1;
   }

   public void a(x var1) {
      this.c = var1;
   }

   public void a(String var1) {
      this.g = var1;
   }

   public void a(boolean var1) {
      this.f = var1;
   }

   public b b() {
      return this.e;
   }

   public x c() {
      return this.c;
   }

   public String d() {
      return this.g;
   }

   public c e() {
      return this.d;
   }

   public w f() {
      return this.b;
   }

   public boolean g() {
      return this.f;
   }
}
