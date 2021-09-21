package com.noqoush.adfalcon.android.sdk.conn;

import android.content.Context;
import android.os.Build;
import android.view.View;
import com.noqoush.adfalcon.android.sdk.ADFTargetingParams;
import com.noqoush.adfalcon.android.sdk.g;
import com.noqoush.adfalcon.android.sdk.constant.ADFAdSize;
import com.noqoush.adfalcon.android.sdk.nativead.assets.ADFAssetsBinder;
import com.noqoush.adfalcon.android.sdk.util.d;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;

public class c {
   private static final int e = 5000;
   private static final int f = 5000;
   static final String g = "http://api.adfalcon.com/AdRequest/GetAd";
   String a = "http://api.adfalcon.com/AdRequest/GetAd";
   String b = null;
   String c;
   private Hashtable d = new Hashtable();

   public c() {
      this.a = "http://api.adfalcon.com/AdRequest/GetAd";
      this.b = null;
   }

   public c a(Context var1) {
      this.b("R_SessionId", com.noqoush.adfalcon.android.sdk.util.c.d(var1));
      StringBuilder var2 = new StringBuilder();
      var2.append("");
      var2.append(com.noqoush.adfalcon.android.sdk.util.c.c(var1));
      this.b("R_SessionSeq", var2.toString());
      return this;
   }

   public c a(Context var1, g var2) throws Exception {
      Hashtable var3 = var2.a(var1, (View)null);
      this.c = var2.w();
      Iterator var4 = var3.keySet().iterator();

      while(var4.hasNext()) {
         String var5 = (String)var4.next();
         this.b(var5, (String)var3.get(var5));
      }

      return this;
   }

   public c a(ADFTargetingParams var1) throws Exception {
      if (var1 == null) {
         com.noqoush.adfalcon.android.sdk.util.d.a();
         return this;
      } else {
         Hashtable var2 = var1.toHashtable();
         if (var1 != null && var1.getAdditionalInfo() != null && var1.getAdditionalInfo().containsKey("R_URL")) {
            this.a = (String)var1.getAdditionalInfo().get("R_URL");
         }

         if (var1 != null && var1.getAdditionalInfo() != null && var1.getAdditionalInfo().containsKey("R_URL") && var1.getAdditionalInfo().containsKey("X-Forwarded-For")) {
            this.b = (String)var1.getAdditionalInfo().get("X-Forwarded-For");
         }

         if (var2 != null) {
            Iterator var5 = var2.keySet().iterator();

            while(var5.hasNext()) {
               String var6 = (String)var5.next();
               if (!var6.equalsIgnoreCase("content") && !var6.equalsIgnoreCase("json") && !var6.equalsIgnoreCase("R_URL") && !var6.equalsIgnoreCase("X-Forwarded-For")) {
                  this.b(var6, (String)var2.get(var6));
               }
            }
         }

         if (Build.FINGERPRINT.contains("generic")) {
            this.b(true);
            return this;
         } else if (var1.isTestDevice((Context)null)) {
            this.b(true);
            return this;
         } else {
            com.noqoush.adfalcon.android.sdk.util.d.a();
            return this;
         }
      }
   }

   public c a(ADFAdSize var1) {
      String var2;
      if (var1 == ADFAdSize.AD_UNIT_320x50) {
         var2 = "10";
      } else if (var1 == ADFAdSize.AD_UNIT_468x60) {
         var2 = "6";
      } else if (var1 == ADFAdSize.AD_UNIT_728x90) {
         var2 = "7";
      } else if (var1 == ADFAdSize.AD_UNIT_300x250) {
         var2 = "8";
      } else if (var1 == ADFAdSize.AD_UNIT_120x600) {
         var2 = "9";
      } else if (var1 == ADFAdSize.AD_UNIT_AUTO_BANNER) {
         var2 = null;
      } else {
         var2 = "";
      }

      if (var2 != null) {
         this.b("R_AS", var2);
      }

      return this;
   }

   public c a(com.noqoush.adfalcon.android.sdk.constant.a var1) {
      String var2;
      if (var1 == com.noqoush.adfalcon.android.sdk.constant.a.c) {
         var2 = "11";
      } else if (var1 == com.noqoush.adfalcon.android.sdk.constant.a.d) {
         var2 = "12";
      } else if (var1 == com.noqoush.adfalcon.android.sdk.constant.a.b) {
         var2 = "8";
      } else {
         var2 = "13";
      }

      this.b("R_AS", var2);
      return this;
   }

