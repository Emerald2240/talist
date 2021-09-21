package com.noqoush.adfalcon.android.sdk.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.noqoush.adfalcon.android.sdk.g;
import com.noqoush.adfalcon.android.sdk.k;
import java.util.Calendar;
import java.util.StringTokenizer;

public class d {
   private static final String a = "app";
   private static final String b = "url";
   private static final String c = "call";
   private static final String d = "sms";
   private static final String e = "video";
   private static final String f = "audio";
   private static final String g = "loc";
   private static final String h = "canvas";
   private static final String i = "ADFALCON_GUID_SHARED_PREF_KEY";
   public static final String j = "none";
   public static final String k = "portrait";
   public static final String l = "landscape";
   static long m;

   public static int a(Context var0, int var1) {
      return (int)(e(var0) * (float)var1);
   }

   public static String a(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   public static String a(String var0) {
      boolean var9;
      label118: {
         Exception var10000;
         label104: {
            boolean var10001;
            boolean var2;
            try {
               var2 = var0.equalsIgnoreCase("url");
            } catch (Exception var17) {
               var10000 = var17;
               var10001 = false;
               break label104;
            }

            if (var2) {
               return "Visit Site";
            }

            boolean var3;
            try {
               var3 = var0.equalsIgnoreCase("app");
            } catch (Exception var16) {
               var10000 = var16;
               var10001 = false;
               break label104;
            }

            if (var3) {
               return "Download";
            }

            boolean var4;
            try {
               var4 = var0.equalsIgnoreCase("call");
            } catch (Exception var15) {
               var10000 = var15;
               var10001 = false;
               break label104;
            }

            if (var4) {
               return "Make Call";
            }

            boolean var5;
            try {
               var5 = var0.equalsIgnoreCase("sms");
            } catch (Exception var14) {
               var10000 = var14;
               var10001 = false;
               break label104;
            }

            if (var5) {
               return "Send SMS";
            }

            boolean var6;
            try {
               var6 = var0.equalsIgnoreCase("video");
            } catch (Exception var13) {
               var10000 = var13;
               var10001 = false;
               break label104;
            }

            if (var6) {
               return "Play Video";
            }

            boolean var7;
            try {
               var7 = var0.equalsIgnoreCase("audio");
            } catch (Exception var12) {
               var10000 = var12;
               var10001 = false;
               break label104;
            }

            if (var7) {
               return "Play Audio";
            }

            boolean var8;
            try {
               var8 = var0.equalsIgnoreCase("loc");
            } catch (Exception var11) {
               var10000 = var11;
               var10001 = false;
               break label104;
            }

            if (var8) {
               return "View Location";
            }

            try {
               var9 = var0.equalsIgnoreCase("canvas");
               break label118;
            } catch (Exception var10) {
               var10000 = var10;
               var10001 = false;
            }
         }

         Exception var1 = var10000;
         com.noqoush.adfalcon.android.sdk.util.a.a(var1);
         return "View";
      }

      if (var9) {
         return "View";
      } else {
         return "View";
      }
   }

   public static void a() {
      try {
         (new Thread(new Runnable() {
            public void run() {
               try {
                  if (Calendar.getInstance().getTimeInMillis() - com.noqoush.adfalcon.android.sdk.util.d.m > 60000L) {
                     Info var2 = com.noqoush.adfalcon.android.sdk.g.c((Context)null).a((Context)null);
                     StringBuilder var3 = new StringBuilder();
                     var3.append("**********   AdFalcon: Use ADFTargetingParams to receive test ads   **********\n\nADFTargetingParams params = new ADFTargetingParams();\nparams.addTestDevice(\"");
                     var3.append(var2.getId());
                     var3.append("\"\n);\n******************************************************************************");
                     com.noqoush.adfalcon.android.sdk.util.a.c(var3.toString());
                     com.noqoush.adfalcon.android.sdk.util.d.m = Calendar.getInstance().getTimeInMillis();
                     return;
                  }
               } catch (Exception var4) {
               }

            }
         })).start();
      } catch (Exception var1) {
      }
   }

   public static void a(final Activity var0, boolean var1, String var2, int var3, int var4) {
      StringBuilder var5 = new StringBuilder();
      var5.append("(");
      var5.append(var3);
      var5.append(", ");
      var5.append(var4);
      var5.append(")");
      com.noqoush.adfalcon.android.sdk.k.e(var5.toString());
      if (var2.equalsIgnoreCase("landscape")) {
         if (var3 < var4) {
            var0.setRequestedOrientation(0);
         }
      } else if (var2.equalsIgnoreCase("portrait")) {
         if (var3 > var4) {
            var0.setRequestedOrientation(1);
         }
      } else {
         var0.setRequestedOrientation(-1);
      }

      if (var1) {
         var0.getWindow().getDecorView().postDelayed(new Runnable() {
            public void run() {
               try {
                  var0.setRequestedOrientation(-1);
               } catch (Exception var2) {
                  com.noqoush.adfalcon.android.sdk.k.b(var2.getMessage());
               }
            }
         }, 5000L);
      }

   }

   public static void a(Context var0) throws Exception {
      PackageManager var1 = var0.getPackageManager();

      int var10000;
      try {
         var10000 = var1.getActivityInfo(new ComponentName(var0, "com.noqoush.adfalcon.android.sdk.ADFActivity"), 128).configChanges;
      } catch (NameNotFoundException var6) {
         com.noqoush.adfalcon.android.sdk.util.a.b("com.noqoush.adfalcon.android.sdk.ADFActivity must be added in AndroidManifest.xml");
         throw new Exception("com.noqoush.adfalcon.android.sdk.ADFActivity must be added in AndroidManifest.xml");
      }

      try {
         var10000 = var1.getActivityInfo(new ComponentName(var0, "com.noqoush.adfalcon.android.sdk.ADFBrowser"), 128).configChanges;
      } catch (NameNotFoundException var5) {
         com.noqoush.adfalcon.android.sdk.util.a.b("com.noqoush.adfalcon.android.sdk.ADFBrowser must be added in AndroidManifest.xml");
         throw new Exception("com.noqoush.adfalcon.android.sdk.ADFBrowser must be added in AndroidManifest.xml");
      }
   }

   public static void a(final Context var0, final String var1, final Handler var2) {
      (new Thread() {
         public void run() {
            // $FF: Couldn't be decompiled
         }
      }).start();
   }

   public static void a(Context var0, String var1, String var2) {
      try {
         StringBuilder var3 = new StringBuilder();
         var3.append("AdFalconSDK - ");
         var3.append(var1);
         var3.append(" - ");
         var3.append(var2);
         com.noqoush.adfalcon.android.sdk.util.a.e(var3.toString());
      } catch (Exception var5) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var5);
      }
   }

   public static boolean a(Activity var0) {
      if (var0 == null) {
         return true;
      } else {
         return VERSION.SDK_INT >= 17 ? var0.isDestroyed() : var0.isFinishing();
      }
   }

   public static int b(String var0) {
      try {
         int var2 = Integer.parseInt(var0);
         return var2;
      } catch (Exception var3) {
         return 0;
      }
   }

   public static void b(Context var0) {
      try {
         PackageManager var2 = var0.getPackageManager();
         String var3 = var0.getPackageName();
         if (var2.checkPermission("android.permission.INTERNET", var3) != -1) {
            if (var2.checkPermission("android.permission.ACCESS_NETWORK_STATE", var3) != -1) {
               a(var0);
            } else {
               com.noqoush.adfalcon.android.sdk.util.a.b("ACCESS_NETWORK_STATE permissions must be enabled in AndroidManifest.xml.");
               throw new Exception("ACCESS_NETWORK_STATE permissions must be enabled in AndroidManifest.xml.");
            }
         } else {
            com.noqoush.adfalcon.android.sdk.util.a.b("INTERNET permissions must be enabled in AndroidManifest.xml.");
            throw new Exception("INTERNET permissions must be enabled in AndroidManifest.xml.");
         }
      } catch (Exception var4) {
         a(var0, "Error", var4.getMessage());
      }
   }

   public static void b(Context var0, String var1) {
      try {
         Editor var3 = PreferenceManager.getDefaultSharedPreferences(var0).edit();
         var3.putString("ADFALCON_GUID_SHARED_PREF_KEY", var1);
         var3.apply();
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }
   }

   public static Activity c(Context var0) {
      if (var0 == null) {
         return null;
      } else if (var0 instanceof Activity) {
         return (Activity)var0;
      } else {
         while(var0 instanceof ContextWrapper) {
            if (var0 instanceof Activity) {
               return (Activity)var0;
            }

            var0 = ((ContextWrapper)var0).getBaseContext();
         }

         return null;
      }
   }

   public static String c(String param0) {
      // $FF: Couldn't be decompiled
   }

   public static String d(Context var0) {
      try {
         String var2 = PreferenceManager.getDefaultSharedPreferences(var0).getString("ADFALCON_GUID_SHARED_PREF_KEY", (String)null);
         return var2;
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
         return null;
      }
   }

   public static String d(String param0) {
      // $FF: Couldn't be decompiled
   }

   public static float e(Context var0) {
      if (var0 == null) {
         return 1.0F;
      } else {
         try {
            float var2 = var0.getResources().getDisplayMetrics().density;
            return var2;
         } catch (Exception var3) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var3);
            return 1.0F;
         }
      }
   }

   private static Calendar e(String var0) throws Exception {
      String var1 = "T";
      if (!var0.contains(var1)) {
         var1 = " ";
      }

      StringTokenizer var2 = new StringTokenizer(var0, var1);
      String var3 = var2.nextToken();
      boolean var4 = var2.hasMoreTokens();
      String var5 = null;
      if (var4) {
         var5 = var2.nextToken();
      }

      StringTokenizer var6 = new StringTokenizer(var3, "-");
      int var7 = Integer.parseInt(var6.nextToken());
      int var8 = Integer.parseInt(var6.nextToken());
      int var9 = Integer.parseInt(var6.nextToken());
      int var13;
      int var12;
      if (var5 != null) {
         StringTokenizer var10 = new StringTokenizer(var5, ":");
         int var11 = Integer.parseInt(var10.nextToken());
         if (var10.hasMoreTokens()) {
            var13 = Integer.parseInt(var10.nextToken().subSequence(0, 2).toString());
            var12 = var11;
         } else {
            var12 = var11;
            var13 = 0;
         }
      } else {
         var12 = 0;
         var13 = 0;
      }

      Calendar var14 = Calendar.getInstance();
      var14.set(var7, var8 - 1, var9, var12, var13, 0);
      return var14;
   }

   public static Boolean f(Context var0) {
      boolean var10001;
      NetworkInfo var2;
      try {
         var2 = ((ConnectivityManager)var0.getSystemService("connectivity")).getActiveNetworkInfo();
      } catch (Exception var7) {
         var10001 = false;
         return true;
      }

      boolean var3;
      label28: {
         label27: {
            if (var2 != null) {
               try {
                  if (var2.isConnected()) {
                     break label27;
                  }
               } catch (Exception var6) {
                  var10001 = false;
                  return true;
               }
            }

            var3 = false;
            break label28;
         }

         var3 = true;
      }

      try {
         Boolean var4 = var3;
         return var4;
      } catch (Exception var5) {
         var10001 = false;
         return true;
      }
   }
}
