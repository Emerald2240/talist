package com.noqoush.adfalcon.android.sdk.video.reward;

import android.content.Context;
import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;
import com.noqoush.adfalcon.android.sdk.util.a;
import com.noqoush.adfalcon.android.sdk.video.vast.manager.b;
import com.noqoush.adfalcon.android.sdk.video.vast.manager.c;
import com.noqoush.adfalcon.android.sdk.video.vast.manager.d;
import com.noqoush.adfalcon.android.sdk.video.vast.manager.e;
import com.noqoush.adfalcon.android.sdk.video.vast.model.p;
import com.noqoush.adfalcon.android.sdk.video.vast.model.q;
import com.noqoush.adfalcon.android.sdk.video.vast.model.r;
import com.noqoush.adfalcon.android.sdk.video.vast.player.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Vector;

public class ADFRewardedVideoAd extends e {
   private ADFRewardedVideoAdListener e;
   private String f = null;
   private q g;
   private boolean h = false;
   private boolean i = false;

   public ADFRewardedVideoAd(Context var1) {
      super(var1);
      com.noqoush.adfalcon.android.sdk.video.vast.manager.c.a(this.getContext());
   }

   private q a() {
      return this.g;
   }

   private void a(q var1) {
      this.g = var1;
   }

   public void didLoadAd(d var1, p var2) {
      super.didLoadAd(var1, var2);
      com.noqoush.adfalcon.android.sdk.util.a.a("Reward->didLoadAd");
      this.f = null;

      Exception var10000;
      label69: {
         Vector var5;
         boolean var10001;
         Queue var4;
         try {
            var4 = r.a(this.getContext(), var2);
            var5 = new Vector(var4);
            if (var5.size() == 0) {
               this.onRewardedVideoAdFailedToLoad(ADFErrorCode.NO_AVAILABLE_AD, "No available Ad");
               return;
            }
         } catch (Exception var13) {
            var10000 = var13;
            var10001 = false;
            break label69;
         }

         Iterator var6;
         try {
            var6 = var5.iterator();
         } catch (Exception var11) {
            var10000 = var11;
            var10001 = false;
            break label69;
         }

         while(true) {
            try {
               if (!var6.hasNext()) {
                  break;
               }

               r var8 = (r)var6.next();
               if (var8.q() != null && this.a() == null) {
                  this.a(var8.q());
               }
            } catch (Exception var12) {
               var10000 = var12;
               var10001 = false;
               break label69;
            }
         }

         while(true) {
            String var7;
            try {
               if (var4.peek() == null) {
                  return;
               }

               var7 = ((r)var4.poll()).o().a(this.getContext()).k();
               if (this.f == null) {
                  this.f = var7;
               }
            } catch (Exception var10) {
               var10000 = var10;
               var10001 = false;
               break;
            }

            try {
               com.noqoush.adfalcon.android.sdk.video.vast.manager.c.a(this.getContext(), var7, new b() {
                  public void a(String var1) {
                     if (ADFRewardedVideoAd.this.f.equalsIgnoreCase(var1) && !ADFRewardedVideoAd.this.i) {
                        ADFRewardedVideoAd.this.onRewardedVideoAdLoaded();
                        ADFRewardedVideoAd.this.i = true;
                     }

                  }

                  public void b(String var1) {
                     if (ADFRewardedVideoAd.this.f.equalsIgnoreCase(var1)) {
                        ADFRewardedVideoAd.this.onRewardedVideoAdFailedToLoad(ADFErrorCode.COMMUNICATION_ERROR, "Failed to download the media of the rewarded ad");
                     }

                  }
               });
            } catch (Exception var9) {
               var10000 = var9;
               var10001 = false;
               break;
            }
         }
      }

      Exception var3 = var10000;
      this.onRewardedVideoAdFailedToLoad(ADFErrorCode.GENERIC_SDK_ERROR, var3.getMessage());
      var3.printStackTrace();
   }

   public void failedToLoadAd(d var1, ADFErrorCode var2, String var3, ArrayList var4) {
      StringBuilder var5 = new StringBuilder();
      var5.append("Reward->failedToLoadAd: ");
      var5.append(var3);
      com.noqoush.adfalcon.android.sdk.util.a.a(var5.toString());
      super.failedToLoadAd(var1, var2, var3, var4);
      this.onRewardedVideoAdFailedToLoad(var2, var3);
   }

   public ADFRewardedVideoAdListener getListener() {
      return this.e;
   }

   public void onApplicationLeft(h var1) {
      com.noqoush.adfalcon.android.sdk.util.a.a("Reward->onApplicationLeft");
      this.onRewardedVideoAdLeftApplication();
   }

   public void onCompanionAdClicked(com.noqoush.adfalcon.android.sdk.video.vast.model.b var1, h var2) {
      com.noqoush.adfalcon.android.sdk.util.a.a("Reward->onCompanionAdClicked");
      this.onRewarded();
   }

