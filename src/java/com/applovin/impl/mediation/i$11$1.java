package com.applovin.impl.mediation;

import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;

class i$11$1 implements MaxSignalCollectionListener {
   // $FF: synthetic field
   final <undefinedtype> a;

   i$11$1(Object var1) {
      this.a = var1;
   }

   public void onSignalCollected(String var1) {
      i.a(this.a.f, var1, this.a.d);
   }

   public void onSignalCollectionFailed(String var1) {
      i.b(this.a.f, var1, this.a.d);
   }
}
