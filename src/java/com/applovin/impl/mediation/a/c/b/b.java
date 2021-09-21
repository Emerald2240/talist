package com.applovin.impl.mediation.a.c.b;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.applovin.impl.mediation.a.a.c;
import com.applovin.impl.mediation.a.a.d;
import com.applovin.impl.mediation.a.a.e;
import com.applovin.impl.mediation.a.a.g;
import com.applovin.impl.sdk.utils.f;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b extends com.applovin.impl.mediation.a.c.a {
   private final c c = new g("INTEGRATIONS");
   private final c d = new g("PERMISSIONS");
   private final c e = new g("CONFIGURATION");
   private final c f = new g("DEPENDENCIES");
   private final c g = new g("");
   private SpannedString h;
   private b.a i;

   b(d var1, Context var2) {
      super(var2);
      if (var1.a() == d.a.c) {
         SpannableString var3 = new SpannableString("Tap for more information");
         var3.setSpan(new AbsoluteSizeSpan(12, true), 0, var3.length(), 33);
         this.h = new SpannedString(var3);
      } else {
         this.h = new SpannedString("");
      }

      this.b.add(this.c);
      this.b.add(this.a(var1));
      this.b.add(this.b(var1));
      this.b.addAll(this.a(var1.i()));
      this.b.addAll(this.a(var1.k()));
      this.b.addAll(this.b(var1.j()));
      this.b.add(this.g);
   }

   private int a(boolean var1) {
      return var1 ? R.drawable.applovin_ic_check_mark : R.drawable.applovin_ic_x_mark;
   }

   private int b(boolean var1) {
      int var2;
      if (var1) {
         var2 = R.color.applovin_sdk_checkmarkColor;
      } else {
         var2 = R.color.applovin_sdk_xmarkColor;
      }

      return com.applovin.impl.sdk.utils.f.a(var2, this.a);
   }

   public c a(d var1) {
      com.applovin.impl.mediation.a.c.b.a.a.a var2 = com.applovin.impl.mediation.a.c.b.a.a.j().a("SDK").b(var1.f());
      c.a var3;
      if (TextUtils.isEmpty(var1.f())) {
         var3 = c.a.c;
      } else {
         var3 = c.a.d;
      }

      com.applovin.impl.mediation.a.c.b.a.a.a var4 = var2.a(var3);
      if (TextUtils.isEmpty(var1.f())) {
         var4.a(this.a(var1.b())).b(this.b(var1.b()));
      }

      return var4.a();
   }

   public List a(e var1) {
      ArrayList var2 = new ArrayList(2);
      if (var1.a()) {
         boolean var3 = var1.b();
         var2.add(this.e);
         com.applovin.impl.mediation.a.c.b.a.a.a var5 = com.applovin.impl.mediation.a.c.b.a.a.j().a("Cleartext Traffic");
         SpannedString var6;
         if (var3) {
            var6 = null;
         } else {
            var6 = this.h;
         }

         var2.add(var5.a(var6).c(var1.c()).a(this.a(var3)).b(this.b(var3)).a(var3 ^ true).a());
      }

      return var2;
   }

   public List a(List var1) {
      ArrayList var2 = new ArrayList(1 + var1.size());
      if (var1.size() > 0) {
         var2.add(this.d);

         SpannedString var8;
         com.applovin.impl.mediation.a.a.f var5;
         com.applovin.impl.mediation.a.c.b.a.a.a var7;
         boolean var6;
         for(Iterator var4 = var1.iterator(); var4.hasNext(); var2.add(var7.a(var8).c(var5.b()).a(this.a(var6)).b(this.b(var6)).a(var6 ^ true).a())) {
            var5 = (com.applovin.impl.mediation.a.a.f)var4.next();
            var6 = var5.c();
            var7 = com.applovin.impl.mediation.a.c.b.a.a.j().a(var5.a());
            if (var6) {
               var8 = null;
            } else {
               var8 = this.h;
            }
         }
      }

      return var2;
   }

   protected void a(c var1) {
      if (this.i != null && var1 instanceof com.applovin.impl.mediation.a.c.b.a.a) {
         String var2 = ((com.applovin.impl.mediation.a.c.b.a.a)var1).i();
         if (!TextUtils.isEmpty(var2)) {
            this.i.a(var2);
         }
      }

   }

   public void a(b.a var1) {
      this.i = var1;
   }

   public c b(d var1) {
      com.applovin.impl.mediation.a.c.b.a.a.a var2 = com.applovin.impl.mediation.a.c.b.a.a.j().a("Adapter").b(var1.g());
      c.a var3;
      if (TextUtils.isEmpty(var1.g())) {
         var3 = c.a.c;
      } else {
         var3 = c.a.d;
      }

      com.applovin.impl.mediation.a.c.b.a.a.a var4 = var2.a(var3);
      if (TextUtils.isEmpty(var1.g())) {
         var4.a(this.a(var1.c())).b(this.b(var1.c()));
      }

      return var4.a();
   }

   public List b(List var1) {
      ArrayList var2 = new ArrayList(1 + var1.size());
      if (var1.size() > 0) {
         var2.add(this.f);

         SpannedString var8;
         com.applovin.impl.mediation.a.a.a var5;
         com.applovin.impl.mediation.a.c.b.a.a.a var7;
         boolean var6;
         for(Iterator var4 = var1.iterator(); var4.hasNext(); var2.add(var7.a(var8).c(var5.b()).a(this.a(var6)).b(this.b(var6)).a(var6 ^ true).a())) {
            var5 = (com.applovin.impl.mediation.a.a.a)var4.next();
            var6 = var5.c();
            var7 = com.applovin.impl.mediation.a.c.b.a.a.j().a(var5.a());
            if (var6) {
               var8 = null;
            } else {
               var8 = this.h;
            }
         }
      }

      return var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MediatedNetworkListAdapter{listItems=");
      var1.append(this.b);
      var1.append("}");
      return var1.toString();
   }

   public interface a {
      void a(String var1);
   }
}
