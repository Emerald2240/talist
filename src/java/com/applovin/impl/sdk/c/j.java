package com.applovin.impl.sdk.c;

import android.text.TextUtils;
import com.applovin.impl.sdk.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j {
   private final com.applovin.impl.sdk.j a;
   private final p b;
   private final Object c = new Object();
   private final Map d = new HashMap();

   public j(com.applovin.impl.sdk.j var1) {
      this.a = var1;
      this.b = var1.v();
      this.c();
   }

   private j.b b(i var1) {
      Object var2 = this.c;
      synchronized(var2){}

      boolean var10001;
      Throwable var10000;
      label176: {
         j.b var5;
         String var4;
         try {
            var4 = var1.a();
            var5 = (j.b)this.d.get(var4);
         } catch (Throwable var27) {
            var10000 = var27;
            var10001 = false;
            break label176;
         }

         if (var5 == null) {
            try {
               var5 = new j.b(var4);
               this.d.put(var4, var5);
            } catch (Throwable var26) {
               var10000 = var26;
               var10001 = false;
               break label176;
            }
         }

         label165:
         try {
            return var5;
         } catch (Throwable var25) {
            var10000 = var25;
            var10001 = false;
            break label165;
         }
      }

      while(true) {
         Throwable var3 = var10000;

         try {
            throw var3;
         } catch (Throwable var24) {
            var10000 = var24;
            var10001 = false;
            continue;
         }
      }
   }

   private void c() {
      // $FF: Couldn't be decompiled
   }

   private void d() {
      // $FF: Couldn't be decompiled
   }

   public JSONArray a() {
      // $FF: Couldn't be decompiled
   }

   public void a(i var1) {
      this.a(var1, false, 0L);
   }

   public void a(i param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   public void a(i var1, boolean var2, long var3) {
      if (var1 == null) {
         throw new IllegalArgumentException("No key specified");
      } else if ((Boolean)this.a.a(com.applovin.impl.sdk.b.d.eD)) {
         Object var5 = this.c;
         synchronized(var5){}

         boolean var10001;
         Throwable var10000;
         label221: {
            j.b var7;
            try {
               var7 = this.b(var1);
               var7.b();
            } catch (Throwable var28) {
               var10000 = var28;
               var10001 = false;
               break label221;
            }

            if (var2) {
               try {
                  var7.a(var3);
               } catch (Throwable var27) {
                  var10000 = var27;
                  var10001 = false;
                  break label221;
               }
            }

            label206:
            try {
               this.d();
               return;
            } catch (Throwable var26) {
               var10000 = var26;
               var10001 = false;
               break label206;
            }
         }

         while(true) {
            Throwable var6 = var10000;

            try {
               throw var6;
            } catch (Throwable var25) {
               var10000 = var25;
               var10001 = false;
               continue;
            }
         }
      }
   }

   public void b() {
      // $FF: Couldn't be decompiled
   }

   private static class a {
      static final String a = a("tk");
      static final String b = a("tc");
      static final String c = a("ec");
      static final String d = a("dm");
      static final String e = a("dv");
      static final String f = a("dh");
      static final String g = a("dl");
      private static final Set h = new HashSet(7);

      private static String a(String var0) {
         if (!TextUtils.isEmpty(var0)) {
            if (!h.contains(var0)) {
               h.add(var0);
               return var0;
            } else {
               StringBuilder var1 = new StringBuilder();
               var1.append("Key has already been used: ");
               var1.append(var0);
               throw new IllegalArgumentException(var1.toString());
            }
         } else {
            throw new IllegalArgumentException("No key name specified");
         }
      }
   }

   private static class b {
      private final String a;
      private int b = 0;
      private int c = 0;
      private double d = 0.0D;
      private double e = 0.0D;
      private Long f = null;
      private Long g = null;

      b(String var1) {
         this.a = var1;
      }

      b(JSONObject var1) throws JSONException {
         this.a = var1.getString(j.a.a);
         this.b = var1.getInt(j.a.b);
         this.c = var1.getInt(j.a.c);
         this.d = var1.getDouble(j.a.d);
         this.e = var1.getDouble(j.a.e);
         this.f = var1.optLong(j.a.f);
         this.g = var1.optLong(j.a.g);
      }

      String a() {
         return this.a;
      }

      void a(long var1) {
         int var3 = this.b;
         double var4 = this.d;
         double var6 = this.e;
         this.b = var3 + 1;
         double var8 = (double)var3;
         Double.isNaN(var8);
         double var11 = var4 * var8;
         double var13 = (double)var1;
         Double.isNaN(var13);
         double var16 = var11 + var13;
         int var18 = this.b;
         double var19 = (double)var18;
         Double.isNaN(var19);
         this.d = var16 / var19;
         double var22 = (double)var18;
         Double.isNaN(var8);
         Double.isNaN(var22);
         double var26 = var8 / var22;
         Double.isNaN(var13);
         double var29 = Math.pow(var4 - var13, 2.0D);
         double var31 = (double)this.b;
         Double.isNaN(var31);
         this.e = var26 * (var6 + var29 / var31);
         Long var34 = this.f;
         if (var34 == null || var1 > var34) {
            this.f = var1;
         }

         Long var35 = this.g;
         if (var35 == null || var1 < var35) {
            this.g = var1;
         }

      }

      void b() {
         ++this.c;
      }

      JSONObject c() throws JSONException {
         JSONObject var1 = new JSONObject();
         var1.put(j.a.a, this.a);
         var1.put(j.a.b, this.b);
         var1.put(j.a.c, this.c);
         var1.put(j.a.d, this.d);
         var1.put(j.a.e, this.e);
         var1.put(j.a.f, this.f);
         var1.put(j.a.g, this.g);
         return var1;
      }

      public String toString() {
         try {
            StringBuilder var1 = new StringBuilder();
            var1.append("TaskStats{n='");
            var1.append(this.a);
            var1.append('\'');
            var1.append(", stats=");
            var1.append(this.c().toString());
            var1.append('}');
            String var16 = var1.toString();
            return var16;
         } catch (JSONException var17) {
            StringBuilder var3 = new StringBuilder();
            var3.append("TaskStats{n='");
            var3.append(this.a);
            var3.append('\'');
            var3.append(", count=");
            var3.append(this.b);
            var3.append('}');
            return var3.toString();
         }
      }
   }
}
