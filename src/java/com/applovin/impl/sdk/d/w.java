package com.applovin.impl.sdk.d;

import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class w extends a {
   private com.applovin.impl.a.c a;
   private final AppLovinAdLoadListener c;

   w(com.applovin.impl.a.c var1, AppLovinAdLoadListener var2, com.applovin.impl.sdk.j var3) {
      super("TaskRenderVastAd", var3);
      this.c = var2;
      this.a = var1;
   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.w;
   }

   public void run() {
      this.a("Rendering VAST ad...");
      int var1 = this.a.b().size();
      HashSet var2 = new HashSet(var1);
      HashSet var3 = new HashSet(var1);
      Iterator var4 = this.a.b().iterator();
      String var5 = "";
      com.applovin.impl.a.f var6 = null;
      com.applovin.impl.a.j var7 = null;
      com.applovin.impl.a.b var8 = null;
      String var9 = var5;

      while(true) {
         com.applovin.impl.sdk.utils.s var22;
         label56:
         do {
            while(var4.hasNext()) {
               com.applovin.impl.sdk.utils.s var14 = (com.applovin.impl.sdk.utils.s)var4.next();
               String var15;
               if (com.applovin.impl.a.i.a(var14)) {
                  var15 = "Wrapper";
               } else {
                  var15 = "InLine";
               }

               com.applovin.impl.sdk.utils.s var16 = var14.c(var15);
               if (var16 != null) {
                  com.applovin.impl.sdk.utils.s var20 = var16.c("AdSystem");
                  if (var20 != null) {
                     var6 = com.applovin.impl.a.f.a(var20, var6, this.b);
                  }

                  var5 = com.applovin.impl.a.i.a(var16, "AdTitle", var5);
                  var9 = com.applovin.impl.a.i.a(var16, "Description", var9);
                  com.applovin.impl.a.i.a((List)var16.a("Impression"), (Set)var2, this.a, this.b);
                  com.applovin.impl.sdk.utils.s var21 = var16.b("ViewableImpression");
                  if (var21 != null) {
                     com.applovin.impl.a.i.a((List)var21.a("Viewable"), (Set)var2, this.a, this.b);
                  }

                  com.applovin.impl.a.i.a((List)var16.a("Error"), (Set)var3, this.a, this.b);
                  var22 = var16.b("Creatives");
                  continue label56;
               }

               StringBuilder var17 = new StringBuilder();
               var17.append("Did not find wrapper or inline response for node: ");
               var17.append(var14);
               this.d(var17.toString());
            }

            com.applovin.impl.a.a var10 = com.applovin.impl.a.a.aO().a(this.b).a(this.a.c()).b(this.a.d()).a(this.a.e()).a(this.a.f()).a(var5).b(var9).a(var6).a(var7).a(var8).a((Set)var2).b((Set)var3).a();
            com.applovin.impl.a.d var11 = com.applovin.impl.a.i.a(var10);
            if (var11 == null) {
               h var12 = new h(var10, this.b, this.c);
               r.a var13 = r.a.h;
               if ((Boolean)this.b.a(com.applovin.impl.sdk.b.d.bm)) {
                  if (var10.getType() == AppLovinAdType.REGULAR) {
                     var13 = r.a.f;
                  } else if (var10.getType() == AppLovinAdType.INCENTIVIZED) {
                     var13 = r.a.g;
                  }
               }

               this.b.K().a((a)var12, var13);
               return;
            }

            com.applovin.impl.a.i.a(this.a, this.c, var11, -6, this.b);
            return;
         } while(var22 == null);

         Iterator var23 = var22.d().iterator();

         while(var23.hasNext()) {
            com.applovin.impl.sdk.utils.s var24 = (com.applovin.impl.sdk.utils.s)var23.next();
            com.applovin.impl.sdk.utils.s var25 = var24.b("Linear");
            if (var25 != null) {
               var7 = com.applovin.impl.a.j.a(var25, var7, this.a, this.b);
            } else {
               com.applovin.impl.sdk.utils.s var26 = var24.c("CompanionAds");
               if (var26 != null) {
                  com.applovin.impl.sdk.utils.s var30 = var26.c("Companion");
                  if (var30 != null) {
                     var8 = com.applovin.impl.a.b.a(var30, var8, this.a, this.b);
                  }
               } else {
                  StringBuilder var27 = new StringBuilder();
                  var27.append("Received and will skip rendering for an unidentified creative: ");
                  var27.append(var24);
                  this.d(var27.toString());
               }
            }
         }
      }
   }
}
