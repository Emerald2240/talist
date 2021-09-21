package com.applovin.impl.sdk.d;

import java.util.Collections;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ae extends ab {
   protected ae(String var1, com.applovin.impl.sdk.j var2) {
      super(var1, var2);
   }

   // $FF: synthetic method
   static void a(ae var0, JSONObject var1) {
      var0.b(var1);
   }

   private void b(JSONObject var1) {
      com.applovin.impl.sdk.a.c var2 = this.c(var1);
      if (var2 != null) {
         this.a(var2);
      }
   }

   private com.applovin.impl.sdk.a.c c(JSONObject var1) {
      JSONException var10000;
      label99: {
         boolean var10001;
         JSONObject var3;
         try {
            var3 = com.applovin.impl.sdk.utils.h.a(var1);
            com.applovin.impl.sdk.utils.h.d(var3, this.b);
            com.applovin.impl.sdk.utils.h.c(var1, this.b);
         } catch (JSONException var24) {
            var10000 = var24;
            var10001 = false;
            break label99;
         }

         boolean var19 = false;

         Map var5;
         try {
            var19 = true;
            var5 = com.applovin.impl.sdk.utils.i.a((JSONObject)var3.get("params"));
            var19 = false;
         } finally {
            if (var19) {
               label89:
               try {
                  var5 = Collections.emptyMap();
                  break label89;
               } catch (JSONException var22) {
                  var10000 = var22;
                  var10001 = false;
                  break label99;
               }
            }
         }

         String var7;
         try {
            var7 = var3.getString("result");
         } finally {
            ;
         }

         try {
            com.applovin.impl.sdk.a.c var8 = com.applovin.impl.sdk.a.c.a(var7, var5);
            return var8;
         } catch (JSONException var21) {
            var10000 = var21;
            var10001 = false;
         }
      }

      JSONException var2 = var10000;
      this.a("Unable to parse API response", var2);
      return null;
   }

   protected abstract void a(com.applovin.impl.sdk.a.c var1);

   protected abstract boolean c();

   public void run() {
      this.a(this.i(), new ae$1(this));
   }
}
