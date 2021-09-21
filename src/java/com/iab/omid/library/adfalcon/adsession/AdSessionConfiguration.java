package com.iab.omid.library.adfalcon.adsession;

import com.iab.omid.library.adfalcon.d.b;
import com.iab.omid.library.adfalcon.d.e;
import org.json.JSONObject;

public class AdSessionConfiguration {
   private final Owner impressionOwner;
   private final boolean isolateVerificationScripts;
   private final Owner videoEventsOwner;

   private AdSessionConfiguration(Owner var1, Owner var2, boolean var3) {
      this.impressionOwner = var1;
      if (var2 == null) {
         this.videoEventsOwner = Owner.NONE;
      } else {
         this.videoEventsOwner = var2;
      }

      this.isolateVerificationScripts = var3;
   }

   @Deprecated
   public static AdSessionConfiguration createAdSessionConfiguration(Owner var0, Owner var1) {
      return createAdSessionConfiguration(var0, var1, true);
   }

   public static AdSessionConfiguration createAdSessionConfiguration(Owner var0, Owner var1, boolean var2) {
      e.a((Object)var0, "Impression owner is null");
      e.a(var0);
      return new AdSessionConfiguration(var0, var1, var2);
   }

   public boolean isNativeImpressionOwner() {
      return Owner.NATIVE == this.impressionOwner;
   }

   public boolean isNativeVideoEventsOwner() {
      return Owner.NATIVE == this.videoEventsOwner;
   }

   public JSONObject toJsonObject() {
      JSONObject var1 = new JSONObject();
      b.a(var1, "impressionOwner", this.impressionOwner);
      b.a(var1, "videoEventsOwner", this.videoEventsOwner);
      b.a(var1, "isolateVerificationScripts", this.isolateVerificationScripts);
      return var1;
   }
}
