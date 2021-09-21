package com.noqoush.adfalcon.android.sdk.video.vast.model;

import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class b extends h {
   private ArrayList o = new ArrayList();
   private c p;

   public void a(Context var1, String var2, int var3, com.noqoush.adfalcon.android.sdk.video.vast.manager.g var4) {
      Iterator var5 = this.s().iterator();

      while(var5.hasNext()) {
         ((s)var5.next()).a(var1, var2, var3, var4, 0);
      }

   }

   protected void a(com.noqoush.adfalcon.android.sdk.urlactions.i var1, com.noqoush.adfalcon.android.sdk.urlactions.m var2) {
      try {
         if (this.r() != null) {
            this.r().a(this, var1, var2);
            return;
         }
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }

   }

   public void a(c var1) {
      this.p = var1;
   }

   public void a(XmlPullParser var1) throws IOException, XmlPullParserException {
      for(int var2 = var1.getEventType(); var2 != 1; var2 = var1.next()) {
         String var3 = var1.getName();
         if (var2 != 2) {
            if (var2 == 3 && var3 != null && var3.equalsIgnoreCase("companion")) {
               return;
            }
         } else if (var3 != null) {
            super.a(var1);
            if (var3.equalsIgnoreCase("tracking")) {
               if (this.s() == null) {
                  this.c(new ArrayList());
               }

               s var4 = new s();
               var4.a(var1.getAttributeValue((String)null, "event"));
               var4.c(var1.nextText().trim());
               this.s().add(var4);
            }
         }
      }

   }

   public boolean a(Context var1, boolean var2) {
      com.noqoush.adfalcon.android.sdk.g var3 = com.noqoush.adfalcon.android.sdk.g.c(var1);
      float var4 = (float)(var3.v() * var3.u());
      float var5 = (float)(this.l() * this.g());
      int var6 = this.g();
      boolean var7 = false;
      if (var6 <= 90) {
         int var8 = this.g();
         var7 = false;
         if (var8 > 10) {
            float var9;
            if (var2) {
               var9 = (float)Math.min(var3.u(), var3.v()) / var3.e();
            } else {
               var9 = (float)Math.max(var3.u(), var3.v()) / var3.e();
            }

            float var17;
            int var10 = (var17 = (float)this.l() - var9) == 0.0F ? 0 : (var17 < 0.0F ? -1 : 1);
            var7 = false;
            if (var10 <= 0) {
               double var11 = (double)var5;
               double var13 = (double)var4;
               Double.isNaN(var13);
               double var18;
               int var16 = (var18 = var11 - var13 * 0.15D) == 0.0D ? 0 : (var18 < 0.0D ? -1 : 1);
               var7 = false;
               if (var16 <= 0) {
                  var7 = true;
               }
            }
         }
      }

      return var7;
   }

   public boolean b(Context var1, boolean var2) {
      com.noqoush.adfalcon.android.sdk.g var3 = com.noqoush.adfalcon.android.sdk.g.c(var1);
      if (this.l() != 0 || this.g() != 0 || this.h() == null && this.i() == null) {
         if (this.g() >= 250) {
            float var4;
            float var5;
            if (var2) {
               var4 = (float)Math.min(var3.u(), var3.v()) / var3.e();
               var5 = (float)Math.max(var3.u(), var3.v()) / var3.e();
            } else {
               var4 = (float)Math.max(var3.u(), var3.v()) / var3.e();
               var5 = (float)Math.min(var3.u(), var3.v()) / var3.e();
            }

            return (float)this.l() <= var4 && (float)this.g() <= var5;
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public void c(ArrayList var1) {
      this.o = var1;
   }

   protected void n() {
      try {
         if (this.r() != null) {
            this.r().a(this);
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   protected void o() {
      try {
         if (this.r() != null) {
            this.r().b(this);
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public c r() {
      return this.p;
   }

   public ArrayList s() {
      return this.o;
   }

   public boolean t() {
      return this.h() == null && this.i() == null && this.k() == null;
   }

   public boolean u() {
      return this.k() != null || this.i() != null || this.h() != null;
   }
}
