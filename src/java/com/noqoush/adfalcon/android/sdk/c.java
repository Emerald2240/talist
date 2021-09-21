package com.noqoush.adfalcon.android.sdk;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

class c extends RelativeLayout {
   private x a;
   int b = 0;
   int c = 0;

   public c(Activity var1) {
      super(var1);
   }

   public c(Context var1) {
      super(var1);
   }

   public c(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public c(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   private x b() {
      return this.a;
   }

   public ADFListener a() {
      return this.b().i();
   }

   public void a(ADFListener var1) {
      this.b().a(var1);
   }

   protected void a(x var1) {
      this.a = var1;
   }
}
