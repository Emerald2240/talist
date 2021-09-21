package com.applovin.impl.sdk.c;

import android.text.TextUtils;
import com.applovin.impl.sdk.p;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f {
   private final List a;
   private final Object b = new Object();
   private final com.applovin.impl.sdk.j c;
   private final p d;

   public f(com.applovin.impl.sdk.j var1) {
      this.c = var1;
      this.d = var1.v();
      this.a = new ArrayList();
   }

   private void d() {
      // $FF: Couldn't be decompiled
   }

   public JSONArray a() {
      // $FF: Couldn't be decompiled
   }

   public void a(String var1, Throwable var2) {
      if (!TextUtils.isEmpty(var1)) {
         Object var3 = this.b;
         synchronized(var3){}

         boolean var10001;
         Throwable var10000;
         label137: {
            try {
               if (this.a.size() >= (Integer)this.c.a(com.applovin.impl.sdk.b.d.eF)) {
                  return;
               }
            } catch (Throwable var19) {
               var10000 = var19;
               var10001 = false;
               break label137;
            }

            label131:
            try {
               f.a var5 = new f.a(var1, var2);
               this.a.add(var5);
               this.d();
               return;
            } catch (Throwable var18) {
               var10000 = var18;
               var10001 = false;
               break label131;
            }
         }

         while(true) {
            Throwable var4 = var10000;

            try {
               throw var4;
            } catch (Throwable var17) {
               var10000 = var17;
               var10001 = false;
               continue;
            }
         }
      }
   }

   public void b() {
      // $FF: Couldn't be decompiled
   }

   public void c() {
      // $FF: Couldn't be decompiled
   }

   private static class a {
      private final Long a;
      private final String b;
      private final String c;
      private final String d;

      private a(String var1, Throwable var2) {
         this.b = var1;
         this.a = System.currentTimeMillis();
         String var3;
         if (var2 != null) {
            var3 = var2.getClass().getName();
         } else {
            var3 = null;
         }

         this.c = var3;
         String var4 = null;
         if (var2 != null) {
            var4 = var2.getMessage();
         }

         this.d = var4;
      }

      // $FF: synthetic method
      a(String var1, Throwable var2, Object var3) {
         this(var1, var2);
      }

      private a(JSONObject var1) throws JSONException {
         this.b = var1.getString("ms");
         this.a = var1.getLong("ts");
         JSONObject var2 = var1.optJSONObject("ex");
         String var3;
         if (var2 != null) {
            var3 = var2.getString("nm");
         } else {
            var3 = null;
         }

         this.c = var3;
         String var4 = null;
         if (var2 != null) {
            var4 = var2.getString("rn");
         }

         this.d = var4;
      }

      // $FF: synthetic method
      a(JSONObject var1, Object var2) throws JSONException {
         this(var1);
      }

      private JSONObject a() throws JSONException {
         JSONObject var1 = new JSONObject();
         var1.put("ms", this.b);
         var1.put("ts", this.a);
         if (!TextUtils.isEmpty(this.c)) {
            JSONObject var4 = new JSONObject();
            var4.put("nm", this.c);
            if (!TextUtils.isEmpty(this.d)) {
               var4.put("rn", this.d);
            }

            var1.put("ex", var4);
         }

         return var1;
      }

      // $FF: synthetic method
      static JSONObject a(f.a var0) throws JSONException {
         return var0.a();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("ErrorLog{timestampMillis=");
         var1.append(this.a);
         var1.append(",message='");
         var1.append(this.b);
         var1.append('\'');
         var1.append(",throwableName='");
         var1.append(this.c);
         var1.append('\'');
         var1.append(",throwableReason='");
         var1.append(this.d);
         var1.append('\'');
         var1.append('}');
         return var1.toString();
      }
   }
}
