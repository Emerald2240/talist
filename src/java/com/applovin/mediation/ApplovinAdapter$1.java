package com.applovin.mediation;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.LinkedList;
import java.util.Queue;

class ApplovinAdapter$1 implements AppLovinAdLoadListener {
   // $FF: synthetic field
   final ApplovinAdapter this$0;

   ApplovinAdapter$1(ApplovinAdapter var1) {
      this.this$0 = var1;
   }

   public void adReceived(AppLovinAd var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Interstitial did load ad: ");
      var2.append(var1.getAdIdNumber());
      var2.append(" for zone: ");
      var2.append(ApplovinAdapter.access$000(this.this$0));
      ApplovinAdapter.log(3, var2.toString());
      Object var7 = ApplovinAdapter.access$100();
      synchronized(var7){}

      boolean var10001;
      Throwable var10000;
      label176: {
         Object var9;
         try {
            var9 = (Queue)ApplovinAdapter.access$200().get(ApplovinAdapter.access$000(this.this$0));
         } catch (Throwable var32) {
            var10000 = var32;
            var10001 = false;
            break label176;
         }

         if (var9 == null) {
            try {
               var9 = new LinkedList();
               ApplovinAdapter.access$200().put(ApplovinAdapter.access$000(this.this$0), var9);
            } catch (Throwable var31) {
               var10000 = var31;
               var10001 = false;
               break label176;
            }
         }

         label165:
         try {
            ((Queue)var9).offer(var1);
            AppLovinSdkUtils.runOnUiThread(new ApplovinAdapter$1$1(this));
            return;
         } catch (Throwable var30) {
            var10000 = var30;
            var10001 = false;
            break label165;
         }
      }

      while(true) {
         Throwable var8 = var10000;

         try {
            throw var8;
         } catch (Throwable var29) {
            var10000 = var29;
            var10001 = false;
            continue;
         }
      }
   }

   public void failedToReceiveAd(int var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Interstitial failed to load with error: ");
      var2.append(var1);
      ApplovinAdapter.log(6, var2.toString());
      AppLovinSdkUtils.runOnUiThread(new ApplovinAdapter$1$2(this, var1));
   }
}
