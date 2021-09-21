package com.noqoush.adfalcon.android.sdk.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;

public class f {
   public static int a() {
      int var10000 = VERSION.SDK_INT;
      return -1;
   }

   public static ProgressBar a(Context var0, int var1) throws Exception {
      ProgressBar var2 = new ProgressBar(var0, (AttributeSet)null, var1);
      LayoutParams var3;
      if (var1 == 16842872) {
         var3 = new LayoutParams(a(), -2);
      } else {
         var3 = new LayoutParams(-2, -2);
         var3.addRule(13);
      }

      var3.setMargins(0, 0, 0, 0);
      var2.setPadding(0, 0, 0, 0);
      var2.setLayoutParams(var3);
      var2.setVisibility(4);
      var2.setMax(100);
      var2.setProgress(0);
      return var2;
   }

   public static void a(Context var0, View var1, Object var2) {
      if (var2 instanceof Drawable) {
         if (VERSION.SDK_INT < 16) {
            var1.setBackgroundDrawable((Drawable)var2);
         } else {
            var1.setBackground((Drawable)var2);
         }
      } else if (var2 instanceof Bitmap) {
         BitmapDrawable var3 = new BitmapDrawable(var0.getResources(), (Bitmap)var2);
         if (VERSION.SDK_INT < 16) {
            var1.setBackgroundDrawable(var3);
         } else {
            var1.setBackground(var3);
         }
      } else {
         if (var2 instanceof Integer) {
            var1.setBackgroundColor((Integer)var2);
         }

      }
   }

   public static boolean a(Context var0, KeyEvent var1) {
      if (var1.getKeyCode() == 25 && var1.getAction() == 1) {
         AudioManager var5 = (AudioManager)var0.getSystemService("audio");
         int var6 = var5.getStreamVolume(3) - 1;
         if (var6 < 0) {
            var6 = 0;
         }

         var5.setStreamVolume(3, var6, 0);
         return true;
      } else if (var1.getKeyCode() == 24 && var1.getAction() == 1) {
         AudioManager var2 = (AudioManager)var0.getSystemService("audio");
         int var3 = 1 + var2.getStreamVolume(3);
         int var4 = var2.getStreamMaxVolume(3);
         if (var3 > var4) {
            var3 = var4;
         }

         var2.setStreamVolume(3, var3, 0);
         return true;
      } else if (var1.getKeyCode() == 164 && var1.getAction() == 1) {
         ((AudioManager)var0.getSystemService("audio")).setStreamMute(3, true);
         return true;
      } else {
         return false;
      }
   }

   public static Drawable b() {
      ShapeDrawable var0 = new ShapeDrawable(new OvalShape());
      var0.getPaint().setColor(Color.argb(127, 255, 255, 255));
      var0.setPadding(5, 5, 5, 5);
      return var0;
   }
}
