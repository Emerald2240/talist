package com.noqoush.adfalcon.android.sdk.video.vast.player;

import android.view.View;
import android.view.View.OnClickListener;

class a$a implements OnClickListener {
   // $FF: synthetic field
   final a a;

   a$a(a var1) {
      this.a = var1;
   }

   public void onClick(View var1) {
      if (com.noqoush.adfalcon.android.sdk.video.vast.player.a.a(this.a).getTranslationX() == 0.0F) {
         com.noqoush.adfalcon.android.sdk.video.vast.player.a.b(this.a);
      } else {
         this.a.a(true, true, 4);
      }
   }
}
