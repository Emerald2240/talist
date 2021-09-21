package com.noqoush.adfalcon.android.sdk.video.vast.player;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.noqoush.adfalcon.android.sdk.R;
import com.noqoush.adfalcon.android.sdk.z;
import com.noqoush.adfalcon.android.sdk.video.vast.model.r;

public class e extends c {
   private z e;

   public e(Context var1) {
      super(var1);
   }

   public e(Context var1, h var2) {
      super(var1, var2);
   }

   private void b(r var1) throws Exception {
      if (var1 != null && var1.k() != null) {
         if (this.findViewById(R.id.end_card_container) != null) {
            return;
         }

         RelativeLayout var2 = (RelativeLayout)LayoutInflater.from(this.getContext()).inflate(R.layout.vast_player_end_card_container, (ViewGroup)null);
         this.e = var1.k().a((Context)this.getContext(), (RelativeLayout)this.getVastPlayer());
         int var4;
         int var3;
         if (var1.k().g() > 0 && var1.k().l() > 0) {
            var4 = com.noqoush.adfalcon.android.sdk.util.d.a(this.getContext(), var1.k().g());
            var3 = com.noqoush.adfalcon.android.sdk.util.d.a(this.getContext(), var1.k().l());
         } else {
            var3 = -1;
            var4 = -1;
         }

         LayoutParams var5 = new LayoutParams(var3, var4);
         var5.addRule(13);
         if (this.e.getParent() != null) {
            ((ViewGroup)this.e.getParent()).removeAllViews();
         }

         var2.addView(this.e, var5);
         this.addView(var2, new LayoutParams(-1, -1));
      }

   }

   public void a(r var1) {
      super.a(var1);

      try {
         this.b(var1);
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }

   public void a(boolean var1, boolean var2, int var3) {
      super.a(var1, var2, var3);
      if (this.getScene() != null && this.getScene().k() != null) {
         if (var1) {
            this.getScene().k().q();
            return;
         }

         this.getScene().k().p();
      }

   }

   public void b() {
      try {
         if (this.e != null) {
            this.e.onPause();
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

      super.b();
   }
}
