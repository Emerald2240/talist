package com.noqoush.adfalcon.android.sdk.video.vast.model;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class x extends g {
   private String c;
   private String d;
   private String e;

   private void c(String var1) {
      this.d = var1;
   }

   private void d(String var1) {
      this.e = var1;
   }

   private void e(String var1) {
      this.c = var1;
   }

   public void a(XmlPullParser var1) throws IOException, XmlPullParserException {
      super.a(var1);

      for(int var2 = var1.getEventType(); var2 != 1; var2 = var1.next()) {
         String var3 = var1.getName();
         if (var2 != 2) {
            if (var2 == 3 && var3 != null && var3.equalsIgnoreCase("ViewableImpression")) {
               return;
            }
         } else if (var3 != null) {
            if (var3.equalsIgnoreCase("Viewable")) {
               this.e(var1.nextText().trim());
            } else if (var3.equalsIgnoreCase("NotViewable")) {
               this.c(var1.nextText().trim());
            } else if (var3.equalsIgnoreCase("ViewUndetermined")) {
               this.d(var1.nextText().trim());
            }
         }
      }

   }

   public String c() {
      return this.d;
   }

   public String d() {
      return this.e;
   }

   public String e() {
      return this.c;
   }
}
