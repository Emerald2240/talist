package com.noqoush.adfalcon.android.sdk.nativead;

public enum ADFNativeAdStatus {
   clicked,
   failed,
   loaded,
   loading,
   none,
   shown;

   static {
      ADFNativeAdStatus var0 = new ADFNativeAdStatus("clicked", 5);
      clicked = var0;
      ADFNativeAdStatus[] var1 = new ADFNativeAdStatus[]{none, loading, loaded, shown, failed, var0};
   }
}
