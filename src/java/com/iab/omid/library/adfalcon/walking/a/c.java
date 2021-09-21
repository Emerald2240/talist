package com.iab.omid.library.adfalcon.walking.a;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c implements b.a {
   private final BlockingQueue a = new LinkedBlockingQueue();
   private final ThreadPoolExecutor b;
   private final ArrayDeque c = new ArrayDeque();
   private b d = null;

   public c() {
      ThreadPoolExecutor var1 = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.a);
      this.b = var1;
   }

   private void a() {
      b var1 = (b)this.c.poll();
      this.d = var1;
      if (var1 != null) {
         var1.a(this.b);
      }

   }

   public void a(b var1) {
      this.d = null;
      this.a();
   }

   public void b(b var1) {
      var1.a((b.a)this);
      this.c.add(var1);
      if (this.d == null) {
         this.a();
      }

   }
}
