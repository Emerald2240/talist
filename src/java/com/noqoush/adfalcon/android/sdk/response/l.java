package com.noqoush.adfalcon.android.sdk.response;

import org.json.JSONException;
import org.json.JSONObject;

public class l {
   private static final String i = "hwacc";
   private static final String j = "adVwPct";
   private static final String k = "adVwDur";
   private static final String l = "adTtl";
   private static final String m = "adCC";
   private static final String n = "IntrLdTout";
   private static final String o = "settings";
   private static final String p = "MraidOnReadyVw";
   private static final String q = "extBr";
   private int a = 0;
   private int b = 0;
   private double c = 0.0D;
   private boolean d = true;
   private int e = -1;
   private int f = 5000;
   private int g = 0;
   private boolean h = false;

   public l(JSONObject var1) throws JSONException {
      if (!var1.isNull("settings")) {
         JSONObject var2 = var1.getJSONObject("settings");
         this.d(var2.getInt("adTtl"));
         this.e(var2.getInt("adVwDur"));
         this.a(var2.getDouble("adVwPct"));
         if (!var2.isNull("hwacc")) {
            this.b(var2.getBoolean("hwacc"));
         }

         if (!var2.isNull("adCC")) {
            this.a(var2.getInt("adCC"));
         }

         if (!var2.isNull("IntrLdTout")) {
            this.c(var2.getInt("IntrLdTout"));
         }

         if (!var2.isNull("MraidOnReadyVw")) {
            this.b(var2.getInt("MraidOnReadyVw"));
         }

         if (!var2.isNull("extBr")) {
            this.a(var2.getBoolean("extBr"));
         }
      }

   }

   public int a() {
      return this.e;
   }

   public void a(double var1) {
      this.c = var1;
   }

   public void a(int var1) {
      this.e = var1;
   }

   public void a(boolean var1) {
      this.h = var1;
   }

   public int b() {
      return this.g;
   }

   public void b(int var1) {
      this.g = var1;
   }

   public void b(boolean var1) {
      this.d = var1;
   }

   public int c() {
      return this.f;
   }

   public void c(int var1) {
      this.f = var1;
   }

   public int d() {
      return this.a;
   }

   public void d(int var1) {
      this.a = var1;
   }

   public int e() {
      return this.b;
   }

   public void e(int var1) {
      this.b = var1;
   }

   public double f() {
      return this.c;
   }

   public boolean g() {
      return this.h;
   }

   public boolean h() {
      return this.d;
   }
}
