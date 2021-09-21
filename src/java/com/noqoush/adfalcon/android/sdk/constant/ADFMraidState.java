package com.noqoush.adfalcon.android.sdk.constant;

public enum ADFMraidState {
   DEFAULT,
   EXPANDED,
   HIDDEN,
   LOADING,
   RESIZED;

   static {
      ADFMraidState var0 = new ADFMraidState("HIDDEN", 4);
      HIDDEN = var0;
      ADFMraidState[] var1 = new ADFMraidState[]{LOADING, DEFAULT, RESIZED, EXPANDED, var0};
   }
}
