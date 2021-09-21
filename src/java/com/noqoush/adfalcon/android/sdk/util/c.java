package com.noqoush.adfalcon.android.sdk.util;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import java.util.Calendar;
import java.util.UUID;

public class c {
   private static final long a = 82800000L;
   private static final String b = "ADFSessionUtil";
   private static final String c = "ADF_KEY_LAST_CALL";
   private static final String d = "ADF_KEY_SESSION";
   private static final String e = "ADF_KEY_SEQ_NO";
   private static String f;
   private static long g;
   private static long h;

   private static long a(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   private static void a(Context var0, String var1, long var2) {
      Class var9 = c.class;
      synchronized(c.class){}

      try {
         if (a(var0)) {
            Editor var6 = var0.getSharedPreferences("ADFSessionUtil", 0).edit();
            var6.putLong(var1, var2);
            var6.commit();
         }
      } catch (Exception var12) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var12);
      } finally {
         ;
      }

   }

   private static void a(Context var0, String var1, String var2) {
      Class var8 = c.class;
      synchronized(c.class){}

      try {
         if (a(var0)) {
            Editor var5 = var0.getSharedPreferences("ADFSessionUtil", 0).edit();
            var5.putString(var1, var2);
            var5.commit();
         }
      } catch (Exception var11) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var11);
      } finally {
         ;
      }

   }

   private static boolean a(Context var0) {
      int var2;
      try {
         var2 = var0.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", var0.getPackageName());
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
         return false;
      }

      boolean var3 = false;
      if (var2 == 0) {
         var3 = true;
      }

      return var3;
   }

   private static String b(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   private static void b(Context var0) {
      try {
         f = UUID.randomUUID().toString();
         g = Calendar.getInstance().getTimeInMillis();
         h = 0L;
         a(var0, "ADF_KEY_SESSION", f);
         a(var0, "ADF_KEY_SEQ_NO", h);
         a(var0, "ADF_KEY_LAST_CALL", g);
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public static long c(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static String d(Context var0) {
      Class var4 = c.class;
      synchronized(c.class){}

      Throwable var10000;
      label131: {
         boolean var10001;
         label124: {
            Exception var1;
            try {
               try {
                  e(var0);
                  break label124;
               } catch (Exception var19) {
                  var1 = var19;
               }
            } catch (Throwable var20) {
               var10000 = var20;
               var10001 = false;
               break label131;
            }

            try {
               com.noqoush.adfalcon.android.sdk.util.a.a(var1);
            } catch (Throwable var18) {
               var10000 = var18;
               var10001 = false;
               break label131;
            }
         }

         label116:
         try {
            String var2 = f;
            return var2;
         } catch (Throwable var17) {
            var10000 = var17;
            var10001 = false;
            break label116;
         }
      }

      Throwable var3 = var10000;
      throw var3;
   }

   private static void e(Context param0) {
      // $FF: Couldn't be decompiled
   }
}
