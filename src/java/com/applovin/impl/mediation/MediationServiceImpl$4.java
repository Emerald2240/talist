package com.applovin.impl.mediation;

import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;

class MediationServiceImpl$4 implements MaxSignalCollectionListener {
   // $FF: synthetic field
   final com.applovin.impl.mediation.b.f.a a;
   // $FF: synthetic field
   final com.applovin.impl.mediation.b.g b;
   // $FF: synthetic field
   final i c;
   // $FF: synthetic field
   final MediationServiceImpl d;

   MediationServiceImpl$4(MediationServiceImpl var1, com.applovin.impl.mediation.b.f.a var2, com.applovin.impl.mediation.b.g var3, i var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public void onSignalCollected(String var1) {
      this.a.a(com.applovin.impl.mediation.b.f.a(this.b, this.c, var1));
   }

   public void onSignalCollectionFailed(String var1) {
      MediationServiceImpl.a(this.d, var1, this.b);
      this.a.a(com.applovin.impl.mediation.b.f.b(this.b, this.c, var1));
   }
}
