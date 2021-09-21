package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BundleUtils {
   public static boolean getBoolean(String var0, Bundle var1) {
      return getBoolean(var0, false, var1);
   }

   public static boolean getBoolean(String var0, boolean var1, Bundle var2) {
      if (!TextUtils.isEmpty(var0) && var2 != null) {
         if (!var2.containsKey(var0)) {
            return var1;
         }

         Object var3 = var2.get(var0);
         if (var3 instanceof Boolean) {
            return (Boolean)var3;
         }

         if (var3 instanceof Number) {
            if (((Number)var3).intValue() == 0) {
               return false;
            }

            return true;
         }

         if (var3 instanceof String) {
            String var4 = (String)var3;
            if (!var4.equalsIgnoreCase("true")) {
               if (var4.equalsIgnoreCase("1")) {
                  return true;
               }

               if (!var4.equalsIgnoreCase("false")) {
                  if (var4.equalsIgnoreCase("0")) {
                     return false;
                  }

                  return var1;
               }

               return false;
            }

            return true;
         }
      }

      return var1;
   }

   public static int getInt(String var0, int var1, Bundle var2) {
      if (!TextUtils.isEmpty(var0) && var2 != null) {
         if (!var2.containsKey(var0)) {
            return var1;
         }

         Object var3 = var2.get(var0);
         if (var3 instanceof Number) {
            return ((Number)var3).intValue();
         }

         if (var3 instanceof String) {
            try {
               int var5 = Integer.parseInt((String)var3);
               return var5;
            } catch (NumberFormatException var6) {
            }
         }
      }

      return var1;
   }

   public static int getInt(String var0, Bundle var1) {
      return getInt(var0, 0, var1);
   }

   public static int getLong(String var0, Bundle var1) {
      return getInt(var0, 0, var1);
   }

   public static long getLong(String var0, long var1, Bundle var3) {
      if (!TextUtils.isEmpty(var0) && var3 != null) {
         if (!var3.containsKey(var0)) {
            return var1;
         }

         Object var4 = var3.get(var0);
         if (var4 instanceof Number) {
            return ((Number)var4).longValue();
         }

         if (var4 instanceof String) {
            try {
               long var6 = Long.parseLong((String)var4);
               return var6;
            } catch (NumberFormatException var8) {
            }
         }
      }

      return var1;
   }

   public static String getString(String var0, Bundle var1) {
      return getString(var0, (String)null, var1);
   }

   public static String getString(String var0, String var1, Bundle var2) {
      if (!TextUtils.isEmpty(var0) && var2 != null) {
         if (!var2.containsKey(var0)) {
            return var1;
         } else {
            Object var3 = var2.get(var0);
            return var3 instanceof String ? (String)var3 : String.valueOf(var3);
         }
      } else {
         return var1;
      }
   }

   public static Map toMap(Bundle var0) {
      if (var0 == null) {
         return new HashMap();
      } else {
         HashMap var1 = new HashMap(var0.size());
         Iterator var2 = var0.keySet().iterator();

         while(true) {
            String var3;
            Object var4;
            while(true) {
               do {
                  if (!var2.hasNext()) {
                     return var1;
                  }

                  var3 = (String)var2.next();
                  var4 = var0.get(var3);
               } while(var4 == null);

               if (var4 instanceof Bundle) {
                  var4 = toMap((Bundle)var4);
                  break;
               }

               boolean var5 = var4 instanceof Collection;
               if (!var5 && !(var4 instanceof Parcelable[])) {
                  break;
               }

               Object var6;
               if (var5) {
                  var6 = (Collection)var4;
               } else {
                  var6 = Arrays.asList((Parcelable[])((Parcelable[])var4));
               }

               ArrayList var7 = new ArrayList();

               Object var10;
               for(Iterator var8 = ((Collection)var6).iterator(); var8.hasNext(); var7.add(var10)) {
                  var10 = var8.next();
                  if (var10 instanceof Bundle) {
                     var10 = toMap((Bundle)var10);
                  }
               }

               var1.put(var3, var7);
            }

            var1.put(var3, var4);
         }
      }
   }
}
