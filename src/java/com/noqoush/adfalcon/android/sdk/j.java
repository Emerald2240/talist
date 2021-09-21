package com.noqoush.adfalcon.android.sdk;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.noqoush.adfalcon.android.sdk.constant.ADFMraidState;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Hashtable;

public class j implements a, OnClickListener {
   public static final int o = 555555;
   static final int p = 666666;
   static Hashtable q = new Hashtable();
   static Hashtable r;
   private com.noqoush.adfalcon.android.sdk.nativead.a a;
   private w b;
   private x c;
   private q d;
   private y e;
   private m f;
   private ADFView g;
   private ImageView h;
   private RelativeLayout i;
   private OnClickListener j;
   private String k;
   protected float l = 1.0F;
   private Activity m;
   private Intent n;

   static {
      Hashtable var0 = new Hashtable();
      r = var0;
      var0.put("app", "Download");
      r.put("audio", "Play audio");
      r.put("call", "Make call");
      r.put("loc", "View location");
      r.put("sms", "Send SMS");
      r.put("url", "Open web page");
      r.put("video", "Play video");
   }

   private void c(Bundle var1) {
      if (var1 != null) {
         try {
            if (var1.containsKey("key")) {
               long var6 = var1.getLong("key");
               if (q.containsKey(var6)) {
                  j.c var8 = (j.c)q.get(var6);
                  this.b = var8.a;
                  this.c = var8.b;
                  this.d = var8.c;
                  this.a = var8.d;
                  q.remove(var6);
                  return;
               }
            }
         } catch (Exception var9) {
            StringBuilder var3 = new StringBuilder();
            var3.append("ADFInterstitialActivityImp->restoreData->");
            var3.append(var9.toString());
            com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
         }
      }

   }

   private String q() {
      try {
         if (r.containsKey(this.l().l().a().f())) {
            String var5 = (String)r.get(this.l().l().a().f());
            return var5;
         }
      } catch (Exception var6) {
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFActivity->actionToString->");
         var2.append(var6.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var2.toString());
      }

      return "Open Ad";
   }

   private void r() throws Exception {
      this.i().requestWindowFeature(1);
      RelativeLayout var2 = new RelativeLayout(this.i());
      this.i = var2;
      var2.setId(555555);
      if (this.k().getIntExtra("width", -1) > 0 && this.k().getIntExtra("height", -1) > 0) {
         this.i.setBackgroundColor(Color.argb(125, 0, 0, 0));
      } else {
         this.i().requestWindowFeature(1);
         if (this.k().getBooleanExtra("isExpanded", false)) {
            this.i.setBackgroundColor(0);
         } else {
            this.i.setBackgroundColor(-16777216);
         }
      }

      this.a(this.k().getStringExtra("url"));
      this.i.setOnClickListener(this);
      this.i().setContentView(this.i);
      String var4 = this.k().getStringExtra("forceOrientation");
      if (var4 != null) {
         boolean var5 = this.k().getBooleanExtra("allowOrientationChange", true);
         Display var6 = ((WindowManager)this.i().getSystemService("window")).getDefaultDisplay();
         int var11;
         int var10;
         if (VERSION.SDK_INT >= 13) {
            Point var7 = new Point();
            var6.getSize(var7);
            float var8 = (float)var7.x;
            float var9 = this.l;
            var10 = (int)(var8 / var9);
            var11 = (int)((float)var7.y / var9);
         } else {
            int var12 = (int)((float)var6.getWidth() / this.l);
            var11 = (int)((float)var6.getHeight() / this.l);
            var10 = var12;
         }

         com.noqoush.adfalcon.android.sdk.util.d.a(this.i(), var5, var4, var10, var11);
      }

   }

   private void s() throws Exception {
      this.g = new ADFView(this.i());
      if (this.m() != null) {
         this.f.a((Context)this.i());
         this.f.setParentLayout(this.i);
         this.f.setVisibility(0);
         this.f.invalidate();
         this.f.requestFocus();
         WeakReference var3 = this.f.q;
         if (var3 != null && var3.get() != null) {
            this.e = (y)this.f.q.get();
         } else {
            this.e = new y(this.i(), this.i, (ProgressBar)null);
         }
      } else {
         this.e = new y(this.i(), this.i, (ProgressBar)null);
      }

      this.g.setWebChromeClient(this.e);
      this.g.setModel(this.l());
      this.g.setController(this.j());
      this.l().a(this.g);
      this.a(this.j().h());
      this.g.setClickListener(this.h());
      LayoutParams var1 = new LayoutParams(-2, -2);
      var1.addRule(13);
      this.g.setLayoutParams(var1);
      this.g.setBackgroundColor(0);
      this.i.addView(this.g);
      this.j().q();
   }

