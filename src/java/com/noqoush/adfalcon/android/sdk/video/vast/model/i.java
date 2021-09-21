package com.noqoush.adfalcon.android.sdk.video.vast.model;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class i extends g {
   private String c;
   private j d;
   private q e;
   private v f;
   private s g;
   private o h;
   private List i;
   private int j;

   public void a(j var1) {
      this.d = var1;
   }

   public void a(o var1) {
      this.h = var1;
   }

   public void a(q var1) {
      this.e = var1;
   }

   public void a(s var1) {
      this.g = var1;
   }

   public void a(v var1) {
      this.f = var1;
   }

   public void a(List var1) {
      this.i = var1;
   }

   public void a(XmlPullParser var1) throws IOException, XmlPullParserException {
      super.a(var1);
      int var2 = var1.getEventType();
      String var3 = null;

      while(true) {
         byte var4 = 1;
         if (var2 == var4) {
            return;
         }

         String var5 = var1.getName();
         if (var2 != 2) {
            if (var2 == 3 && var5 != null && (var5.equalsIgnoreCase("extension") || var5.equalsIgnoreCase("creativeextension"))) {
               return;
            }
         } else if (var5 != null) {
            StringBuilder var6 = new StringBuilder();
            var6.append("Extension, name=");
            var6.append(var5);
            var6.append(", type=");
            var6.append(this.j());
            Log.d("VAST", var6.toString());
            boolean var12;
            if (this.j() != null && this.j().equalsIgnoreCase("AdVerifications")) {
               var12 = true;
            } else {
               var12 = false;
            }

            if (var12) {
               if (var5.equalsIgnoreCase("extension")) {
                  this.c(var1.getAttributeValue((String)null, "type"));
               } else if (var12 && var5.equalsIgnoreCase("Verification")) {
                  u var18 = new u();
                  var18.a(var1);
                  if (this.c() == null) {
                     this.a((List)(new ArrayList()));
                  }

                  this.c().add(var18);
               }
            } else {
               if (this.j() == null || !this.j().equalsIgnoreCase("AdFalcon")) {
                  var4 = 0;
               }

               if (!var5.equalsIgnoreCase("extension") && !var5.equalsIgnoreCase("creativeextension")) {
                  if (var4 != 0 && var5.equalsIgnoreCase("customAdChoices")) {
                     var3 = var5;
                  } else if (var4 != 0 && var5.equalsIgnoreCase("icon") && "customAdChoices".equalsIgnoreCase(var3)) {
                     j var17 = new j();
                     var17.a(var1);
                     this.a(var17);
                  } else if (var4 != 0 && var5.equalsIgnoreCase("rewarditem")) {
                     q var16 = new q();
                     var16.a(var1);
                     this.a(var16);
                  } else if (var4 != 0 && var5.equalsIgnoreCase("endcardduration")) {
                     this.b(1000 * super.a(var1.nextText().trim()));
                  } else if (var4 != 0 && var5.equalsIgnoreCase("customvideoclicks")) {
                     v var15 = new v();
                     var15.a(var1);
                     this.a(var15);
                  } else if (var4 == 0 && var5.equalsIgnoreCase("tracking")) {
                     s var14 = new s();
                     var14.a(var1.getAttributeValue((String)null, "event"));
                     var14.c(var1.nextText().trim());
                     this.a(var14);
                  } else if (var4 != 0 && var5.equalsIgnoreCase("moatParams")) {
                     o var13 = new o();
                     var13.a(var1);
                     this.a(var13);
                  }
               } else {
                  this.c(var1.getAttributeValue((String)null, "type"));
               }
            }
         }

         var2 = var1.next();
      }
   }

   public void b(int var1) {
      this.j = var1;
   }

   public List c() {
      return this.i;
   }

   public void c(String var1) {
      this.c = var1;
   }

   public j d() {
      return this.d;
   }

   public s e() {
      return this.g;
   }

   public v f() {
      return this.f;
   }

   public int g() {
      return this.j;
   }

   public o h() {
      return this.h;
   }

   public q i() {
      return this.e;
   }

   public String j() {
      return this.c;
   }
}
