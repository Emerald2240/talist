package com.applovin.impl.sdk.ad;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.n;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
   private final com.applovin.impl.sdk.j a;
   private final String b;

   public c(String var1, com.applovin.impl.sdk.j var2) {
      if (!TextUtils.isEmpty(var1)) {
         if (var2 != null) {
            this.b = var1;
            this.a = var2;
         } else {
            throw new IllegalArgumentException("No sdk specified");
         }
      } else {
         throw new IllegalArgumentException("Identifier is empty");
      }
   }

   private String a(com.applovin.impl.sdk.b.d var1) {
      Iterator var2 = this.a.b(var1).iterator();

      String var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (String)var2.next();
      } while(!this.b.startsWith(var3));

      return var3;
   }

   public String a() {
      return this.b;
   }

   public c.a b() {
      if (this.a(com.applovin.impl.sdk.b.d.aT) != null) {
         return c.a.b;
      } else {
         return this.a(com.applovin.impl.sdk.b.d.aU) != null ? c.a.c : c.a.a;
      }
   }

   public String c() {
      String var1 = this.a(com.applovin.impl.sdk.b.d.aT);
      if (!TextUtils.isEmpty(var1)) {
         return var1;
      } else {
         String var2 = this.a(com.applovin.impl.sdk.b.d.aU);
         return !TextUtils.isEmpty(var2) ? var2 : null;
      }
   }

   public JSONObject d() {
      if (this.b() == c.a.c) {
         try {
            int var7 = this.c().length();
            String var8 = new String(Base64.decode(this.b.substring(var7), 0), "UTF-8");

            try {
               JSONObject var9 = new JSONObject(var8);
               p var16 = this.a.v();
               StringBuilder var17 = new StringBuilder();
               var17.append("Decoded token into ad response: ");
               var17.append(var9);
               var16.b("AdToken", var17.toString());
               return var9;
            } catch (JSONException var20) {
               p var11 = this.a.v();
               StringBuilder var12 = new StringBuilder();
               var12.append("Unable to decode token '");
               var12.append(this.b);
               var12.append("' into JSON");
               var11.b("AdToken", var12.toString(), var20);
            }
         } catch (Throwable var21) {
            p var2 = this.a.v();
            StringBuilder var3 = new StringBuilder();
            var3.append("Unable to process ad response from token '");
            var3.append(this.b);
            var3.append("'");
            var2.b("AdToken", var3.toString(), var21);
            return null;
         }
      }

      return null;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof c)) {
         return false;
      } else {
         c var2 = (c)var1;
         String var3 = this.b;
         String var4 = var2.b;
         if (var3 != null) {
            return var3.equals(var4);
         } else {
            return var4 == null;
         }
      }
   }

   public int hashCode() {
      String var1 = this.b;
      return var1 != null ? var1.hashCode() : 0;
   }

   public String toString() {
      String var1 = n.a(32, this.b);
      StringBuilder var2 = new StringBuilder();
      var2.append("AdToken{id=");
      var2.append(var1);
      var2.append(", type=");
      var2.append(this.b());
      var2.append('}');
      return var2.toString();
   }

   public static enum a {
      a("UNSPECIFIED"),
      b("REGULAR"),
      c("AD_RESPONSE_JSON");

      private final String d;

      static {
         c.a[] var0 = new c.a[]{a, b, c};
      }

      private a(String var3) {
         this.d = var3;
      }

      public String toString() {
         return this.d;
      }
   }
}
