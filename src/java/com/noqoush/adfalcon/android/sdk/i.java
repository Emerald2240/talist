package com.noqoush.adfalcon.android.sdk;

import android.app.Activity;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import java.util.Hashtable;

class i {
   static Hashtable b;
   private int a;

   static {
      Hashtable var0 = new Hashtable();
      b = var0;
      var0.put("app", "Download");
      b.put("audio", "Play audio");
      b.put("call", "Make call");
      b.put("loc", "View location");
      b.put("sms", "Send SMS");
      b.put("url", "Open web page");
      b.put("video", "Play video");
   }

   private int a() {
      return this.a;
   }

   private OnDismissListener a(final Context var1, final q var2) {
      return new OnDismissListener() {
         public void onDismiss(DialogInterface var1x) {
            com.noqoush.adfalcon.android.sdk.util.d.c(var1).setRequestedOrientation(i.this.a());
            var2.didDismissScreen();
         }
      };
   }

   private static OnClickListener a(final Dialog var0, final q var1, final y var2) {
      return new OnClickListener() {
         public void onClick(View var1x) {
            try {
               if (var2 == null || !var2.b()) {
                  var1.willDismissScreen();
                  var0.dismiss();
                  return;
               }
            } catch (Exception var4) {
               StringBuilder var3 = new StringBuilder();
               var3.append("ADFDialogF: ");
               var3.append(var4.toString());
               k.b(var3.toString());
            }

         }
      };
   }

   private OnClickListener a(final Context var1, final OnClickListener var2, final Dialog var3, final String var4) {
      OnClickListener var5 = new OnClickListener() {
         public void onClick(View var1x) {
            Builder var2x = new Builder(var1);
            var2x.setTitle("Action");
            var2x.setMessage("What do you want to do?").setCancelable(false).setPositiveButton((CharSequence)i.b.get(var4), new android.content.DialogInterface.OnClickListener() {
               public void onClick(DialogInterface var1x, int var2x) {
                  var2.onClick((View)null);
                  var1x.dismiss();
               }
            }).setNegativeButton("Exit", new android.content.DialogInterface.OnClickListener() {
               public void onClick(DialogInterface var1x, int var2x) {
                  var1x.cancel();
                  var3.dismiss();
               }
            }).setCancelable(true);
            var2x.create().show();
         }
      };
      return var5;
   }

