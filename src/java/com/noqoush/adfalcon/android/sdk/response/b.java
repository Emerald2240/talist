package com.noqoush.adfalcon.android.sdk.response;

import org.json.JSONException;
import org.json.JSONObject;

public class b {
   public static final String c = "adChoices";
   private static final String d = "optout_url";
   private static final String e = "icon_url";
   private String a;
   private String b;

   public b(JSONObject var1) throws JSONException {
      if (var1 != null && !var1.isNull("adChoices")) {
         JSONObject var2 = var1.getJSONObject("adChoices");
         if (!var2.isNull("optout_url")) {
            this.a = var2.getString("optout_url");
         }

         if (!var2.isNull("icon_url")) {
            this.b = var2.getString("icon_url");
         }
      }

   }

   public String a() {
      return this.b;
   }

   public void a(String var1) {
      this.b = var1;
   }

   public String b() {
      return this.a;
   }

   public void b(String var1) {
      this.a = var1;
   }
}
