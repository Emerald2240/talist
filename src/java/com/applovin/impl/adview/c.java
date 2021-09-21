package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;

class c extends g {
   private static c g;
   private final com.applovin.impl.sdk.p a;
   private final com.applovin.impl.sdk.j b;
   private com.applovin.impl.sdk.c.d c;
   private AppLovinAd d;
   private boolean e;
   private final boolean f;

   c(d var1, com.applovin.impl.sdk.j var2, Context var3) {
      this(var1, var2, var3, false);
   }

   c(d var1, com.applovin.impl.sdk.j var2, Context var3, boolean var4) {
      super(var3);
      this.d = null;
      this.e = false;
      if (var2 != null) {
         this.b = var2;
         this.a = var2.v();
         this.f = var4;
         this.setBackgroundColor(0);
         WebSettings var5 = this.getSettings();
         var5.setSupportMultipleWindows(false);
         var5.setJavaScriptEnabled(true);
         this.setWebViewClient(var1);
         this.setWebChromeClient(new b(var2));
         this.setVerticalScrollBarEnabled(false);
         this.setHorizontalScrollBarEnabled(false);
         this.setScrollBarStyle(33554432);
         if (com.applovin.impl.sdk.utils.g.g()) {
            this.setWebViewRenderProcessClient((new e(var2)).a());
         }

         this.setOnTouchListener(new c$1(this));
         this.setOnLongClickListener(new c$12(this));
      } else {
         throw new IllegalArgumentException("No sdk specified.");
      }
   }

   public static c a(AppLovinAdSize var0, d var1, com.applovin.impl.sdk.j var2, Context var3) {
      if ((Boolean)var2.a(com.applovin.impl.sdk.b.d.fh) && var0 == AppLovinAdSize.INTERSTITIAL) {
         c var4 = g;
         if (var4 == null) {
            g = new c(var1, var2, var3.getApplicationContext(), true);
         } else {
            var4.setWebViewClient(var1);
         }

         return g;
      } else {
         return new c(var1, var2, var3);
      }
   }

   // $FF: synthetic method
   static com.applovin.impl.sdk.p a(c var0) {
      return var0.a;
   }

   private String a(String var1, String var2) {
      return com.applovin.impl.sdk.utils.n.b(var1) ? com.applovin.impl.sdk.utils.q.b(var1).replace("{SOURCE}", var2) : null;
   }