   public static h a(Context var0, final View var1, o.a var2, final q var3, final y var4, final com.noqoush.adfalcon.android.sdk.nativead.a var5) {
      Exception var10000;
      label115: {
         final RelativeLayout var11;
         boolean var10001;
         LayoutParams var12;
         final ImageView var10;
         try {
            var3.willPresentScreen();
            var10 = new ImageView(var0);
            var11 = new RelativeLayout(var0);
            var12 = new LayoutParams(com.noqoush.adfalcon.android.sdk.util.f.a(), com.noqoush.adfalcon.android.sdk.util.f.a());
         } catch (Exception var32) {
            var10000 = var32;
            var10001 = false;
            break label115;
         }

         final h var15;
         LayoutParams var14;
         label117: {
            if (var2 != null) {
               label118: {
                  label102:
                  try {
                     if (var2.b() > 0 && var2.a() > 0) {
                        break label102;
                     }
                     break label118;
                  } catch (Exception var31) {
                     var10000 = var31;
                     var10001 = false;
                     break label115;
                  }

                  LayoutParams var20;
                  h var19;
                  try {
                     var19 = new h(var0, 16973840);
                     var20 = new LayoutParams(var2.b(), var2.a());
                     var11.setBackgroundColor(Color.argb(125, 0, 0, 0));
                  } catch (Exception var30) {
                     var10000 = var30;
                     var10001 = false;
                     break label115;
                  }

                  var15 = var19;
                  var14 = var20;
                  break label117;
               }
            }

            h var13;
            try {
               var13 = new h(var0, 16973841);
            } catch (Exception var29) {
               var10000 = var29;
               var10001 = false;
               break label115;
            }

            var14 = var12;
            var15 = var13;
         }

         try {
            var11.setTag(var15);
            var15.a(true);
            var11.setLayoutParams(var14);
            OnDismissListener var16 = new OnDismissListener() {
               public void onDismiss(DialogInterface var1x) {
                  try {
                     if (var4 != null) {
                        var4.b();
                     }

                     if (var1 instanceof m) {
                        ((m)var1).h();
                     }

                     var11.removeAllViews();
                     var3.didDismissScreen();
                     if (var5 != null) {
                        var5.a();
                        return;
                     }
                  } catch (Exception var4x) {
                     StringBuilder var3x = new StringBuilder();
                     var3x.append("ADFDialogF->showResizedADFDialog->onDismiss: ");
                     var3x.append(var4x.toString());
                     k.b(var3x.toString());
                  }

               }
            };
            var15.a(var16);
            var15.setOnKeyListener(new OnKeyListener() {
               public boolean onKey(View var1x, int var2, KeyEvent var3x) {
                  if (var2 == 4 && var3x.getAction() == 1) {
                     Exception var10000;
                     label54: {
                        boolean var10001;
                        label55: {
                           try {
                              if (var4 != null && !var4.b()) {
                                 break label55;
                              }
                           } catch (Exception var9) {
                              var10000 = var9;
                              var10001 = false;
                              break label54;
                           }

                           try {
                              var10.bringToFront();
                              return true;
                           } catch (Exception var6) {
                              var10000 = var6;
                              var10001 = false;
                              break label54;
                           }
                        }

                        try {
                           if (var1 instanceof m && ((m)var1).h()) {
                              var10.bringToFront();
                              return true;
                           }
                        } catch (Exception var8) {
                           var10000 = var8;
                           var10001 = false;
                           break label54;
                        }

                        try {
                           var3.willDismissScreen();
                           return false;
                        } catch (Exception var7) {
                           var10000 = var7;
                           var10001 = false;
                        }
                     }

                     Exception var4x = var10000;
                     StringBuilder var5 = new StringBuilder();
                     var5.append("ADFDialogF->showResizedADFDialog->onKey: ");
                     var5.append(var4x.toString());
                     k.b(var5.toString());
                  }

                  return false;
               }
            });
            var15.a(1);
            var15.a((View)var11);
            var4.a(var11);
         } catch (Exception var28) {
            var10000 = var28;
            var10001 = false;
            break label115;
         }

         if (var2 != null) {
            try {
               if (var2.b() > 0 && var2.a() > 0) {
                  var14 = new LayoutParams(var2.b(), var2.a());
               }
            } catch (Exception var27) {
               var10000 = var27;
               var10001 = false;
               break label115;
            }
         }

         try {
            var14.addRule(13);
            var1.setLayoutParams(var14);
            var1.setBackgroundColor(0);
            var11.addView(var1);
            int var17 = (int)(50.0F * com.noqoush.adfalcon.android.sdk.util.d.e(var0));
            var10.setImageBitmap((new com.noqoush.adfalcon.android.sdk.images.b()).b(var0));
            var10.setBackgroundColor(0);
            var10.setMinimumHeight(var17);
            var10.setMinimumWidth(var17);
            var10.setScaleType(ScaleType.FIT_XY);
            var10.setOnClickListener(new OnClickListener() {
               public void onClick(View var1) {
                  try {
                     if (var4 == null || !var4.b()) {
                        var3.willDismissScreen();
                        var15.dismiss();
                        return;
                     }
                  } catch (Exception var4x) {
                     StringBuilder var3x = new StringBuilder();
                     var3x.append("ADFDialogF->showResizedADFDialog->onViewabilityClick: ");
                     var3x.append(var4x.toString());
                     k.b(var3x.toString());
                  }

               }
            });
            LayoutParams var18 = new LayoutParams(-2, -2);
            var18.addRule(11, -1);
            var18.addRule(10, -1);
            var10.setLayoutParams(var18);
            var11.addView(var10);
         } catch (Exception var26) {
            var10000 = var26;
            var10001 = false;
            break label115;
         }

         label76: {
            if (var2 != null) {
               try {
                  if (var2.d()) {
                     var10.setVisibility(4);
                     break label76;
                  }
               } catch (Exception var25) {
                  var10000 = var25;
                  var10001 = false;
                  break label115;
               }
            }

            try {
               a((View)var10);
            } catch (Exception var24) {
               var10000 = var24;
               var10001 = false;
               break label115;
            }
         }

         try {
            var15.a();
            var3.didPresentScreen();
         } catch (Exception var23) {
            var10000 = var23;
            var10001 = false;
            break label115;
         }

         if (var5 != null) {
            try {
               var5.c();
            } catch (Exception var22) {
               var10000 = var22;
               var10001 = false;
               break label115;
            }
         }

         try {
            if (var1 instanceof m) {
               ((m)var1).setCloseIndicatorImageButton(var10);
            }

            return var15;
         } catch (Exception var21) {
            var10000 = var21;
            var10001 = false;
         }
      }

      Exception var6 = var10000;
      StringBuilder var7 = new StringBuilder();
      var7.append("showResizedDialog->");
      var7.append(var6.toString());
      k.b(var7.toString());
      return null;
   }

