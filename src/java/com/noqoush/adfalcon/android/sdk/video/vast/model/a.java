package com.noqoush.adfalcon.android.sdk.video.vast.model;

import java.io.IOException;
import java.io.Serializable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a extends g implements Serializable {
   private k c;
   private y d;

   public void a(k var1) {
      this.c = var1;
   }

   public void a(y var1) {
      this.d = var1;
   }

   public void a(XmlPullParser var1) throws XmlPullParserException, IOException {
      super.a(var1);

      for(int var2 = var1.getEventType(); var2 != 1; var2 = var1.next()) {
         String var3 = var1.getName();
         if (var2 != 2) {
            if (var2 == 3 && var1.getName().equalsIgnoreCase("ad")) {
               return;
            }
         } else if (var3 != null && var3.equalsIgnoreCase("inline")) {
            this.a(new k());
            this.c().a(var1);
         } else if (var3 != null && var3.equalsIgnoreCase("wrapper")) {
            this.a(new y());
            this.d().a(var1);
         }
      }

   }

   public k c() {
      return this.c;
   }

   public y d() {
      return this.d;
   }
}
