package com.noqoush.adfalcon.android.sdk.video.vast.model;

import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class v extends h {
   private String o;
   private w p;

   protected void a(com.noqoush.adfalcon.android.sdk.urlactions.i var1, com.noqoush.adfalcon.android.sdk.urlactions.m var2) {
      try {
         if (this.s() != null) {
            this.s().a(this, var1, var2);
            return;
         }
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }

   }

   public void a(v var1) {
      this.h(var1.r());
      this.c(var1.l());
      this.b(var1.g());
      this.f(var1.j());
      this.g(var1.k());
      if (this.l() == 0 || this.g() == 0) {
         this.c(120);
         this.b(30);
      }

      if (this.k() == null) {
         Locale var2 = Locale.getDefault();
         Object[] var3 = new Object[]{this.l(), this.g(), this.r()};
         this.d(String.format(var2, "<button type=\"button\" style=\"width:%dpx;height:%dpx;\">%s</button>", var3));
      } else {
         this.d((String)null);
      }
   }

   public void a(w var1) {
      this.p = var1;
   }

   public void a(XmlPullParser var1) throws IOException, XmlPullParserException {
      for(int var2 = var1.getEventType(); var2 != 1; var2 = var1.next()) {
         String var3 = var1.getName();
         if (var2 != 2) {
            if (var2 == 3 && var3 != null && (var3.equalsIgnoreCase("videoclicks") || var3.equalsIgnoreCase("CustomVideoClicks"))) {
               return;
            }
         } else if (var3 != null) {
            super.a(var1);
            if (var3.equalsIgnoreCase("cta")) {
               this.h(var1.nextText());
            }
         }
      }

   }

   public void h(String var1) {
      this.o = var1;
   }

   protected void n() {
      try {
         if (this.s() != null) {
            this.s().a(this);
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   protected void o() {
      try {
         if (this.s() != null) {
            this.s().b(this);
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public String r() {
      return this.o;
   }

   public w s() {
      return this.p;
   }
}
