package com.applovin.impl.sdk;

import android.util.Log;

public class p {
   private final j a;

   p(j var1) {
      this.a = var1;
   }

   private void a(String var1, String var2, boolean var3) {
      if (com.applovin.impl.sdk.utils.n.b(var2)) {
         int var4 = (Integer)this.a.a(com.applovin.impl.sdk.b.d.ak);
         if (var4 > 0) {
            int var5 = var2.length();
            int var6 = (-1 + var5 + var4) / var4;

            for(int var7 = 0; var7 < var6; ++var7) {
               int var8 = var7 * var4;
               String var9 = var2.substring(var8, Math.min(var5, var8 + var4));
               if (var3) {
                  Log.d(var1, var9);
               } else {
                  this.b(var1, var9);
               }
            }
         }

      }
   }

   private boolean a() {
      return this.a.C().e();
   }

   public static void c(String var0, String var1, Throwable var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("[");
      var3.append(var0);
      var3.append("] ");
      var3.append(var1);
      Log.e("AppLovinSdk", var3.toString(), var2);
   }

   public static void g(String var0, String var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("[");
      var2.append(var0);
      var2.append("] ");
      var2.append(var1);
      Log.d("AppLovinSdk", var2.toString());
   }

   public static void h(String var0, String var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("[");
      var2.append(var0);
      var2.append("] ");
      var2.append(var1);
      Log.i("AppLovinSdk", var2.toString());
   }

   public static void i(String var0, String var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("[");
      var2.append(var0);
      var2.append("] ");
      var2.append(var1);
      Log.w("AppLovinSdk", var2.toString());
   }

   public static void j(String var0, String var1) {
      c(var0, var1, (Throwable)null);
   }

   private void k(String var1, String var2) {
   }

   public void a(String var1, Boolean var2, String var3) {
      this.a(var1, var2, var3, (Throwable)null);
   }

   public void a(String var1, Boolean var2, String var3, Throwable var4) {
      if (this.a()) {
         StringBuilder var5 = new StringBuilder();
         var5.append("[");
         var5.append(var1);
         var5.append("] ");
         var5.append(var3);
         String var10 = var5.toString();
         Log.e("AppLovinSdk", var10, var4);
         StringBuilder var12 = new StringBuilder();
         var12.append(var10);
         var12.append(" : ");
         var12.append(var4);
         this.k("ERROR", var12.toString());
      }

      if (var2 && (Boolean)this.a.a(com.applovin.impl.sdk.b.d.eE) && this.a.P() != null) {
         this.a.P().a(var3, var4);
      }

   }

   public void a(String var1, String var2) {
      if (this.a()) {
         this.a(var1, var2, false);
      }

   }

   public void a(String var1, String var2, Throwable var3) {
      if (this.a()) {
         StringBuilder var4 = new StringBuilder();
         var4.append("[");
         var4.append(var1);
         var4.append("] ");
         var4.append(var2);
         String var9 = var4.toString();
         Log.w("AppLovinSdk", var9, var3);
         this.k("WARN", var9);
      }

   }

   public void b(String var1, String var2) {
      if (this.a()) {
         StringBuilder var3 = new StringBuilder();
         var3.append("[");
         var3.append(var1);
         var3.append("] ");
         var3.append(var2);
         String var8 = var3.toString();
         Log.d("AppLovinSdk", var8);
         this.k("DEBUG", var8);
      }

   }

   public void b(String var1, String var2, Throwable var3) {
      this.a(var1, true, var2, var3);
   }

   public void c(String var1, String var2) {
      if (this.a()) {
         StringBuilder var3 = new StringBuilder();
         var3.append("[");
         var3.append(var1);
         var3.append("] ");
         var3.append(var2);
         String var8 = var3.toString();
         Log.i("AppLovinSdk", var8);
         this.k("INFO", var8);
      }

   }

   public void d(String var1, String var2) {
      this.a(var1, (String)var2, (Throwable)null);
   }

   public void e(String var1, String var2) {
      this.b(var1, var2, (Throwable)null);
   }

   public void f(String var1, String var2) {
      this.a(var1, var2, true);
   }
}
