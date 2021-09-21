package com.noqoush.adfalcon.android.sdk.video.vast.model;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class u extends g {
   private String c;
   private l d;
   private String e;
   private ArrayList f;
   private ArrayList g = new ArrayList();

   private void a(x var1) {
      if (this.f == null) {
         this.f = new ArrayList();
      }

      this.f.add(var1);
   }

   private void c(String var1) {
      this.c = var1;
   }

   private void d(String var1) {
      this.e = var1;
   }

   public void a(XmlPullParser var1) throws IOException, XmlPullParserException {
      super.a(var1);
      this.c(var1.getAttributeValue((String)null, "vendor"));

      for(int var2 = var1.getEventType(); var2 != 1; var2 = var1.next()) {
         String var3 = var1.getName();
         if (var2 != 2) {
            if (var2 == 3 && var3 != null && var3.equalsIgnoreCase("Verification")) {
               return;
            }
         } else if (var3 != null) {
            if (var3.equalsIgnoreCase("JavaScriptResource")) {
               this.d = new l();
               this.c().c(var1.getAttributeValue((String)null, "apiFramework"));
               this.c().d(var1.nextText().trim());
            } else if (var3.equalsIgnoreCase("Tracking")) {
               s var4 = new s();
               var4.a(var1.getAttributeValue((String)null, "event"));
               var4.c(var1.nextText().trim());
               this.d().add(var4);
            } else if (var3.equalsIgnoreCase("VerificationParameters")) {
               this.d(var1.nextText().trim());
            } else if (var3.equalsIgnoreCase("ViewableImpression")) {
               x var6 = new x();
               var6.a(var1);
               this.a(var6);
            }
         }
      }

   }

   public l c() {
      return this.d;
   }

   public ArrayList d() {
      if (this.g == null) {
         this.g = new ArrayList();
      }

      return this.g;
   }

   public String e() {
      return this.c;
   }

   public String f() {
      return this.e;
   }

   public ArrayList g() {
      return this.f;
   }
}
