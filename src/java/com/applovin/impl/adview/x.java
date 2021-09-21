package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public final class x extends h {
   private static final Paint d = new Paint(1);
   private static final Paint e = new Paint(1);
   private static final Paint f = new Paint(1);
   private float c = 1.0F;

   public x(com.applovin.impl.sdk.j var1, Context var2) {
      super(var1, var2);
      d.setColor(-1);
      e.setColor(-16777216);
      f.setColor(-1);
      f.setStyle(Style.STROKE);
   }

   public void a(int var1) {
      this.setViewScale((float)var1 / 30.0F);
   }

   protected float getCenter() {
      return this.getSize() / 2.0F;
   }

   protected float getCrossOffset() {
      return 10.0F * this.c;
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
      return 3.0F * this.c;
   }

   public h.a getStyle() {
      return h.a.a;
   }

   public float getViewScale() {
      return this.c;
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      float var2 = this.getCenter();
      var1.drawCircle(var2, var2, var2, d);
      var1.drawCircle(var2, var2, this.getInnerCircleRadius(), e);
      float var3 = this.getCrossOffset();
      float var4 = this.getSize() - var3;
      f.setStrokeWidth(this.getStrokeWidth());
      var1.drawLine(var3, var3, var4, var4, f);
      var1.drawLine(var3, var4, var4, var3, f);
   }

   public void setViewScale(float var1) {
      this.c = var1;
   }
}
