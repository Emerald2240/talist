package com.applovin.impl.adview;

import android.app.Activity;
import android.graphics.PointF;
import android.net.Uri;
import android.view.View;
import com.applovin.adview.AppLovinAdView;

class AdViewControllerImpl$2 implements Runnable {
   // $FF: synthetic field
   final PointF a;
   // $FF: synthetic field
   final AdViewControllerImpl b;

   AdViewControllerImpl$2(AdViewControllerImpl var1, PointF var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      if (AdViewControllerImpl.a(this.b) == null) {
         if (AdViewControllerImpl.d(this.b) instanceof com.applovin.impl.sdk.ad.a) {
            if (AdViewControllerImpl.e(this.b) != null) {
               com.applovin.impl.sdk.ad.a var1 = (com.applovin.impl.sdk.ad.a)AdViewControllerImpl.d(this.b);
               Activity var2;
               if (AdViewControllerImpl.f(this.b) instanceof Activity) {
                  var2 = (Activity)AdViewControllerImpl.f(this.b);
               } else {
                  var2 = com.applovin.impl.sdk.utils.q.a((View)AdViewControllerImpl.e(this.b), (com.applovin.impl.sdk.j)AdViewControllerImpl.g(this.b));
               }

               if (var2 != null) {
                  if (AdViewControllerImpl.h(this.b) != null) {
                     AdViewControllerImpl.h(this.b).removeView(AdViewControllerImpl.e(this.b));
                  }

                  AdViewControllerImpl var4 = this.b;
                  AdViewControllerImpl.b(var4, new k(var1, AdViewControllerImpl.e(var4), var2, AdViewControllerImpl.g(this.b)));
                  AdViewControllerImpl.a(this.b).setOnDismissListener(new AdViewControllerImpl$2$1(this));
                  AdViewControllerImpl.a(this.b).show();
                  com.applovin.impl.sdk.utils.j.a(AdViewControllerImpl.i(this.b), AdViewControllerImpl.d(this.b), (AppLovinAdView)AdViewControllerImpl.h(this.b));
                  if (AdViewControllerImpl.j(this.b) != null) {
                     AdViewControllerImpl.j(this.b).d();
                     return;
                  }
               } else {
                  com.applovin.impl.sdk.p.j("AppLovinAdView", "Unable to expand ad. No Activity found.");
                  Uri var3 = var1.f();
                  if (var3 != null && (Boolean)AdViewControllerImpl.g(this.b).a(com.applovin.impl.sdk.b.d.cw)) {
                     AdViewControllerImpl.k(this.b).trackAndLaunchClick(var1, this.b.getParentView(), this.b, var3, this.a);
                     if (AdViewControllerImpl.j(this.b) != null) {
                        AdViewControllerImpl.j(this.b).b();
                     }
                  }

                  AdViewControllerImpl.e(this.b).a("javascript:al_onFailedExpand();");
               }

            }
         }
      }
   }
}
