package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public final class q extends h {
   private static final Paint d = new Paint(1);
   private static final Paint e = new Paint(1);
   private float c = 1.0F;

   public q(com.applovin.impl.sdk.j var1, Context var2) {
      super(var1, var2);
      d.setARGB(80, 0, 0, 0);
      e.setColor(-1);
      e.setStyle(Style.STROKE);
   }

   public void a(int var1) {
      this.setViewScale((float)var1 / 30.0F);
   }

   protected float getCenter() {
      return this.getSize() / 2.0F;
   }

   protected float getCrossOffset() {
      return 8.0F * this.c;
   }

   protected float getInnerCircleOffset() {
      return 2.0F * this.c;
   }

   protected float getInnerCircleRadius() {
      return this.getCenter() - this.getInnerCircleOffset();
   }

   protected float getSize() {
      return 30.0F * this.c;
   }

   protected float getStrokeWidth() {
      return 2.0F * this.c;
   }

   public h.a getStyle() {
      return h.a.b;
   }

   public float getViewScale() {
      return this.c;
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      float var2 = this.getCenter();
      var1.drawCircle(var2, var2, var2, d);
      float var3 = this.getCrossOffset();
      float var4 = this.getSize() - var3;
      e.setStrokeWidth(this.getStrokeWidth());
      var1.drawLine(var3, var3, var4, var4, e);
      var1.drawLine(var3, var4, var4, var3, e);
   }

   public void setViewScale(float var1) {
      this.c = var1;
   }
}
