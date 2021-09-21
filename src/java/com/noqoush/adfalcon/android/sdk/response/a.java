package com.noqoush.adfalcon.android.sdk.response;

import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
   private static final String g = "trackers";
   private static final String h = "action_custom_data";
   private static final String i = "actionInfo_url";
   private static final String j = "action_url";
   private static final String k = "type";
   private static final String l = "adAction";
   public static final String m = "custom";
   public static final String n = "app";
   public static final String o = "url";
   public static final String p = "call";
   public static final String q = "sms";
   public static final String r = "video";
   public static final String s = "audio";
   public static final String t = "loc";
   public static final String u = "canvas";
   private String a;
   private String b;
   private String c;
   private String d;
   private String e;
   private Vector f = new Vector();

   public a(JSONObject var1) throws JSONException {
      if (!var1.isNull("adAction")) {
         JSONObject var2 = var1.getJSONObject("adAction");
         this.f(var2);
         String var3 = this.a;
         if (var3 != null && var3.equalsIgnoreCase("custom")) {
            this.d(var2);
         } else {
            this.e(var2);
            this.c(var2);
         }

         this.b(var2);
         this.a(var2);
      }
   }

   private void c(JSONObject var1) throws JSONException {
      if (!var1.isNull("actionInfo_url")) {
         this.c = var1.getString("actionInfo_url");
      }
   }

   private void d(JSONObject var1) throws JSONException {
      if (!var1.isNull("action_custom_data")) {
         this.d = var1.getString("action_custom_data");
      }
   }

   private void e(JSONObject var1) throws JSONException {
      if (!var1.isNull("action_url")) {
         this.b = var1.getString("action_url");
      }
   }

   private void f(JSONObject var1) throws JSONException {
      if (!var1.isNull("type")) {
         this.a = var1.getString("type");
      }
   }

   public String a() {
      return this.c;
   }

   public void a(JSONObject var1) throws JSONException {
      if (!var1.isNull("fallback_action_url")) {
         this.e = var1.getString("fallback_action_url");
      }

   }

   public String b() {
      return this.d;
   }

   public void b(JSONObject var1) throws JSONException {
      if (!var1.isNull("trackers")) {
         JSONArray var2 = var1.getJSONArray("trackers");

         for(int var3 = 0; var3 < var2.length(); ++var3) {
            String var4 = var2.getString(var3);
            this.f.add(var4);
         }

      }
   }

   public String c() {
      return this.b;
   }

   public String d() {
      return this.e;
   }

   public Vector e() {
      return this.f;
   }

   public String f() {
      return this.a;
   }
}
