package com.iab.omid.library.adfalcon.adsession;

import android.view.View;
import com.iab.omid.library.adfalcon.d.e;
import com.iab.omid.library.adfalcon.publisher.AdSessionStatePublisher;

public abstract class AdSession {
   public static AdSession createAdSession(AdSessionConfiguration var0, AdSessionContext var1) {
      e.a();
      e.a((Object)var0, "AdSessionConfiguration is null");
      e.a((Object)var1, "AdSessionContext is null");
      return new a(var0, var1);
   }

   public abstract void addFriendlyObstruction(View var1);

   public abstract void error(ErrorType var1, String var2);

   public abstract void finish();

   public abstract String getAdSessionId();

   public abstract AdSessionStatePublisher getAdSessionStatePublisher();

   public abstract void registerAdView(View var1);

   public abstract void removeAllFriendlyObstructions();

   public abstract void removeFriendlyObstruction(View var1);

   public abstract void start();
}
