package com.iab.omid.library.adfalcon.d;

import android.os.Build;
import android.os.Build.VERSION;
import org.json.JSONObject;

public final class a {
   public static String a() {
      StringBuilder var0 = new StringBuilder();
      var0.append(Build.MANUFACTURER);
      var0.append("; ");
      var0.append(Build.MODEL);
      return var0.toString();
   }

   public static String b() {
      return Integer.toString(VERSION.SDK_INT);
   }

   public static String c() {
      return "Android";
   }

   public static JSONObject d() {
      JSONObject var0 = new JSONObject();
      b.a(var0, "deviceType", a());
      b.a(var0, "osVersion", b());
      b.a(var0, "os", c());
      return var0;
   }
}
