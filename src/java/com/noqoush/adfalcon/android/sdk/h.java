package com.noqoush.adfalcon.android.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnKeyListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class h extends RelativeLayout implements DialogInterface {
   private static final int n = 100;
   private Activity a;
   private View b;
   private View c;
   private ViewGroup d;
   private View e;
   private boolean f;
   private OnDismissListener g;
   private OnKeyListener h;
   private boolean i = true;
   private boolean j = false;
   private int k;
   private int l;
   private int m;

   public h(Context var1) {
      super(var1);
      this.a(var1, 0);
   }

   public h(Context var1, int var2) {
      super(var1);
      this.a(var1, var2);
   }

   private void a(Context var1, int var2) {
      try {
         Activity var7 = com.noqoush.adfalcon.android.sdk.util.d.c((Context)((Activity)var1));
         this.a = var7;
         this.m = var2;
         this.d = (ViewGroup)var7.findViewById(16908290);
         this.e = this.a.findViewById(16908310);
         this.setBackgroundColor(0);
         LayoutParams var8 = new LayoutParams(com.noqoush.adfalcon.android.sdk.util.f.a(), com.noqoush.adfalcon.android.sdk.util.f.a());
         var8.addRule(13);
         this.setLayoutParams(var8);
         this.setId(100);
      } catch (Exception var9) {
         StringBuilder var4 = new StringBuilder();
         var4.append("ADFDialog->initViewability: ");
         var4.append(var9.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var4.toString());
      }
   }

   private void b() throws Exception {
      Rect var1 = new Rect();
      Rect var2 = new Rect();
      Window var3 = this.a.getWindow();
      var3.getDecorView().getGlobalVisibleRect(var1);
      var3.getDecorView().getWindowVisibleDisplayFrame(var2);
      int var5 = var2.top - var1.top;
      this.k = var5;
      boolean var6;
      if (var5 != 0) {
         var6 = true;
      } else {
         var6 = false;
      }

      this.i = var6;
   }

   public void a() throws Exception {
      this.b();
      this.d.addView(this, new android.view.ViewGroup.LayoutParams(com.noqoush.adfalcon.android.sdk.util.f.a(), com.noqoush.adfalcon.android.sdk.util.f.a()));
      if (this.m == 16973841) {
         this.a.getWindow().setFlags(1024, 1024);
         View var3 = this.e;
         if (var3 != null && var3.getParent() != null) {
            View var10 = (View)this.e.getParent();
            this.l = var10.getLayoutParams().height;
            var10.getLayoutParams().height = 0;
         }

         if (VERSION.SDK_INT >= 11 && this.a.getActionBar() != null) {
            this.j = this.a.getActionBar().isShowing();
            this.a.getActionBar().hide();
         } else {
            label60: {
               boolean var10001;
               Class var5;
               try {
                  var5 = this.a.getClass();
               } catch (Exception var15) {
                  var10001 = false;
                  break label60;
               }

               Object var6;
               try {
                  var6 = var5.getMethod("getSupportActionBar", (Class[])null).invoke(this.a, new Object[0]);
               } catch (Exception var14) {
                  var10001 = false;
                  break label60;
               }

               if (var6 != null) {
                  label62: {
                     Class var7;
                     try {
                        var7 = var6.getClass();
                     } catch (Exception var13) {
                        var10001 = false;
                        break label62;
                     }

                     Class var8;
                     try {
                        this.j = (Boolean)var7.getMethod("isShowing", (Class[])null).invoke(var6, new Object[0]);
                        var8 = var6.getClass();
                     } catch (Exception var12) {
                        var10001 = false;
                        break label62;
                     }

                     try {
                        var8.getMethod("hide", (Class[])null).invoke(var6, new Object[0]);
                     } catch (Exception var11) {
                        var10001 = false;
                     }
                  }
               }
            }
         }
      } else {
         this.e = null;
      }

      this.requestFocus();
      this.c.setFocusable(true);
      this.c.requestFocus();
   }

   public void a(int var1) {
   }

   public void a(OnDismissListener var1) {
      this.g = var1;
   }

   public void a(View var1) throws Exception {
      RelativeLayout var2 = new RelativeLayout(this.getContext());
      LayoutParams var3 = new LayoutParams(com.noqoush.adfalcon.android.sdk.util.f.a(), com.noqoush.adfalcon.android.sdk.util.f.a());
      var3.addRule(5);
      var3.addRule(6);
      var2.setLayoutParams(var3);
      this.addView(var2);
      this.b = var2;
      var3.addRule(13);
      var2.addView(var1, var3);
      this.c = var1;
   }

   public void a(boolean var1) {
      this.f = var1;
   }

   public void cancel() {
      this.dismiss();
   }

   public void dismiss() {
      Exception var10000;
      label88: {
         boolean var10001;
         try {
            if (this.i) {
               this.a.getWindow().clearFlags(1024);
            }
         } catch (Exception var17) {
            var10000 = var17;
            var10001 = false;
            break label88;
         }

         label86: {
            try {
               this.d.removeView(this);
               this.g.onDismiss(this);
               this.b.setOnKeyListener((OnKeyListener)null);
               if (VERSION.SDK_INT >= 11 && this.a.getActionBar() != null) {
                  if (this.j) {
                     this.a.getActionBar().show();
                  }
                  break label86;
               }
            } catch (Exception var16) {
               var10000 = var16;
               var10001 = false;
               break label88;
            }

            boolean var5;
            try {
               var5 = this.j;
            } catch (Exception var11) {
               var10000 = var11;
               var10001 = false;
               break label88;
            }

            if (var5) {
               label87: {
                  Class var7;
                  try {
                     var7 = this.a.getClass();
                  } catch (Exception var15) {
                     var10001 = false;
                     break label87;
                  }

                  Object var8;
                  try {
                     var8 = var7.getMethod("getSupportActionBar", (Class[])null).invoke(this.a, new Object[0]);
                  } catch (Exception var14) {
                     var10001 = false;
                     break label87;
                  }

                  if (var8 != null) {
                     label89: {
                        Class var9;
                        try {
                           var9 = var8.getClass();
                        } catch (Exception var13) {
                           var10001 = false;
                           break label89;
                        }

                        try {
                           var9.getMethod("show", (Class[])null).invoke(var8, new Object[0]);
                        } catch (Exception var12) {
                           var10001 = false;
                        }
                     }
                  }
               }
            }
         }

         try {
            if (this.e != null && this.e.getParent() != null) {
               ((View)this.e.getParent()).getLayoutParams().height = this.l;
               return;
            }

            return;
         } catch (Exception var10) {
            var10000 = var10;
            var10001 = false;
         }
      }

      Exception var1 = var10000;
      StringBuilder var2 = new StringBuilder();
      var2.append("ADFDialog->initViewability: ");
      var2.append(var1.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var2.toString());
   }

   public boolean dispatchKeyEvent(KeyEvent var1) {
      if (com.noqoush.adfalcon.android.sdk.util.f.a(this.getContext(), var1)) {
         return true;
      } else {
         OnKeyListener var2 = this.h;
         if (var2 != null && var2.onKey(this, var1.getKeyCode(), var1)) {
            return true;
         } else if (var1.getKeyCode() == 4 && var1.getAction() == 1) {
            try {
               if (this.f) {
                  this.dismiss();
                  return true;
               }
            } catch (Exception var5) {
               StringBuilder var4 = new StringBuilder();
               var4.append("ADFDialog->dispatchKeyEvent: ");
               var4.append(var5.toString());
               com.noqoush.adfalcon.android.sdk.k.b(var4.toString());
            }

            return true;
         } else {
            return super.dispatchKeyEvent(var1);
         }
      }
   }

   public boolean onTouchEvent(MotionEvent var1) {
      return true;
   }

   public void setOnKeyListener(OnKeyListener var1) {
      this.h = var1;
   }
}
