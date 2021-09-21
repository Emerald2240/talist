package com.noqoush.adfalcon.android.sdk;

import android.os.PowerManager;
import android.os.Build.VERSION;

class v$a implements Runnable {
   // $FF: synthetic field
   final v a;

   v$a(v var1) {
      this.a = var1;
   }

   public void run() {
      Exception var10000;
      label130: {
         boolean var10001;
         label131: {
            PowerManager var2;
            label132: {
               v var15;
               boolean var16;
               label124: {
                  label123: {
                     try {
                        var2 = (PowerManager)this.a.getContext().getSystemService("power");
                        if (VERSION.SDK_INT < 20) {
                           break label132;
                        }

                        var15 = this.a;
                        if (!var2.isInteractive() || !x.F()) {
                           break label123;
                        }
                     } catch (Exception var26) {
                        var10000 = var26;
                        var10001 = false;
                        break label130;
                     }

                     var16 = true;
                     break label124;
                  }

                  var16 = false;
               }

               try {
                  v.a(var15, var16);
                  break label131;
               } catch (Exception var24) {
                  var10000 = var24;
                  var10001 = false;
                  break label130;
               }
            }

            v var3;
            boolean var4;
            label112: {
               label111: {
                  try {
                     var3 = this.a;
                     if (var2.isScreenOn() && x.F()) {
                        break label111;
                     }
                  } catch (Exception var25) {
                     var10000 = var25;
                     var10001 = false;
                     break label130;
                  }

                  var4 = false;
                  break label112;
               }

               var4 = true;
            }

            try {
               v.a(var3, var4);
            } catch (Exception var23) {
               var10000 = var23;
               var10001 = false;
               break label130;
            }
         }

         try {
            if (!v.a(this.a)) {
               v.b(this.a, true);
            }
         } catch (Exception var22) {
            var10000 = var22;
            var10001 = false;
            break label130;
         }

         label93: {
            label134: {
               label91: {
                  try {
                     if (v.c(this.a) == null) {
                        return;
                     }

                     StringBuilder var6 = new StringBuilder();
                     var6.append("mVideoView.isPlaying(): ");
                     var6.append(v.c(this.a).isPlaying());
                     var6.append(", mScreenOn: ");
                     var6.append(v.a(this.a));
                     k.e(var6.toString());
                     if (!v.c(this.a).isPlaying()) {
                        break label93;
                     }

                     v.d(this.a);
                     if (this.a.getVisibility() == 4 || !v.a(this.a) || !v.e(this.a) && !this.a.isFocused() && !v.f(this.a).isFocused()) {
                        break label91;
                     }
                  } catch (Exception var21) {
                     var10000 = var21;
                     var10001 = false;
                     break label130;
                  }

                  try {
                     if (!v.b(this.a) || this.a.isFocused()) {
                        break label134;
                     }
                  } catch (Exception var20) {
                     var10000 = var20;
                     var10001 = false;
                     break label130;
                  }
               }

               try {
                  if (v.c(this.a).isPlaying()) {
                     v.g(this.a);
                     break label93;
                  }
               } catch (Exception var19) {
                  var10000 = var19;
                  var10001 = false;
                  break label130;
               }
            }

            try {
               if (v.h(this.a) != null) {
                  k.e("startUpdateTime1");
                  if (v.c(this.a).isPlaying()) {
                     this.a.t = (long)v.c(this.a).getCurrentPosition();
                     v.h(this.a).setIVideoTimeUpdate(this.a.t);
                     StringBuilder var11 = new StringBuilder();
                     var11.append("startUpdateTime2.mCurrentTime:");
                     var11.append(this.a.t);
                     k.e(var11.toString());
                  }
               }
            } catch (Exception var18) {
               var10000 = var18;
               var10001 = false;
               break label130;
            }
         }

         try {
            v.i(this.a);
            return;
         } catch (Exception var17) {
            var10000 = var17;
            var10001 = false;
         }
      }

      Exception var1 = var10000;
      k.b(var1.getMessage());
   }
}
