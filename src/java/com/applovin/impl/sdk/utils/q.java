package com.applovin.impl.sdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdk;
import java.io.Closeable;
import java.io.File;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

public abstract class q {
   private static Boolean a;

   public static double a(long var0) {
      double var2 = (double)var0;
      Double.isNaN(var2);
      return var2 / 1000.0D;
   }

   public static float a(float var0) {
      return var0 * 1000.0F;
   }

   public static int a(JSONObject var0) {
      int var1 = i.b(var0, "video_completion_percent", -1, (com.applovin.impl.sdk.j)null);
      return var1 >= 0 && var1 <= 100 ? var1 : 95;
   }

   public static long a(com.applovin.impl.sdk.j var0) {
      long var1 = (Long)var0.a(com.applovin.impl.sdk.b.d.eT);
      long var3 = (Long)var0.a(com.applovin.impl.sdk.b.d.eU);
      long var5 = System.currentTimeMillis();
      if (var1 > 0L && var3 > 0L) {
         var5 += var1 - var3;
      }

      return var5;
   }

   public static Activity a(View var0, com.applovin.impl.sdk.j var1) {
      if (var0 == null) {
         return null;
      } else {
         int var2 = 0;

         while(var2 < 1000) {
            ++var2;

            try {
               Context var4 = var0.getContext();
               if (var4 instanceof Activity) {
                  return (Activity)var4;
               }

               ViewParent var5 = var0.getParent();
               if (!(var5 instanceof View)) {
                  return null;
               }

               var0 = (View)var5;
            } catch (Throwable var7) {
               var1.v().b("Utils", "Encountered error while retrieving activity from view", var7);
               break;
            }
         }

         return null;
      }
   }

   public static Bitmap a(Context param0, int param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   public static Bitmap a(File param0, int param1) {
      // $FF: Couldn't be decompiled
   }

   public static View a(Context var0, View var1) {
      View var2 = c(var0);
      return var2 != null ? var2 : a(var1);
   }

   public static View a(View var0) {
      if (var0 == null) {
         return null;
      } else {
         View var1 = var0.getRootView();
         if (var1 == null) {
            return null;
         } else {
            View var2 = var1.findViewById(16908290);
            if (var2 != null) {
               var1 = var2;
            }

            return var1;
         }
      }
   }

   public static com.applovin.impl.sdk.ad.d a(JSONObject var0, com.applovin.impl.sdk.j var1) {
      return com.applovin.impl.sdk.ad.d.a(AppLovinAdSize.fromString(i.b(var0, "ad_size", (String)null, var1)), AppLovinAdType.fromString(i.b(var0, "ad_type", (String)null, var1)), i.b(var0, "zone_id", (String)null, var1), var1);
   }

   public static com.applovin.impl.sdk.j a(AppLovinSdk var0) {
      try {
         Field var5 = var0.getClass().getDeclaredField("mSdkImpl");
         var5.setAccessible(true);
         com.applovin.impl.sdk.j var6 = (com.applovin.impl.sdk.j)var5.get(var0);
         return var6;
      } catch (Throwable var8) {
         StringBuilder var2 = new StringBuilder();
         var2.append("Internal error - unable to retrieve SDK implementation: ");
         var2.append(var8);
         throw new IllegalStateException(var2.toString());
      }
   }

   public static AppLovinAd a(AppLovinAd var0, com.applovin.impl.sdk.j var1) {
      if (var0 instanceof com.applovin.impl.sdk.ad.g) {
         com.applovin.impl.sdk.ad.g var2 = (com.applovin.impl.sdk.ad.g)var0;
         AppLovinAd var3 = var1.o().dequeueAd(var2.getAdZone());
         com.applovin.impl.sdk.p var4 = var1.v();
         StringBuilder var5 = new StringBuilder();
         var5.append("Dequeued ad for dummy ad: ");
         var5.append(var3);
         var4.b("Utils", var5.toString());
         if (var3 != null) {
            var2.a(var3);
            ((AppLovinAdBase)var3).setDummyAd(var2);
            return var3;
         }

         var0 = var2.a();
      }

      return var0;
   }

   public static Object a(Object var0, com.applovin.impl.sdk.j var1) {
      if (var0 instanceof Map) {
         Map var8 = (Map)var0;
         HashMap var9 = new HashMap(var8.size());

         Entry var11;
         String var13;
         for(Iterator var10 = var8.entrySet().iterator(); var10.hasNext(); var9.put(var13, a(var11.getValue(), var1))) {
            var11 = (Entry)var10.next();
            Object var12 = var11.getKey();
            if (var12 instanceof String) {
               var13 = (String)var12;
            } else {
               var13 = String.valueOf(var12);
            }
         }

         return var9;
      } else if (var0 instanceof List) {
         List var4 = (List)var0;
         ArrayList var5 = new ArrayList(var4.size());
         Iterator var6 = var4.iterator();

         while(var6.hasNext()) {
            var5.add(a(var6.next(), var1));
         }

         return var5;
      } else if (var0 instanceof Date) {
         return String.valueOf(((Date)var0).getTime());
      } else {
         String var2 = String.valueOf(var0);
         int var3;
         if (var0 instanceof String) {
            var3 = (Integer)var1.a(com.applovin.impl.sdk.b.d.aZ);
            if (var3 <= 0 || var2.length() <= var3) {
               return var2;
            }
         } else {
            if (!(var0 instanceof Uri)) {
               return var2;
            }

            var3 = (Integer)var1.a(com.applovin.impl.sdk.b.d.ba);
            if (var3 <= 0 || var2.length() <= var3) {
               return var2;
            }
         }

         var2 = var2.substring(0, var3);
         return var2;
      }
   }

   public static String a(com.applovin.impl.sdk.b.f var0, com.applovin.impl.sdk.j var1) {
      return (String)var1.a(var0);
   }

   public static String a(String var0) {
      return var0 != null && var0.length() > 4 ? var0.substring(var0.length() - 4) : "NOKEY";
   }

   public static String a(Map var0) {
      if (var0 != null && !var0.isEmpty()) {
         StringBuilder var1 = new StringBuilder();
         Iterator var2 = var0.entrySet().iterator();

         while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            if (var1.length() > 0) {
               var1.append("&");
            }

            var1.append(var3.getKey());
            var1.append('=');
            var1.append(var3.getValue());
         }

         return var1.toString();
      } else {
         return "";
      }
   }

