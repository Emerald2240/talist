package com.noqoush.adfalcon.android.sdk.video.vast.model;

import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class o extends g {
   private HashMap c;

   public void a(HashMap var1) {
      this.c = var1;
   }

   public void a(XmlPullParser var1) throws IOException, XmlPullParserException {
      this.a(new HashMap());
      int var2 = var1.getEventType();

      while(true) {
         while(var2 != 1) {
            label32: {
               String var3 = var1.getName();
               if (var2 != 2) {
                  if (var2 != 3) {
                     break label32;
                  }
               } else {
                  if (var3 == null) {
                     continue;
                  }

                  if (var3 != null && var3.equalsIgnoreCase("moatParams")) {
                     var2 = var1.next();
                     continue;
                  }

                  super.a(var1);
                  this.c().put(var3, var1.nextText().trim());
               }

               if (var3 != null && var3.equalsIgnoreCase("moatParams")) {
                  return;
               }
            }

            var2 = var1.next();
         }

         return;
      }
   }

   public HashMap c() {
      return this.c;
   }
}
