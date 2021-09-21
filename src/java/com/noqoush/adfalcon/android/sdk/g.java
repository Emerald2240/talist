package com.noqoush.adfalcon.android.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.util.Calendar;
import java.util.Hashtable;

public class g {
   private static g y;
   private String a;
   private String b;
   private String c;
   private String d;
   private String e;
   private int f;
   private int g;
   private int h;
   private String i;
   private int j;
   private String k;
   private String l;
   private long m;
   private long n;
   private String o;
   private double p = -1.0D;
   private double q = -1.0D;
   private float r;
   private Info s;
   private String t;
   private String u;
   private String v;
   private String w;
   private String x;

   private g() {
   }

   private static void b(Context var0) {
      boolean var10001;
      String var2;
      try {
         var2 = ((TelephonyManager)var0.getSystemService("phone")).getNetworkOperator();
      } catch (Exception var7) {
         var10001 = false;
         return;
      }

      String var3 = "";
      String var4;
      if (var2 != null && var2 != var3) {
         try {
            var3 = var2.substring(0, 3);
            var4 = var2.substring(3);
         } catch (Exception var6) {
            var10001 = false;
            return;
         }
      } else {
         var4 = var3;
      }

      try {
         y.i(var3);
         y.j(var4);
      } catch (Exception var5) {
         var10001 = false;
      }
   }

   public static g c(final Context var0) {
      g var1 = y;
      if (var1 == null) {
         label78: {
            Exception var10000;
            label82: {
               boolean var10001;
               long var15;
               try {
                  com.noqoush.adfalcon.android.sdk.k.a("will get device info");
                  var15 = Calendar.getInstance().getTimeInMillis();
                  g var17 = new g();
                  y = var17;
                  var17.c("");
                  y.l(var0.getPackageName());
               } catch (Exception var37) {
                  var10000 = var37;
                  var10001 = false;
                  break label82;
               }

               label83: {
                  label74: {
                     int var32;
                     try {
                        PackageInfo var31 = var0.getPackageManager().getPackageInfo(var0.getPackageName(), 0);
                        y.b(var31.versionName);
                        var32 = var0.getApplicationInfo().labelRes;
                     } catch (Exception var41) {
                        var10000 = var41;
                        var10001 = false;
                        break label74;
                     }

                     if (var32 > 0) {
                        try {
                           y.a(var0.getString(var32));
                           break label83;
                        } catch (Exception var39) {
                           var10000 = var39;
                           var10001 = false;
                        }
                     } else {
                        try {
                           com.noqoush.adfalcon.android.sdk.util.a.e("No app_name found");
                           y.a("Unknown");
                           break label83;
                        } catch (Exception var40) {
                           var10000 = var40;
                           var10001 = false;
                        }
                     }
                  }

                  Exception var18 = var10000;

                  try {
                     com.noqoush.adfalcon.android.sdk.util.a.e("No app_name found");
                     com.noqoush.adfalcon.android.sdk.util.a.a(var18);
                  } catch (Exception var36) {
                     var10000 = var36;
                     var10001 = false;
                     break label82;
                  }
               }

               try {
                  b(var0);
                  h(var0);
                  e(var0);
                  z var19 = new z(var0);
                  y.n(var19.getSettings().getUserAgentString());
                  long var20 = Calendar.getInstance().getTimeInMillis();
                  StringBuilder var22 = new StringBuilder();
                  var22.append("Read device info in ");
                  var22.append(var20 - var15);
                  var22.append("ms");
                  com.noqoush.adfalcon.android.sdk.k.c(var22.toString());
                  g var26 = y;
                  StringBuilder var27 = new StringBuilder();
                  var27.append("");
                  var27.append(VERSION.SDK_INT);
                  var26.m(var27.toString());
                  y.b(VERSION.SDK_INT);
                  y.k(Build.MODEL);
                  y.h(Build.MANUFACTURER);
                  g(var0);
                  d(var0);
               } catch (Exception var35) {
                  var10000 = var35;
                  var10001 = false;
                  break label82;
               }

               if (var0 == null) {
                  break label78;
               }

               try {
                  if (Looper.myLooper() == Looper.getMainLooper()) {
                     (new Thread(new Runnable() {
                        public void run() {
                           com.noqoush.adfalcon.android.sdk.g.y.a(var0);
                        }
                     })).start();
                     break label78;
                  }
               } catch (Exception var38) {
                  var10000 = var38;
                  var10001 = false;
                  break label82;
               }

               try {
                  y.a(var0);
                  break label78;
               } catch (Exception var34) {
                  var10000 = var34;
                  var10001 = false;
               }
            }

            Exception var14 = var10000;
            com.noqoush.adfalcon.android.sdk.util.a.a(var14);
         }
      } else if (var0 != null) {
         var1.i(var0);
      }

      try {
         StringBuilder var2 = new StringBuilder();
         var2.append("did get the following: size:[");
         var2.append(y.v());
         var2.append(", ");
         var2.append(y.u());
         var2.append("], loc:[");
         var2.append(y.i());
         var2.append(", ");
         var2.append(y.j());
         var2.append("], orientation:");
         var2.append(y.g());
         com.noqoush.adfalcon.android.sdk.k.c(var2.toString());
      } catch (Exception var33) {
      }

      return y;
   }