   private void a(com.applovin.impl.sdk.ad.f var1) {
      Throwable var10000;
      label7651: {
         boolean var10001;
         label7647: {
            try {
               if (!(Boolean)this.b.a(com.applovin.impl.sdk.b.d.eX) && !var1.aw()) {
                  break label7647;
               }
            } catch (Throwable var1140) {
               var10000 = var1140;
               var10001 = false;
               break label7651;
            }

            try {
               this.a((Runnable)(new c$13(this)));
            } catch (Throwable var1139) {
               var10000 = var1139;
               var10001 = false;
               break label7651;
            }
         }

         try {
            if (com.applovin.impl.sdk.utils.g.b()) {
               this.a((Runnable)(new c$14(this, var1)));
            }
         } catch (Throwable var1138) {
            var10000 = var1138;
            var10001 = false;
            break label7651;
         }

         try {
            if (com.applovin.impl.sdk.utils.g.c() && var1.ay()) {
               this.a((Runnable)(new c$15(this)));
            }
         } catch (Throwable var1137) {
            var10000 = var1137;
            var10001 = false;
            break label7651;
         }

         w var3;
         try {
            var3 = var1.az();
         } catch (Throwable var1136) {
            var10000 = var1136;
            var10001 = false;
            break label7651;
         }

         if (var3 == null) {
            return;
         }

         PluginState var5;
         WebSettings var4;
         try {
            var4 = this.getSettings();
            var5 = var3.b();
         } catch (Throwable var1135) {
            var10000 = var1135;
            var10001 = false;
            break label7651;
         }

         if (var5 != null) {
            try {
               this.a((Runnable)(new c$16(this, var4, var5)));
            } catch (Throwable var1134) {
               var10000 = var1134;
               var10001 = false;
               break label7651;
            }
         }

         Boolean var6;
         try {
            var6 = var3.c();
         } catch (Throwable var1133) {
            var10000 = var1133;
            var10001 = false;
            break label7651;
         }

         if (var6 != null) {
            try {
               this.a((Runnable)(new c$17(this, var4, var6)));
            } catch (Throwable var1132) {
               var10000 = var1132;
               var10001 = false;
               break label7651;
            }
         }

         Boolean var7;
         try {
            var7 = var3.d();
         } catch (Throwable var1131) {
            var10000 = var1131;
            var10001 = false;
            break label7651;
         }

         if (var7 != null) {
            try {
               this.a((Runnable)(new c$18(this, var4, var7)));
            } catch (Throwable var1130) {
               var10000 = var1130;
               var10001 = false;
               break label7651;
            }
         }

         Boolean var8;
         try {
            var8 = var3.e();
         } catch (Throwable var1129) {
            var10000 = var1129;
            var10001 = false;
            break label7651;
         }

         if (var8 != null) {
            try {
               this.a((Runnable)(new c$19(this, var4, var8)));
            } catch (Throwable var1128) {
               var10000 = var1128;
               var10001 = false;
               break label7651;
            }
         }

         Boolean var9;
         try {
            var9 = var3.f();
         } catch (Throwable var1127) {
            var10000 = var1127;
            var10001 = false;
            break label7651;
         }

         if (var9 != null) {
            try {
               this.a((Runnable)(new c$2(this, var4, var9)));
            } catch (Throwable var1126) {
               var10000 = var1126;
               var10001 = false;
               break label7651;
            }
         }

         Boolean var10;
         try {
            var10 = var3.g();
         } catch (Throwable var1125) {
            var10000 = var1125;
            var10001 = false;
            break label7651;
         }

         if (var10 != null) {
            try {
               this.a((Runnable)(new c$3(this, var4, var10)));
            } catch (Throwable var1124) {
               var10000 = var1124;
               var10001 = false;
               break label7651;
            }
         }

         Boolean var11;
         try {
            var11 = var3.h();
         } catch (Throwable var1123) {
            var10000 = var1123;
            var10001 = false;
            break label7651;
         }

         if (var11 != null) {
            try {
               this.a((Runnable)(new c$4(this, var4, var11)));
            } catch (Throwable var1122) {
               var10000 = var1122;
               var10001 = false;
               break label7651;
            }
         }

         Boolean var12;
         try {
            var12 = var3.i();
         } catch (Throwable var1121) {
            var10000 = var1121;
            var10001 = false;
            break label7651;
         }

         if (var12 != null) {
            try {
               this.a((Runnable)(new c$5(this, var4, var12)));
            } catch (Throwable var1120) {
               var10000 = var1120;
               var10001 = false;
               break label7651;
            }
         }

         Boolean var13;
         try {
            var13 = var3.j();
         } catch (Throwable var1119) {
            var10000 = var1119;
            var10001 = false;
            break label7651;
         }

         if (var13 != null) {
            try {
               this.a((Runnable)(new c$6(this, var4, var13)));
            } catch (Throwable var1118) {
               var10000 = var1118;
               var10001 = false;
               break label7651;
            }
         }

         Boolean var14;
         try {
            var14 = var3.k();
         } catch (Throwable var1117) {
            var10000 = var1117;
            var10001 = false;
            break label7651;
         }

         if (var14 != null) {
            try {
               this.a((Runnable)(new c$7(this, var4, var14)));
            } catch (Throwable var1116) {
               var10000 = var1116;
               var10001 = false;
               break label7651;
            }
         }

         Boolean var15;
         try {
            var15 = var3.l();
         } catch (Throwable var1115) {
            var10000 = var1115;
            var10001 = false;
            break label7651;
         }

         if (var15 != null) {
            try {
               this.a((Runnable)(new c$8(this, var4, var15)));
            } catch (Throwable var1114) {
               var10000 = var1114;
               var10001 = false;
               break label7651;
            }
         }

         Boolean var16;
         try {
            var16 = var3.m();
         } catch (Throwable var1113) {
            var10000 = var1113;
            var10001 = false;
            break label7651;
         }

         if (var16 != null) {
            try {
               this.a((Runnable)(new c$9(this, var4, var16)));
            } catch (Throwable var1112) {
               var10000 = var1112;
               var10001 = false;
               break label7651;
            }
         }

         label7540: {
            Integer var18;
            try {
               if (!com.applovin.impl.sdk.utils.g.d()) {
                  break label7540;
               }

               var18 = var3.a();
            } catch (Throwable var1111) {
               var10000 = var1111;
               var10001 = false;
               break label7651;
            }

            if (var18 != null) {
               try {
                  this.a((Runnable)(new c$10(this, var4, var18)));
               } catch (Throwable var1110) {
                  var10000 = var1110;
                  var10001 = false;
                  break label7651;
               }
            }
         }

         Boolean var17;
         try {
            if (!com.applovin.impl.sdk.utils.g.e()) {
               return;
            }

            var17 = var3.n();
         } catch (Throwable var1109) {
            var10000 = var1109;
            var10001 = false;
            break label7651;
         }

         if (var17 == null) {
            return;
         }

         label7523:
         try {
            this.a((Runnable)(new c$11(this, var4, var17)));
            return;
         } catch (Throwable var1108) {
            var10000 = var1108;
            var10001 = false;
            break label7523;
         }
      }

      Throwable var2 = var10000;
      this.a.b("AdWebView", "Unable to apply WebView settings", var2);
   }

