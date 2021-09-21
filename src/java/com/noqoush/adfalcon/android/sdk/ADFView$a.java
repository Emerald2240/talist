package com.noqoush.adfalcon.android.sdk;

import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;

class ADFView$a implements Runnable {
   // $FF: synthetic field
   final Exception a;
   // $FF: synthetic field
   final ADFView b;

   ADFView$a(ADFView var1, Exception var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      try {
         this.b.getListener().onError(this.b, ADFErrorCode.GENERIC_SDK_ERROR, this.a.getMessage());
      } catch (Exception var2) {
      }
   }
}
