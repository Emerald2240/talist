package com.noqoush.adfalcon.android.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.noqoush.adfalcon.android.sdk.constant.ADFAdSize;
import com.noqoush.adfalcon.android.sdk.constant.ADFMraidPlacementType;
import com.noqoush.adfalcon.android.sdk.constant.ADFMraidState;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Vector;

public class m extends com.noqoush.adfalcon.android.sdk.viewability.d implements DownloadListener, q, ADFMraidIVideoInInterface {
   private static String F;
   long A;
   d B;
   private int C;
   private int D;
   private int E;
   private com.noqoush.adfalcon.android.sdk.response.k c;
   private w d;
   private com.noqoush.adfalcon.android.sdk.nativead.a e;
   private n f;
   private o g;
   private m.f h;
   private RelativeLayout i;
   private LayoutParams j;
   private h k;
   private ImageView l;
   private v m;
   private v n;
   private boolean o;
   private boolean p;
   protected WeakReference q;
   private WeakReference r;
   protected float s;
   private int t;
   private int u;
   int v;
   int w;
   int x;
   int y;
   ADFMraidState z;

   public m(Context var1, RelativeLayout var2, y var3, boolean var4) {
      super(var1, (Vector)null, false);
      this.p = false;
      this.t = 0;
      this.u = 0;
      this.z = ADFMraidState.LOADING;
      this.A = -1L;
      this.C = -1;
      this.D = -1;
      this.E = -1;

      Exception var10000;
      label64: {
         boolean var10001;
         try {
            this.s = com.noqoush.adfalcon.android.sdk.util.d.e(this.getContext());
            this.setParentLayout(var2);
            this.k();
         } catch (Exception var15) {
            var10000 = var15;
            var10001 = false;
            break label64;
         }

         if (var4) {
            try {
               this.getMraidModel().a(ADFMraidState.EXPANDED);
            } catch (Exception var14) {
               var10000 = var14;
               var10001 = false;
               break label64;
            }
         } else {
            try {
               this.getMraidModel().a(ADFMraidState.DEFAULT);
            } catch (Exception var13) {
               var10000 = var13;
               var10001 = false;
               break label64;
            }
         }

         int var9 = 5000;

         try {
            if (this.getController() != null && this.getController().g() != null && this.getController().g().l() != null) {
               var9 = this.getController().g().l().q().c();
            }
         } catch (Exception var12) {
            var10000 = var12;
            var10001 = false;
            break label64;
         }

         try {
            this.setWebViewClient(new p(this.getContext(), this.getController(), this.getMraidController(), var9));
         } catch (Exception var11) {
            var10000 = var11;
            var10001 = false;
            break label64;
         }

         if (var3 == null) {
            return;
         }

         try {
            this.setWebChromeClient(var3);
            return;
         } catch (Exception var10) {
            var10000 = var10;
            var10001 = false;
         }
      }

      Exception var5 = var10000;
      StringBuilder var6 = new StringBuilder();
      var6.append("ADFMraidContainer->constr:");
      var6.append(var5.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var6.toString());
   }

   public m(Context var1, RelativeLayout var2, y var3, boolean var4, w var5, p var6, com.noqoush.adfalcon.android.sdk.response.k var7) {
      super(var1, var7.e(), var7.r().contains("video"));
      this.p = false;
      this.t = 0;
      this.u = 0;
      this.z = ADFMraidState.LOADING;
      this.A = -1L;
      this.C = -1;
      this.D = -1;
      this.E = -1;

      Exception var10000;
      label49: {
         boolean var10001;
         try {
            this.s = com.noqoush.adfalcon.android.sdk.util.d.e(this.getContext());
            this.setResponse(var7);
            this.setParentLayout(var2);
            this.setController(var5);
            this.k();
         } catch (Exception var14) {
            var10000 = var14;
            var10001 = false;
            break label49;
         }

         if (var4) {
            try {
               this.getMraidModel().a(ADFMraidState.EXPANDED);
            } catch (Exception var13) {
               var10000 = var13;
               var10001 = false;
               break label49;
            }
         } else {
            try {
               this.getMraidModel().a(ADFMraidState.LOADING);
            } catch (Exception var12) {
               var10000 = var12;
               var10001 = false;
               break label49;
            }
         }

         try {
            var6.a(this.getMraidController());
            this.setWebViewClient(var6);
         } catch (Exception var11) {
            var10000 = var11;
            var10001 = false;
            break label49;
         }

         if (var3 == null) {
            return;
         }

         try {
            this.setWebChromeClient(var3);
            return;
         } catch (Exception var10) {
            var10000 = var10;
            var10001 = false;
         }
      }

      Exception var8 = var10000;
      StringBuilder var9 = new StringBuilder();
      var9.append("ADFMraidContainer->constr:");
      var9.append(var8.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var9.toString());
   }

