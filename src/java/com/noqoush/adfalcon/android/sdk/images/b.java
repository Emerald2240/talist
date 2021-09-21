package com.noqoush.adfalcon.android.sdk.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.noqoush.adfalcon.android.sdk.R;

public class b {
   public Bitmap a(Context var1) throws Exception {
      return BitmapFactory.decodeResource(var1.getResources(), R.drawable.audio_bg);
   }

   public Bitmap a(a var1, Context var2) throws Exception {
      Resources var3 = var2.getResources();
      StringBuilder var4 = new StringBuilder();
      var4.append("back_icon_");
      var4.append(var1.toString());
      int var7 = var3.getIdentifier(var4.toString(), "drawable", var2.getPackageName());
      return BitmapFactory.decodeResource(var2.getResources(), var7);
   }

   public Bitmap b(Context var1) throws Exception {
      return BitmapFactory.decodeResource(var1.getResources(), R.drawable.close_icon_interstitial);
   }

   public Bitmap b(a var1, Context var2) throws Exception {
      Resources var3 = var2.getResources();
      StringBuilder var4 = new StringBuilder();
      var4.append("browser_icon_");
      var4.append(var1.toString());
      int var7 = var3.getIdentifier(var4.toString(), "drawable", var2.getPackageName());
      return BitmapFactory.decodeResource(var2.getResources(), var7);
   }

   public Bitmap c(a var1, Context var2) throws Exception {
      Resources var3 = var2.getResources();
      StringBuilder var4 = new StringBuilder();
      var4.append("close_icon_");
      var4.append(var1.toString());
      int var7 = var3.getIdentifier(var4.toString(), "drawable", var2.getPackageName());
      return BitmapFactory.decodeResource(var2.getResources(), var7);
   }

   public Bitmap d(a var1, Context var2) throws Exception {
      Resources var3 = var2.getResources();
      StringBuilder var4 = new StringBuilder();
      var4.append("forward_icon_");
      var4.append(var1.toString());
      int var7 = var3.getIdentifier(var4.toString(), "drawable", var2.getPackageName());
      return BitmapFactory.decodeResource(var2.getResources(), var7);
   }

   public Bitmap e(a var1, Context var2) throws Exception {
      Resources var3 = var2.getResources();
      StringBuilder var4 = new StringBuilder();
      var4.append("refresh_icon_");
      var4.append(var1.toString());
      int var7 = var3.getIdentifier(var4.toString(), "drawable", var2.getPackageName());
      return BitmapFactory.decodeResource(var2.getResources(), var7);
   }

   public Bitmap f(a var1, Context var2) throws Exception {
      Resources var3 = var2.getResources();
      StringBuilder var4 = new StringBuilder();
      var4.append("stop_icon_");
      var4.append(var1.toString());
      int var7 = var3.getIdentifier(var4.toString(), "drawable", var2.getPackageName());
      return BitmapFactory.decodeResource(var2.getResources(), var7);
   }
}
