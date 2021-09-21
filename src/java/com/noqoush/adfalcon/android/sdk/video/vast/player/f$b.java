package com.noqoush.adfalcon.android.sdk.video.vast.player;

import android.view.View;
import android.view.View.OnClickListener;
import com.noqoush.adfalcon.android.sdk.R;

class f$b implements OnClickListener {
   // $FF: synthetic field
   final f a;

   f$b(f var1) {
      this.a = var1;
   }

   public void onClick(View var1) {
      if (this.a.getTopContainerListener() != null) {
         if (this.a.getVastPlayer().k()) {
            this.a.getMuteImgView().setImageResource(R.drawable.mute_btn);
            this.a.getTopContainerListener().f();
            return;
         }

         this.a.getMuteImgView().setImageResource(R.drawable.unmute_btn);
         this.a.getTopContainerListener().h();
      }

   }
}
