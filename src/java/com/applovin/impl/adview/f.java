package com.applovin.impl.adview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class f extends View {
   private static final int s = Color.rgb(66, 145, 241);
   private static final int t = Color.rgb(66, 145, 241);
   private static final int u = Color.rgb(66, 145, 241);
   protected Paint a;
   protected Paint b;
   private Paint c;
   private Paint d;
   private RectF e;
   private float f;
   private int g;
   private int h;
   private int i;
   private int j;
   private int k;
   private float l;
   private int m;
   private String n;
   private String o;
   private float p;
   private String q;
   private float r;
   private final float v;
   private final float w;
   private final float x;
   private final int y;

   public f(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public f(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public f(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.e = new RectF();
      this.i = 0;
      this.n = "";
      this.o = "";
      this.q = "";
      this.w = f.a.d(this.getResources(), 14.0F);
      this.y = (int)f.a.c(this.getResources(), 100.0F);
      this.v = f.a.c(this.getResources(), 4.0F);
      this.x = f.a.d(this.getResources(), 18.0F);
      this.b();
      this.a();
   }

   private int a(int var1) {
      int var2 = MeasureSpec.getMode(var1);
      int var3 = MeasureSpec.getSize(var1);
      if (var2 == 1073741824) {
         return var3;
      } else {
         int var4 = this.y;
         return var2 == Integer.MIN_VALUE ? Math.min(var4, var3) : var4;
      }
   }

   private float getProgressAngle() {
      return 360.0F * ((float)this.getProgress() / (float)this.j);
   }

   protected void a() {
      this.a = new TextPaint();
      this.a.setColor(this.g);
      this.a.setTextSize(this.f);
      this.a.setAntiAlias(true);
      this.b = new TextPaint();
      this.b.setColor(this.h);
      this.b.setTextSize(this.p);
      this.b.setAntiAlias(true);
      this.c = new Paint();
      this.c.setColor(this.k);
      this.c.setStyle(Style.STROKE);
      this.c.setAntiAlias(true);
      this.c.setStrokeWidth(this.l);
      this.d = new Paint();
      this.d.setColor(this.m);
      this.d.setAntiAlias(true);
   }

   protected void b() {
      this.k = s;
      this.g = t;
      this.f = this.w;
      this.setMax(100);
      this.setProgress(0);
      this.l = this.v;
      this.m = 0;
      this.p = this.x;
      this.h = u;
   }

   public int getFinishedStrokeColor() {
      return this.k;
   }

   public float getFinishedStrokeWidth() {
      return this.l;
   }

   public int getInnerBackgroundColor() {
      return this.m;
   }

   public String getInnerBottomText() {
      return this.q;
   }

   public int getInnerBottomTextColor() {
      return this.h;
   }

   public float getInnerBottomTextSize() {
      return this.p;
   }

   public int getMax() {
      return this.j;
   }

   public String getPrefixText() {
      return this.n;
   }

   public int getProgress() {
      return this.i;
   }

   public String getSuffixText() {
      return this.o;
   }

   public int getTextColor() {
      return this.g;
   }

   public float getTextSize() {
      return this.f;
   }

   public void invalidate() {
      this.a();
      super.invalidate();
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      float var2 = this.l;
      this.e.set(var2, var2, (float)this.getWidth() - var2, (float)this.getHeight() - var2);
      float var3 = (float)this.getWidth();
      float var4 = this.l;
      float var5 = (var4 + (var3 - var4)) / 2.0F;
      var1.drawCircle((float)this.getWidth() / 2.0F, (float)this.getHeight() / 2.0F, var5, this.d);
      var1.drawArc(this.e, 270.0F, -this.getProgressAngle(), false, this.c);
      StringBuilder var6 = new StringBuilder();
      var6.append(this.n);
      var6.append(this.i);
      var6.append(this.o);
      String var10 = var6.toString();
      if (!TextUtils.isEmpty(var10)) {
         float var12 = this.a.descent() + this.a.ascent();
         var1.drawText(var10, ((float)this.getWidth() - this.a.measureText(var10)) / 2.0F, ((float)this.getWidth() - var12) / 2.0F, this.a);
      }

      if (!TextUtils.isEmpty(this.getInnerBottomText())) {
         this.b.setTextSize(this.p);
         float var11 = (float)this.getHeight() - this.r - (this.a.descent() + this.a.ascent()) / 2.0F;
         var1.drawText(this.getInnerBottomText(), ((float)this.getWidth() - this.b.measureText(this.getInnerBottomText())) / 2.0F, var11, this.b);
      }

   }

   protected void onMeasure(int var1, int var2) {
      this.setMeasuredDimension(this.a(var1), this.a(var2));
      this.r = (float)(this.getHeight() - 3 * this.getHeight() / 4);
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if (var1 instanceof Bundle) {
         Bundle var2 = (Bundle)var1;
         this.g = var2.getInt("text_color");
         this.f = var2.getFloat("text_size");
         this.p = var2.getFloat("inner_bottom_text_size");
         this.q = var2.getString("inner_bottom_text");
         this.h = var2.getInt("inner_bottom_text_color");
         this.k = var2.getInt("finished_stroke_color");
         this.l = var2.getFloat("finished_stroke_width");
         this.m = var2.getInt("inner_background_color");
         this.a();
         this.setMax(var2.getInt("max"));
         this.setProgress(var2.getInt("progress"));
         this.n = var2.getString("prefix");
         this.o = var2.getString("suffix");
         super.onRestoreInstanceState(var2.getParcelable("saved_instance"));
      } else {
         super.onRestoreInstanceState(var1);
      }
   }

   protected Parcelable onSaveInstanceState() {
      Bundle var1 = new Bundle();
      var1.putParcelable("saved_instance", super.onSaveInstanceState());
      var1.putInt("text_color", this.getTextColor());
      var1.putFloat("text_size", this.getTextSize());
      var1.putFloat("inner_bottom_text_size", this.getInnerBottomTextSize());
      var1.putFloat("inner_bottom_text_color", (float)this.getInnerBottomTextColor());
      var1.putString("inner_bottom_text", this.getInnerBottomText());
      var1.putInt("inner_bottom_text_color", this.getInnerBottomTextColor());
      var1.putInt("finished_stroke_color", this.getFinishedStrokeColor());
      var1.putInt("max", this.getMax());
      var1.putInt("progress", this.getProgress());
      var1.putString("suffix", this.getSuffixText());
      var1.putString("prefix", this.getPrefixText());
      var1.putFloat("finished_stroke_width", this.getFinishedStrokeWidth());
      var1.putInt("inner_background_color", this.getInnerBackgroundColor());
      return var1;
   }

   public void setFinishedStrokeColor(int var1) {
      this.k = var1;
      this.invalidate();
   }

   public void setFinishedStrokeWidth(float var1) {
      this.l = var1;
      this.invalidate();
   }

   public void setInnerBackgroundColor(int var1) {
      this.m = var1;
      this.invalidate();
   }

   public void setInnerBottomText(String var1) {
      this.q = var1;
      this.invalidate();
   }

   public void setInnerBottomTextColor(int var1) {
      this.h = var1;
      this.invalidate();
   }

   public void setInnerBottomTextSize(float var1) {
      this.p = var1;
      this.invalidate();
   }

   public void setMax(int var1) {
      if (var1 > 0) {
         this.j = var1;
         this.invalidate();
      }

   }

   public void setPrefixText(String var1) {
      this.n = var1;
      this.invalidate();
   }

   public void setProgress(int var1) {
      this.i = var1;
      if (this.i > this.getMax()) {
         this.i %= this.getMax();
      }

      this.invalidate();
   }

   public void setSuffixText(String var1) {
      this.o = var1;
      this.invalidate();
   }

   public void setTextColor(int var1) {
      this.g = var1;
      this.invalidate();
   }

   public void setTextSize(float var1) {
      this.f = var1;
      this.invalidate();
   }

   private static class a {
      private static float c(Resources var0, float var1) {
         return 0.5F + var1 * var0.getDisplayMetrics().density;
      }

      private static float d(Resources var0, float var1) {
         return var1 * var0.getDisplayMetrics().scaledDensity;
      }
   }
}
