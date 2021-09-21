package com.noqoush.adfalcon.android.sdk;

import android.util.Log;

public class k {
   private static String a;

   public static void a(String var0) {
      if (var0 != null) {
         try {
            Log.d(a, var0);
            return;
         } catch (Exception var2) {
         }
      }

   }

   public static void b(String var0) {
      if (var0 != null) {
         try {
            Log.e(a, var0);
            return;
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      }

   }

   public static void c(String var0) {
      if (var0 != null) {
         try {
            Log.i(a, var0);
            return;
         } catch (Exception var2) {
         }
      }

   }

   public static void d(String var0) {
      if (var0 != null) {
         try {
            Log.v(a, var0);
            return;
         } catch (Exception var2) {
         }
      }

   }

   public static void e(String var0) {
      if (var0 != null) {
         try {
            Log.w(a, var0);
            return;
         } catch (Exception var2) {
         }
      }

   }
}