   public static Field a(Class var0, String var1) {
      try {
         Field var4 = var0.getDeclaredField(var1);
         return var4;
      } catch (NoSuchFieldException var5) {
         Class var3 = var0.getSuperclass();
         return var3 == null ? null : a(var3, var1);
      }
   }

   public static List a(String var0, JSONObject var1, String var2, String var3, com.applovin.impl.sdk.j var4) {
      return a(var0, var1, var2, (String)null, var3, var4);
   }

   public static List a(String var0, JSONObject var1, String var2, String var3, String var4, com.applovin.impl.sdk.j var5) {
      HashMap var6 = new HashMap(2);
      var6.put("{CLCODE}", var2);
      if (var3 == null) {
         var3 = "";
      }

      var6.put("{EVENT_ID}", var3);
      return a(var0, var1, (Map)var6, var4, var5);
   }

   public static List a(String var0, JSONObject var1, Map var2, String var3, com.applovin.impl.sdk.j var4) {
      JSONObject var5 = i.b(var1, var0, new JSONObject(), var4);
      ArrayList var6 = new ArrayList(1 + var5.length());
      if (n.b(var3)) {
         var6.add(new com.applovin.impl.sdk.c.a(var3, (String)null));
      }

      if (var5.length() > 0) {
         Iterator var7 = var5.keys();

         while(var7.hasNext()) {
            try {
               String var9 = (String)var7.next();
               if (!TextUtils.isEmpty(var9)) {
                  String var10 = var5.optString(var9);
                  String var11 = n.a(var9, var2);
                  if (!TextUtils.isEmpty(var10)) {
                     var10 = n.a(var10, var2);
                  }

                  var6.add(new com.applovin.impl.sdk.c.a(var11, var10));
               }
            } catch (Throwable var13) {
               var4.v().b("Utils", "Failed to create and add postback url.", var13);
               continue;
            }
         }
      }

      return var6;
   }

