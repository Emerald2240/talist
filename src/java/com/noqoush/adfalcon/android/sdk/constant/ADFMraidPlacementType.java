package com.noqoush.adfalcon.android.sdk.constant;

public enum ADFMraidPlacementType {
   INLINE,
   INTERSTITIAL;

   static {
      ADFMraidPlacementType var0 = new ADFMraidPlacementType("INTERSTITIAL", 1);
      INTERSTITIAL = var0;
      ADFMraidPlacementType[] var1 = new ADFMraidPlacementType[]{INLINE, var0};
   }
}
