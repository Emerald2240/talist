package com.noqoush.adfalcon.android.sdk.handler;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.noqoush.adfalcon.android.sdk.w;
import com.noqoush.adfalcon.android.sdk.z;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public class a implements OnClickListener {
   private b a;
   private WeakReference b;
   private long c;
   private int d = 0;
   private String e;

   public a(b var1) {
      this.a = var1;
      this.b((new z(var1.d())).getSettings().getUserAgentString());
   }

   public a(b var1, w var2) {
      this.a = var1;
      this.b((new z(var1.d())).getSettings().getUserAgentString());
      this.b = new WeakReference(var2);
   }

   private boolean a(String param1) {
      // $FF: Couldn't be decompiled
   }

   private void b(String var1) {
      this.e = var1;
   }

   private boolean d() throws Exception {
      if (this.b().b().g() != null) {
         Iterator var1 = this.b().b().g().a().iterator();

         while(var1.hasNext()) {
            if (!((com.noqoush.adfalcon.android.sdk.response.c)var1.next()).b()) {
               return false;
            }
         }
      }

      return true;
   }

   private String e() {
      return this.b().b().a().f();
   }

   private String f() {
      return this.e;
   }

   private void g() {
      // $FF: Couldn't be decompiled
   }

   public void a() {
      try {
         if (this.b().b().p != null && this.b().b().p.e().size() > 0) {
            (new com.noqoush.adfalcon.android.sdk.helper.c(this.b().b().p.e(), this.f())).a((com.noqoush.adfalcon.android.sdk.response.b)null, (String)null);
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public void a(b var1) {
      this.a = var1;
   }

   public b b() {
      return this.a;
   }

   public void c() throws Exception {
      String var1 = this.e();
      String var2 = this.b().b().a().c();
      String var3 = this.b().b().a().d();
      StringBuilder var4 = new StringBuilder();
      var4.append("Open Ad Action, type: ");
      var4.append(var1);
      var4.append(", url: ");
      var4.append(var2);
      var4.append(", fallback: ");
      var4.append(var3);
      com.noqoush.adfalcon.android.sdk.util.a.c(var4.toString());
      boolean var11 = this.a(var2);
      boolean var12 = true;
      if (!var11 && (var3 == null || !this.a(var3))) {
         var12 = false;
      }

      if (var12) {
         this.a();
      } else {
         Toast.makeText(this.b().d(), "Sorry, your device does not support this action", 0).show();
      }
   }

   public void onClick(View param1) {
      // $FF: Couldn't be decompiled
   }
}
