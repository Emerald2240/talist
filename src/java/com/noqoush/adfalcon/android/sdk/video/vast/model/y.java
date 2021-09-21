package com.noqoush.adfalcon.android.sdk.video.vast.model;

import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class y extends k {
   private String n;
   private p o;
   private boolean p = true;
   private boolean q;
   private boolean r;

   public b a(Context var1, boolean var2) {
      Iterator var3 = this.n().iterator();

      b var4;
      do {
         if (!var3.hasNext()) {
            return null;
         }

         var4 = (b)var3.next();
      } while(!var4.a(var1, var2) || var4.t());

      return var4;
   }

   public void a(p var1) {
      this.o = var1;
   }

   public void a(XmlPullParser var1) throws IOException, XmlPullParserException {
      for(int var2 = var1.getEventType(); var2 != 1; var2 = var1.next()) {
         String var3 = var1.getName();
         if (var2 != 2) {
            if (var2 == 3 && var3 != null && var3.equalsIgnoreCase("wrapper")) {
               return;
            }
         } else if (var3 != null) {
            String var4 = var1.getAttributeValue((String)null, "allowMultipleAds");
            if (var4 != null) {
               this.a(Boolean.parseBoolean(var4));
            }

            String var5 = var1.getAttributeValue((String)null, "fallbackOnNoAd");
            if (var5 != null) {
               this.b(Boolean.parseBoolean(var5));
            }

            String var6 = var1.getAttributeValue((String)null, "followAdditonalWrappers");
            if (var6 != null) {
               this.c(Boolean.parseBoolean(var6));
            }

            if (var3.equalsIgnoreCase("vastadtaguri")) {
               this.h(var1.nextText().trim());
            }

            super.a(var1, var3);
         }
      }

   }

   public void a(boolean var1) {
      this.q = var1;
   }

   public b b(Context var1, boolean var2) {
      Iterator var3 = this.n().iterator();

      b var4;
      do {
         if (!var3.hasNext()) {
            return null;
         }

         var4 = (b)var3.next();
      } while(!var4.b(var1, var2) || var4.t());

      return var4;
   }

   public void b(int var1) {
   }

   public void b(boolean var1) {
      this.r = var1;
   }

   public void c(boolean var1) {
      this.p = var1;
   }

   public void h(String var1) {
      this.n = var1;
   }

   public ArrayList n() {
      ArrayList var1 = new ArrayList();
      if (this.h() == null) {
         return var1;
      } else {
         Iterator var2 = this.h().c().iterator();

         while(true) {
            e var3;
            do {
               if (!var2.hasNext()) {
                  return var1;
               }

               var3 = (e)var2.next();
            } while(var3.e() == null);

            Iterator var4 = var3.e().c().iterator();

            while(var4.hasNext()) {
               var1.add((b)var4.next());
            }
         }
      }
   }

   public ArrayList o() {
      ArrayList var1 = new ArrayList();
      if (this.h() == null) {
         return var1;
      } else {
         Iterator var2 = this.h().c().iterator();

         while(var2.hasNext()) {
            e var3 = (e)var2.next();
            if (var3.g() != null) {
               var1.add(var3.g());
            }
         }

         return var1;
      }
   }

   public p p() {
      return this.o;
   }

   public String q() {
      return this.n;
   }

   public boolean r() {
      return this.q;
   }

   public boolean s() {
      return this.r;
   }

   public boolean t() {
      return this.p;
   }

   public void u() {
   }
}