   private void t() throws Exception {
      com.noqoush.adfalcon.android.sdk.images.b var1 = new com.noqoush.adfalcon.android.sdk.images.b();
      int var2 = (int)(50.0F * this.l);
      ImageView var3 = new ImageView(this.i());
      this.h = var3;
      var3.setId(666666);
      this.h.setImageBitmap(var1.b(this.i()));
      this.h.setBackgroundColor(0);
      this.h.setMinimumHeight(var2);
      this.h.setMinimumWidth(var2);
      this.h.setScaleType(ScaleType.FIT_XY);
      this.h.setOnClickListener(this);
      LayoutParams var4 = new LayoutParams(var2, var2);
      var4.addRule(11, -1);
      var4.addRule(10, -1);
      this.h.setLayoutParams(var4);
      this.i.addView(this.h);
      if (this.k().getBooleanExtra("isUseCustomClose", false)) {
         this.h.setVisibility(4);
      } else {
         this.h.setVisibility(0);
      }

      if (this.m() != null) {
         this.m().setCloseIndicatorImageButton(this.h);
      }

   }

   private void u() throws Exception {
      LayoutParams var1;
      if (this.k().getIntExtra("width", -1) > 0 && this.k().getIntExtra("height", -1) > 0) {
         var1 = new LayoutParams(this.k().getIntExtra("width", -1), this.k().getIntExtra("height", -1));
      } else {
         var1 = new LayoutParams(com.noqoush.adfalcon.android.sdk.util.f.a(), com.noqoush.adfalcon.android.sdk.util.f.a());
      }

      var1.addRule(13);
      if (this.m() != null) {
         this.f.a((Context)this.i());
         this.f.setParentLayout(this.i);
         this.f.setVisibility(0);
         this.f.invalidate();
         this.f.requestFocus();
         WeakReference var4 = this.f.q;
         if (var4 != null && var4.get() != null) {
            this.e = (y)this.f.q.get();
         }
      } else {
         this.e = new y(this.i(), this.i, (ProgressBar)null);
         m var2 = new m(this.p(), this.i(), this.i, this.e, this.k().getBooleanExtra("isExpanded", false), this.j(), this.a);
         this.f = var2;
      }

      this.f.setLayoutParams(var1);
      this.f.setBackgroundColor(0);
      this.i.addView(this.f);
   }

