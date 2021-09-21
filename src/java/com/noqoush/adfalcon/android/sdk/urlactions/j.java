package com.noqoush.adfalcon.android.sdk.urlactions;

public class j extends b {
   public boolean a(e var1) {
      Exception var10000;
      label67: {
         boolean var10001;
         String var3;
         boolean var4;
         try {
            var3 = var1.b();
            var4 = this.d(var3);
         } catch (Exception var14) {
            var10000 = var14;
            var10001 = false;
            break label67;
         }

         boolean var5 = false;
         if (var4) {
            return var5;
         }

         boolean var6;
         try {
            var6 = this.b(var3);
         } catch (Exception var13) {
            var10000 = var13;
            var10001 = false;
            break label67;
         }

         var5 = false;
         if (var6) {
            return var5;
         }

         boolean var7;
         try {
            var7 = this.f(var3);
         } catch (Exception var12) {
            var10000 = var12;
            var10001 = false;
            break label67;
         }

         var5 = false;
         if (var7) {
            return var5;
         }

         boolean var8;
         try {
            var8 = this.e(var3);
         } catch (Exception var11) {
            var10000 = var11;
            var10001 = false;
            break label67;
         }

         var5 = false;
         if (var8) {
            return var5;
         }

         boolean var9;
         try {
            var9 = this.c(var3);
         } catch (Exception var10) {
            var10000 = var10;
            var10001 = false;
            break label67;
         }

         var5 = false;
         if (!var9) {
            var5 = true;
         }

         return var5;
      }

      Exception var2 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      return false;
   }

   public boolean b(e var1) throws Exception {
      try {
         l.a(var1.a(), this.a(var1.b()));
         if (var1.c() != null) {
            var1.c().a(i.b, m.e);
         }

         return true;
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
         if (var1.c() != null) {
            var1.c().a();
         }

         return false;
      }
   }
}
