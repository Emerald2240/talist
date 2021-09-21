package com.noqoush.adfalcon.android.sdk.response;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class m {
   private String a;
   private String b;
   private HashMap c;

   public m(JSONObject var1) {
      Exception var10000;
      label39: {
         boolean var10001;
         String var3;
         try {
            this.b(var1.getString("vendor"));
            this.a(var1.getString("apiFramework"));
            var3 = var1.getString("customData");
         } catch (Exception var9) {
            var10000 = var9;
            var10001 = false;
            break label39;
         }

         if (var3 == null) {
            return;
         }

         Iterator var5;
         JSONObject var4;
         try {
            var4 = new JSONObject(var3);
            var5 = var4.keys();
         } catch (Exception var8) {
            var10000 = var8;
            var10001 = false;
            break label39;
         }

         while(true) {
            try {
               if (!var5.hasNext()) {
                  return;
               }

               String var6 = (String)var5.next();
               this.a(var6, var4.getString(var6));
            } catch (Exception var7) {
               var10000 = var7;
               var10001 = false;
               break;
            }
         }
      }

      Exception var2 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var2);
   }

   public String a() {
      return this.b;
   }

   public void a(String var1) {
      this.b = var1;
   }

   public void a(String var1, String var2) {
      this.b().put(var1, var2);
   }

   public HashMap b() {
      if (this.c == null) {
         this.c = new HashMap();
      }

      return this.c;
   }

   public void b(String var1) {
      this.a = var1;
   }

   public String c() {
      return (String)this.b().get("params");
   }

   public String d() {
      return (String)this.b().get("url");
   }

   public String e() {
      return this.a;
   }
}
