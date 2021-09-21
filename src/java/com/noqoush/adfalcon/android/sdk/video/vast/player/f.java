package com.noqoush.adfalcon.android.sdk.video.vast.player;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;
import com.noqoush.adfalcon.android.sdk.R;
import com.noqoush.adfalcon.android.sdk.video.vast.model.r;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class f extends c {
   private ImageView e;
   private ImageView f;
   private ImageView g;
   private ImageView h;
   private TextView i;
   private RelativeLayout j;
   private TextView k;
   private boolean l;
   private WeakReference m;

   public f(Context var1) {
      super(var1);
   }

   public f(Context var1, h var2, g var3) {
      super(var1, var2);

      try {
         this.setTopContainerListener(var3);
      } catch (Exception var5) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var5);
      }
   }

   private void d() throws Exception {
      if (this.getVastPlayer().k()) {
         this.getMuteImgView().setImageResource(R.drawable.unmute_btn);
      } else {
         this.getMuteImgView().setImageResource(R.drawable.mute_btn);
      }

      this.getSkipImgView().setImageResource(R.drawable.close_btn);
      this.getRewindImgView().setImageResource(R.drawable.replay_btn);
      this.getCloseImgView().setImageResource(R.drawable.close_btn);
   }

   private void e() throws Exception {
      this.setAutoCloseRelativeLayout((RelativeLayout)this.findViewById(R.id.auto_close_container));
      this.setAutoCloseTxtView((TextView)this.findViewById(R.id.auto_close_txt_view));
      this.getAutoCloseRelativeLayout().setOnClickListener(new f$f(this));
   }

   private void f() throws Exception {
      this.setCloseImgView((ImageView)this.findViewById(R.id.close_img_view));
      this.getCloseImgView().setOnClickListener(new f$e(this));
   }

   private void g() throws Exception {
      this.setMuteImgView((ImageView)this.findViewById(R.id.mute_img_view));
      this.getMuteImgView().setOnClickListener(new f$b(this));
   }

   private void h() throws Exception {
      this.setRewindImgView((ImageView)this.findViewById(R.id.rewind_img_view));
      this.getRewindImgView().setOnClickListener(new f$d(this));
   }

   private void i() throws Exception {
      this.setSkipImgView((ImageView)this.findViewById(R.id.skip_img_view));
      this.getSkipImgView().setOnClickListener(new f$c(this));
   }

   private void j() {
      this.setTitleTxtView((TextView)this.findViewById(R.id.title_txt_view));
   }

   private void k() {
      this.getAutoCloseRelativeLayout().setVisibility(0);
      this.getAutoCloseRelativeLayout().clearAnimation();
      ScaleAnimation var1 = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 1.0F);
      var1.setDuration(250L);
      var1.setFillAfter(true);
      var1.setFillEnabled(true);
      var1.setAnimationListener(new f$a(this));
      this.getAutoCloseRelativeLayout().startAnimation(var1);
      this.getTitleTxtView().setAlpha(0.2F);
   }

   public void a() {
      try {
         super.a();
         if (this.findViewById(R.id.top_container) == null) {
            this.addView(LayoutInflater.from(this.getContext()).inflate(R.layout.vast_player_top_container, (ViewGroup)null), new LayoutParams(-1, -1));
         }

         this.g();
         this.i();
         this.h();
         this.f();
         this.e();
         this.j();
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void a(int var1, int var2) {
      Exception var10000;
      label55: {
         boolean var10001;
         try {
            super.a(var1, var2);
         } catch (Exception var13) {
            var10000 = var13;
            var10001 = false;
            break label55;
         }

         int var4 = var2 - var1;
         if (var4 > 0 && var4 <= 30) {
            label56: {
               try {
                  if (this.getAutoCloseRelativeLayout().getVisibility() != 0) {
                     this.k();
                  }
               } catch (Exception var10) {
                  var10000 = var10;
                  var10001 = false;
                  break label56;
               }

               TextView var5;
               Locale var6;
               try {
                  var5 = this.getAutoCloseTxtView();
                  var6 = Locale.getDefault();
               } catch (Exception var9) {
                  var10000 = var9;
                  var10001 = false;
                  break label56;
               }

               try {
                  Object[] var7 = new Object[]{var4};
                  var5.setText(String.format(var6, "Will close in %02ds", var7));
                  return;
               } catch (Exception var8) {
                  var10000 = var8;
                  var10001 = false;
               }
            }
         } else if (var4 <= 0) {
            try {
               this.getTopContainerListener().d();
               return;
            } catch (Exception var11) {
               var10000 = var11;
               var10001 = false;
            }
         } else {
            try {
               this.getAutoCloseRelativeLayout().setVisibility(8);
               return;
            } catch (Exception var12) {
               var10000 = var12;
               var10001 = false;
            }
         }
      }

      Exception var3 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var3);
   }

   public void a(r var1) {
      Exception var10000;
      label93: {
         boolean var10001;
         boolean var3;
         label89: {
            label88: {
               try {
                  super.a(var1);
                  this.d();
                  this.getTitleTxtView().setText(var1.c());
                  if (var1.r() <= 0) {
                     break label88;
                  }
               } catch (Exception var11) {
                  var10000 = var11;
                  var10001 = false;
                  break label93;
               }

               var3 = true;
               break label89;
            }

            var3 = false;
         }

         label81: {
            label96: {
               try {
                  this.setSkippableLinear(var3);
                  if (this.getVastPlayer().getPlayerStatus() == null.f || this.getVastPlayer().getPlayerStatus() == null.e) {
                     break label81;
                  }

                  if (this.c()) {
                     this.getSkipImgView().setVisibility(4);
                     this.getMuteImgView().setVisibility(0);
                     this.getRewindImgView().setVisibility(4);
                     this.getCloseImgView().setVisibility(4);
                     break label96;
                  }
               } catch (Exception var10) {
                  var10000 = var10;
                  var10001 = false;
                  break label93;
               }

               try {
                  this.getCloseImgView().setVisibility(0);
                  this.getSkipImgView().setVisibility(4);
                  this.getMuteImgView().setVisibility(0);
                  this.getRewindImgView().setVisibility(4);
               } catch (Exception var9) {
                  var10000 = var9;
                  var10001 = false;
                  break label93;
               }
            }

            try {
               this.getAutoCloseRelativeLayout().setVisibility(8);
               this.getTitleTxtView().setAlpha(1.0F);
               return;
            } catch (Exception var4) {
               var10000 = var4;
               var10001 = false;
               break label93;
            }
         }

         label97: {
            try {
               this.getMuteImgView().setVisibility(4);
               if (this.getVastPlayer().getPlayerStatus() != null.e) {
                  this.getRewindImgView().setVisibility(0);
                  break label97;
               }
            } catch (Exception var8) {
               var10000 = var8;
               var10001 = false;
               break label93;
            }

            try {
               this.getRewindImgView().setVisibility(4);
            } catch (Exception var7) {
               var10000 = var7;
               var10001 = false;
               break label93;
            }
         }

         try {
            this.getSkipImgView().setVisibility(4);
            this.getCloseImgView().setVisibility(0);
            if (this.getVastPlayer().j() || !this.getVastPlayer().j() && this.getScene().l() > 0) {
               return;
            }
         } catch (Exception var6) {
            var10000 = var6;
            var10001 = false;
            break label93;
         }

         try {
            this.getAutoCloseRelativeLayout().setVisibility(8);
            this.getTitleTxtView().setAlpha(1.0F);
            return;
         } catch (Exception var5) {
            var10000 = var5;
            var10001 = false;
         }
      }

      Exception var2 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var2);
   }

   public void b(int var1, int var2) {
      Exception var10000;
      label69: {
         boolean var10001;
         label70: {
            try {
               super.b(var1, var2);
               if (this.getVastPlayer().k()) {
                  this.getMuteImgView().setImageResource(R.drawable.unmute_btn);
                  break label70;
               }
            } catch (Exception var8) {
               var10000 = var8;
               var10001 = false;
               break label69;
            }

            try {
               this.getMuteImgView().setImageResource(R.drawable.mute_btn);
            } catch (Exception var7) {
               var10000 = var7;
               var10001 = false;
               break label69;
            }
         }

         label52: {
            try {
               if (this.getScene().r() <= 0 || var1 < this.getScene().r() || this.getSkipImgView().getVisibility() == 0 || this.getCloseImgView().getVisibility() == 0) {
                  return;
               }

               if (this.getScene().v()) {
                  this.getSkipImgView().setVisibility(0);
                  break label52;
               }
            } catch (Exception var6) {
               var10000 = var6;
               var10001 = false;
               break label69;
            }

            try {
               this.getCloseImgView().setVisibility(0);
            } catch (Exception var5) {
               var10000 = var5;
               var10001 = false;
               break label69;
            }
         }

         try {
            if (this.getTopContainerListener() != null) {
               this.getTopContainerListener().e();
               return;
            }

            return;
         } catch (Exception var4) {
            var10000 = var4;
            var10001 = false;
         }
      }

      Exception var3 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var3);
   }

   public boolean c() {
      return this.l;
   }

   public RelativeLayout getAutoCloseRelativeLayout() {
      return this.j;
   }

   public TextView getAutoCloseTxtView() {
      return this.i;
   }

   public ImageView getCloseImgView() {
      return this.h;
   }

   public ImageView getMuteImgView() {
      return this.e;
   }

   public ImageView getRewindImgView() {
      return this.f;
   }

   public ImageView getSkipImgView() {
      return this.g;
   }

   public TextView getTitleTxtView() {
      return this.k;
   }

   public g getTopContainerListener() {
      WeakReference var1 = this.m;
      return var1 == null ? null : (g)var1.get();
   }

   public void setAutoCloseRelativeLayout(RelativeLayout var1) {
      this.j = var1;
   }

   public void setAutoCloseTxtView(TextView var1) {
      this.i = var1;
   }

   public void setCloseImgView(ImageView var1) {
      this.h = var1;
   }

   public void setMuteImgView(ImageView var1) {
      this.e = var1;
   }

   public void setRewindImgView(ImageView var1) {
      this.f = var1;
   }

   public void setSkipImgView(ImageView var1) {
      this.g = var1;
   }

   public void setSkippableLinear(boolean var1) {
      this.l = var1;
   }

   public void setTitleTxtView(TextView var1) {
      this.k = var1;
   }

   public void setTopContainerListener(g var1) {
      if (var1 != null) {
         this.m = new WeakReference(var1);
      }

   }
}
