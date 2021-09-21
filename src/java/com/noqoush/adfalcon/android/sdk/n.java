package com.noqoush.adfalcon.android.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.noqoush.adfalcon.android.sdk.constant.ADFIVideoTracking;
import com.noqoush.adfalcon.android.sdk.constant.ADFMraidPlacementType;
import com.noqoush.adfalcon.android.sdk.constant.ADFMraidState;
import org.json.JSONObject;

class n extends Handler implements ADFMraidInterface, t, ADFMraidIVideoOutInterface, ADFMraidIVideoInInterface {
   public static final int i = 0;
   public static final int j = 1;
   public static final int k = 2;
   public static final int l = 3;
   public static final int m = 4;
   public static final int n = 5;
   public static final int o = 6;
   public static final int p = 7;
   public static final int q = 8;
   public static final int r = 9;
   public static final int s = 10;
   public static final int t = 11;
   public static final int u = 12;
   public static final int v = 13;
   public static final int w = 14;
   public static final int x = 15;
   public static final int y = 16;
   private m a;
   private ADFMraidJSInListener b;
   private ADFMraidJSOutListener c;
   private ADFMraidIVideoInInterface d;
   private o e;
   private s f;
   private boolean g;
   private boolean h;

   public n(m var1, o var2) {
      try {
         this.a(var1);
         this.a(var2);
         this.e();
      } catch (Exception var5) {
         StringBuilder var4 = new StringBuilder();
         var4.append("ADFMraidController->");
         var4.append(var5.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var4.toString());
      }
   }

   // $FF: synthetic method
   static ADFMraidJSOutListener a(n var0) {
      return var0.j();
   }

   private void a(m var1) {
      this.a = var1;
   }

   private void a(o var1) {
      this.e = var1;
   }

   private void b(boolean var1) {
      this.h = var1;
   }

   private boolean g() {
      return this.i().getContext().checkCallingOrSelfPermission("android.permission.WRITE_CALENDAR") == 0 && this.i().getContext().checkCallingOrSelfPermission("android.permission.READ_CALENDAR") == 0;
   }

   private boolean h() {
      return this.i().getContext().checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
   }

   private m i() {
      return this.a;
   }

   private ADFMraidJSOutListener j() {
      return this.c;
   }

   private boolean k() {
      return this.h;
   }

   public void a() {
      try {
         this.c.onShake();
      } catch (Exception var3) {
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFMraidController->onTiltChange: ");
         var2.append(var3.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var2.toString());
      }
   }

   public void a(float var1, float var2, float var3) {
      try {
         this.c.setTilt(var1, var2, var3);
      } catch (Exception var6) {
         StringBuilder var5 = new StringBuilder();
         var5.append("ADFMraidController->onTiltChange: ");
         var5.append(var6.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var5.toString());
      }
   }

   public void a(int var1) {
   }

   protected void a(ADFMraidIVideoInInterface var1) {
      this.d = var1;
   }

   protected void a(boolean var1) {
      this.g = var1;
   }

   protected void b() {
      try {
         this.f.b();
         this.j().destroy();
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.k.b(var2.getMessage());
      }
   }

   protected ADFMraidIVideoInInterface c() {
      return this.d;
   }

