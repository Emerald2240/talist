package com.noqoush.adfalcon.android.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class r extends BroadcastReceiver {
   public static boolean b;
   private ADFView a;

   public r(ADFView var1) {
      this.a = var1;
   }

   public void onReceive(Context var1, Intent var2) {
      try {
         if (var2.getAction().equals("android.intent.action.SCREEN_OFF")) {
            k.c("ACTION_SCREEN_OFF");
            x.i(false);
            this.a.a();
            return;
         }

         if (var2.getAction().equals("android.intent.action.SCREEN_ON")) {
            k.c("ACTION_SCREEN_ON");
            x.i(true);
            this.a.b();
            return;
         }
      } catch (Exception var4) {
      }

   }
}
