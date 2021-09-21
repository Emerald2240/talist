package com.noqoush.adfalcon.android.sdk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.Animation.AnimationListener;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

class f {
   private int a = 0;
   private int b = 250;

   public f() {
   }

   private Animation a(final View var1) {
      try {
         AlphaAnimation var2 = new AlphaAnimation(0.0F, 1.0F);
         var2.setDuration((long)this.b);
         var2.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation var1x) {
               k.c("did start animation (alpha out)");
               var1.clearAnimation();
            }

            public void onAnimationRepeat(Animation var1x) {
            }

            public void onAnimationStart(Animation var1x) {
               k.c("will start animation (alpha out)");
            }
         });
         return var2;
      } catch (Exception var4) {
         return null;
      }
   }

   private String a(String param1, HttpURLConnection param2, String param3) throws Exception {
      // $FF: Couldn't be decompiled
   }

   public static Bitmap b(String var0) {
      try {
         HttpURLConnection var5 = (HttpURLConnection)(new URL(var0)).openConnection();
         var5.setDoInput(true);
         var5.connect();
         Bitmap var6 = BitmapFactory.decodeStream(var5.getInputStream());
         return var6;
      } catch (IOException var7) {
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFComm.->onKey: ");
         var2.append(var7.toString());
         k.b(var2.toString());
         return null;
      }
   }

   private Animation b(final View var1) {
      try {
         ScaleAnimation var2 = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
         var2.setDuration((long)this.b);
         var2.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation var1x) {
               k.c("did start animation (Slide Out)");
               var1.clearAnimation();
            }

            public void onAnimationRepeat(Animation var1x) {
            }

            public void onAnimationStart(Animation var1x) {
               k.c("will start animation (Slide Out)");
            }
         });
         return var2;
      } catch (Exception var4) {
         return null;
      }
   }

   private void b(final View var1, final b var2) {
      try {
         AlphaAnimation var3 = new AlphaAnimation(1.0F, 0.0F);
         var3.setDuration((long)this.b);
         var3.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation var1x) {
               try {
                  k.c("did start animation (alpha in)");
                  var2.a();
                  Animation var3 = f.this.a(var1);
                  var1.clearAnimation();
                  var1.setAnimation(var3);
                  var1.invalidate();
                  var3.start();
               } catch (Exception var4) {
               }
            }

            public void onAnimationRepeat(Animation var1x) {
            }

            public void onAnimationStart(Animation var1x) {
               k.c("will start animation (alpha in)");
            }
         });
         var1.clearAnimation();
         var1.setAnimation(var3);
         var1.invalidate();
         var3.start();
      } catch (Exception var5) {
      }
   }

   private void c(final View var1, final b var2) {
      try {
         ScaleAnimation var3 = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
         var3.setDuration((long)this.b);
         var3.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation var1x) {
               try {
                  k.c("did start animation (Slide IN)");
                  var2.a();
                  Animation var3 = f.this.b(var1);
                  var1.clearAnimation();
                  var1.setAnimation(var3);
                  var1.invalidate();
                  var3.start();
               } catch (Exception var4) {
               }
            }

            public void onAnimationRepeat(Animation var1x) {
            }

            public void onAnimationStart(Animation var1x) {
               k.c("will start animation (Slide IN)");
            }
         });
         var1.clearAnimation();
         var1.setAnimation(var3);
         var1.invalidate();
         var3.start();
      } catch (Exception var5) {
      }
   }

   public com.noqoush.adfalcon.android.sdk.response.k a(String var1, x var2) throws JSONException, Exception {
      k.a(var1);
      if (var1.charAt(0) == '{') {
         com.noqoush.adfalcon.android.sdk.response.k var3 = new com.noqoush.adfalcon.android.sdk.response.k(var1, com.noqoush.adfalcon.android.sdk.util.d.e(var2.f()));
         var2.b(var3.t());
         var2.a(var3.j());
         return var3;
      } else {
         throw new Exception("Failed to connect to AdFalcon server");
      }
   }

   public String a(com.noqoush.adfalcon.android.sdk.response.k var1, String var2) throws Exception {
      com.noqoush.adfalcon.android.sdk.response.a var3 = var1.a();
      String var4 = var3.f();
      JSONObject var5 = new JSONObject(this.a(var3.a(), (HttpURLConnection)null, var2));
      if (!var4.equalsIgnoreCase("app") && !var4.equalsIgnoreCase("canvas") && !var4.equalsIgnoreCase("audio") && !var4.equalsIgnoreCase("video")) {
         return !var4.equalsIgnoreCase("call") && !var4.equalsIgnoreCase("sms") ? null : var5.getString("number");
      } else {
         return var5.getString("url");
      }
   }

   public String a(String var1) throws Exception {
      return this.a(var1, (HttpURLConnection)null, (String)null);
   }

   public String a(HttpURLConnection var1, x var2) throws Exception {
      ADFTargetingParams var3 = var2.t();
      if (var3 != null && var3.getAdditionalInfo() != null && var3.getAdditionalInfo().containsKey("JSON")) {
         return (String)var3.getAdditionalInfo().get("JSON");
      } else if (var3 != null && var3.getAdditionalInfo() != null && var3.getAdditionalInfo().containsKey("CONTENT")) {
         JSONObject var4 = new JSONObject("{\"pac\":false,\"adType\":\"banner\",\"adSize\":[320,50],\"responseType\":\"content\",\"adAction\":NULL,\"settings\":{\"EA\":0,\"RD\":100},\"beacon_url\":NULL}");
         var4.put("content", var3.getAdditionalInfo().get("CONTENT"));
         return var4.toString();
      } else {
         return this.a((String)null, var1, (String)null);
      }
   }

   public HttpURLConnection a(x var1) throws Exception {
      com.noqoush.adfalcon.android.sdk.conn.c var2 = new com.noqoush.adfalcon.android.sdk.conn.c();
      var2.d(var1.p()).a("ph,rm").a(var1.t()).b().d().b("JSON").e().a(var1.f(), var1.g()).a(var1.f()).b(var1.f()).b(var1.C());
      if (var1.B()) {
         var2.a(var1.h());
      } else {
         var2.a(var1.q());
      }

      if (var1.v()) {
         var2.c();
      }

      return var2.a();
   }

   public void a(View param1, b param2) {
      // $FF: Couldn't be decompiled
   }

   public void b(x var1) throws Exception {
      k.a("will downLoad the beacon");
      (new com.noqoush.adfalcon.android.sdk.handler.d(new f$a(this, var1))).start();
   }

   public class f extends FilterInputStream {
      protected f(InputStream var2) {
         super(var2);
      }

      public long skip(long var1) throws IOException {
         long var5;
         long var3;
         for(var3 = 0L; var3 < var1; var3 += var5) {
            var5 = super.in.skip(var1 - var3);
            if (var5 == 0L) {
               if (this.read() < 0) {
                  return var3;
               }

               var5 = 1L;
            }
         }

         return var3;
      }
   }
}