   private static List a(List var0, com.applovin.impl.sdk.j var1) {
      if (var0 == null) {
         return null;
      } else {
         ArrayList var2 = new ArrayList(var0.size());
         Iterator var3 = var0.iterator();

         while(var3.hasNext()) {
            String var4 = (String)var3.next();

            try {
               var2.add(Class.forName(var4));
            } catch (ClassNotFoundException var8) {
               com.applovin.impl.sdk.p var6 = var1.v();
               StringBuilder var7 = new StringBuilder();
               var7.append("Failed to create class for name: ");
               var7.append(var4);
               var6.e("Utils", var7.toString());
            }
         }

         return var2;
      }
   }

   public static void a(com.applovin.impl.sdk.b.f var0, int var1, com.applovin.impl.sdk.j var2) {
      if (TextUtils.isEmpty((String)var2.a(var0))) {
         double var3 = Math.random();
         double var5 = (double)var1;
         Double.isNaN(var5);
         var2.a((com.applovin.impl.sdk.b.f)var0, (Object)String.valueOf(1 + (int)(var3 * var5)));
      }

   }

   public static void a(AppLovinAdLoadListener var0, com.applovin.impl.sdk.ad.d var1, int var2, com.applovin.impl.sdk.j var3) {
      if (var0 != null) {
         try {
            if (var0 instanceof com.applovin.impl.sdk.m) {
               ((com.applovin.impl.sdk.m)var0).a(var1, var2);
            } else {
               var0.failedToReceiveAd(var2);
            }
         } catch (Throwable var6) {
            var3.v().b("Utils", "Unable process a failure to receive an ad", var6);
            return;
         }
      }
   }