   private void a(Runnable var1) {
      try {
         var1.run();
      } catch (Throwable var4) {
         this.a.b("AdWebView", "Unable to apply WebView setting", var4);
         return;
      }
   }

   private void a(String var1, String var2, String var3, com.applovin.impl.sdk.j var4) {
      String var5 = this.a(var3, var1);
      if (com.applovin.impl.sdk.utils.n.b(var5)) {
         com.applovin.impl.sdk.p var15 = this.a;
         StringBuilder var16 = new StringBuilder();
         var16.append("Rendering webview for VAST ad with resourceContents : ");
         var16.append(var5);
         var15.b("AdWebView", var16.toString());
         this.loadDataWithBaseURL(var2, var5, "text/html", (String)null, "");
      } else {
         String var6 = this.a((String)var4.a(com.applovin.impl.sdk.b.d.eH), var1);
         if (com.applovin.impl.sdk.utils.n.b(var6)) {
            com.applovin.impl.sdk.p var11 = this.a;
            StringBuilder var12 = new StringBuilder();
            var12.append("Rendering webview for VAST ad with resourceContents : ");
            var12.append(var6);
            var11.b("AdWebView", var12.toString());
            this.loadDataWithBaseURL(var2, var6, "text/html", (String)null, "");
         } else {
            com.applovin.impl.sdk.p var7 = this.a;
            StringBuilder var8 = new StringBuilder();
            var8.append("Rendering webview for VAST ad with resourceURL : ");
            var8.append(var1);
            var7.b("AdWebView", var8.toString());
            this.loadUrl(var1);
         }
      }
   }

   public void a(com.applovin.impl.sdk.c.d var1) {
      this.c = var1;
   }

