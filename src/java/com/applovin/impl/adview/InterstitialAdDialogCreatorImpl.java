package com.applovin.impl.adview;

import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.adview.InterstitialAdDialogCreator;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class InterstitialAdDialogCreatorImpl implements InterstitialAdDialogCreator {
   private static final Object a = new Object();
   private static WeakReference b = new WeakReference((Object)null);
   private static WeakReference c = new WeakReference((Object)null);

   public AppLovinInterstitialAdDialog createInterstitialAdDialog(AppLovinSdk var1, Context var2) {
      if (var1 == null) {
         var1 = AppLovinSdk.getInstance(var2);
      }

      Object var3 = a;
      synchronized(var3){}

      boolean var10001;
      Throwable var10000;
      label428: {
         n var5;
         try {
            var5 = (n)b.get();
         } catch (Throwable var48) {
            var10000 = var48;
            var10001 = false;
            break label428;
         }

         label433: {
            if (var5 != null) {
               label432: {
                  try {
                     if (!var5.isShowing() || c.get() != var2) {
                        break label432;
                     }
                  } catch (Throwable var47) {
                     var10000 = var47;
                     var10001 = false;
                     break label428;
                  }

                  try {
                     var1.getLogger().d("InterstitialAdDialogCreator", "An interstitial dialog is already showing, returning it");
                     break label433;
                  } catch (Throwable var46) {
                     var10000 = var46;
                     var10001 = false;
                     break label428;
                  }
               }
            }

            try {
               var5 = new n(var1, var2);
               b = new WeakReference(var5);
               c = new WeakReference(var2);
            } catch (Throwable var45) {
               var10000 = var45;
               var10001 = false;
               break label428;
            }
         }

         label401:
         try {
            return var5;
         } catch (Throwable var44) {
            var10000 = var44;
            var10001 = false;
            break label401;
         }
      }

      while(true) {
         Throwable var4 = var10000;

         try {
            throw var4;
         } catch (Throwable var43) {
            var10000 = var43;
            var10001 = false;
            continue;
         }
      }
   }
}
