package com.noqoush.adfalcon.android.sdk.video.vast.manager;

import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.noqoush.adfalcon.android.sdk.R;

class a$a implements Runnable {
   // $FF: synthetic field
   final a a;

   a$a(a var1) {
      this.a = var1;
   }

   public void run() {
      try {
         RelativeLayout var2 = (RelativeLayout)this.a.g().findViewById(R.id.vast_container_layout);
         LayoutParams var3 = new LayoutParams(-1, -1);
         var2.addView(com.noqoush.adfalcon.android.sdk.video.vast.manager.a.a(this.a).getVastPlayer(), var3);
         if (com.noqoush.adfalcon.android.sdk.video.vast.manager.a.a(this.a).getVastPlayer().getPlayerStatus() == null.a) {
            com.noqoush.adfalcon.android.sdk.video.vast.manager.a.a(this.a).getVastPlayer().a(com.noqoush.adfalcon.android.sdk.video.vast.manager.a.a(this.a).getVastResponse());
            com.noqoush.adfalcon.android.sdk.video.vast.manager.a.a(this.a).getVastPlayer().m();
            return;
         }
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }

   }
}
