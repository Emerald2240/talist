package com.applovin.impl.mediation.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.applovin.impl.mediation.e;
import com.applovin.impl.mediation.l;
import com.applovin.impl.mediation.b.c;
import com.applovin.impl.sdk.b;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.h;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxReward;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class MaxFullscreenAdImpl extends a implements b.a {
   private final <undefinedtype> a;
   private final b b;
   private final com.applovin.impl.mediation.b c;
   private final Object d = new Object();
   private c e = null;
   private c f = null;
   private c g = null;
   private <undefinedtype> h;
   private final AtomicBoolean i;
   private String j;
   protected final <undefinedtype> listenerWrapper;

   public MaxFullscreenAdImpl(String var1, MaxAdFormat var2, Object var3, String var4, j var5) {
      super(var1, var2, var4, var5);
      this.h = null.a;
      this.i = new AtomicBoolean();
      this.j = "";
      this.a = var3;
      this.listenerWrapper = new com.applovin.impl.mediation.j.b((MaxFullscreenAdImpl$1)null) {
         public void a(c var1) {
            if (var1.getFormat() == MaxFullscreenAdImpl.this.adFormat) {
               this.onAdLoaded(var1);
            }

         }

         public void onAdClicked(MaxAd var1) {
            com.applovin.impl.sdk.utils.j.d(MaxFullscreenAdImpl.this.adListener, MaxFullscreenAdImpl.this.d());
         }

         public void onAdDisplayFailed(MaxAd var1, int var2) {
            MaxFullscreenAdImpl.this.a((<undefinedtype>)null.a, (Runnable)(new MaxFullscreenAdImpl$b$4(this, var2)));
         }

         public void onAdDisplayed(MaxAd var1) {
            if (!((c)var1).j()) {
               MaxFullscreenAdImpl.this.b.a();
            }

            com.applovin.impl.sdk.utils.j.b((MaxAdListener)MaxFullscreenAdImpl.this.adListener, (MaxAd)MaxFullscreenAdImpl.this.d());
         }

         public void onAdHidden(MaxAd var1) {
            MaxFullscreenAdImpl.this.c.a(var1);
            MaxFullscreenAdImpl.this.a((<undefinedtype>)null.a, (Runnable)(new MaxFullscreenAdImpl$b$3(this)));
         }

         public void onAdLoadFailed(String var1, int var2) {
            MaxFullscreenAdImpl.this.c();
            if (MaxFullscreenAdImpl.this.g == null) {
               MaxFullscreenAdImpl.this.a((<undefinedtype>)null.a, (Runnable)(new MaxFullscreenAdImpl$b$2(this, var1, var2)));
            }
         }

         public void onAdLoaded(MaxAd var1) {
            c var2 = (c)var1;
            MaxFullscreenAdImpl.this.a(var2);
            if (!var2.j() && MaxFullscreenAdImpl.this.i.compareAndSet(true, false)) {
               MaxFullscreenAdImpl.this.loadRequestBuilder.a("expired_ad_ad_unit_id");
            } else {
               MaxFullscreenAdImpl.this.a((<undefinedtype>)null.c, (Runnable)(new MaxFullscreenAdImpl$b$1(this)));
            }
         }

         public void onRewardedVideoCompleted(MaxAd var1) {
            com.applovin.impl.sdk.utils.j.f(MaxFullscreenAdImpl.this.adListener, MaxFullscreenAdImpl.this.d());
         }

         public void onRewardedVideoStarted(MaxAd var1) {
            com.applovin.impl.sdk.utils.j.e(MaxFullscreenAdImpl.this.adListener, MaxFullscreenAdImpl.this.d());
         }

         public void onUserRewarded(MaxAd var1, MaxReward var2) {
            com.applovin.impl.sdk.utils.j.a((MaxAdListener)MaxFullscreenAdImpl.this.adListener, (MaxAd)MaxFullscreenAdImpl.this.d(), (MaxReward)var2);
         }
      };
      this.b = new b(var5, this);
      this.c = new com.applovin.impl.mediation.b(var5, this.listenerWrapper);
      StringBuilder var6 = new StringBuilder();
      var6.append("Created new ");
      var6.append(var4);
      var6.append(" (");
      var6.append(this);
      var6.append(")");
      p.g(var4, var6.toString());
   }

   private c a() {
      Object var1 = this.d;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label195: {
         c var3;
         label189: {
            try {
               if (this.f != null) {
                  var3 = this.f;
                  break label189;
               }
            } catch (Throwable var24) {
               var10000 = var24;
               var10001 = false;
               break label195;
            }

            try {
               var3 = this.g;
            } catch (Throwable var23) {
               var10000 = var23;
               var10001 = false;
               break label195;
            }
         }

         label180:
         try {
            return var3;
         } catch (Throwable var22) {
            var10000 = var22;
            var10001 = false;
            break label180;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var21) {
            var10000 = var21;
            var10001 = false;
            continue;
         }
      }
   }

   // $FF: synthetic method
   static Object a(MaxFullscreenAdImpl var0) {
      return var0.d;
   }

   private void a(Object var1, Runnable var2) {
      <undefinedtype> var3 = this.h;
      Object var4 = this.d;
      synchronized(var4){}

      boolean var19;
      label8509: {
         boolean var10001;
         Throwable var10000;
         label8510: {
            label8511: {
               p var13;
               String var14;
               String var18;
               label8512: {
                  label8501: {
                     label8500: {
                        label8513: {
                           String var36;
                           String var35;
                           label8514: {
                              label8515: {
                                 try {
                                    p var6 = this.logger;
                                    String var7 = this.tag;
                                    StringBuilder var8 = new StringBuilder();
                                    var8.append("Attempting state transition from ");
                                    var8.append(var3);
                                    var8.append(" to ");
                                    var8.append(var1);
                                    var6.b(var7, var8.toString());
                                    if (var3 == null.a) {
                                       if (var1 == null.b) {
                                          break label8500;
                                       }
                                       break label8515;
                                    }
                                 } catch (Throwable var979) {
                                    var10000 = var979;
                                    var10001 = false;
                                    break label8510;
                                 }

                                 label8516: {
                                    try {
                                       if (var3 != null.b) {
                                          break label8516;
                                       }

                                       if (var1 == null.a) {
                                          break label8500;
                                       }
                                    } catch (Throwable var978) {
                                       var10000 = var978;
                                       var10001 = false;
                                       break label8510;
                                    }

                                    label8438: {
                                       try {
                                          if (var1 != null.b) {
                                             break label8438;
                                          }

                                          var35 = this.tag;
                                       } catch (Throwable var971) {
                                          var10000 = var971;
                                          var10001 = false;
                                          break label8510;
                                       }

                                       var36 = "An ad is already loading";
                                       break label8514;
                                    }

                                    try {
                                       if (var1 == null.c) {
                                          break label8500;
                                       }
                                    } catch (Throwable var967) {
                                       var10000 = var967;
                                       var10001 = false;
                                       break label8510;
                                    }

                                    label8430: {
                                       try {
                                          if (var1 != null.d) {
                                             break label8430;
                                          }

                                          var35 = this.tag;
                                       } catch (Throwable var970) {
                                          var10000 = var970;
                                          var10001 = false;
                                          break label8510;
                                       }

                                       var36 = "An ad is not ready to be shown yet";
                                       break label8514;
                                    }

                                    try {
                                       if (var1 == null.e) {
                                          break label8500;
                                       }
                                    } catch (Throwable var963) {
                                       var10000 = var963;
                                       var10001 = false;
                                       break label8510;
                                    }

                                    try {
                                       var13 = this.logger;
                                       var14 = this.tag;
                                       StringBuilder var43 = new StringBuilder();
                                       var43.append("Unable to transition to: ");
                                       var43.append(var1);
                                       var18 = var43.toString();
                                       break label8512;
                                    } catch (Throwable var958) {
                                       var10000 = var958;
                                       var10001 = false;
                                       break label8510;
                                    }
                                 }

                                 label8517: {
                                    try {
                                       if (var3 != null.c) {
                                          break label8517;
                                       }

                                       if (var1 == null.a) {
                                          break label8500;
                                       }
                                    } catch (Throwable var977) {
                                       var10000 = var977;
                                       var10001 = false;
                                       break label8510;
                                    }

                                    label8518: {
                                       try {
                                          if (var1 == null.b) {
                                             var35 = this.tag;
                                             break label8518;
                                          }
                                       } catch (Throwable var972) {
                                          var10000 = var972;
                                          var10001 = false;
                                          break label8510;
                                       }

                                       label8519: {
                                          try {
                                             if (var1 == null.c) {
                                                var13 = this.logger;
                                                var14 = this.tag;
                                                break label8519;
                                             }
                                          } catch (Throwable var968) {
                                             var10000 = var968;
                                             var10001 = false;
                                             break label8510;
                                          }

                                          try {
                                             if (var1 == null.d) {
                                                break label8500;
                                             }
                                          } catch (Throwable var965) {
                                             var10000 = var965;
                                             var10001 = false;
                                             break label8510;
                                          }

                                          try {
                                             if (var1 == null.e) {
                                                break label8500;
                                             }
                                          } catch (Throwable var964) {
                                             var10000 = var964;
                                             var10001 = false;
                                             break label8510;
                                          }

                                          try {
                                             var13 = this.logger;
                                             var14 = this.tag;
                                             StringBuilder var40 = new StringBuilder();
                                             var40.append("Unable to transition to: ");
                                             var40.append(var1);
                                             var18 = var40.toString();
                                             break label8512;
                                          } catch (Throwable var957) {
                                             var10000 = var957;
                                             var10001 = false;
                                             break label8510;
                                          }
                                       }

                                       var18 = "An ad is already marked as ready";
                                       break label8512;
                                    }

                                    var36 = "An ad is already loaded";
                                    break label8514;
                                 }

                                 label8520: {
                                    try {
                                       if (var3 != null.d) {
                                          break label8520;
                                       }

                                       if (var1 == null.a) {
                                          break label8500;
                                       }
                                    } catch (Throwable var976) {
                                       var10000 = var976;
                                       var10001 = false;
                                       break label8510;
                                    }

                                    label8462: {
                                       try {
                                          if (var1 != null.b) {
                                             break label8462;
                                          }

                                          var35 = this.tag;
                                       } catch (Throwable var974) {
                                          var10000 = var974;
                                          var10001 = false;
                                          break label8510;
                                       }

                                       var36 = "Can not load another ad while the ad is showing";
                                       break label8514;
                                    }

                                    try {
                                       if (var1 == null.c) {
                                          var13 = this.logger;
                                          var14 = this.tag;
                                          break label8513;
                                       }
                                    } catch (Throwable var969) {
                                       var10000 = var969;
                                       var10001 = false;
                                       break label8510;
                                    }

                                    label8454: {
                                       try {
                                          if (var1 == null.d) {
                                             var35 = this.tag;
                                             break label8454;
                                          }
                                       } catch (Throwable var973) {
                                          var10000 = var973;
                                          var10001 = false;
                                          break label8510;
                                       }

                                       try {
                                          if (var1 != null.e) {
                                             break label8501;
                                          }
                                          break label8500;
                                       } catch (Throwable var962) {
                                          var10000 = var962;
                                          var10001 = false;
                                          break label8510;
                                       }
                                    }

                                    var36 = "The ad is already showing, not showing another one";
                                    break label8514;
                                 }

                                 label8469: {
                                    try {
                                       if (var3 != null.e) {
                                          break label8469;
                                       }

                                       var35 = this.tag;
                                    } catch (Throwable var975) {
                                       var10000 = var975;
                                       var10001 = false;
                                       break label8510;
                                    }

                                    var36 = "No operations are allowed on a destroyed instance";
                                    break label8514;
                                 }

                                 try {
                                    var13 = this.logger;
                                    var14 = this.tag;
                                    StringBuilder var15 = new StringBuilder();
                                    var15.append("Unknown state: ");
                                    var15.append(this.h);
                                    var18 = var15.toString();
                                    break label8512;
                                 } catch (Throwable var955) {
                                    var10000 = var955;
                                    var10001 = false;
                                    break label8510;
                                 }
                              }

                              try {
                                 if (var1 == null.e) {
                                    break label8500;
                                 }
                              } catch (Throwable var966) {
                                 var10000 = var966;
                                 var10001 = false;
                                 break label8510;
                              }

                              label8389: {
                                 try {
                                    if (var1 == null.d) {
                                       var35 = this.tag;
                                       break label8389;
                                    }
                                 } catch (Throwable var961) {
                                    var10000 = var961;
                                    var10001 = false;
                                    break label8510;
                                 }

                                 try {
                                    var13 = this.logger;
                                    var14 = this.tag;
                                    StringBuilder var46 = new StringBuilder();
                                    var46.append("Unable to transition to: ");
                                    var46.append(var1);
                                    var18 = var46.toString();
                                    break label8512;
                                 } catch (Throwable var959) {
                                    var10000 = var959;
                                    var10001 = false;
                                    break label8510;
                                 }
                              }

                              var36 = "No ad is loading or loaded";
                           }

                           try {
                              p.j(var35, var36);
                           } catch (Throwable var960) {
                              var10000 = var960;
                              var10001 = false;
                              break label8510;
                           }

                           var19 = false;
                           break label8511;
                        }

                        var18 = "An ad is already showing, ignoring";
                        break label8512;
                     }

                     var19 = true;
                     break label8511;
                  }

                  try {
                     var13 = this.logger;
                     var14 = this.tag;
                     StringBuilder var37 = new StringBuilder();
                     var37.append("Unable to transition to: ");
                     var37.append(var1);
                     var18 = var37.toString();
                  } catch (Throwable var956) {
                     var10000 = var956;
                     var10001 = false;
                     break label8510;
                  }
               }

               try {
                  var13.e(var14, var18);
               } catch (Throwable var954) {
                  var10000 = var954;
                  var10001 = false;
                  break label8510;
               }

               var19 = false;
            }

            if (var19) {
               try {
                  p var20 = this.logger;
                  String var21 = this.tag;
                  StringBuilder var22 = new StringBuilder();
                  var22.append("Transitioning from ");
                  var22.append(this.h);
                  var22.append(" to ");
                  var22.append(var1);
                  var22.append("...");
                  var20.b(var21, var22.toString());
                  this.h = var1;
               } catch (Throwable var953) {
                  var10000 = var953;
                  var10001 = false;
                  break label8510;
               }
            } else {
               try {
                  p var28 = this.logger;
                  String var29 = this.tag;
                  StringBuilder var30 = new StringBuilder();
                  var30.append("Not allowed transition from ");
                  var30.append(this.h);
                  var30.append(" to ");
                  var30.append(var1);
                  var28.d(var29, var30.toString());
               } catch (Throwable var952) {
                  var10000 = var952;
                  var10001 = false;
                  break label8510;
               }
            }

            label8361:
            try {
               break label8509;
            } catch (Throwable var951) {
               var10000 = var951;
               var10001 = false;
               break label8361;
            }
         }

         while(true) {
            Throwable var5 = var10000;

            try {
               throw var5;
            } catch (Throwable var950) {
               var10000 = var950;
               var10001 = false;
               continue;
            }
         }
      }

      if (var19 && var2 != null) {
         var2.run();
      }

   }

   // $FF: synthetic method
   static void a(MaxFullscreenAdImpl var0, String var1, Activity var2) {
      var0.a(var1, var2);
   }

   private void a(c var1) {
      this.j = var1.getNetworkName();
      if (var1.j()) {
         this.g = var1;
         p var7 = this.logger;
         String var8 = this.tag;
         StringBuilder var9 = new StringBuilder();
         var9.append("Handle ad loaded for fallback ad: ");
         var9.append(var1);
         var7.b(var8, var9.toString());
      } else {
         this.f = var1;
         p var2 = this.logger;
         String var3 = this.tag;
         StringBuilder var4 = new StringBuilder();
         var4.append("Handle ad loaded for regular ad: ");
         var4.append(var1);
         var2.b(var3, var4.toString());
         this.b(var1);
      }
   }

   private void a(c var1, Context var2, Runnable var3) {
      if (var1 != null && var1.w() && !com.applovin.impl.sdk.utils.h.a(var2) && var2 instanceof Activity) {
         AlertDialog var4 = (new Builder(var2)).setTitle(var1.x()).setMessage(var1.y()).setPositiveButton(var1.z(), (OnClickListener)null).create();
         var4.setOnDismissListener(new MaxFullscreenAdImpl$4(this, var3));
         var4.show();
      } else {
         var3.run();
      }
   }

   private void a(String var1, Activity var2) {
      Object var3 = this.d;
      synchronized(var3){}

      boolean var10001;
      Throwable var10000;
      label215: {
         label210: {
            try {
               this.e = this.a();
               this.sdk.B().b((com.applovin.impl.mediation.j.b)this.listenerWrapper);
               if (!this.e.j()) {
                  break label210;
               }

               if (this.e.h().get()) {
                  p var13 = this.logger;
                  String var14 = this.tag;
                  StringBuilder var15 = new StringBuilder();
                  var15.append("Failed to display ad: ");
                  var15.append(this.e);
                  var15.append(" - displayed already");
                  var13.e(var14, var15.toString());
                  this.sdk.y().maybeScheduleAdDisplayErrorPostback(new e(-5201, "Ad displayed already"), this.e);
                  com.applovin.impl.sdk.utils.j.a((MaxAdListener)this.adListener, (MaxAd)this.d(), -5201);
                  return;
               }
            } catch (Throwable var39) {
               var10000 = var39;
               var10001 = false;
               break label215;
            }

            try {
               this.sdk.B().a(this.listenerWrapper, this.adFormat);
            } catch (Throwable var38) {
               var10000 = var38;
               var10001 = false;
               break label215;
            }
         }

         try {
            this.e.a(this.adUnitId);
         } catch (Throwable var37) {
            var10000 = var37;
            var10001 = false;
            break label215;
         }

         this.c.b(this.e);
         p var5 = this.logger;
         String var6 = this.tag;
         StringBuilder var7 = new StringBuilder();
         var7.append("Showing ad for '");
         var7.append(this.adUnitId);
         var7.append("'; loaded ad: ");
         var7.append(this.e);
         var7.append("...");
         var5.b(var6, var7.toString());
         this.sdk.y().showFullscreenAd(this.e, var1, var2);
         return;
      }

      while(true) {
         Throwable var4 = var10000;

         try {
            throw var4;
         } catch (Throwable var36) {
            var10000 = var36;
            var10001 = false;
            continue;
         }
      }
   }

   // $FF: synthetic method
   static c b(MaxFullscreenAdImpl var0) {
      return var0.f;
   }

   private void b() {
      Object var1 = this.d;
      synchronized(var1){}

      c var3;
      label219: {
         boolean var10001;
         Throwable var10000;
         label220: {
            label212: {
               try {
                  var3 = this.e;
                  this.e = null;
                  if (var3 == this.g) {
                     this.g = null;
                     break label212;
                  }
               } catch (Throwable var24) {
                  var10000 = var24;
                  var10001 = false;
                  break label220;
               }

               try {
                  if (var3 == this.f) {
                     this.f = null;
                  }
               } catch (Throwable var23) {
                  var10000 = var23;
                  var10001 = false;
                  break label220;
               }
            }

            label203:
            try {
               break label219;
            } catch (Throwable var22) {
               var10000 = var22;
               var10001 = false;
               break label203;
            }
         }

         while(true) {
            Throwable var2 = var10000;

            try {
               throw var2;
            } catch (Throwable var21) {
               var10000 = var21;
               var10001 = false;
               continue;
            }
         }
      }

      this.sdk.y().destroyAd(var3);
   }

   private void b(c var1) {
      long var2 = var1.n();
      if (var2 >= 0L) {
         p var4 = this.logger;
         String var5 = this.tag;
         StringBuilder var6 = new StringBuilder();
         var6.append("Scheduling ad expiration ");
         var6.append(TimeUnit.MILLISECONDS.toMinutes(var2));
         var6.append(" minutes from now for ");
         var6.append(this.getAdUnitId());
         var6.append(" ...");
         var4.b(var5, var6.toString());
         this.b.a(var2);
      }

   }

   // $FF: synthetic method
   static c c(MaxFullscreenAdImpl var0) {
      return var0.a();
   }

   private void c() {
      // $FF: Couldn't be decompiled
   }

   private l d() {
      return new l(this.adUnitId, this.adFormat, this.j);
   }

   // $FF: synthetic method
   static void j(MaxFullscreenAdImpl var0) {
      var0.b();
   }

   public void destroy() {
      this.a((<undefinedtype>)null.e, (Runnable)(new MaxFullscreenAdImpl$1(this)));
   }

   public boolean isReady() {
      Object var1 = this.d;
      synchronized(var1){}

      boolean var10001;
      Throwable var10000;
      label161: {
         boolean var3;
         label160: {
            label159: {
               try {
                  if (this.a() == null || !this.a().a() || this.h != null.c) {
                     break label159;
                  }
               } catch (Throwable var16) {
                  var10000 = var16;
                  var10001 = false;
                  break label161;
               }

               var3 = true;
               break label160;
            }

            var3 = false;
         }

         label149:
         try {
            return var3;
         } catch (Throwable var15) {
            var10000 = var15;
            var10001 = false;
            break label149;
         }
      }

      while(true) {
         Throwable var2 = var10000;

         try {
            throw var2;
         } catch (Throwable var14) {
            var10000 = var14;
            var10001 = false;
            continue;
         }
      }
   }

   public void loadAd(Activity var1) {
      p var2 = this.logger;
      String var3 = this.tag;
      StringBuilder var4 = new StringBuilder();
      var4.append("Loading ad for '");
      var4.append(this.adUnitId);
      var4.append("'...");
      var2.b(var3, var4.toString());
      if (this.isReady()) {
         p var8 = this.logger;
         String var9 = this.tag;
         StringBuilder var10 = new StringBuilder();
         var10.append("An ad is already loaded for '");
         var10.append(this.adUnitId);
         var10.append("'");
         var8.b(var9, var10.toString());
         com.applovin.impl.sdk.utils.j.a((MaxAdListener)this.adListener, (MaxAd)this.d());
      } else {
         this.a((<undefinedtype>)null.b, (Runnable)(new MaxFullscreenAdImpl$2(this, var1)));
      }
   }

   public void onAdExpired() {
      p var1 = this.logger;
      String var2 = this.tag;
      StringBuilder var3 = new StringBuilder();
      var3.append("Ad expired ");
      var3.append(this.getAdUnitId());
      var1.b(var2, var3.toString());
      Activity var6 = this.a.getActivity();
      if (var6 == null) {
         var6 = this.sdk.aa().a();
         if (!(Boolean)this.sdk.a(com.applovin.impl.sdk.b.c.J) || var6 == null) {
            this.listenerWrapper.onAdLoadFailed(this.adUnitId, -5601);
            return;
         }
      }

      this.i.set(true);
      this.loadRequestBuilder.a("expired_ad_ad_unit_id", this.getAdUnitId());
      this.sdk.y().loadAd(this.adUnitId, this.adFormat, this.loadRequestBuilder.a(), false, var6, this.listenerWrapper);
   }

   public void showAd(String var1, Activity var2) {
      Activity var3;
      if (var2 != null) {
         var3 = var2;
      } else {
         var3 = this.sdk.ag();
      }

      if (var3 == null) {
         throw new IllegalArgumentException("Attempting to show ad without a valid activity.");
      } else if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.c.F) && (this.sdk.Z().a() || this.sdk.Z().b())) {
         p.j(this.tag, "Attempting to show ad when another fullscreen ad is already showing");
         com.applovin.impl.sdk.utils.j.a((MaxAdListener)this.adListener, (MaxAd)this.a(), -23);
      } else if ((Boolean)this.sdk.a(com.applovin.impl.sdk.b.c.G) && !com.applovin.impl.sdk.utils.h.a((Context)var3)) {
         p.j(this.tag, "Attempting to show ad with no internet connection");
         com.applovin.impl.sdk.utils.j.a((MaxAdListener)this.adListener, (MaxAd)this.d(), -5201);
      } else {
         this.a((c)this.a(), (Context)var2, (Runnable)(new MaxFullscreenAdImpl$3(this, var1, var3)));
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.tag);
      var1.append("{adUnitId='");
      var1.append(this.adUnitId);
      var1.append('\'');
      var1.append(", adListener=");
      var1.append(this.adListener);
      var1.append(", isReady=");
      var1.append(this.isReady());
      var1.append('}');
      return var1.toString();
   }
}
