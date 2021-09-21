package com.iab.omid.library.adfalcon.adsession;

import com.iab.omid.library.adfalcon.d.e;

public final class AdEvents {
   private final a adSession;

   private AdEvents(a var1) {
      this.adSession = var1;
   }

   public static AdEvents createAdEvents(AdSession var0) {
      a var1 = (a)var0;
      e.a((Object)var0, "AdSession is null");
      e.d(var1);
      e.b(var1);
      AdEvents var2 = new AdEvents(var1);
      var1.getAdSessionStatePublisher().a(var2);
      return var2;
   }

   public void impressionOccurred() {
      e.b(this.adSession);
      e.f(this.adSession);
      if (!this.adSession.d()) {
         try {
            this.adSession.start();
         } catch (Exception var2) {
         }
      }

      if (this.adSession.d()) {
         this.adSession.b();
      }

   }
}
