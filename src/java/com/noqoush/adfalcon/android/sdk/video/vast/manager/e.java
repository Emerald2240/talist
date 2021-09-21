package com.noqoush.adfalcon.android.sdk.video.vast.manager;

import android.accounts.NetworkErrorException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.noqoush.adfalcon.android.sdk.ADFActivity;
import com.noqoush.adfalcon.android.sdk.ADFTargetingParams;
import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;
import com.noqoush.adfalcon.android.sdk.video.vast.model.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public abstract class e implements f {
   private d a;
   private com.noqoush.adfalcon.android.sdk.video.vast.player.h b;
   private p c;
   private Context d;

   public e(Context var1) {
      this.setContext(var1);
   }

   private void a() {
      if (this.getVastConnManager() != null) {
         this.getVastConnManager().c();
      }

      this.setVastConnManager((d)null);
      this.setVastResponse((p)null);
      this.setVastPlayer((com.noqoush.adfalcon.android.sdk.video.vast.player.h)null);
   }

   public void didLoadAd(d var1, p var2) {
      this.setVastResponse(var2);
   }

   public void didWrapAd(d var1) {
   }

   public void failedToLoadAd(d var1, ADFErrorCode var2, String var3, ArrayList var4) {
      if (var4 != null) {
         try {
            (new com.noqoush.adfalcon.android.sdk.helper.c(this.getContext(), new Vector(var4))).a((com.noqoush.adfalcon.android.sdk.response.b)null, (String)null);
            return;
         } catch (Exception var6) {
            com.noqoush.adfalcon.android.sdk.util.a.a(var6);
         }
      }

   }

   public Context getContext() {
      return this.d;
   }

   public d getVastConnManager() {
      return this.a;
   }

   public com.noqoush.adfalcon.android.sdk.video.vast.player.h getVastPlayer() {
      return this.b;
   }

   public p getVastResponse() {
      return this.c;
   }

   public boolean isReady() {
      return this.getVastResponse() != null;
   }

   public void onDestroy(Context var1) {
      this.a();
   }

   public void onPause(Context var1) {
      this.a();
   }

   public void onResume(Context var1) {
   }

   public void requestAd(String var1, ADFTargetingParams var2) {
      Object var3;
      try {
         if (this.getVastConnManager() != null && this.getVastConnManager().f()) {
            com.noqoush.adfalcon.android.sdk.util.a.e("Ad is already loading");
            return;
         }

         this.setVastConnManager(new d(this.getContext(), this));
         if (Looper.myLooper() != Looper.getMainLooper()) {
            this.failedToLoadAd(this.getVastConnManager(), ADFErrorCode.GENERIC_SDK_ERROR, "Rewarded Video Ad should be requested from UI thread", (ArrayList)null);
            return;
         }

         com.noqoush.adfalcon.android.sdk.g var5 = com.noqoush.adfalcon.android.sdk.g.c(this.getContext());
         this.getVastConnManager().a(var1, var2, var5);
         return;
      } catch (IOException var6) {
         var3 = var6;
      } catch (NetworkErrorException var7) {
         var3 = var7;
      } catch (Exception var8) {
         this.failedToLoadAd(this.getVastConnManager(), ADFErrorCode.GENERIC_SDK_ERROR, var8.getMessage(), (ArrayList)null);
         com.noqoush.adfalcon.android.sdk.util.a.a(var8);
         return;
      }

      this.failedToLoadAd(this.getVastConnManager(), ADFErrorCode.COMMUNICATION_ERROR, "Please check your internet connection", (ArrayList)null);
      com.noqoush.adfalcon.android.sdk.util.a.a((Exception)var3);
   }

   public void setContext(Context var1) {
      this.d = var1;
   }

   public void setVastConnManager(d var1) {
      this.a = var1;
   }

   public void setVastPlayer(com.noqoush.adfalcon.android.sdk.video.vast.player.h var1) {
      this.b = var1;
      var1.setVastControllerListener(this);
   }

   public void setVastResponse(p var1) {
      this.c = var1;
   }

   public void show(Activity var1) {
      try {
         if (com.noqoush.adfalcon.android.sdk.util.d.f(var1)) {
            ADFActivity.b = new a(this);
            var1.startActivity(new Intent(var1, ADFActivity.class));
         } else {
            this.onFailedToPresent(this.getVastConnManager(), ADFErrorCode.COMMUNICATION_ERROR, "No internet connection is available, so the rewarded video ad will not be shown");
         }
      } catch (Exception var3) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var3);
         this.onFailedToPresent(this.getVastConnManager(), ADFErrorCode.GENERIC_SDK_ERROR, var3.getMessage());
      }
   }

   public boolean willWrapAd(d var1) {
      return true;
   }
}