   private static void d(Context var0) throws Exception {
      ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService("connectivity");
      if (var1 != null && var1.getActiveNetworkInfo() != null) {
         g var2 = y;
         String var3 = var1.getActiveNetworkInfo().getTypeName();
         String var4 = "WIFI";
         if (!var3.equalsIgnoreCase(var4)) {
            var4 = "CARRIER";
         }

         var2.d(var4);
      }

   }

   private static void e(Context param0) {
      // $FF: Couldn't be decompiled
   }

   private static void f(Context var0) {
      try {
         y.e(Secure.getString(var0.getContentResolver(), "android_id"));
         if (y.f() == null) {
            y.e("Emulator");
         }

         if (y.f() != null) {
            y.e(y.f());
         }
      } catch (Exception var17) {
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFDeviceInfo->setIDs1: ");
         var2.append(var17.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var2.toString());
      }

      try {
         if (var0.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", var0.getPackageName()) == 0) {
            String var14 = ((TelephonyManager)var0.getSystemService("phone")).getDeviceId();
            y.f(var14);
         }
      } catch (Exception var16) {
         StringBuilder var6 = new StringBuilder();
         var6.append("ADFDeviceInfo->setIDs2: ");
         var6.append(var16.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var6.toString());
      }

      try {
         if (var0.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", var0.getPackageName()) == 0) {
            String var13 = ((WifiManager)var0.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
            y.g(var13);
            return;
         }
      } catch (Exception var15) {
         StringBuilder var10 = new StringBuilder();
         var10.append("ADFDeviceInfo->setIDs3: ");
         var10.append(var15.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var10.toString());
      }

   }

   private static void g(Context var0) throws Exception {
      ActivityManager var1 = (ActivityManager)var0.getSystemService("activity");
      MemoryInfo var2 = new MemoryInfo();
      var1.getMemoryInfo(var2);
      y.a(var2.availMem);
      y.b(var2.availMem);
   }

   private static void h(Context var0) throws Exception {
      float var1 = com.noqoush.adfalcon.android.sdk.util.d.e(var0);
      Display var2 = ((WindowManager)var0.getSystemService("window")).getDefaultDisplay();
      int var5;
      int var4;
      if (VERSION.SDK_INT >= 13) {
         Point var3 = new Point();
         var2.getSize(var3);
         var4 = var3.x;
         var5 = var3.y;
      } else {
         var4 = var2.getWidth();
         var5 = var2.getHeight();
      }

      int var6;
      if (VERSION.SDK_INT >= 8) {
         var6 = var2.getRotation();
      } else {
         var6 = var2.getOrientation();
      }

      y.a(var1);
      y.d(var4);
      y.c(var5);
      y.a(var6);
   }

   private void i(final Context var1) {
      if (var1 != null) {
         boolean var10001;
         try {
            h(var1);
            e(var1);
            g(var1);
            d(var1);
            b(var1);
         } catch (Exception var4) {
            var10001 = false;
            return;
         }

         if (var1 != null) {
            try {
               if (Looper.myLooper() == Looper.getMainLooper()) {
                  (new Thread(new Runnable() {
                     public void run() {
                        com.noqoush.adfalcon.android.sdk.g.y.a(var1);
                     }
                  })).start();
                  return;
               }
            } catch (Exception var5) {
               var10001 = false;
               return;
            }

            try {
               y.a(var1);
               return;
            } catch (Exception var3) {
               var10001 = false;
            }
         }
      }

   }

   private static boolean y() {
      Looper var1;
      Looper var2;
      try {
         var1 = Looper.myLooper();
         var2 = Looper.getMainLooper();
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
         return true;
      }

      return var1 == var2;
   }

   public Info a(Context param1) {
      // $FF: Couldn't be decompiled
   }

   public String a() {
      return this.v;
   }

   public Hashtable a(Context var1, View var2) throws Exception {
      Hashtable var3 = new Hashtable();
      y.i(var1);
      String var4;
      if (this.v() > this.u()) {
         var4 = "l";
      } else {
         var4 = "p";
      }

      var3.put("D_DO", var4);
      StringBuilder var6 = new StringBuilder();
      var6.append("");
      var6.append(this.v());
      var3.put("D_SW", var6.toString());
      StringBuilder var10 = new StringBuilder();
      var10.append("");
      var10.append(this.u());
      var3.put("D_SH", var10.toString());
      StringBuilder var14 = new StringBuilder();
      var14.append("");
      var14.append(this.e());
      var3.put("D_Density", var14.toString());
      StringBuilder var18 = new StringBuilder();
      var18.append("");
      var18.append(this.w());
      var3.put("D_UA", var18.toString());
      StringBuilder var22 = new StringBuilder();
      var22.append("");
      var22.append(this.s());
      var3.put("D_OSV", var22.toString());
      var3.put("D_OS", "android");
      var3.put("D_DMdl", this.o());
      var3.put("D_DM", this.l());
      StringBuilder var29 = new StringBuilder();
      var29.append("");
      var29.append(this.r());
      var3.put("D_RAM_SZ", var29.toString());
      StringBuilder var33 = new StringBuilder();
      var33.append("");
      var33.append(this.q());
      var3.put("D_RAM_FSZ", var33.toString());
      StringBuilder var37 = new StringBuilder();
      var37.append("");
      var37.append(this.d());
      var3.put("D_CON_TYPE", var37.toString());
      if (this.i() != -1.0D && this.j() != -1.0D) {
         StringBuilder var73 = new StringBuilder();
         var73.append("");
         var73.append(this.i());
         var3.put("U_LA", var73.toString());
         StringBuilder var77 = new StringBuilder();
         var77.append("");
         var77.append(this.j());
         var3.put("U_LO", var77.toString());
      }

      if (this.m() != null && this.m() != "") {
         var3.put("D_MCC", this.m());
      }

      if (this.n() != null && this.n() != "") {
         var3.put("D_MNC", this.n());
      }

      if (this.a(var1) != null) {
         StringBuilder var41 = new StringBuilder();
         var41.append("");
         var41.append(this.a(var1).getId());
         var3.put("D_UID_IDFA", var41.toString());
         StringBuilder var45 = new StringBuilder();
         var45.append("");
         var45.append(true ^ this.a(var1).isLimitAdTrackingEnabled());
         var3.put("D_UID_IDTF", var45.toString());
      } else {
         f(var1);
         var3.put("D_UID_MD5_ANDR", com.noqoush.adfalcon.android.sdk.util.d.c(this.f()));
         var3.put("D_UID_SHA1_ANDR", com.noqoush.adfalcon.android.sdk.util.d.d(this.f()));
         if (this.h() != null) {
            var3.put("D_UID_MD5_IMEI", com.noqoush.adfalcon.android.sdk.util.d.c(this.h()));
            var3.put("D_UID_SHA1_IMEI", com.noqoush.adfalcon.android.sdk.util.d.d(this.h()));
         }

         if (this.k() != null) {
            var3.put("D_UID_MD5_MAC", com.noqoush.adfalcon.android.sdk.util.d.c(this.k()));
            var3.put("D_UID_SHA1_MAC", com.noqoush.adfalcon.android.sdk.util.d.d(this.k()));
         }
      }

      if (this.p() != null && this.p().length() > 0) {
         var3.put("R_AppBundle", this.p());
      }

      if (this.a() != null && this.a().length() > 0) {
         var3.put("R_AppName", this.a());
      }

      if (this.b() != null && this.b().length() > 0) {
         var3.put("R_AppVer", this.b());
      }

      boolean var49 = this.a(var2);
      if (var49) {
         StringBuilder var50 = new StringBuilder();
         var50.append("");
         var50.append(var49);
         var3.put("D_HWACC", var50.toString());
      }

      String var54 = "mraid1,mraid2,interactivevideo,omid1";
      if (VERSION.SDK_INT >= 13 && var49) {
         StringBuilder var56 = new StringBuilder();
         var56.append(var54);
         var56.append(",inlinevideo");
         var54 = var56.toString();
         if (VERSION.SDK_INT >= 17) {
            StringBuilder var59 = new StringBuilder();
            var59.append(var54);
            var59.append(",autoplay");
            var54 = var59.toString();
         }
      }

      var3.put("D_CAPS", var54);
      return var3;
   }

   public void a(double var1) {
      this.p = var1;
   }

   protected void a(float var1) {
      this.r = var1;
   }

   void a(int var1) {
      this.f = var1;
   }

   public void a(long var1) {
      this.m = var1;
   }

   public void a(String var1) {
      this.v = var1;
   }

   public boolean a(View var1) {
      return VERSION.SDK_INT >= 11;
   }

   public String b() {
      return this.u;
   }

   public void b(double var1) {
      this.q = var1;
   }

   public void b(int var1) {
      this.j = var1;
   }

   public void b(long var1) {
      this.n = var1;
   }

   public void b(String var1) {
      this.u = var1;
   }

   public String c() {
      return this.a;
   }

   void c(int var1) {
      this.h = var1;
   }

   void c(String var1) {
      this.a = var1;
   }

   public String d() {
      return this.o;
   }

   void d(int var1) {
      this.g = var1;
   }

   public void d(String var1) {
      this.o = var1;
   }

   public float e() {
      return this.r;
   }

   void e(String var1) {
      this.b = var1;
   }

   public String f() {
      return this.b;
   }

   protected void f(String var1) {
      this.c = var1;
   }

   public int g() {
      return this.f;
   }

   protected void g(String var1) {
      this.d = var1;
   }

   protected String h() {
      return this.c;
   }

   public void h(String var1) {
      this.l = var1;
   }

   public double i() {
      return this.p;
   }

   public void i(String var1) {
      this.w = var1;
   }

   public double j() {
      return this.q;
   }

   public void j(String var1) {
      this.x = var1;
   }

   protected String k() {
      return this.d;
   }

   public void k(String var1) {
      this.k = var1;
   }

   public String l() {
      return this.l;
   }

   public void l(String var1) {
      this.t = var1;
   }

   public String m() {
      return this.w;
   }

   public void m(String var1) {
      this.i = var1;
   }

   public String n() {
      return this.x;
   }

   public void n(String var1) {
      this.e = var1;
   }

   public String o() {
      return this.k;
   }

   public String p() {
      return this.t;
   }

   public long q() {
      return this.m;
   }

   public long r() {
      return this.n;
   }

   public String s() {
      return this.i;
   }

   public int t() {
      return this.j;
   }

   public int u() {
      return this.h;
   }

   public int v() {
      return this.g;
   }

   public String w() {
      return this.e;
   }
}