   public void close(boolean var1) {
      Exception var10000;
      label70: {
         boolean var10001;
         label71: {
            try {
               if (this.d().m() == ADFMraidState.EXPANDED || this.d().m() == ADFMraidState.RESIZED || this.d().i() == ADFMraidPlacementType.INTERSTITIAL) {
                  break label71;
               }
            } catch (Exception var14) {
               var10000 = var14;
               var10001 = false;
               break label70;
            }

            if (!var1) {
               return;
            }

            try {
               ADFMraidJSOutListener var7 = this.j();
               StringBuilder var8 = new StringBuilder();
               var8.append("SDK cannot close this ad creative because its state is ");
               var8.append(this.d().m().toString().toLowerCase());
               var7.fireErrorEvent(var8.toString(), "close");
               return;
            } catch (Exception var9) {
               var10000 = var9;
               var10001 = false;
               break label70;
            }
         }

         if (var1) {
            try {
               this.sendMessage(this.obtainMessage(3));
            } catch (Exception var13) {
               var10000 = var13;
               var10001 = false;
               break label70;
            }
         }

         label74: {
            try {
               if (this.i().getController() != null && this.i().getController().g().B()) {
                  this.setState(ADFMraidState.HIDDEN);
                  break label74;
               }
            } catch (Exception var12) {
               var10000 = var12;
               var10001 = false;
               break label70;
            }

            try {
               this.setState(ADFMraidState.DEFAULT);
            } catch (Exception var11) {
               var10000 = var11;
               var10001 = false;
               break label70;
            }
         }

         try {
            this.j().fireSizeChangeEvent(this.d().d(), this.d().a());
            return;
         } catch (Exception var10) {
            var10000 = var10;
            var10001 = false;
         }
      }

      Exception var2 = var10000;
      StringBuilder var3 = new StringBuilder();
      var3.append("ADFMraidController->close->");
      var3.append(var2.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
   }

   public void closeIVideo() {
      try {
         Message var6 = this.obtainMessage(12);
         var6.setData(new Bundle());
         this.sendMessage(var6);
      } catch (Exception var8) {
         Exception var1 = var8;
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFMraidController->resumeIVideo: ");
         var2.append(var8.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var2.toString());

         try {
            this.j().fireErrorEvent(var1.getMessage(), "closeIVideo");
         } catch (Exception var7) {
            com.noqoush.adfalcon.android.sdk.k.b(var7.getMessage());
         }
      }
   }

   public void createCalendarEvent(String var1) {
      try {
         if (!this.g()) {
            this.j().fireErrorEvent("SDK does not support calendar feature", "createCalendarEvent");
         } else {
            Message var6 = this.obtainMessage(7);
            Bundle var7 = new Bundle();
            var7.putString("json", var1);
            var6.setData(var7);
            this.sendMessage(var6);
         }
      } catch (Exception var8) {
         StringBuilder var3 = new StringBuilder();
         var3.append("ADFMraidController->createCalendarEvent:");
         var3.append(var8.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
      }
   }

   protected o d() {
      return this.e;
   }

   protected void e() {
      if (this.b == null) {
         this.b = new ADFMraidJSInListener(this, this.d(), this.i(), this.i().s);
         com.noqoush.adfalcon.android.sdk.response.k var1 = this.i().getResponse();
         boolean var2;
         if (var1 != null && var1.s() != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.c = new ADFMraidJSOutListener(this.d(), this.i(), var2);

         try {
            this.f = new s(this.i().getContext(), this);
            return;
         } catch (Exception var4) {
            com.noqoush.adfalcon.android.sdk.k.b(var4.getMessage());
         }
      }

   }

   public void expand(String var1) {
      Exception var10000;
      label57: {
         boolean var10001;
         ADFMraidState var6;
         ADFMraidState var7;
         try {
            var6 = this.d().m();
            var7 = ADFMraidState.EXPANDED;
         } catch (Exception var22) {
            var10000 = var22;
            var10001 = false;
            break label57;
         }

         String var14;
         if (var6 == var7) {
            var14 = "the ad creative is already expanded";
         } else {
            ADFMraidState var8;
            ADFMraidState var9;
            try {
               var8 = this.d().m();
               var9 = ADFMraidState.HIDDEN;
            } catch (Exception var21) {
               var10000 = var21;
               var10001 = false;
               break label57;
            }

            if (var8 == var9) {
               var14 = "the ad creative is hidden";
            } else {
               ADFMraidState var11;
               ADFMraidState var10;
               try {
                  var10 = this.d().m();
                  var11 = ADFMraidState.LOADING;
               } catch (Exception var20) {
                  var10000 = var20;
                  var10001 = false;
                  break label57;
               }

               if (var10 == var11) {
                  var14 = "the ad creative is not loaded completely";
               } else {
                  ADFMraidPlacementType var13;
                  ADFMraidPlacementType var12;
                  try {
                     var12 = this.d().i();
                     var13 = ADFMraidPlacementType.INTERSTITIAL;
                  } catch (Exception var19) {
                     var10000 = var19;
                     var10001 = false;
                     break label57;
                  }

                  if (var12 == var13) {
                     var14 = "You cannot call expand if a placement type is interstitial";
                  } else {
                     var14 = null;
                  }
               }
            }
         }

         if (var14 != null) {
            try {
               this.j().fireErrorEvent(var14, "expand");
               return;
            } catch (Exception var17) {
               var10000 = var17;
               var10001 = false;
            }
         } else {
            try {
               Message var15 = this.obtainMessage(2);
               Bundle var16 = new Bundle();
               var16.putString("url", var1);
               var15.setData(var16);
               this.sendMessage(var15);
               return;
            } catch (Exception var18) {
               var10000 = var18;
               var10001 = false;
            }
         }
      }

      Exception var2 = var10000;
      StringBuilder var3 = new StringBuilder();
      var3.append("ADFMraidController->expand->");
      var3.append(var2.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
   }

   protected boolean f() {
      return this.g;
   }

   public void firePlayIVideoError(String var1) throws Exception {
      try {
         this.j().firePlayIVideoError(var1);
      } catch (Exception var3) {
      }
   }

   public void fireSizeChangeEvent(int var1, int var2) {
      try {
         this.j().fireSizeChangeEvent(var1, var2);
      } catch (Exception var5) {
         StringBuilder var4 = new StringBuilder();
         var4.append("ADFMraidController->fireSizeChangeEvent->");
         var4.append(var5.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var4.toString());
      }
   }

   public void handleMessage(Message var1) {
      String var2 = "createCalendarEvent";

      label177: {
         Exception var3;
         label172: {
            Exception var10000;
            label178: {
               boolean var10001;
               int var14;
               Bundle var13;
               try {
                  var13 = var1.getData();
                  var14 = var1.what;
               } catch (Exception var40) {
                  var10000 = var40;
                  var10001 = false;
                  break label178;
               }

               switch(var14) {
               case 0:
                  try {
                     Toast.makeText(this.i().getContext(), var13.getString("msg"), 1).show();
                     break label177;
                  } catch (Exception var38) {
                     var10000 = var38;
                     var10001 = false;
                     break label178;
                  }
               case 1:
                  var2 = "open";

                  try {
                     this.i().c(var13.getString("url"));
                     break label177;
                  } catch (Exception var37) {
                     var10000 = var37;
                     var10001 = false;
                     break;
                  }
               case 2:
                  var2 = "expand";

                  try {
                     this.i().b(var13.getString("url"));
                     this.setState(ADFMraidState.EXPANDED);
                     break label177;
                  } catch (Exception var36) {
                     var10000 = var36;
                     var10001 = false;
                     break;
                  }
               case 3:
                  var2 = "close";

                  try {
                     this.i().a(true);
                     break label177;
                  } catch (Exception var35) {
                     var10000 = var35;
                     var10001 = false;
                     break;
                  }
               case 4:
                  var2 = "resize";

                  try {
                     this.i().i();
                     break label177;
                  } catch (Exception var34) {
                     var10000 = var34;
                     var10001 = false;
                     break;
                  }
               case 5:
                  try {
                     this.i().b(var13.getBoolean("useCustomClose"));
                     break label177;
                  } catch (Exception var33) {
                     var3 = var33;
                     var2 = "useCustomClose";
                     break label172;
                  }
               case 6:
                  try {
                     this.i().g();
                     break label177;
                  } catch (Exception var32) {
                     var10000 = var32;
                     var10001 = false;
                     break label178;
                  }
               case 7:
                  String var16;
                  try {
                     var16 = com.noqoush.adfalcon.android.sdk.util.d.a(this.i().getContext(), var13.getString("json"));
                  } catch (Exception var39) {
                     var10000 = var39;
                     var10001 = false;
                     break;
                  }

                  if (var16 == null) {
                     break label177;
                  }

                  try {
                     Toast.makeText(this.i().getContext(), var16, 1).show();
                     this.j().fireErrorEvent(var16, var2);
                     break label177;
                  } catch (Exception var31) {
                     var10000 = var31;
                     var10001 = false;
                     break;
                  }
               case 8:
                  var2 = "playVideo";

                  try {
                     String var17 = var13.getString("url");
                     this.i().d(var17);
                     break label177;
                  } catch (Exception var30) {
                     var10000 = var30;
                     var10001 = false;
                     break;
                  }
               case 9:
                  var2 = "playIVideo";

                  try {
                     String var18 = var13.getString("url");
                     this.i().playIVideo(var18);
                     break label177;
                  } catch (Exception var29) {
                     var10000 = var29;
                     var10001 = false;
                     break;
                  }
               case 10:
                  var2 = "pauseIVideo";

                  try {
                     this.i().pauseIVideo();
                     break label177;
                  } catch (Exception var28) {
                     var10000 = var28;
                     var10001 = false;
                     break;
                  }
               case 11:
                  var2 = "resumeIVideo";

                  try {
                     this.i().resumeIVideo();
                     break label177;
                  } catch (Exception var27) {
                     var10000 = var27;
                     var10001 = false;
                     break;
                  }
               case 12:
                  var2 = "closeIVideo";

                  try {
                     this.i().closeIVideo();
                     break label177;
                  } catch (Exception var26) {
                     var10000 = var26;
                     var10001 = false;
                     break;
                  }
               case 13:
                  var2 = "seekIVideo";

                  try {
                     long var19 = var13.getLong("toPosition");
                     this.i().seekIVideo(var19);
                     break label177;
                  } catch (Exception var25) {
                     var10000 = var25;
                     var10001 = false;
                     break;
                  }
               case 14:
                  var2 = "muteIVideo";

                  try {
                     this.i().muteIVideo();
                     break label177;
                  } catch (Exception var24) {
                     var10000 = var24;
                     var10001 = false;
                     break;
                  }
               case 15:
                  var2 = "unMuteIVideo";

                  try {
                     this.i().unMuteIVideo();
                     break label177;
                  } catch (Exception var23) {
                     var10000 = var23;
                     var10001 = false;
                     break;
                  }
               case 16:
                  var2 = "replayIVideo";

                  try {
                     this.i().replayIVideo();
                  } catch (Exception var22) {
                     var10000 = var22;
                     var10001 = false;
                     break;
                  }
               default:
                  break label177;
               }

               var3 = var10000;
               break label172;
            }

            var3 = var10000;
            var2 = null;
         }

         StringBuilder var4 = new StringBuilder();
         var4.append("ADFMraidController->handleMessage->");
         String var9;
         if (var2 != null) {
            StringBuilder var6 = new StringBuilder();
            var6.append(var2);
            var6.append("->");
            var9 = var6.toString();
         } else {
            var9 = "";
         }

         var4.append(var9);
         var4.append(var3.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var4.toString());
         if (var2 != null) {
            try {
               this.j().fireErrorEvent(var3.getMessage(), var2);
            } catch (Exception var21) {
               com.noqoush.adfalcon.android.sdk.k.b(var21.getMessage());
            }
         }
      }

      super.handleMessage(var1);
   }

   public void muteIVideo() {
      try {
         Message var6 = this.obtainMessage(14);
         var6.setData(new Bundle());
         this.sendMessage(var6);
      } catch (Exception var8) {
         Exception var1 = var8;
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFMraidController->muteIVideo: ");
         var2.append(var8.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var2.toString());

         try {
            this.j().fireErrorEvent(var1.getMessage(), "muteIVideo");
         } catch (Exception var7) {
            com.noqoush.adfalcon.android.sdk.k.b(var7.getMessage());
         }
      }
   }

   public void open(String var1) {
      Exception var10000;
      label35: {
         boolean var10001;
         label38: {
            if (var1 != null) {
               try {
                  if (var1.length() >= 3 && !var1.equalsIgnoreCase("undefined")) {
                     break label38;
                  }
               } catch (Exception var10) {
                  var10000 = var10;
                  var10001 = false;
                  break label35;
               }
            }

            try {
               this.j().fireErrorEvent("invalid url", "open");
               return;
            } catch (Exception var9) {
               var10000 = var9;
               var10001 = false;
               break label35;
            }
         }

         try {
            Message var6 = this.obtainMessage(1);
            Bundle var7 = new Bundle();
            var7.putString("url", var1);
            var6.setData(var7);
            this.sendMessage(var6);
            return;
         } catch (Exception var8) {
            var10000 = var8;
            var10001 = false;
         }
      }

      Exception var2 = var10000;
      StringBuilder var3 = new StringBuilder();
      var3.append("ADFMraidController->open->");
      var3.append(var2.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
   }

   public void pauseIVideo() {
      try {
         Message var6 = this.obtainMessage(10);
         var6.setData(new Bundle());
         this.sendMessage(var6);
      } catch (Exception var8) {
         Exception var1 = var8;
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFMraidController->pauseIVideo: ");
         var2.append(var8.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var2.toString());

         try {
            this.j().fireErrorEvent(var1.getMessage(), "pauseIVideo");
         } catch (Exception var7) {
            com.noqoush.adfalcon.android.sdk.k.b(var7.getMessage());
         }
      }
   }

   public void playIVideo(String var1) {
      try {
         Message var7 = this.obtainMessage(9);
         Bundle var8 = new Bundle();
         var8.putString("url", var1);
         var7.setData(var8);
         this.sendMessage(var7);
      } catch (Exception var10) {
         Exception var2 = var10;
         StringBuilder var3 = new StringBuilder();
         var3.append("ADFMraidController->playIVideo: ");
         var3.append(var10.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var3.toString());

         try {
            this.j().fireErrorEvent(var2.getMessage(), "playIVideo");
         } catch (Exception var9) {
            com.noqoush.adfalcon.android.sdk.k.b(var9.getMessage());
         }
      }
   }

   public void playVideo(String var1) {
      try {
         Message var6 = this.obtainMessage(8);
         Bundle var7 = new Bundle();
         var7.putString("url", var1);
         var6.setData(var7);
         this.sendMessage(var6);
      } catch (Exception var8) {
         StringBuilder var3 = new StringBuilder();
         var3.append("ADFMraidController->playVideo: ");
         var3.append(var8.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
      }
   }

   public void ready() {
      Exception var10000;
      label149: {
         boolean var10001;
         m var5;
         try {
            var5 = this.i();
         } catch (Exception var34) {
            var10000 = var34;
            var10001 = false;
            break label149;
         }

         boolean var6;
         label151: {
            var6 = true;
            if (var5 != null) {
               try {
                  if (this.d().o() && (this.i().getVisibility() != 0 || this.i().getParent() == null)) {
                     break label151;
                  }
               } catch (Exception var33) {
                  var10000 = var33;
                  var10001 = false;
                  break label149;
               }
            }

            try {
               this.j().setPlacementType();
               if (this.i() != null) {
                  this.i().setShouldCallTrackers(var6);
                  this.i().a("");
                  if (this.i().isShown() && this.i().getVisibility() == 0 && this.i().getParent() != null) {
                     this.i().c();
                  }
               }
            } catch (Exception var32) {
               var10000 = var32;
               var10001 = false;
               break label149;
            }

            ADFMraidJSOutListener var7;
            label129: {
               try {
                  var7 = this.j();
                  if (this.i().isShown() && this.i().getVisibility() == 0 && this.i().getParent() != null) {
                     break label129;
                  }
               } catch (Exception var31) {
                  var10000 = var31;
                  var10001 = false;
                  break label149;
               }

               var6 = false;
            }

            try {
               var7.fireViewableChangeEvent(var6);
               if (this.d().m() == ADFMraidState.LOADING) {
                  this.d().a(ADFMraidState.DEFAULT);
               }
            } catch (Exception var30) {
               var10000 = var30;
               var10001 = false;
               break label149;
            }

            ADFMraidJSOutListener var8;
            byte var9;
            label115: {
               label114: {
                  try {
                     this.j().setCurrentPosition(this.d().b(), this.d().c(), this.d().d(), this.d().a());
                     this.j().setDefaultPosition(this.d().b(), this.d().c(), this.d().d(), this.d().a());
                     this.j().setMaxSize(this.d().g(), this.d().f());
                     this.j().setScreenSize(this.d().l(), this.d().k());
                     var8 = this.j();
                     if (this.d().l() <= this.d().k()) {
                        break label114;
                     }
                  } catch (Exception var29) {
                     var10000 = var29;
                     var10001 = false;
                     break label149;
                  }

                  var9 = 90;
                  break label115;
               }

               var9 = 0;
            }

            try {
               var8.setOrientation(var9);
               this.j().setSupports("sms");
               this.j().setSupports("tel");
            } catch (Exception var28) {
               var10000 = var28;
               var10001 = false;
               break label149;
            }

            try {
               if (VERSION.SDK_INT >= 11 && this.i().isHardwareAccelerated() && this.i().getResponse() != null && this.i().getResponse().q().h()) {
                  this.j().setSupports("inlineVideo");
               }
            } catch (Exception var27) {
               Exception var10 = var27;

               try {
                  StringBuilder var11 = new StringBuilder();
                  var11.append("ADFMraidController->ready->");
                  var11.append(var10.toString());
                  com.noqoush.adfalcon.android.sdk.k.b(var11.toString());
               } catch (Exception var26) {
                  var10000 = var26;
                  var10001 = false;
                  break label149;
               }
            }

            try {
               if (this.g()) {
                  this.j().setSupports("calendar");
               }
            } catch (Exception var25) {
               Exception var14 = var25;

               try {
                  StringBuilder var15 = new StringBuilder();
                  var15.append("ADFMraidController->ready->");
                  var15.append(var14.toString());
                  com.noqoush.adfalcon.android.sdk.k.b(var15.toString());
               } catch (Exception var24) {
                  var10000 = var24;
                  var10001 = false;
                  break label149;
               }
            }

            try {
               if (this.h()) {
                  this.j().setSupports("storePicture");
               }
            } catch (Exception var23) {
               Exception var18 = var23;

               try {
                  StringBuilder var19 = new StringBuilder();
                  var19.append("ADFMraidController->ready->");
                  var19.append(var18.toString());
                  com.noqoush.adfalcon.android.sdk.k.b(var19.toString());
               } catch (Exception var22) {
                  var10000 = var22;
                  var10001 = false;
                  break label149;
               }
            }

            try {
               this.j().fireStateChangedEvent();
               this.j().fireReadyEvent();
               this.b(false);
               return;
            } catch (Exception var21) {
               var10000 = var21;
               var10001 = false;
               break label149;
            }
         }

         try {
            this.b(var6);
            return;
         } catch (Exception var20) {
            var10000 = var20;
            var10001 = false;
         }
      }

      Exception var1 = var10000;
      StringBuilder var2 = new StringBuilder();
      var2.append("ADFMraidController->ready->");
      var2.append(var1.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var2.toString());
   }

   public void replayIVideo() throws Exception {
      try {
         Message var6 = this.obtainMessage(16);
         var6.setData(new Bundle());
         this.sendMessage(var6);
      } catch (Exception var8) {
         Exception var1 = var8;
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFMraidController->replayIVideo: ");
         var2.append(var8.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var2.toString());

         try {
            this.j().fireErrorEvent(var1.getMessage(), "replayIVideo");
         } catch (Exception var7) {
         }
      }
   }

   public void resize() {
      Exception var10000;
      label48: {
         boolean var10001;
         ADFMraidState var5;
         ADFMraidState var6;
         try {
            var5 = this.d().m();
            var6 = ADFMraidState.DEFAULT;
         } catch (Exception var18) {
            var10000 = var18;
            var10001 = false;
            break label48;
         }

         if (var5 != var6) {
            try {
               if (this.d().m() != ADFMraidState.RESIZED) {
                  ADFMraidJSOutListener var13 = this.j();
                  StringBuilder var14 = new StringBuilder();
                  var14.append("you can not invoke resize while the state is ");
                  var14.append(this.d().m().toString().toLowerCase());
                  var13.fireErrorEvent(var14.toString(), "resize");
                  return;
               }
            } catch (Exception var17) {
               var10000 = var17;
               var10001 = false;
               break label48;
            }
         }

         try {
            if (this.d().i() == ADFMraidPlacementType.INTERSTITIAL) {
               ADFMraidJSOutListener var9 = this.j();
               StringBuilder var10 = new StringBuilder();
               var10.append("you can not invoke resize if the placement type is ");
               var10.append(this.d().i().toString().toLowerCase());
               var9.fireErrorEvent(var10.toString(), "resize");
               return;
            }
         } catch (Exception var16) {
            var10000 = var16;
            var10001 = false;
            break label48;
         }

         try {
            if (this.d().j() == null) {
               this.j().fireErrorEvent("you have not passed the resize properties", "resize");
               return;
            }
         } catch (Exception var19) {
            var10000 = var19;
            var10001 = false;
            break label48;
         }

         try {
            Message var7 = this.obtainMessage(4);
            var7.setData(new Bundle());
            this.sendMessage(var7);
            this.setState(ADFMraidState.RESIZED);
            return;
         } catch (Exception var15) {
            var10000 = var15;
            var10001 = false;
         }
      }

      Exception var1 = var10000;
      StringBuilder var2 = new StringBuilder();
      var2.append("ADFMraidController->resize->");
      var2.append(var1.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var2.toString());
   }

   public void resumeIVideo() {
      try {
         Message var6 = this.obtainMessage(11);
         var6.setData(new Bundle());
         this.sendMessage(var6);
      } catch (Exception var8) {
         Exception var1 = var8;
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFMraidController->resumeIVideo: ");
         var2.append(var8.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var2.toString());

         try {
            this.j().fireErrorEvent(var1.getMessage(), "resumeIVideo");
         } catch (Exception var7) {
            com.noqoush.adfalcon.android.sdk.k.b(var7.getMessage());
         }
      }
   }

   public void runTiltSensor() {
      try {
         if (this.f != null) {
            this.f.a();
         }

         this.a(true);
      } catch (Exception var3) {
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFMraidController->runTiltSensor: ");
         var2.append(var3.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var2.toString());
      }
   }

   public void seekIVideo(long var1) {
      try {
         Message var8 = this.obtainMessage(13);
         Bundle var9 = new Bundle();
         var9.putLong("toPosition", var1);
         var8.setData(var9);
         this.sendMessage(var8);
      } catch (Exception var11) {
         Exception var3 = var11;
         StringBuilder var4 = new StringBuilder();
         var4.append("ADFMraidController->seekIVideo: ");
         var4.append(var11.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var4.toString());

         try {
            this.j().fireErrorEvent(var3.getMessage(), "seekIVideo");
         } catch (Exception var10) {
            com.noqoush.adfalcon.android.sdk.k.b(var10.getMessage());
         }
      }
   }

   public void setCurrentPosition(int var1, int var2, int var3, int var4) {
      try {
         this.j().setCurrentPosition(var1, var2, var3, var4);
         this.d().a(var1, var2, var3, var4);
      } catch (Exception var7) {
         StringBuilder var6 = new StringBuilder();
         var6.append("ADFMraidController->setCurrentPosition->");
         var6.append(var7.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var6.toString());
      }
   }

   public void setDefaultPosition(int var1, int var2, int var3, int var4) {
      try {
         this.j().setDefaultPosition(var1, var2, var3, var4);
      } catch (Exception var7) {
         StringBuilder var6 = new StringBuilder();
         var6.append("ADFMraidController->setDefaultPosition->");
         var6.append(var7.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var6.toString());
      }
   }

   public void setIVideoDuration(long var1) throws Exception {
      try {
         this.j().setIVideoDuration(var1);
      } catch (Exception var5) {
         StringBuilder var4 = new StringBuilder();
         var4.append("ADFMraidController->setIVideoDuration: ");
         var4.append(var5.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var4.toString());
      }
   }

   public void setIVideoTimeUpdate(long var1) throws Exception {
      try {
         this.j().setIVideoTimeUpdate(var1);
      } catch (Exception var5) {
         StringBuilder var4 = new StringBuilder();
         var4.append("ADFMraidController->setIVideoTimeUpdate: ");
         var4.append(var5.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var4.toString());
      }
   }

   public void setIVideoTracking(ADFIVideoTracking var1) throws Exception {
      try {
         this.j().setIVideoTracking(var1);
      } catch (Exception var4) {
         StringBuilder var3 = new StringBuilder();
         var3.append("ADFMraidController->setIVideoTrackingEvent: ");
         var3.append(var4.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
      }
   }

   public void setMaxSize(int var1, int var2) {
      try {
         this.d().a(var1, var2);
         this.j().setMaxSize(var1, var2);
      } catch (Exception var5) {
         StringBuilder var4 = new StringBuilder();
         var4.append("ADFMraidController->setMaxSize->");
         var4.append(var5.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var4.toString());
      }
   }

   public void setOrientationProperties(String var1) {
      Exception var10000;
      label50: {
         boolean var10001;
         o.b var7;
         try {
            var7 = this.d().h();
         } catch (Exception var14) {
            var10000 = var14;
            var10001 = false;
            break label50;
         }

         if (var7 == null) {
            try {
               var7 = new o.b();
               this.d().a(var7);
            } catch (Exception var13) {
               var10000 = var13;
               var10001 = false;
               break label50;
            }
         }

         try {
            JSONObject var8 = new JSONObject(var1);
            var7.a(var8.getBoolean("allowOrientationChange"));
            var7.a(var8.getString("forceOrientation"));
            if (this.d().m() != ADFMraidState.EXPANDED && this.d().i() != ADFMraidPlacementType.INTERSTITIAL) {
               return;
            }
         } catch (Exception var12) {
            var10000 = var12;
            var10001 = false;
            break label50;
         }

         try {
            Message var9 = this.obtainMessage(6);
            var9.setData(new Bundle());
            this.sendMessage(var9);
            return;
         } catch (Exception var11) {
            var10000 = var11;
            var10001 = false;
         }
      }

      Exception var2 = var10000;

      try {
         this.j().fireErrorEvent(var2.getMessage(), "setOrientationProperties");
      } catch (Exception var10) {
      }

      StringBuilder var4 = new StringBuilder();
      var4.append("ADFMraidController->setOrientationProperties:");
      var4.append(var2.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var4.toString());
   }

   public void setPlacementType(ADFMraidPlacementType var1) {
      try {
         this.d().a(var1);
         this.j().setPlacementType();
      } catch (Exception var4) {
         StringBuilder var3 = new StringBuilder();
         var3.append("ADFMraidController->setPlacementType->");
         var3.append(var4.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
      }
   }

   public void setResizeProperties(String var1) {
      try {
         JSONObject var2 = new JSONObject(var1);
         o var8 = this.d();
         o.c var10 = var8.new c();
         var10.d(var2.getInt("width"));
         var10.a(var2.getInt("height"));
         var10.b(var2.getInt("offsetX"));
         var10.c(var2.getInt("offsetY"));
         var10.a(var2.getString("customClosePosition"));
         var10.a(var2.getBoolean("allowOffscreen"));
         this.d().a(var10);
      } catch (Exception var12) {
         Exception var3 = var12;
         StringBuilder var4 = new StringBuilder();
         var4.append("ADFMraidController->setResizeProperties->");
         var4.append(var12.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var4.toString());

         try {
            this.j().fireErrorEvent(var3.getMessage(), "setResizeProperties");
         } catch (Exception var11) {
         }
      }
   }

   public void setScreenSize(int var1, int var2) {
      try {
         this.d().b(var1, var2);
         this.j().setScreenSize(var1, var2);
      } catch (Exception var5) {
         StringBuilder var4 = new StringBuilder();
         var4.append("ADFMraidController->setScreenSize->");
         var4.append(var5.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var4.toString());
      }
   }

   public void setState(ADFMraidState var1) {
      try {
         if (this.d().m() != var1) {
            this.d().a(var1);
            if (var1 == ADFMraidState.EXPANDED) {
               this.i().postDelayed(new n$a(this), 500L);
               return;
            }

            if (var1 == ADFMraidState.HIDDEN) {
               this.i().destroy();
            }

            this.j().fireStateChangedEvent();
            return;
         }
      } catch (Exception var4) {
         StringBuilder var3 = new StringBuilder();
         var3.append("ADFMraidController->setState->");
         var3.append(var4.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
      }

   }

   public void setViewableChange(boolean var1) {
      Exception var10000;
      label62: {
         boolean var10001;
         boolean var2;
         label65: {
            if (var1) {
               label64: {
                  try {
                     if (!this.i().isShown()) {
                        break label64;
                     }
                  } catch (Exception var16) {
                     var10000 = var16;
                     var10001 = false;
                     break label62;
                  }

                  var2 = true;
                  break label65;
               }
            }

            var2 = false;
         }

         try {
            StringBuilder var3 = new StringBuilder();
            var3.append("setViewableChange: ");
            var3.append(var2);
            com.noqoush.adfalcon.android.sdk.util.a.a(var3.toString());
         } catch (Exception var14) {
            var10000 = var14;
            var10001 = false;
            break label62;
         }

         if (var2) {
            try {
               if (this.k()) {
                  this.ready();
               }
            } catch (Exception var13) {
               var10000 = var13;
               var10001 = false;
               break label62;
            }
         }

         if (var2) {
            try {
               this.i().c();
            } catch (Exception var12) {
               var10000 = var12;
               var10001 = false;
               break label62;
            }
         }

         try {
            if (this.d().n() != var2) {
               this.d().b(var2);
               this.j().fireViewableChangeEvent(var2);
               return;
            }
         } catch (Exception var15) {
            var10000 = var15;
            var10001 = false;
            break label62;
         }

         try {
            StringBuilder var6 = new StringBuilder();
            var6.append("viewable is already ");
            var6.append(var2);
            com.noqoush.adfalcon.android.sdk.k.e(var6.toString());
            return;
         } catch (Exception var11) {
            var10000 = var11;
            var10001 = false;
         }
      }

      Exception var9 = var10000;
      StringBuilder var10 = new StringBuilder();
      var10.append("ADFMraidController->setViewableChange->");
      var10.append(var9.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var10.toString());
   }

   public void stopTiltSensor() {
      try {
         if (this.f != null) {
            this.f.b();
         }

         return;
      } catch (Exception var8) {
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFMraidController->stopTiltSensor: ");
         var2.append(var8.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var2.toString());
      } finally {
         this.a(false);
      }

   }

   public void storePicture(String var1) {
      Exception var10000;
      label53: {
         boolean var10001;
         if (var1 != null) {
            label52: {
               try {
                  if (var1.length() < 3 || var1.equalsIgnoreCase("undefined")) {
                     break label52;
                  }
               } catch (Exception var7) {
                  var10000 = var7;
                  var10001 = false;
                  break label53;
               }

               try {
                  if (this.h()) {
                     com.noqoush.adfalcon.android.sdk.util.d.a(this.i().getContext(), var1, (Handler)this);
                     return;
                  }
               } catch (Exception var6) {
                  var10000 = var6;
                  var10001 = false;
                  break label53;
               }

               try {
                  this.j().fireErrorEvent("SKD does not support storePicture feature", "storePicture");
                  this.open(var1);
                  return;
               } catch (Exception var4) {
                  var10000 = var4;
                  var10001 = false;
                  break label53;
               }
            }
         }

         try {
            this.j().fireErrorEvent("Invalid uri", "storePicture");
            return;
         } catch (Exception var5) {
            var10000 = var5;
            var10001 = false;
         }
      }

      Exception var2 = var10000;
      StringBuilder var3 = new StringBuilder();
      var3.append("ADFMraidController->storePicture:");
      var3.append(var2.toString());
      com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
   }

   public void unMuteIVideo() {
      try {
         Message var6 = this.obtainMessage(15);
         var6.setData(new Bundle());
         this.sendMessage(var6);
      } catch (Exception var8) {
         Exception var1 = var8;
         StringBuilder var2 = new StringBuilder();
         var2.append("ADFMraidController->unMuteIVideo: ");
         var2.append(var8.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var2.toString());

         try {
            this.j().fireErrorEvent(var1.getMessage(), "unMuteIVideo");
         } catch (Exception var7) {
         }
      }
   }

   public void useCustomClose(boolean var1) {
      try {
         Message var6 = this.obtainMessage(5);
         Bundle var7 = new Bundle();
         var7.putBoolean("useCustomClose", var1);
         var6.setData(var7);
         this.sendMessage(var6);
      } catch (Exception var8) {
         StringBuilder var3 = new StringBuilder();
         var3.append("ADFMraidController->useCustomClose:");
         var3.append(var8.toString());
         com.noqoush.adfalcon.android.sdk.k.b(var3.toString());
      }
   }
}