   private void v() {
      try {
         Builder var1 = new Builder(this.i());
         var1.setTitle("Click to");
         Builder var7 = var1.setCancelable(false).setPositiveButton(this.q(), new j$b(this));
         var7.setNegativeButton("Exit", new j$a(this)).setCancelable(true);
         var1.create().show();
      } catch (Exception var8) {
         StringBuilder var3 = new StringBuilder();
         var3.append("ADFActivity->showAlert->");
         var3.append(var8.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
      }
   }

   public void a() {
   }

   public void a(Activity var1) {
      this.m = var1;
   }

   public void a(Intent var1) {
      this.n = var1;
   }

   public void a(Bundle var1) {
      this.c(var1);
   }

   public void a(Bundle var1, Activity var2, Window var3, Intent var4) {
      Exception var10000;
      label110: {
         boolean var10001;
         try {
            this.a(var2);
            this.a(var4);
            this.l = com.noqoush.adfalcon.android.sdk.util.d.e((Context)var2);
            this.c(var1);
            if (this.o() != null) {
               this.o().willPresentScreen();
            }
         } catch (Exception var23) {
            var10000 = var23;
            var10001 = false;
            break label110;
         }

         label111: {
            o var9;
            try {
               this.r();
               if (this.m() == null) {
                  break label111;
               }

               var9 = this.m().getMraidModel();
            } catch (Exception var22) {
               var10000 = var22;
               var10001 = false;
               break label110;
            }

            boolean var10 = false;
            if (var9 != null) {
               o.a var11;
               try {
                  var11 = this.m().getMraidModel().e();
               } catch (Exception var21) {
                  var10000 = var21;
                  var10001 = false;
                  break label110;
               }

               var10 = false;
               if (var11 != null) {
                  try {
                     var10 = this.m().getMraidModel().e().d();
                  } catch (Exception var20) {
                     var10000 = var20;
                     var10001 = false;
                     break label110;
                  }
               }
            }

            try {
               this.k().putExtra("isUseCustomClose", var10);
            } catch (Exception var19) {
               var10000 = var19;
               var10001 = false;
               break label110;
            }
         }

         label112: {
            try {
               if (this.p() == null) {
                  this.s();
                  break label112;
               }
            } catch (Exception var18) {
               var10000 = var18;
               var10001 = false;
               break label110;
            }

            try {
               this.u();
            } catch (Exception var17) {
               var10000 = var17;
               var10001 = false;
               break label110;
            }
         }

         try {
            if (this.m() != null) {
               this.m().g();
            }
         } catch (Exception var16) {
            var10000 = var16;
            var10001 = false;
            break label110;
         }

         try {
            this.t();
            if (this.o() != null) {
               this.o().didPresentScreen();
            }
         } catch (Exception var15) {
            var10000 = var15;
            var10001 = false;
            break label110;
         }

         try {
            if (this.n() != null) {
               this.n().c();
            }
         } catch (Exception var14) {
            var10000 = var14;
            var10001 = false;
            break label110;
         }

         try {
            if (this.l() != null && this.l().a() instanceof ADFInterstitial && this.l().l().g() != null && this.l().l().g().a().size() > 0) {
               this.l().a((Context)var2);
               this.j().l();
            }
         } catch (Exception var13) {
            var10000 = var13;
            var10001 = false;
            break label110;
         }

         try {
            var3.addFlags(128);
            return;
         } catch (Exception var12) {
            var10000 = var12;
            var10001 = false;
         }
      }

      Exception var5 = var10000;
      var5.printStackTrace();
      StringBuilder var6 = new StringBuilder();
      var6.append("ADFInterstitialActivityImp->onCreate->");
      var6.append(var5.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var6.toString());
   }

   public void a(OnClickListener var1) {
      this.j = var1;
   }

   public void a(m var1) {
      this.f = var1;
      var1.setCloseIndicatorImageButton(this.h);
   }

   public void a(com.noqoush.adfalcon.android.sdk.nativead.a var1) {
      this.a = var1;
   }

   public void a(q var1) {
      this.d = var1;
   }

   public void a(w var1) {
      this.b = var1;
   }

   public void a(x var1) {
      this.c = var1;
   }

   public void a(String var1) {
      this.k = var1;
   }

   public void b() {
   }

   public void b(Bundle var1) {
      try {
         j.c var2 = new j.c((j$a)null);
         var2.a = this.j();
         var2.b = this.l();
         var2.c = this.o();
         var2.d = this.n();
         long var7 = Calendar.getInstance().getTimeInMillis();
         q.put(var7, var2);
         var1.putLong("key", var7);
      } catch (Exception var9) {
         StringBuilder var4 = new StringBuilder();
         var4.append("ADFActivity->onSaveInstanceState->");
         var4.append(var9.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var4.toString());
      }
   }

   public void b(Bundle var1, Activity var2, Window var3, Intent var4) {
   }

   public void b(m var1) {
      this.f = var1;
   }

   public void c() {
      com.noqoush.adfalcon.android.sdk.util.e.a((z)this.m());
   }

   public void d() {
      try {
         com.noqoush.adfalcon.android.sdk.util.e.b(this.m());
         if (this.j() == null) {
            this.g();
            return;
         }
      } catch (Exception var3) {
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFActivity->onResume->");
         var2.append(var3.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var2.toString());
      }

   }

   public void e() {
      try {
         if (this.e == null || !this.e.b()) {
            if (this.m() == null || !this.m().h()) {
               this.g();
            }
         }
      } catch (Exception var3) {
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFActivity->onBackPressed->");
         var2.append(var3.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var2.toString());
      }
   }

   public void f() {
      try {
         if (this.g != null) {
            this.g.destroy();
            return;
         }

         if (this.m() != null) {
            this.i.removeAllViews();
            this.m().e();
            return;
         }
      } catch (Exception var2) {
      }

   }

   public void g() {
      try {
         if (this.o() != null) {
            this.o().willDismissScreen();
         }

         if (this.l() != null && this.l().a() instanceof ADFInterstitial) {
            if (this.g != null) {
               this.a((m)this.g.findViewById(100));
            }

            if (this.m() != null) {
               this.m().getMraidController().setState(ADFMraidState.HIDDEN);
            }
         }
      } catch (Exception var8) {
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFActivity->finish->");
         var2.append(var8.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var2.toString());
      } finally {
         this.i().finish();
         if (this.o() != null) {
            this.o().didDismissScreen();
         }

      }

   }

   public OnClickListener h() {
      return this.j;
   }

   public Activity i() {
      return this.m;
   }

   public w j() {
      return this.b;
   }

   public Intent k() {
      return this.n;
   }

   public x l() {
      return this.c;
   }

   public m m() {
      return this.f;
   }

   public com.noqoush.adfalcon.android.sdk.nativead.a n() {
      return this.a;
   }

   public q o() {
      return this.d;
   }

   public void onClick(View var1) {
      try {
         if (var1 == this.h) {
            this.g();
            return;
         }

         if (var1 == this.i && this.l() != null && this.l().l().a().c() != null && this.l().l().a().c().length() > 5) {
            this.v();
            return;
         }
      } catch (Exception var4) {
         StringBuilder var3 = new StringBuilder();
         var3.append("ADFActivity->onViewabilityClick->");
         var3.append(var4.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
      }

   }

   public String p() {
      return this.k;
   }

   private static class c {
      public w a;
      public x b;
      public q c;
      public com.noqoush.adfalcon.android.sdk.nativead.a d;

      private c() {
      }

      // $FF: synthetic method
      c(j$a var1) {
         this();
      }
   }
}
