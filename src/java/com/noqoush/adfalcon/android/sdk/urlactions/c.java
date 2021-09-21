package com.noqoush.adfalcon.android.sdk.urlactions;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public class c extends b {
   private List g(String var1) throws UnsupportedEncodingException, JSONException {
      if (var1 != null && var1.length() != 0) {
         ArrayList var2 = new ArrayList();
         String[] var3 = URLDecoder.decode(var1, "UTF-8").split(",");

         for(int var4 = 0; var4 < var3.length; ++var4) {
            var2.add(var3[var4]);
         }

         return var2;
      } else {
         return null;
      }
   }

   public boolean a(e var1) {
      return this.c(var1.b());
   }

   public boolean b(e var1) throws Exception {
      Exception var10000;
      label67: {
         com.noqoush.adfalcon.android.sdk.handler.c var8;
         String var5;
         boolean var10001;
         String var4;
         String var6;
         String var7;
         try {
            Uri var3 = this.a(var1.b());
            var4 = var3.getQueryParameter("primaryUrl");
            var5 = var3.getQueryParameter("primaryTrackingUrls");
            var6 = var3.getQueryParameter("fallbackUrl");
            var7 = var3.getQueryParameter("fallbackTrackingUrls");
            var8 = new com.noqoush.adfalcon.android.sdk.handler.c(true, true, true, true, true, true, false);
         } catch (Exception var21) {
            var10000 = var21;
            var10001 = false;
            break label67;
         }

         if (var4 == null) {
            return false;
         }

         com.noqoush.adfalcon.android.sdk.handler.c var10;
         label57: {
            Exception var9;
            label68: {
               List var15;
               try {
                  String var14 = URLDecoder.decode(var4, "UTF-8");
                  var15 = this.g(var5);
                  var1.a(var14);
                  var1.a(false);
               } catch (Exception var20) {
                  var9 = var20;
                  var10 = var8;
                  break label68;
               }

               var10 = var8;

               try {
                  if (var10.a(var1)) {
                     l.a(var1, var15);
                     return true;
                  }
                  break label57;
               } catch (Exception var19) {
                  var9 = var19;
               }
            }

            try {
               com.noqoush.adfalcon.android.sdk.util.a.a(var9);
            } catch (Exception var18) {
               var10000 = var18;
               var10001 = false;
               break label67;
            }
         }

         if (var6 == null) {
            return false;
         }

         try {
            String var12 = URLDecoder.decode(var6, "UTF-8");
            List var13 = this.g(var7);
            var1.a(var12);
            var1.a(false);
            if (var10.a(var1)) {
               l.a(var1, var13);
               return true;
            }

            return false;
         } catch (Exception var17) {
            Exception var11 = var17;

            try {
               com.noqoush.adfalcon.android.sdk.util.a.a(var11);
               return false;
            } catch (Exception var16) {
               var10000 = var16;
               var10001 = false;
            }
         }
      }

      Exception var2 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      return false;
   }
}
