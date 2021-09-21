package com.noqoush.adfalcon.android.sdk.nativead.assets;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.noqoush.adfalcon.android.sdk.response.g;

public class c extends a {
   private TextView g;
   private int h;

   public c(int var1, int var2, int var3) throws Exception {
      super(var1, 0, d(var2), e(var2));
      this.c(var3);
   }

   private static String d(int var0) {
      StringBuilder var1 = new StringBuilder();
      var1.append("D");
      var1.append(var0);
      return var1.toString();
   }

   private static String e(int var0) {
      StringBuilder var1 = new StringBuilder();
      var1.append("d.");
      var1.append(var0);
      return var1.toString();
   }

   public void a(TextView var1) {
      this.g = var1;
   }

   public void a(com.noqoush.adfalcon.android.sdk.conn.c var1) {
      super.a(var1);
      String var2 = d(3);
      if (this.e() > 0 && this.a().toLowerCase().equalsIgnoreCase(var2)) {
         Object[] var3 = new Object[]{this.a()};
         String var4 = String.format("R_N%sML", var3);
         StringBuilder var5 = new StringBuilder();
         var5.append("");
         var5.append(this.e());
         var1.b(var4, var5.toString());
      }

   }

   public boolean a(View var1, com.noqoush.adfalcon.android.sdk.response.f var2) {
      try {
         g var4 = (g)var2;
         View var5 = var1.findViewById(this.d());
         if (var5 instanceof TextView) {
            ((TextView)var5).setText(var4.c());
            return true;
         } else if (var5 instanceof ImageView) {
            com.noqoush.adfalcon.android.sdk.images.c.a().a(var4.c(), (ImageView)var5);
            return true;
         } else if (var5 instanceof RatingBar) {
            RatingBar var6 = (RatingBar)var5;
            var6.setIsIndicator(true);
            var6.setStepSize(0.1F);
            var6.setNumStars(5);
            var6.setRating(Float.parseFloat(var4.c()));
            return true;
         } else {
            if (var5 instanceof Button) {
               ((Button)var5).setText(var4.c());
            }

            return true;
         }
      } catch (Exception var7) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var7);
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
