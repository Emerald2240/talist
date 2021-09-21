package com.noqoush.adfalcon.android.sdk.constant;

public enum ADFAdSize {
   AD_UNIT_120x600,
   AD_UNIT_300x250,
   AD_UNIT_320x50,
   AD_UNIT_468x60,
   AD_UNIT_728x90,
   AD_UNIT_AUTO_BANNER;

   static {
      ADFAdSize var0 = new ADFAdSize("AD_UNIT_120x600", 5);
      AD_UNIT_120x600 = var0;
      ADFAdSize[] var1 = new ADFAdSize[]{AD_UNIT_AUTO_BANNER, AD_UNIT_320x50, AD_UNIT_300x250, AD_UNIT_468x60, AD_UNIT_728x90, var0};
   }
}
