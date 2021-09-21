package com.noqoush.adfalcon.android.sdk.video.vast.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class f extends g {
   private ArrayList c = new ArrayList();

   public void a(ArrayList var1) {
      this.c = var1;
   }

   public void a(XmlPullParser var1) throws IOException, XmlPullParserException {
      super.a(var1);

      for(int var2 = var1.getEventType(); var2 != 1; var2 = var1.next()) {
         String var3 = var1.getName();
         if (var2 != 2) {
            if (var2 == 3 && var3 != null && var3.equalsIgnoreCase("creatives")) {
               return;
            }
         } else if (var3 != null) {
            if (this.c() == null) {
               this.a(new ArrayList());
            }

            e var4 = new e();
            var4.a(var1);
            this.c().add(var4);
         }
      }

   }

   public ArrayList c() {
      return this.c;
   }

   public int d() {
      ArrayList var1 = this.c();
      int var2 = 0;
      if (var1 != null) {
         if (this.c().size() == 0) {
            return 0;
         }

         Iterator var3 = this.c().iterator();

         while(var3.hasNext()) {
            e var4 = (e)var3.next();
            if (var4.b() > var2) {
               var2 = var4.b();
            }
         }
      }

      return var2;
   }
}
