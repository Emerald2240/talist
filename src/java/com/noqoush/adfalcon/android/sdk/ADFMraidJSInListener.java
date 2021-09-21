package com.noqoush.adfalcon.android.sdk;

import android.webkit.JavascriptInterface;
import com.noqoush.adfalcon.android.sdk.constant.ADFMraidPlacementType;
import com.noqoush.adfalcon.android.sdk.constant.ADFMraidState;
import org.json.JSONObject;

class ADFMraidJSInListener implements ADFMraidIVideoInInterface {
   private static final String JAVASCRIPT_METHOD = "ADFalconSDK";
   private ADFMraidIVideoInInterface mraidIVideoInterface;
   private ADFMraidInterface mraidInterface;
   private o mraidModel;
   private float scale;
   private z webView;

   public ADFMraidJSInListener(n var1, o var2, z var3, float var4) {
      try {
         this.setMraidInterface(var1);
         this.setMraidIVideoInterface(var1);
         this.setMraidModel(var2);
         this.setWebView(var3);
         this.setScale(var4);
         this.init();
      } catch (Exception var7) {
         StringBuilder var6 = new StringBuilder();
         var6.append("ADFMraidJSIn:");
         var6.append(var7.toString());
         k.b(var6.toString());
      }
   }

   private ADFMraidIVideoInInterface getMraidIVideoInterface() {
      return this.mraidIVideoInterface;
   }

   private ADFMraidInterface getMraidInterface() {
      return this.mraidInterface;
   }

   private o getMraidModel() {
      return this.mraidModel;
   }

   private float getScale() {
      return this.scale;
   }

   private z getWebView() {
      return this.webView;
   }

   private void init() {
      this.getWebView().addJavascriptInterface(this, "ADFalconSDK");
   }

   private void setMraidIVideoInterface(ADFMraidIVideoInInterface var1) {
      this.mraidIVideoInterface = var1;
   }

   private void setMraidInterface(ADFMraidInterface var1) {
      this.mraidInterface = var1;
   }

   private void setMraidModel(o var1) {
      this.mraidModel = var1;
   }

   private void setScale(float var1) {
      this.scale = var1;
   }

   private void setWebView(z var1) {
      this.webView = var1;
   }

   @JavascriptInterface
   public void close() {
      this.getMraidInterface().close(true);
   }

   @JavascriptInterface
   public void closeIVideo() {
      try {
         this.getMraidIVideoInterface().closeIVideo();
      } catch (Exception var2) {
         k.b(var2.getMessage());
      }
   }

   @JavascriptInterface
   public void createCalendarEvent(String var1) {
      this.getMraidInterface().createCalendarEvent(var1);
   }

   @JavascriptInterface
   public void expand(String var1) {
      ADFMraidInterface var2 = this.getMraidInterface();
      if (var1 == null || var1.length() < 10) {
         var1 = null;
      }

      var2.expand(var1);
   }

   @JavascriptInterface
   public void log(String var1, String var2) {
      if (var1.equalsIgnoreCase("e")) {
         StringBuilder var3 = new StringBuilder();
         var3.append("mraid.");
         var3.append(var2);
         k.b(var3.toString());
      } else if (var1.equalsIgnoreCase("d")) {
         StringBuilder var6 = new StringBuilder();
         var6.append("mraid.");
         var6.append(var2);
         k.a(var6.toString());
      } else if (var1.equalsIgnoreCase("w")) {
         StringBuilder var9 = new StringBuilder();
         var9.append("mraid.");
         var9.append(var2);
         k.e(var9.toString());
      } else if (var1.equalsIgnoreCase("i")) {
         StringBuilder var12 = new StringBuilder();
         var12.append("mraid.");
         var12.append(var2);
         k.c(var12.toString());
      } else {
         StringBuilder var15 = new StringBuilder();
         var15.append("mraid.");
         var15.append(var2);
         k.d(var15.toString());
      }
   }

   @JavascriptInterface
   public void muteIVideo() {
      try {
         this.getMraidIVideoInterface().muteIVideo();
      } catch (Exception var2) {
         k.b(var2.getMessage());
      }
   }

   @JavascriptInterface
   public void open(String var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("open: ");
      var2.append(var1);
      k.a(var2.toString());
      this.getMraidInterface().open(var1);
   }

   @JavascriptInterface
   public void pauseIVideo() {
      try {
         this.getMraidIVideoInterface().pauseIVideo();
      } catch (Exception var2) {
         k.b(var2.getMessage());
      }
   }

