package com.applovin.impl.adview;

import android.content.Context;

public final class o extends h {
   private float c = 1.0F;

   public o(com.applovin.impl.sdk.j var1, Context var2) {
      super(var1, var2);
   }

   public void a(int var1) {
      this.setViewScale((float)var1 / 30.0F);
   }

   public h.a getStyle() {
      return h.a.c;
   }

   public float getViewScale() {
      return this.c;
   }

   public void setViewScale(float var1) {
      this.c = var1;
   }
}
