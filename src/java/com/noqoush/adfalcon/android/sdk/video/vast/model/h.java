package com.noqoush.adfalcon.android.sdk.video.vast.model;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.noqoush.adfalcon.android.sdk.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public abstract class h extends g {
   private int c;
   private int d;
   private String e;
   private String f;
   private String g;
   private String h;
   private String i;
   private ArrayList j = new ArrayList();
   private ArrayList k = new ArrayList();
   private ContextWrapper l;
   private z m;
   private boolean n;

   private String r() {
      int var1 = this.l();
      String var2 = "100%";
      String var3 = "";
      String var7;
      if (var1 > 0) {
         StringBuilder var4 = new StringBuilder();
         var4.append(var3);
         var4.append(this.l());
         var7 = var4.toString();
      } else {
         var7 = var2;
      }

      if (this.g() > 0) {
         StringBuilder var8 = new StringBuilder();
         var8.append(var3);
         var8.append(this.g());
         var2 = var8.toString();
      }

      if (this.h() != null) {
         var3 = this.h();
      } else if (this.k() != null) {
         if (this.j().toLowerCase().contains("image")) {
            Locale var17 = Locale.getDefault();
            Object[] var18 = new Object[]{this.k(), var7, var2};
            var3 = String.format(var17, "<img src='%s' width='%s' height='%s'/>", var18);
         } else if (this.j().toLowerCase().contains("javascript")) {
            Locale var15 = Locale.getDefault();
            Object[] var16 = new Object[]{this.k(), var7, var2};
            var3 = String.format(var15, "<script src='%s' width='%s' height='%s'></script>", var16);
         }
      } else if (this.i() != null) {
         Locale var13 = Locale.getDefault();
         Object[] var14 = new Object[]{this.i(), var7, var2};
         var3 = String.format(var13, "<iframe style='frameBorder:0px; border:none; scrolling:no;' frameBorder='0px' border='none' src='%s' width='%s' height='%s'/>", var14);
      } else {
         var3 = null;
      }

      if (this.c() != null) {
         Locale var11 = Locale.getDefault();
         Object[] var12 = new Object[]{this.c(), var3};
         var3 = String.format(var11, "<a href='%s'>%s</a>", var12);
      }

      return var3;
   }

   public z a(Context var1) throws Exception {
      return this.a((Context)var1, (RelativeLayout)null);
   }

   public z a(Context var1, RelativeLayout var2) throws Exception {
      z var3 = this.m;
      if (var3 != null) {
         return var3;
      } else {
         this.b(var1);
         if (this.l() < 10 || this.g() < 10) {
            com.noqoush.adfalcon.android.sdk.g var4 = com.noqoush.adfalcon.android.sdk.g.c(var1);
            int var5 = (int)((float)var4.v() / var4.e());
            int var6 = (int)((float)var4.u() / var4.e());
            this.c(var5);
            this.b(var6);
         }

         String var7 = this.r();
         z var8 = new z(this.e());
         this.m = var8;
         com.noqoush.adfalcon.android.sdk.util.e.e(var8);
         this.a(true);
         String var9 = String.format(Locale.getDefault(), "<html><head><style type='text/css'> html { -webkit-text-size-adjust: none;} </style> <meta name=\"viewport\" content=\"initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\" /></head><body style='margin-left:0px; margin-right:0px; margin-top:0px; margin-bottom:0px;padding-bottom:0px; padding-left:0px; padding-right:0px; padding-top:0px; background-color:transparent; border:none' bgcolor='transparent'>%s</body></html>", new Object[]{var7});
         this.m.loadDataWithBaseURL("", var9, "text/html", "UTF-8", (String)null);
         this.m.setBackgroundColor(0);
         this.m.setWebChromeClient(new com.noqoush.adfalcon.android.sdk.y(this.e(), var2, (ProgressBar)null));
         this.m.setWebViewClient(new h$a(this));
         return this.m;
      }
   }

   public void a(Context param1, com.noqoush.adfalcon.android.sdk.video.vast.manager.g param2) {
      // $FF: Couldn't be decompiled
   }

   public void a(ContextWrapper var1) {
      this.l = var1;
   }

   protected abstract void a(com.noqoush.adfalcon.android.sdk.urlactions.i var1, com.noqoush.adfalcon.android.sdk.urlactions.m var2);

   public void a(ArrayList var1) {
      this.j = var1;
   }

   public void a(XmlPullParser var1) throws XmlPullParserException, IOException {
      super.a(var1);
      String var2 = var1.getName();
      if (var2 != null) {
         if (var2.toLowerCase().contains("staticresource")) {
            String var7 = var1.getAttributeValue((String)null, "creativeType");
            if (var7 == null || var7.toLowerCase().contains("image") || var7.toLowerCase().contains("javascript")) {
               if (var7 != null) {
                  this.f(var7);
               }

               this.g(var1.nextText().trim());
               return;
            }
         } else {
            if (var2.toLowerCase().contains("iframeresource")) {
               this.e(var1.nextText().trim());
               return;
            }

            if (var2.toLowerCase().contains("htmlresource")) {
               this.d(var1.nextText().trim());
               return;
            }

            if (var2.toLowerCase().contains("clickthrough")) {
               this.c(var1.nextText().trim());
               return;
            }

            if (var2.toLowerCase().contains("clicktracking")) {
               if (this.d() == null) {
                  this.a(new ArrayList());
               }

               this.d().add(var1.nextText().trim());
               return;
            }

            if (var2.toLowerCase().contains("customclick")) {
               if (this.f() == null) {
                  this.b(new ArrayList());
               }

               this.f().add(var1.nextText().trim());
               return;
            }

            String var3 = var1.getAttributeValue((String)null, "height");
            if (var3 != null) {
               this.b(com.noqoush.adfalcon.android.sdk.util.d.b(var3));
            }

            String var4 = var1.getAttributeValue((String)null, "width");
            if (var4 != null) {
               this.c(com.noqoush.adfalcon.android.sdk.util.d.b(var4));
            }
         }

      }
   }

   public void a(boolean var1) {
      this.n = var1;
   }

   public void b(int var1) {
      this.d = var1;
   }

   public void b(Context var1) {
      this.l = new ContextWrapper(var1);
   }

   public void b(ArrayList var1) {
      this.k = var1;
   }

   public String c() {
      return this.i;
   }

   public void c(int var1) {
      this.c = var1;
   }

   public void c(String var1) {
      this.i = var1;
   }

   public ArrayList d() {
      return this.j;
   }

   public void d(String var1) {
      this.h = var1;
   }

   public ContextWrapper e() {
      return this.l;
   }

   public void e(String var1) {
      this.g = var1;
   }

   public ArrayList f() {
      return this.k;
   }

   public void f(String var1) {
      this.f = var1;
   }

   public int g() {
      return this.d;
   }

   public void g(String var1) {
      this.e = var1;
   }

   public String h() {
      return this.h;
   }

   public String i() {
      return this.g;
   }

   public String j() {
      return this.f;
   }

   public String k() {
      return this.e;
   }

   public int l() {
      return this.c;
   }

   public boolean m() {
      return this.n;
   }

   protected abstract void n();

   protected abstract void o();

   public void p() {
      z var1 = this.m;
      if (var1 != null) {
         var1.a();
      }

   }

   public void q() {
      z var1 = this.m;
      if (var1 != null) {
         var1.b();
      }

   }
}
