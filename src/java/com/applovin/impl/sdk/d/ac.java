package com.applovin.impl.sdk.d;

public class ac extends a {
   private final Runnable a;

   public ac(com.applovin.impl.sdk.j var1, Runnable var2) {
      this(var1, false, var2);
   }

   public ac(com.applovin.impl.sdk.j var1, boolean var2, Runnable var3) {
      super("TaskRunnable", var1, var2);
      this.a = var3;
   }

   public com.applovin.impl.sdk.c.i a() {
      return com.applovin.impl.sdk.c.i.f;
   }

   public void run() {
      this.a.run();
   }
}