   private void a(int var1) {
      this.a = var1;
   }

   private static void a(View var0) {
      var0.setVisibility(0);
   }

   public static Dialog b(Context var0, final View var1, o.a var2, final q var3, final y var4, final com.noqoush.adfalcon.android.sdk.nativead.a var5) {
      Exception var10000;
      label118: {
         boolean var10001;
         final RelativeLayout var10;
         try {
            var3.willPresentScreen();
            var10 = new RelativeLayout(var0);
            var10.setTag((Object)null);
         } catch (Exception var33) {
            var10000 = var33;
            var10001 = false;
            break label118;
         }

         Dialog var11;
         label119: {
            label122: {
               if (var2 != null) {
                  try {
                     if (var2.b() > 0 && var2.a() > 0) {
                        break label122;
                     }
                  } catch (Exception var32) {
                     var10000 = var32;
                     var10001 = false;
                     break label118;
                  }
               }

               try {
                  var11 = new Dialog(var0, 16973841);
                  break label119;
               } catch (Exception var30) {
                  var10000 = var30;
                  var10001 = false;
                  break label118;
               }
            }

            Dialog var20;
            try {
               var20 = new Dialog(var0, 16973840);
               var20.getWindow().getAttributes().y = 25;
               var20.getWindow().setLayout(var2.b(), var2.a());
            } catch (Exception var31) {
               var10000 = var31;
               var10001 = false;
               break label118;
            }

            var11 = var20;
         }

         LayoutParams var14;
         try {
            var11.setCancelable(false);
            var10.setLayoutParams(new LayoutParams(com.noqoush.adfalcon.android.sdk.util.f.a(), com.noqoush.adfalcon.android.sdk.util.f.a()));
            OnDismissListener var12 = new OnDismissListener() {
               public void onDismiss(DialogInterface var1x) {
                  try {
                     if (var4 != null) {
                        var4.b();
                     }

                     if (var1 instanceof m) {
                        ((m)var1).h();
                     }

                     var10.removeAllViews();
                     var3.didDismissScreen();
                     if (var5 != null) {
                        var5.a();
                        return;
                     }
                  } catch (Exception var4x) {
                     StringBuilder var3x = new StringBuilder();
                     var3x.append("ADFDialogF->showResizedDialog->onDismiss: ");
                     var3x.append(var4x.toString());
                     k.b(var3x.toString());
                  }

               }
            };
            var11.setOnDismissListener(var12);
            var11.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() {
               public boolean onKey(DialogInterface var1x, int var2, KeyEvent var3) {
                  if (var2 == 4 && var3.getAction() == 1) {
                     try {
                        if (var4 == null) {
                           return true;
                        }

                        if (var4.b()) {
                           return true;
                        }

                        if (var1 instanceof m && ((m)var1).h()) {
                           return true;
                        }

                        var1x.dismiss();
                     } catch (Exception var6) {
                        StringBuilder var5 = new StringBuilder();
                        var5.append("ADFDialogF->showResizedDialog->onKey: ");
                        var5.append(var6.toString());
                        k.b(var5.toString());
                     }

                     return false;
                  } else {
                     return true;
                  }
               }
            });
            var11.requestWindowFeature(1);
            var11.setContentView(var10);
            var4.a(var10);
            var14 = new LayoutParams(com.noqoush.adfalcon.android.sdk.util.f.a(), com.noqoush.adfalcon.android.sdk.util.f.a());
         } catch (Exception var29) {
            var10000 = var29;
            var10001 = false;
            break label118;
         }

         if (var2 != null) {
            try {
               if (var2.b() > 0 && var2.a() > 0) {
                  var14 = new LayoutParams(var2.b(), var2.a());
               }
            } catch (Exception var28) {
               var10000 = var28;
               var10001 = false;
               break label118;
            }
         }

         ImageView var17;
         try {
            var14.addRule(13);
            var1.setLayoutParams(var14);
            var1.setBackgroundColor(0);
            var10.addView(var1);
            int var15 = (int)(50.0F * com.noqoush.adfalcon.android.sdk.util.d.e(var0));
            com.noqoush.adfalcon.android.sdk.images.b var16 = new com.noqoush.adfalcon.android.sdk.images.b();
            var17 = new ImageView(var0);
            var17.setImageBitmap(var16.b(var0));
            var17.setBackgroundColor(0);
            var17.setMinimumHeight(var15);
            var17.setMinimumWidth(var15);
            var17.setScaleType(ScaleType.FIT_XY);
            var17.setOnClickListener(a(var11, var3, var4));
            LayoutParams var18 = new LayoutParams(-2, -2);
            var18.addRule(11, -1);
            var18.addRule(10, -1);
            var17.setLayoutParams(var18);
            var10.addView(var17);
         } catch (Exception var27) {
            var10000 = var27;
            var10001 = false;
            break label118;
         }

         label123: {
            if (var2 != null) {
               try {
                  if (var2.d()) {
                     var17.setVisibility(4);
                     break label123;
                  }
               } catch (Exception var26) {
                  var10000 = var26;
                  var10001 = false;
                  break label118;
               }
            }

            try {
               a((View)var17);
            } catch (Exception var25) {
               var10000 = var25;
               var10001 = false;
               break label118;
            }
         }

         try {
            var11.show();
            var3.didPresentScreen();
         } catch (Exception var24) {
            var10000 = var24;
            var10001 = false;
            break label118;
         }

         if (var5 != null) {
            try {
               var5.c();
            } catch (Exception var23) {
               var10000 = var23;
               var10001 = false;
               break label118;
            }
         }

         try {
            if (var1 instanceof m) {
               ((m)var1).setCloseIndicatorImageButton(var17);
            }
         } catch (Exception var22) {
            var10000 = var22;
            var10001 = false;
            break label118;
         }

         try {
            var1.requestFocus();
            return var11;
         } catch (Exception var21) {
            var10000 = var21;
            var10001 = false;
         }
      }

