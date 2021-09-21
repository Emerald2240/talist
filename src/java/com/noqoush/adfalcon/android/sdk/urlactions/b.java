package com.noqoush.adfalcon.android.sdk.urlactions;

import android.net.Uri;

public abstract class b {
   protected Uri a(String var1) {
      return var1 != null && var1.length() != 0 ? Uri.parse(var1) : null;
   }

   public abstract boolean a(e var1) throws Exception;

   public abstract boolean b(e var1) throws Exception;

   protected boolean b(String var1) {
      Uri var2 = this.a(var1);
      return var2 == null ? false : "about".equalsIgnoreCase(var2.getScheme());
   }

   protected boolean c(String var1) {
      Uri var2 = this.a(var1);
      return var2 == null ? false : "adfdeeplink".equalsIgnoreCase(var2.getScheme());
   }

   protected boolean d(String var1) {
      Uri var2 = this.a(var1);
      if (var2 == null) {
         return false;
      } else {
         String var3 = var2.getScheme();
         boolean var4;
         if (!"http".equalsIgnoreCase(var3)) {
            boolean var5 = "https".equalsIgnoreCase(var3);
            var4 = false;
            if (!var5) {
               return var4;
            }
         }

         var4 = true;
         return var4;
      }
   }

   protected boolean e(String var1) {
      Uri var2 = this.a(var1);
      return var2 == null ? false : "intent".equalsIgnoreCase(var2.getScheme());
   }

   protected boolean f(String var1) {
      Uri var2 = this.a(var1);
      if (var2 == null) {
         return false;
      } else {
         String var3 = var2.getScheme();
         String var4 = var2.getHost();
         boolean var5;
         if (!"play.google.com".equalsIgnoreCase(var4) && !"market.android.com".equalsIgnoreCase(var4)) {
            boolean var6 = "market".equalsIgnoreCase(var3);
            var5 = false;
            if (!var6) {
               return var5;
            }
         }

         var5 = true;
         return var5;
      }
   }
}