   public c a(ADFAssetsBinder var1) {
      com.noqoush.adfalcon.android.sdk.util.a.a("From ADFHttpConnection Class");
      Iterator var2 = var1.getAssets().values().iterator();

      while(var2.hasNext()) {
         ((com.noqoush.adfalcon.android.sdk.nativead.assets.a)var2.next()).a(this);
      }

      return this;
   }

   public c a(String var1) {
      this.b("R_AdType", var1);
      return this;
   }

   public c a(boolean var1) {
      this.b("R_STG", Boolean.toString(var1));
      return this;
   }

   public HttpURLConnection a() throws Exception {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.d.keySet().iterator();

      while(var2.hasNext()) {
         String var16 = (String)var2.next();
         String var17 = (String)this.d.get(var16);
         if (var1.length() != 0) {
            var1.append("&");
         }

         StringBuilder var18 = new StringBuilder();
         var18.append(var16);
         var18.append("=");
         var18.append(URLEncoder.encode(var17, "utf-8"));
         var1.append(var18.toString());
      }

      StringBuilder var3 = new StringBuilder();
      var3.append(this.a);
      String var8;
      if (var1.length() > 0) {
         StringBuilder var5 = new StringBuilder();
         var5.append("?");
         var5.append(var1.toString());
         var8 = var5.toString();
      } else {
         var8 = "";
      }

      var3.append(var8);
      String var10 = var3.toString();
      com.noqoush.adfalcon.android.sdk.util.a.a(var10);
      String var11 = this.c;
      if (var11 != null) {
         System.setProperty("http.agent", var11);
      }

      HttpURLConnection var12 = (HttpURLConnection)(new URL(var10)).openConnection();
      var12.setReadTimeout(5000);
      var12.setConnectTimeout(5000);
      var12.setRequestMethod("GET");
      String var13 = this.b;
      if (var13 != null) {
         var12.setRequestProperty("X-Forwarded-For", var13);
      }

      String var14 = this.c;
      if (var14 != null) {
         var12.setRequestProperty("User-Agent", var14);
      }

      return var12;
   }

   public void a(String var1, String var2) {
      String var7;
      if (this.d.containsKey(var1)) {
         StringBuilder var3 = new StringBuilder();
         var3.append((String)this.d.get(var1));
         var3.append(",");
         var3.append(var2);
         var7 = var3.toString();
      } else {
         var7 = var2;
      }

      if (var1 != null && var2 != null) {
         this.d.put(var1, var7);
      } else {
         StringBuilder var8 = new StringBuilder();
         var8.append("parameter (");
         var8.append(var1);
         var8.append(") has null value");
         com.noqoush.adfalcon.android.sdk.util.a.e(var8.toString());
      }
   }

   public c b() {
      StringBuilder var1 = new StringBuilder();
      var1.append("");
      var1.append((new Date()).getTime());
      this.b("dateTime", var1.toString());
      return this;
   }

   public c b(Context var1) {
      String var2 = var1.getPackageName();
      String var3 = com.noqoush.adfalcon.android.sdk.util.d.c(var2.replace(var2.substring(var2.lastIndexOf(".")), ""));
      StringBuilder var4 = new StringBuilder();
      var4.append("");
      var4.append(var3);
      this.b("D_UID_IDV", var4.toString());
      return this;
   }

   public c b(String var1) {
      this.b("R_F", var1);
      return this;
   }

   public c b(boolean var1) {
      this.b("R_TM", Boolean.toString(var1));
      return this;
   }

   public void b(String var1, String var2) {
      if (this.d.containsKey(var1)) {
         StringBuilder var3 = new StringBuilder();
         var3.append("parameter (");
         var3.append(var1);
         var3.append(") is already added");
         com.noqoush.adfalcon.android.sdk.util.a.e(var3.toString());
         this.d.remove(var1);
      }

      if (var1 != null && var2 != null) {
         this.d.put(var1, var2);
      } else {
         StringBuilder var8 = new StringBuilder();
         var8.append("parameter (");
         var8.append(var1);
         var8.append(") has null value");
         com.noqoush.adfalcon.android.sdk.util.a.e(var8.toString());
      }
   }

   public c c() {
      this.b("R_STG", "true");
      return this;
   }

   public c c(String var1) {
      this.b("R_Protocol", var1);
      return this;
   }

   public c d() {
      this.b("R_V", "sdk-a-5.2.0");
      return this;
   }

   public c d(String var1) {
      this.b("R_SID", var1);
      return this;
   }

   public c e() {
      return this;
   }

   public c e(String var1) {
      this.a = var1;
      return this;
   }

   public c f(String var1) {
      this.c = var1;
      return this;
   }
}
