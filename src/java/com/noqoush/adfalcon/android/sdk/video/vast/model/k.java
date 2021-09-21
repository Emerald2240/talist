package com.noqoush.adfalcon.android.sdk.video.vast.model;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class k extends g {
   private String c;
   private String d;
   private String e;
   private ArrayList f = new ArrayList();
   private ArrayList g;
   private String h;
   private String i;
   private f j;
   private ArrayList k = new ArrayList();
   private ArrayList l = new ArrayList();
   private ArrayList m;

   private void a(u var1) {
      if (this.m == null) {
         this.m = new ArrayList();
      }

      this.m.add(var1);
   }

   private void a(x var1) {
      if (this.g == null) {
         this.g = new ArrayList();
      }

      this.g.add(var1);
   }

   public void a(f var1) {
      this.j = var1;
   }

   public void a(ArrayList var1) {
      this.k = var1;
   }

   public void a(XmlPullParser var1) throws IOException, XmlPullParserException {
      super.a(var1);

      for(int var2 = var1.getEventType(); var2 != 1; var2 = var1.next()) {
         String var3 = var1.getName();
         if (var2 != 2) {
            if (var2 == 3 && var3 != null && var3.equalsIgnoreCase("inline")) {
               return;
            }
         } else if (var3 != null) {
            this.a(var1, var3);
         }
      }

   }

   void a(XmlPullParser var1, String var2) throws XmlPullParserException, IOException {
      if (var2.equalsIgnoreCase("adsystem")) {
         this.d(var1.nextText().trim());
      } else if (var2.equalsIgnoreCase("adtitle")) {
         this.e(var1.nextText().trim());
      } else if (var2.equalsIgnoreCase("description")) {
         this.g(var1.nextText().trim());
      } else if (var2.equalsIgnoreCase("advertiser")) {
         this.f(var1.nextText().trim());
      } else if (var2.equalsIgnoreCase("impression")) {
         if (this.l() == null) {
            this.c(new ArrayList());
         }

         this.l().add(var1.nextText().trim());
      } else if (var2.equalsIgnoreCase("ViewableImpression")) {
         x var3 = new x();
         var3.a(var1);
         this.a(var3);
      } else if (var2.equalsIgnoreCase("creatives")) {
         this.a(new f());
         this.h().a(var1);
      } else if (var2.equalsIgnoreCase("extension")) {
         if (this.k() == null) {
            this.b(new ArrayList());
         }

         i var6 = new i();
         var6.a(var1);
         this.k().add(var6);
      } else if (var2.equalsIgnoreCase("error")) {
         if (this.j() == null) {
            this.a(new ArrayList());
         }

         this.j().add(var1.nextText().trim());
      } else if (var2.equalsIgnoreCase("Verification")) {
         u var4 = new u();
         var4.a(var1);
         this.a(var4);
      } else {
         if (var2.equalsIgnoreCase("AdServingId")) {
            this.c(var1.nextText().trim());
         }

      }
   }

   public void b(ArrayList var1) {
      this.l = var1;
   }

   public String c() {
      return this.e;
   }

   public void c(String var1) {
      this.e = var1;
   }

   public void c(ArrayList var1) {
      this.f = var1;
   }

   public String d() {
      return this.c;
   }

   public void d(String var1) {
      this.c = var1;
   }

   public String e() {
      return this.d;
   }

   public void e(String var1) {
      this.d = var1;
   }

   public ArrayList f() {
      return this.m;
   }

   public void f(String var1) {
      this.h = var1;
   }

   public String g() {
      return this.h;
   }

   public void g(String var1) {
      this.i = var1;
   }

   public f h() {
      return this.j;
   }

   public String i() {
      return this.i;
   }

   public ArrayList j() {
      return this.k;
   }

   public ArrayList k() {
      return this.l;
   }

   public ArrayList l() {
      return this.f;
   }

   public ArrayList m() {
      return this.g;
   }
}