   public void onComplete(h var1) {
      com.noqoush.adfalcon.android.sdk.util.a.a("Reward->onComplete");
      this.onRewarded();
      this.onRewardedVideoEnded();
   }

   public void onDismissed(h var1) {
      com.noqoush.adfalcon.android.sdk.util.a.a("Reward->onDismissed");
      this.onRewardedVideoAdClosed();
   }

   public void onFailedToPlayAd(h var1) {
      com.noqoush.adfalcon.android.sdk.util.a.a("Reward->onFailedToPlayAd");
      this.onRewarded();
   }

   public void onFailedToPresent(d var1, ADFErrorCode var2, String var3) {
      StringBuilder var4 = new StringBuilder();
      var4.append("Reward->onFailedToPresent: ");
      var4.append(var3);
      com.noqoush.adfalcon.android.sdk.util.a.a(var4.toString());
      this.onRewardedVideoAdFailedToOpen(var2, var3);
   }

   public void onFirstQurtile(h var1) {
      com.noqoush.adfalcon.android.sdk.util.a.a("Reward->onFirstQuartile");
   }

   public void onMidpoint(h var1) {
      com.noqoush.adfalcon.android.sdk.util.a.a("Reward->onMidpoint");
   }

   public void onPresented(h var1) {
      com.noqoush.adfalcon.android.sdk.util.a.a("Reward->onPresented");
      this.onRewardedVideoAdOpened();
   }

   public void onRewarded() {
      try {
         if (this.getListener() != null && !this.h) {
            com.noqoush.adfalcon.android.sdk.util.a.a("Reward->fireonRewarded");
            this.h = true;
            if (this.a() != null) {
               this.getListener().onRewarded(this.a().d(), this.a().c());
               return;
            }

            this.getListener().onRewarded("", -1);
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public void onRewardedVideoAdClosed() {
      try {
         if (this.getListener() != null) {
            com.noqoush.adfalcon.android.sdk.util.a.a("Reward->fireonRewardedVideoAdClosed");
            this.getListener().onRewardedVideoAdClosed();
         }

         com.noqoush.adfalcon.android.sdk.video.vast.manager.c.a(this.getContext());
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   public void onRewardedVideoAdFailedToLoad(ADFErrorCode var1, String var2) {
      try {
         if (this.getListener() != null) {
            com.noqoush.adfalcon.android.sdk.util.a.a("Reward->fireonRewardedVideoAdFailedToLoad");
            this.getListener().onRewardedVideoAdFailedToLoad(var1, var2);
            return;
         }
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }

   }

   public void onRewardedVideoAdFailedToOpen(ADFErrorCode var1, String var2) {
      try {
         if (this.getListener() != null) {
            com.noqoush.adfalcon.android.sdk.util.a.a("Reward->fireonRewardedVideoAdFailedToOpen");
            this.getListener().onRewardedVideoAdFailedToOpen(var1, var2);
            return;
         }
      } catch (Exception var4) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var4);
      }

   }

   public void onRewardedVideoAdLeftApplication() {
      try {
         if (this.getListener() != null) {
            com.noqoush.adfalcon.android.sdk.util.a.a("Reward->fireonRewardedVideoAdLeftApplication");
            this.getListener().onRewardedVideoAdLeftApplication();
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public void onRewardedVideoAdLoaded() {
      try {
         if (this.getListener() != null) {
            com.noqoush.adfalcon.android.sdk.util.a.a("Reward->fireonRewardedVideoAdLoaded");
            this.getListener().onRewardedVideoAdLoaded(this);
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public void onRewardedVideoAdOpened() {
      try {
         if (this.getListener() != null) {
            com.noqoush.adfalcon.android.sdk.util.a.a("Reward->fireonRewardedVideoAdOpened");
            this.getListener().onRewardedVideoAdOpened();
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public void onRewardedVideoEnded() {
      try {
         if (this.getListener() != null) {
            com.noqoush.adfalcon.android.sdk.util.a.a("Reward->fireonRewardedVideoEnded");
            this.getListener().onRewardedVideoEnded();
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public void onRewardedVideoStarted() {
      try {
         if (this.getListener() != null) {
            com.noqoush.adfalcon.android.sdk.util.a.a("Reward->fireonRewardedVideoStarted");
            this.getListener().onRewardedVideoStarted();
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public void onStart(h var1) {
      com.noqoush.adfalcon.android.sdk.util.a.a("Reward->onStart");
      this.onRewardedVideoStarted();
   }

   public void onThirdQurtile(h var1) {
      com.noqoush.adfalcon.android.sdk.util.a.a("Reward->onThirdQurtile");
      this.onRewarded();
   }

   public void setListener(ADFRewardedVideoAdListener var1) {
      this.e = var1;
   }

   public void willLoadAd(d var1) {
   }
}
