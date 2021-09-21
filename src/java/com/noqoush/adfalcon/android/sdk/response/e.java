package com.noqoush.adfalcon.android.sdk.response;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
   private static final String b = "h";
   private static final String c = "w";
   private static final String d = "value";
   private static final String e = "type";
   private static final String f = "url";
   private static final String g = "text";
   private static final String h = "content";
   private static final String i = "xhtml";
   private static final String j = "data";
   private static final String k = "img";
   private static final String l = "title";
   private static final String m = "assets";
   private static final String n = "native";
   private ArrayList a = new ArrayList();

   public e(JSONObject var1, b var2) throws JSONException {
      JSONArray var3 = var1.getJSONObject("native").getJSONArray("assets");
      if (var3 != null) {
         if (var3.length() == 0) {
            return;
         }

         for(int var4 = 0; var4 < var3.length(); ++var4) {
            JSONObject var5 = var3.getJSONObject(var4);
            if (!var5.isNull("title")) {
               this.c(var5);
            } else if (!var5.isNull("img")) {
               this.b(var5);
            } else if (!var5.isNull("data")) {
               this.a(var5);
            } else if (!var5.isNull("xhtml")) {
               this.d(var5);
            }
         }

         if (var2 != null) {
            this.a(var2);
         }
      }

   }

   private void a(b var1) throws JSONException {
      h var2 = new h();
      var2.a(var1);
      this.a.add(var2);
   }

   private void a(JSONObject var1) throws JSONException {
      JSONObject var2 = var1.getJSONObject("data");
      g var3 = new g();
      var3.a(var2.getInt("type"));
      var3.a(var2.getString("value"));
      this.a.add(var3);
   }

   private void b(JSONObject var1) throws JSONException {
      JSONObject var2 = var1.getJSONObject("img");
      h var3 = new h();
      var3.a(var2.getString("url"));
      var3.b(var2.getInt("type"));
      if (!var2.isNull("w")) {
         var3.c(var2.getInt("w"));
      }

      if (!var2.isNull("h")) {
         var3.a(var2.getInt("h"));
      }

      this.a.add(var3);
   }

   private void c(JSONObject var1) throws JSONException {
      JSONObject var2 = var1.getJSONObject("title");
      i var3 = new i();
      var3.a(var2.getString("text"));
      this.a.add(var3);
   }

   private void d(JSONObject var1) throws JSONException {
      JSONObject var2 = var1.getJSONObject("xhtml");
      j var3 = new j();
      var3.a(var2.getString("content"));
      this.a.add(var3);
   }

   public ArrayList a() {
      return this.a;
   }
}
