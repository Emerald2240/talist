package com.noqoush.adfalcon.android.sdk.response;

import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
   private static final String b = "beacons";
   private static final String c = "beacon_url";
   private Vector a = new Vector();

   public d(JSONObject var1) throws JSONException {
      if (!var1.isNull("beacon_url")) {
         String var5 = var1.getString("beacon_url");
         this.a.add(new c(var5));
      } else {
         if (!var1.isNull("beacons")) {
            JSONArray var2 = var1.getJSONArray("beacons");

            for(int var3 = 0; var3 < var2.length(); ++var3) {
               this.a.add(new c(var2.getString(var3)));
            }
         }

      }
   }

   public Vector a() {
      return this.a;
   }
}
