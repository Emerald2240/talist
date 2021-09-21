package com.iab.omid.library.adfalcon.adsession.video;

import com.iab.omid.library.adfalcon.d.c;
import com.iab.omid.library.adfalcon.d.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class VastProperties {
   private static final String TAG = "VastProperties: ";
   private final boolean isAutoPlay;
   private final boolean isSkippable;
   private final Position position;
   private final Float skipOffset;

   private VastProperties(boolean var1, Float var2, boolean var3, Position var4) {
      this.isSkippable = var1;
      this.skipOffset = var2;
      this.isAutoPlay = var3;
      this.position = var4;
   }

   public static VastProperties createVastPropertiesForNonSkippableVideo(boolean var0, Position var1) {
      e.a((Object)var1, "Position is null");
      return new VastProperties(false, (Float)null, var0, var1);
   }

   public static VastProperties createVastPropertiesForSkippableVideo(float var0, boolean var1, Position var2) {
      e.a((Object)var2, "Position is null");
      return new VastProperties(true, var0, var1, var2);
   }

   JSONObject toJSON() {
      JSONObject var1 = new JSONObject();

      JSONException var10000;
      label37: {
         boolean var10001;
         boolean var4;
         try {
            var1.put("skippable", this.isSkippable);
            var4 = this.isSkippable;
         } catch (JSONException var8) {
            var10000 = var8;
            var10001 = false;
            break label37;
         }

         if (var4) {
            try {
               var1.put("skipOffset", this.skipOffset);
            } catch (JSONException var7) {
               var10000 = var7;
               var10001 = false;
               break label37;
            }
         }

         try {
            var1.put("autoPlay", this.isAutoPlay);
         } catch (JSONException var6) {
            var10000 = var6;
            var10001 = false;
            break label37;
         }

         try {
            var1.put("position", this.position);
            return var1;
         } catch (JSONException var5) {
            var10000 = var5;
            var10001 = false;
         }
      }

      JSONException var2 = var10000;
      c.a("VastProperties: JSON error", var2);
      return var1;
   }
}