   public void a(AppLovinAd var1) {
      if (!this.e) {
         this.d = var1;

         Throwable var10000;
         label4560: {
            boolean var10001;
            com.applovin.impl.sdk.p var30;
            String var31;
            label4559: {
               label4567: {
                  try {
                     if (var1 instanceof com.applovin.impl.sdk.ad.h) {
                        this.loadDataWithBaseURL("/", ((com.applovin.impl.sdk.ad.h)var1).a(), "text/html", (String)null, "");
                        var30 = this.a;
                        break label4567;
                     }
                  } catch (Throwable var494) {
                     var10000 = var494;
                     var10001 = false;
                     break label4560;
                  }

                  com.applovin.impl.sdk.ad.f var3;
                  try {
                     var3 = (com.applovin.impl.sdk.ad.f)var1;
                     this.a(var3);
                     if (var3.ag()) {
                        this.setVisibility(0);
                     }
                  } catch (Throwable var492) {
                     var10000 = var492;
                     var10001 = false;
                     break label4560;
                  }

                  label4568: {
                     try {
                        if (var1 instanceof com.applovin.impl.sdk.ad.a) {
                           String var32 = com.applovin.impl.sdk.utils.q.b(((com.applovin.impl.sdk.ad.a)var1).a());
                           this.loadDataWithBaseURL(var3.ax(), var32, "text/html", (String)null, "");
                           var30 = this.a;
                           break label4568;
                        }
                     } catch (Throwable var493) {
                        var10000 = var493;
                        var10001 = false;
                        break label4560;
                     }

                     com.applovin.impl.a.b var5;
                     com.applovin.impl.a.a var4;
                     try {
                        if (!(var1 instanceof com.applovin.impl.a.a)) {
                           return;
                        }

                        var4 = (com.applovin.impl.a.a)var1;
                        var5 = var4.j();
                     } catch (Throwable var491) {
                        var10000 = var491;
                        var10001 = false;
                        break label4560;
                     }

                     if (var5 != null) {
                        Uri var7;
                        com.applovin.impl.a.e var6;
                        try {
                           var6 = var5.b();
                           var7 = var6.b();
                        } catch (Throwable var489) {
                           var10000 = var489;
                           var10001 = false;
                           break label4560;
                        }

                        String var8;
                        if (var7 != null) {
                           try {
                              var8 = var7.toString();
                           } catch (Throwable var488) {
                              var10000 = var488;
                              var10001 = false;
                              break label4560;
                           }
                        } else {
                           var8 = "";
                        }

                        com.applovin.impl.sdk.j var23;
                        String var22;
                        String var10;
                        label4525: {
                           com.applovin.impl.sdk.p var11;
                           String var12;
                           label4570: {
                              label4577: {
                                 String var9;
                                 try {
                                    var9 = var6.c();
                                    var10 = var4.aK();
                                    if (!com.applovin.impl.sdk.utils.n.b(var8) && !com.applovin.impl.sdk.utils.n.b(var9)) {
                                       break label4577;
                                    }
                                 } catch (Throwable var487) {
                                    var10000 = var487;
                                    var10001 = false;
                                    break label4560;
                                 }

                                 try {
                                    if (var6.a() == com.applovin.impl.a.e.a.b) {
                                       this.a.b("AdWebView", "Rendering WebView for static VAST ad");
                                       String var29 = this.a((String)this.b.a(com.applovin.impl.sdk.b.d.eG), var8);
                                       this.loadDataWithBaseURL(var3.ax(), var29, "text/html", (String)null, "");
                                       return;
                                    }
                                 } catch (Throwable var482) {
                                    var10000 = var482;
                                    var10001 = false;
                                    break label4560;
                                 }

                                 label4572: {
                                    label4511: {
                                       String var21;
                                       String var19;
                                       String var14;
                                       String var20;
                                       label4573: {
                                          label4574: {
                                             label4508: {
                                                label4507: {
                                                   String var24;
                                                   try {
                                                      if (var6.a() != com.applovin.impl.a.e.a.d) {
                                                         break label4508;
                                                      }

                                                      if (!com.applovin.impl.sdk.utils.n.b(var9)) {
                                                         break label4572;
                                                      }

                                                      var24 = this.a(var10, var9);
                                                      if (!com.applovin.impl.sdk.utils.n.b(var24)) {
                                                         break label4507;
                                                      }
                                                   } catch (Throwable var486) {
                                                      var10000 = var486;
                                                      var10001 = false;
                                                      break label4560;
                                                   }

                                                   var14 = var24;
                                                   break label4574;
                                                }

                                                var14 = var9;
                                                break label4574;
                                             }

                                             try {
                                                if (var6.a() != com.applovin.impl.a.e.a.c) {
                                                   break label4511;
                                                }

                                                if (com.applovin.impl.sdk.utils.n.b(var8)) {
                                                   this.a.b("AdWebView", "Preparing to load iFrame VAST ad resourceUri");
                                                   var22 = var3.ax();
                                                   var23 = this.b;
                                                   break label4525;
                                                }
                                             } catch (Throwable var485) {
                                                var10000 = var485;
                                                var10001 = false;
                                                break label4560;
                                             }

                                             label4482: {
                                                String var13;
                                                label4481: {
                                                   try {
                                                      if (!com.applovin.impl.sdk.utils.n.b(var9)) {
                                                         return;
                                                      }

                                                      var13 = this.a(var10, var9);
                                                      if (com.applovin.impl.sdk.utils.n.b(var13)) {
                                                         break label4481;
                                                      }
                                                   } catch (Throwable var484) {
                                                      var10000 = var484;
                                                      var10001 = false;
                                                      break label4560;
                                                   }

                                                   var14 = var9;
                                                   break label4482;
                                                }

                                                var14 = var13;
                                             }

                                             try {
                                                com.applovin.impl.sdk.p var15 = this.a;
                                                StringBuilder var16 = new StringBuilder();
                                                var16.append("Rendering WebView for iFrame VAST ad with resourceContents: ");
                                                var16.append(var14);
                                                var15.b("AdWebView", var16.toString());
                                                var19 = var3.ax();
                                             } catch (Throwable var479) {
                                                var10000 = var479;
                                                var10001 = false;
                                                break label4560;
                                             }

                                             var20 = "text/html";
                                             var21 = "";
                                             break label4573;
                                          }

                                          try {
                                             com.applovin.impl.sdk.p var25 = this.a;
                                             StringBuilder var26 = new StringBuilder();
                                             var26.append("Rendering WebView for HTML VAST ad with resourceContents: ");
                                             var26.append(var14);
                                             var25.b("AdWebView", var26.toString());
                                             var19 = var3.ax();
                                          } catch (Throwable var480) {
                                             var10000 = var480;
                                             var10001 = false;
                                             break label4560;
                                          }

                                          var20 = "text/html";
                                          var21 = "";
                                       }

                                       try {
                                          this.loadDataWithBaseURL(var19, var14, var20, (String)null, var21);
                                          return;
                                       } catch (Throwable var475) {
                                          var10000 = var475;
                                          var10001 = false;
                                          break label4560;
                                       }
                                    }

                                    try {
                                       var11 = this.a;
                                    } catch (Throwable var481) {
                                       var10000 = var481;
                                       var10001 = false;
                                       break label4560;
                                    }

                                    var12 = "Failed to render VAST companion ad of invalid type";
                                    break label4570;
                                 }

                                 try {
                                    if (!com.applovin.impl.sdk.utils.n.b(var8)) {
                                       return;
                                    }

                                    this.a.b("AdWebView", "Preparing to load HTML VAST ad resourceUri");
                                    var22 = var3.ax();
                                    var23 = this.b;
                                    break label4525;
                                 } catch (Throwable var478) {
                                    var10000 = var478;
                                    var10001 = false;
                                    break label4560;
                                 }
                              }

                              try {
                                 var11 = this.a;
                              } catch (Throwable var483) {
                                 var10000 = var483;
                                 var10001 = false;
                                 break label4560;
                              }

                              var12 = "Unable to load companion ad. No resources provided.";
                           }

                           try {
                              var11.e("AdWebView", var12);
                              return;
                           } catch (Throwable var476) {
                              var10000 = var476;
                              var10001 = false;
                              break label4560;
                           }
                        }

                        try {
                           this.a(var8, var22, var10, var23);
                           return;
                        } catch (Throwable var474) {
                           var10000 = var474;
                           var10001 = false;
                           break label4560;
                        }
                     }

                     try {
                        var30 = this.a;
                     } catch (Throwable var490) {
                        var10000 = var490;
                        var10001 = false;
                        break label4560;
                     }

                     var31 = "No companion ad provided.";
                     break label4559;
                  }

                  var31 = "AppLovinAd rendered";
                  break label4559;
               }

               var31 = "Empty ad rendered";
            }

            label4458:
            try {
               var30.b("AdWebView", var31);
               return;
            } catch (Throwable var477) {
               var10000 = var477;
               var10001 = false;
               break label4458;
            }
         }

         Throwable var2 = var10000;
         this.a.b("AdWebView", "Unable to render AppLovinAd", var2);
      } else {
         com.applovin.impl.sdk.p.j("AdWebView", "Ad can not be loaded in a destroyed webview");
      }
   }

