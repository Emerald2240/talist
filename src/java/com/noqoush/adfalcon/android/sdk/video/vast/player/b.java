package com.noqoush.adfalcon.android.sdk.video.vast.player;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;
import com.noqoush.adfalcon.android.sdk.R;
import com.noqoush.adfalcon.android.sdk.video.vast.model.r;
import com.noqoush.adfalcon.android.sdk.video.vast.model.v;
import com.noqoush.adfalcon.android.sdk.video.vast.model.w;
import java.util.Locale;

public class b extends c {
   private TextView e;
   private WebView f;
   private ProgressBar g;

   public b(Context var1) {
      super(var1);
   }

   public b(Context var1, h var2) {
      super(var1, var2);
   }

   private void b(r var1) throws Exception {
      v var2 = var1.o().i();
      if (var2 != null && var2.c() != null && this.getLearnMoreView() == null && var2.l() <= 200) {
         if (var2.g() > 40) {
            return;
         }

         LayoutParams var3 = new LayoutParams(com.noqoush.adfalcon.android.sdk.util.d.a(this.getContext(), var2.l()), com.noqoush.adfalcon.android.sdk.util.d.a(this.getContext(), var2.g()));
         var3.addRule(11);
         var3.addRule(15);
         var3.rightMargin = com.noqoush.adfalcon.android.sdk.util.d.a(this.getContext(), 5);

         try {
            this.setLearnMoreView(var1.o().i().a((Context)this.getContext(), (RelativeLayout)this.getVastPlayer()));
            this.getLearnMoreView().setLayoutParams(var3);
            var1.o().i().a((w)this.getVastPlayer());
         } catch (Exception var5) {
            var5.printStackTrace();
         }

         if (this.getLearnMoreView().getParent() != null) {
            ((ViewGroup)this.getLearnMoreView().getParent()).removeView(this.getLearnMoreView());
         }

         this.addView(this.getLearnMoreView());
      }

   }

   private void c() throws Exception {
      this.setAdvertiserTxtView((TextView)this.findViewById(R.id.advertiser_txt_view));
   }

   private void d() throws Exception {
      this.setProgressBar((ProgressBar)this.findViewById(R.id.progress_bar));
   }

   public void a() {
      try {
         super.a();
         if (this.findViewById(R.id.bottom_container) == null) {
            this.addView(LayoutInflater.from(this.getContext()).inflate(R.layout.vast_player_bottom_container, (ViewGroup)null), new LayoutParams(-1, -1));
         }

         this.d();
         this.c();
         this.invalidate();
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void a(r var1) {
      try {
         super.a(var1);
         this.b(var1);
         this.getProgressBar().setMax(this.getVastPlayer().getDuration());
         this.getAdvertiserTxtView().setText("Ad by AdFalcon");
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }

   public void a(boolean var1, boolean var2, int var3) {
      super.a(var1, var2, var3);
      if (this.getScene() != null && this.getScene().o() != null && this.getScene().o().i() != null) {
         if (var1) {
            this.getScene().o().i().q();
            return;
         }

         this.getScene().o().i().p();
      }

   }

   public void b(int var1, int var2) {
      Exception var10000;
      label31: {
         boolean var10001;
         try {
            super.b(var1, var2);
            this.getProgressBar().setProgress(var1);
            this.getProgressBar().setMax(var2);
         } catch (Exception var11) {
            var10000 = var11;
            var10001 = false;
            break label31;
         }

         int var4 = var2 - var1;
         if (var4 > 0) {
            label25: {
               TextView var5;
               Locale var6;
               try {
                  var5 = this.getAdvertiserTxtView();
                  var6 = Locale.getDefault();
               } catch (Exception var9) {
                  var10000 = var9;
                  var10001 = false;
                  break label25;
               }

               try {
                  Object[] var7 = new Object[]{var4};
                  var5.setText(String.format(var6, "Ad: Remaining %d s", var7));
                  return;
               } catch (Exception var8) {
                  var10000 = var8;
                  var10001 = false;
               }
            }
         } else {
            try {
               this.getAdvertiserTxtView().setText("Ad by AdFalcon");
               return;
            } catch (Exception var10) {
               var10000 = var10;
               var10001 = false;
            }
         }
      }

      Exception var3 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var3);
   }

   public TextView getAdvertiserTxtView() {
      return this.e;
   }

   public WebView getLearnMoreView() {
      return this.f;
   }

   public ProgressBar getProgressBar() {
      return this.g;
   }

   public void setAdvertiserTxtView(TextView var1) {
      this.e = var1;
   }

   public void setLearnMoreView(WebView var1) {
      this.f = var1;
   }

   public void setProgressBar(ProgressBar var1) {
      this.g = var1;
   }
}
