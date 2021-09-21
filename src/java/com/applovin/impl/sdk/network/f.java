package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.utils.i;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class f {
   private String a;
   private String b;
   private String c;
   private Map d;
   private Map e;
   private Map f;
   private boolean g;
   private String h;
   private int i;

   private f(f.a var1) {
      this.a = UUID.randomUUID().toString();
      this.b = var1.a;
      this.c = var1.b;
      this.d = var1.c;
      this.e = var1.d;
      this.f = var1.e;
      this.g = var1.f;
      this.h = var1.g;
      this.i = 0;
   }

   // $FF: synthetic method
   f(f.a var1, Object var2) {
      this(var1);
   }

   f(JSONObject var1, j var2) throws Exception {
      String var3 = com.applovin.impl.sdk.utils.i.b(var1, "uniqueId", UUID.randomUUID().toString(), var2);
      String var4 = var1.getString("targetUrl");
      String var5 = com.applovin.impl.sdk.utils.i.b(var1, "backupUrl", "", var2);
      int var6 = var1.getInt("attemptNumber");
      Map var7;
      if (com.applovin.impl.sdk.utils.i.a(var1, "parameters")) {
         var7 = com.applovin.impl.sdk.utils.i.a(var1.getJSONObject("parameters"));
      } else {
         var7 = Collections.emptyMap();
      }

      Map var8;
      if (com.applovin.impl.sdk.utils.i.a(var1, "httpHeaders")) {
         var8 = com.applovin.impl.sdk.utils.i.a(var1.getJSONObject("httpHeaders"));
      } else {
         var8 = Collections.emptyMap();
      }

      Map var9;
      if (com.applovin.impl.sdk.utils.i.a(var1, "requestBody")) {
         var9 = com.applovin.impl.sdk.utils.i.b(var1.getJSONObject("requestBody"));
      } else {
         var9 = Collections.emptyMap();
      }

      this.a = var3;
      this.b = var4;
      this.c = var5;
      this.d = var7;
      this.e = var8;
      this.f = var9;
      this.g = var1.optBoolean("isEncodingEnabled", false);
      this.i = var6;
   }

   public static f.a l() {
      return new f.a();
   }

   String a() {
      return this.b;
   }

   String b() {
      return this.c;
   }

   Map c() {
      return this.d;
   }

   Map d() {
      return this.e;
   }

   Map e() {
      return this.f;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         f var2 = (f)var1;
         return this.a.equals(var2.a);
      } else {
         return false;
      }
   }

   boolean f() {
      return this.g;
   }

   String g() {
      return this.h;
   }

   int h() {
      return this.i;
   }

   public int hashCode() {
      return this.a.hashCode();
   }

   void i() {
      ++this.i;
   }

   void j() {
      HashMap var1 = new HashMap();
      Map var2 = this.d;
      if (var2 != null) {
         var1.putAll(var2);
      }

      var1.put("postback_ts", String.valueOf(System.currentTimeMillis()));
      this.d = var1;
   }

   JSONObject k() throws JSONException {
      JSONObject var1 = new JSONObject();
      var1.put("uniqueId", this.a);
      var1.put("targetUrl", this.b);
      var1.put("backupUrl", this.c);
      var1.put("isEncodingEnabled", this.g);
      var1.put("attemptNumber", this.i);
      Map var7 = this.d;
      if (var7 != null) {
         var1.put("parameters", new JSONObject(var7));
      }

      Map var8 = this.e;
      if (var8 != null) {
         var1.put("httpHeaders", new JSONObject(var8));
      }

      Map var9 = this.f;
      if (var9 != null) {
         var1.put("requestBody", new JSONObject(var9));
      }

      return var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("PostbackRequest{uniqueId='");
      var1.append(this.a);
      var1.append('\'');
      var1.append(", communicatorRequestId='");
      var1.append(this.h);
      var1.append('\'');
      var1.append(", targetUrl='");
      var1.append(this.b);
      var1.append('\'');
      var1.append(", backupUrl='");
      var1.append(this.c);
      var1.append('\'');
      var1.append(", attemptNumber=");
      var1.append(this.i);
      var1.append(", isEncodingEnabled=");
      var1.append(this.g);
      var1.append('}');
      return var1.toString();
   }

   public static class a {
      private String a;
      private String b;
      private Map c;
      private Map d;
      private Map e;
      private boolean f;
      private String g;

      public f.a a(String var1) {
         this.a = var1;
         return this;
      }

      public f.a a(Map var1) {
         this.c = var1;
         return this;
      }

      public f.a a(boolean var1) {
         this.f = var1;
         return this;
      }

      public f a() {
         return new f(this);
      }

      public f.a b(String var1) {
         this.b = var1;
         return this;
      }

      public f.a b(Map var1) {
         this.d = var1;
         return this;
      }

      public f.a c(String var1) {
         this.g = var1;
         return this;
      }

      public f.a c(Map var1) {
         this.e = var1;
         return this;
      }
   }
}
