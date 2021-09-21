package com.noqoush.adfalcon.android.sdk.video.vast.model;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class n extends g {
   private String c;
   private String d;
   private int e;
   private int f;
   private String g;
   private int h;
   private int i;
   private int j;
   private String k;
   private String l;

   public void a(XmlPullParser var1) throws IOException, XmlPullParserException {
      super.a(var1);
      this.e(var1.getAttributeValue((String)null, "delivery"));
      String var2 = var1.getAttributeValue((String)null, "height");
      if (var2 != null) {
         this.c(com.noqoush.adfalcon.android.sdk.util.d.b(var2));
      }

      String var3 = var1.getAttributeValue((String)null, "width");
      if (var3 != null) {
         this.f(com.noqoush.adfalcon.android.sdk.util.d.b(var3));
      }

      this.f(var1.getAttributeValue((String)null, "type"));
      this.c(var1.getAttributeValue((String)null, "apiFramework"));
      String var4 = var1.getAttributeValue((String)null, "bitrate");
      if (var4 != null) {
         this.b(com.noqoush.adfalcon.android.sdk.util.d.b(var4));
      }

      String var5 = var1.getAttributeValue((String)null, "maxBitrate");
      if (var5 != null) {
         this.d(com.noqoush.adfalcon.android.sdk.util.d.b(var5));
      }

      String var6 = var1.getAttributeValue((String)null, "minBitrate");
      if (var6 != null) {
         this.e(com.noqoush.adfalcon.android.sdk.util.d.b(var6));
      }

      this.d(var1.getAttributeValue((String)null, "codec"));
      this.g(var1.nextText().trim());
   }

   public void b(int var1) {
      this.h = var1;
   }

   public String c() {
      return this.k;
   }

   public void c(int var1) {
      this.f = var1;
   }

   public void c(String var1) {
      this.k = var1;
   }

   public int d() {
      return this.h;
   }

   public void d(int var1) {
      this.j = var1;
   }

   public void d(String var1) {
      this.g = var1;
   }

   public String e() {
      return this.g;
   }

   public void e(int var1) {
      this.i = var1;
   }

   public void e(String var1) {
      this.c = var1;
   }

   public String f() {
      return this.c;
   }

   public void f(int var1) {
      this.e = var1;
   }

   public void f(String var1) {
      this.d = var1;
   }

   public int g() {
      return this.f;
   }

   public void g(String var1) {
      this.l = var1;
   }

   public int h() {
      return this.j;
   }

   public int i() {
      return this.i;
   }

   public String j() {
      return this.d;
   }

   public String k() {
      return this.l;
   }

   public int l() {
      return this.e;
   }

   public boolean m() {
      return this.g() < this.l();
   }

   public boolean n() {
      return this.j().toLowerCase().contains("mp4") || this.j().toLowerCase().contains("3gp");
   }

   public boolean o() {
      return this.p() && this.f().toLowerCase().contains("progressive");
   }

   public boolean p() {
      return this.j().toLowerCase().contains("video");
   }
}
