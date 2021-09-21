package com.noqoush.adfalcon.android.sdk.video.vast.model;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class q extends g {
   private String c;
   private int d;

   public void a(XmlPullParser var1) throws XmlPullParserException, IOException {
      super.a(var1);

      for(int var2 = var1.getEventType(); var2 != 1; var2 = var1.next()) {
         String var3 = var1.getName();
         if (var2 != 2) {
            if (var2 == 3 && var3 != null && var3.equalsIgnoreCase("rewarditem")) {
               return;
            }
         } else if (var3 != null) {
            if (var3.equalsIgnoreCase("name")) {
               this.c(var1.nextText().trim());
            } else if (var3.equalsIgnoreCase("amount")) {
               this.b(Integer.parseInt(var1.nextText()));
            }
         }
      }

   }

   public void b(int var1) {
      this.d = var1;
   }

   public int c() {
      return this.d;
   }

   public void c(String var1) {
      this.c = var1;
   }

   public String d() {
      return this.c;
   }
}
