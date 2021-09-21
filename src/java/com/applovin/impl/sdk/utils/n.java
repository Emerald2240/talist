package com.applovin.impl.sdk.utils;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class n {
   private static final char[] a = "0123456789abcdef".toCharArray();

   public static int a(String var0) {
      return a(var0, 0);
   }

   public static int a(String var0, int var1) {
      if (d(var0)) {
         var1 = Integer.parseInt(var0);
      }

      return var1;
   }

   public static String a(int var0, String var1) {
      if (TextUtils.isEmpty(var1)) {
         return var1;
      } else {
         if (var0 > var1.length()) {
            var0 = var1.length();
         }

         return var1.substring(0, var0);
      }
   }

   private static String a(String var0, Integer var1) {
      if (TextUtils.isEmpty(var0)) {
         return "";
      } else {
         try {
            MessageDigest var7 = MessageDigest.getInstance("SHA-1");
            var7.update(var0.getBytes("UTF-8"));
            String var8 = a(var7.digest());
            if (var1 > 0) {
               String var9 = var8.substring(0, Math.min(var1, var8.length()));
               return var9;
            } else {
               return var8;
            }
         } catch (Throwable var11) {
            StringBuilder var3 = new StringBuilder();
            var3.append("SHA-1 for \"");
            var3.append(var0);
            var3.append("\" failed.");
            throw new RuntimeException(var3.toString(), var11);
         }
      }
   }

   public static String a(String var0, String var1, String var2) {
      if (!TextUtils.isEmpty(var0)) {
         if (TextUtils.isEmpty(var1)) {
            return var0;
         }

         Builder var3 = Uri.parse(var0).buildUpon();
         var3.appendQueryParameter(var1, var2);
         var0 = var3.build().toString();
      }

      return var0;
   }

   public static String a(String var0, Map var1) {
      if (var0 != null) {
         if (var1 == null) {
            return var0;
         }

         Entry var3;
         for(Iterator var2 = var1.entrySet().iterator(); var2.hasNext(); var0 = var0.replace((CharSequence)var3.getKey(), (CharSequence)var3.getValue())) {
            var3 = (Entry)var2.next();
         }
      }

      return var0;
   }

   public static String a(boolean var0) {
      return var0 ? "1" : "0";
   }

   public static String a(byte[] var0) {
      if (var0 == null) {
         IllegalArgumentException var1 = new IllegalArgumentException("No data specified");
         throw var1;
      } else {
         char[] var2 = new char[2 * var0.length];

         for(int var3 = 0; var3 < var0.length; ++var3) {
            int var4 = var3 * 2;
            char[] var5 = a;
            var2[var4] = var5[(240 & var0[var3]) >>> 4];
            var2[var4 + 1] = var5[15 & var0[var3]];
         }

         return new String(var2);
      }
   }

   public static boolean a(String var0, String var1) {
      return b(var0) && b(var1) && var0.toLowerCase().contains(var1.toLowerCase());
   }

   public static String b(String var0, Map var1) {
      if (TextUtils.isEmpty(var0)) {
         return var0;
      } else {
         if (var1 != null) {
            if (var1.isEmpty()) {
               return var0;
            }

            Builder var2 = Uri.parse(var0).buildUpon();
            Iterator var3 = var1.entrySet().iterator();

            while(var3.hasNext()) {
               Entry var4 = (Entry)var3.next();
               var2.appendQueryParameter((String)var4.getKey(), (String)var4.getValue());
            }

            var0 = var2.build().toString();
         }

         return var0;
      }
   }

   public static boolean b(String var0) {
      return true ^ TextUtils.isEmpty(var0);
   }

   public static String c(String var0) {
      if (var0 == null) {
         var0 = "";
      }

      return var0;
   }

   public static boolean d(String var0) {
      if (TextUtils.isEmpty(var0)) {
         return false;
      } else {
         char var1 = var0.charAt(0);
         int var2;
         if (var1 != '-' && var1 != '+') {
            var2 = 0;
         } else {
            var2 = 1;
         }

         int var3 = var0.length();
         if (var2 == 1 && var3 == 1) {
            return false;
         } else {
            while(var2 < var3) {
               if (!Character.isDigit(var0.charAt(var2))) {
                  return false;
               }

               ++var2;
            }

            return true;
         }
      }
   }

   public static String e(String var0) {
      if (!TextUtils.isEmpty(var0)) {
         try {
            String var2 = URLEncoder.encode(var0, "UTF-8");
            return var2;
         } catch (UnsupportedEncodingException var3) {
            throw new UnsupportedOperationException(var3);
         }
      } else {
         return "";
      }
   }

   public static String f(String var0) {
      return a(var0, 16);
   }
}
