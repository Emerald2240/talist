package com.noqoush.adfalcon.android.sdk.video.vast.model;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public abstract class g {
   private String a;
   private int b;

   public int a(String var1) {
      if (var1 != null) {
         if (var1.length() == 0) {
            return 0;
         } else {
            int var4;
            int var5;
            int var6;
            try {
               String[] var3 = var1.split(":");
               var4 = com.noqoush.adfalcon.android.sdk.util.d.b(var3[0]);
               var5 = com.noqoush.adfalcon.android.sdk.util.d.b(var3[1]);
               var6 = com.noqoush.adfalcon.android.sdk.util.d.b(var3[2]);
            } catch (Exception var7) {
               return 0;
            }

            return var6 + var4 * 3600 + var5 * 60;
         }
      } else {
         return 0;
      }
   }

   public String a() {
      return this.a;
   }

   public void a(int var1) {
      this.b = var1;
   }

   public void a(XmlPullParser var1) throws XmlPullParserException, IOException {
      String var2 = var1.getAttributeValue((String)null, "id");
      if (var2 != null) {
         this.b(var2);
      }

      String var3 = var1.getAttributeValue((String)null, "sequence");
      if (var3 != null) {
         this.a(com.noqoush.adfalcon.android.sdk.util.d.b(var3));
      }

   }

   public int b() {
      return this.b;
   }

   public void b(String var1) {
      this.a = var1;
   }
}