   public void a(String var1) {
      this.a(var1, (Runnable)null);
   }

   public void a(String var1, Runnable var2) {
      try {
         com.applovin.impl.sdk.p var4 = this.a;
         StringBuilder var5 = new StringBuilder();
         var5.append("Forwarding \"");
         var5.append(var1);
         var5.append("\" to ad template");
         var4.b("AdWebView", var5.toString());
         this.loadUrl(var1);
      } catch (Throwable var7) {
         this.a.b("AdWebView", "Unable to forward to template", var7);
         if (var2 != null) {
            var2.run();
         }

         return;
      }
   }

   public boolean a() {
      return this.f;
   }

   AppLovinAd b() {
      return this.d;
   }

   public com.applovin.impl.sdk.c.d c() {
      return this.c;
   }

   public void computeScroll() {
   }

   public void destroy() {
      this.e = true;

      try {
         super.destroy();
         this.a.b("AdWebView", "Web view destroyed");
      } catch (Throwable var4) {
         com.applovin.impl.sdk.p var2 = this.a;
         if (var2 != null) {
            var2.b("AdWebView", "destroy() threw exception", var4);
         }

         return;
      }
   }

   protected void onFocusChanged(boolean var1, int var2, Rect var3) {
      try {
         super.onFocusChanged(var1, var2, var3);
      } catch (Exception var5) {
         this.a.b("AdWebView", "onFocusChanged() threw exception", var5);
      }
   }

   protected void onScrollChanged(int var1, int var2, int var3, int var4) {
   }

   public void onWindowFocusChanged(boolean var1) {
      try {
         super.onWindowFocusChanged(var1);
      } catch (Exception var3) {
         this.a.b("AdWebView", "onWindowFocusChanged() threw exception", var3);
      }
   }

   protected void onWindowVisibilityChanged(int var1) {
      try {
         super.onWindowVisibilityChanged(var1);
      } catch (Exception var3) {
         this.a.b("AdWebView", "onWindowVisibilityChanged() threw exception", var3);
      }
   }

   public boolean requestFocus(int var1, Rect var2) {
      try {
         boolean var4 = super.requestFocus(var1, var2);
         return var4;
      } catch (Exception var5) {
         this.a.b("AdWebView", "requestFocus() threw exception", var5);
         return false;
      }
   }

   public void scrollTo(int var1, int var2) {
   }
}
