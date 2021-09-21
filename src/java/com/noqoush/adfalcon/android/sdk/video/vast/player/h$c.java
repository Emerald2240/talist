package com.noqoush.adfalcon.android.sdk.video.vast.player;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

class h$c implements OnErrorListener {
   // $FF: synthetic field
   final h a;

   h$c(h var1) {
      this.a = var1;
   }

   public boolean onError(MediaPlayer var1, int var2, int var3) {
      String var4;
      label21: {
         com.noqoush.adfalcon.android.sdk.util.a.e("onError");
         if (var3 != -1010) {
            if (var3 == -110) {
               var4 = "402";
               break label21;
            }

            if (var3 != 1) {
               var4 = "400";
               break label21;
            }
         }

         var4 = "405";
      }

      try {
         h.a(this.a, var4);
         this.a.getVideoPlayer().setBackgroundColor(-16777216);
         return true;
      } catch (Exception var6) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var6);
         return true;
      }
   }
}
