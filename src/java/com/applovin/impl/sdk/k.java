package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class k {
   private static String e;
   private static String f;
   private static int g;
   private final j a;
   private final p b;
   private final Context c;
   private final Map d;
   private final AtomicReference h = new AtomicReference();

   protected k(j var1) {
      if (var1 != null) {
         this.a = var1;
         this.b = var1.v();
         this.c = var1.D();
         this.d = Collections.synchronizedMap(new HashMap());
      } else {
         throw new IllegalArgumentException("No sdk specified");
      }
   }

   private k.d a(k.d var1) {
      if (var1 == null) {
         var1 = new k.d();
      }

      var1.K = com.applovin.impl.sdk.g.a(this.c);
      var1.L = com.applovin.impl.sdk.g.b(this.c);
      var1.M = com.applovin.impl.sdk.g.c(this.c);
      k.c var2;
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.eb)) {
         var2 = this.j();
      } else {
         var2 = null;
      }

      var1.u = var2;
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.eo)) {
         var1.t = this.p();
      }

      boolean var10001;
      Throwable var10000;
      label1018: {
         label1026: {
            AudioManager var17;
            try {
               var17 = (AudioManager)this.c.getSystemService("audio");
            } catch (Throwable var81) {
               var10000 = var81;
               var10001 = false;
               break label1026;
            }

            if (var17 == null) {
               break label1018;
            }

            label1013:
            try {
               var1.x = (int)((Float)this.a.a(com.applovin.impl.sdk.b.d.ep) * (float)var17.getStreamVolume(3));
               break label1018;
            } catch (Throwable var80) {
               var10000 = var80;
               var10001 = false;
               break label1013;
            }
         }

         Throwable var3 = var10000;
         this.b.b("DataCollector", "Unable to collect volume", var3);
      }

      try {
         var1.y = (int)(100.0F * ((float)System.getInt(this.c.getContentResolver(), "screen_brightness") / 255.0F));
      } catch (SettingNotFoundException var75) {
         this.b.b("DataCollector", "Unable to collect screen brightness", var75);
      }

      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.eq)) {
         if (e == null) {
            String var16 = this.t();
            if (!com.applovin.impl.sdk.utils.n.b(var16)) {
               var16 = "";
            }

            e = var16;
         }

         if (com.applovin.impl.sdk.utils.n.b(e)) {
            var1.z = e;
         }
      }

      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.ef)) {
         label1006:
         try {
            var1.H = Environment.getDataDirectory().getFreeSpace();
            var1.I = Environment.getDataDirectory().getTotalSpace();
         } catch (Throwable var79) {
            var1.H = -1L;
            var1.I = -1L;
            this.b.b("DataCollector", "Unable to collect total & free space.", var79);
            break label1006;
         }
      }

      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.eg)) {
         label1002:
         try {
            ActivityManager var13 = (ActivityManager)this.c.getSystemService("activity");
            MemoryInfo var14 = new MemoryInfo();
            var13.getMemoryInfo(var14);
            var1.J.b = var14.availMem;
            var1.J.d = var14.lowMemory;
            var1.J.c = var14.threshold;
            var1.J.a = var14.totalMem;
         } catch (Throwable var78) {
            this.b.b("DataCollector", "Unable to collect memory info.", var78);
            break label1002;
         }
      }

      String var5 = (String)this.a.C().a(com.applovin.impl.sdk.b.d.es);
      if (!var5.equalsIgnoreCase(f)) {
         try {
            f = var5;
            PackageInfo var11 = this.c.getPackageManager().getPackageInfo(var5, 0);
            var1.s = var11.versionCode;
            g = var11.versionCode;
         } finally {
            ;
         }
      } else {
         var1.s = g;
      }

      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.ec)) {
         var1.C = AppLovinSdkUtils.isTablet(this.c);
      }

      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.ed)) {
         var1.D = this.o();
      }

      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.ee)) {
         String var9 = this.m();
         if (!TextUtils.isEmpty(var9)) {
            var1.G = var9;
         }
      }

      var1.l = this.g();
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.eh)) {
         var1.E = com.applovin.impl.sdk.utils.q.d();
      }

      if (com.applovin.impl.sdk.utils.g.d()) {
         label991: {
            label1028: {
               boolean var7;
               try {
                  var7 = ((PowerManager)this.c.getSystemService("power")).isPowerSaveMode();
               } catch (Throwable var77) {
                  var10000 = var77;
                  var10001 = false;
                  break label1028;
               }

               byte var8 = 0;
               if (var7) {
                  var8 = 1;
               }

               label986:
               try {
                  var1.F = var8;
                  break label991;
               } catch (Throwable var76) {
                  var10000 = var76;
                  var10001 = false;
                  break label986;
               }
            }

            Throwable var6 = var10000;
            this.b.b("DataCollector", "Unable to collect power saving mode", var6);
         }
      }

      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.et) && this.a.ad() != null) {
         var1.O = this.a.ad().c();
      }

      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.eu) && this.a.ad() != null) {
         var1.P = this.a.ad().b();
      }

      return var1;
   }

   private String a(int var1) {
      if (var1 == 1) {
         return "receiver";
      } else if (var1 == 2) {
         return "speaker";
      } else if (var1 != 4 && var1 != 3) {
         if (var1 == 8) {
            return "bluetootha2dpoutput";
         } else if (var1 != 13 && var1 != 19 && var1 != 5 && var1 != 6 && var1 != 12 && var1 != 11) {
            return var1 != 9 && var1 != 10 ? null : "hdmioutput";
         } else {
            return "lineout";
         }
      } else {
         return "headphones";
      }
   }

   private boolean a(String var1) {
      int var3;
      try {
         var3 = Secure.getInt(this.c.getContentResolver(), var1);
      } catch (SettingNotFoundException var5) {
         return false;
      }

      boolean var4 = false;
      if (var3 == 1) {
         var4 = true;
      }

      return var4;
   }

   private boolean a(String var1, com.applovin.impl.sdk.b.d var2) {
      Iterator var3 = com.applovin.impl.sdk.utils.e.a((String)this.a.a(var2)).iterator();

      do {
         if (!var3.hasNext()) {
            return false;
         }
      } while(!var1.startsWith((String)var3.next()));

      return true;
   }

   private boolean b(String var1) {
      if (var1 != null) {
         Context var2 = this.c;
         if (var2 != null) {
            return com.applovin.impl.sdk.utils.k.a(var1, var2.getPackageName(), this.c.getPackageManager()) == 0;
         } else {
            throw new IllegalArgumentException("No context specified");
         }
      } else {
         throw new IllegalArgumentException("No permission name specified");
      }
   }

   private String c(String var1) {
      int var2 = var1.length();
      int[] var3 = new int[]{11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
      int var4 = var3.length;
      char[] var5 = new char[var2];

      for(int var6 = 0; var6 < var2; ++var6) {
         var5[var6] = var1.charAt(var6);

         for(int var7 = var4 - 1; var7 >= 0; --var7) {
            var5[var6] = (char)(var5[var6] ^ var3[var7]);
         }
      }

      return new String(var5);
   }

   // $FF: synthetic method
   static AtomicReference c(k var0) {
      return var0.h;
   }

   private Map f() {
      return this.a((Map)null, false, true);
   }

   private String g() {
      int var2;
      try {
         var2 = com.applovin.impl.sdk.utils.q.b(this.c);
      } catch (Throwable var4) {
         this.a.v().b("DataCollector", "Encountered error while attempting to collect application orientation", var4);
         return "none";
      }

      if (var2 == 1) {
         return "portrait";
      } else if (var2 == 2) {
         return "landscape";
      } else {
         return "none";
      }
   }

   private k.a h() {
      if (this.i()) {
         try {
            k.a var1 = new k.a();
            Info var3 = AdvertisingIdClient.getAdvertisingIdInfo(this.c);
            var1.a = var3.isLimitAdTrackingEnabled();
            var1.b = var3.getId();
            return var1;
         } catch (Throwable var5) {
            this.b.b("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", var5);
            return new k.a();
         }
      } else {
         p.j("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }");
         return new k.a();
      }
   }

   private boolean i() {
      return com.applovin.impl.sdk.utils.q.e("com.google.android.gms.ads.identifier.AdvertisingIdClient");
   }

   private k.c j() {
      Throwable var10000;
      label429: {
         boolean var10001;
         Intent var4;
         k.c var1;
         try {
            var1 = new k.c();
            IntentFilter var2 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            var4 = this.c.registerReceiver((BroadcastReceiver)null, var2);
         } catch (Throwable var63) {
            var10000 = var63;
            var10001 = false;
            break label429;
         }

         int var5 = -1;
         int var6;
         if (var4 != null) {
            try {
               var6 = var4.getIntExtra("level", var5);
            } catch (Throwable var62) {
               var10000 = var62;
               var10001 = false;
               break label429;
            }
         } else {
            var6 = -1;
         }

         int var7;
         if (var4 != null) {
            try {
               var7 = var4.getIntExtra("scale", var5);
            } catch (Throwable var61) {
               var10000 = var61;
               var10001 = false;
               break label429;
            }
         } else {
            var7 = -1;
         }

         if (var6 > 0 && var7 > 0) {
            try {
               var1.b = (int)(100.0F * ((float)var6 / (float)var7));
            } catch (Throwable var60) {
               var10000 = var60;
               var10001 = false;
               break label429;
            }
         } else {
            try {
               var1.b = var5;
            } catch (Throwable var59) {
               var10000 = var59;
               var10001 = false;
               break label429;
            }
         }

         if (var4 != null) {
            try {
               var5 = var4.getIntExtra("status", var5);
            } catch (Throwable var58) {
               var10000 = var58;
               var10001 = false;
               break label429;
            }
         }

         label403:
         try {
            var1.a = var5;
            return var1;
         } catch (Throwable var57) {
            var10000 = var57;
            var10001 = false;
            break label403;
         }
      }

      Throwable var3 = var10000;
      this.b.b("DataCollector", "Unable to collect battery info", var3);
      return null;
   }

   private long k() {
      List var1 = Arrays.asList(com.applovin.impl.sdk.utils.n.c(Secure.getString(this.c.getContentResolver(), "enabled_accessibility_services")).split(":"));
      long var2;
      if (var1.contains("AccessibilityMenuService")) {
         var2 = 256L;
      } else {
         var2 = 0L;
      }

      if (var1.contains("SelectToSpeakService")) {
         var2 |= 512L;
      }

      if (var1.contains("SoundAmplifierService")) {
         var2 |= 2L;
      }

      if (var1.contains("SpeechToTextAccessibilityService")) {
         var2 |= 128L;
      }

      if (var1.contains("SwitchAccessService")) {
         var2 |= 4L;
      }

      if ((48 & this.c.getResources().getConfiguration().uiMode) == 32) {
         var2 |= 1024L;
      }

      if (this.a("accessibility_enabled")) {
         var2 |= 8L;
      }

      if (this.a("touch_exploration_enabled")) {
         var2 |= 16L;
      }

      if (com.applovin.impl.sdk.utils.g.d()) {
         if (this.a("accessibility_display_inversion_enabled")) {
            var2 |= 32L;
         }

         if (this.a("skip_first_use_hints")) {
            var2 |= 64L;
         }
      }

      return var2;
   }

   private float l() {
      try {
         float var2 = System.getFloat(this.c.getContentResolver(), "font_scale");
         return var2;
      } catch (SettingNotFoundException var3) {
         this.b.b("DataCollector", "Error collecting font scale", var3);
         return -1.0F;
      }
   }

   private String m() {
      Throwable var10000;
      label559: {
         boolean var10001;
         StringBuilder var3;
         boolean var4;
         AudioManager var2;
         try {
            var2 = (AudioManager)this.c.getSystemService("audio");
            var3 = new StringBuilder();
            var4 = com.applovin.impl.sdk.utils.g.e();
         } catch (Throwable var69) {
            var10000 = var69;
            var10001 = false;
            break label559;
         }

         if (var4) {
            int var11;
            AudioDeviceInfo[] var10;
            try {
               var10 = var2.getDevices(2);
               var11 = var10.length;
            } catch (Throwable var66) {
               var10000 = var66;
               var10001 = false;
               break label559;
            }

            for(int var12 = 0; var12 < var11; ++var12) {
               try {
                  String var13 = this.a(var10[var12].getType());
                  if (!TextUtils.isEmpty(var13)) {
                     var3.append(var13);
                     var3.append(",");
                  }
               } catch (Throwable var68) {
                  var10000 = var68;
                  var10001 = false;
                  break label559;
               }
            }
         } else {
            try {
               if (var2.isWiredHeadsetOn()) {
                  var3.append("headphones");
                  var3.append(",");
               }
            } catch (Throwable var67) {
               var10000 = var67;
               var10001 = false;
               break label559;
            }

            try {
               if (var2.isBluetoothA2dpOn()) {
                  var3.append("bluetootha2dpoutput");
               }
            } catch (Throwable var65) {
               var10000 = var65;
               var10001 = false;
               break label559;
            }
         }

         try {
            if (var3.length() > 0 && var3.charAt(-1 + var3.length()) == ',') {
               var3.deleteCharAt(-1 + var3.length());
            }
         } catch (Throwable var64) {
            var10000 = var64;
            var10001 = false;
            break label559;
         }

         label530:
         try {
            String var5 = var3.toString();
            if (TextUtils.isEmpty(var5)) {
               this.b.b("DataCollector", "No sound outputs detected");
            }

            return var5;
         } catch (Throwable var63) {
            var10000 = var63;
            var10001 = false;
            break label530;
         }
      }

      Throwable var1 = var10000;
      this.b.b("DataCollector", "Unable to collect sound outputs", var1);
      return null;
   }

   private double n() {
      double var1 = (double)TimeZone.getDefault().getOffset((new Date()).getTime());
      Double.isNaN(var1);
      double var4 = (double)Math.round(var1 * 10.0D / 3600000.0D);
      Double.isNaN(var4);
      return var4 / 10.0D;
   }

   private boolean o() {
      try {
         PackageManager var2 = this.c.getPackageManager();
         if (com.applovin.impl.sdk.utils.g.d()) {
            return var2.hasSystemFeature("android.software.leanback");
         } else {
            boolean var3 = var2.hasSystemFeature("android.hardware.type.television");
            return var3;
         }
      } catch (Throwable var5) {
         this.b.b("DataCollector", "Failed to determine if device is TV.", var5);
         return false;
      }
   }

   private boolean p() {
      boolean var2;
      label36: {
         boolean var3;
         try {
            if (this.q()) {
               break label36;
            }

            var3 = this.r();
         } finally {
            ;
         }

         var2 = false;
         if (!var3) {
            return var2;
         }
      }

      var2 = true;
      return var2;
   }

   private boolean q() {
      String var1 = Build.TAGS;
      return var1 != null && var1.contains(this.c("lz}$blpz"));
   }

   private boolean r() {
      String[] var1 = new String[]{"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if ((new File(this.c(var1[var3]))).exists()) {
            return true;
         }
      }

      return false;
   }

   private boolean s() {
      return this.a(Build.DEVICE, com.applovin.impl.sdk.b.d.el) || this.a(Build.HARDWARE, com.applovin.impl.sdk.b.d.ek) || this.a(Build.MANUFACTURER, com.applovin.impl.sdk.b.d.em) || this.a(Build.MODEL, com.applovin.impl.sdk.b.d.en);
   }

   private String t() {
      final AtomicReference var1 = new AtomicReference();
      final CountDownLatch var2 = new CountDownLatch(1);
      (new Handler(this.c.getMainLooper())).post(new Runnable() {
         public void run() {
            try {
               WebView var1x = new WebView(k.this.c);
               var1.set(var1x.getSettings().getUserAgentString());
            } catch (Throwable var9) {
               Throwable var2x = var9;

               try {
                  k.this.b.b("DataCollector", "Unable to collect user agent string", var2x);
                  return;
               } finally {
                  var2.countDown();
               }
            }

         }
      });

      try {
         var2.await((Long)this.a.a(com.applovin.impl.sdk.b.d.er), TimeUnit.MILLISECONDS);
      } finally {
         return (String)var1.get();
      }

      return (String)var1.get();
   }

   String a() {
      String var1 = Base64.encodeToString((new JSONObject(this.f())).toString().getBytes(Charset.defaultCharset()), 2);
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.eS)) {
         long var2 = com.applovin.impl.sdk.utils.q.a(this.a);
         var1 = com.applovin.impl.sdk.utils.l.a(var1, this.a.t(), var2);
      }

      return var1;
   }

   public Map a(Map var1, boolean var2, boolean var3) {
      HashMap var4 = new HashMap();
      k.d var5 = this.b();
      var4.put("brand", com.applovin.impl.sdk.utils.n.e(var5.d));
      var4.put("brand_name", com.applovin.impl.sdk.utils.n.e(var5.e));
      var4.put("hardware", com.applovin.impl.sdk.utils.n.e(var5.f));
      var4.put("api_level", String.valueOf(var5.h));
      var4.put("carrier", com.applovin.impl.sdk.utils.n.e(var5.j));
      var4.put("country_code", com.applovin.impl.sdk.utils.n.e(var5.i));
      var4.put("locale", com.applovin.impl.sdk.utils.n.e(var5.k.toString()));
      var4.put("model", com.applovin.impl.sdk.utils.n.e(var5.a));
      var4.put("os", com.applovin.impl.sdk.utils.n.e(var5.b));
      var4.put("platform", com.applovin.impl.sdk.utils.n.e(var5.c));
      var4.put("revision", com.applovin.impl.sdk.utils.n.e(var5.g));
      var4.put("orientation_lock", var5.l);
      var4.put("tz_offset", String.valueOf(var5.r));
      var4.put("aida", String.valueOf(var5.N));
      var4.put("wvvc", String.valueOf(var5.s));
      var4.put("adns", String.valueOf(var5.m));
      var4.put("adnsd", String.valueOf(var5.n));
      var4.put("xdpi", String.valueOf(var5.o));
      var4.put("ydpi", String.valueOf(var5.p));
      var4.put("screen_size_in", String.valueOf(var5.q));
      var4.put("sim", com.applovin.impl.sdk.utils.n.a(var5.A));
      var4.put("gy", com.applovin.impl.sdk.utils.n.a(var5.B));
      var4.put("is_tablet", com.applovin.impl.sdk.utils.n.a(var5.C));
      var4.put("tv", com.applovin.impl.sdk.utils.n.a(var5.D));
      var4.put("vs", com.applovin.impl.sdk.utils.n.a(var5.E));
      var4.put("lpm", String.valueOf(var5.F));
      var4.put("fs", String.valueOf(var5.H));
      var4.put("tds", String.valueOf(var5.I));
      var4.put("fm", String.valueOf(var5.J.b));
      var4.put("tm", String.valueOf(var5.J.a));
      var4.put("lmt", String.valueOf(var5.J.c));
      var4.put("lm", String.valueOf(var5.J.d));
      var4.put("adr", com.applovin.impl.sdk.utils.n.a(var5.t));
      var4.put("volume", String.valueOf(var5.x));
      var4.put("sb", String.valueOf(var5.y));
      var4.put("af", String.valueOf(var5.v));
      var4.put("font", String.valueOf(var5.w));
      com.applovin.impl.sdk.utils.q.a((String)"ua", (String)com.applovin.impl.sdk.utils.n.e(var5.z), (Map)var4);
      com.applovin.impl.sdk.utils.q.a((String)"so", (String)com.applovin.impl.sdk.utils.n.e(var5.G), (Map)var4);
      var4.put("bt_ms", String.valueOf(var5.Q));
      if (var5.O > 0.0F) {
         var4.put("da", String.valueOf(var5.O));
      }

      if (var5.P > 0.0F) {
         var4.put("dm", String.valueOf(var5.P));
      }

      k.c var44 = var5.u;
      if (var44 != null) {
         var4.put("act", String.valueOf(var44.a));
         var4.put("acm", String.valueOf(var44.b));
      }

      Boolean var45 = var5.K;
      if (var45 != null) {
         var4.put("huc", var45.toString());
      }

      Boolean var46 = var5.L;
      if (var46 != null) {
         var4.put("aru", var46.toString());
      }

      Boolean var47 = var5.M;
      if (var47 != null) {
         var4.put("dns", var47.toString());
      }

      Point var48 = com.applovin.impl.sdk.utils.g.a(this.c);
      var4.put("dx", Integer.toString(var48.x));
      var4.put("dy", Integer.toString(var48.y));
      var4.put("accept", "custom_size,launch_app,video");
      var4.put("api_did", this.a.a(com.applovin.impl.sdk.b.d.X));
      var4.put("sdk_version", AppLovinSdk.VERSION);
      var4.put("build", Integer.toString(131));
      var4.put("format", "json");
      k.b var56 = this.c();
      var4.put("app_version", com.applovin.impl.sdk.utils.n.e(var56.b));
      var4.put("ia", Long.toString(var56.h));
      var4.put("tg", String.valueOf(var56.e));
      var4.put("ltg", String.valueOf(var56.f));
      var4.put("installer_name", var56.d);
      var4.put("debug", var56.g);
      com.applovin.impl.sdk.utils.q.a((String)"mediation_provider", (String)com.applovin.impl.sdk.utils.n.e(this.a.n()), (Map)var4);
      var4.put("network", com.applovin.impl.sdk.utils.h.f(this.a));
      com.applovin.impl.sdk.utils.q.a((String)"plugin_version", (String)((String)this.a.a(com.applovin.impl.sdk.b.d.ea)), (Map)var4);
      var4.put("preloading", String.valueOf(var2));
      var4.put("first_install", String.valueOf(this.a.H()));
      var4.put("first_install_v2", String.valueOf(true ^ this.a.I()));
      if (!(Boolean)this.a.a(com.applovin.impl.sdk.b.d.eR)) {
         var4.put("sdk_key", this.a.t());
      }

      var4.put("sc", this.a.a(com.applovin.impl.sdk.b.d.aa));
      var4.put("sc2", this.a.a(com.applovin.impl.sdk.b.d.ab));
      var4.put("server_installed_at", com.applovin.impl.sdk.utils.n.e((String)this.a.a(com.applovin.impl.sdk.b.d.ac)));
      com.applovin.impl.sdk.utils.q.a((String)"persisted_data", (String)com.applovin.impl.sdk.utils.n.e((String)this.a.a(com.applovin.impl.sdk.b.f.z)), (Map)var4);
      var4.put("v1", Boolean.toString(com.applovin.impl.sdk.utils.g.a("android.permission.WRITE_EXTERNAL_STORAGE", this.c)));
      var4.put("v2", "true");
      var4.put("v3", "true");
      var4.put("v4", "true");
      var4.put("v5", "true");
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.ex)) {
         com.applovin.impl.sdk.c.h var89 = this.a.L();
         var4.put("li", String.valueOf(var89.b(com.applovin.impl.sdk.c.g.b)));
         var4.put("si", String.valueOf(var89.b(com.applovin.impl.sdk.c.g.d)));
         var4.put("pf", String.valueOf(var89.b(com.applovin.impl.sdk.c.g.h)));
         var4.put("mpf", String.valueOf(var89.b(com.applovin.impl.sdk.c.g.n)));
         var4.put("gpf", String.valueOf(var89.b(com.applovin.impl.sdk.c.g.i)));
      }

      k.a var76;
      label60: {
         var4.put("vz", com.applovin.impl.sdk.utils.n.f(this.c.getPackageName()));
         if (var3) {
            var76 = (k.a)this.h.get();
            if (var76 != null) {
               this.e();
               break label60;
            }

            if (com.applovin.impl.sdk.utils.q.b()) {
               var76 = new k.a();
               var4.put("inc", Boolean.toString(true));
               break label60;
            }
         }

         var76 = this.a.O().d();
      }

      String var77 = var76.b;
      if (com.applovin.impl.sdk.utils.n.b(var77)) {
         var4.put("idfa", var77);
      }

      var4.put("dnt", Boolean.toString(var76.a));
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.dT)) {
         com.applovin.impl.sdk.utils.q.a((String)"cuid", (String)this.a.i(), (Map)var4);
      }

      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.dW)) {
         var4.put("compass_random_token", this.a.j());
      }

      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.dY)) {
         var4.put("applovin_random_token", this.a.k());
      }

      if (var1 != null) {
         var4.putAll(var1);
      }

      var4.put("rid", UUID.randomUUID().toString());
      com.applovin.impl.sdk.network.a.b var80 = this.a.J().a();
      if (var80 != null) {
         var4.put("lrm_ts_ms", String.valueOf(var80.a()));
         var4.put("lrm_url", var80.b());
         var4.put("lrm_ct_ms", String.valueOf(var80.d()));
         var4.put("lrm_rs", String.valueOf(var80.c()));
      }

      return var4;
   }

   public k.d b() {
      Object var1 = this.d.get(k.d.class);
      k.d var2;
      if (var1 != null) {
         var2 = (k.d)var1;
      } else {
         var2 = new k.d();
         var2.k = Locale.getDefault();
         var2.a = Build.MODEL;
         var2.b = VERSION.RELEASE;
         var2.c = "android";
         var2.d = Build.MANUFACTURER;
         var2.e = Build.BRAND;
         var2.f = Build.HARDWARE;
         var2.h = VERSION.SDK_INT;
         var2.g = Build.DEVICE;
         var2.r = this.n();
         var2.A = this.s();
         var2.N = this.i();

         boolean var10001;
         label333: {
            Throwable var10000;
            label332: {
               boolean var19;
               label331: {
                  label330: {
                     try {
                        if (((SensorManager)this.c.getSystemService("sensor")).getDefaultSensor(4) != null) {
                           break label330;
                        }
                     } catch (Throwable var44) {
                        var10000 = var44;
                        var10001 = false;
                        break label332;
                     }

                     var19 = false;
                     break label331;
                  }

                  var19 = true;
               }

               label324:
               try {
                  var2.B = var19;
                  break label333;
               } catch (Throwable var43) {
                  var10000 = var43;
                  var10001 = false;
                  break label324;
               }
            }

            Throwable var3 = var10000;
            this.b.b("DataCollector", "Unable to retrieve gyroscope availability", var3);
         }

         if (this.b("android.permission.READ_PHONE_STATE")) {
            TelephonyManager var16 = (TelephonyManager)this.c.getSystemService("phone");
            if (var16 != null) {
               var2.i = var16.getSimCountryIso().toUpperCase(Locale.ENGLISH);
               String var17 = var16.getNetworkOperatorName();

               try {
                  var2.j = URLEncoder.encode(var17, "UTF-8");
               } catch (UnsupportedEncodingException var40) {
                  var2.j = var17;
               }
            }
         }

         label339: {
            double var8;
            float var10;
            try {
               DisplayMetrics var6 = this.c.getResources().getDisplayMetrics();
               var2.m = var6.density;
               var2.n = var6.densityDpi;
               var2.o = var6.xdpi;
               var2.p = var6.ydpi;
               Point var7 = com.applovin.impl.sdk.utils.g.a(this.c);
               var8 = Math.sqrt(Math.pow((double)var7.x, 2.0D) + Math.pow((double)var7.y, 2.0D));
               var10 = var2.o;
            } catch (Throwable var42) {
               var10001 = false;
               break label339;
            }

            double var11 = (double)var10;
            Double.isNaN(var11);
            double var14 = var8 / var11;

            label313:
            try {
               var2.q = var14;
            } catch (Throwable var41) {
               var10001 = false;
               break label313;
            }
         }

         if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.ei)) {
            var2.v = this.k();
         }

         if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.ej)) {
            var2.w = this.l();
         }

         var2.Q = java.lang.System.currentTimeMillis() - SystemClock.elapsedRealtime();
         this.d.put(k.d.class, var2);
      }

      return this.a(var2);
   }

   public k.b c() {
      Object var1 = this.d.get(k.b.class);
      if (var1 != null) {
         return (k.b)var1;
      } else {
         ApplicationInfo var2 = this.c.getApplicationInfo();
         long var3 = (new File(var2.sourceDir)).lastModified();
         PackageManager var5 = this.c.getPackageManager();
         String var6 = null;

         PackageInfo var8;
         try {
            var8 = var5.getPackageInfo(this.c.getPackageName(), 0);
         } finally {
            ;
         }

         try {
            var6 = var5.getInstallerPackageName(var2.packageName);
         } finally {
            ;
         }

         k.b var9 = new k.b();
         var9.c = var2.packageName;
         String var10 = "";
         if (var6 == null) {
            var6 = var10;
         }

         var9.d = var6;
         var9.h = var3;
         var9.a = String.valueOf(var5.getApplicationLabel(var2));
         if (var8 != null) {
            var10 = var8.versionName;
         }

         var9.b = var10;
         var9.e = com.applovin.impl.sdk.utils.q.a(com.applovin.impl.sdk.b.f.g, this.a);
         var9.f = com.applovin.impl.sdk.utils.q.a(com.applovin.impl.sdk.b.f.h, this.a);
         var9.g = Boolean.toString(com.applovin.impl.sdk.utils.q.b(this.a));
         this.d.put(k.b.class, var9);
         return var9;
      }
   }

   public k.a d() {
      k.a var1 = this.h();
      if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.dS)) {
         if (var1.a && !(Boolean)this.a.a(com.applovin.impl.sdk.b.d.dR)) {
            var1.b = "";
            return var1;
         }
      } else {
         var1 = new k.a();
      }

      return var1;
   }

   public void e() {
      this.a.K().a((com.applovin.impl.sdk.d.a)(new com.applovin.impl.sdk.d.i(this.a, new k$2(this))), com.applovin.impl.sdk.d.r.a.d);
   }

   public static class a {
      public boolean a;
      public String b = "";
   }

   public static class b {
      public String a;
      public String b;
      public String c;
      public String d;
      public String e;
      public String f;
      public String g;
      public long h;
   }

   public static class c {
      public int a = -1;
      public int b = -1;
   }

   public static class d {
      public boolean A;
      public boolean B;
      public boolean C;
      public boolean D;
      public boolean E;
      public int F = -1;
      public String G;
      public long H;
      public long I;
      public k.e J = new k.e();
      public Boolean K;
      public Boolean L;
      public Boolean M;
      public boolean N;
      public float O;
      public float P;
      public long Q;
      public String a;
      public String b;
      public String c;
      public String d;
      public String e;
      public String f;
      public String g;
      public int h;
      public String i;
      public String j;
      public Locale k;
      public String l;
      public float m;
      public int n;
      public float o;
      public float p;
      public double q;
      public double r;
      public int s;
      public boolean t;
      public k.c u;
      public long v;
      public float w;
      public int x;
      public int y;
      public String z;
   }

   public static class e {
      public long a = -1L;
      public long b = -1L;
      public long c = -1L;
      public boolean d = false;
   }
}
