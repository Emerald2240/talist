package com.noqoush.adfalcon.android.sdk.video.vast.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class p extends g {
   private ArrayList c = new ArrayList();
   private ArrayList d = new ArrayList();
   private String e;

   private void b(XmlPullParser var1) throws IOException, XmlPullParserException {
      super.a(var1);
      this.a(new ArrayList());

      for(int var2 = var1.getEventType(); var2 != 1; var2 = var1.next()) {
         if (var2 != 2) {
            if (var2 == 3) {
               String var7 = var1.getName();
               if (var7 != null && var7.equalsIgnoreCase("VAST")) {
                  return;
               }
            }
         } else {
            String var3 = var1.getName();
            if (var3 != null && var3.equalsIgnoreCase("ad")) {
               a var5 = new a();
               var5.a(var1);
               this.c().add(var5);
            } else if (var3 != null && var3.equalsIgnoreCase("error")) {
               if (this.d() == null) {
                  this.b(new ArrayList());
               }

               this.d().add(var1.nextText().trim());
            }
         }
      }

   }

   public void a(ArrayList var1) {
      this.c = var1;
   }

   public void a(XmlPullParser var1) throws XmlPullParserException, IOException {
      var1.nextTag();
      var1.require(2, (String)null, "VAST");
      this.c(var1.getAttributeValue((String)null, "version"));
      this.b(var1);
   }

   public void b(ArrayList var1) {
      this.d = var1;
   }

   public ArrayList c() {
      return this.c;
   }

   public void c(String var1) {
      this.e = var1;
   }

   public ArrayList d() {
      return this.d;
   }

   int e() {
      ArrayList var1 = this.c();
      int var2 = 0;
      if (var1 != null) {
         if (this.c().size() == 0) {
            return 0;
         }

         Iterator var3 = this.c().iterator();

         while(var3.hasNext()) {
            a var4 = (a)var3.next();
            if (var4.b() > var2) {
               var2 = var4.b();
            }
         }
      }

      return var2;
   }

   public String f() {
      return this.e;
   }
}
