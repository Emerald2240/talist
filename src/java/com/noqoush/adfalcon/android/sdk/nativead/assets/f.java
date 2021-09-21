package com.noqoush.adfalcon.android.sdk.nativead.assets;

import android.view.View;
import android.widget.TextView;
import com.noqoush.adfalcon.android.sdk.response.i;

public class f extends a {
   public static final String i = "T";
   private TextView g;
   private int h;

   public f(int var1, int var2) throws Exception {
      super(var1, 1, "T", "title");
      this.c(var2);
   }

   public void a(TextView var1) {
      this.g = var1;
   }

   public void a(com.noqoush.adfalcon.android.sdk.conn.c var1) {
      super.a(var1);
      if (this.e() > 0) {
         Object[] var2 = new Object[]{this.a()};
         String var3 = String.format("R_N%sML", var2);
         StringBuilder var4 = new StringBuilder();
         var4.append("");
         var4.append(this.e());
         var1.b(var3, var4.toString());
      }

   }

   public boolean a(View var1, com.noqoush.adfalcon.android.sdk.response.f var2) {
      try {
         i var4 = (i)var2;
         ((TextView)var1.findViewById(this.d())).setText(var4.b());
         return true;
      } catch (Exception var5) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var5);
         return false;
      }
   }

   public void c(int var1) {
      this.h = var1;
   }

   public int e() {
      return this.h;
   }

   public TextView f() {
      return this.g;
   }
}
