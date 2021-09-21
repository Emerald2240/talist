package com.noqoush.adfalcon.android.sdk.video.vast.model;

import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class d extends g {
   private ArrayList c = new ArrayList();

   public b a(Context var1, boolean var2) {
      ArrayList var3 = this.c;
      if (var3 != null) {
         if (var3.size() == 0) {
            return null;
         }

         Iterator var4 = this.c.iterator();

         while(var4.hasNext()) {
            b var5 = (b)var4.next();
            if (var5.a(var1, var2)) {
               return var5;
            }
         }
      }

      return null;
   }

   public void a(ArrayList var1) {
      this.c = var1;
   }

   public void a(XmlPullParser var1) throws IOException, XmlPullParserException {
      super.a(var1);

      for(int var2 = var1.getEventType(); var2 != 1; var2 = var1.next()) {
         String var3 = var1.getName();
         if (var2 != 2) {
            if (var2 == 3 && var3 != null && var3.equalsIgnoreCase("companionads")) {
               return;
            }
         } else if (var3 != null && var3.equalsIgnoreCase("companion")) {
            if (this.c() == null) {
               this.a(new ArrayList());
            }

            b var4 = new b();
            var4.a(var1);
            this.c().add(var4);
         }
      }

   }

   public b b(Context var1, boolean var2) {
      ArrayList var3 = this.c;
      if (var3 != null) {
         if (var3.size() == 0) {
            return null;
         }

         Iterator var4 = this.c.iterator();

         while(var4.hasNext()) {
            b var5 = (b)var4.next();
            if (var5.b(var1, var2)) {
               return var5;
            }
         }
      }

      return null;
   }

   public ArrayList c() {
      return this.c;
   }
}
