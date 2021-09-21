package com.noqoush.adfalcon.android.sdk.video.vast.player;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.noqoush.adfalcon.android.sdk.R;
import com.noqoush.adfalcon.android.sdk.z;
import com.noqoush.adfalcon.android.sdk.video.vast.model.r;

public class a extends c {
   private z e;
   private boolean f;

   public a(Context var1) {
      super(var1);
   }

   public a(Context var1, h var2) {
      super(var1, var2);
   }

   // $FF: synthetic method
   static z a(a var0) {
      return var0.e;
   }

   private void b(r var1) throws Exception {
      if (var1 != null && var1.f() != null) {
         if (this.findViewById(R.id.banner_container) != null) {
            return;
         }

         RelativeLayout var2 = (RelativeLayout)LayoutInflater.from(this.getContext()).inflate(R.layout.vast_player_banner_container, (ViewGroup)null);
         ImageView var3 = (ImageView)var2.findViewById(R.id.arrow_img_view);
         this.e = var1.f().a((Context)this.getContext(), (RelativeLayout)this.getVastPlayer());
         int var4 = com.noqoush.adfalcon.android.sdk.util.d.a(this.getContext(), var1.f().l());
         int var5 = com.noqoush.adfalcon.android.sdk.util.d.a(this.getContext(), var1.f().g());
         var3.setOnClickListener(new a$a(this));
         LayoutParams var6 = new LayoutParams(com.noqoush.adfalcon.android.sdk.util.d.a(this.getContext(), 20), var5);
         var6.addRule(11);
         var3.setLayoutParams(var6);
         LayoutParams var7 = new LayoutParams(var4, var5);
         var7.addRule(11);
         this.e.setTranslationX((float)var4);
         if (this.e.getParent() != null) {
            ((ViewGroup)this.e.getParent()).removeView(this.e);
         }

         var2.addView(this.e, var7);
         this.addView(var2);
      }

   }

   // $FF: synthetic method
   static void b(a var0) {
      var0.d();
   }

   private void d() {
      ImageView var1 = (ImageView)this.findViewById(R.id.arrow_img_view);
      var1.setImageResource(R.drawable.left_arrow);
      this.e.clearAnimation();
      this.e.animate().translationX((float)(this.getWidth() - com.noqoush.adfalcon.android.sdk.util.d.a(this.getContext(), 20))).setDuration(500L).start();
      var1.bringToFront();
      this.setBannerVisible(false);
   }

   private void e() {
      ImageView var1 = (ImageView)this.findViewById(R.id.arrow_img_view);
      var1.setImageResource(R.drawable.right_arrow);
      this.e.clearAnimation();
      this.e.animate().translationX(0.0F).setDuration(500L).start();
      var1.bringToFront();
      this.setBannerVisible(true);
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
      if (this.getVastPlayer().getPlayerStatus() != null.e && this.getVastPlayer().getPlayerStatus() != null.f) {
         if (var1) {
            if (var3 == -1) {
               var3 = 3;
            }

            super.a(true, var2, var3);
         }

         if (var1) {
            this.e();
         } else {
            this.d();
         }
      } else {
         super.a(var1, var2, var3);
         if (var1) {
            this.e();
         }
      }

      if (this.getScene() != null && this.getScene().f() != null) {
         if (this.c()) {
            this.getScene().f().q();
            return;
         }

         this.getScene().f().p();
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

   public void b(int var1, int var2) {
      if (var1 > this.getHiddenTime() && this.getHiddenTime() > 0) {
         this.setHiddenTime(-1);
         this.d();
      }

      super.b(var1, var2);
   }

   public boolean c() {
      return this.f && this.getVisibility() == 0;
   }

   public void setBannerVisible(boolean var1) {
      this.f = var1;
   }
}
