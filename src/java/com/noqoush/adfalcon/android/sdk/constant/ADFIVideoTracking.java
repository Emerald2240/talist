package com.noqoush.adfalcon.android.sdk.constant;

public enum ADFIVideoTracking {
   closed,
   ended,
   loading,
   pause,
   playing;

   static {
      ADFIVideoTracking var0 = new ADFIVideoTracking("closed", 4);
      closed = var0;
      ADFIVideoTracking[] var1 = new ADFIVideoTracking[]{loading, playing, pause, ended, var0};
   }
}
