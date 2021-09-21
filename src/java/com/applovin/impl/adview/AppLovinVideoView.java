package com.applovin.impl.adview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class AppLovinVideoView extends VideoView implements t {
   private final com.applovin.impl.sdk.j a;

   public AppLovinVideoView(Context var1, com.applovin.impl.sdk.j var2) {
      super(var1, (AttributeSet)null, 0);
      this.a = var2;
   }

   public void setVideoSize(int var1, int var2) {
      try {
         this.getHolder().setFixedSize(var1, var2);
         this.requestLayout();
         this.invalidate();
      } catch (Exception var4) {
      }
   }
}
