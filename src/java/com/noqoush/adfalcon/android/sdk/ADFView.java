package com.noqoush.adfalcon.android.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.noqoush.adfalcon.android.sdk.constant.ADFAdSize;
import java.io.Serializable;
import java.util.Timer;

public class ADFView extends RelativeLayout implements ADFAd, Serializable {
   private static final long k = 1L;
   public static final String l = "sdk-a-5.2.0";
   protected static final int m = 100;
   protected static final int n = 101;
   protected static final int o = 102;
   private w a;
   private x b;
   private m c;
   private BroadcastReceiver d;
   private OnClickListener e;
   private y f;
   private Timer g;
   protected float h;
   int i;
   int j;

   public ADFView(Activity var1) {
      super(var1);
      this.init();
   }

   public ADFView(Context var1) {
      super(var1);
      this.init();
   }

   public ADFView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init();
   }

   public ADFView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init();
   }

   // $FF: synthetic method
   static w a(ADFView var0) {
      return var0.getController();
   }

   private void a(String var1) throws Exception {
      if (this.findViewById(101) != null) {
         this.e();
      } else {
         int var2 = (int)((float)this.getModel().c() * this.h);
         int var3 = (int)((float)this.getModel().d() * this.h);
         double var4 = (double)this.getModel().c();
         Double.isNaN(var4);
         int var7 = (int)(var4 * 0.8D);
         double var8 = (double)this.getModel().d();
         Double.isNaN(var8);
         int var11 = (int)(var8 * 0.4D);
         if (var7 > 100) {
            var7 = 100;
         }

         if (var11 > 150) {
            var11 = 150;
         }

         if (var11 == 0 || var7 == 0) {
            var11 = 128;
            var7 = 38;
         }

         float var12 = (float)var11;
         float var13 = this.h;
         int var14 = (int)(var12 * var13);
         int var15 = (int)(var13 * (float)var7);
         LinearLayout var16 = new LinearLayout(this.getContext());
         var16.setId(102);
         LayoutParams var17 = new LayoutParams(var3, var2);
         var17.addRule(13);
         var16.setBackgroundColor(Color.argb(102, 0, 0, 0));
         this.addView(var16, var17);
         Button var18 = new Button(this.getContext());
         var18.setId(101);
         var18.setText(com.noqoush.adfalcon.android.sdk.util.d.a(var1));
         var18.getPaint().setTypeface(Typeface.DEFAULT_BOLD);
         var18.setBackgroundColor(Color.rgb(51, 102, 204));
         var18.setTextColor(-1);
         var18.setMinWidth(100);
         LayoutParams var20 = new LayoutParams(var14, var15);
         var20.addRule(13);
         var18.setLayoutParams(var20);
         this.addView(var18);
         var18.setOnClickListener(this.getClickListener());
         ScaleAnimation var21 = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F);
         var21.setDuration(125L);
         var18.startAnimation(var21);
         var16.startAnimation(var21);
         this.d();
         Timer var22 = new Timer();
         this.g = var22;
         var22.schedule(new ADFView$c(this), 5000L);
      }
   }

   // $FF: synthetic method
   static void b(ADFView var0) throws Exception {
      var0.e();
   }

   private void c() {
      try {
         this.d();
      } catch (Exception var5) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var5);
      }

      for(int var2 = 0; var2 < this.getChildCount(); ++var2) {
         View var3 = this.getChildAt(var2);
         if (var3 instanceof m) {
            m var4 = (m)var3;
            this.removeView(var4);
            var4.e();
         }
      }

      this.removeAllViews();
   }

   private void d() throws Exception {
      Timer var1 = this.g;
      if (var1 != null) {
         var1.cancel();
      }

      this.g = null;
   }

   private void e() throws Exception {
      this.d();
      ScaleAnimation var1 = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F);
      var1.setDuration(125L);
      var1.setFillAfter(true);
      var1.setAnimationListener(new ADFView$d(this));
      this.findViewById(102).startAnimation(var1);
      this.findViewById(101).startAnimation(var1);
   }

   private void f() {
      try {
         if (this.getLayoutParams() != null && this.getModel() != null && this.getModel().l() != null && !this.getModel().B()) {
            int var2 = (int)((float)this.getModel().l().t() * this.h);
            int var3 = (int)((float)this.getModel().l().j() * this.h);
            if (this.getLayoutParams().width != var2 || this.getLayoutParams().height != var3) {
               this.getLayoutParams().width = var2;
               this.getLayoutParams().height = var3;
               this.requestLayout();
               return;
            }
         }
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }

   }

   private w getController() {
      return this.a;
   }

   private x getModel() {
      return this.b;
   }

   private void setAdSize(ADFAdSize var1) {
      if (this.getModel().q() != var1) {
         this.getModel().a((com.noqoush.adfalcon.android.sdk.response.k)null);
      }

      this.getModel().a(var1);
   }

   private void setSiteId(String var1) {
      this.getModel().a(var1);
   }

   private void setTargetingParams(ADFTargetingParams var1) {
      this.getModel().a(var1);
   }

   protected void a() {
      if (this.getController() != null) {
         this.getController().s();
      }

   }

   protected void a(com.noqoush.adfalcon.android.sdk.response.k var1, m var2) {
      com.noqoush.adfalcon.android.sdk.k.a("will displayContent");

      Exception var10000;
      label78: {
         boolean var10001;
         try {
            this.c();
         } catch (Exception var15) {
            var10000 = var15;
            var10001 = false;
            break label78;
         }

         if (var2 == null) {
            try {
               w var4 = this.getController();
               Context var5 = this.getContext();
               y var6 = this.getWebChromeClient();
               var2 = new m(var1, this, var4, var5, var6);
            } catch (Exception var14) {
               var10000 = var14;
               var10001 = false;
               break label78;
            }
         }

         LayoutParams var8;
         label75: {
            label76: {
               try {
                  var2.setId(100);
                  if (!this.getModel().B()) {
                     break label76;
                  }

                  if (this.getModel().l().c().equalsIgnoreCase("richmedia")) {
                     var8 = new LayoutParams(com.noqoush.adfalcon.android.sdk.util.f.a(), com.noqoush.adfalcon.android.sdk.util.f.a());
                     break label75;
                  }
               } catch (Exception var13) {
                  var10000 = var13;
                  var10001 = false;
                  break label78;
               }

               try {
                  var8 = new LayoutParams((int)((float)this.getModel().d() * this.h), (int)((float)this.getModel().c() * this.h));
                  break label75;
               } catch (Exception var12) {
                  var10000 = var12;
                  var10001 = false;
                  break label78;
               }
            }

            LayoutParams var7;
            try {
               var7 = new LayoutParams((int)((float)var1.t() * this.h), (int)((float)var1.j() * this.h));
               this.f();
            } catch (Exception var11) {
               var10000 = var11;
               var10001 = false;
               break label78;
            }

            var8 = var7;
         }

         try {
            var8.addRule(13);
            var2.setLayoutParams(var8);
            var2.setBackgroundColor(0);
            this.addView(var2);
            this.c = var2;
            if (VERSION.SDK_INT >= 11) {
               var2.setLayerType(this.getLayerType(), (Paint)null);
               this.c.invalidate();
            }
         } catch (Exception var10) {
            var10000 = var10;
            var10001 = false;
            break label78;
         }

         try {
            this.setPadding(0, 0, 0, 0);
            this.invalidate();
            com.noqoush.adfalcon.android.sdk.k.a("did displayContent");
            return;
         } catch (Exception var9) {
            var10000 = var9;
            var10001 = false;
         }
      }

      Exception var3 = var10000;
      var3.printStackTrace();
      com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
   }

   protected void b() {
      if (this.getController() != null) {
         this.getController().r();
      }

      this.f();
   }

   public void destroy() {
      try {
         if (this.c != null) {
            this.removeView(this.c);
            this.c.e();
         }

         if (this.getController() != null) {
            this.getController().a();
         }

         this.d();
      } catch (Exception var5) {
         com.noqoush.adfalcon.android.sdk.k.b(var5.getMessage());
      } finally {
         if (this.getController() != null) {
            this.getController().b();
         }

      }

   }

   public ADFAdSize getAdSize() {
      return this.getModel().q();
   }

   protected OnClickListener getClickListener() {
      synchronized(this){}

      OnClickListener var2;
      try {
         var2 = this.e;
      } finally {
         ;
      }

      return var2;
   }

   public ADFListener getListener() {
      return this.getModel().i();
   }

   public int getRefreshDuration() {
      return this.getModel().k();
   }

   public String getSiteId() {
      return this.getModel().p();
   }

   public ADFTargetingParams getTargetingParams() {
      return this.getModel().t();
   }

   protected y getWebChromeClient() {
      return this.f;
   }

   public void init() {
      try {
         this.h = com.noqoush.adfalcon.android.sdk.util.d.e(this.getContext());
         if (!this.isInEditMode()) {
            com.noqoush.adfalcon.android.sdk.k.c("AdFalconSDK Version: sdk-a-5.2.0");
            this.setController(new w(this));
            this.setModel(this.getController().g());
            return;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public void initialize(String var1, ADFAdSize var2, ADFTargetingParams var3, ADFListener var4, boolean var5) {
      try {
         if (this.getModel() != null && this.getModel().s() != w.e.a) {
            com.noqoush.adfalcon.android.sdk.k.b("The ADFView was initialized before.");
         } else {
            com.noqoush.adfalcon.android.sdk.k.a("will load an Ad");
            this.setSiteId(var1);
            this.setTargetingParams(var3);
            this.setListener(var4);
            this.setEnableAutoRefresh(var5);
            this.setAdSize(var2);
            g var8 = com.noqoush.adfalcon.android.sdk.g.c(this.getContext());
            this.getModel().a(var8);
            this.getModel().a(w.e.b);
            r.b = true;
            this.refreshAd();
         }
      } catch (Exception var9) {
         com.noqoush.adfalcon.android.sdk.k.b(var9.getMessage());
         if (this.getListener() != null) {
            this.post(new ADFView$a(this, var9));
         }

      }
   }

   public boolean isEnableAnimation() {
      return this.getModel().y();
   }

   public boolean isEnableAutoRefresh() {
      return this.getModel().A();
   }

   public boolean isTestMode() {
      return this.getModel().C();
   }

   protected void onAttachedToWindow() {
      this.b();
      super.onAttachedToWindow();
   }

   protected void onDetachedFromWindow() {
      this.a();
      super.onDetachedFromWindow();
   }

   public boolean onTouchEvent(MotionEvent param1) {
      // $FF: Couldn't be decompiled
   }

   public void onWindowFocusChanged(boolean var1) {
      this.getModel().h(var1);
      if (var1) {
         this.b();
      } else {
         this.a();
      }

      super.onWindowFocusChanged(var1);
   }

   protected void onWindowVisibilityChanged(int var1) {
      super.onWindowVisibilityChanged(var1);
      StringBuilder var2 = new StringBuilder();
      var2.append("visibility: ");
      var2.append(var1);
      com.noqoush.adfalcon.android.sdk.k.a(var2.toString());

      Exception var10000;
      label46: {
         boolean var10001;
         label40: {
            try {
               if (this.d == null) {
                  break label40;
               }
            } catch (Exception var10) {
               var10000 = var10;
               var10001 = false;
               break label46;
            }

            if (var1 == 8) {
               try {
                  this.getContext().unregisterReceiver(this.d);
                  this.d.clearAbortBroadcast();
                  this.d = null;
                  this.a();
               } catch (Exception var9) {
                  var10000 = var9;
                  var10001 = false;
                  break label46;
               }
            }
         }

         try {
            if (this.d != null) {
               return;
            }
         } catch (Exception var8) {
            var10000 = var8;
            var10001 = false;
            break label46;
         }

         if (var1 != 0) {
            return;
         }

         try {
            IntentFilter var6 = new IntentFilter("android.intent.action.SCREEN_ON");
            var6.addAction("android.intent.action.SCREEN_OFF");
            this.d = new r(this);
            this.getContext().registerReceiver(this.d, var6);
            this.b();
            if (this.getController() != null) {
               this.getController().p();
               return;
            }

            return;
         } catch (Exception var7) {
            var10000 = var7;
            var10001 = false;
         }
      }

      Exception var5 = var10000;
      com.noqoush.adfalcon.android.sdk.k.b(var5.toString());
   }

   public void refreshAd() {
      (new Thread(new ADFView$b(this))).start();
   }

   protected void setClickListener(OnClickListener var1) {
      synchronized(this){}

      try {
         this.e = var1;
      } finally {
         ;
      }

   }

   protected void setController(w var1) {
      this.a = var1;
   }

   public void setEnableAnimation(boolean var1) {
      this.getModel().b(var1);
   }

   public void setEnableAutoRefresh(boolean var1) {
      this.getModel().d(var1);
   }

   public void setLayerType(int var1, Paint var2) {
      try {
         if (this.c != null) {
            this.c.setLayerType(var1, var2);
            this.c.invalidate();
         }
      } catch (Exception var4) {
      }

      super.setLayerType(var1, var2);
   }

   public void setLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      super.setLayoutParams(var1);
      this.f();
   }

   public void setListener(ADFListener var1) {
      this.getModel().a(var1);
   }

   protected void setModel(x var1) {
      this.b = var1;
   }

   public void setRefreshDuration(int var1) {
      this.getModel().c(var1);
   }

   @Deprecated
   public void setTestMode(boolean var1) {
      this.getModel().g(var1);
      com.noqoush.adfalcon.android.sdk.util.d.a();
   }

   protected void setWebChromeClient(y var1) {
      this.f = var1;
   }
}
