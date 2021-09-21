package com.noqoush.adfalcon.android.sdk.nativead.assets;

import android.view.View;
import android.widget.ImageView;
import com.noqoush.adfalcon.android.sdk.response.h;

public class d extends a {
   public static final String j = "I";
   private static final String k = "R_NILA";
   private static final String l = "R_NIH";
   private static final String m = "R_NIW";
   private ImageView g;
   private int h;
   private int i;

   public d(int var1, int var2, int var3) throws Exception {
      super(var1, 1, "I", "icon");
      this.d(var2);
      this.c(var3);
   }

   public void a(ImageView var1) {
      this.g = var1;
   }

   public void a(com.noqoush.adfalcon.android.sdk.conn.c var1) {
      super.a(var1);
      StringBuilder var2 = new StringBuilder();
      var2.append("");
      var2.append(this.g());
      var1.b("R_NIW", var2.toString());
      StringBuilder var5 = new StringBuilder();
      var5.append("");
      var5.append(this.f());
      var1.b("R_NIH", var5.toString());
      var1.b("R_NILA", "true");
   }

   public boolean a(View var1, com.noqoush.adfalcon.android.sdk.response.f var2) {
      try {
         h var4 = (h)var2;
         ImageView var5 = (ImageView)var1.findViewById(this.d());
         com.noqoush.adfalcon.android.sdk.images.c.a().a(var4.e(), var5);
         return true;
      } catch (Exception var6) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var6);
         return false;
      }
   }

   public void c(int var1) {
      this.i = var1;
   }

   public void d(int var1) {
      this.h = var1;
   }

   public ImageView e() {
      return this.g;
   }

   public int f() {
      return this.i;
   }

   public int g() {
      return this.h;
   }
}