      Exception var6 = var10000;
      StringBuilder var7 = new StringBuilder();
      var7.append("showResizedDialog->");
      var7.append(var6.toString());
      k.b(var7.toString());
      return null;
   }

   public Dialog a(Context var1, View var2, q var3, OnClickListener var4, String var5, com.noqoush.adfalcon.android.sdk.nativead.a var6) {
      Exception var10000;
      label54: {
         Dialog var13;
         boolean var10001;
         ImageView var16;
         label48: {
            Activity var12;
            try {
               com.noqoush.adfalcon.android.sdk.images.b var7 = new com.noqoush.adfalcon.android.sdk.images.b();
               var12 = com.noqoush.adfalcon.android.sdk.util.d.c(var1);
               this.a(var12.getRequestedOrientation());
               var3.willPresentScreen();
               var13 = new Dialog(var1, 16973831);
               var13.setOnDismissListener(this.a(var1, var3));
               RelativeLayout var14 = new RelativeLayout(var1);
               var14.setOnClickListener(this.a(var1, var4, var13, var5));
               var13.setContentView(var14);
               int var15 = (int)(50.0F * com.noqoush.adfalcon.android.sdk.util.d.e(var1));
               var16 = new ImageView(var1);
               var16.setImageBitmap(var7.b(var1));
               var16.setBackgroundColor(0);
               var16.setMinimumHeight(var15);
               var16.setMinimumWidth(var15);
               var16.setScaleType(ScaleType.FIT_XY);
               var16.setOnClickListener(a(var13, var3, (y)null));
               LayoutParams var17 = new LayoutParams(-2, -2);
               var17.addRule(11, -1);
               var17.addRule(10, -1);
               var16.setLayoutParams(var17);
               var14.addView(var16);
               LayoutParams var18 = new LayoutParams(-2, -2);
               var18.addRule(13);
               var2.setLayoutParams(var18);
               var14.addView(var2);
               a((View)var16);
               if (var12.getResources().getConfiguration().orientation == 2) {
                  var12.setRequestedOrientation(0);
                  break label48;
               }
            } catch (Exception var23) {
               var10000 = var23;
               var10001 = false;
               break label54;
            }

            try {
               var12.setRequestedOrientation(1);
            } catch (Exception var22) {
               var10000 = var22;
               var10001 = false;
               break label54;
            }
         }

         try {
            if (var2 instanceof m) {
               ((m)var2).setCloseIndicatorImageButton(var16);
            }
         } catch (Exception var21) {
            var10000 = var21;
            var10001 = false;
            break label54;
         }

         try {
            var13.show();
            var3.didPresentScreen();
         } catch (Exception var20) {
            var10000 = var20;
            var10001 = false;
            break label54;
         }

         if (var6 == null) {
            return var13;
         }

         try {
            var6.c();
            return var13;
         } catch (Exception var19) {
            var10000 = var19;
            var10001 = false;
         }
      }

      Exception var8 = var10000;
      StringBuilder var9 = new StringBuilder();
      var9.append("ADFDialogFactory->showFullscreenDialog: ");
      var9.append(var8.toString());
      k.b(var9.toString());
      return null;
   }
}
