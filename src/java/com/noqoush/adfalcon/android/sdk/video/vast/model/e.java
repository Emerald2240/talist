package com.noqoush.adfalcon.android.sdk.video.vast.model;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class e extends g {
   private m c;
   private d d;
   private String e;
   private String f;
   private ArrayList g = new ArrayList();
   private t h;

   public void a(d var1) {
      this.d = var1;
   }

   public void a(m var1) {
      this.c = var1;
   }

   public void a(t var1) {
      this.h = var1;
   }

   public void a(ArrayList var1) {
      this.g = var1;
   }

   public void a(XmlPullParser var1) throws IOException, XmlPullParserException {
      for(int var2 = var1.getEventType(); var2 != 1; var2 = var1.next()) {
         String var3 = var1.getName();
         if (var2 != 2) {
            if (var2 == 3 && var3 != null && var3.equalsIgnoreCase("creative")) {
               return;
            }
         } else if (var3 != null) {
            if (var3.equalsIgnoreCase("creative")) {
               super.a(var1);
               this.c(var1.getAttributeValue((String)null, "AdID"));
               this.d(var1.getAttributeValue((String)null, "apiFramework"));
            } else if (var3.equalsIgnoreCase("linear")) {
               this.a(new m());
               this.g().a(var1);
            } else if (var3.equalsIgnoreCase("companionads")) {
               this.a(new d());
               this.e().a(var1);
            } else if (!var3.equalsIgnoreCase("creativeextension") && !var3.equalsIgnoreCase("extension")) {
               if (var3.equalsIgnoreCase("UniversalAdId")) {
                  this.a(new t());
                  this.h().a(var1);
               }
            } else {
               if (this.f() == null) {
                  this.a(new ArrayList());
               }

               i var4 = new i();
               var4.a(var1);
               this.f().add(var4);
            }
         }
      }

   }

   public String c() {
      return this.e;
   }

   public void c(String var1) {
      this.e = var1;
   }

   public String d() {
      return this.f;
   }

   public void d(String var1) {
      this.f = var1;
   }

   public d e() {
      return this.d;
   }

   public ArrayList f() {
      return this.g;
   }

   public m g() {
      return this.c;
   }

   public t h() {
      return this.h;
   }
}