   public m(com.noqoush.adfalcon.android.sdk.response.k var1, RelativeLayout var2, w var3, Context var4, y var5) {
      super(var4, var1.e(), var1.r().contains("video"));
      this.p = false;
      this.t = 0;
      this.u = 0;
      this.z = ADFMraidState.LOADING;
      this.A = -1L;
      this.C = -1;
      this.D = -1;
      this.E = -1;

      Exception var10000;
      label65: {
         boolean var10001;
         try {
            this.s = com.noqoush.adfalcon.android.sdk.util.d.e(this.getContext());
            if (var4 instanceof a) {
               ((a)var4).a(this);
            }
         } catch (Exception var13) {
            var10000 = var13;
            var10001 = false;
            break label65;
         }

         try {
            this.setResponse(var1);
            this.setController(var3);
            this.setParentLayout(var2);
            this.k();
            this.setWebViewClient(new p(this.getContext(), this.getController(), this.getMraidController(), this.getController().g().l().q().c()));
         } catch (Exception var12) {
            var10000 = var12;
            var10001 = false;
            break label65;
         }

         if (var5 != null) {
            try {
               this.setWebChromeClient(var5);
            } catch (Exception var11) {
               var10000 = var11;
               var10001 = false;
               break label65;
            }
         } else {
            try {
               this.setWebChromeClient(new y(var4, var2, (ProgressBar)null));
            } catch (Exception var10) {
               var10000 = var10;
               var10001 = false;
               break label65;
            }
         }

         try {
            if (var1.a().c() != null && var1.a().c().length() > 5) {
               this.setClickable(false);
            }
         } catch (Exception var9) {
            var10000 = var9;
            var10001 = false;
            break label65;
         }

         try {
            if (var1.s() != null) {
               this.loadUrl(var1.s());
               return;
            }
         } catch (Exception var14) {
            var10000 = var14;
            var10001 = false;
            break label65;
         }

         try {
            this.loadDataWithBaseURL(var1.f(), com.noqoush.adfalcon.android.sdk.util.e.a(var4, var1), "text/html", "utf-8", (String)null);
            return;
         } catch (Exception var8) {
            var10000 = var8;
            var10001 = false;
         }
      }

      Exception var6 = var10000;
      StringBuilder var7 = new StringBuilder();
      var7.append("ADFMraidContainer->constr:");
      var7.append(var6.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var7.toString());
   }

   public m(String var1, Context var2, RelativeLayout var3, y var4, boolean var5, w var6, com.noqoush.adfalcon.android.sdk.nativead.a var7) {
      Vector var8;
      if (var6 != null && var6.g() != null && var6.g().l() != null && var6.g().l().e() != null) {
         var8 = var6.g().l().e();
      } else {
         var8 = null;
      }

      boolean var9;
      if (var6 != null && var6.g() != null && var6.g().l() != null && var6.g().l().e() != null) {
         var9 = var6.g().l().r().contains("video");
      } else {
         var9 = false;
      }

      super(var2, var8, var9);
      this.p = false;
      this.t = 0;
      this.u = 0;
      this.z = ADFMraidState.LOADING;
      this.A = -1L;
      this.C = -1;
      this.D = -1;
      this.E = -1;

      Exception var10000;
      label77: {
         boolean var10001;
         try {
            this.s = com.noqoush.adfalcon.android.sdk.util.d.e(this.getContext());
            this.setNativeListenerController(var7);
            this.setParentLayout(var3);
            this.setController(var6);
            this.k();
         } catch (Exception var17) {
            var10000 = var17;
            var10001 = false;
            break label77;
         }

         if (var5) {
            try {
               this.getMraidModel().a(ADFMraidState.EXPANDED);
            } catch (Exception var16) {
               var10000 = var16;
               var10001 = false;
               break label77;
            }
         } else {
            try {
               this.getMraidModel().a(ADFMraidState.HIDDEN);
            } catch (Exception var15) {
               var10000 = var15;
               var10001 = false;
               break label77;
            }
         }

         try {
            this.setWebViewClient(new p(this.getContext(), this.getController(), this.getMraidController(), var6.g().l().q().c()));
         } catch (Exception var14) {
            var10000 = var14;
            var10001 = false;
            break label77;
         }

         if (var4 != null) {
            try {
               this.setWebChromeClient(var4);
            } catch (Exception var13) {
               var10000 = var13;
               var10001 = false;
               break label77;
            }
         }

         try {
            this.loadUrl(var1);
            return;
         } catch (Exception var12) {
            var10000 = var12;
            var10001 = false;
         }
      }

      Exception var10 = var10000;
      StringBuilder var11 = new StringBuilder();
      var11.append("ADFMraidContainer->constr:");
      var11.append(var10.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var11.toString());
   }

   private int a(int var1) {
      return (int)((float)var1 / this.s);
   }

   private void a(View var1) throws Exception {
      if (this.E == -1) {
         for(int var2 = 1; var2 < 1000000; ++var2) {
            if (var1.findViewById(var2) == null) {
               if (this.C == -1) {
                  this.C = var2;
               } else {
                  if (this.D != -1) {
                     this.E = var2;
                     return;
                  }

                  this.D = var2;
               }
            }
         }
      }

   }

   private void a(ViewGroup var1, RelativeLayout var2, boolean var3) throws Exception {
      var1.removeView(var2);
      RelativeLayout var4 = (RelativeLayout)var2.findViewById(this.E);
      var2.removeAllViews();
      var4.removeAllViews();
      this.setLayoutParams(this.j);
      this.getParentLayout().addView(this);
      this.getLayoutParams().height = this.u;
      this.getLayoutParams().width = this.t;
      this.getParentLayout().setPadding(0, 0, 0, 0);
      this.requestLayout();
      var1.invalidate();
      if (var3) {
         if (this.getController() != null) {
            this.getController().c();
         }

         this.getMraidController().close(false);
         this.invalidate();
         var1.invalidate();
      }

   }

   // $FF: synthetic method
   static void a(m var0) throws Exception {
      var0.l();
   }

   // $FF: synthetic method
   static void a(m var0, boolean var1) {
      var0.c(var1);
   }

   private int b(int var1) {
      return (int)((float)var1 * this.s);
   }

   // $FF: synthetic method
   static WeakReference c(m var0) {
      return var0.r;
   }