   public static void a(Closeable var0, com.applovin.impl.sdk.j var1) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (Throwable var6) {
            if (var1 != null) {
               com.applovin.impl.sdk.p var3 = var1.v();
               StringBuilder var4 = new StringBuilder();
               var4.append("Unable to close stream: ");
               var4.append(var0);
               var3.b("Utils", var4.toString(), var6);
            }

            return;
         }
      }
   }

   public static void a(String var0, String var1, Map var2) {
      if (!TextUtils.isEmpty(var1)) {
         var2.put(var0, var1);
      }

   }

   public static void a(String var0, JSONObject var1, com.applovin.impl.sdk.j var2) {
      if (var1.has("no_fill_reason")) {
         Object var3 = i.a(var1, "no_fill_reason", new Object(), var2);
         StringBuilder var4 = new StringBuilder();
         var4.append("\n**************************************************\nNO FILL received:\n..ID: \"");
         var4.append(var0);
         var4.append("\"\n..SDK KEY: \"");
         var4.append(var2.t());
         var4.append("\"\n..Reason: ");
         var4.append(var3);
         var4.append("\n**************************************************\n");
         com.applovin.impl.sdk.p.j("AppLovinSdk", var4.toString());
      }

   }

   public static void a(HttpURLConnection var0, com.applovin.impl.sdk.j var1) {
      if (var0 != null) {
         try {
            var0.disconnect();
         } catch (Throwable var6) {
            if (var1 != null) {
               com.applovin.impl.sdk.p var3 = var1.v();
               StringBuilder var4 = new StringBuilder();
               var4.append("Unable to disconnect connection: ");
               var4.append(var0);
               var3.b("Utils", var4.toString(), var6);
            }

            return;
         }
      }
   }

   public static boolean a() {
      Context var0 = com.applovin.impl.sdk.j.E();
      return var0 != null ? c.a(var0).a("applovin.sdk.verbose_logging") : false;
   }

   public static boolean a(long var0, long var2) {
      return (var0 & var2) != 0L;
   }

   public static boolean a(Context var0) {
      if (var0 == null) {
         var0 = com.applovin.impl.sdk.j.E();
      }

      return var0 != null ? c.a(var0).a("applovin.sdk.verbose_logging", false) : false;
   }

   public static boolean a(Context var0, Uri var1, com.applovin.impl.sdk.j var2) {
      boolean var10;
      label45: {
         try {
            Intent var3 = new Intent("android.intent.action.VIEW", var1);
            if (!(var0 instanceof Activity)) {
               var3.setFlags(268435456);
            }

            var2.Y().b();
            var0.startActivity(var3);
         } catch (Throwable var12) {
            com.applovin.impl.sdk.p var5 = var2.v();
            StringBuilder var6 = new StringBuilder();
            var6.append("Unable to open \"");
            var6.append(var1);
            var6.append("\".");
            var5.b("Utils", var6.toString(), var12);
            var10 = false;
            break label45;
         }

         var10 = true;
      }

      if (!var10) {
         var2.Y().c();
      }

      return var10;
   }

   public static boolean a(View var0, Activity var1) {
      if (var1 != null) {
         if (var0 == null) {
            return false;
         } else {
            Window var2 = var1.getWindow();
            View var4;
            if (var2 != null) {
               var4 = var2.getDecorView();
            } else {
               View var3 = var1.findViewById(16908290);
               if (var3 == null) {
                  return false;
               }

               var4 = var3.getRootView();
            }

            return a(var0, var4);
         }
      } else {
         return false;
      }
   }

   public static boolean a(View var0, View var1) {
      if (var0 == var1) {
         return true;
      } else {
         if (var1 instanceof ViewGroup) {
            ViewGroup var2 = (ViewGroup)var1;

            for(int var3 = 0; var3 < var2.getChildCount(); ++var3) {
               if (a(var0, var2.getChildAt(var3))) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public static boolean a(Object var0, List var1, com.applovin.impl.sdk.j var2) {
      if (var1 == null) {
         return false;
      } else {
         Iterator var3 = a(var1, var2).iterator();

         do {
            if (!var3.hasNext()) {
               com.applovin.impl.sdk.p var4 = var2.v();
               StringBuilder var5 = new StringBuilder();
               var5.append("Object '");
               var5.append(var0);
               var5.append("' does not match any of the required types '");
               var5.append(var1);
               var5.append("'.");
               var4.b("Utils", var5.toString());
               return false;
            }
         } while(!((Class)var3.next()).isInstance(var0));

         if (var0 instanceof Map) {
            Iterator var12 = ((Map)var0).entrySet().iterator();

            while(var12.hasNext()) {
               Entry var13 = (Entry)var12.next();
               if (!(var13.getKey() instanceof String)) {
                  var2.v().b("Utils", "Invalid key type used. Map keys should be of type String.");
                  return false;
               }

               if (!a(var13.getValue(), var1, var2)) {
                  return false;
               }
            }
         } else if (var0 instanceof List) {
            Iterator var11 = ((List)var0).iterator();

            while(var11.hasNext()) {
               if (!a(var11.next(), var1, var2)) {
                  return false;
               }
            }
         }

         return true;
      }
   }

   public static boolean a(String var0, List var1) {
      Iterator var2 = var1.iterator();

      do {
         if (!var2.hasNext()) {
            return false;
         }
      } while(!var0.startsWith((String)var2.next()));

      return true;
   }

   public static int b(Context var0) {
      if (var0 != null) {
         Resources var1 = var0.getResources();
         if (var1 != null) {
            Configuration var2 = var1.getConfiguration();
            if (var2 != null) {
               return var2.orientation;
            }
         }
      }

      return 0;
   }

   public static long b(float var0) {
      return c(a(var0));
   }

   public static String b(Class var0, String var1) {
      try {
         Field var3 = a(var0, var1);
         var3.setAccessible(true);
         String var4 = (String)var3.get((Object)null);
         return var4;
      } finally {
         ;
      }
   }

   public static String b(String var0) {
      return var0.replace("{PLACEMENT}", "");
   }

   public static Map b(Map var0) {
      HashMap var1 = new HashMap(var0);
      Iterator var2 = var1.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         String var4 = (String)var1.get(var3);
         if (var4 != null) {
            var1.put(var3, n.e(var4));
         }
      }

      return var1;
   }

   public static void b(AppLovinAd var0, com.applovin.impl.sdk.j var1) {
      if (var0 instanceof AppLovinAdBase) {
         AppLovinAdBase var2 = (AppLovinAdBase)var0;
         String var3 = var1.t();
         String var4 = var2.getSdk().t();
         if (!var3.equals(var4)) {
            StringBuilder var5 = new StringBuilder();
            var5.append("Ad was loaded from sdk with key: ");
            var5.append(var4);
            var5.append(", but is being rendered from sdk with key: ");
            var5.append(var3);
            com.applovin.impl.sdk.p.j("AppLovinAd", var5.toString());
            var1.L().a(com.applovin.impl.sdk.c.g.l);
         }

      }
   }

   public static boolean b() {
      return Looper.myLooper() == Looper.getMainLooper();
   }

   public static boolean b(com.applovin.impl.sdk.j var0) {
      if (a == null) {
         boolean var5 = false;

         try {
            var5 = true;
            Context var2 = com.applovin.impl.sdk.j.E();
            StringBuilder var3 = new StringBuilder();
            var3.append(var2.getPackageName());
            var3.append(".BuildConfig");
            a = Class.forName(var3.toString()).getField("DEBUG").getBoolean((Object)null);
            var5 = false;
         } finally {
            if (var5) {
               var0.v().b("Utils", "Publisher is not in debug mode");
               a = false;
               return a;
            }
         }
      }

      return a;
   }

   private static long c(float var0) {
      return (long)Math.round(var0);
   }

   public static View c(Context var0) {
      return !(var0 instanceof Activity) ? null : ((Activity)var0).getWindow().getDecorView().findViewById(16908290);
   }

   public static MaxAdFormat c(String var0) {
      if (TextUtils.isEmpty(var0)) {
         return null;
      } else if (var0.equalsIgnoreCase("banner")) {
         return MaxAdFormat.BANNER;
      } else if (var0.equalsIgnoreCase("mrec")) {
         return MaxAdFormat.MREC;
      } else if (!var0.equalsIgnoreCase("leaderboard") && !var0.equalsIgnoreCase("leader")) {
         if (!var0.equalsIgnoreCase("interstitial") && !var0.equalsIgnoreCase("inter")) {
            if (!var0.equalsIgnoreCase("rewarded") && !var0.equalsIgnoreCase("reward")) {
               StringBuilder var1 = new StringBuilder();
               var1.append("Unknown format: ");
               var1.append(var0);
               throw new IllegalArgumentException(var1.toString());
            } else {
               return MaxAdFormat.REWARDED;
            }
         } else {
            return MaxAdFormat.INTERSTITIAL;
         }
      } else {
         return MaxAdFormat.LEADER;
      }
   }

   public static boolean c() {
      RunningAppProcessInfo var0 = new RunningAppProcessInfo();

      try {
         ActivityManager.getMyMemoryState(var0);
      } catch (Throwable var3) {
         com.applovin.impl.sdk.p.c("Utils", "Exception thrown while getting memory state.", var3);
         return var0.importance == 100 || var0.importance == 200;
      }

      return var0.importance == 100 || var0.importance == 200;
   }

   public static String d(Context var0) {
      Intent var1 = new Intent("android.intent.action.MAIN");
      var1.setPackage(var0.getPackageName());
      List var3 = var0.getPackageManager().queryIntentActivities(var1, 0);
      return !var3.isEmpty() ? ((ResolveInfo)var3.get(0)).activityInfo.name : null;
   }

   public static String d(String var0) {
      Uri var1 = Uri.parse(var0);
      return (new Builder()).scheme(var1.getScheme()).authority(var1.getAuthority()).path(var1.getPath()).build().toString();
   }

   public static boolean d() {
      // $FF: Couldn't be decompiled
   }

   public static int e(Context var0) {
      WindowManager var1 = (WindowManager)var0.getSystemService("window");
      return var1 == null ? 0 : var1.getDefaultDisplay().getRotation();
   }

   public static boolean e(String var0) {
      if (TextUtils.isEmpty(var0)) {
         return false;
      } else {
         try {
            Class.forName(var0);
            return true;
         } finally {
            ;
         }
      }
   }

   public static long f(String var0) {
      if (n.b(var0)) {
         try {
            int var2 = Color.parseColor(var0);
         } finally {
            return Long.MAX_VALUE;
         }

      } else {
         return Long.MAX_VALUE;
      }
   }
}
