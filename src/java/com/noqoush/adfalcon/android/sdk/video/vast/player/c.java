package com.noqoush.adfalcon.android.sdk.video.vast.player;

import android.content.Context;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import com.noqoush.adfalcon.android.sdk.video.vast.model.r;
import java.lang.ref.WeakReference;

public abstract class c extends RelativeLayout implements d {
   private WeakReference a;
   private WeakReference b;
   private int c;
   private int d;

   public c(Context var1) {
      super(var1);
   }

   public c(Context var1, h var2) {
      super(var1);
      this.setVastPlayer(var2);
   }

   public void a() {
      this.setVisibility(8);
   }

   public void a(int var1) {
      this.setShowTime(var1 + this.getScene().j());
   }

   public void a(int var1, int var2) {
   }

   public void a(r var1) {
      this.setScene(var1);
   }

   public void a(boolean var1, boolean var2, int var3) {
      Exception var10000;
      label71: {
         boolean var10001;
         try {
            this.clearAnimation();
         } catch (Exception var15) {
            var10000 = var15;
            var10001 = false;
            break label71;
         }

         if (var1) {
            if (var3 > 0) {
               try {
                  this.setHiddenTime(var3 + this.getScene().j());
               } catch (Exception var14) {
                  var10000 = var14;
                  var10001 = false;
                  break label71;
               }
            } else {
               try {
                  this.setHiddenTime(-1);
               } catch (Exception var13) {
                  var10000 = var13;
                  var10001 = false;
                  break label71;
               }
            }
         } else {
            try {
               this.setHiddenTime(-1);
            } catch (Exception var12) {
               var10000 = var12;
               var10001 = false;
               break label71;
            }
         }

         if (var1) {
            try {
               this.bringToFront();
            } catch (Exception var11) {
               var10000 = var11;
               var10001 = false;
               break label71;
            }
         }

         if (var2) {
            label72: {
               ViewPropertyAnimator var5;
               try {
                  var5 = this.animate();
               } catch (Exception var9) {
                  var10000 = var9;
                  var10001 = false;
                  break label72;
               }

               float var6;
               if (var1) {
                  var6 = 1.0F;
               } else {
                  var6 = 0.0F;
               }

               try {
                  var5.alpha(var6).setDuration(128L).setListener(new c$a(this, var1)).start();
                  return;
               } catch (Exception var8) {
                  var10000 = var8;
                  var10001 = false;
               }
            }
         } else {
            byte var7;
            if (var1) {
               var7 = 0;
            } else {
               var7 = 4;
            }

            try {
               this.setVisibility(var7);
               return;
            } catch (Exception var10) {
               var10000 = var10;
               var10001 = false;
            }
         }
      }

      Exception var4 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var4);
   }

   public void b() {
      this.removeAllViews();
      this.setShowTime(0);
      this.setHiddenTime(0);
   }

   public void b(int var1, int var2) {
      this.getScene().d(var1);
      if (var1 > this.getHiddenTime() && this.getHiddenTime() > 0) {
         this.setHiddenTime(-1);
         this.a(false, true, -1);
      } else {
         if (var1 > this.getShowTime() && this.getShowTime() > 0) {
            this.setShowTime(-1);
            this.a(true, true, 3);
         }

      }
   }

   public int getHiddenTime() {
      return this.c;
   }

   public r getScene() {
      WeakReference var1 = this.b;
      return var1 == null ? null : (r)var1.get();
   }

   public int getShowTime() {
      return this.d;
   }

   public h getVastPlayer() {
      WeakReference var1 = this.a;
      return var1 == null ? null : (h)var1.get();
   }

   public void setHiddenTime(int var1) {
      this.c = var1;
   }

   public void setScene(r var1) {
      this.b = new WeakReference(var1);
   }

   public void setShowTime(int var1) {
      this.d = var1;
   }

   public void setVastPlayer(h var1) {
      this.a = new WeakReference(var1);
   }
}
