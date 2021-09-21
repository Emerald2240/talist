package com.noqoush.adfalcon.android.sdk.video.vast.model;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class j extends h {
   private String o;
   private int p;
   private int q;
   private String r;
   private String s;
   private String t;
   private String u;
   private ArrayList v = new ArrayList();

   protected void a(com.noqoush.adfalcon.android.sdk.urlactions.i var1, com.noqoush.adfalcon.android.sdk.urlactions.m var2) {
   }

   public void a(XmlPullParser var1) throws IOException, XmlPullParserException {
      for(int var2 = var1.getEventType(); var2 != 1; var2 = var1.next()) {
         String var3 = var1.getName();
         if (var2 != 2) {
            if (var2 == 3 && var3 != null && var3.equalsIgnoreCase("icon")) {
               return;
            }
         } else if (var3 != null) {
            super.a(var1);
            if (var3.equalsIgnoreCase("icon")) {
               String var5 = var1.getAttributeValue((String)null, "height");
               if (var5 != null) {
                  this.b(com.noqoush.adfalcon.android.sdk.util.d.b(var5));
               }

               String var6 = var1.getAttributeValue((String)null, "width");
               if (var6 != null) {
                  this.c(com.noqoush.adfalcon.android.sdk.util.d.b(var6));
               }

               this.j(var1.getAttributeValue((String)null, "program"));
               this.k(var1.getAttributeValue((String)null, "xPosition"));
               this.l(var1.getAttributeValue((String)null, "yPosition"));
               this.h(var1.getAttributeValue((String)null, "duration"));
               this.i(var1.getAttributeValue((String)null, "offset"));
            } else if (var3.equalsIgnoreCase("iconviewtracking")) {
               if (this.u() == null) {
                  this.c(new ArrayList());
               }

               this.u().add(var1.nextText().trim());
            }
         }
      }

   }

   public void b(int var1) {
      this.q = var1;
   }

   public void c(int var1) {
      this.p = var1;
   }

   public void c(ArrayList var1) {
      this.v = var1;
   }

   public int g() {
      return this.q;
   }

   public void h(String var1) {
      this.t = var1;
   }

   public void i(String var1) {
      this.u = var1;
   }

   public void j(String var1) {
      this.o = var1;
   }

   public void k(String var1) {
      this.r = var1;
   }

   public int l() {
      return this.p;
   }

   public void l(String var1) {
      this.s = var1;
   }

   protected void n() {
   }

   protected void o() {
   }

   public String r() {
      return this.t;
   }

   public String s() {
      return this.u;
   }

   public String t() {
      return this.o;
   }

   public ArrayList u() {
      return this.v;
   }

   public String v() {
      return this.r;
   }

   public String w() {
      return this.s;
   }
}