   @JavascriptInterface
   public void playIVideo(String var1) {
      try {
         this.getMraidIVideoInterface().playIVideo(var1);
      } catch (Exception var3) {
         k.b(var3.getMessage());
      }
   }

   @JavascriptInterface
   public void playVideo(String var1) {
      this.getMraidInterface().playVideo(var1);
   }

   @JavascriptInterface
   public void replayIVideo() {
      try {
         this.getMraidIVideoInterface().replayIVideo();
      } catch (Exception var2) {
         k.b(var2.getMessage());
      }
   }

   @JavascriptInterface
   public void resize() {
      k.a("resize");
      this.getMraidInterface().resize();
   }

   @JavascriptInterface
   public void resumeIVideo() {
      try {
         this.getMraidIVideoInterface().resumeIVideo();
      } catch (Exception var2) {
         k.b(var2.getMessage());
      }
   }

   @JavascriptInterface
   public void runTiltSensor() {
      this.getMraidInterface().runTiltSensor();
   }

   @JavascriptInterface
   public void seekIVideo(long var1) {
      try {
         this.getMraidIVideoInterface().seekIVideo(var1);
      } catch (Exception var4) {
         k.b(var4.getMessage());
      }
   }

   @JavascriptInterface
   public void setExpandProperties(String var1) {
      Exception var10000;
      label76: {
         boolean var10001;
         o.a var9;
         try {
            StringBuilder var2 = new StringBuilder();
            var2.append("setExpandProperties: ");
            var2.append(var1);
            k.a(var2.toString());
            var9 = this.getMraidModel().e();
            if (this.getMraidModel().e() == null) {
               o var13 = this.getMraidModel();
               var9 = var13.new a();
               this.getMraidModel().a(var9);
            }
         } catch (Exception var20) {
            var10000 = var20;
            var10001 = false;
            break label76;
         }

         JSONObject var10;
         label69: {
            int var12;
            label68: {
               try {
                  var10 = new JSONObject(var1);
                  if (var10.isNull("width")) {
                     break label69;
                  }

                  var12 = var10.getInt("width");
                  if (var12 <= this.getMraidModel().g()) {
                     break label68;
                  }
               } catch (Exception var19) {
                  var10000 = var19;
                  var10001 = false;
                  break label76;
               }

               var12 = -1;
            }

            try {
               var9.b((int)((float)var12 * this.getScale()));
            } catch (Exception var18) {
               var10000 = var18;
               var10001 = false;
               break label76;
            }
         }

         label58: {
            int var11;
            label57: {
               try {
                  if (var10.isNull("height")) {
                     break label58;
                  }

                  var11 = var10.getInt("height");
                  if (var11 <= this.getMraidModel().f()) {
                     break label57;
                  }
               } catch (Exception var17) {
                  var10000 = var17;
                  var10001 = false;
                  break label76;
               }

               var11 = -1;
            }

            try {
               var9.a((int)((float)var11 * this.getScale()));
            } catch (Exception var16) {
               var10000 = var16;
               var10001 = false;
               break label76;
            }
         }

         try {
            if (var10.isNull("useCustomClose")) {
               return;
            }

            var9.b(var10.getBoolean("useCustomClose"));
            if (this.getMraidModel().m() != ADFMraidState.EXPANDED && this.getMraidModel().i() != ADFMraidPlacementType.INTERSTITIAL) {
               return;
            }
         } catch (Exception var15) {
            var10000 = var15;
            var10001 = false;
            break label76;
         }

         try {
            this.getMraidInterface().useCustomClose(var9.d());
            return;
         } catch (Exception var14) {
            var10000 = var14;
            var10001 = false;
         }
      }

      Exception var3 = var10000;
      StringBuilder var4 = new StringBuilder();
      var4.append("ADFMraidJSIn->setExpandProperties:");
      var4.append(var3.toString());
      k.b(var4.toString());
   }

   @JavascriptInterface
   public void setOrientationProperties(String var1) {
      this.getMraidInterface().setOrientationProperties(var1);
   }

   @JavascriptInterface
   public void setResizeProperties(String var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("setResizeProperties: ");
      var2.append(var1);
      k.a(var2.toString());
      this.getMraidInterface().setResizeProperties(var1);
   }

   @JavascriptInterface
   public void stopTiltSensor() {
      this.getMraidInterface().stopTiltSensor();
   }

   @JavascriptInterface
   public void storePicture(String var1) {
      this.getMraidInterface().storePicture(var1);
   }

   @JavascriptInterface
   public void unMuteIVideo() {
      try {
         this.getMraidIVideoInterface().unMuteIVideo();
      } catch (Exception var2) {
         k.b(var2.getMessage());
      }
   }
}
