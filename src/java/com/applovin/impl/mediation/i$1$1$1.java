package com.applovin.impl.mediation;

import android.os.SystemClock;
import com.applovin.mediation.adapter.MaxAdapter;

class i$1$1$1 implements Runnable {
   // $FF: synthetic field
   final i$1$1 a;

   i$1$1$1(i$1$1 var1) {
      this.a = var1;
   }

   public void run() {
      long var1 = SystemClock.elapsedRealtime() - this.a.a;
      i.b(this.a.b.c).x().a(i.a(this.a.b.c), var1, MaxAdapter.InitializationStatus.ADAPTER_NOT_SUPPORTED, (String)null);
   }
}