   private void c(boolean var1) {
      Exception var10000;
      label42: {
         boolean var10001;
         RelativeLayout var7;
         ViewGroup var6;
         try {
            if (this.C == -1 || this.getParentLayout() == null || this.j == null) {
               return;
            }

            var6 = (ViewGroup)this.getActivity().getWindow().getDecorView();
            this.a((View)var6);
            var7 = (RelativeLayout)var6.findViewById(this.C);
         } catch (Exception var10) {
            var10000 = var10;
            var10001 = false;
            break label42;
         }

         if (var7 == null) {
            return;
         }

         if (var1) {
            try {
               this.willDismissScreen();
            } catch (Exception var9) {
               var10000 = var9;
               var10001 = false;
               break label42;
            }
         }

         try {
            this.a(var6, var7, var1);
            return;
         } catch (Exception var8) {
            var10000 = var8;
            var10001 = false;
         }
      }

      Exception var2 = var10000;
      StringBuilder var3 = new StringBuilder();
      var3.append("ADFMraidContainer->resize:");
      var3.append(var2.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
   }

   // $FF: synthetic method
   static n d(m var0) {
      return var0.f;
   }

   private void e(String param1) {
      // $FF: Couldn't be decompiled
   }

   private Activity getActivity() {
      if (this.getContext() instanceof Activity) {
         return (Activity)this.getContext();
      } else {
         if (this.getParent() != null) {
            ViewGroup var1 = (ViewGroup)this.getParent();
            if (var1.getContext() instanceof Activity) {
               return (Activity)var1.getContext();
            }
         }

         return com.noqoush.adfalcon.android.sdk.util.d.c(this.getContext());
      }
   }

   private void j() {
      if (VERSION.SDK_INT >= 11) {
         this.setLayerType(1, (Paint)null);

         try {
            Class[] var2 = new Class[]{Integer.TYPE, Paint.class};
            Method var3 = View.class.getMethod("setLayerType", var2);
            Object[] var4 = new Object[]{1, new Paint()};
            var3.invoke(this, var4);
            return;
         } catch (Exception var5) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var5);
         }
      }

   }

   private void k() {
      Exception var10000;
      label169: {
         boolean var10001;
         try {
            com.noqoush.adfalcon.android.sdk.util.e.e(this);
         } catch (Exception var35) {
            var10000 = var35;
            var10001 = false;
            break label169;
         }

         byte var5 = 1;

         o var6;
         label170: {
            label157:
            try {
               this.setScrollContainer((boolean)var5);
               this.setVerticalScrollBarEnabled(false);
               this.setHorizontalScrollBarEnabled(false);
               this.setScrollBarStyle(0);
               this.setScrollbarFadingEnabled((boolean)var5);
               var6 = new o();
               this.g = var6;
               if (this.getResponse() == null || this.getResponse().q().b() != var5) {
                  break label157;
               }
               break label170;
            } catch (Exception var34) {
               var10000 = var34;
               var10001 = false;
               break label169;
            }

            var5 = 0;
         }

         try {
            var6.a((boolean)var5);
            this.f = new n(this, this.g);
            if (this.getController() != null && this.getController().g().B()) {
               this.f.setPlacementType(ADFMraidPlacementType.INTERSTITIAL);
            }
         } catch (Exception var33) {
            var10000 = var33;
            var10001 = false;
            break label169;
         }

         float var11;
         float var13;
         int var12;
         label146: {
            int var9;
            float var10;
            label145: {
               Display var7;
               try {
                  var7 = ((WindowManager)this.getContext().getSystemService("window")).getDefaultDisplay();
                  if (VERSION.SDK_INT >= 13) {
                     Point var8 = new Point();
                     var7.getSize(var8);
                     var9 = (int)((float)var8.x / this.s);
                     var10 = (float)var8.y;
                     var11 = this.s;
                     break label145;
                  }
               } catch (Exception var32) {
                  var10000 = var32;
                  var10001 = false;
                  break label169;
               }

               try {
                  var12 = (int)((float)var7.getWidth() / this.s);
                  var13 = (float)var7.getHeight();
                  var11 = this.s;
                  break label146;
               } catch (Exception var31) {
                  var10000 = var31;
                  var10001 = false;
                  break label169;
               }
            }

            var12 = var9;
            var13 = var10;
         }

         int var14;
         label134: {
            try {
               var14 = (int)(var13 / var11);
               if (this.getActivity() != null) {
                  Rect var15 = new Rect();
                  Rect var16 = new Rect();
                  Window var17 = this.getActivity().getWindow();
                  var17.getDecorView().getGlobalVisibleRect(var15);
                  var17.getDecorView().getWindowVisibleDisplayFrame(var16);
                  int var19 = var16.top - var15.top;
                  this.f.setMaxSize((int)((float)var15.right / this.s), (int)((float)var15.bottom / this.s) - (int)((float)var19 / this.s));
                  break label134;
               }
            } catch (Exception var30) {
               var10000 = var30;
               var10001 = false;
               break label169;
            }

            try {
               this.f.setMaxSize(var12, var14 - com.noqoush.adfalcon.android.sdk.util.d.a(this.getContext(), 28));
            } catch (Exception var29) {
               var10000 = var29;
               var10001 = false;
               break label169;
            }
         }

         label167: {
            try {
               this.f.setScreenSize(var12, var14);
               if (this.getController() == null || this.getController().g().B()) {
                  break label167;
               }
            } catch (Exception var28) {
               var10000 = var28;
               var10001 = false;
               break label169;
            }

            label168: {
               try {
                  if (this.getController().g().q() == ADFAdSize.AD_UNIT_120x600) {
                     break label168;
                  }
               } catch (Exception var27) {
                  var10000 = var27;
                  var10001 = false;
                  break label169;
               }

               label109: {
                  try {
                     if (this.getController().g().q() != ADFAdSize.AD_UNIT_300x250) {
                        break label109;
                     }
                  } catch (Exception var26) {
                     var10000 = var26;
                     var10001 = false;
                     break label169;
                  }

                  var12 = 300;
                  var14 = 250;
                  break label167;
               }

               label103: {
                  try {
                     if (this.getController().g().q() != ADFAdSize.AD_UNIT_320x50) {
                        break label103;
                     }
                  } catch (Exception var25) {
                     var10000 = var25;
                     var10001 = false;
                     break label169;
                  }

                  var12 = 320;
                  var14 = 50;
                  break label167;
               }

               label97: {
                  try {
                     if (this.getController().g().q() != ADFAdSize.AD_UNIT_468x60) {
                        break label97;
                     }
                  } catch (Exception var24) {
                     var10000 = var24;
                     var10001 = false;
                     break label169;
                  }

                  var12 = 468;
                  var14 = 60;
                  break label167;
               }

               label91: {
                  try {
                     if (this.getController().g().q() != ADFAdSize.AD_UNIT_728x90) {
                        break label91;
                     }
                  } catch (Exception var23) {
                     var10000 = var23;
                     var10001 = false;
                     break label169;
                  }

                  var12 = 728;
                  var14 = 90;
                  break label167;
               }

               try {
                  var12 = this.getController().g().d();
                  var14 = this.getController().g().c();
                  break label167;
               } catch (Exception var22) {
                  var10000 = var22;
                  var10001 = false;
                  break label169;
               }
            }

            var12 = 120;
            var14 = 600;
         }

         try {
            this.getMraidController().setDefaultPosition(0, 0, var12, var14);
            this.getMraidController().setCurrentPosition(0, 0, var12, var14);
            if (this.getResponse() != null && !this.getResponse().q().h()) {
               this.j();
            }
         } catch (Exception var21) {
            var10000 = var21;
            var10001 = false;
            break label169;
         }

         try {
            this.setDownloadListener(this);
            return;
         } catch (Exception var20) {
            var10000 = var20;
            var10001 = false;
         }
      }

      Exception var1 = var10000;
      StringBuilder var2 = new StringBuilder();
      var2.append("ADFMraidContainer->initViewability:");
      var2.append(var1.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var2.toString());
   }

   private void l() throws Exception {
      Display var1 = ((WindowManager)this.getContext().getSystemService("window")).getDefaultDisplay();
      int var5;
      int var6;
      if (VERSION.SDK_INT >= 13) {
         Point var2 = new Point();
         var1.getSize(var2);
         float var3 = (float)var2.x;
         float var4 = this.s;
         var5 = (int)(var3 / var4);
         var6 = (int)((float)var2.y / var4);
      } else {
         int var18 = (int)((float)var1.getWidth() / this.s);
         var6 = (int)((float)var1.getHeight() / this.s);
         var5 = var18;
      }

      if (this.getActivity() != null) {
         Rect var7 = new Rect();
         Rect var8 = new Rect();
         Window var9 = this.getActivity().getWindow();
         var9.getDecorView().getGlobalVisibleRect(var7);
         var9.getDecorView().getWindowVisibleDisplayFrame(var8);
         int var11 = var8.top - var7.top;
         n var12 = this.f;
         float var13 = (float)var7.right;
         float var14 = this.s;
         var12.setMaxSize((int)(var13 / var14), (int)((float)var7.bottom / var14) - (int)((float)var11 / var14));
      } else {
         this.f.setMaxSize(var5, var6 - com.noqoush.adfalcon.android.sdk.util.d.a(this.getContext(), 28));
      }

      this.f.setScreenSize(var5, var6);
      int var15 = this.a(this.getWidth());
      int var16 = this.a(this.getHeight());
      int[] var17 = new int[]{0, 0};
      this.getLocationOnScreen(var17);
      this.getMraidController().setCurrentPosition(this.a(var17[0]), this.a(var17[1]), var15, var16);
      this.getMraidController().fireSizeChangeEvent(var15, var16);
   }

   private void m() {
      Display var1 = ((WindowManager)this.getContext().getSystemService("window")).getDefaultDisplay();
      int var5;
      int var6;
      if (VERSION.SDK_INT >= 13) {
         Point var2 = new Point();
         var1.getSize(var2);
         float var3 = (float)var2.x;
         float var4 = this.s;
         var5 = (int)(var3 / var4);
         var6 = (int)((float)var2.y / var4);
      } else {
         int var7 = (int)((float)var1.getWidth() / this.s);
         var6 = (int)((float)var1.getHeight() / this.s);
         var5 = var7;
      }

      this.setLayoutParams(new android.view.ViewGroup.LayoutParams(var5, var6));
   }

   public void a(Context var1) {
      if (this.getContext() instanceof MutableContextWrapper) {
         ((MutableContextWrapper)this.getContext()).setBaseContext(var1);
      }

      ((y)this.q.get()).a(var1);
      ((p)this.r.get()).a(var1);
   }

   public void a(boolean var1) {
      Exception var10000;
      label51: {
         boolean var10001;
         try {
            this.d();
         } catch (Exception var10) {
            var10000 = var10;
            var10001 = false;
            break label51;
         }

         if (var1) {
            try {
               this.willDismissScreen();
            } catch (Exception var9) {
               var10000 = var9;
               var10001 = false;
               break label51;
            }
         }

         try {
            this.closeIVideo();
            if (this.k != null) {
               this.k.dismiss();
               return;
            }
         } catch (Exception var11) {
            var10000 = var11;
            var10001 = false;
            break label51;
         }

         try {
            Activity var6 = com.noqoush.adfalcon.android.sdk.util.d.c(((View)this.getParent()).getContext());
            if (!var6.isFinishing()) {
               var6.finish();
            }
         } catch (Exception var8) {
            var10000 = var8;
            var10001 = false;
            break label51;
         }

         if (!var1) {
            return;
         }

         try {
            this.didDismissScreen();
            return;
         } catch (Exception var7) {
            var10000 = var7;
            var10001 = false;
         }
      }

      Exception var2 = var10000;
      StringBuilder var3 = new StringBuilder();
      var3.append("ADFMraidContainer->close:");
      var3.append(var2.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
   }

   public void b(String param1) {
      // $FF: Couldn't be decompiled
   }

   protected void b(boolean var1) throws Exception {
      if (this.getMraidModel().i() != ADFMraidPlacementType.INTERSTITIAL || this.getResponse().q().a() != 2 || this.getCloseIndicatorImageButton() != null) {
         ImageView var2 = this.getCloseIndicatorImageButton();
         byte var3;
         if (var1) {
            var3 = 4;
         } else {
            var3 = 0;
         }

         var2.setVisibility(var3);
      }
   }

   public void c(String var1) {
      Exception var10000;
      label106: {
         boolean var10001;
         try {
            this.e(var1);
            if (this.getController() != null && this.getController().i() == w.e.c) {
               this.getController().o();
               this.getController().e();
            }
         } catch (Exception var20) {
            var10000 = var20;
            var10001 = false;
            break label106;
         }

         try {
            if (this.getNativeListenerController() != null) {
               this.getNativeListenerController().c();
            }
         } catch (Exception var19) {
            var10000 = var19;
            var10001 = false;
            break label106;
         }

         label96: {
            try {
               if (this.n == null || !var1.toLowerCase().startsWith("http") || var1.toLowerCase().contains("youtube")) {
                  break label96;
               }

               this.B = new d(var1, this.getContext(), this.getMraidController());
               if (this.getController() != null) {
                  com.noqoush.adfalcon.android.sdk.d.g = this.getController();
               }
            } catch (Exception var18) {
               var10000 = var18;
               var10001 = false;
               break label106;
            }

            try {
               this.B.f();
               return;
            } catch (Exception var12) {
               var10000 = var12;
               var10001 = false;
               break label106;
            }
         }

         boolean var8;
         com.noqoush.adfalcon.android.sdk.handler.c var6;
         com.noqoush.adfalcon.android.sdk.urlactions.g var7;
         label82: {
            label81: {
               label80: {
                  try {
                     var6 = new com.noqoush.adfalcon.android.sdk.handler.c();
                     var7 = new com.noqoush.adfalcon.android.sdk.urlactions.g() {
                        public void a() {
                        }

                        public void a(com.noqoush.adfalcon.android.sdk.urlactions.i var1, com.noqoush.adfalcon.android.sdk.urlactions.m var2) {
                           try {
                              if (m$e.a[var1.ordinal()] != 1) {
                                 return;
                              }

                              if (var2 != com.noqoush.adfalcon.android.sdk.urlactions.m.a && m.this.getController() != null) {
                                 m.this.getController().f();
                                 return;
                              }
                           } catch (Exception var5) {
                              StringBuilder var4 = new StringBuilder();
                              var4.append("ADFMraidContainer->open->onSuccess:");
                              var4.append(var5.toString());
                              com.noqoush.adfalcon.android.sdk.k.b(var4.toString());
                           }

                        }
                     };
                     if (this.c == null) {
                        break label80;
                     }
                  } catch (Exception var17) {
                     var10000 = var17;
                     var10001 = false;
                     break label106;
                  }

                  try {
                     if (!this.c.q().g()) {
                        break label81;
                     }
                  } catch (Exception var16) {
                     var10000 = var16;
                     var10001 = false;
                     break label106;
                  }
               }

               var8 = false;
               break label82;
            }

            var8 = true;
         }

         Context var9;
         try {
            var9 = this.getContext();
         } catch (Exception var15) {
            var10000 = var15;
            var10001 = false;
            break label106;
         }

         boolean var10 = false;
         if (var9 != null) {
            boolean var11;
            try {
               var11 = this.getContext() instanceof ADFBrowser;
            } catch (Exception var14) {
               var10000 = var14;
               var10001 = false;
               break label106;
            }

            var10 = false;
            if (var11) {
               var10 = true;
            }
         }

         try {
            if (var6.a(this.getContext(), var1, var10, var8, var7, this) && this.getController() != null) {
               ADFBrowser.c = this.getController();
               return;
            }

            return;
         } catch (Exception var13) {
            var10000 = var13;
            var10001 = false;
         }
      }

      Exception var2 = var10000;
      StringBuilder var3 = new StringBuilder();
      var3.append("ADFMraidContainer->open:");
      var3.append(var2.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
   }

   public void closeIVideo() throws Exception {
      v var1 = this.n;
      if (var1 != null) {
         var1.closeIVideo();
         this.n = null;
      }

   }

   protected void d(String var1) {
      try {
         ADFActivity.b = new l();
         Intent var3 = new Intent(this.getActivity(), ADFActivity.class);
         var3.putExtra("url", var1);
         this.getActivity().startActivity(var3);
         if (this.n != null) {
            this.n.a();
            this.getMraidController().setViewableChange(false);
            if (this.m != null) {
               this.m.setVideoView(this.n);
               this.m.setMraidInterface(this.getMraidController());
               return;
            }
         }
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.k.b(var4.toString());
      }

   }

   public void didDismissScreen() {
      try {
         if (this.getParentLayout() != null && this.getParent() == null && this.j != null) {
            this.setLayoutParams(this.j);
            this.getLayoutParams().height = this.u;
            this.getLayoutParams().width = this.t;
            this.getParentLayout().addView(this);
            this.getParentLayout().setPadding(0, 0, 0, 0);
         }

         if (this.getController() != null) {
            this.getController().c();
         }

         this.getMraidController().close(false);
         this.k = null;
         if (this.getMraidModel().h() != null) {
            this.getActivity().setRequestedOrientation(-1);
         }

         if (this.getMraidModel().i() == ADFMraidPlacementType.INTERSTITIAL) {
            this.a(false);
            return;
         }
      } catch (Exception var3) {
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFMraidContainer->didDimissScreen:");
         var2.append(var3.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var2.toString());
      }

   }

   public void didPresentScreen() {
      try {
         if (this.getController() != null) {
            this.getController().e();
         }

         if (this.getNativeListenerController() != null) {
            this.getNativeListenerController().c();
            return;
         }
      } catch (Exception var3) {
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFMraidContainer->didPresentScreen:");
         var2.append(var3.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var2.toString());
      }

   }

   public void e() {
      // $FF: Couldn't be decompiled
   }

   public boolean f() {
      return this.p;
   }

   protected void g() {
      Exception var10000;
      label45: {
         boolean var10001;
         o.b var5;
         try {
            var5 = this.getMraidModel().h();
            if (this.getActivity() == null) {
               return;
            }
         } catch (Exception var17) {
            var10000 = var17;
            var10001 = false;
            break label45;
         }

         if (var5 == null) {
            return;
         }

         int var11;
         float var12;
         float var10;
         label35: {
            Display var6;
            label34: {
               int var8;
               float var9;
               try {
                  var6 = ((WindowManager)this.getActivity().getSystemService("window")).getDefaultDisplay();
                  if (VERSION.SDK_INT < 13) {
                     break label34;
                  }

                  Point var7 = new Point();
                  var6.getSize(var7);
                  var8 = (int)((float)var7.x / this.s);
                  var9 = (float)var7.y;
                  var10 = this.s;
               } catch (Exception var16) {
                  var10000 = var16;
                  var10001 = false;
                  break label45;
               }

               var11 = var8;
               var12 = var9;
               break label35;
            }

            try {
               var11 = (int)((float)var6.getWidth() / this.s);
               var12 = (float)var6.getHeight();
               var10 = this.s;
            } catch (Exception var15) {
               var10000 = var15;
               var10001 = false;
               break label45;
            }
         }

         try {
            int var13 = (int)(var12 / var10);
            com.noqoush.adfalcon.android.sdk.util.d.a(this.getActivity(), var5.b(), var5.a(), var11, var13);
            return;
         } catch (Exception var14) {
            var10000 = var14;
            var10001 = false;
         }
      }

      Exception var1 = var10000;
      StringBuilder var2 = new StringBuilder();
      var2.append("ADFMraidContainer->onChangeOrientationProperties:");
      var2.append(var1.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var2.toString());
   }

   protected ImageView getCloseIndicatorImageButton() {
      return this.l;
   }

   public w getController() {
      return this.d;
   }

   protected n getMraidController() {
      return this.f;
   }

   protected o getMraidModel() {
      return this.g;
   }

   public com.noqoush.adfalcon.android.sdk.nativead.a getNativeListenerController() {
      return this.e;
   }

   public RelativeLayout getParentLayout() {
      return this.i;
   }

   public com.noqoush.adfalcon.android.sdk.response.k getResponse() {
      return this.c;
   }

   protected boolean h() {
      try {
         if (this.m != null && this.m.d()) {
            if (this.n != null) {
               this.n.f();
               this.getMraidController().setViewableChange(true);
            }

            return true;
         }

         if (this.n != null && this.n.d()) {
            this.n = null;
            this.a(true);
            return true;
         }
      } catch (Exception var5) {
         com.noqoush.adfalcon.android.sdk.k.b(var5.getMessage());
      } finally {
         this.m = null;
      }

      return false;
   }

   protected void i() {
      Exception var10000;
      label114: {
         boolean var10001;
         int var6;
         int var7;
         int var8;
         int var9;
         String var10;
         label112: {
            int var24;
            try {
               this.e((String)null);
               this.willPresentScreen();
               this.getController().n();
               int[] var5 = new int[]{0, 0};
               this.getLocationOnScreen(var5);
               var6 = this.getMraidModel().j().c() + this.a(var5[0]);
               var7 = this.getMraidModel().j().d() + this.a(var5[1]);
               var8 = this.getMraidModel().j().e();
               var9 = this.getMraidModel().j().b();
               var10 = this.getMraidModel().j().a();
               if (this.getMraidModel().j().f()) {
                  break label112;
               }

               var24 = var6 + var8 - this.getMraidModel().g();
            } catch (Exception var36) {
               var10000 = var36;
               var10001 = false;
               break label114;
            }

            if (var24 > 0) {
               var6 -= var24;
            }

            int var25;
            try {
               var25 = var7 + var9 - this.getMraidModel().f() - (this.getMraidModel().k() - this.getMraidModel().f());
            } catch (Exception var35) {
               var10000 = var35;
               var10001 = false;
               break label114;
            }

            if (var25 > 0) {
               var7 -= var25;
            }
         }

         Activity var11;
         com.noqoush.adfalcon.android.sdk.images.b var14;
         RelativeLayout var13;
         ViewGroup var12;
         try {
            var11 = this.getActivity();
            var12 = (ViewGroup)var11.getWindow().getDecorView();
            this.a((View)var12);
            var13 = (RelativeLayout)var12.findViewById(this.C);
            var14 = new com.noqoush.adfalcon.android.sdk.images.b();
         } catch (Exception var34) {
            var10000 = var34;
            var10001 = false;
            break label114;
         }

         ImageView var21;
         RelativeLayout var18;
         if (var13 == null) {
            try {
               int var15 = (int)(50.0F * this.s);
               RelativeLayout var16 = (RelativeLayout)this.getParent();
               this.setParentLayout(var16);
               this.getParentLayout().setPadding(0, 0, 0, this.u);
               this.getParentLayout().requestLayout();
               this.j = (LayoutParams)this.getLayoutParams();
               var16.removeAllViews();
               RelativeLayout var17 = new RelativeLayout(this.getContext());
               var17.setId(this.C);
               var12.addView(var17, new android.widget.LinearLayout.LayoutParams(-1, -1));
               var18 = new RelativeLayout(this.getContext());
               var18.setId(this.E);
               LayoutParams var19 = new LayoutParams(-2, -2);
               var19.addRule(10);
               var18.setLayoutParams(var19);
               var17.addView(var18);
               LayoutParams var20 = new LayoutParams(this.b(var8), this.b(var9));
               var20.addRule(10);
               this.setLayoutParams(var20);
               var18.addView(this);
               var21 = new ImageView(this.getContext());
               var21.setId(this.D);
               var21.setImageBitmap(var14.b(var11));
               var21.setMinimumHeight(var15);
               var21.setMinimumWidth(var15);
               var21.setScaleType(ScaleType.FIT_XY);
               var21.setBackgroundColor(0);
               var21.setOnClickListener(new m$c(this));
            } catch (Exception var33) {
               var10000 = var33;
               var10001 = false;
               break label114;
            }
         } else {
            try {
               var18 = (RelativeLayout)var13.findViewById(this.E);
               var21 = (ImageView)var18.findViewById(this.D);
            } catch (Exception var32) {
               var10000 = var32;
               var10001 = false;
               break label114;
            }
         }

         LayoutParams var22;
         label115: {
            try {
               var18.removeView(var21);
               var22 = new LayoutParams(this.b(50), this.b(50));
               if (var10.equalsIgnoreCase("bottom-left")) {
                  var22.addRule(12);
                  var22.addRule(9);
                  break label115;
               }
            } catch (Exception var31) {
               var10000 = var31;
               var10001 = false;
               break label114;
            }

            try {
               if (var10.equalsIgnoreCase("bottom-right")) {
                  var22.addRule(12);
                  var22.addRule(11);
                  break label115;
               }
            } catch (Exception var30) {
               var10000 = var30;
               var10001 = false;
               break label114;
            }

            try {
               if (var10.equalsIgnoreCase("top-left")) {
                  var22.addRule(10);
                  var22.addRule(9);
                  break label115;
               }
            } catch (Exception var29) {
               var10000 = var29;
               var10001 = false;
               break label114;
            }

            try {
               if (var10.equalsIgnoreCase("top-right")) {
                  var22.addRule(11);
                  var22.addRule(10);
                  break label115;
               }
            } catch (Exception var28) {
               var10000 = var28;
               var10001 = false;
               break label114;
            }

            try {
               var22.addRule(13);
            } catch (Exception var27) {
               var10000 = var27;
               var10001 = false;
               break label114;
            }
         }

         try {
            var21.setLayoutParams(var22);
            var18.addView(var21);
            LayoutParams var23 = (LayoutParams)var18.getLayoutParams();
            var23.setMargins(this.b(var6), this.b(var7), 0, 0);
            var23.height = this.b(var9);
            var23.width = this.b(var8);
            var18.invalidate();
            var18.requestLayout();
            this.getParentLayout().setPadding(0, 0, 0, this.u);
            this.getParentLayout().requestLayout();
            this.didPresentScreen();
            return;
         } catch (Exception var26) {
            var10000 = var26;
            var10001 = false;
         }
      }

      Exception var1 = var10000;
      StringBuilder var2 = new StringBuilder();
      var2.append("ADFMraidContainer->resize:");
      var2.append(var1.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var2.toString());
   }

   public void muteIVideo() throws Exception {
      v var1 = this.n;
      if (var1 != null) {
         var1.muteIVideo();
      }

   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();

      try {
         if (this.getMraidController() != null) {
            this.getMraidController().setViewableChange(true);
            if (this.t == 0) {
               this.t = this.getWidth();
               this.u = this.getHeight();
            }

            if (this.getMraidController().f()) {
               this.getMraidController().runTiltSensor();
               return;
            }
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);

      try {
         this.postDelayed(new m$a(this), 200L);
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }

   protected void onDetachedFromWindow() {
      try {
         if (this.getMraidController() != null) {
            this.getMraidController().setViewableChange(false);
            this.getMraidController().stopTiltSensor();
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

      super.onDetachedFromWindow();
   }

   public void onDownloadStart(String param1, String param2, String param3, String param4, long param5) {
      // $FF: Couldn't be decompiled
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      label54: {
         Exception var10000;
         label53: {
            boolean var10001;
            label56: {
               try {
                  if (this.z == this.getMraidModel().m() && this.getMraidModel().m() != ADFMraidState.LOADING) {
                     break label56;
                  }
               } catch (Exception var12) {
                  var10000 = var12;
                  var10001 = false;
                  break label53;
               }

               label50: {
                  int var8;
                  try {
                     if (this.v != var2 || this.w != var3 || this.x != var4) {
                        break label50;
                     }

                     var8 = this.y;
                  } catch (Exception var13) {
                     var10000 = var13;
                     var10001 = false;
                     break label53;
                  }

                  if (var8 == var5) {
                     break label56;
                  }
               }

               try {
                  this.l();
               } catch (Exception var11) {
                  Exception var7 = var11;

                  try {
                     com.noqoush.adfalcon.android.sdk.k.b(var7.getMessage());
                  } catch (Exception var10) {
                     var10000 = var10;
                     var10001 = false;
                     break label53;
                  }
               }
            }

            try {
               this.z = this.getMraidModel().m();
               this.v = var2;
               this.w = var3;
               this.x = var4;
               this.y = var5;
               break label54;
            } catch (Exception var9) {
               var10000 = var9;
               var10001 = false;
            }
         }

         Exception var6 = var10000;
         com.noqoush.adfalcon.android.sdk.util.a.a(var6);
      }

      super.onLayout(var1, var2, var3, var4, var5);
   }

   public boolean onTouchEvent(MotionEvent var1) {
      try {
         if (!this.isClickable()) {
            return false;
         } else {
            boolean var6 = super.onTouchEvent(var1);
            return var6;
         }
      } catch (Exception var7) {
         StringBuilder var3 = new StringBuilder();
         var3.append("ADFMraidContainer->constr:");
         var3.append(var7.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
         return this.isClickable();
      }
   }

   public void onWindowFocusChanged(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onWindowVisibilityChanged(int var1) {
      super.onWindowVisibilityChanged(var1);
      StringBuilder var2 = new StringBuilder();
      var2.append("onWindowVisibilityChanged(");
      var2.append(var1);
      var2.append(") mHasWindowFocus: ");
      var2.append(this.o);
      com.noqoush.adfalcon.android.sdk.k.e(var2.toString());
      boolean var10001;
      if (var1 == 0) {
         label54: {
            label64: {
               try {
                  if (this.getMraidController() == null) {
                     break label54;
                  }

                  if (this.B != null && this.B.e()) {
                     this.getMraidController().setViewableChange(false);
                     break label64;
                  }
               } catch (Exception var12) {
                  var10001 = false;
                  return;
               }

               try {
                  this.getMraidController().setViewableChange(true);
               } catch (Exception var11) {
                  var10001 = false;
                  return;
               }
            }

            try {
               if (this.getMraidController().f()) {
                  this.getMraidController().runTiltSensor();
               }
            } catch (Exception var10) {
               var10001 = false;
               return;
            }
         }

         try {
            IntentFilter var8 = new IntentFilter("android.intent.action.SCREEN_ON");
            var8.addAction("android.intent.action.SCREEN_OFF");
            this.h = new m.f((m$a)null);
            this.getContext().registerReceiver(this.h, var8);
            return;
         } catch (Exception var9) {
            var10001 = false;
         }
      } else {
         try {
            if (this.getMraidController() != null) {
               this.getMraidController().setViewableChange(false);
               this.getMraidController().stopTiltSensor();
            }
         } catch (Exception var14) {
            var10001 = false;
            return;
         }

         try {
            this.getContext().unregisterReceiver(this.h);
            this.h.clearAbortBroadcast();
            this.h = null;
            return;
         } catch (Exception var13) {
            var10001 = false;
         }
      }

   }

   public void pauseIVideo() throws Exception {
      v var1 = this.n;
      if (var1 != null) {
         var1.pauseIVideo();
      }

   }

   public void playIVideo(String var1) throws Exception {
      WebSettings var2 = this.getSettings();
      var2.setBuiltInZoomControls(false);
      var2.setSupportZoom(false);
      var2.setUseWideViewPort(false);
      Object var3;
      if (this.getMraidModel().i() == ADFMraidPlacementType.INTERSTITIAL) {
         this.getParentLayout();
         this.j = (LayoutParams)this.getLayoutParams();
         this.getParentLayout().removeAllViews();
         var3 = new RelativeLayout(this.getContext());
         ((RelativeLayout)var3).addView(this, this.j);
         LayoutParams var10 = new LayoutParams(com.noqoush.adfalcon.android.sdk.util.f.a(), com.noqoush.adfalcon.android.sdk.util.f.a());
         var10.addRule(13);
         this.getParentLayout().addView((View)var3, var10);
      } else {
         var3 = (ViewGroup)this.getParent();
      }

      if (var3 != null) {
         if (this.n == null) {
            Context var5 = this.getContext();
            ImageView var6 = this.getCloseIndicatorImageButton();
            n var7 = this.getMraidController();
            v var8 = new v(var5, var1, (ViewGroup)var3, (w)null, var6, var7);
            this.n = var8;
         }

         this.n.playIVideo(var1);
         this.bringToFront();
         this.requestLayout();
         this.invalidate();
         ((ViewGroup)var3).requestLayout();
         ((ViewGroup)var3).invalidate();
         this.requestFocus();
         this.setFocusable(true);
      } else {
         throw new Exception("The parent of mraid container is null");
      }
   }

   public void replayIVideo() throws Exception {
      v var1 = this.n;
      if (var1 != null) {
         var1.replayIVideo();
      }

   }

   public void resumeIVideo() throws Exception {
      v var1 = this.n;
      if (var1 != null) {
         var1.resumeIVideo();
      }

   }

   public void seekIVideo(long var1) throws Exception {
      v var3 = this.n;
      if (var3 != null) {
         var3.seekIVideo(var1);
      }

   }

   protected void setCloseIndicatorImageButton(ImageView var1) {
      this.l = var1;
   }

   public void setController(w var1) {
      this.d = var1;
   }

   public void setNativeListenerController(com.noqoush.adfalcon.android.sdk.nativead.a var1) {
      this.e = var1;
   }

   public void setParentLayout(RelativeLayout var1) {
      this.i = var1;
      WeakReference var2 = this.q;
      if (var2 != null) {
         ((y)var2.get()).a(var1);
      }

   }

   public void setResponse(com.noqoush.adfalcon.android.sdk.response.k var1) {
      this.c = var1;
   }

   public void setShouldCallTrackers(boolean var1) {
      this.p = var1;
   }

   public void setWebChromeClient(WebChromeClient var1) {
      if (var1 instanceof y) {
         this.q = new WeakReference((y)var1);
      } else {
         com.noqoush.adfalcon.android.sdk.k.e("WebChromeClient is not instance of ADFWebChromeClient");
      }

      super.setWebChromeClient(var1);
   }

   public void setWebViewClient(WebViewClient var1) {
      if (var1 instanceof WebViewClient) {
         this.r = new WeakReference((p)var1);
      } else {
         com.noqoush.adfalcon.android.sdk.k.e("WebViewClient is not instance of ADFMraidWebViewClient");
      }

      super.setWebViewClient(var1);
   }

   public void unMuteIVideo() throws Exception {
      v var1 = this.n;
      if (var1 != null) {
         var1.unMuteIVideo();
      }

   }

   public void willDismissScreen() {
   }

   public void willPresentScreen() {
   }

   private class f extends BroadcastReceiver {
      private f() {
      }

      // $FF: synthetic method
      f(m$a var2) {
         this();
      }

      public void onReceive(Context var1, Intent var2) {
         try {
            StringBuilder var3 = new StringBuilder();
            var3.append("ScreenReceiver: ");
            var3.append(var2.getAction());
            com.noqoush.adfalcon.android.sdk.k.e(var3.toString());
            if (var2.getAction().equals("android.intent.action.SCREEN_OFF")) {
               if (m.this.getMraidController() != null) {
                  m.this.getMraidController().setViewableChange(false);
                  return;
               }
            } else if (var2.getAction().equals("android.intent.action.SCREEN_ON") && m.this.getMraidController() != null) {
               if (m.this.B != null && m.this.B.e()) {
                  m.this.getMraidController().setViewableChange(false);
                  return;
               }

               m.this.getMraidController().setViewableChange(m.this.o);
               return;
            }
         } catch (Exception var5) {
            com.noqoush.adfalcon.android.sdk.k.b(var5.toString());
         }

      }
   }
}
