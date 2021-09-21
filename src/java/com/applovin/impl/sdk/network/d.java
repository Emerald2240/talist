package com.applovin.impl.sdk.network;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
   private static final Object a = new Object();

   private static JSONObject a(String var0, Context var1) {
      JSONObject var2 = b(var1);
      if (var2 == null) {
         var2 = new JSONObject();
      }

      if (!var2.has(var0)) {
         try {
            var2.put(var0, new JSONObject());
            return var2;
         } catch (JSONException var4) {
         }
      }

      return var2;
   }

   static void a(int param0, String param1, Context param2) {
      // $FF: Couldn't be decompiled
   }

   public static void a(Context param0) {
      // $FF: Couldn't be decompiled
   }

   private static void a(JSONObject var0, Context var1) {
      com.applovin.impl.sdk.b.g.a((com.applovin.impl.sdk.b.f)com.applovin.impl.sdk.b.f.q, var0.toString(), (Context)var1);
   }

   public static JSONObject b(Context var0) {
      Object var1 = a;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label180: {
         JSONObject var2;
         label179: {
            try {
               try {
                  var2 = new JSONObject((String)com.applovin.impl.sdk.b.g.b(com.applovin.impl.sdk.b.f.q, "{}", (Context)var0));
                  break label179;
               } catch (JSONException var30) {
               }
            } catch (Throwable var31) {
               var10000 = var31;
               var10001 = false;
               break label180;
            }

            try {
               JSONObject var5 = new JSONObject();
               return var5;
            } catch (Throwable var28) {
               var10000 = var28;
               var10001 = false;
               break label180;
            }
         }

         label173:
         try {
            return var2;
         } catch (Throwable var29) {
            var10000 = var29;
            var10001 = false;
            break label173;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var27) {
            var10000 = var27;
            var10001 = false;
            continue;
         }
      }
   }
}
