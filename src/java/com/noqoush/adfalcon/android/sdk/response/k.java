package com.noqoush.adfalcon.android.sdk.response;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class k {
   public static final String A = "plainhtml";
   public static final String B = "interstitial_static";
   public static final String C = "interstitial_dynamic";
   public static final String D = "slides";
   public static final String E = "content";
   public static final String F = "url";
   public static final String G = "native";
   public static final int H = 2;
   public static final int I = 1;
   public static final int J = 0;
   public static final int K = -1;
   public static final int L = 1;
   public static final int M = 0;
   public static final int N = 5000;
   private static final String O = "url";
   private static final String P = "content";
   private static final String Q = "message";
   private static final String R = "code";
   private static final String S = "pac";
   private static final String T = "responseType";
   private static final String U = "subType";
   private static final String V = "adType";
   private static final String W = "elements";
   private static final String X = "dd";
   private static final String Y = "adSize";
   private static final String Z = "slides";
   private static final String a0 = "apis";
   private static final String b0 = "adVerifications";
   public static final String w = "banner";
   public static final String x = "text";
   public static final String y = "richmedia";
   public static final String z = "native";
   public float a = 2.0F;
   public int b = 0;
   public int c = -1;
   public int d = -1;
   public boolean e = false;
   private boolean f = false;
   public String g;
   public String h;
   public String i = "display";
   public String j;
   public String k;
   public String l;
   private String m = "";
   private String n;
   public d o;
   public a p;
   public e q;
   public l r;
   private b s;
   private HashMap t;
   private Vector u = new Vector();
   private Vector v = new Vector();

   public k() {
   }

   public k(String var1) throws JSONException {
      this.a(var1);
   }

   public k(String var1, float var2) throws JSONException {
      this.a = var2;
      this.a(var1);
   }

   private void i(JSONObject var1) throws JSONException {
      this.p = new a(var1);
   }

   private void j(JSONObject var1) throws JSONException {
      this.h = var1.getString("adType");
   }

   private void k(JSONObject var1) throws JSONException {
      if (!var1.isNull("adVerifications")) {
         JSONArray var2 = var1.getJSONArray("adVerifications");

         for(int var3 = 0; var3 < var2.length(); ++var3) {
            this.v.add(new m(var2.getJSONObject(var3)));
         }

      }
   }

   private void l(JSONObject var1) throws JSONException {
      if (!var1.isNull("native")) {
         this.q = new e(var1, this.s);
      }

   }

   private void m(JSONObject var1) throws JSONException {
      if (!var1.isNull("pac")) {
         this.e = var1.getBoolean("pac");
      }

   }

   private void n(JSONObject var1) throws JSONException {
      this.j = var1.getString("responseType");
   }

   private void o(JSONObject var1) throws JSONException {
      if (!var1.isNull("subType")) {
         this.i = var1.getString("subType");
      }

   }

   public a a() {
      return this.p;
   }

   public void a(int var1) {
      this.b = var1;
   }

   public void a(String var1) throws JSONException {
      JSONObject var2 = new JSONObject(var1);
      if (!var2.isNull("code")) {
         int var3 = var2.getInt("code");
         this.a(var3);
         if (var3 != 0) {
            this.d(var2.getString("message"));
            return;
         }
      }

      this.a(var2);
      this.b(var2);
      this.j(var2);
      this.o(var2);
      this.n(var2);
      this.m(var2);
      this.d(var2);
      this.i(var2);
      this.f(var2);
      this.e(var2);
      this.g(var2);
      this.l(var2);
      this.c(var2);
      this.h(var2);
      this.k(var2);
   }

   public void a(HashMap var1) {
      this.t = var1;
   }

   public void a(JSONObject var1) throws JSONException {
      if (!var1.isNull("adChoices")) {
         this.s = new b(var1);
      }

   }

   public b b() {
      return this.s;
   }

   public void b(int var1) {
      this.d = var1;
   }

   public void b(String var1) {
      this.m = var1;
   }

   public void b(JSONObject var1) throws JSONException {
      if (!var1.isNull("adSize")) {
         JSONArray var2 = var1.getJSONArray("adSize");
         this.c(var2.getInt(0));
         this.b(var2.getInt(1));
      }

   }

   public String c() {
      return this.h;
   }

   public void c(int var1) {
      this.c = var1;
   }

   public void c(String var1) throws JSONException {
      this.k = var1;
   }

   public void c(JSONObject var1) throws JSONException {
      if (!var1.isNull("apis")) {
         JSONArray var2 = var1.getJSONArray("apis");

         for(int var3 = 0; var3 < var2.length(); ++var3) {
            this.u.add(var2.getString(var3));
         }

      }
   }

   public Vector d() {
      return this.v;
   }

   public void d(String var1) {
      this.g = var1;
   }

   public void d(JSONObject var1) throws JSONException {
      this.o = new d(var1);
   }

   public Vector e() {
      return this.u;
   }

   public void e(String var1) {
      this.n = var1;
   }

   public void e(JSONObject var1) throws JSONException {
      if (!var1.isNull("content")) {
         this.k = var1.getString("content");
      }

   }

   public String f() {
      return this.m;
   }

   public void f(String var1) throws JSONException {
      this.j = var1;
   }

   public void f(JSONObject var1) throws JSONException {
      this.r = new l(var1);
   }

   public d g() {
      return this.o;
   }

   public void g(String var1) {
      this.l = var1;
   }

   public void g(JSONObject var1) throws JSONException {
      if (!var1.isNull("url")) {
         this.l = var1.getString("url");
      }

   }

   public int h() {
      return this.b;
   }

   public void h(JSONObject var1) throws JSONException {
      if (!var1.isNull("viewability")) {
         JSONArray var2 = var1.getJSONArray("viewability");

         for(int var3 = 0; var3 < var2.length(); ++var3) {
            JSONObject var4 = var2.getJSONObject(var3);
            if (!var4.isNull("vendor") && var4.getString("vendor").equalsIgnoreCase("moat") && !var4.isNull("params")) {
               JSONObject var5 = new JSONObject(var4.getString("params"));
               JSONArray var6 = var5.names();
               this.a(new HashMap());

               for(int var7 = 0; var7 < var6.length(); ++var7) {
                  String var8 = var6.getString(var7);
                  String var9 = var5.getString(var8);
                  this.l().put(var8, var9);
               }
            }
         }
      }

   }

   public String i() {
      return this.k;
   }

   public int j() {
      return this.d;
   }

   public String k() {
      return this.g;
   }

   public HashMap l() {
      if (this.t == null) {
         Vector var1 = this.v;
         if (var1 != null) {
            Iterator var2 = var1.iterator();

            while(var2.hasNext()) {
               m var3 = (m)var2.next();
               if (var3.a().equalsIgnoreCase("moat")) {
                  return var3.b();
               }
            }
         }
      }

      return this.t;
   }

   public e m() {
      return this.q;
   }

   public String n() {
      return this.n;
   }

   public boolean o() {
      return this.e;
   }

   public String p() {
      return this.j;
   }

   public l q() {
      return this.r;
   }

   public String r() {
      return this.i;
   }

   public String s() {
      return this.l;
   }

   public int t() {
      return this.c;
   }

   public boolean u() {
      if (this.i() != null) {
         if (this.i().toLowerCase().contains("mraid.js")) {
            this.f = true;
         } else {
            this.f = false;
         }
      } else {
         this.f = false;
      }

      return this.f;
   }
}
