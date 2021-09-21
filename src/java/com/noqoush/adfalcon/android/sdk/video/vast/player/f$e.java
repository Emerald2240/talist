package com.noqoush.adfalcon.android.sdk.video.vast.player;

import android.view.View;
import android.view.View.OnClickListener;

class f$e implements OnClickListener {
   // $FF: synthetic field
   final f a;

   f$e(f var1) {
      this.a = var1;
   }

   public void onClick(View var1) {
      if (this.a.getVastPlayer().getPlayerStatus() != null.f && this.a.getVastPlayer().getPlayerStatus() != null.e) {
         this.a.getTopContainerListener().g();
      } else {
         this.a.getTopContainerListener().d();
      }
   }
}
