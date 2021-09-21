package com.noqoush.adfalcon.android.sdk.viewability;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.VideoView;
import com.noqoush.adfalcon.android.sdk.video.vast.model.p;
import com.noqoush.adfalcon.android.sdk.video.vast.model.r;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class ViewabilityVideoView extends VideoView implements OnCompletionListener, OnPreparedListener, OnErrorListener, OnInfoListener {
   private b a;
   private HashMap b;
   private SoftReference c;
   private SoftReference d;
   private SoftReference e;
   private SoftReference f;
   private Timer g;
   private int h;
   private int i = -1;
   private int j;
   private AudioManager k;
   private boolean l = false;

   public ViewabilityVideoView(Context var1) {
      super(var1);
      this.c();
   }

   public ViewabilityVideoView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.c();
   }

   public ViewabilityVideoView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.c();
   }

   public ViewabilityVideoView(Context var1, AttributeSet var2, int var3, int var4) {
      super(var1, var2, var3, var4);
      this.c();
   }

   private void a() {
      Exception var10000;
      label47: {
         boolean var10001;
         int var2;
         label50: {
            label45: {
               try {
                  var2 = this.k.getStreamVolume(3);
                  if (this.j == var2) {
                     return;
                  }

                  if (this.j != 0) {
                     break label45;
                  }
               } catch (Exception var7) {
                  var10000 = var7;
                  var10001 = false;
                  break label47;
               }

               if (var2 > 0) {
                  try {
                     this.getVideoAnalytic().k();
                     break label50;
                  } catch (Exception var5) {
                     var10000 = var5;
                     var10001 = false;
                     break label47;
                  }
               }
            }

            try {
               if (this.j <= 0) {
                  break label50;
               }
            } catch (Exception var6) {
               var10000 = var6;
               var10001 = false;
               break label47;
            }

            if (var2 == 0) {
               try {
                  this.getVideoAnalytic().p();
               } catch (Exception var4) {
                  var10000 = var4;
                  var10001 = false;
                  break label47;
               }
            }
         }

         try {
            this.j = var2;
            return;
         } catch (Exception var3) {
            var10000 = var3;
            var10001 = false;
         }
      }

      Exception var1 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var1);
   }

   private void b() {
      this.a();

      Exception var10000;
      label73: {
         boolean var10001;
         int var2;
         try {
            var2 = this.getCurrentPosition() / 1000;
            if (var2 == this.i) {
               return;
            }
         } catch (Exception var17) {
            var10000 = var17;
            var10001 = false;
            break label73;
         }

         int var8;
         int var9;
         int var7;
         try {
            StringBuilder var3 = new StringBuilder();
            var3.append("Moat-onProgressChange: ");
            var3.append(var2);
            com.noqoush.adfalcon.android.sdk.util.a.a(var3.toString());
            int var6 = this.getDuration() / 1000;
            var7 = var6 / 4;
            var8 = var6 / 2;
            var9 = var6 * 3 / 4;
         } catch (Exception var16) {
            var10000 = var16;
            var10001 = false;
            break label73;
         }

         if (var2 == 0) {
            try {
               this.getVideoAnalytic().s();
            } catch (Exception var15) {
               var10000 = var15;
               var10001 = false;
               break label73;
            }
         } else if (var2 == 1) {
            try {
               this.getVideoAnalytic().b();
            } catch (Exception var14) {
               var10000 = var14;
               var10001 = false;
               break label73;
            }
         } else if (var2 == var7) {
            try {
               this.getVideoAnalytic().r();
            } catch (Exception var13) {
               var10000 = var13;
               var10001 = false;
               break label73;
            }
         } else if (var2 == var8) {
            try {
               this.getVideoAnalytic().q();
            } catch (Exception var12) {
               var10000 = var12;
               var10001 = false;
               break label73;
            }
         } else if (var2 == var9) {
            try {
               this.getVideoAnalytic().e();
            } catch (Exception var11) {
               var10000 = var11;
               var10001 = false;
               break label73;
            }
         }

         try {
            this.i = var2;
            return;
         } catch (Exception var10) {
            var10000 = var10;
            var10001 = false;
         }
      }

      Exception var1 = var10000;
      com.noqoush.adfalcon.android.sdk.util.a.a(var1);
   }

   private void c() {
      try {
         this.getVideoAnalytic().a(this.getContext());
         super.setOnPreparedListener(this);
         super.setOnCompletionListener(this);
         super.setOnErrorListener(this);
         if (VERSION.SDK_INT >= 17) {
            super.setOnInfoListener(this);
         }

         AudioManager var2 = (AudioManager)this.getContext().getSystemService("audio");
         this.k = var2;
         this.j = var2.getStreamVolume(3);
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }
   }

   private void d() {
      try {
         if (this.g == null) {
            this.i = -1;
            Timer var2 = new Timer();
            this.g = var2;
            var2.scheduleAtFixedRate(new TimerTask() {
               public void run() {
                  try {
                     ViewabilityVideoView.this.post(new Runnable() {
                        public void run() {
                           try {
                              ViewabilityVideoView.this.b();
                           } catch (Exception var2) {
                              com.noqoush.adfalcon.android.sdk.util.a.a(var2);
                           }
                        }
                     });
                  } catch (Exception var2) {
                     com.noqoush.adfalcon.android.sdk.util.a.a(var2);
                  }
               }
            }, 0L, 100L);
            return;
         }
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
      }

   }

   private void e() {
      try {
         if (this.g != null) {
            this.g.cancel();
            this.g = null;
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public int getDuration() {
      return super.getDuration() == -1 ? this.h : super.getDuration();
   }

   public r getVastScene() {
      SoftReference var1 = this.f;
      return var1 != null ? (r)var1.get() : null;
   }

   public b getVideoAnalytic() {
      if (this.a == null) {
         this.a = new com.noqoush.adfalcon.android.sdk.viewability.omsdk.c();
      }

      return this.a;
   }

   public float getVolume() {
      float var2;
      int var3;
      try {
         var2 = (float)this.k.getStreamVolume(3);
         var3 = this.k.getStreamMaxVolume(3);
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
         return (float)this.j;
      }

      return var2 / (float)var3;
   }

   public void onCompletion(MediaPlayer var1) {
      try {
         this.e();
         this.getVideoAnalytic().o();
         this.getVideoAnalytic().a();
      } catch (Exception var5) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var5);
      }

      try {
         if (this.c != null && this.c.get() != null) {
            ((OnCompletionListener)this.c.get()).onCompletion(var1);
            return;
         }
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }

   }

   public boolean onError(MediaPlayer var1, int var2, int var3) {
      this.getVideoAnalytic().a();

      try {
         if (this.e != null && this.e.get() != null) {
            boolean var5 = ((OnErrorListener)this.e.get()).onError(var1, var2, var3);
            return var5;
         }
      } catch (Exception var6) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var6);
      }

      return false;
   }

   public boolean onInfo(MediaPlayer var1, int var2, int var3) {
      if (var2 != 3) {
         if (var2 != 701) {
            if (var2 != 702) {
               return false;
            }

            this.getVideoAnalytic().j();
            return true;
         }

         this.getVideoAnalytic().c();
      }

      return true;
   }

   public void onPrepared(MediaPlayer var1) {
      try {
         this.e();
         this.getVideoAnalytic().g();
         this.d();
      } catch (Exception var5) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var5);
      }

      try {
         if (this.d != null && this.d.get() != null) {
            ((OnPreparedListener)this.d.get()).onPrepared(var1);
            return;
         }
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }

   }

   public void pause() {
      super.pause();
      this.getVideoAnalytic().l();
      this.e();
      this.l = true;
   }

   public void resume() {
      super.resume();
      this.getVideoAnalytic().i();
      this.d();
   }

   public void seekTo(int var1) {
      this.i = -1;
      super.seekTo(var1);
   }

   public void setExpectedCuration(int var1) {
      this.h = var1;
   }

   public void setOnCompletionListener(OnCompletionListener var1) {
      this.c = new SoftReference(var1);
   }

   public void setOnErrorListener(OnErrorListener var1) {
      this.e = new SoftReference(var1);
   }

   public void setOnPreparedListener(OnPreparedListener var1) {
      this.d = new SoftReference(var1);
   }

   public void setVastScene(r var1) {
      this.f = new SoftReference(var1);
      this.getVideoAnalytic().a(this.getContext(), (p)null, this.getVastScene(), this.getDuration(), this, (MediaPlayer)null);
   }

   public void start() {
      super.start();
      this.getVideoAnalytic().a((Object)this);
      if (this.getCurrentPosition() > 0) {
         this.getVideoAnalytic().i();
         this.d();
      }

   }

   public void stopPlayback() {
      label30: {
         Exception var10000;
         label32: {
            boolean var10001;
            int var3;
            int var2;
            try {
               var2 = this.getDuration();
               var3 = this.getCurrentPosition();
            } catch (Exception var7) {
               var10000 = var7;
               var10001 = false;
               break label32;
            }

            int var4 = var2 - var3;
            if (var3 > 1000 && var4 > 1000) {
               try {
                  this.getVideoAnalytic().n();
               } catch (Exception var6) {
                  var10000 = var6;
                  var10001 = false;
                  break label32;
               }
            }

            try {
               this.e();
               this.getVideoAnalytic().h();
               this.getVideoAnalytic().a();
               break label30;
            } catch (Exception var5) {
               var10000 = var5;
               var10001 = false;
            }
         }

         Exception var1 = var10000;
         com.noqoush.adfalcon.android.sdk.util.a.a(var1);
      }

      super.stopPlayback();
   }
}
