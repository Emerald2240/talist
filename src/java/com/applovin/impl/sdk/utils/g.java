package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.StrictMode;
import android.os.Build.VERSION;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.view.Display;
import android.view.WindowManager;

public class g {
   public static Point a(Context var0) {
      Point var1 = new Point();
      var1.x = 480;
      var1.y = 320;

      try {
         Display var3 = ((WindowManager)var0.getSystemService("window")).getDefaultDisplay();
         if (b()) {
            var3.getRealSize(var1);
            return var1;
         } else {
            var3.getSize(var1);
            return var1;
         }
      } finally {
         ;
      }
   }

   public static void a() {
      try {
         StrictMode.setThreadPolicy((new Builder()).permitAll().build());
      } finally {
         return;
      }
   }

   public static boolean a(String var0, Context var1) {
      return var1.checkCallingOrSelfPermission(var0) == 0;
   }

   public static boolean b() {
      return VERSION.SDK_INT >= 17;
   }

   public static boolean c() {
      return VERSION.SDK_INT >= 19;
   }

   public static boolean d() {
      return VERSION.SDK_INT >= 21;
   }

   public static boolean e() {
      return VERSION.SDK_INT >= 23;
   }

   public static boolean f() {
      return VERSION.SDK_INT >= 24;
   }

   public static boolean g() {
      return VERSION.SDK_INT >= 29;
   }
}
