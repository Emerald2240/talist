package com.applovin.impl.mediation;

import android.os.SystemClock;
import com.applovin.mediation.adapter.MaxAdapter;

class i$1$1$2 implements Runnable {
   // $FF: synthetic field
   final MaxAdapter.InitializationStatus a;
   // $FF: synthetic field
   final String b;
   // $FF: synthetic field
   final i$1$1 c;

   i$1$1$2(i$1$1 var1, MaxAdapter.InitializationStatus var2, String var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void run() {
      long var1 = SystemClock.elapsedRealtime() - this.c.a;
      i.b(this.c.b.c).x().a(i.a(this.c.b.c), var1, this.a, this.b);
   }
}
