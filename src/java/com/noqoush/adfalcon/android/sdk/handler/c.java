package com.noqoush.adfalcon.android.sdk.handler;

import android.content.Context;
import android.webkit.WebView;
import com.noqoush.adfalcon.android.sdk.urlactions.e;
import com.noqoush.adfalcon.android.sdk.urlactions.f;
import com.noqoush.adfalcon.android.sdk.urlactions.g;
import com.noqoush.adfalcon.android.sdk.urlactions.h;
import com.noqoush.adfalcon.android.sdk.urlactions.j;
import com.noqoush.adfalcon.android.sdk.urlactions.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c {
   private final List a = new ArrayList();
   private final com.noqoush.adfalcon.android.sdk.urlactions.b b = new com.noqoush.adfalcon.android.sdk.urlactions.a();
   private final com.noqoush.adfalcon.android.sdk.urlactions.b c = new com.noqoush.adfalcon.android.sdk.urlactions.c();
   private final com.noqoush.adfalcon.android.sdk.urlactions.b d = new com.noqoush.adfalcon.android.sdk.urlactions.d();
   private final com.noqoush.adfalcon.android.sdk.urlactions.b e = new h();
   private final com.noqoush.adfalcon.android.sdk.urlactions.b f = new j();
   private final com.noqoush.adfalcon.android.sdk.urlactions.b g = new k();
   private final com.noqoush.adfalcon.android.sdk.urlactions.b h = new f();

   public c() {
      this.a.add(this.b);
      this.a.add(this.g);
      this.a.add(this.d);
      this.a.add(this.e);
      this.a.add(this.f);
      this.a.add(this.h);
      this.a.add(this.c);
   }

   public c(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7) {
      if (var1) {
         this.a.add(this.b);
      }

      if (var2) {
         this.a.add(this.g);
      }

      if (var3) {
         this.a.add(this.d);
      }

      if (var4) {
         this.a.add(this.e);
      }

      if (var5) {
         this.a.add(this.f);
      }

      if (var6) {
         this.a.add(this.h);
      }

      if (var7) {
         this.a.add(this.c);
      }

   }

   public boolean a(Context var1, String var2, boolean var3, boolean var4, g var5, WebView var6) {
      try {
         e var7 = new e(var2, var1, var3, var4, var5, var6);
         boolean var12 = this.a(var7);
         return var12;
      } catch (Exception var13) {
         StringBuilder var9 = new StringBuilder();
         var9.append("ADFUrlActionHandler->handleUrlAction: ");
         var9.append(var13.getMessage());
         com.noqoush.adfalcon.android.sdk.util.a.b(var9.toString());
         return false;
      }
   }

   public boolean a(e var1) {
      try {
         Iterator var6 = this.a.iterator();

         while(var6.hasNext()) {
            com.noqoush.adfalcon.android.sdk.urlactions.b var7 = (com.noqoush.adfalcon.android.sdk.urlactions.b)var6.next();
            if (var7.a(var1)) {
               boolean var8 = var7.b(var1);
               return var8;
            }
         }
      } catch (Exception var9) {
         StringBuilder var3 = new StringBuilder();
         var3.append("ADFUrlActionHandler->handleUrlAction: ");
         var3.append(var9.getMessage());
         com.noqoush.adfalcon.android.sdk.util.a.b(var3.toString());
      }

      return false;
   }
}
