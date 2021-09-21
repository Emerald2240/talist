package com.noqoush.adfalcon.android.sdk.nativead;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.noqoush.adfalcon.android.sdk.ADFTargetingParams;
import com.noqoush.adfalcon.android.sdk.w;
import com.noqoush.adfalcon.android.sdk.constant.ADFErrorCode;
import com.noqoush.adfalcon.android.sdk.handler.b;
import com.noqoush.adfalcon.android.sdk.nativead.assets.ADFAssetsBinder;
import com.noqoush.adfalcon.android.sdk.response.k;
import com.noqoush.adfalcon.android.sdk.util.d;
import com.noqoush.adfalcon.android.sdk.viewability.c;

public class ADFNativeAd extends c {
   private com.noqoush.adfalcon.android.sdk.nativead.data.a d;
   private com.noqoush.adfalcon.android.sdk.nativead.mngr.a e;

   public ADFNativeAd(Activity var1) {
      super(var1);
      this.c();
   }

   public ADFNativeAd(Activity var1, AttributeSet var2) {
      super(var1, var2);
      this.c();
   }

   public ADFNativeAd(Activity var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.c();
   }

   private void c() {
      try {
         this.setAdContext(new com.noqoush.adfalcon.android.sdk.nativead.data.a());
         this.getAdContext().a(com.noqoush.adfalcon.android.sdk.util.d.c(this.getContext()));
         com.noqoush.adfalcon.android.sdk.util.d.b(this.getContext());
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }
   }

   private com.noqoush.adfalcon.android.sdk.nativead.data.a getAdContext() {
      return this.d;
   }

   private void setAdContext(com.noqoush.adfalcon.android.sdk.nativead.data.a var1) {
      this.d = var1;
   }

   void a() {
      try {
         if (this.getAdContext() != null && this.getAdContext().d() == ADFNativeAdStatus.loaded && this.getAdContext().l() != null && this.getAdContext().l().c()) {
            com.noqoush.adfalcon.android.sdk.util.a.e("getAdContext().getVisibilityHandler().interrupt()");
            this.getAdContext().l().interrupt();
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   void b() {
      try {
         if (this.getAdContext().d() == ADFNativeAdStatus.loaded) {
            if (this.getAdContext().l() == null || !this.getAdContext().l().c()) {
               this.getAdContext().a(new com.noqoush.adfalcon.android.sdk.handler.d(new b() {
                  public void a(ADFNativeAdStatus var1) {
                     try {
                        ADFNativeAd.this.getAdContext().a(var1, (String)null, (ADFErrorCode)null);
                     } catch (Exception var3) {
                        com.noqoush.adfalcon.android.sdk.util.a.a(var3);
                     }
                  }

                  public void a(w.e var1) {
                  }

                  public boolean a() {
                     return true;
                  }

                  public k b() {
                     return ADFNativeAd.this.getAdContext().i();
                  }

                  public a c() {
                     return ADFNativeAd.this.getAdContext().c();
                  }

                  public Context d() {
                     return ADFNativeAd.this.getAdContext().b();
                  }

                  public boolean e() {
                     return false;
                  }

                  public View f() {
                     return ADFNativeAd.this.getAdContext().h();
                  }
               }));
            }

            if (!this.getAdContext().l().c()) {
               this.getAdContext().l().start();
               com.noqoush.adfalcon.android.sdk.util.a.e("getAdContext().getVisibilityHandler().start()");
               return;
            }
         } else if (this.getAdContext().d() == ADFNativeAdStatus.clicked && this.getAdContext().c() != null && this.getAdContext().c().g()) {
            this.getAdContext().c().a();
            this.getAdContext().c().a(false);
            return;
         }
      } catch (Exception var2) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var2);
      }

   }

   public void destroy() {
      com.noqoush.adfalcon.android.sdk.nativead.mngr.a var1 = this.e;
      if (var1 != null) {
         var1.a((com.noqoush.adfalcon.android.sdk.nativead.data.a)null);
         if (this.e.f()) {
            this.e.c();
         }
      }

      this.getAdContext().a();
      com.noqoush.adfalcon.android.sdk.util.a.a("Native ad was disposed");
   }

   public ADFErrorCode getErrorCode() {
      return this.getAdContext().f();
   }

   public String getErrorMessage() {
      return this.getAdContext().g();
   }

   public ADFNativeAdListener getListener() {
      return this.getAdContext().c() == null ? null : this.getAdContext().c().f();
   }

   public ADFNativeAdStatus getStatus() {
      return this.getAdContext().d();
   }

   public boolean isLogging() {
      return com.noqoush.adfalcon.android.sdk.util.a.a;
   }

   public boolean isTesting() {
      return this.getAdContext().n();
   }

   public void loadAd(String var1, ADFTargetingParams var2, ADFAssetsBinder var3) {
      Exception var10000;
      label52: {
         boolean var10001;
         label55: {
            try {
               this.getAdContext().a(this);
               if (var1.length() != 32) {
                  break label55;
               }
            } catch (Exception var12) {
               var10000 = var12;
               var10001 = false;
               break label52;
            }

            if (var3 == null) {
               try {
                  throw new Exception("Invalid binder, binder shoud not be null");
               } catch (Exception var9) {
                  var10000 = var9;
                  var10001 = false;
                  break label52;
               }
            }

            try {
               if (this.getAdContext().d() == ADFNativeAdStatus.loading) {
                  com.noqoush.adfalcon.android.sdk.util.a.e("The SDK is still loading new ad");
                  return;
               }
            } catch (Exception var11) {
               var10000 = var11;
               var10001 = false;
               break label52;
            }

            try {
               this.getAdContext().a(var1);
               this.getAdContext().a(var2);
               this.getAdContext().a(var3);
               com.noqoush.adfalcon.android.sdk.nativead.mngr.a var6 = new com.noqoush.adfalcon.android.sdk.nativead.mngr.a(this.getAdContext());
               this.e = var6;
               var6.d();
               return;
            } catch (Exception var8) {
               var10000 = var8;
               var10001 = false;
               break label52;
            }
         }

         try {
            com.noqoush.adfalcon.android.sdk.util.a.b("Invalid site ID");
            throw new Exception("Invalid site ID");
         } catch (Exception var10) {
            var10000 = var10;
            var10001 = false;
         }
      }

      Exception var4 = var10000;

      try {
         this.d.a(ADFNativeAdStatus.failed, var4.getMessage(), ADFErrorCode.COMMUNICATION_ERROR);
      } catch (Exception var7) {
         com.noqoush.adfalcon.android.sdk.util.a.a(var7);
      }

      com.noqoush.adfalcon.android.sdk.util.a.a(var4);
   }

   protected void onAttachedToWindow() {
      this.b();
      super.onAttachedToWindow();
   }

   protected void onDetachedFromWindow() {
      this.a();
      super.onDetachedFromWindow();
   }

   protected void onVisibilityChanged(View var1, int var2) {
      if (var2 == 0) {
         this.b();
      } else {
         this.a();
      }

      super.onVisibilityChanged(var1, var2);
   }

   protected void onWindowVisibilityChanged(int var1) {
      if (var1 == 0) {
         this.b();
      } else {
         this.a();
      }

      super.onWindowVisibilityChanged(var1);
   }

   public void setListener(ADFNativeAdListener var1) {
      this.getAdContext().a(new a(this, var1));
   }

   public void setLogging(boolean var1) {
      com.noqoush.adfalcon.android.sdk.util.a.a = var1;
   }

   public void setTesting(boolean var1) {
      this.getAdContext().b(var1);
   }
}
